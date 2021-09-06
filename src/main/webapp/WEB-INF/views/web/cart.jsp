<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<div class="banner-wrapper has_background">
	
	<div class="banner-wrapper-inner">
		<h1 class="page-title">Cart</h1>
		<div role="navigation" aria-label="Breadcrumbs"
			class="breadcrumb-trail breadcrumbs">
			<ul class="trail-items breadcrumb">
				<li class="trail-item trail-begin"><a href="index.html"><span>Home</span></a></li>
				<li class="trail-item trail-end active"><span>Cart</span></li>
			</ul>
		</div>
	</div>
</div>
<main class="site-main main-container no-sidebar">
	<div class="container">
		<div class="row">
			<div class="main-content col-md-12">
				<div class="page-main-content">
					<div class="furgan">
						<div class="furgan-notices-wrapper"></div>
							<table
								class="ProTabale   shop_table shop_table_responsive cart furgan-cart-form__contents"
								>
								<thead>
									<tr>
										<th class="product-remove">Xoa</th>
										<th class="product-thumbnail">Anh</th>
										<th class="product-name">Product</th>
										<th class="product-price">Price</th>
										<th class="product-price">Discount</th>
										
										<th class="product-quantity">Quantity</th>
										<th class="product-subtotal">Total</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach var="p" items="${sessionScope['scopedTarget.cartService'].all}">



										<tr class="furgan-cart-form__cart-item cart_item">
											<td class="product-remove"><a href="#" class="remove btnRemove"
												aria-label="Remove this item" data-product_id="27"
												data-id="${p.id}">×</a></td>
												
											<td class="product-thumbnail"><a href="#"><img
													src="<c:url value="/images"/>/${p.img }"
													class="attachment-furgan_thumbnail size-furgan_thumbnail"
													alt="img" width="600" height="778"></a></td>
											<td class="product-name" data-title="Product"><a
												href="#">${p.name}</a></td>
											<td class="product-price" data-title="Price"><span
												class="furgan-Price-amount amount"><span
													class="furgan-Price-currencySymbol"></span>${p.price}</span></td>
											
											<td class="product-price" data-title="Discount"><span
												class="furgan-Price-amount amount"><span
													class="furgan-Price-currencySymbol">%</span>${p.discount}</span></td>
											
											<td class="" data-title="Quantity">
												<div class="">
													<span class="qty-label">Quantiy:</span>
													<div class="">
														<input data-id="${p.id}" data-price="${p.price}"  data-discount="${p.discount}" class="inputQuantity"  type="number" min=1 value="${p.quantity}" title="Qty"> 
													</div>
												</div>
											</td>
											<td class="product-subtotal" data-title="Total">
											<span 
												class="furgan-Price-amount amount   span-singer-price">
												<span class="furgan-Price-currencySymbol"></span> 
												${(p.price * p.quantity * ((100 - p.discount))) / 100}
											 </span>
											 </td>
										</tr>
									</c:forEach>
									
 									
 									<tr>
                                    <td colspan="12" class="">
                                        <div class="">
                                        
                                        	
                                            <label style="margin-right: 877px; margin-left: 60px;" for="Tổng tiền là">Tổng tiền là:</label> 
                                            <button  type="submit" class="  btn-totalPrice button btn btn-warning" name="apply_coupon" value="Apply coupon">${sessionScope['scopedTarget.cartService'].totalPrice}</button>
                                        </div>
                                      
                               		 </tr>
                               		 
								</tbody>
							</table>
							<button  class="button btn btn-info btnClear" >Làm trống giỏ hàng </button>
                                         <button  class="button btn btn-success btnCheckout" >Thanh toán ngay  </button>
						
						<div class="col-md-12 col-sm-12 dreaming_crosssell-product">
							<div class="block-title">
								<h2 class="product-grid-title">
									<span>Cross Sell Products</span>
								</h2>
							</div>
							<div class="owl-slick owl-products equal-container better-height"
								data-slick="{&quot;arrows&quot;:false,&quot;slidesMargin&quot;:30,&quot;dots&quot;:true,&quot;infinite&quot;:false,&quot;slidesToShow&quot;:4}"
								data-responsive="[{&quot;breakpoint&quot;:480,&quot;settings&quot;:{&quot;slidesToShow&quot;:2,&quot;slidesMargin&quot;:&quot;10&quot;}},{&quot;breakpoint&quot;:768,&quot;settings&quot;:{&quot;slidesToShow&quot;:2,&quot;slidesMargin&quot;:&quot;10&quot;}},{&quot;breakpoint&quot;:992,&quot;settings&quot;:{&quot;slidesToShow&quot;:3,&quot;slidesMargin&quot;:&quot;20&quot;}},{&quot;breakpoint&quot;:1200,&quot;settings&quot;:{&quot;slidesToShow&quot;:3,&quot;slidesMargin&quot;:&quot;20&quot;}},{&quot;breakpoint&quot;:1500,&quot;settings&quot;:{&quot;slidesToShow&quot;:3,&quot;slidesMargin&quot;:&quot;30&quot;}}]">
								<div
									class="product-item style-01 post-278 page type-page status-publish hentry">
									<div class="product-inner tooltip-left">
										<div class="product-thumb">
											<a class="thumb-link" href="#" tabindex="0"> <img
												class="img-responsive"
												src="assets/images/apro51012-1-600x778.jpg" alt="Long Sofa"
												width="600" height="778">
											</a>
											<div class="flash">
												<span class="onsale"><span class="number">-21%</span></span>
												<span class="onnew"><span class="text">New</span></span>
											</div>
											<div class="group-button">
												<div class="yith-wcwl-add-to-wishlist">
													<div class="yith-wcwl-add-button show">
														<a href="#" class="add_to_wishlist"> Add to Wishlist</a>
													</div>
												</div>
												<div class="furgan product compare-button">
													<a href="#" class="compare button">Compare</a>
												</div>
												<a href="#" class="button yith-wcqv-button">Quick View</a>
												<div class="add-to-cart">
													<a href="#"
														class="button product_type_simple add_to_cart_button ajax_add_to_cart">Add
														to cart </a>
												</div>
											</div>
										</div>
										<div class="product-info equal-elem">
											<h3 class="product-name product_title">
												<a href="#" tabindex="0">Long Sofa</a>
											</h3>
											<div class="rating-wapper nostar">
												<div class="star-rating">
													<span style="width: 0%">Rated <strong class="rating">0</strong>
														out of 5
													</span>
												</div>
												<span class="review">(0)</span>
											</div>
											<span class="price"><del>
													<span class="furgan-Price-amount amount"><span
														class="furgan-Price-currencySymbol">$</span>125.00</span>
												</del> <ins>
													<span class="furgan-Price-amount amount"><span
														class="furgan-Price-currencySymbol">$</span>99.00</span>
												</ins></span>
										</div>
									</div>
								</div>
								<div
									class="product-item style-01 post-36 product type-product status-publish has-post-thumbnail product_cat-table product_cat-bed product_tag-light product_tag-table product_tag-sock first instock sale shipping-taxable purchasable product-type-simple">
									<div class="product-inner tooltip-left">
										<div class="product-thumb">
											<a class="thumb-link" href="#" tabindex="0"> <img
												class="img-responsive"
												src="assets/images/apro71-1-600x778.jpg" alt="Moss Sofa"
												width="600" height="778">
											</a>
											<div class="flash">
												<span class="onsale"><span class="number">-18%</span></span>
												<span class="onnew"><span class="text">New</span></span>
											</div>
											<div class="group-button">
												<div class="yith-wcwl-add-to-wishlist">
													<div class="yith-wcwl-add-button show">
														<a href="#" class="add_to_wishlist"> Add to Wishlist</a>
													</div>
												</div>
												<div class="furgan product compare-button">
													<a href="#" class="compare button">Compare</a>
												</div>
												<a href="#" class="button yith-wcqv-button">Quick View</a>
												<div class="add-to-cart">
													<a href="#"
														class="button product_type_simple add_to_cart_button ajax_add_to_cart">Add
														to cart </a>
												</div>
											</div>
										</div>
										<div class="product-info equal-elem">
											<h3 class="product-name product_title">
												<a href="#" tabindex="0">Moss Sofa</a>
											</h3>
											<div class="rating-wapper nostar">
												<div class="star-rating">
													<span style="width: 0%">Rated <strong class="rating">0</strong>
														out of 5
													</span>
												</div>
												<span class="review">(0)</span>
											</div>
											<span class="price"><del>
													<span class="furgan-Price-amount amount"><span
														class="furgan-Price-currencySymbol">$</span>109.00</span>
												</del> <ins>
													<span class="furgan-Price-amount amount"><span
														class="furgan-Price-currencySymbol">$</span>89.00</span>
												</ins></span>
										</div>
									</div>
								</div>
								<div
									class="product-item style-01 post-32 product type-product status-publish has-post-thumbnail product_cat-light product_cat-chair product_cat-sofas product_tag-hat product_tag-sock  instock sale featured shipping-taxable purchasable product-type-simple">
									<div class="product-inner tooltip-left">
										<div class="product-thumb">
											<a class="thumb-link" href="#" tabindex="0"> <img
												class="img-responsive"
												src="assets/images/apro91-1-600x778.jpg" alt="DAX Armchair"
												width="600" height="778">
											</a>
											<div class="flash">
												<span class="onnew"><span class="text">New</span></span>
											</div>
											<div class="group-button">
												<div class="yith-wcwl-add-to-wishlist">
													<div class="yith-wcwl-add-button show">
														<a href="#" class="add_to_wishlist"> Add to Wishlist</a>
													</div>
												</div>
												<div class="furgan product compare-button">
													<a href="#" class="compare button">Compare</a>
												</div>
												<a href="#" class="button yith-wcqv-button">Quick View</a>
												<div class="add-to-cart">
													<a href="#"
														class="button product_type_simple add_to_cart_button ajax_add_to_cart">Add
														to cart </a>
												</div>
											</div>
										</div>
										<div class="product-info equal-elem">
											<h3 class="product-name product_title">
												<a href="#" tabindex="0">DAX Armchair</a>
											</h3>
											<div class="rating-wapper nostar">
												<div class="star-rating">
													<span style="width: 0%">Rated <strong class="rating">0</strong>
														out of 5
													</span>
												</div>
												<span class="review">(0)</span>
											</div>
											<span class="price"><span
												class="furgan-Price-amount amount"><span
													class="furgan-Price-currencySymbol">$</span>89.00</span> – <span
												class="furgan-Price-amount amount"><span
													class="furgan-Price-currencySymbol">$</span>139.00</span></span>
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
</main>





