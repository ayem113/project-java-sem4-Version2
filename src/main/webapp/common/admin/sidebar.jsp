
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Quản trị </div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="index.html">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Tổng quan</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
           

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Quản lý</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="<c:url value='/quan-tri/san-pham/danh-sach'/>">Sản Phẩm</a>
                        <a class="collapse-item" href="<c:url value='/quan-tri/nguoi-dung/danh-sach'/>">Người dùng</a>
                        <a class="collapse-item" href="<c:url value='/quan-tri/danh-muc/danh-sach'/>">Danh mục</a>
                         <a class="collapse-item" href="<c:url value='/quan-tri/danh-muc/danh-sach'/>">Đơn hàng</a>
                    </div>
                </div>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>Tiện tích</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        
                        <a class="collapse-item" href="utilities-color.html">Hàng tồn kho</a>
                        <a class="collapse-item" href="utilities-border.html">Sản phẩm còn hàng</a>
                        <a class="collapse-item" href="utilities-animation.html">Sản phẩm hết hàng</a>
                        <a class="collapse-item" href="utilities-other.html">báo cáo doanh thu</a>
                        <a class="collapse-item" href="utilities-other.html">Lượng người mua</a>
                        <a class="collapse-item" href="utilities-other.html">Sản phẩm bán chạy</a>
                    </div>
                </div>
            </li>
            
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities2"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fa fa-cogs"></i>
                    <span>Tùy chọn ẩn/hiển thị </span>
                </a>
                <div id="collapseUtilities2" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        
                        <a class="collapse-item" href="utilities-color.html">Danh mục</a>
                        <a class="collapse-item" href="utilities-border.html">Sản phẩm</a>
                        
                    </div>
                </div>
            </li>
            
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities3"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fa fa-book"></i>
                    <span>Thiết lập các nhóm sản phẩm </span>
                </a>
                <div id="collapseUtilities3" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        
                        <a class="collapse-item" href="utilities-color.html">Khuyến mãi</a>
                        <a class="collapse-item" href="utilities-border.html">Giảm giá</a>
                         <a class="collapse-item" href="utilities-color.html">Hàng mưới về</a>
                        <a class="collapse-item" href="utilities-border.html">Hàng sắp về </a>
                         <a class="collapse-item" href="utilities-border.html">Hàng thanh lý </a>
                        
                    </div>
                </div>
            </li>


            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="charts.html">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Charts</span></a>
            </li>

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="tables.html">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Tables</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

            

        </ul>