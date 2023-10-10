<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>goodsbuy</title>
    <link href="/css/alertChat2.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="/js/alertChat2.js"></script>
</head>
<button class="chatbox-open">
    <i class="fa fa-comment fa-2x" aria-hidden="true"></i>
</button>
<button class="chatbox-close">
    <i class="fa fa-close fa-2x" aria-hidden="true"></i>
</button>
<section class="chatbox-popup">
    <header class="chatbox-popup__header">
        <aside style="flex:3">
            <i class="fa fa-user-circle fa-4x chatbox-popup__avatar" aria-hidden="true"></i>
        </aside>
        <aside style="flex:8">
            <h1>닉네임</h1> 오전 09:40 (Online)
        </aside>
        <aside style="flex:1">
            <button class="chatbox-maximize"><i class="fa fa-window-maximize" aria-hidden="true"></i></button>
        </aside>
    </header>
    <main class="chatbox-popup__main">
        채팅 채팅<br>채팅채팅<br> 채팅채팅
    </main>
    <footer class="chatbox-popup__footer">
        <aside style="flex:1;color:#888;text-align:center;">
            <i class="fa fa-camera" aria-hidden="true"></i>
        </aside>
        <aside style="flex:10">
            <textarea type="text" placeholder="Type your message here..." autofocus></textarea>
        </aside>
        <aside style="flex:1;color:#888;text-align:center;">
            <i class="fa fa-paper-plane" aria-hidden="true"></i>
        </aside>
    </footer>
</section>
<section class="chatbox-panel">
    <header class="chatbox-panel__header">
        <aside style="flex:3">
            <i class="fa fa-user-circle fa-3x chatbox-popup__avatar" aria-hidden="true"></i>
        </aside>
        <aside style="flex:6">
            <h1>Sussanah Austin</h1> Agent (Online)
        </aside>
        <aside style="flex:3;text-align:right;">
            <button class="chatbox-minimize"><i class="fa fa-window-restore" aria-hidden="true"></i></button>
            <button class="chatbox-panel-close"><i class="fa fa-close" aria-hidden="true"></i></button>
        </aside>
    </header>
    <main class="chatbox-panel__main" style="flex:1">
        We make it simple and seamless for<br> bussiness and people to talk to each<br> other. Ask us anything.
    </main>
    <footer class="chatbox-panel__footer">
        <aside style="flex:1;color:#888;text-align:center;">
            <i class="fa fa-camera" aria-hidden="true"></i>
        </aside>
        <aside style="flex:10">
            <textarea type="text" placeholder="Type your message here..." autofocus></textarea>
        </aside>
        <aside style="flex:1;color:#888;text-align:center;">
            <i class="fa fa-paper-plane" aria-hidden="true"></i>
        </aside>
    </footer>
</section>