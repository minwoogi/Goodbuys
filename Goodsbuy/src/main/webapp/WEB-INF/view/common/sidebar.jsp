<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<section class="app">
    <aside class="sidebar">
        <header>
            Menu
        </header>
        <nav class="sidebar-nav">
            <ul>
                <li>
                    <a href=""><i class="bi bi-person-circle"></i> <span>개인정보 수정</span></a>
                    <ul class="nav-flyout">
                        <li>
                            <a href="/profile"><i class="bi bi-pencil"></i>프로필 수정</a>
                        </li>
                        <li>
                            <a href="/profile/nickname"><i class="bi bi-file-person"></i>닉네임 변경</a>
                        </li>
                        <li>
                            <a href="/profile/email"><i class="bi bi-envelope"></i>이메일 등록 및 변경</a>
                        </li>
                        <li>
                            <a href="/profile/location"><i class="bi bi-geo-alt"></i>지역 설정</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="bi bi-chat-dots"></i> <span class="">채팅</span></a>
                </li>

                <li>
                    <a href="/dibs"><i class="bi bi-heart"></i> <span class="">관심목록</span></a>
                </li>


                <li>
                    <a href="/sales-items"><i class="bi bi-archive"></i> <span class="">판매중인 상품</span></a>
                </li>


                <li>
                    <a href="#"><i class="bi bi-clock-history"></i> <span class="">판,구매 내역</span></a>
                    <ul class="nav-flyout">
                        <li>
                            <a href="/sales-history"><i class="bi bi-receipt"></i>판매 내역</a>
                        </li>
                        <li>
                            <a href="/purchase-history"><i class="bi bi-bag-check"></i>구매 내역</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
    </aside>
</section>