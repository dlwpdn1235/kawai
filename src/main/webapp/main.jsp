<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=75bc52b7e552dc0c2e818096144eaeeb"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script> 
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=75bc52b7e552dc0c2e818096144eaeeb&libraries=services,clusterer,drawing"></script>
<%@ include file="/inc/header.jsp" %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<div>
</br>
</br>
</br>
  <h1>지도</h1>
  <div class="container_div1">
    <div class="search-form">
      <input type="text" class="evt-search-input" name="searchInput" value="" placeholder="주소 또는 서점 이름 입력">
      <a href="#none" onclick="searchLocation()" class="evt-search">검색</a>
      <p></p>
    </div>
    <div class="map-container">
      <div class="evt-map" id="map" style="width:500px;height:400px;"></div>
    </div>
    <div class="position-container">
    </div>
    <div class="address">
      <strong>주소:</strong> <span class="evt-view-address"></span>
    </div>
    <div>
      <a href="write.jsp">등록하기</a>
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
	    headers: {
	      'Authorization': 'KakaoAK 777e5bc1b050bf23083d724435c9f0ed'
	    },
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

	        var container = document.getElementById('map');
	        var options = {
	          center: new kakao.maps.LatLng(latitude, longitude),
	          level: 3
	        };
	        var map = new kakao.maps.Map(container, options);
	        var marker = new kakao.maps.Marker({
	          position: new kakao.maps.LatLng(latitude, longitude),
	          map: map
	        });
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
	  $('.map-container').css({
	    'display': 'flex',
	    'justify-content': 'flex-end' ,
	    'height':'0'
	  });
	  $('.evt-search-input').css({
		    'width': '250px'
		  });
	  
	  $('.evt-map').css({
	    'width': '800px',
	    'height': '700px'
	  });
	});
	
</script>
</div>

<style>
.container_div1 {
  display: flex;
  flex-direction: column;
}

.map-container {
  height: 700px;
}

.position-item {
  flex-basis: 50%;
}
</style>
