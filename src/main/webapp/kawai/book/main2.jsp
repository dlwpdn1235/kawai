<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=75bc52b7e552dc0c2e818096144eaeeb"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script> 
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=75bc52b7e552dc0c2e818096144eaeeb&libraries=services,clusterer,drawing"></script>
<%@ include file="/kawai/inc/header.jsp" %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container map_container">
  <h1>지도</h1>
  <div class="row">
    <div class="col-sm-4" style="height: 700px; overflow: auto;">
      <div class="search-form">
        <input type="text" class="evt-search-input" name="searchInput" placeholder="주소 또는 서점 이름 입력">
        <a href="#none" onclick="searchLocation()" class="evt-search">검색</a>
      </div>
      <div class="address">
        <strong>주소:</strong> <span class="evt-view-address"></span>
      </div>
      <div>
        <a href="${pageContext.request.contextPath}/kawai/write.kawai">등록하기</a><br><br>
      </div>
      <div>
  <table>
    <tr>
      <td class="col-sm-4">
        <c:forEach var="dto" items="${list}" varStatus="status">
          <%-- <c:if test="${status.index < 10}"> --%>
          <span class="img_radius"><img class="profile" src="${pageContext.request.contextPath}/kawai/img/iron.jpg" alt="이미지"></span>
          <%-- </c:if> --%>
        </c:forEach>
      </td>
      <td class="col-sm-6 div_list">
        <c:forEach var="dto" items="${list}" varStatus="status">
          <%-- <c:if test="${status.index < 5}"> --%>
          	<p>${dto.bs_no}</p>
            <a href="${pageContext.request.contextPath}/kawai/detail.kawai?bs_name=${dto.bs_name}">${dto.bs_name}</a>
            <h5>${dto.bs_address_detail}</h5>
        <%--   </c:if> --%>
        </c:forEach>
      </td>
    </tr>
  </table>
</div>
    </div>
    <div class="col-sm-8">
      <div class="evt-map" id="map" style="width:100%; height:400px;"></div>
    </div>
  </div>
</div>

<%-- <div>
  	<p>임시용 링크태우기</p>
  	<a href="${pageContext.request.contextPath}/kawai/book_admin_list.kawai?bs_no=${bs_no}">관리자리스트</a>
  </div> --%>

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
    'width': '250px'
  });
  $('.evt-map').css({
    'width': '780px',
    'height': '700px'
  });
});
</script>

<style>
.container_div1 {
  display: flex;
  flex-direction: column;
} -> 지금 고칠것

.map-container {
  height: 700px;
}

.position-item {
  flex-basis: 50%;
}

img.profile {
    border-radius: 25%;
}
.profile {
    width: 71%;
    height: 9%;
    object-fit: cover;
    margin-top: 10px
}
.col-sm-6.div_list {
    margin-top: 15px;
    padding-left: 5px;
    position: absolute;
    display: table-cell;
}
table td[class*=col-], table th[class*=col-] {
    position: static;
    display: table-cell;
}
td.col-sm-3 {
    padding: 0px;
    margin: 0;
    width: 8%;
}
td.col-sm-4,
td.col-sm-6 {
  vertical-align: top; /* 이미지 상단에 맞추기 */
}
td.col-sm-6 a,
td.col-sm-6 h5 {
  margin-bottom: 10px; /* 아래쪽 간격 설정 */
}

</style>
