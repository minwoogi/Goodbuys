var stompClient = null;

function setConnected(connected) {
    if (connected) {
        $("#chat-content").show();
    } else {
        $("#chat-content").hide();
    }
}

function connect() {
    var socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/chat/sub', function (message) {
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

function sendMessage(){

    var messageHtml = '<li class="me">';
    messageHtml += '<div class="entete">';
    messageHtml += '<span class="status blue"></span>';
    messageHtml += '<h2>' + '내 닉네임' + '</h2>';
    messageHtml += '<h3>' + new Date().toLocaleTimeString() + '</h3>'; // 현재 시간 표시
    messageHtml += '</div>';
    messageHtml += '<div class="triangle"></div>';
    messageHtml += '<div class="message">';
    messageHtml += message.content;
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