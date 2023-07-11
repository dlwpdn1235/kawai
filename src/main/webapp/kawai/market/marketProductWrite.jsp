<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>
   <div class="container panel tmpt">
      <h3 class="panel-heading">상품등록</h3>   
      <div class="marketWrite-group">     

      <form action="${pageContext.request.contextPath}/market/marketProductInsert" method="post">    
		   <div class="marketWriteName marketWriteCon">
		   		<input type="text" class="form-control" placeholder="작성자" readOnly/>
		   </div>

		    <div class="marketWriteTitle marketWriteCon">
		   		제목:<input type="text" name="mTitle" class="form-control" placeholder="제목"/>
		   </div>
		   <div class="form-group bookapi">
    			<label for="search"  >책 검색</label>
				<input type="search" name="search" id="search" class="form-control"/>
				<button type="button" id="searchbtn" class="btn btn-info btn-lg">검색</button>
			</div>
			<div class="form-group bookinfo">
					
			</div>	
		   
		    <div class="marketWritePrice marketWriteCon">
		   		<input type="text" class="form-control" name="mPrice" placeholder="가격"/>
		   </div>
		   
		    <div class="marketWriteContent marketWriteCon">
		   		<textarea rows="4" cols="100" name="mContent" placeholder="내용" class="form-control"></textarea>
		   </div>
		   
		   <div class="marketWriteSubmit">
		   		<input type="submit" class="btn btn-info" value="등록완료"/>
		   		<input type="button" class="btn btn-danger" value="취소" onclick="cancle"/>
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
			        </div>
			        <div class="modal-footer">
			          <button type="button" class="btn btn-info bookinfoSubmit" data-dismiss="modal">선택</button>
			          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
			        </div>
			      </div>
			    </div>
			  </div>
		<script>
			$(function(){
			    $("#searchbtn").on("click", function(){
			        var bookinfo_title = $("#search").val();
			        $.ajax({
			            url: "${pageContext.request.contextPath}/community/commBookinfo/" + bookinfo_title,
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
			                $("#myModal").modal("show");
			            }
			        });
			    });
			
			    $(".bookinfoSubmit").on("click", function() {
			        var selectedRadio = $(".bookTableList tbody input[type='radio']:checked");
			        if (selectedRadio.length > 0) {
			            var selectedRow = selectedRadio.closest("tr");
			            var title = selectedRow.find("td:nth-child(2) a").text();
			            var image = selectedRow.find("td:nth-child(3) img").attr("src");
			            var author = selectedRow.find("td:nth-child(4)").html();
			            var publisher = selectedRow.find("td:nth-child(5)").html();
			            var pubdate = selectedRow.find("td:nth-child(6)").html();
			            var description = selectedRow.find(".hidden").val();
			
			            $(".bookinfo").empty();
			            $(".bookinfo")
			                .append($("<input type='hidden' name='book_title' class='bookinfo_title'>").val(title))
			                .append($("<input type='hidden' name='book_image'>").val(image))
			                .append($("<input type='hidden' name='book_author'>").val(author))
			                .append($("<input type='hidden' name='book_publisher'>").val(publisher))
			                .append($("<input type='hidden' name='book_pubdate'>").val(pubdate))
			                .append($("<input type='hidden' name='book_description'>").val(description));
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
</div>                        
<%@include file="../inc/footer.jsp" %>
<!-- 
   
 -->