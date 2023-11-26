<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>시작 페이지</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="./index0.css">
</head>
<body>
	<div style="height: 55px;">
		<nav class="navbar navbar-dark bg-dark fixed-top">
			<div class="container-fluid" id="top">
				<div>
					<a class="navbar-brand" href="#" style="font-size: 15px; padding-left:10px;">한세In Dream</a>
				</div>
				<div>
					<a class="navbar-brand" href="#" style="font-size: 15px; padding-left:20px;">한세대학교 메인 홈</a>
				</div>
				<div>
					<a class="navbar-brand" href="#" style="font-size: 15px; padding-left:20px;">한세대학교 포털</a>
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
							<li class="nav-item"><a class="nav-link" href="#">한세대학교 메인 홈</a></li>
							<li class="nav-item"><a class="nav-link" href="#">한세대학교 포털</a></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="#" role="button"
								data-bs-toggle="dropdown" aria-expanded="false"> 메뉴 </a>
								<ul class="dropdown-menu dropdown-menu-dark">
									<li><a class="dropdown-item" href="#">1</a></li>
									<li><a class="dropdown-item" href="#">2</a></li>
									<li>
										<hr class="dropdown-divider">
									</li>
									<li><a class="dropdown-item" href="#">3
											</a></li>
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
	<div id="div">
		<div id="div_left">
			<div id="carouselExampleDark" class="carousel carousel-dark slide"
				data-ts-ride="carousel">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="3" aria-label="Slide 4"></button>
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="4" aria-label="Slide 5"></button>
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="5" aria-label="Slide 6"></button>
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="6" aria-label="Slide 7"></button>
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="7" aria-label="Slide 8"></button>
				</div>
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
		<div id="div_right">
			<div id="login_top">
				<div id="login_text">
					<p id="login">LOGIN&nbsp;</p>
				</div>
				<div id="motto_text">
					<div id="motto1_text">
						<p id="motto1">New Dream,</p>
					</div>
					<div id="motto2_text">
						<p id="motto2">New Hansei</p>
					</div>
				</div>
			</div>
			<div id="login_middle">
				<div id="id_password">
					<form>
						<div class="row mb-3">
							<label for="inputID" class="col-sm-2 col-form-label">ID:</label>
							<div class="col-sm-10">
								<input type="ID" class="form-control" id="inputID" />
							</div>
						</div>
						<div class="row mb-3">
							<label for="inputPassword" class="col-sm-2 col-form-label">P/W:</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="inputPassword" />
							</div>
						</div>
						<div id="find_or_login">
							<div class="d-grid gap-2 col-6">
								<button class="btn btn-primary" type="button" id="b1">ID/PW
									찾기</button>
								<button class="btn btn-primary" type="button" id="b2">회원가입</button>
							</div>
							<button type="button" class="btn btn-outline-primary" id="b3" onclick="location.href = './main.jsp'">
								LOGIN</button>
						</div>

					</form>
				</div>
			</div>
			<div id="login_bottom">
				<p id="hansei-logo">
					<img src="./images/hansei_logo.png" width="300" />
				</p>
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