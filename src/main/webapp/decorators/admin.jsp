

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
    
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    
    
    
    <!-- js girl -->
    <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.css" />
	<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid-theme.min.css" />
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.js"></script>

</head>

<body id="page-top">

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

</body>

</html>