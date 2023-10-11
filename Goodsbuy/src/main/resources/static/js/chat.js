var stompClient = null;

function connect() {
    var socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {

        stompClient.subscribe('/chat/sub/message', function (message) {
            showMessage(JSON.parse(message.body));
        });

        stompClient.subscribe(`/chat/sub/${roomId}`, function (message) {
            showMessage(JSON.parse(message.body));
        });


    });
}

function showMessage(message) {

    var messageHtml = '<li class="you">';
    messageHtml += '<div class="entete">';
    messageHtml += '<span class="status green"></span>';
    messageHtml += '<h2>' + message.sender + '</h2>';
    messageHtml += '<h3>' + new Date().toLocaleTimeString() + '</h3>'; // 현재 시간 표시
    messageHtml += '</div>';
    messageHtml += '<div class="triangle"></div>';
    messageHtml += '<div class="message">';
    messageHtml += message.content;
    messageHtml += '</div>';
    messageHtml += '</li>';
    $("#chat").append(messageHtml);
}

function sendMessage() {

    var content = document.getElementById('content').value;


    var destination = `/pub/enter/roomId`;
    var messageContent = '안녕, 이 메시지를 보냅니다!';

// 메시지 보내기
    stompClient.send(destination, {}, JSON.stringify({content: messageContent}));

    var messageHtml = '<li class="me">';
    messageHtml += '<div class="entete">';
    messageHtml += '<h3>' + new Date().toLocaleTimeString() + '&nbsp</h3>'; // 현재 시간 표시
    messageHtml += '<h2>' + '내 닉네임' + '</h2>';
    messageHtml += '<span class="status blue"></span>';
    messageHtml += '</div>';
    messageHtml += '<div class="triangle"></div>';
    messageHtml += '<div class="message">';
    messageHtml += content;
    messageHtml += '</div>';
    messageHtml += '</li>';
    $("#chat").append(messageHtml);

}

$(function () {
    $("#send-button").on('click', function () {
        sendMessage(); // 메시지 전송 함수 호출
    });
    connect();
});