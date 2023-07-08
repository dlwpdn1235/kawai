<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/header.jsp" %>
   <div class="container panel tmpt">
      <h3 class="panel-heading text-center">제목 : ${commRead.community_title}</h3>
      <div class="row">
      	<div class="col-sm-2 text-center">카테고리 : ${commRead.category_name}</div>
      	<div class="col-sm-2 text-center">날짜 : ${commRead.community_date}</div>
      	<div class="col-sm-2 text-center">아이디 : ${commRead.user_id}</div>
      	<div class="col-sm-3 text-center">조회 : ${commRead.community_hit}</div>
      	<div class="col-sm-3 text-center">추천 : ${commRead.communityLikeCnt}</div>
      </div>
      <br/><br/>
      <div class="row well" style="padding-left:150px">
      	<div class="col-sm-2"><img src="${commRead.bookinfo.book_image}" title="${commRead.bookinfo.book_title}사진" style="width: 400px; height: 400px;"/></div>
      	<div class="col-sm-4"></div>
      	<div class="col-sm-6">
      		<p>${commRead.bookinfo.book_title}   ${commRead.bookinfo.book_author}</p>
      		<p>${commRead.bookinfo.book_publisher}   ${commRead.bookinfo.book_pubdate}</p>
      		<p>${commRead.bookinfo.book_description}</p>
      	</div>
      </div>
      <div>
      	<textarea cols="60"  rows="10"   class="form-control" readonly>${commRead.community_content}</textarea>
      </div>
		<div class="text-center">
		   <label for="likebtn">${commRead.communityLikeCnt}</label>
		   <input type="button" class="likebtn" name="likebtn" data-islike="${commRead.like.checkLike ? '0' : '1'}"
		      value="${commRead.like.checkLike ? '좋아요 취소' : '좋아요'}" />
		</div>
      <div class="comment">
      	
      </div>
      <div class="">
      	<a href="" title="" class="btn btn-info">수정</a>
      	<a href="" title="" class="btn btn-danger">삭제</a>
      	<a href="" title="" class="btn">뒤로가기</a>
      </div>
	<script>
	   $(function(){
	      $(".likebtn").on("click", function(){
	         var checklike = false;
	         if($(this).data("islike") == "0"){
	            checklike = true;
	         }
	         var like = {
	            community_id: "${commRead.community_id}",
	            user_id: "user001",
	            checklike: checklike
	         };
	         $.ajax({
	            url: "${pageContext.request.contextPath}/community/commLike",
	            type: "POST",
	            data: JSON.stringify(like),
	            dataType: "json",
	            contentType: "application/json;charset=UTF-8",
	            error: function(xhr, status, msg) {
	               alert(status + "/" + msg);
	            },
	            success: function(json){
	               var commCheckLike = json.commCheckLike;
	               var checkLike = commCheckLike ? true : false;
	               if (checkLike) {
	                  $(".likebtn").val("좋아요 취소");
	               } else {
	                  $(".likebtn").val("좋아요");
	               }
	            }
	         });
	      });
	   });
	</script>                                                
   </div>
<%@ include file="../inc/footer.jsp" %>