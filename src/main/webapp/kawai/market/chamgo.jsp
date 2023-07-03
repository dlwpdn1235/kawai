<%@page import="java.util.List"%>
<%@page import="com.kawai.dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
	<div class="container tmpt">
	  <h3>마켓</h3>
	  <br/><br/>
	  <div>
	  <div class="btn-group btn-group-lg">
	    <input type="button" class="btn btn-info division" value="상품" style="color:white;"/>
	    <input type="button" class="btn btn-info division" value="수업" style="color:white;"/>
	  </div>
	  <c:if test="${sessionScope.memberValue == 'expert'}">
	<div class="text-right">
	  <div class="dropdown dropright">
	    <button class="btn btn-info dropdown-toggle" type="button" id="categoryDropdown" style="color:white;" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      상품 / 수업 생성
	    </button>
		<div class="dropdown-menu dropdown-menu-right row" aria-labelledby="categoryDropdown">
		 <div class="col-sm-6"> <a class="dropdown-item" href="${pageContext.request.contextPath}/marketCreateForm.crud?mDivision=상품" >상품</a></div>
		  <div class="col-sm-6"><a class="dropdown-item" href="${pageContext.request.contextPath}/marketCreateForm.crud?mDivision=수업" >수업</a></div>
		</div>
	  </div>
	</div>
	  </c:if>
	  </div>


	  <br/><br/>
	  <div class="container">
	  	<div class="row">
	    	<div class="col-sm-2">
				<div class="btn-group-vertical">
	    			<input type="button" class="btn btn-default categorybtn" value="전체" />	
					<c:forEach var="category1" items="${mCategory}" varStatus="status">
						<input type="button" class="btn btn-default categorybtn"  value="${category1.category1_name}" data-category-id="${category1.category1_id}"/>
					</c:forEach>
				</div>
	      	</div>
	      	<div class="col-sm-10">
			<div class="well">
				<div class="row ajaxMarket text-center">
					<c:forEach var="dto" items="${mDtoList}" varStatus="status">
						<div class="col-sm-4">
							<a href="${pageContext.request.contextPath}/marketDetail.crud?market_id=${dto.market_id}"><img src="/images/${dto.images[0]}" alt="대표이미지" 
							class="img-thumbnail" style="width: 300px; height: 200px;"/></a>
							<p>${dto.category2_name}</p>
							<p><a href="${pageContext.request.contextPath}/marketDetail.crud?market_id=${dto.market_id}">${dto.title}</a></p>
							<p>${dto.price}</p>
						</div>
					</c:forEach>
				</div>
			</div>
	      	</div>
	    </div>
	  </div>
	  <div class="text-right">
	  <input type="button" class="btn btn-info" id="addContent" value = "더보기" style="color:white;"/>
	  </div>
	</div>
<script>
  var division = "상품";
  var category1_id = 0;
  var plus = 0;
  $(function(){
    $(".division").on("click", function(){
      division = $(this).val();  // division 값을 변경
		plus=0;
      $.ajax({
        url: "${pageContext.request.contextPath}/ajaxMarketRead.crud?mDivision=" + division,
        type: "get",
        dataType: "json",
        success: function(json){
          $(".ajaxMarket").empty();
          $.each(json, function(index, item){
            var image = item.images[0];
            var category2_name = item.category2_name;
            var title = item.title;
            var price = item.price;
            var market_id = item.market_id;
            var mimage = $("<a>").attr("href", "${pageContext.request.contextPath}/marketDetail.crud?market_id=" + market_id).html($("<img>").attr("src", "/images/" + image).attr("class","img-thumbnail").attr("alt","대표이미지")
            		.attr("style","width: 300px; height: 200px;"));
            var mtitle = $("<a>").attr("href", "${pageContext.request.contextPath}/marketDetail.crud?market_id=" + market_id).attr("title", title).html(title);

            mimage = $("<p>").append(mimage);
            mcategory2_name = $("<p>").append(category2_name);
            mtitle = $("<p>").append(mtitle);
            mprice = $("<p>").append(price);

            $(".ajaxMarket").append($("<div class='col-sm-4'>").append(mimage).append(mcategory2_name)
              .append(mtitle).append(mprice));
          });
        },
        error: function(xhr, textStatus, errorThrown){
          // AJAX 요청 실패 처리
        }
      });
    });
  });
  
  $(function(){
	    $(".categorybtn").on("click", function(){
	        category1_id = $(this).data("category-id");
			plus=0;
	        $.ajax({
	            url: "${pageContext.request.contextPath}/ajaxMarketRead.crud",
	            type: "get",
	            data: {
	                mDivision: division,
	                category1_id: category1_id
	            },
	            dataType: "json",
	            success: function(json){
	                $(".ajaxMarket").empty();
	                $.each(json, function(index, item){
	                    var image = item.images[0];
	                    var category2_name = item.category2_name;
	                    var title = item.title;
	                    var price = item.price;
	                    var market_id = item.market_id;
	                    var mimage = $("<a>").attr("href", "${pageContext.request.contextPath}/marketDetail.crud?market_id=" + market_id).html($("<img>").attr("src", "/images/" + image).attr("class","img-thumbnail").attr("alt","대표이미지")
	                    		.attr("style","width: 300px; height: 200px;"));
	                    var mtitle = $("<a>").attr("href", "${pageContext.request.contextPath}/marketDetail.crud?market_id=" + market_id).attr("title", title).html(title);

	                    mimage = $("<p>").append(mimage);
	                    mcategory2_name = $("<p>").append(category2_name);
	                    mtitle = $("<p>").append(mtitle);
	                    mprice = $("<p>").append(price);

	                    $(".ajaxMarket").append($("<div class='col-sm-4'>").append(mimage).append(mcategory2_name)
	                        .append(mtitle).append(mprice));
	                });
	            },
	            error: function(xhr, textStatus, errorThrown){
	                // AJAX 요청 실패 처리
	            }
	        });
	    });
	});
  
  $(function(){
	    $("#addContent").on("click", function(){
	    	plus = plus+9;
	        $.ajax({
	            url: "${pageContext.request.contextPath}/ajaxMarketRead.crud",
	            type: "get",
	            data: {
	                mDivision: division,
	                category1_id: category1_id,
	                market_count: plus
	            },
	            dataType: "json",
	            success: function(json){
	                $.each(json, function(index, item){
	                    var image = item.images[0];
	                    var category2_name = item.category2_name;
	                    var title = item.title;
	                    var price = item.price;
	                    var market_id = item.market_id;
	                    var mimage = $("<a>").attr("href", "${pageContext.request.contextPath}/marketDetail.crud?market_id=" + market_id).html($("<img>").attr("src", "/images/" + image).attr("class","img-thumbnail").attr("alt","대표이미지")
	                    		.attr("style","width: 300px; height: 200px;"));
	                    var mtitle = $("<a>").attr("href", "${pageContext.request.contextPath}/marketDetail.crud?market_id=" + market_id).attr("title", title).html(title);

	                    mimage = $("<p>").append(mimage);
	                    mcategory2_name = $("<p>").append(category2_name);
	                    mtitle = $("<p>").append(mtitle);
	                    mprice = $("<p>").append(price);

	                    $(".ajaxMarket").append($("<div class='col-sm-4'>").append(mimage).append(mcategory2_name)
	                        .append(mtitle).append(mprice));
	                });
	            },
	            error: function(xhr, textStatus, errorThrown){
	                // AJAX 요청 실패 처리
	            }
	        });
	    });
	});
  
</script>
<%@ include file="../inc/footer.jsp" %>