<script type="text/javascript">

$(".inputQuantity").on("input", function(e) {
	   e.preventDefault();
	   var _this = this;
		var quantity =$(this).val();
		var id =($(this).attr("data-id"));
		var price =($(this).attr("data-price"));
		var discount =($(this).attr("data-discount"));
	
		
		/* $(this).parents('.furgan-cart-form__cart-item cart_item').find(".span-singer-price").html("cc");
		
		console.log($(this).parents('.furgan-cart-form__cart-item').children(".furgan-Price-amount.amount.span-singer-price"));
		console.log(quantity);
		$(this).closest("tr").find("td.span.span-singer-price").html(quantity*price* ((100 - discount) / 100));
    	
    	$(this).find(".span-singer-price").html(quantity*price* ((100 - discount) / 100)); */
    	
		
		//$(this).parents('tr').find("span.span-singer-price").html(quantity*price* ((100 - discount) / 100));
	    $.get("/cart/update/"+id+"/"+quantity, function(data, status){
	    	console.log(this);
	    		
	    	$(_this).parents('tr').find("span.span-singer-price").html(quantity*price* ((100 - discount) / 100));
	    	
	    	
	    	
	    	$(".btn-totalPrice").text(data[1]);
	      });
	   
	});

$('.btnClear').click(function (e) {
	e.preventDefault(); 
	var id =($(this).attr("data-id"));
    $.get("/cart/clear/", function(data, status){
    	 	$("#cart-total-items").html(0);
    	    $("#cart-total-price").html(0);
    	    $("table>tbody ").html("");
      });
});

$('.btnRemove').click(function (e) {
	e.preventDefault(); 
	var id =($(this).attr("data-id"));
    $.get("/cart/remove/"+id, function(data, status){
    	$("#cart-total-items").html(data[0]);
	    $("#cart-total-price").html(data[1]);
	    //load lai table c1
	   // $(".ProTabale").load("http://localhost:8080/gio-hang/danh-sach" + " .ProTabale");
      });
    //load table cach 2 
      $(this).closest("tr").remove();
});


$('.btnRemove').click(function (e) {
	e.preventDefault(); 
	var id =($(this).attr("data-id"));
    $.get("/cart/remove/"+id, function(data, status){
    	$("#cart-total-items").html(data[0]);
	    $("#cart-total-price").html(data[1]);
	    //load lai table c1
	   // $(".ProTabale").load("http://localhost:8080/gio-hang/danh-sach" + " .ProTabale");
      });
    //load table cach 2 
      $(this).closest("tr").remove();
});
$('.btnCheckout').click(function (e) {
	window.location.href = "http://localhost:8080/thanh-toan";
});

</script>