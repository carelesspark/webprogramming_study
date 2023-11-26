<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="./main.css">
</head>
<body>
	<div style="height: 55px;">
		<nav class="navbar navbar-dark bg-dark fixed-top">
			<div class="container-fluid" id="top">
				<div>
					<a class="navbar-brand" href="./index.jsp"
						style="font-size: 15px; padding-left: 10px;">한세In Dream</a>
				</div>
				<div>
					<ul class="navbar-nav me-auto mb-2 mb-lg-0" id="ul_grid">
						<li class="nav-item dropdown" id="li1"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown1"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								한세in </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown"
								id="navbarDropdown1">
								<li><a class="dropdown-item" href="#">전공in</a></li>
								<li><a class="dropdown-item" href="#">교양in</a></li>
								<li><a class="dropdown-item" href="#">학교in</a></li>
								<li><a class="dropdown-item" href="#">자유in</a></li>
							</ul></li>
						<li class="nav-item dropdown" id="li2"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown2"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								게시판 </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown"
								id="navbarDropdown2">
								<li><a class="dropdown-item" href="#">자유게시판</a></li>
								<li><a class="dropdown-item" href="#">건의게시판</a></li>
								<li><a class="dropdown-item" href="#">동아리 게시판</a></li>
								<li><a class="dropdown-item" href="#">공모전 게시판</a></li>
							</ul></li>
						<li class="nav-item dropdown" id="li3"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown3"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								우리 친해져요! </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown"
								id="navbarDropdown3">
								<li><a class="dropdown-item" href="#">동아리 친구</a></li>
								<li><a class="dropdown-item" href="#">운동 친구</a></li>
								<li><a class="dropdown-item" href="#">밥 친구</a></li>
								<li><a class="dropdown-item" href="#">게임 친구</a></li>
								<li><a class="dropdown-item" href="#">취미 소통</a></li>
							</ul></li>
						<li class="nav-item dropdown" id="li4"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown4"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								토론 </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown"
								id="navbarDropdown4">
								<li><a class="dropdown-item" href="#">교양토론</a></li>
								<li><a class="dropdown-item" href="#">전공토론</a></li>
								<li><a class="dropdown-item" href="#">일상토론</a></li>
								<li><a class="dropdown-item" href="#">MBTI토론</a></li>
							</ul></li>
					</ul>
				</div>
				<div>
					<a class="navbar-brand" href="#"
						style="font-size: 15px; padding-left: 20px;">한세대학교 메인 홈</a>
				</div>
				<div>
					<a class="navbar-brand" href="#"
						style="font-size: 15px; padding-left: 20px;">한세대학교 포털</a>
				</div>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar"
					aria-controls="offcanvasDarkNavbar">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1"
					id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
					<div class="offcanvas-header">
						<h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">한세대학교
							커뮤니티 한세In Dream</h5>
						<button type="button" class="btn-close btn-close-white"
							data-bs-dismiss="offcanvas" aria-label="Close"></button>
					</div>
					<div class="offcanvas-body">
						<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="#">메인페이지</a></li>
							<li class="nav-item"><a class="nav-link" href="#">한세대학교
									메인 홈</a></li>
							<li class="nav-item"><a class="nav-link" href="#">한세대학교
									포털</a></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="#" role="button"
								data-bs-toggle="dropdown" aria-expanded="false"> 메뉴 </a>
								<ul class="dropdown-menu dropdown-menu-dark">
									<li><a class="dropdown-item" href="#">1</a></li>
									<li><a class="dropdown-item" href="#">2</a></li>
									<li>
										<hr class="dropdown-divider">
									</li>
									<li><a class="dropdown-item" href="#">3 </a></li>
								</ul></li>
						</ul>
						<form class="d-flex mt-3" role="search">
							<input class="form-control me-2" type="search"
								placeholder="Search" aria-label="Search">
							<button class="btn btn-success" type="submit">검색</button>
						</form>
					</div>
				</div>
			</div>
		</nav>
	</div>
	<div id="main1">
		<div id="main_content">
			<div id="content_box">
				<div id="content_box_1">게시판</div>
				<div id="content_box_2">
					<div id="content_box_2_1">
						자유게시판<a href="#" id="content_box_a">내용1</a>
					</div>
					<div id="content_box_2_2">
						건의게시판<a href="#" id="content_box_a">내용2</a>
					</div>
					<div id="content_box_2_2">
						동아리 게시판<a href="#" id="content_box_a">내용3</a>
					</div>
					<div id="content_box_2_2">
						공모전 게시판<a href="#" id="content_box_a">내용4</a>
					</div>
				</div>
			</div>
		</div>
		<div id="user_info">
			<div id="user_box">
				<div id="user_box_1">
					<img src="./images/major3.png" id="user_box_1_img" />
				</div>
				<div id="user_box_2">
					<p style="font-size: 13px; color: gray; margin: 0 auto;">학번 :
						202010102</p>
					<strong>박종혁님</strong>, 반갑습니다
				</div>
			</div>
			<div id="user_button">
				<button type="button" class="btn btn-outline-info" id="user_button1">회원정
					보수정</button>
				<button type="button" class="btn btn-outline-info" id="user_button1">로그아웃</button>
			</div>
		</div>
	</div>
	<div id="main2">
		<div id="div_left">
			<div id="notice">공지 홍보사항</div>
			<div id="carouselExampleDark" class="carousel carousel-dark slide"
				data-ts-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="./images/major1.png" class="d-block w-100" alt="major1" />
					</div>
					<div class="carousel-item">
						<img src="./images/major2.png" class="d-block w-100" alt="major2" />
					</div>
					<div class="carousel-item">
						<img src="./images/major3.png" class="d-block w-100" alt="major3" />
					</div>
					<div class="carousel-item">
						<img src="./images/major4.png" class="d-block w-100" alt="major4" />
					</div>
					<div class="carousel-item">
						<img src="./images/major5.png" class="d-block w-100" alt="major5" />
					</div>
					<div class="carousel-item">
						<img src="./images/major6.png" class="d-block w-100" alt="major6" />
					</div>
					<div class="carousel-item">
						<img src="./images/major7.png" class="d-block w-100" alt="major7" />
					</div>
					<div class="carousel-item">
						<img src="./images/major8.png" class="d-block w-100" alt="major8" />
					</div>
				</div>

				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleDark" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>


				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleDark" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>

			</div>
		</div>
		<div id="div_middle">
			<div id="notice">학교 행사(달력)</div>
			<div id="div_middle_content">
			
			</div>
		</div>
		<div id="div_right">
			<div id="notice">오늘의 학식 or 추천메뉴(날씨 기반)</div>
			<div id="div_right_content">
			
			</div>
		</div>
	</div>
	<footer class="py-5 bg-dark" id="footer">
		<div class="container">
			<p class="m-0 text-center text-white">© 2023 한세대학교 Copyright.</p>
		</div>
	</footer>
</body>
</html>