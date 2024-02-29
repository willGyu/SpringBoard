<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

viewUpdateStatus : ${viewUpdateStatus }
<div class="content">

	<h1>read.jsp</h1>
	<form role="form" action="" method="get" class="fm">
	   <input type="hidden" name="bno" value="${vo.bno }">
	</form>
	

	<div class="box box-primary">
		<div class="box-header with-border">
			<h3 class="box-title">게시판 본문내용</h3>
		</div>
		
			<div class="box-body">
				<div class="form-group">
					<label for="exampleInputEmail1">제 목</label> 
					<input type="text" class="form-control" 
					 name="title" id="exampleInputEmail1" 
					 value="${vo.title }" readonly>
				</div>

				<div class="form-group">
					<label>이 름</label>
					<input type="text" class="form-control" name="writer" 
					value="${vo.writer }" readonly>
				</div>

				<div class="form-group">
					<label>내 용</label>
					<textarea class="form-control" rows="3" 
					name="content" readonly>${vo.content }</textarea>
				</div>


			</div>

			<div class="box-footer">
				<button type="submit" class="btn btn-danger">수정하기</button>
				<button type="submit" class="btn btn-warning">삭제하기</button>
				<button type="submit" class="btn btn-success">목록이동</button>
			</div>
	</div>


</div>

<!-- JQuery 사용 -->
<!-- JQuery라이브러리 추가( include/header.jsp 파일에 추가되어있음 ) -->
<script>
	$(document).ready(function(){
		
		// bno를 저장하는 폼태그 정보
		//console.log( $("form[role='form']") );
		//console.log( $(".fm") );
		var formObj = $("form[role='form']");
		
		
		// '수정하기' 버튼 클릭시 
		$(".btn-danger").click(function(){
			alert(" 수정하기 버튼 클릭 ! ");
			formObj.attr("action","/board/modify");
			formObj.submit();			
		});
		
		// '삭제하기' 버튼 클릭시
		$('.btn-warning').click(function(){
			alert(" 삭제하기 버튼 클릭! ");
			formObj.attr("action","/board/remove");
			formObj.attr("method","post");
			formObj.submit();
		});
		
		
		
		
		//alert("Test");
		// '목록이동' 버튼 클릭시
		$(".btn-success").click(function(){
			alert(" '목록이동' 버튼 클릭! ");
			//목록으로 이동
			location.href="/board/list";
		});	
		
	});
</script>


<%@include file="../include/footer.jsp"%>
