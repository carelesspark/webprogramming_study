<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginForm</title>
<script>
	function validateForm(form) {
		// document.loginForm.user_id.value; == form.user_id.value 
		// (form.user_id.value는  validateForm에 인수로 this를 주었을 때, validateForm에 매개변수를 넣어주었을 때 사용)

		// 숫자 : 0 -> false, 0 아니면 -> true
		// 문자 : "" -> false, ""가 아니면 -> true
		if (!form.user_id.value) {
			alert("아이디를 입력하세요");
			form.user_id.focus(); // alert창이 뜨고 다시 커서가 text태그 박스 안에 뜨게 해주는 기능
			return false;
		}

		if (form.user_pw.value == "") {
			alert("비밀번호를 입력하세요");
			form.user_pw.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<form action="LoginProcess.jsp" method="post" name="loginForm"
		onsubmit="return validateForm(this)">
		아이디 : <input type="text" name="user_id" /><br /> 패스워드 : <input
			type="password" name="user_pw" /><br /> <input type="submit"
			value="로그인하기" />
	</form>
</body>
</html>