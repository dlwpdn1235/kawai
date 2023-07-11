 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=75bc52b7e552dc0c2e818096144eaeeb"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script> 
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=75bc52b7e552dc0c2e818096144eaeeb&libraries=services,clusterer,drawing"></script>
<%@ include file="/kawai/inc/header.jsp" %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container map_container" id="bs_write_div">
<div class="row">
	<div class="col-sm-4">
		<p class="likes_hearts"><a class="btn btn-info"  href="javascript:history.go(-1)"> 뒤로</a>
		<span class="check_like">
		<img class="heart_check" src="${pageContext.request.contextPath}/kawai/img/marketLikeUnCheck.jpg" alt="하트">
			좋아요
		</span>
		</p>
		<div>
		<h4>${name.bs_name}</h4> 
		</div>
		<!-- src="https://image.bookshopmap.com/1600,fit,q60/venue/yourmind-cover.jpg"; -->
		<img src="${pageContext.request.contextPath}/resources/upload/${name.bfile}" 
		 class="img_size" alt="${name.bfile}">
		<div>
			<div class="row">
				<div class="col-sm-3">
					<p class="td_width">소개</p>
				</div>
				<div class="col-sm-9">
				<p> ${name.bs_content} </p>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-3">
					<p class="tag_unerline">활동</p>
				</div>
				<div class="col-sm-9">
				<c:forEach items="${name.tagNames}" var="tagName">
					     ${tagName}&ensp;
				        </c:forEach>
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-sm-3">
					<p class="3spel">개점일</p>
				</div>
				<div class="col-sm-9">
					 <p>${name.bs_opendate}</p>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-3">
					<p class="td_width">주소</p>
				</div>
				<div class="col-sm-9">
				<p> ${name.bs_address_detail} </p>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-3">
					<p class="3spel">운영시간</p>
				</div>
				<div class="col-sm-9">
				<p> ${name.bs_start_time} ~ ${name.bs_end_time} </p>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-3">
					<p >휴무일</p>
				</div>
				<div class="col-sm-9">
				<p> ${name.bs_closeday} </p>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-3">
					<p >전화</p>
				</div>
				<div class="col-sm-9">
				<p> ${name.bs_phonenum} </p>
				</div>
			</div>
			
		</div>
	</div>
	<div class="col-sm-8">
		<div class="evt-map" id="map" style="width:10%; height:400px;"></div>
	</div>	
</div>
</div>

<%@ include file="/kawai/inc/footer.jsp" %>
<style>
span.check_like {
    float: right;
}
img.heart_check {
    width: 28px;
}
p.likes_hearts {
	margin: 0px;
}
img.img_class {
    width: 360px;
    height: 440px;
}
table.table_width{
	width: 360px;
    height: 440px;
    
}
table.table_width th {
    padding: 6px;
    font-size: 13px;
    text-align: right;
}
table.table_width td{
	 padding: 6px;
    font-size: 13px;
}
img.img_size {
    width: 368px;
    height: 430px;
}
@media (min-width: 768px)
.col-sm-12 {
    width: 115%;
    padding: 0px;
}
td.tag_unerline {
    text-decoration: underline;
}
</style>

<script>
  $(document).ready(function() {
    var address = "${name.bs_address}";

    // 주소를 가져와서 검색
    var query = address;

    $.ajax({
      url: 'https://dapi.kakao.com/v2/local/search/keyword.json',
      headers: {
        'Authorization': 'KakaoAK f00f19411360e5f8d2eff4cd9335b9dc'
      },
      data: {
        query: query
      },
      success: function(response) {
        var documents = response.documents;
        if (documents.length > 0) {
          var firstResult = documents[0];
          var latitude = firstResult.y;
          var longitude = firstResult.x;

          var container = document.getElementById('map');
          var options = {
            center: new kakao.maps.LatLng(latitude, longitude),
            level: 4
          };
          var map = new kakao.maps.Map(container, options);

          var marker = new kakao.maps.Marker({
            position: new kakao.maps.LatLng(latitude, longitude),
            map: map
          });

          // 인포윈도우로 텍스트 표시
          var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">' + address + '</div>'
          });
          infowindow.open(map, marker);
        } else {
          alert('검색 결과가 없습니다.');
        }
      },
      error: function() {
        alert('주소 또는 서점 검색에 실패하였습니다.');
      }
    });

    var bs_no = '${name.bs_no}';

    $('.heart_check').click(function() {
      var image = $(this);
      var span = image.parent();
      var button = span.find('.heart_check');

      if (image.attr('src').includes('marketLikeUnCheck.jpg')) {
        $.ajax({
          url: '${pageContext.request.contextPath}/kawai/add',
          method: 'POST',
          data: {
            fk_id: 'user001',
            fk_bs_no: bs_no
          },
          success: function(response) {
            console.log('Success:', response);
            image.attr('src', '${pageContext.request.contextPath}/kawai/img/marketLikeCheck.jpg');
            button.text('좋아요 취소');
          },
          error: function(error) {
            console.log('Error:', error);
          }
        });
      } else if (image.attr('src').includes('marketLikeCheck.jpg')) {
        $.ajax({
          url: '${pageContext.request.contextPath}/kawai/remove',
          method: 'POST',
          data: {
            fk_id: 'user001',
            fk_bs_no: bs_no
          },
          success: function(response) {
            console.log('Success:', response);
            image.attr('src', '${pageContext.request.contextPath}/kawai/img/marketLikeUnCheck.jpg');
            button.text('좋아요');
          },
          error: function(error) {
            console.log('Error:', error);
          }
        });
      }
    });

    $('.map-container').css({
      'display': 'flex',
      'justify-content': 'flex-end',
      'height': '0'
    });
    $('.evt-search-input').css({
      'width': '250px'
    });
    $('.evt-map').css({
      'width': '862px',
      'height': '577px'
    });
  });
</script>