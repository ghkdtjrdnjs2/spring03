<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/main.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<!-- 뷰를 조합하자 include -->
	<div id="app">
		<header>
			<jsp:include page="/WEB-INF/view/include/header.jsp"></jsp:include>
		</header>
		<nav>
			<jsp:include page="/WEB-INF/view/include/nav.jsp"></jsp:include>
		</nav>
		<main>
			<aside>
				<jsp:include page="/WEB-INF/view/include/aside.jsp"></jsp:include>
			</aside>
			<section></section>
			<aside>
				<jsp:include page="/WEB-INF/view/include/aside.jsp"></jsp:include>
			</aside>
		</main>
		<footer>
			<jsp:include page="/WEB-INF/view/include/footer.jsp"></jsp:include>
		</footer>
	</div>
</body>
</html>