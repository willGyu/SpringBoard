<%@page pageEncoding="UTF-8"%>

<!--1. 지시어 include : 컴파일 전에 소스코드 포함 -->
<%@ include file="include/header.jsp"%>

<!--2. 액션태그 include : 컴파일 후에 소스코드(페이지) 포함-->
<%-- <jsp:include page=""></jsp:include> --%>
<!-- home.jsp -->
<h1>Hello world!</h1>

<P>The time on the server is ${serverTime}.</P>
<hr>

<button type="button" class="btn btn-block btn-success bg-orange">Success</button>

<a class="btn btn-app"> <i class="fa fa-play"></i> Play
</a>

<hr>

<a class="btn btn-block btn-social btn-github">
<i class="fa fa-github"></i>
 Sign in with GitHub
</a>


<%@ include file="include/footer.jsp"%>

