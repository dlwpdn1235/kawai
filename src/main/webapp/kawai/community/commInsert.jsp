<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
	<div class="container tmpt">
			<h3>글쓰기</h3>
			<form action="${pageContext.request.contextPath}/community/commInsert" method="POST">
			    <div class="form-group">
			        <select class="categorys" name="comm_category_id">
			            <option value="2">책 리뷰</option>
			            <option value="3">책 추천</option>
			            <option value="4">자유게시판</option>
			        </select>
			    </div>	
				<div class="form-group">
				  <label for="community_title"  >제목</label>
				  <input type="text"   name="community_title"   id="community_title"   class="form-control" > 
				</div>																			
				<div class="form-group bookapi">
    				<label for="search"  >책 검색</label>
					<input type="search" name="search" id="search" class="form-control"/>
					<button type="button" id="searchbtn" class="btn btn-info btn-lg">검색</button>
				</div>
				<div class="form-group bookinfo">
					
				</div>					
				<div class="form-group">
				  <label for="community_content"  >내용</label>
				  <textarea name="community_content"  cols="60"  rows="10"   class="form-control" ></textarea>
				</div>			
				<div class="form-group  text-right">
					<input type="submit"   value="글쓰기"  class="btn" id="commSubmit">  
				    <input type="reset"   onclick="history.go(-1);"    value="취소"  class="btn"    >  
					<a href="${pageContext.request.contextPath}/board/list"   class="btn"   >목록보기</a>
				</div>	
			</form>
			  <!-- Modal -->
			  <div class="modal fade tmpt" id="myModal" role="dialog">
			    <div class="modal-dialog modal-lg">
			      <div class="modal-content">
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title">책 검색 리스트</h4>
			        </div>
			        <div class="modal-body">
			         <table class="table table-striped table-hover bookTableList">
					<thead>
						<tr>
							<th scope="col" class="text-center">선택</th>
							<th scope="col" class="text-center">제목</th>
							<th scope="col" class="text-center">이미지</th>
							<th scope="col" class="text-center">저자</th>
							<th scope="col" class="text-center">출판사</th>
							<th scope="col" class="text-center">날짜</th>
						</tr>
					</thead>
					<tbody class="text-center">
						
					</tbody>			
					</table>
					<div class="text-center">
			          <button type="button" class="btn btn-info" id="backBtn">이전</button>
			          <button type="button" class="btn btn-info" id="nextBtn">다음</button>
					</div>
			        </div>
			        <div class="modal-footer">
			          <button type="button" class="btn btn-info bookinfoSubmit" data-dismiss="modal">선택</button>
			          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
			        
			        </div>
			      </div>
			    </div>
			  </div>
			<script>
			$(document).ready(function(){
			var isSelect = false;
	        var bookinfo_title = "";
			var start_page = 1;
			var isFirst= true;
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
					if(!isSelect){
					      alert("책을 선택해야합니다.");
					      $("#search").focus();
					      return false;
					}
				});
				
			    $(".categorys").on("change", function () {
			        var selectedCategoryId = $(this).find(":selected").val();
			        if (selectedCategoryId == 4) {
			            $(".bookapi").hide();
			        } else {
			            $(".bookapi").show();
			        }
			    });
			
			    $("#searchbtn").on("click", function(){
			    	start_page = 1;
			        bookinfo_title = $("#search").val();
			        bookinfoList();
			    });
			    
			    $("#nextBtn").on("click", function(){
			        start_page = start_page + 10; // start_page 값을 10 증가
			    	bookinfoList();
			    });
			    
			    $("#backBtn").on("click", function(){
			    	if(start_page != 1){
			    		start_page = start_page-10;			    		
			    	}else{
			    		alert("제일 첫 페이지입니다.");
			    	}
			    	bookinfoList();
			    });
			    
			    function bookinfoList(){
			        $.ajax({
			            url: "${pageContext.request.contextPath}/community/commBookinfo/" + bookinfo_title + "/" + start_page,
			            type: "GET",
			            dataType: "json",
			            contentType: "application/json;charset=UTF-8",
			            error: function(xhr, status, msg) {
			                alert("책 제목을 입력하세요.");
			            },
			            success: function(json){
			                $(".bookTableList tbody").empty();
			                $.each(json.bookinfoList.items, function(idx, bookinfo){
			                    $("<tr>")
			                        .append($("<input type='radio' class='radios' name='radios'>"))
			                        .append($("<td>").html(bookinfo.title))
			                        .append($("<td>").append($("<img>").attr("src", bookinfo.image).attr("alt", bookinfo.title).attr("style", "width:100px;")))
			                        .append($("<td>").html(bookinfo.author))
			                        .append($("<td>").html(bookinfo.publisher))
			                        .append($("<td>").html(bookinfo.pubdate))
			                        .append($("<input type='hidden' class='hidden'>").val(bookinfo.description))
			                        .appendTo(".bookTableList tbody");
			                });
			                if(isFirst){
			                	$("#myModal").modal("show");
			                	isFirst=false;
			                }
			            }
			        });
			    }
			
			    $(".bookinfoSubmit").on("click", function() {
			        var selectedRadio = $(".bookTableList tbody input[type='radio']:checked");
			        if (selectedRadio.length > 0) {
			            var selectedRow = selectedRadio.closest("tr");
			            var title = selectedRow.find("td:nth-child(2)").text();
			            var image = selectedRow.find("td:nth-child(3) img").attr("src");
			            var author = selectedRow.find("td:nth-child(4)").html();
			            var publisher = selectedRow.find("td:nth-child(5)").html();
			            var pubdate = selectedRow.find("td:nth-child(6)").html();
			            var description = selectedRow.find(".hidden").val();
			
			            $(".bookinfo").empty();
			            $(".bookinfo")
			            	.append($("<label for='book_title'>책 제목</lable>"))
			                .append($("<input type='text' name='book_title' class='bookinfo_title form-control' readonly>").val(title))
			            	.append($("<label for='book_image' >이미지</lable>"))
			                .append($("<input type='text' name='book_image' class='form-control' readonly>").val(image))
			            	.append($("<label for='book_author'>저자</lable>"))
			                .append($("<input type='text' name='book_author' class='form-control' readonly>").val(author))
			            	.append($("<label for='book_publisher'>퍼블리셔</lable>"))
			                .append($("<input type='text' name='book_publisher' class='form-control' readonly>").val(publisher))
			            	.append($("<label for='book_pubdate'>출간일</lable>"))
			                .append($("<input type='text' name='book_pubdate' class='form-control' readonly>").val(pubdate))
			            	.append($("<label for='book_description'>책 설명</lable>"))
			                .append($("<input type='text' name='book_description' class='form-control' readonly>").val(description));
			            // 다른 필요한 데이터도 필요한대로 추가할 수 있습니다.
			            isSelect = true;
			        } else {
			            // 선택된 라디오 버튼이 없을 때의 처리
			            alert("책을 선택해야합니다.");
			            isSelect = false;
			        }
			        
			    });
			});
			</script>
</div>                                                   
<%@ include file="../inc/footer.jsp" %>