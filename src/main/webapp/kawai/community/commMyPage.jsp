<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../inc/header.jsp" %>
	<div class="container panel tmpt">
	  <h3 class="panel-heading">게시글 마이페이지</h3>
	  <div class="">
	    <select class="btn selectOption">
			<option value="1" data-selectOption="1">내가 쓴글</option>
			<option value="2" data-selectOption="2">좋아요 누른 게시글</option>
	    </select>
	  </div>
	  <div class="communitys">
	    <table class="table table-striped table-hover">
	    <colgroup>
	        <col style="width:20%" >
	        <col style="width:50%" >
	        <col style="width:20%" >
	        <col style="width:10%" >
	    </colgroup>
	      <thead>
	        <tr>
	          <th scope="col">카테고리</th>
	          <th scope="col">제목</th>
	          <th scope="col">날짜</th>
	          <th scope="col">조회수</th>
	        </tr>
	      </thead>
	      <tbody class="myPageCommList">
	        <c:forEach var="comm" items="${commList}" varStatus="status">
	          <tr>
	            <td>${comm.category_name}</td>
	            <td><a href="${pageContext.request.contextPath}/community/commUpdateDetail?community_id=${comm.community_id}">${comm.community_title}</a></td>
	            <td>${comm.community_date}</td>
	            <td>${comm.community_hit}</td>
	          </tr>
	        </c:forEach>
	      </tbody>
	    </table>
	    <div class="text-right">
	    <input type="button" class="btn btn-info" id="plusPageBtn" value="더보기"/>
	    </div>
	  </div>
	  <script>
	    var plusPage = 0;
	    var option = 1;
	    $(function() {
	      $("#plusPageBtn").on("click", function() {
	        plusPage += 10;
	        option = $(".selectOption").find(":selected").attr("data-selectOption");
	        console.log(option);
	        if (option == "1") {
	          myCommunity();
	        } else if (option == "2") {
	          myLikeCommunity();
	        } else {
	          alert("관리자에게 문의하세요.");
	        }
	      });
	      function myCommunity() {
	        $.ajax({
	          url: "${pageContext.request.contextPath}/community/communityMyPageAdd/" + plusPage,
	          type: "GET",
	          dataType: "json",
	          contentType: "application/json;charset=UTF-8",
	          error: function(xhr, status, msg) {
	            alert("관리자에게 문의해주세요.");
	          },
	          success: function(json) {
	            $.each(json.commList, function(idx, comm) {
	              $(".myPageCommList")
	                .append($("<tr>")
	                  .append($("<td>").text(comm.category_name))
	                  .append($("<td>").html("<a href='${pageContext.request.contextPath}/community/commUpdateDetail?community_id="+comm.community_id+"'>"+comm.community_title+"</a>"))
	                  .append($("<td>").text(comm.community_date))
	                  .append($("<td>").text(comm.community_hit))
	                );
	            });
	          }
	        });
	      };
	      $(".selectOption").on("change", function() {
	        plusPage=0;
	        option = $(".selectOption").find(":selected").attr("data-selectOption");
	        console.log(option);
	        $(".myPageCommList").empty();
	        if (option == "1") {
	          myCommunity();
	        } else if (option == "2") {
	          myLikeCommunity();
	        } else {
	          alert("관리자에게 문의하세요.");
	        }
	      });
	      function myLikeCommunity() {
	        $.ajax({
	          url: "${pageContext.request.contextPath}/community/communityLikeMyPageAdd/" + plusPage,
	          type: "GET",
	          dataType: "json",
	          contentType: "application/json;charset=UTF-8",
	          error: function(xhr, status, msg) {
	            alert("관리자에게 문의해주세요.");
	          },
	          success: function(json) {
	            $.each(json.commList, function(idx, comm) {
	              $(".myPageCommList")
	                .append($("<tr>")
	                  .append($("<td>").text(comm.category_name))
	                  .append($("<td>").html("<a href='${pageContext.request.contextPath}/community/commUpdateDetail?community_id="+comm.community_id+"'>"+comm.community_title+"</a>"))
	                  .append($("<td>").text(comm.community_date))
	                  .append($("<td>").text(comm.community_hit))
	                );
	            });
	          }
	        });
	      };
	    });
	  </script>
	</div>
<%@ include file="../inc/footer.jsp" %>
