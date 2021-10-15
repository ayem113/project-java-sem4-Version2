<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html >
<style type="text/css">
	/* Fixed Header on Scroll */
	.sticky {
	  position: fixed;
	  top: 0;
	  width: 100%;
	  background-color: gold;
	}
	
      .ui-autocomplete-row
      {
       
        
        border-bottom:1px solid #ccc;
        font-weight:bold;
      }
      .ui-autocomplete-row:hover
      {
       padding:10px;
        background-color: #ddd;
      }
    </style>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <!--  <link rel="shortcut icon" type="image/x-icon" href="http://localhost:8080/images/favicon.png"/> -->
        <!-- <link rel="icon" href="/images/favicon.png" type="image/gif" sizes="16x16"> -->
        
     <link rel="icon" href="/images/favicopy.jpg" type="image/gif" sizes="16x16">
        
        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,300i,400,400i,600,600i,700,700i&amp;display=swap" rel="stylesheet">

    
    
    <link href="<c:url value='/template/web/assets/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/template/web/assets/css/animate.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/template/web/assets/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/template/web/assets/css/chosen.min.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/template/web/assets/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/template/web/assets/css/jquery.scrollbar.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/template/web/assets/css/lightbox.min.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/template/web/assets/css/magnific-popup.css'/>" rel="stylesheet" type="text/css"> 
    <link href="<c:url value='/template/web/assets/css/slick.min.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/template/web/assets/fonts/flaticon.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/template/web/assets/css/megamenu.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/template/web/assets/css/dreaming-attribute.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/template/web/assets/css/style.css'/>" rel="stylesheet" type="text/css">
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  
    
    <script src="<c:url value='/template/web/assets/js/jquery-1.12.4.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/chosen.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/countdown.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/jquery.scrollbar.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/lightbox.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/magnific-popup.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/slick.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/jquery.zoom.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/threesixty.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/jquery-ui.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/mobilemenu.js'/>"></script>
<script src='https://maps.googleapis.com/maps/api/js?key=AIzaSyC3nDHy1dARR-Pa_2jjPCjvsOR4bcILYsM'></script>
<script src="<c:url value='/template/web/assets/js/functions.js'/>"></script>

<script src="<c:url value='/template/web/paging/jquery.twbsPagination.js' />"></script>

    
    <title>Furgan - HTML Template </title>
</head>
<body >  <!-- onload="AutoLogoutClient();" -->



	<%@ include file="/common/web/header.jsp" %>

	<dec:body/>

	
	<%@ include file="/common/web/footer.jsp" %>




<a href="#" class="backtotop active">
    <i class="fa fa-angle-double-up"></i>
</a>








</body>
<script type="text/javascript">
$.get("/getDataSearchAutocomplete", {}, function(data) {  		
	  $('#search_data').autocomplete({
	      source: data,
	      focus: function( event, ui ) {
	          $( "#search_data" ).val( ui.item.label ); return false;
	        },
	      select: function (event, ui) {
			window.location.href = 'http://localhost:8080/san-pham/'+ui.item.slug; return false;
			}    
	    }).autocomplete( "instance" )._renderItem = function( ul, item ) {
	        return $( "<li class='ui-autocomplete-row'></li>" )
	        .append( "<img class=\"img-responsive\"src=\"/images/"+item.img+"\"alt=\"Office Chair\" width=\"70\" height=\"50\">")
	        .append( "<a> "+ item.label + " </a>     "  )
	        .appendTo( ul );
	    };;
}); 

function AutoLogoutClient() {   //khi người dùng k thao tác trên web thì tự động logout

	
	var time;
    window.onload = resetTimer; //trường hợp khi load vào trang sẽ gọi ngày hàm resetTimer() 
    
    
 	// bắt các trường hợp người dùng k thao tác trên web
    window.onmousemove = resetTimer;
    window.onmousedown = resetTimer; 
    window.onclick = resetTimer;     
    window.onscroll = resetTimer;   
    window.onkeypress = resetTimer;

    function logout() {
        window.location = 'http://localhost:8080/dang-nhap?sessionTimeout';
    }

    function resetTimer() {
        clearTimeout(time); //Phương thức clearTimeout() sẽ xóa bộ hẹn giờ của phương thức setTimeout() .
        time = setTimeout(logout, 600000);  // gọi hàm logout sau  600000  milliseconds(10 phut)
    }
}
</script>
</html>