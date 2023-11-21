<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX3</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#buttonSubmit").click(function() {
			$.ajax({
				url : './ajaxServer3.jsp',
				type : 'post',
				data : $("#writeFrm").serialize(), // 여러 개의 데이터를 전송해야 할 때, 하나하나 작성할 필요 없이 객체 형식으로 한 번에 넘겨줌
				dataType : 'json',
				success : function(data) {
					$("#result_name").text(data.name);
					$("#result_ph_number").text(data.ph_number);
					$("#result_address").text(data.address);
				}
			});
		});
	});
</script>
</head>
<body>
	<form id="writeFrm">
		<table border="1" width="60%">
			<tr>
				<th>이름</th>
				<td><input type="text" id="name" name="name"></td>
			</tr>
			<tr>
				<th>번호</th>
				<td><input type="text" id="ph_number" name="ph_number"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" id="address" name="address"></td>
			</tr>
		</table>
		<input id="buttonSubmit" type="button" value="제출" />
	</form>
	<table border="1" width="60%">
		<tr>
			<th>[확인] 이름</th>
			<td style="width: 200px;"><span id="result_name"></span></td>
		</tr>
		<tr>
			<th>[확인] 번호</th>
			<td><span id="result_ph_number"></span></td>
		</tr>
		<th>[확인] 주소</th>
		<td><span id="result_address"></span></td>
	</table>
</body>
</html>