<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp"%>

<%-- ${boardList.size() } --%>
<!-- listCri.jsp -->
viewUpdateStatus : ${viewUpdateStatus }
<hr>


cri : ${cri }<br>
pageVO : ${pageVO }<br>

<div class="content">

	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title">게시판 목록</h3>
		</div>

		<div class="box-body">
			<table class="table table-bordered">
				<tbody>
					<tr>
						<th style="width: 10px">bno</th>
						<th>title</th>
						<th>writer</th>
						<th style="width: 40px">viewcnt</th>
						<th>regdate</th>
					</tr>
					
					<c:forEach var="bVO" items="${boardList }">
						<tr>
							<td>${bVO.bno }</td>
							<td>
								<a href="/board/read?bno=${bVO.bno }&page=${cri.page}&pageSize=${cri.pageSize}">${bVO.title }</a>
							</td>
							<td>
								${bVO.writer }
							</td>
							<td><span class="badge bg-red">${bVO.viewcnt }</span></td>
							<td>
							   <fmt:formatDate value="${bVO.regdate }" pattern="yy.MM.dd"/> 
							</td>
						</tr>
					</c:forEach>
				
				</tbody>
			</table>
		</div>

		<div class="box-footer clearfix">
			<ul class="pagination pagination-sm no-margin pull-right">
				
				<c:if test="${pageVO.prev }">
					<li><a href="/board/listCri?page=${pageVO.startPage - 1 }">«</a></li>
				</c:if>
				
				<c:forEach var="idx" begin="${pageVO.startPage }" 
				           end="${pageVO.endPage }" step="1">
					<li ${pageVO.cri.page == idx? "class='active'":""}>
						<a href="/board/listCri?page=${idx }">${idx }</a>
					</li>
				</c:forEach>
				
				<c:if test="${pageVO.next }">
					<li><a href="/board/listCri?page=${pageVO.endPage + 1 }">»</a></li>
				</c:if>
				
			</ul>
		</div>
	</div>

</div>


<%@ include file="../include/footer.jsp"%>