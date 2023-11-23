<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" />

<form action="./memberProcess.jsp" method="post">
	<div class="mb-3 mt-3">
		<label for="id" class="form-label">Id:</label> <input type="text"
			class="form-control" id="id" placeholder="Enter id" name="id">
	</div>
	<div class="mb-3 mt-3">
		<label for="name" class="form-label">Name:</label> <input type="text"
			class="form-control" id="name" placeholder="Enter name" name="name">
	</div>
	<div class="mb-3 mt-3">
		<label for="email" class="form-label">Email:</label> <input
			type="email" class="form-control" id="email"
			placeholder="Enter email" name="email">
	</div>
	<label for="comment">가입 인사:</label>
	<textarea class="form-control" rows="5" id="comment" name="comment"></textarea>
	<button type="submit" class="btn btn-primary">Submit</button>
</form>

</body>
</html>