<%@include file="/common/taglib.jsp"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!-- <style>
.shoppinggg-cart {
	display: inline-block;
	background: url('https://webdevtrick.com/wp-content/uploads/cart.png')
	no-repeat 0 0;
	width: 24px;
	height: 24px;
	margin: 0 10px 0 0;
}
</style> -->

<body>




	<div class="fullwidth-template">


		<div class="section-017">
			<div class="row">
				<div class="col-md-12 col-lg-4">
					<div class="furgan-banner style-08 left-center">
						<div class="banner-inner">
							<figure class="banner-thumb">
								<img
									src="<c:url value='/template/web/assets/images/banner31.jpg'/>"
									class="attachment-full size-full" alt="img">
							</figure>
							<div class="banner-info ">
								<div class="banner-content">
									<div class="title-wrap">
										<h6 class="title">Deal Of Day</h6>
									</div>
									<div class="cate">50% sale off</div>
									<div class="button-wrap">
										<a class="button" target="_self" href="#"><span>Shop
												now</span></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-12 col-lg-4">
					<div class="furgan-banner style-09 left-center">
						<div class="banner-inner">
							<figure class="banner-thumb">
								<img src="/template/web/assets/images/banner32.jpg"
									class="attachment-full size-full" alt="img">
							</figure>
							<div class="banner-info ">
								<div class="banner-content">
									<div class="title-wrap">
										<h6 class="title">Best Product</h6>
									</div>
									<div class="cate">Plastic Chair</div>
									<div class="button-wrap">
										<a class="button" target="_self" href="#"><span>Shop
												now</span></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-12 col-lg-4">
					<div class="furgan-banner style-10 left-center">
						<div class="banner-inner">
							<figure class="banner-thumb">
								<img src="/template/web/assets/images/banner33.jpg"
									class="attachment-full size-full" alt="img">
							</figure>
							<div class="banner-info ">
								<div class="banner-content">
									<div class="title-wrap">
										<h6 class="title">New Arrivals</h6>
									</div>
									<div class="cate">Hang Light</div>
									<div class="button-wrap">
										now</span></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="section-001">
			<div class="container">
				<div class="furgan-heading style-01">
					<div class="heading-inner">
						<h3 class="title">Trending Clothing</h3>
						<div class="subtitle">Browse our website for the hottest
							items in the marketplace now.</div>

						<span><i class="shoppinggg-cart"></i></span>
					</div>
				</div>


				<label for="cars">Hiển thị sản phẩm một trang:</label>
				<div class="dropdownLimit">
					<select name="limit">
						<option value="5">5</option>
						<option value="10">10</option>
						<option value="15">15</option>
						<option value="20">20</option>
					</select>
				</div>



				<div class="furgan-products style-04">

					<form action="<c:url value='/trang-chu'/>" id="formSubmit"
						method="get">


						<div
							class="response-product product-list-grid row auto-clear equal-container better-height ">

							<c:forEach var="item" items="${model.listResult}">


								<div
									class="product-item best-selling style-04 rows-space-30 col-bg-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-ts-6 post-25 product type-product status-publish has-post-thumbnail product_cat-light product_cat-chair product_cat-specials product_tag-light product_tag-sock first instock sale featured shipping-taxable purchasable product-type-simple">
									<div class="product-inner tooltip-top tooltip-all-top">
										<div class="product-thumb">
											<a class="thumb-link" href="#"> <img
												class="img-responsive"
												src="/template/web/assets/images/apro151-1-270x350.jpg"
												alt="Office Chair" width="270" height="350">
											</a>
											<div class="flash">
												<span class="onsale"><span class="number">-11%</span></span>
												<span class="onnew"><span class="text">New</span></span>
											</div>
											<div class="group-button">
												<div class="add-to-cart">
													<a data-id='${item.id}'
														class=" btnAddToCart button product_type_simple add_to_cart_button ajax_add_to_cart">Add
														to cart</a>
												</div>
												<a href="#" class="button yith-wcqv-button">Quick View</a>
												<div class="furgan product compare-button">
													<a href="#" class="compare button">Compare</a>
												</div>
												<div class="yith-wcwl-add-to-wishlist">
													<div class="yith-wcwl-add-button show">
														<a data-id='${item.id}'
															class="btnAddToWishlist add_to_wishlist">Add to
															Wishlist</a>
													</div>
												</div>
											</div>
										</div>
										<div class="product-info">
											<h3 class="product-name product_title">
												<a href="/san-pham?name=${item.slug}">${item.name}</a> <a
													href="/san-pham/${item.slug}">${item.name}</a>
											</h3>
											<span class="price"><del>
													<span class="furgan-Price-amount amount"><span
														class="furgan-Price-currencySymbol">$</span>89.00</span>
												</del> <ins>
													<span class="furgan-Price-amount amount"><span
														class="furgan-Price-currencySymbol">$</span>${item.price}</span>
												</ins></span>
											<div class="rating-wapper nostar">
												<div class="star-rating">
													<span style="width: 0%">Rated <strong class="rating">0</strong>
														out of 5
													</span>
												</div>
												<span class="review">(0)</span>
											</div>
										</div>
									</div>
								</div>

							</c:forEach>


						</div>
						<!-- OWL Products -->




						<ul class="pagination" id="pagination"></ul>
						
						
						
						 <input type="hidden" value="${model.cateCode}" id="cateCode" name="danh-muc" />
						<input type="hidden" value="${model.page}" id="page" name="page" /> 
						<input type="hidden" value="${model.limit}" id="limit" name="limit" />
						
							



						<div class="shop-all">
							<a target=" _blank" href="#">Discovery All</a>
						</div>
					</form>

				<input type="hidden" value="" id="pageT" name="pageT" /> 




				</div>
			</div>
		</div>
		<div class="section-018">
			<div class="container">
				<div class="row">
					<div
						class="offset-sm-2 col-sm-10 offset-md-4 col-md-8 offset-xl-6 col-xl-6 offset-lg-5 col-lg-7">
						<div class="furgan-slide">
							<div class="owl-slick equal-container better-height dots-light"
								data-slick="{&quot;arrows&quot;:false,&quot;slidesMargin&quot;:0,&quot;dots&quot;:true,&quot;infinite&quot;:false,&quot;speed&quot;:300,&quot;slidesToShow&quot;:1,&quot;vertical&quot;:true,&quot;verticalSwiping&quot;:true,&quot;rows&quot;:1}"
								data-responsive="[{&quot;breakpoint&quot;:480,&quot;settings&quot;:{&quot;slidesToShow&quot;:1,&quot;slidesMargin&quot;:&quot;0&quot;}},{&quot;breakpoint&quot;:768,&quot;settings&quot;:{&quot;slidesToShow&quot;:1,&quot;slidesMargin&quot;:&quot;0&quot;}},{&quot;breakpoint&quot;:992,&quot;settings&quot;:{&quot;slidesToShow&quot;:1,&quot;slidesMargin&quot;:&quot;0&quot;}},{&quot;breakpoint&quot;:1200,&quot;settings&quot;:{&quot;slidesToShow&quot;:1,&quot;slidesMargin&quot;:&quot;0&quot;}},{&quot;breakpoint&quot;:1500,&quot;settings&quot;:{&quot;slidesToShow&quot;:1,&quot;slidesMargin&quot;:&quot;0&quot;}}]">
								<div class="furgan-testimonial style-01">
									<div class="testimonial-inner">
										<p class="desc">Lorem ipsum dolor sit amet consectetur
											adipiscing elit, facilisi viverra morbi aptent taciti
											hendrerit pulvinar ante</p>
										<div class="testimonial-info">
											<div class="intro">
												<h3 class="name">
													<a href="#" target="_self" tabindex="0"> Charley Pratt
													</a>
												</h3>
												<div class="position">Student</div>
											</div>
											<div class="thumb">
												<img src="/template/web/assets/images/avatar1.jpg"
													class="attachment-full size-full" alt="img" width="97"
													height="97">
											</div>
										</div>
									</div>
								</div>
								<div class="furgan-testimonial style-01">
									<div class="testimonial-inner">
										<p class="desc">Lorem ipsum dolor sit amet consectetur
											adipiscing elit, facilisi viverra morbi aptent taciti
											hendrerit pulvinar ante</p>
										<div class="testimonial-info">
											<div class="intro">
												<h3 class="name">
													<a href="#" target="_self" tabindex="-1"> Nadia Pugh </a>
												</h3>
												<div class="position">Student</div>
											</div>
											<div class="thumb">
												<img src="/template/web/assets/images/avatar3.jpg"
													class="attachment-full size-full" alt="img" width="97"
													height="97">
											</div>
										</div>
									</div>
								</div>
								<div class="furgan-testimonial style-01">
									<div class="testimonial-inner">
										<p class="desc">Lorem ipsum dolor sit amet consectetur
											adipiscing elit, facilisi viverra morbi aptent taciti
											hendrerit pulvinar ante</p>
										<div class="testimonial-info">
											<div class="intro">
												<h3 class="name">
													<a href="#" target="_self" tabindex="-1"> Troy Bryant </a>
												</h3>
												<div class="position">Student</div>
											</div>
											<div class="thumb">
												<img src="/template/web/assets/images/avatar2.jpg"
													class="attachment-full size-full" alt="img" width="97"
													height="97">
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="section-001">

			<div class="container">
				<div class="furgan-heading style-01">
					<div class="heading-inner">
						<h3 class="title">From Our Blog</h3>
						<div class="subtitle">Lorem ipsum dolor sit amet consectetur
							adipiscing elit erat vehicula ad, mollis viverra vulputate</div>
					</div>
				</div>
				<div class="furgan-blog style-02">
					<div class="blog-list-owl owl-slick equal-container better-height"
						data-slick="{&quot;arrows&quot;:false,&quot;slidesMargin&quot;:30,&quot;dots&quot;:true,&quot;infinite&quot;:false,&quot;speed&quot;:300,&quot;slidesToShow&quot;:3,&quot;rows&quot;:1}"
						data-responsive="[{&quot;breakpoint&quot;:480,&quot;settings&quot;:{&quot;slidesToShow&quot;:1,&quot;slidesMargin&quot;:&quot;10&quot;}},{&quot;breakpoint&quot;:768,&quot;settings&quot;:{&quot;slidesToShow&quot;:1,&quot;slidesMargin&quot;:&quot;10&quot;}},{&quot;breakpoint&quot;:992,&quot;settings&quot;:{&quot;slidesToShow&quot;:2,&quot;slidesMargin&quot;:&quot;20&quot;}},{&quot;breakpoint&quot;:1200,&quot;settings&quot;:{&quot;slidesToShow&quot;:2,&quot;slidesMargin&quot;:&quot;20&quot;}},{&quot;breakpoint&quot;:1500,&quot;settings&quot;:{&quot;slidesToShow&quot;:3,&quot;slidesMargin&quot;:&quot;30&quot;}}]">
						<article
							class="post-item post-grid rows-space-0 post-195 post type-post status-publish format-standard has-post-thumbnail hentry category-light category-table category-life-style tag-light tag-life-style">
							<div class="post-inner">
								<div class="post-thumb">
									<a href="#" tabindex="0"> <img
										src="/template/web/assets/images/blogpost1-370x330.jpg"
										class="img-responsive attachment-370x330 size-370x330"
										alt="img" width="370" height="330">
									</a>
								</div>
								<div class="post-content">
									<div class="post-info">
										<div class="title-date">
											<a class="datebox" href="#" tabindex="0"> <span>19</span>
												<span>Dec</span>
											</a>
											<h2 class="post-title">
												<a href="#" tabindex="0">Not your ordinary furniture
													service.</a>
											</h2>
										</div>
										<div class="post-meta">
											<div class="post-author">
												By:<a href="#" tabindex="0"> admin </a>
											</div>
											<div class="post-comment-icon">
												<a href="#" tabindex="0">0 </a>
											</div>
										</div>
										Lorem ipsum dolor sit amet, consectetur adipiscing elit.
										Malesuada sodales quisque litora dapibus primis lacinia
									</div>
								</div>
							</div>
						</article>
						<article
							class="post-item post-grid rows-space-0 post-192 post type-post status-publish format-standard has-post-thumbnail hentry category-light category-fashion category-furniture category-life-style tag-light tag-fashion tag-furniture">
							<div class="post-inner">
								<div class="post-thumb">
									<a href="#" tabindex="0"> <img
										src="/template/web/assets/images/blogpost5-370x330.jpg"
										class="img-responsive attachment-370x330 size-370x330"
										alt="img" width="370" height="330">
									</a>
								</div>
								<div class="post-content">
									<div class="post-info">
										<div class="title-date">
											<a class="datebox" href="#" tabindex="0"> <span>19</span>
												<span>Dec</span>
											</a>
											<h2 class="post-title">
												<a href="#" tabindex="0">We bring you the best by
													working</a>
											</h2>
										</div>
										<div class="post-meta">
											<div class="post-author">
												By:<a href="#" tabindex="0"> admin </a>
											</div>
											<div class="post-comment-icon">
												<a href="#" tabindex="0">0 </a>
											</div>
										</div>
										Lorem ipsum dolor sit amet, consectetur adipiscing elit.
										Malesuada sodales quisque litora dapibus primis lacinia
									</div>
								</div>
							</div>
						</article>
						<article
							class="post-item post-grid rows-space-0 post-189 post type-post status-publish format-video has-post-thumbnail hentry category-table category-life-style tag-furniture tag-life-style post_format-post-format-video">
							<div class="post-inner">
								<div class="post-thumb">
									<a href="#" tabindex="0"> <img
										src="/template/web/assets/images/blogpost9-370x330.jpg"
										class="img-responsive attachment-370x330 size-370x330"
										alt="img" width="370" height="330">
									</a>
								</div>
								<div class="post-content">
									<div class="post-info">
										<div class="title-date">
											<a class="datebox" href="#" tabindex="0"> <span>19</span>
												<span>Dec</span>
											</a>
											<h2 class="post-title">
												<a href="#" tabindex="0">We design functional best
													furniture</a>
											</h2>
										</div>
										<div class="post-meta">
											<div class="post-author">
												By:<a href="#" tabindex="0"> admin </a>
											</div>
											<div class="post-comment-icon">
												<a href="#" tabindex="0"> 0 </a>
											</div>
										</div>
										Lorem ipsum dolor sit amet, consectetur adipiscing elit.
										Malesuada sodales quisque litora dapibus primis lacinia
									</div>
								</div>
							</div>
						</article>
						<article
							class="post-item post-grid rows-space-0 post-186 post type-post status-publish format-standard has-post-thumbnail hentry category-light category-life-style tag-life-style">
							<div class="post-inner">
								<div class="post-thumb">
									<a href="#" tabindex="-1"> <img
										src="/template/web/assets/images/blogpost4-370x330.jpg"
										class="img-responsive attachment-370x330 size-370x330"
										alt="img" width="370" height="330">
									</a>
								</div>
								<div class="post-content">
									<div class="post-info">
										<div class="title-date">
											<a class="datebox" href="#" tabindex="-1"> <span>19</span>
												<span>Dec</span>
											</a>
											<h2 class="post-title">
												<a href="#" tabindex="-1">The child is swimming with a
													buoy</a>
											</h2>
										</div>
										<div class="post-meta">
											<div class="post-author">
												By:<a href="#" tabindex="-1"> admin </a>
											</div>
											<div class="post-comment-icon">
												<a href="#" tabindex="-1">0 </a>
											</div>
										</div>
										Lorem ipsum dolor sit amet, consectetur adipiscing elit.
										Malesuada sodales quisque litora dapibus primis lacinia
									</div>
								</div>
							</div>
						</article>
						<article
							class="post-item post-grid rows-space-0 post-183 post type-post status-publish format-standard has-post-thumbnail hentry category-light category-fashion tag-light tag-furniture">
							<div class="post-inner">
								<div class="post-thumb">
									<a href="#" tabindex="-1"> <img
										src="/template/web/assets/images/blogpost2-370x330.jpg"
										class="img-responsive attachment-370x330 size-370x330"
										alt="img" width="370" height="330">
									</a>
								</div>
								<div class="post-content">
									<div class="post-info">
										<div class="title-date">
											<a class="datebox" href="#" tabindex="-1"> <span>19</span>
												<span>Dec</span>
											</a>
											<h2 class="post-title">
												<a href="#" tabindex="-1">Furniture hiding beside beige
													wall</a>
											</h2>
										</div>
										<div class="post-meta">
											<div class="post-author">
												By:<a href="#" tabindex="-1"> admin </a>
											</div>
											<div class="post-comment-icon">
												<a href="#" tabindex="-1"> 0 </a>
											</div>
										</div>
										Lorem ipsum dolor sit amet, consectetur adipiscing elit.
										Malesuada sodales quisque litora dapibus primis lacinia
									</div>
								</div>
							</div>
						</article>
					</div>
				</div>
			</div>
		</div>
		<div class="section-043 section-019">
			<div class="furgan-heading style-01">
				<div class="heading-inner">
					<h3 class="title">Follow Us On Instagram</h3>
					<div class="subtitle">@furganshop</div>
				</div>
			</div>
			<div class="furgan-instagram style-01">
				<div class="instagram-owl owl-slick"
					data-slick="{&quot;arrows&quot;:false,&quot;slidesMargin&quot;:0,&quot;dots&quot;:false,&quot;infinite&quot;:false,&quot;speed&quot;:300,&quot;slidesToShow&quot;:6,&quot;rows&quot;:1}"
					data-responsive="[{&quot;breakpoint&quot;:480,&quot;settings&quot;:{&quot;slidesToShow&quot;:2,&quot;slidesMargin&quot;:&quot;0&quot;}},{&quot;breakpoint&quot;:768,&quot;settings&quot;:{&quot;slidesToShow&quot;:3,&quot;slidesMargin&quot;:&quot;0&quot;}},{&quot;breakpoint&quot;:992,&quot;settings&quot;:{&quot;slidesToShow&quot;:4,&quot;slidesMargin&quot;:&quot;0&quot;}},{&quot;breakpoint&quot;:1200,&quot;settings&quot;:{&quot;slidesToShow&quot;:5,&quot;slidesMargin&quot;:&quot;0&quot;}},{&quot;breakpoint&quot;:1500,&quot;settings&quot;:{&quot;slidesToShow&quot;:6,&quot;slidesMargin&quot;:&quot;0&quot;}}]">
					<div class="rows-space-0">
						<a target="_blank" href="#" class="item  " tabindex="0"> <img
							class="img-responsive lazy"
							src="/template/web/assets/images/insta1.jpg" alt="Home 03">
							<span class="instagram-info"> <span class="social-wrap">
									<span class="social-info">1 <i class="flaticon-chat"></i>
								</span> <span class="social-info">0 <i
										class="flaticon-heart-shape-outline"></i>
								</span>
							</span>
						</span>
						</a>
					</div>
					<div class="rows-space-0">
						<a target="_blank" href="#" class="item  " tabindex="0"> <img
							class="img-responsive lazy"
							src="/template/web/assets/images/insta2.jpg" alt="Home 03">
							<span class="instagram-info"> <span class="social-wrap">
									<span class="social-info">1 <i class="flaticon-chat"></i>
								</span> <span class="social-info">0 <i
										class="flaticon-heart-shape-outline"></i>
								</span>
							</span>
						</span>
						</a>
					</div>
					<div class="rows-space-0">
						<a target="_blank" href="#" class="item  " tabindex="0"> <img
							class="img-responsive lazy"
							src="/template/web/assets/images/insta3.jpg" alt="Home 03">
							<span class="instagram-info"> <span class="social-wrap">
									<span class="social-info">1 <i class="flaticon-chat"></i>
								</span> <span class="social-info">0 <i
										class="flaticon-heart-shape-outline"></i>
								</span>
							</span>
						</span>
						</a>
					</div>
					<div class="rows-space-0">
						<a target="_blank" href="#" class="item  " tabindex="0"> <img
							class="img-responsive lazy"
							src="/template/web/assets/images/insta4.jpg" alt="Home 03">
							<span class="instagram-info"> <span class="social-wrap">
									<span class="social-info">1 <i class="flaticon-chat"></i>
								</span> <span class="social-info">0 <i
										class="flaticon-heart-shape-outline"></i>
								</span>
							</span>
						</span>
						</a>
					</div>
					<div class="rows-space-0">
						<a target="_blank" href="#" class="item  " tabindex="0"> <img
							class="img-responsive lazy"
							src="/template/web/assets/images/insta5.jpg" alt="Home 03">
							<span class="instagram-info"> <span class="social-wrap">
									<span class="social-info">1 <i class="flaticon-chat"></i>
								</span> <span class="social-info">0 <i
										class="flaticon-heart-shape-outline"></i>
								</span>
							</span>
						</span>
						</a>
					</div>
					<div class="rows-space-0">
						<a target="_blank" href="#" class="item  " tabindex="0"> <img
							class="img-responsive lazy"
							src="/template/web/assets/images/insta6.jpg" alt="Home 03">
							<span class="instagram-info"> <span class="social-wrap">
									<span class="social-info">1 <i class="flaticon-chat"></i>
								</span> <span class="social-info">0 <i
										class="flaticon-heart-shape-outline"></i>
								</span>
							</span>
						</span>
						</a>
					</div>
					<div class="rows-space-0">
						<a target="_blank" href="#" class="item  " tabindex="0"> <img
							class="img-responsive lazy"
							src="/template/web/assets/images/insta7.jpg" alt="Home 03">
							<span class="instagram-info"> <span class="social-wrap">
									<span class="social-info">1 <i class="flaticon-chat"></i>
								</span> <span class="social-info">0 <i
										class="flaticon-heart-shape-outline"></i>
								</span>
							</span>
						</span>
						</a>
					</div>
					<div class="rows-space-0">
						<a target="_blank" href="#" class="item  " tabindex="0"> <img
							class="img-responsive lazy"
							src="/template/web/assets/images/insta8.jpg" alt="Home 03">
							<span class="instagram-info"> <span class="social-wrap">
									<span class="social-info">1 <i class="flaticon-chat"></i>
								</span> <span class="social-info">0 <i
										class="flaticon-heart-shape-outline"></i>
								</span>
							</span>
						</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>







	<script type="text/javascript" charset="utf-8" >
	
	
	
	
	
	function swalAlert(mess,icon){
		
		Swal.fire({
			  position: 'top',
			  icon: icon,
			  title: mess,
			  showConfirmButton: false,
			  timer: 1500
			});
	}

