 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=75bc52b7e552dc0c2e818096144eaeeb"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script> 
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=75bc52b7e552dc0c2e818096144eaeeb&libraries=services,clusterer,drawing"></script>
<%@ include file="/kawai/inc/header.jsp" %>


<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<div class="map_container">
 	<h1>지도</h1>
		  <div class="row">
				    <div class="col-sm-4">
				    	
					      <div class="search-form">
					        <input type="text" class="evt-search-input" name="searchInput" placeholder="주소 또는 서점 이름 입력">
					        <a href="#none" onclick="searchLocation()" class="evt-search">검색</a>
					      </div>
					      <div class="address">
					        <strong>주소:</strong> <span class="evt-view-address"></span>
					      </div>
					      <c:if test="${role_id == 1}">
					      <div>
					        <a href="${pageContext.request.contextPath}/kawai/write.kawai">등록하기</a><br><br>
					      </div>
					     </c:if>
					      <!-- 													이미지 , bs_name ,  address_detail																		 -->
					      
					      <div class="row">
					      <div class="col-sm-6  text-center">
					      <c:forEach var="dto" items="${list}" varStatus="status">
					      	<c:if test="${status.index < 6}">
								          <img class="profile" alt="이미지"  style="width: 170px; border-radius: 40%;  padding-top:2px; padding-bottom: 0px; " 
								          			src="${pageContext.request.contextPath}/resources/upload/${dto.bfile}"; >
								          			<!--  src="https://image.bookshopmap.com/1600,fit,q60/venue/yourmind-cover.jpg";  -->
		          			</c:if>
						  </c:forEach>
						  </div>
						  
						  <div class="col-sm-6  a_psm6">
						  <c:forEach var="dto" items="${list}" varStatus="status">
						  <c:if test="${status.index < 6}" > 
				           <p class="p_sm6">
				           <a href="${pageContext.request.contextPath}/kawai/detail.kawai?bs_name=${dto.bs_name}">${dto.bs_name}</a>
				           </p>
				            <p>${dto.bs_address_detail}</p>
				            </c:if>
				            </c:forEach>
				           </div>
				           </div> 
					   </div>   
					    <div class="col-sm-8">
		      			<div class="evt-map" id="map" style="width:100%; height:400px;"></div>
		    			</div>
			   </div>   
</div>

<script>
function searchLocation() {
  var searchInput = $('.evt-search-input').val();
  if ($.trim(searchInput) === '') {
    alert('주소 또는 서점 이름을 입력해주세요.');
    return false;
  }

  // 주소 또는 서점 이름을 가져와서 검색
  var query = searchInput;

  $.ajax({
    url: 'https://dapi.kakao.com/v2/local/search/keyword.json',
    method: "get" ,
    headers: {
        'Authorization': 'KakaoAK f00f19411360e5f8d2eff4cd9335b9dc'
    } ,
    data: {
      query: query
    },
    success: function(response) {
      var documents = response.documents;
      if (documents.length > 0) {
        var firstResult = documents[0];
        var address = firstResult.address_name;
        var latitude = firstResult.y;
        var longitude = firstResult.x;

        $('.evt-view-address').text(address);
        $('.evt-view-lat').text(latitude);
        $('.evt-view-lng').text(longitude);
        $('.evt-view-name').text(searchInput); // 입력한 텍스트 표시


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
          content: '<div style="width:150px;text-align:center;padding:6px 0;">' + searchInput + '</div>'
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
}

$(document).ready(function() {
	  // 지도 초기화 설정
	  var mapContainer = document.getElementById('map');
	  var options = {
	    center: new kakao.maps.LatLng(37.395534, 127.108160),
	    level: 3 // 지도의 확대 레벨
	  };
	  var map = new kakao.maps.Map(mapContainer, options);
	});

$(document).ready(function() {
  $('.map-container').css({
    'display': 'flex',
    'justify-content': 'flex-end',
    'height': '0'
  });
  $('.evt-search-input').css({
    'width': '465px'
  });
  $('.evt-map').css({
    'width': '1100px',
    'height': '1100px'
  });
});
</script>
<%@ include file="/kawai/inc/footer.jsp" %>
    