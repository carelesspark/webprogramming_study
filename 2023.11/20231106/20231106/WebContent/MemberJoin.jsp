<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberJoin</title>
<script>
	function validateForm(form){ // 유효성 검사(각 항목들의 값 입력 유무 체크)
		if(!form.join_id.value){
			alert("생성할 아이디를 입력하세요.");
			form.join_id.focus();
			return false;
		}
		if(!form.join_pw.value){
			alert("생성할 비밀번호를 입력하세요.");
			form.join_pw.focus();
			return false;
		}
		if(!form.join_adr1.value){
			alert("지역주소를 입력해주세요.");
			form.join_adr1.focus();
			return false;
		}
		if(!form.join_adr2.value){
			alert("상세주소를 입력해주세요.");
			form.join_adr2.focus();
			return false;
		}
		if(!form.join_gender.value){
			alert("성별을 선택해주세요.");
			return false;
		}
		if(!(form.join_hobby[0].checked || form.join_hobby[1].checked || form.join_hobby[2].checked)){
			alert("취미를 선택해주세요.");
			return false;
		}
		if(!form.join_phon2.value){
			alert("전화번호를 입력해주세요.");
			form.join_phon2.focus();
			return false;
		}
		if(!form.join_phon3.value){
			alert("전화번호를 입력해주세요.");
			form.join_phon3.focus();
			return false;
		}
		if(!form.join_job.value){
			alert("직업을 선택해주세요.");
			return false;
		}
	}
</script>
</head>
<body>
	<form action="JoinProcess.jsp" onsubmit="return validateForm(this)">
		아이디 : <input type="text" name="join_id" /><br/>
		
		비밀번호 : <input type="password" name="join_pw" /><br/>
		
		주소 : <input type="text" name="join_adr1" /><br/>
			<input type="text" name="join_adr2" /><br/>
		성별 : <input type="radio" name="join_gender" value="m" />남자
			<input type="radio" name="join_gender" value="f" />여자<br/>
			
		취미 : <input type="checkbox" name="join_hobby" value="운동" /> 운동
			<input type="checkbox" name="join_hobby" value="음악감상" /> 음악감상
			<input type="checkbox" name="join_hobby" value="독서" /> 독서 <br/>
			
		연락처 : <input type="text" name="join_phon1" value="010" />-<input type="text" name="join_phon2" />-<input type="text" name="join_phon3" /><br/>
		직업 : <select name="join_job">
			<option value="">--선택--</option>
			<option value="학생">--학생--</option>
			<option value="교사">--교사--</option>
			<option value="직장인">--직장인--</option>
			<option value="의사">--의사--</option>
			</select><br/>
		자기소개 : <textarea row="5" col="20" name="join_introduce" placeholder="자기소개"></textarea><br/>
		<input type="submit" value="회원가입" /><input type="reset" value="취소" />
	</form>
</body>
</html>