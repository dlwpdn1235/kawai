<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
	<div class="container tmpt">
			<h3>글쓰기</h3>
			<form action="${pageContext.request.contextPath}/community/commAdminInsert" method="POST">
			    <div class="form-group">
			    	<input type="hidden" name="comm_category_id" value="1" readonly/> 
			    	<input type="text" name="category_name" value="공지사항" readonly/> 
			    </div>	
				<div class="form-group">
				  <label for="community_title"  >제목</label>
				  <input type="text"   name="community_title"   id="community_title"   class="form-control" > 
				</div>																								
				<div class="form-group">
				  <label for="community_content"  >내용</label>
				  <textarea name="community_content"  cols="60"  rows="10"   class="form-control" ></textarea>
				</div>			
				<div class="form-group  text-right">
					<input type="submit"   value="글쓰기"  class="btn" id="commSubmit">  
				    <input type="reset"   onclick="history.go(-1);"    value="뒤로가기"  class="btn"    >  
				</div>	
			</form>
			<script>
			$(document).ready(function(){
				$("#commSubmit").on("click",function(){
				    if ($("#community_title").val() == "") {
					      alert("제목을 입력해야합니다.");
					      $("#community_title").focus();
					      return false;
					}
				    if ($("#community_content").val() == "") {
					      alert("내용을 입력해야합니다.");
					      $("#community_content").focus();
					      return false;
					}
				});
			});
			</script>
</div>                                                   
<%@ include file="../inc/footer.jsp" %>