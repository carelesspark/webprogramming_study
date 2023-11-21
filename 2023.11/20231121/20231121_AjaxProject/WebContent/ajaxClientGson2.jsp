<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX5</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#dataload").click(function() {

			$.ajax({
				url : './ex02Gson',
				type : 'get',
				dataType : 'json',
				success : function(data) {
					$("#tbody").html("");
					for(let i = 0; i < data.length; i++){
						let table = '<tr>';
						table += '<td>' + data[i].email + '</td>';
						table += '<td>' + data[i].tel + '</td>';
						table += '<td>' + data[i].address + '</td>';
						table += '</tr>';
						$("#tbody").append(table);
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<button id="dataload">데이터 가져오기</button>
	<table border="1">
		<thead>
			<tr>
				<td>이메일</td>
				<td>전화번호</td>
				<td>주소</td>
			</tr>
		</thead>
		<tbody id="tbody">
			
		</tbody>
	</table>
</body>
</html>