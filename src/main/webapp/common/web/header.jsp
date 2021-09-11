
<%@include file="/common/taglib.jsp"%>
<%@ page import="com.projectjavasem4.util.SecurityUtils"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<c:set var="cart" value="${sessionScope['scopedTarget.cartService']}"/>
	

	
<header id="header"
	class="header style-03 header-dark header-transparent">
	<div class="header-wrap-stick">
		<div class="header-position">
			<div class="header-middle">
				<div class="furgan-menu-wapper"></div>
				<div class="header-middle-inner">

					<div class="block-menu-bar">
						<a class="menu-bar menu-toggle" href="#"> <span></span> <span></span>
							<span></span>
						</a>
					</div>
				</div>
				<div class="header-logo">
					<a href="<c:url value='/trang-chu?page=1&limit=10'/>"><img alt="Furgan"
						src="<c:url value='/template/web/assets/images/logo.png '/>"
						class="logo"></a>
				</div>
				<div class="header-control">
					<div class="header-control-inner">
						<div class="meta-dreaming">
						
						<div class="menu-item block-user block-dreaming furgan-dropdown">
								<a class="" href="my-account.html"> <span
									class=""></span> Danh muc
								</a>
								<ul class="sub-menu">
								
								<c:forEach var="item" items="${sessionScope.listCategory2}"> 
								
									<li
										class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--dashboard is-active">
										<a href=" <c:url value='/trang-chu?danh-muc=${item.code}&page=1&limit=10'/>"> ${item.name}</a>
									</li>
								</c:forEach>
								
								
									
									
								</ul>
								
								
								<%-- <c:forEach var="item" items="${sessionScope.listCategory2}">
							      <li>${item.name}</li>
							        <c:forEach items = "${item.category}" var="c"> 
							            <li>${c.id}</li>
							            <li>${c.name}</li>
							        </c:forEach> 
							    </c:forEach> --%>
								
								
							</div>
						
						
							<ul class="wpml-menu">



							


									<%--  cách 1 dùng security    <security:authorize access = "isAnonymous()">
										<a class="nav-link" href="<c:url value='/dang-nhap'/>">Đăng nhập</a>
										<a class="nav-link" href="<c:url value='/dang-ky'/>">Đăng ký</a>
									</security:authorize>
									
									<security:authorize access = "isAuthenticated()">
										<a class="nav-link" href="#">Wellcome <%=SecurityUtils.getPrincipal().getFullName()%></a>
										<a class="nav-link" href="<c:url value='/thoat'/>">Thoát</a>
									</security:authorize> --%>
				
				


								<%-- <% if(SecurityUtils.getPrincipal().getFullName()==null || SecurityUtils.getPrincipal().getFullName()==""){ %>
									<li class="nav-item"><a class="nav-link" href="<c:url value='/dang-nhap'/>">Đăng nhập</a></li>
									<li class="nav-item"><a class="nav-link" href="<c:url value='/dang-ky'/>">Đăng ký</a></li>
								<% }
								else{ %>
									<li class="nav-item"><a class="nav-link" href="#"> <%=SecurityUtils.getPrincipal().getFullName()%></a></li>
									<li class="nav-item"><a class="nav-link" href="<c:url value='/thoat'/>">Thoát </a></li>
								<%} %> --%>
								
								<!-- dùng cách cũ -->
								
								<% if(SecurityUtils.getPermission().size()>1 ){ %>
									<li class="nav-item"><a class="nav-link" href="#"> <%=SecurityUtils.getPrincipal().getFullName()%></a></li>
									<li class="nav-item"><a class="nav-link" href="<c:url value='/thoat'/>">Thoát </a></li>
								<% }
								else{ %>
									<li class="nav-item"><a class="nav-link" href="<c:url value='/dang-nhap'/>">Đăng nhập </a></li>
									<li class="nav-item"><a class="nav-link" href="<c:url value='/dang-ky'/>">Đăng ký</a></li>
								<%} %>

						


							</ul>
							<div class="header-search furgan-dropdown">
								<div class="header-search-inner" data-furgan="furgan-dropdown">
									<a href="#" class="link-dropdown block-link"> <span
										class="flaticon-magnifying-glass-1"></span>
									</a>
								</div>
								<div class="block-search">
									<form role="search" method="get"
										class="form-search block-search-form furgan-live-search-form">
										<div class="form-content search-box results-search">
											<div class="inner">
												<input autocomplete="off"
													class="searchfield txt-livesearch input" name="s" value=""
													placeholder="Search here..." type="text">
											</div>
										</div>
										<input name="post_type" value="product" type="hidden">
										<input name="taxonomy" value="product_cat" type="hidden">
										<div class="category">
											<select title="product_cat" name="product_cat"
												class="category-search-option" tabindex="-1">
												<option value="0">All Categories</option>
												<option class="level-0" value="light">Light</option>
												<option class="level-0" value="chair">Chair</option>
												<option class="level-0" value="table">Table</option>
												<option class="level-0" value="bed">Bed</option>
												<option class="level-0" value="new-arrivals">New
													arrivals</option>
												<option class="level-0" value="lamp">Lamp</option>
												<option class="level-0" value="specials">Specials</option>
												<option class="level-0" value="sofas">Sofas</option>
											</select>
										</div>
										<button type="submit" class="btn-submit">
											<span class="flaticon-magnifying-glass-1"></span>
										</button>
									</form>
									<!-- block search -->
								</div>
							</div>
							<div class="furgan-dropdown-close">x</div>
							<div class="menu-item block-user block-dreaming furgan-dropdown">
								<a class="block-link" href="my-account.html"> <span
									class="flaticon-profile"></span>
								</a>
								<ul class="sub-menu">
									<li
										class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--dashboard is-active">
										<a href="#">Dashboard</a>
									</li>
									<li
										class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--orders">
										<a href="#">Orders</a>
									</li>
									<li
										class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--downloads">
										<a href="#">Downloads</a>
									</li>
									<li
										class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--edit-adchair">
										<a href="#">Address</a>
									</li>
									<li
										class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--edit-account">
										<a href="#">Account details</a>
									</li>
									<li
										class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--customer-logout">
										<a href="#">Logout</a>
									</li>
								</ul>
							</div>
							<div
								class="block-minicart block-dreaming furgan-mini-cart furgan-dropdown">
								<div class="shopcart-dropdown block-cart-link"
									data-furgan="furgan-dropdown">
									<a class="block-link link-dropdown" href="<c:url value="/gio-hang/danh-sach"/>"> <span
										class="flaticon-cart"></span> <span id="cart-total-items" class="count">  ${cart.totalItems}</span>
									</a>
								</div>
								<div class="widget furgan widget_shopping_cart">
									<div class="widget_shopping_cart_content">
										<ul class="furgan-mini-cart cart_list product_list_widget">
											<c:forEach var="p" items="${sessionScope['scopedTarget.cartService'].all}"> 
											
											<li class="furgan-mini-cart-item mini_cart_item"><a href="#" class="remove remove_from_cart_button">×</a> 
											<a	href="#"> <img src="<c:url value="/images"/>/${p.img }"class="attachment-furgan_thumbnail size-furgan_thumbnail" alt="img" width="600" height="778"> ${p.name } &nbsp;
											</a> <span class="quantity"> ${p.quantity } ×  ${p.price }
											<span class="furgan-Price-amount amount"><span class="furgan-Price-currencySymbol">VND</span>  </span></span>
											</li>
											
											</c:forEach>
										</ul>
										<p class="furgan-mini-cart__total total">
											<strong> Tổng tiền:</strong> <span id="cart-total-price"
												class="furgan-Price-amount amount"><span
												class="furgan-Price-currencySymbol">VND</span> <f:formatNumber value="${cart.totalPrice}" pattern="#,###.00	" ></f:formatNumber>    </span>
										</p>
										<p class="furgan-mini-cart__buttons buttons">
											<a href="/gio-hang/danh-sach" class="button furgan-forward">Xem giỏ hàng</a>
											<a href="<c:url value="/thanh-toan"/>"
												class="button checkout furgan-forward">Thanh toán</a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="header-mobile">
		<div class="header-mobile-left">
			<div class="block-menu-bar">
				<a class="menu-bar menu-toggle" href="#"> <span></span> <span></span>
					<span></span>
				</a>
			</div>
			<div class="header-search furgan-dropdown">
				<div class="header-search-inner" data-furgan="furgan-dropdown">
					<a href="#" class="link-dropdown block-link"> <span
						class="flaticon-magnifying-glass-1"></span>
					</a>
				</div>
				<div class="block-search">
					<form role="search" method="get"
						class="form-search block-search-form furgan-live-search-form">
						<div class="form-content search-box results-search">
							<div class="inner">
								<input autocomplete="off"
									class="searchfield txt-livesearch input" name="s" value=""
									placeholder="Search here..." type="text">
							</div>
						</div>
						<input name="post_type" value="product" type="hidden"> <input
							name="taxonomy" value="product_cat" type="hidden">
						<div class="category">
							<select title="product_cat" name="product_cat" id="112546160"
								class="category-search-option" tabindex="-1"
								style="display: none;">
								<option value="0">All Categories</option>
								<option class="level-0" value="light">Light</option>
								<option class="level-0" value="chair">Chair</option>
								<option class="level-0" value="table">Table</option>
								<option class="level-0" value="bed">Bed</option>
								<option class="level-0" value="new-arrivals">New
									arrivals</option>
								<option class="level-0" value="lamp">Lamp</option>
								<option class="level-0" value="specials">Specials</option>
								<option class="level-0" value="sofas">Sofas</option>
							</select>
						</div>
						<button type="submit" class="btn-submit">
							<span class="flaticon-magnifying-glass-1"></span>
						</button>
					</form>
					<!-- block search -->
				</div>
			</div>
			<ul class="wpml-menu">
				<li class="menu-item furgan-dropdown block-language"><a
					href="#" data-furgan="furgan-dropdown"> <img
						src="assets/images/en.png" alt="en" width="18" height="12">
						English
				</a> <span class="toggle-submenu"></span>
					<ul class="sub-menu">
						<li class="menu-item"><a href="#"> <img
								src="assets/images/it.png" alt="it" width="18" height="12">
								Italiano
						</a></li>
					</ul></li>
				<li class="menu-item">
					<div class="wcml-dropdown product wcml_currency_switcher">
						<ul>
							<li class="wcml-cs-active-currency"><a
								class="wcml-cs-item-toggle">USD</a>
								<ul class="wcml-cs-submenu">
									<li><a>EUR</a></li>
								</ul></li>
						</ul>
					</div>
				</li>


			</ul>
		</div>
		<div class="header-mobile-mid">
			<div class="header-logo">
				<a href="index.html"><img alt="Furgan"
					src="assets/images/logo.png" class="logo"></a>
			</div>
		</div>
		<div class="header-mobile-right">
			<div class="header-control-inner">
				<div class="meta-dreaming">
					<div class="menu-item block-user block-dreaming furgan-dropdown">
						<a class="block-link" href="my-account.html"> <span
							class="flaticon-profile"></span>
						</a>
						<ul class="sub-menu">
							<li
								class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--dashboard is-active">
								<a href="#">Dashboard</a>
							</li>
							<li
								class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--orders">
								<a href="#">Orders</a>
							</li>
							<li
								class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--downloads">
								<a href="#">Downloads</a>
							</li>
							<li
								class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--edit-adchair">
								<a href="#">Address</a>
							</li>
							<li
								class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--edit-account">
								<a href="#">Account details</a>
							</li>
							<li
								class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--customer-logout">
								<a href="#">Logout</a>
							</li>
						</ul>
					</div>
					<div
						class="block-minicart block-dreaming furgan-mini-cart furgan-dropdown">
						<div class="shopcart-dropdown block-cart-link"
							data-furgan="furgan-dropdown">
							<a class="shopping-cart block-link link-dropdown" href="cart.html"> <span
								class="flaticon-cart   "></span> <span class="count">3</span>
							</a>
						</div>
						<div class="widget furgan widget_shopping_cart">
							<div class="widget_shopping_cart_content">
								<ul class="furgan-mini-cart cart_list product_list_widget">
									<li class="furgan-mini-cart-item mini_cart_item"><a
										href="#" class="remove remove_from_cart_button">×</a> <a
										href="#"> <img src="assets/images/apro134-1-600x778.jpg"
											class="attachment-furgan_thumbnail size-furgan_thumbnail"
											alt="img" width="600" height="778">T-shirt with skirt –
											Pink&nbsp;
									</a> <span class="quantity">1 × <span
											class="furgan-Price-amount amount"><span
												class="furgan-Price-currencySymbol">$</span>150.00</span></span></li>
									<li class="furgan-mini-cart-item mini_cart_item"><a
										href="#" class="remove remove_from_cart_button">×</a> <a
										href="#"> <img src="assets/images/apro1113-600x778.jpg"
											class="attachment-furgan_thumbnail size-furgan_thumbnail"
											alt="img" width="600" height="778">Alarm Clock&nbsp;
									</a> <span class="quantity">1 × <span
											class="furgan-Price-amount amount"><span
												class="furgan-Price-currencySymbol">$</span>129.00</span></span></li>
									<li class="furgan-mini-cart-item mini_cart_item"><a
										href="#" class="remove remove_from_cart_button">×</a> <a
										href="#"> <img src="assets/images/apro201-1-600x778.jpg"
											class="attachment-furgan_thumbnail size-furgan_thumbnail"
											alt="img" width="600" height="778">Chair AAC&nbsp;
									</a> <span class="quantity">1 × <span
											class="furgan-Price-amount amount"><span
												class="furgan-Price-currencySymbol">$</span>139.00</span></span></li>
								</ul>
								<p class="furgan-mini-cart__total total">
									<strong>Subtotal:</strong> <span
										class="furgan-Price-amount amount"><span
										class="furgan-Price-currencySymbol">$</span>418.00</span>
								</p>
								<p class="furgan-mini-cart__buttons buttons">
									<a href="cart.html" class="button furgan-forward">Viewcart</a>
									<a href="checkout.html" class="button checkout furgan-forward">Checkout</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>

