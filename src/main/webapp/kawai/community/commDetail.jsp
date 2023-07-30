<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/header.jsp" %>
<script>
var result = '${success}';   console.log( result  );
if(result =="fail"){ alert("관리자에게 문의하세요.");  history.go(-1); }
else if( result.length !=0 ){  alert(result);  }
</script>
<div class="container panel panel-default tmpt">
   <h3 class="panel-heading text-center">제목 : ${commRead.community_title}</h3>
   <div class="row">
      <div class="col-sm-2 text-center">카테고리 : ${commRead.category_name}</div>
      <div class="col-sm-2 text-center">날짜 : ${commRead.community_date}</div>
      <div class="col-sm-2 text-center">아이디 : ${commRead.user_id}</div>
      <div class="col-sm-3 text-center">조회 : ${commRead.community_hit}</div>
      <div class="col-sm-3 text-center likeCnt">추천 : ${commRead.communityLikeCnt}</div>
   </div>
   <br/><br/>
   <c:if test="${commRead.comm_category_id == 2 || commRead.comm_category_id == 3}">
   <div class="row well" style="padding-left:150px">
      <div class="col-sm-2"><img src="${commRead.bookinfo.book_image}" title="${commRead.bookinfo.book_title}사진" style="width: 400px; height: 400px;"/></div>
      <div class="col-sm-4"></div>
      <div class="col-sm-6">
         <p>${commRead.bookinfo.book_title}   ${commRead.bookinfo.book_author}</p>
         <p>${commRead.bookinfo.book_publisher}   ${commRead.bookinfo.book_pubdate}</p>
         <p>${commRead.bookinfo.book_description}</p>
      </div>
   </div>
   </c:if>
   <div>
      <textarea cols="60" rows="10" class="form-control" readonly>${commRead.community_content}</textarea>
   </div>
   <div class="text-center">
      <label for="likebtn" class="likeCnt">추천 : ${commRead.communityLikeCnt}</label>
      <c:if test="${sessionScope.role_id == 0}">
      <div class="likeBtnGroup">
         <input type="button" class="likebtn" name="likebtn" data-islike="${commRead.like.checkLike ? '0' : '1'}"
            value="${commRead.like.checkLike ? '좋아요 취소' : '좋아요'}" />
      </div>
      </c:if>
   </div>
   <div class="text-right">
   <c:if test="${sessionScope.account == commRead.user_id}">
      <a href="${pageContext.request.contextPath}/community/commUpdate?community_id=${commRead.community_id}" title="수정" class="btn btn-info">수정</a>
      <a href="${pageContext.request.contextPath}/community/commDelete?community_id=${commRead.community_id}" title="삭제" class="btn btn-danger">삭제</a>
   </c:if>
      <input type="reset"   onclick="history.go(-1);"    value="뒤로가기"  class="btn"    > 
   </div>
   <div class="">
   	<label for="commentWrite">댓글</label>
   	<textarea id="commentWrite" rows="10" cols="20" class="form-control "></textarea>
   	<div class="text-right">
   	      <c:if test="${sessionScope.role_id == 0}">
   		<input type="button" class="btn btn-info" id="commentInsert" value="서브밋"/>
   	      </c:if>
   	</div>
   </div>
   <div class="comments panel panel-default">
   </div>
   <script>
      $(function(){
         var user_id = '<%=user_id%>';
         var community_id = ${commRead.community_id};
         commentList();
         
         //대댓글 폼생성 시작
         $(document).on("click",".commCommentInBtn",function(){
        		var parentDiv = $(this).siblings(".commComment");// 클릭된 요소의 상위 요소인 div(panel-body)를 선택
        	    parentDiv.empty();
        		parentDiv.append("<label for='commCommentWrite'> ㄴ 대댓글</label>")
        	    .append("<textarea name='commCommentWrite' rows='10' cols='20' class='form-control commCommentWrite'></textarea>")
        	    .append("<div class='text-right'> <input type='button' class='btn btn-info commCommentInsert' value='서브밋'/> </div>");
         });
         //대댓글 폼생성 끝
         
         //대댓글 인서트
         $(document).on("click",".commCommentInsert",function(){
        	 var comment_btn = $(this);
        	 var parentDiv = comment_btn.closest(".commComment"); // 클릭된 요소의 상위 요소인 .commComment를 선택
        	 var comment = parentDiv.find(".commCommentWrite").val(); 
        	 var comment_id = comment_btn.closest(".panel-body").find(".hidden_no_id").val();
        	 var comment_group = comment_btn.closest(".panel-body").find(".hidden_no_group").val();
        	 var comment_step = comment_btn.closest(".panel-body").find(".hidden_no_step").val();
        	 var comment_indent = comment_btn.closest(".panel-body").find(".hidden_no_indent").val();
        	 var commComment = {
        		community_id: community_id,
        		comment_id: comment_id,
        		comment_group: comment_group,
        		comment_step: comment_step,
        		comment_indent: comment_indent,
        		comment : comment
        	 };
        	 console.log(commComment);
        	 $.ajax({
        	   url: "${pageContext.request.contextPath}/community/commreply",
  	           type: "POST",
  	           data: JSON.stringify(commComment),
  	           dataType: "json",
  	           contentType: "application/json;charset=UTF-8",
  	           error: function (xhr, status, msg) {
  	              alert("관리자에게 문의해주세요.");
  	           },
                 success: function (json) {
              	   if(json.result){
              		   alert("대댓글 입력했습니다.");
              	   }
                     commentList();
                  }
        	 });
         });
         //대댓글 인서트
         
         //수정 폼생성 시작
		$(document).on("click",".commentUpBtn",function(){
			var panelHeading = $(this).closest(".panel-body").prev(".panel-heading");
			var commentUp = panelHeading.text();
		    console.log(commentUp);
		    var parentDiv = $(this).siblings(".commComment");
		
		    parentDiv.empty();
		    parentDiv.append("<label for='commCommentWrite'>수정</label>")
		        .append("<textarea name='commCommentWrite' rows='10' cols='20' class='form-control commCommentWrite'>"+commentUp+"</textarea>")
		        .append("<div class='text-right'> <input type='button' class='btn btn-info commCommentUpdate' value='서브밋'/> </div>");
		});
         //수정 폼생성 끝
         //수정 
         $(document).on("click",".commCommentUpdate",function(){
        	 var comment_btn = $(this);
        	 var parentDiv = comment_btn.closest(".commComment"); // 클릭된 요소의 상위 요소인 .commComment를 선택
        	 var comment = parentDiv.find(".commCommentWrite").val(); 
        	 var comment_id = comment_btn.closest(".panel-body").find(".hidden_no_id").val();
        	 var commComment = {
        		community_id: community_id,
        		comment_id: comment_id,
        		comment : comment
        	 };
        	 $.ajax({
        	   url: "${pageContext.request.contextPath}/community/commentUpdate",
  	           type: "POST",
  	           data: JSON.stringify(commComment),
  	           dataType: "json",
  	           contentType: "application/json;charset=UTF-8",
  	           error: function (xhr, status, msg) {
  	              alert("관리자에게 문의해주세요.");
  	           },
                 success: function (json) {
              	   if(json.result){
              		   alert("수정에 완료하였습니다.");
              	   }
                     commentList();
                  }
        	 });
         });
         //수정
         
        //삭제
         $(document).on("click",".commentDeBtn",function(){
        	 var comment_btn = $(this);
        	 var comment = "삭제된 댓글입니다.";
        	 var comment_id = comment_btn.closest(".panel-body").find(".hidden_no_id").val();
        	 var commComment = {
        		community_id: community_id,
        		comment_id: comment_id,
        		comment : comment
        	 };
        	 $.ajax({
        	   url: "${pageContext.request.contextPath}/community/commentUpdate",
  	           type: "POST",
  	           data: JSON.stringify(commComment),
  	           dataType: "json",
  	           contentType: "application/json;charset=UTF-8",
  	           error: function (xhr, status, msg) {
  	              alert("관리자에게 문의해주세요.");
  	           },
                 success: function (json) {
              	   if(json.result){
              		   alert("삭제에 완료하였습니다.");
              	   }
                     commentList();
                  }
        	 });
         });
         //삭제
         
         // 커뮤니티 좋아요 ..................................
         $(document).on("click",".likebtn", function(){
            var dtoLike = {
               community_id: community_id,
               user_id: user_id,
               isLike: $(this).data("islike")
            };
            $.ajax({
               url: "${pageContext.request.contextPath}/community/commLike",
               type: "POST",
               data: JSON.stringify(dtoLike),
               dataType: "json",
               contentType: "application/json;charset=UTF-8",
               error: function(xhr, status, msg) {
                  alert("관리자에게 문의해주세요.");
               },
               success: function(json){
                  var commCheckLike = json.commCheckLike;
                  var buttonValue = commCheckLike ? "좋아요 취소" : "좋아요";
                  var buttonDataIsLike = commCheckLike ? "0" : "1";
                  $(".likeBtnGroup").empty();
                  <% if(role_id == 0){ %>
                  	$(".likeBtnGroup").append("<input type='button' class='likebtn' name='likebtn' data-islike='" + buttonDataIsLike + "' value='" + buttonValue + "' />");
                  <%}%>
                  $(".likeCnt").empty();
                  $(".likeCnt").html("추천 : " + json.commLikeCnt);
                  if(commCheckLike){
                     alert("좋아요를 눌렀습니다.");
                  }else{
                     alert("좋아요를 취소했습니다.");
                  }
               }
            });
         });
         // 커뮤니티 좋아요 .................................. 끝
         // 새로운 그룹 댓글쓰기 ...............................시작
		$("#commentInsert").on("click",function(){
			var commentDto = {
				community_id : community_id,
				comment : $("#commentWrite").val()	
			};
			console.log(commentDto);
			$.ajax({
	           url: "${pageContext.request.contextPath}/community/commentInsert",
	           type: "POST",
	           data: JSON.stringify(commentDto),
	           dataType: "json",
	           contentType: "application/json;charset=UTF-8",
	           error: function (xhr, status, msg) {
	              alert("관리자에게 문의해주세요.");
	           },
               success: function (json) {
            	   if(json.result){
            		   alert("댓글 입력했습니다.");
            	   }
            	   $("#commentWrite").val("");
                   commentList();
                }
			});
		});
         // 새로운 그룹 댓글쓰기 ...............................끝
         // 댓글 좋아요 ..................................
         $(document).on("click", ".commentLikeBtn", function () {
        	   var commentButton = $(this);
        	   var comment_id = commentButton.closest(".panel-body").find(".hidden_no_id").val();
        	   var dtoCommentLike = {
        	      comment_id: comment_id,
        	      user_id: user_id,
        	      isLike: commentButton.data("islike")
        	   };
            $.ajax({
               url: "${pageContext.request.contextPath}/community/commentLike",
               type: "POST",
               data: JSON.stringify(dtoCommentLike),
               dataType: "json",
               contentType: "application/json;charset=UTF-8",
               error: function (xhr, status, msg) {
                  alert("관리자에게 문의해주세요.");
               },
               success: function (json) {
                  var commentCheckLike = json.commentCheckLike;
                  var buttonValue = commentCheckLike ? "좋아요 취소" : "좋아요";
                  var buttonDataIsLike = commentCheckLike ? "0" : "1";
                  commentButton.data("islike", buttonDataIsLike);
                  commentButton.val(buttonValue);
                  if (commentCheckLike) {
                     alert("좋아요를 눌렀습니다.");
                  } else {
                     alert("좋아요를 취소했습니다.");
                  }
                  commentList();
               }
            });
         });
         // 댓글 좋아요 .................................. 끝
         // 댓글 시작.....................................
         function commentList() {
            $.ajax({
               url: "${pageContext.request.contextPath}/community/commentAllRead/" + community_id,
               type: "GET",
               dataType: "json",
               contentType: "application/json;charset=UTF-8",
               error: function (xhr, status, msg) {
                  alert("관리자에게 문의해주세요.");
               },
               success: commentListResult,
            });
         }
         function commentListResult(json) {
        	   $(".comments").empty();
        	   $.each(json.comment, function (idx, comment) {
        	      var indent = comment.comment_indent;
        	      var indenticon = "";
        	      if (indent != 0) {
        	         indenticon = " ㄴ ";
        	         indent = indent * 10;
        	      } else {
        	         indenticon = "";
        	         indent = 0;
        	      }
        	      indent = indent + "px";
        	      var panelHeading = $("<div class='panel-heading' style='margin-left: " + indent + "'>")
        	         .append(indenticon + comment.comment);
        	      var $panelBody = $("<div class='panel-body'>")
        	         .append($("<input type='hidden' class='hidden_no_id' value='" + comment.comment_id + "'>"))
        	         .append($("<input type='hidden' class='hidden_no_group' value='" + comment.comment_group + "'>"))
        	         .append($("<input type='hidden' class='hidden_no_step' value='" + comment.comment_step + "'>"))
        	         .append($("<input type='hidden' class='hidden_no_indent' value='" + comment.comment_indent + "'>"))
        	         .append("작성날짜 : " + comment.comment_date + " ")
        	         .append("작성자 : " + comment.user_id + " ");
				 <%if(role_id == 0){%>
        	      $panelBody.append(
        	         $("<input type='button' class='btn btn-info commCommentInBtn' value='답글'>")
        	      );
				<%} %>
        	      if (user_id == comment.user_id && comment.comment != '삭제된 댓글입니다.') {
        	         $panelBody
        	            .append(
        	               $("<input type='button' class='btn btn-info commentUpBtn' value='수정'>")
        	            )
        	            .append(
        	               $("<input type='button' class='btn btn-danger commentDeBtn' value='삭제'>")
        	            );
        	      }
        	      var likeBtns = $("<div class='likeBtns'>")
        	         .append("좋아요 : " + comment.commentLikeCnt);
        	      <%if(role_id == 0){%>
        	      if (comment.like.checkLike) {
        	         likeBtns.append($("<input type='button' class='btn btn-default commentLikeBtn' value='좋아요 취소' data-islike='0'>"));
        	      } else {
        	         likeBtns.append($("<input type='button' class='btn btn-default commentLikeBtn' value='좋아요' data-islike='1'>"));
        	      }
        	      <%} %>
        	      $panelBody.append(likeBtns);
        	      $panelBody.append("<div class='commComment'></div>");

        	      panelHeading.appendTo(".comments");
        	      $panelBody.appendTo(".comments");
        	   });
        	}
         // 댓글 시작.....................................
      });
   </script>
</div>
<%@ include file="../inc/footer.jsp" %>
