<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>로드뷰 생성하기</title>

</head>
<body>
	<!-- 로드뷰를 표시할 div 입니다 -->
	<div id="roadview" style="width: 100%; height: 300px;"></div>

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
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=?&libraries=services"></script>
	<script>
	
			let get_url = "https://api.odcloud.kr/api/15052413/v1/uddi:816ab9e3-dafe-4701-839b-c0c4d53adffe_201902261655?page=1&perPage=20&serviceKey=oFIDgsqEGA4%2BxjDNRbiCxoYtHyxes0KtUxZAOMyn6LmwQu94iBxo2fUxPzx98jIYaGw7oIlK2cDmEa11nCzeuA%3D%3D"

			 		
				function clickAdd(address) {
			    var roadviewContainer = document.getElementById('roadview');
			    var roadview = new kakao.maps.Roadview(roadviewContainer);
			    var roadviewClient = new kakao.maps.RoadviewClient();

				console.log(address);
			    var geocoder = new kakao.maps.services.Geocoder();

			    
			    geocoder.addressSearch(address, function(result, status) {
			        if (status === kakao.maps.services.Status.OK) {
			            var position = new kakao.maps.LatLng(result[0].y, result[0].x);
			        }
			        roadviewClient.getNearestPanoId(position, 50, function(panoId) {
			            roadview.setPanoId(panoId, position);
			        });
			    });
			}

			$.getJSON(get_url, function(data) {
			    let pharm = data.data;

			    for (let i = 0; i < data.currentCount; i++) {
			        let txt = "<tr>"
			        txt += "<td>" + pharm[i].약국명칭 + "</td>"
			        txt += "<td><a href='javascript:void(0);' onclick='return clickAdd(\"" + pharm[i]["약국소재지(도로명)"] + "\");'>" 
			            + pharm[i]["약국소재지(도로명)"] + "</a></td>"
			        txt += "<td>" + pharm[i].약국우편번호 + "</td>"
			        txt += "<td>" + pharm[i].약국전화번호 + "</td>"
			        txt += "</tr>"

			        $("table").append(txt);
			    }
			});
			
			/* Uncaught SyntaxError: missing ) after argument list (at 오류 방지 위해 onclick 안에 \"와 "\ 같이 작성 */
		
	</script>
</body>
</html>