<div class="slide-home-03">
			<div
				class="response-product product-list-owl owl-slick equal-container better-height"
				data-slick="{&quot;arrows&quot;:false,&quot;slidesMargin&quot;:0,&quot;dots&quot;:true,&quot;infinite&quot;:false,&quot;speed&quot;:300,&quot;slidesToShow&quot;:1,&quot;rows&quot;:1}"
				data-responsive="[{&quot;breakpoint&quot;:480,&quot;settings&quot;:{&quot;slidesToShow&quot;:1,&quot;slidesMargin&quot;:&quot;0&quot;}},{&quot;breakpoint&quot;:768,&quot;settings&quot;:{&quot;slidesToShow&quot;:1,&quot;slidesMargin&quot;:&quot;0&quot;}},{&quot;breakpoint&quot;:992,&quot;settings&quot;:{&quot;slidesToShow&quot;:1,&quot;slidesMargin&quot;:&quot;0&quot;}},{&quot;breakpoint&quot;:1200,&quot;settings&quot;:{&quot;slidesToShow&quot;:1,&quot;slidesMargin&quot;:&quot;0&quot;}},{&quot;breakpoint&quot;:1500,&quot;settings&quot;:{&quot;slidesToShow&quot;:1,&quot;slidesMargin&quot;:&quot;0&quot;}}]">
				<div class="slide-wrap">
					<img src="/template/web/assets/images/slide31.jpg" alt="image">
					<div class="slide-info">
						<div class="container">
							<div class="slide-inner">
								<h1>SUMMER</h1>
								<h5>Hot Trending</h5>
								<h2>
									<span>Plastic Chair </span>Collection
								</h2>
								<a href="#">Shop now</a>
							</div>
						</div>
					</div>
				</div>
				<div class="slide-wrap">
					<img src="/template/web/assets/images/slide32.jpg" alt="image">
					<div class="slide-info">
						<div class="container">
							<div class="slide-inner">
								<h1>SPRING</h1>
								<h5>New Arrivals</h5>
								<h2>
									<span>Salon Set</span> Collection
								</h2>
								<a href="#">Shop now</a>
							</div>
						</div>
					</div>
				</div>
				<div class="slide-wrap">
					<img src="/template/web/assets/images/slide33.jpg" alt="image">
					<div class="slide-info">
						<div class="container">
							<div class="slide-inner">
								<h1>SUMMER</h1>
								<h5>Collection-2020</h5>
								<h2>
									<span>Armchair</span> For Your Relax
								</h2>
								<a href="#">Shop now</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>