/* if (${isLogin}!=null) {
	if(${isLogin}==true){
		Swal.fire({
			  position: 'top',
			  icon: 'success',
			  title: 'ban da dang nhap ',
			  showConfirmButton: false,
			  timer: 1500
			});
	}
} */


function flyToCart(imgtodrag,cart){
	
        var imgclone = imgtodrag.clone()
            .offset({
            top: imgtodrag.offset().top,
            left: imgtodrag.offset().left
        })
            .css({
            'opacity': '0.75',
                'position': 'absolute',
                'height': '150px',
                'width': '150px',
                'z-index': '100'
        })
            .appendTo($('body'))
            .animate({
            'top': cart.offset().top + 10,
                'left': cart.offset().left + 10,
                'width': 75,
                'height': 75
        }, 1000, 'easeInOutExpo');
        
        setTimeout(function () {
            cart.effect("shake", {
                times: 2
            }, 200);
        }, 1500);

        imgclone.animate({
            'width': 0,
                'height': 0
        }, function () {
            $(this).detach()
        });
    
	
	
}

function setInfo(){
	  $.get("/cart/getInfo/", function(data, status){
	 	$("#cart-total-items").html(data[0]);
	    $("#cart-total-price").html(data[1]);
 }); 
	
	
}

$('.btnAddToCart').click(function (e) {
	e.preventDefault(); 
   	
	var cart = $('.flaticon-cart');
    var imgtodrag = $(this).parents('.product-thumb').find(".thumb-link img");
    
    flyToCart(imgtodrag,cart);
	
    
    
    
	var id =($(this).attr("data-id"));
	
	
   	
   
    
    
    $.get("/cart/add2/"+id, function(data, status){
    	setInfo();
    	if (data!=" ") {
    		swalAlert(data,"success");
		}
    	
     });
    
   
    
    

    
	
});

