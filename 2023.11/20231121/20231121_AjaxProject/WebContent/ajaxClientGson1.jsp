<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX4</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#check").click(function() {
			if ($("#userid").val() == 0) {
				$("#result").text('아이디를 입력하세요');
				return;
			}
			$.ajax({
				url : './ajaxServer2.jsp',
				type : 'post',
				data : {
					userid : $("#userid").val()
				},
				dataType : 'json',
				success : function(data) {
					$("#result").text(data.loginId + data.loginSuccess);
				}
			});
		});
	});
</script>
</head>
<body>
	<input type="text" id="userid" />
	<button type="button" id="check">Check</button>
	<p id="result"></p>
</body>
</html>