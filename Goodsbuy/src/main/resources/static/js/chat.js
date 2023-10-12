var stompClient = null;


function connect(chatRoomNo, loginId) {
    setConnected = false;
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {

        sendEnterMessage(chatRoomNo, loginId);

        stompClient.subscribe('/sub/render/messages', function (message) { // 메세지 렌더링
            renderMessages(JSON.parse(message.body), loginId);
        });

        stompClient.subscribe('/sub/message', function (message) { // 메세지 전달받기
            showMessage(JSON.parse(message.body));
        });
    });
}


function renderMessages(messages, loginId) {

    for (var i = 0; i < messages.length; i++) {
        var message = messages[i];
        if (messages[i].senderId === loginId) { //내가 보낸 메세지이면
            sendMessageRender(messages[i].content, messages[i].createdDate, messages[i].senderNickname);
        } else {
            showMessage(messages[i].content, messages[i].createdDate, messages[i].senderNickname);
        }

    }
}

function sendMessageRender(message, time, nickname) { //처음 채팅방 입장시 메세지 렌더링

    let date = formattedDate(time);

    var messageHtml = '<li class="me">';
    messageHtml += '<div class="entete">';
    messageHtml += '<h3>' + date + '&nbsp</h3>'; // 현재 시간 표시
    messageHtml += '<h2>' + nickname + '</h2>';
    messageHtml += '<span class="status blue"></span>';
    messageHtml += '</div>';
    messageHtml += '<div class="triangle"></div>';
    messageHtml += '<div class="message">';
    messageHtml += message;
    messageHtml += '</div>';
    messageHtml += '</li>';
    $("#chat").append(messageHtml);

}


function showMessage(message, time, nickname) { //받는 메세지

    let date = formattedDate(time);

    var messageHtml = '<li class="you">';
    messageHtml += '<div class="entete">';
    messageHtml += '<span class="status green"></span>';
    messageHtml += '<h2>' + nickname + '</h2>';
    messageHtml += '<h3>' + '&nbsp' + date + '</h3>'; // 현재 시간 표시
    messageHtml += '</div>';
    messageHtml += '<div class="triangle"></div>';
    messageHtml += '<div class="message">';
    messageHtml += message;
    messageHtml += '</div>';
    messageHtml += '</li>';
    $("#chat").append(messageHtml);
}

function sendMessage(nickname) { //보내는 메세지

    var content = document.getElementById('content').value;

    var messageHtml = '<li class="me">';
    messageHtml += '<div class="entete">';
    messageHtml += '<h3>' + new Date().toLocaleTimeString() + '&nbsp</h3>'; // 현재 시간 표시
    messageHtml += '<h2>' + '임시 닉네임' + '</h2>';
    messageHtml += '<span class="status blue"></span>';
    messageHtml += '</div>';
    messageHtml += '<div class="triangle"></div>';
    messageHtml += '<div class="message">';
    messageHtml += content;
    messageHtml += '</div>';
    messageHtml += '</li>';
    $("#chat").append(messageHtml);

    var destination = '/pub/chat/' + chatRoomNo;


    stompClient.send(destination, {}, JSON.stringify({
        /*roomId: chatRoomNo,*/
        message: content
    }));


    $("textarea#content").val("");


}

$(function () {
    $("#send-button").on('click', function () {
        sendMessage(); // 메시지 전송 함수 호출


    });
});


function enterChatRoom(chatRoomNo, loginId) {
    if ($('#chatDots').css('display') !== 'none') {
        // chatDots 요소가 보이는 상태라면 삭제
        $('#chatDots').remove();
    }

    $.ajax({
        type: 'post',
        url: '/chat/render',
        data: JSON.stringify({roomId: chatRoomNo}),
        contentType: 'application/json',
        success(chatroom) {
            renderChatRoom(chatroom, loginId);
        },
        error(error) {
            console.error(error);
        }
    })

    connect(chatRoomNo, loginId);
}

function sendEnterMessage(chatRoomNo, loginId) {
    var destination = '/pub/enter/' + chatRoomNo;

    stompClient.send(destination, {}, JSON.stringify({
        /*roomId: chatRoomNo,*/
        memberId: loginId
    }));
}


function renderChatRoom(chatRoom, loginUserNo) {
    populateChatRoom(chatRoom, loginUserNo);

    if ($('#chatMessage')) {
        // chatMessage 요소가 존재하면 보이게 함
        $('#chatMessage').css("display", "block");
    }
}


function formattedDate(date) {

    var createdDate = new Date(date);
    var formattedDate = createdDate.toLocaleString('en-US',
        {year: 'numeric', month: '2-digit', day: '2-digit', hour: '2-digit', minute: '2-digit'});

    var parts = formattedDate.split(", "); // "10/11/2023, 07:33 PM"을 분할
    var dateParts = parts[0].split('/'); // "10/11/2023"을 분할
    var time = parts[1]; // "07:33 PM"

    formattedDate = dateParts[2] + '/' + dateParts[0] + '/' + dateParts[1] + ', ' + time;
    return formattedDate;
}

function populateChatRoom(chatroom, loginUserNo) {


    var headerElement = document.getElementById('messageHeader');
    var headerHTML = '';


    // 날자 포맷
    var date = formattedDate(chatroom.createdDate);

    if (loginUserNo === chatroom.userNo) {
        // 판매자인 경우
        headerHTML += '<img src="/multipartImg/profileImage/' + chatroom.purchaseProfileUrl + '" alt="" style="width: 55px; height: 55px">';
        headerHTML += '<div>';
        headerHTML += '<h2><a href="#" style="text-decoration: none; color: inherit;">' + chatroom.purchaseNickname + '</a></h2>';
        headerHTML += '<h3>' + date + '</h3>';
        headerHTML += '</div>';
    } else {
        // 판매자가 아닌 경우
        headerHTML += '<img src="/multipartImg/profileImage/' + chatroom.userProfileUrl + '" alt="" style="width: 55px; height: 55px">';
        headerHTML += '<div>';
        headerHTML += '<h2><a href="#" style="text-decoration: none; color: inherit;">' + chatroom.userNickname + '</a></h2>';
        headerHTML += '<h3>' + date + '</h3>';
        headerHTML += '</div>';
    }

    headerElement.innerHTML = headerHTML;

    // Chat 정보 설정
    var chatElement = document.querySelector('#chat');
    var chatHTML = '';

    chatHTML += '<div class="container pt-3">';
    chatHTML += '<div class="row ps-4 pb-1">';
    chatHTML += '<div class="col-auto">';
    chatHTML += '<div>';
    chatHTML += '<img src="/multipartImg/productImage/' + chatroom.productImageUrl + '" style="height: 55px; width: 55px">';
    chatHTML += '</div>';
    chatHTML += '</div>';
    chatHTML += '<div class="col">';
    chatHTML += '<div class="pt-1" id="productInfo">';
    chatHTML += '<a href="/product/' + chatroom.productNo + '" style="text-decoration: none; color: inherit;">' + chatroom.productName + '</a><br>';
    chatHTML += '<span>' + new Intl.NumberFormat('ko-KR').format(chatroom.productPrice) + '원</span>';
    chatHTML += '</div>';
    chatHTML += '</div>';
    chatHTML += '</div>';
    chatHTML += '<hr class="my-2">';
    chatHTML += '</div>';

    chatElement.innerHTML = chatHTML;
}

function exitChatRoom() {

    if ($('#chatMessage')) {
        // chatMessage 요소가 존재하면 보이게 함
        $('#chatMessage').css("display", "none");
    }
}