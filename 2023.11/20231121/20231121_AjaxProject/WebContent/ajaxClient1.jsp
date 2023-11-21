<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#buttonSubmit").on("click", function() {
			$.ajax({
				url : './ajaxServer1.jsp', // 요청할 서버 url
				type : 'post', // 타입(get, post, put 등등)
				dataType : 'json', // 데이터 타입(html, xml, json, text 등등)
				success : function(data) { // 결과 성공 콜백함수
					$("#nickname").text(data.nickName);
					$("#ph_number").text(data.ph_number);
					$("#address").text(data.address);
				}
			});
		});
	});
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX1</title>
</head>
<body>
	<input id="buttonSubmit" type="button" value="제출" />
	<p id="nickname"></p>
	<p id="ph_number"></p>
	<p id="address"></p>
</body>
</html>
