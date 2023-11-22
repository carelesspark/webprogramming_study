<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>광진구 약국 마커표시</title>

</head>
<body>
	<p style="margin-top: -12px">
		<em class="link"> <a href="javascript:void(0);"
			onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
				혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요. </a>
		</em>
	</p>
	<div id="map" style="width: 100%; height: 350px;"></div>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=?&libraries=services"></script>
	<!-- 지도를 표시할 div 입니다 -->

	<h1>광진구 약국 보기</h1>
	<table border="1">
		<tr>
			<td>약국 명칭</td>
			<td>약국소재지</td>
			<td>약국우편번호</td>
			<td>약국전화번호</td>
		</tr>
	</table>

	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(37.49903, 127.0284), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption);

		let get_url = "https://api.odcloud.kr/api/15052413/v1/uddi:816ab9e3-dafe-4701-839b-c0c4d53adffe_201902261655?page=1&perPage=20&serviceKey=oFIDgsqEGA4%2BxjDNRbiCxoYtHyxes0KtUxZAOMyn6LmwQu94iBxo2fUxPzx98jIYaGw7oIlK2cDmEa11nCzeuA%3D%3D"

		$
				.getJSON(
						get_url,
						function(data) {

							let pharm = data.data;

							for (let i = 0; i < data.currentCount; i++) {
								let txt = "<tr>"
								txt += "<td>" + pharm[i].약국명칭 + "</td>"
								txt += "<td>" + pharm[i]["약국소재지(도로명)"]
										+ "</td>" // 괄호 오류가 있으므로 다른 방식으로 표현하기 
								txt += "<td>" + pharm[i].약국우편번호 + "</td>"
								txt += "<td>" + pharm[i].약국전화번호 + "</td>"
								txt += "</tr>"

								$("table").append(txt);
							}

							// 주소-좌표 변환 객체를 생성합니다
							var geocoder = new kakao.maps.services.Geocoder();

							for (let i = 0; i < data.currentCount; i++) { // 변경 내용
								// 주소로 좌표를 검색합니다
								geocoder
										.addressSearch(
												pharm[i]["약국소재지(도로명)"], // 변경 내용
												function(result, status) {

													// 정상적으로 검색이 완료됐으면 
													if (status === kakao.maps.services.Status.OK) {

														var coords = new kakao.maps.LatLng(
																result[0].y,
																result[0].x);

														// 결과값으로 받은 위치를 마커로 표시합니다
														var marker = new kakao.maps.Marker(
																{
																	map : map,
																	position : coords
																});

														// 인포윈도우로 장소에 대한 설명을 표시합니다
														var infowindow = new kakao.maps.InfoWindow(
																{
																	content : '<div style="width:150px;text-align:center;padding:6px 0;">'+ pharm[i].약국명칭 +'</div>' // 변경 내용
																});
														infowindow.open(map,
																marker);

														// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
														map.setCenter(coords);
													}
												});
							}
						}); // getJSON end
	</script>
</body>
</html>