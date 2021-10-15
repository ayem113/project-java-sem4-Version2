
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Dashboard</title>
    

    <link  rel="stylesheet"  type="text/css" href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css'/>">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link rel="stylesheet"  href="<c:url value='/template/admin/css/sb-admin-2.min.css'/>" >
    <script src="<c:url  value='/template/admin/vendor/jquery/jquery.min.js'/>"> </script>
    <script src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
    <link rel="stylesheet" href="<c:url  value='/template/admin/vendor/datatables/dataTables.bootstrap4.min.css'/>" >
    
    
    <link   href="<c:url value='/template/admin/css/uploadfile.css'/>"   rel="stylesheet">
    
     <script src="<c:url value='/template/admin/js/jquery.uploadfile.js'/>" ></script>
    
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    
    
    
    <!-- js girl -->
    <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.css" />
	<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid-theme.min.css" />
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.js"></script>

</head>

<body  id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
         <%@ include file="/common/admin/sidebar.jsp" %>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                
                 <%@ include file="/common/admin/header.jsp" %>
                
                
                
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                
                
                <dec:body/>
                
                
                
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

 

    <script src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js'/>"></script>
    <script src="<c:url value='/template/admin/js/sb-admin-2.min.js'/>"></script>
    <script src="<c:url value='/template/admin/vendor/chart.js/Chart.min.js'/>"></script>
    <script src="<c:url value='/template/admin/js/demo/chart-area-demo.js'/>"></script>
    <script src="<c:url value='/template/admin/js/demo/chart-pie-demo.js'/>"></script>
    <script src="<c:url value='/template/admin/vendor/datatables/jquery.dataTables.min.js'/>"></script>
    <script src="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.min.js'/>"></script>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>   
	<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
	<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
	
</body>
<script type="text/javascript">

//googleCharts
$(document).ready(function() {
	
	

	    	const chart = Highcharts.chart('container', {
	    		  chart: {
	    		    plotBackgroundColor: null,
	    		    plotBorderWidth: null,
	    		    plotShadow: false,
	    		    type: 'pie'
	    		  },
	    		  title: {
	    		    text: 'Các sản phẩm đang được người dùng đặc biệt quan tâm'
	    		  },
	    		  tooltip: {
	    		    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	    		  },
	    		  accessibility: {
	    		    point: {
	    		      valueSuffix: '%'
	    		    }
	    		  },
	    		  plotOptions: {
	    		    pie: {
	    		      allowPointSelect: true,
	    		      cursor: 'pointer',
	    		      dataLabels: {
	    		        enabled: true,
	    		        format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	    		      }
	    		    }
	    		  },
	    		  series: [{
	    		    name: 'tỉ lệ',
	    		    colorByPoint: true,
	    		    data: []
	    		  }]
	    		});
	    	
	    	var cc2= [];
	    	<c:forEach items="${listInterested}" var="dataPoint">
	    		var ob=
	    			{
		                name: '${dataPoint.name}',
		                y: ${dataPoint.viewCount}
		            };
		    	cc2.push(ob);
	 		</c:forEach>	
	    	chart.series[0].setData(cc2);    	
	    
	
	

	$.ajax({
		type : 'GET',
		headers : {
			Accept : "application/json; charset=utf-8",
			"Content-Type" : "application/json; charset=utf-8"
		},
		url : 'http://localhost:8080/quan-tri/chart/data',
		success : function(result) {
			google.charts.load('current', {
				'packages' : [ 'corechart' ]
			});
			google.charts.setOnLoadCallback(function() {
				drawChart(result);
			});
		}
	});

	function drawChart(result) {

		var data = new google.visualization.DataTable();
		data.addColumn('string', 'name');
		data.addColumn('number', 'quantity');
		var dataArray = [];
		$.each(result, function(i, obj) {
			dataArray.push([ obj.name, obj.quantity ]);
		});

		data.addRows(dataArray);

		var piechart_options = {
			title : 'Pie Chart: How Much Products Sold By Last Night',
			width : 400,
			is3D: true,
			height : 300
		};
		var piechart = new google.visualization.PieChart(document
				.getElementById('piechart_div'));
		piechart.draw(data, piechart_options);

		var barchart_options = {
			title : 'Barchart: How Much Products Sold By Last Night',
			width : 400,
			height : 300,
			legend : 'none'
		};
		var barchart = new google.visualization.BarChart(document
				.getElementById('barchart_div'));
		barchart.draw(data, barchart_options);
	}

});


//canvasjs Chair

window.onload = function() {
	 
	 var dps = [[]];
	 var chart = new CanvasJS.Chart("chartContainerRateOfProductsByCategory", {
	 	theme: "light2", // "light1", "dark1", "dark2"
	 	exportEnabled: true,
	 	animationEnabled: true,
	 	title: {
	 		text: "Tỉ lệ sản phẩm theo danh mục"
	 	},
	 	data: [{
	 		type: "pie",
	 		showInLegend: "true",
	 		legendText: "{label}",
	 		yValueFormatString: "#,###\"%\"",
	 		indexLabelFontSize: 16,
	 		indexLabel: "{label} - {y}",
	 		dataPoints: dps[0]
	 	}]
	 });
	  
	 var yValue;
	 var label;
	  
	 <c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">	
	 	<c:forEach items="${dataPoints}" var="dataPoint">
	 		yValue = parseFloat("${dataPoint.y}");
	 		label = "${dataPoint.label}";
	 		dps[parseInt("${loop.index}")].push({
	 			label : label,
	 			y : yValue,
	 		});		
	 	</c:forEach>	
	 </c:forEach> 
	  
	 chart.render();
	 
	 
	 
	 var dps = [[]];
	 var chart = new CanvasJS.Chart("chartContainerBestSellingForChair", {
	 	theme: "light2", // "light1", "dark1", "dark2"
	 	exportEnabled: true,
	 	animationEnabled: true,
	 	title: {
	 		text: "Danh sách sản phẩm bán chạy"
	 	},
	 	data: [{
	 		type: "pie",
	 		showInLegend: "true",
	 		legendText: "{label}",
	 		yValueFormatString: "#,###\" lượt mua\"",
	 		indexLabelFontSize: 16,
	 		indexLabel: "{label} - {y}",
	 		dataPoints: dps[0]
	 	}]
	 });
	  
	 var yValue;
	 var label;
	  
	 <c:forEach items="${dataPointsList2}" var="dataPoints" varStatus="loop">	
	 	<c:forEach items="${dataPoints}" var="dataPoint">
	 		yValue = parseFloat("${dataPoint.y}");
	 		label = "${dataPoint.label}";
	 		dps[parseInt("${loop.index}")].push({
	 			label : label,
	 			y : yValue,
	 		});		
	 	</c:forEach>	
	 </c:forEach> 
	  
	 chart.render();


}
	 
	 
	 
	
	
	








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