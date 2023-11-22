<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<html>
<head>
<meta charset="utf-8">
<title>광진구 약국</title>

</head>
<body>
	<!-- 지도를 표시할 div 입니다 -->
	<div id="map" style="width: 100%; height: 350px;"></div>
	
	<h1>광진구 약국 보기</h1>
	<table border="1">
		<tr>
			<td>약국 명칭</td>
			<td>약국소재지</td>
			<td>약국우편번호</td>
			<td>약국전화번호</td>
		</tr>
	</table>
	
	
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=?"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(37.49903, 127.0284), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		var map = new kakao.maps.Map(mapContainer, mapOption);

		let get_url = "https://api.odcloud.kr/api/15052413/v1/uddi:816ab9e3-dafe-4701-839b-c0c4d53adffe_201902261655?page=1&perPage=20&serviceKey=oFIDgsqEGA4%2BxjDNRbiCxoYtHyxes0KtUxZAOMyn6LmwQu94iBxo2fUxPzx98jIYaGw7oIlK2cDmEa11nCzeuA%3D%3D"
	
		
		$.getJSON(get_url, function(data){
			for(let i = 0; i < data.currentCount; i++){
				let txt ="<tr>"
				txt += "<td>" + data.data[i].약국명칭 + "</td>"
				txt += "<td>" + data.data[i]["약국소재지(도로명)"] + "</td>" // 괄호 오류가 있으므로 다른 방식으로 표현하기 
				txt += "<td>" + data.data[i].약국우편번호 + "</td>"
				txt += "<td>" + data.data[i].약국전화번호 + "</td>"
				txt+= "</tr>"
				
				$("table").append(txt);
			}
		});
	</script>
</body>
</html>