$('.btnAddToWishlist').click(function (e) {
	e.preventDefault(); //huy bo su kien mac dinh cua trang 
   	var id =($(this).attr("data-id"));
	
	
    $.get("/wishlist/add/"+id, function(data, status){
        if (data) {
        	swalAlert("Đã thêm vào danh sách yêu thích","success");
		}
        else{
        	swalAlert("Sản phẩm đã tồn tại trong trong danh sách yêu thích","warning");
        }
      }); 
    
      
	
});


var totalPages = ${model.totalPage};
var currentPage = ${model.page};



$('#pagination').twbsPagination({
	totalPages: totalPages,
    visiblePages: 10,
    startPage: currentPage,
    onPageClick: function (event, page) {
    	
    	$('#pageT').val(page);
    	if (currentPage != page) {
    		
    		
    		/* $('#limit').val($(".dropdownLimit option:selected").val());*/
			
			
			$('#page').val(page);
			$('#formSubmit').submit();
		}
    }
}); 



$('select').on('change', function() {
	
	
	  $('#limit').val(this.value);
	  $('#page').val($('#pageT').val());
	  $('#formSubmit').submit();
	  
	  // cach 1 luwu seesion js cai value vua duoc chon 
	  //sessionStorage.setItem("select", this.value);
	 
	  
	  
	
	
	
	});
	window.addEventListener('load', (event) => {
		 ///casch 2 : set value cho cac select = du lieu tra ve ben controller 
		 $('select[name=limit]').val(${model.limit});
			
	
		//getSessionLimit();
	});

	//sau do get seesion ra roi set attr cho no la select
	function getSessionLimit(){
		
		let data = sessionStorage.getItem('select');
		  $('.dropdownLimit option[value='+data+']').attr('selected','selected');
		
	}
	
	
</script>


</body>
</html>





