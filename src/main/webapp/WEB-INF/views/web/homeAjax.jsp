<%@include file="/common/taglib.jsp"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<body>
	<div class="fullwidth-template">
	
	<br>
	<div class="section-011">
        <div class="container">
            <div class="furgan-heading style-01">
                <div class="heading-inner">
                    <h3 class="title">
                        Sản phẩm nổi bật </h3>
                    <div class="subtitle">
                        Những sản phẩm được khách hàng quan tâm xem nhiều nhất
                    </div>
                </div>
            </div>
            <div class="furgan-products style-04">
                <div class="response-product product-list-owl owl-slick equal-container better-height"
                     data-slick="{&quot;arrows&quot;:true,&quot;slidesMargin&quot;:30,&quot;dots&quot;:true,&quot;infinite&quot;:false,&quot;speed&quot;:300,&quot;slidesToShow&quot;:4,&quot;rows&quot;:1}"
                     data-responsive="[{&quot;breakpoint&quot;:480,&quot;settings&quot;:{&quot;slidesToShow&quot;:2,&quot;slidesMargin&quot;:&quot;10&quot;}},{&quot;breakpoint&quot;:768,&quot;settings&quot;:{&quot;slidesToShow&quot;:2,&quot;slidesMargin&quot;:&quot;10&quot;}},{&quot;breakpoint&quot;:992,&quot;settings&quot;:{&quot;slidesToShow&quot;:3,&quot;slidesMargin&quot;:&quot;20&quot;}},{&quot;breakpoint&quot;:1200,&quot;settings&quot;:{&quot;slidesToShow&quot;:3,&quot;slidesMargin&quot;:&quot;20&quot;}},{&quot;breakpoint&quot;:1500,&quot;settings&quot;:{&quot;slidesToShow&quot;:4,&quot;slidesMargin&quot;:&quot;30&quot;}}]">
                   <c:forEach var="item" items="${listInterested}">   
                    <div class="product-item recent-product style-04 rows-space-0 post-93 product type-product status-publish has-post-thumbnail product_cat-light product_cat-table product_cat-new-arrivals product_tag-table product_tag-sock first instock shipping-taxable purchasable product-type-simple  ">
                        <div class="product-inner tooltip-top tooltip-all-top">
                            <div class="product-thumb">
                                <a class="thumb-link"
                                   href="#" tabindex="0">
                                    <img class="img-responsive"
                                   
                                         src="/images/${item.img }"
                                         alt="Woody Table" width="270" height="350">
                                </a>
                                <div class="flash">
                                    <span class="onnew"><span class="text">New</span></span></div>
                                <div class="group-button">
                                    <div class="add-to-cart">
                                        <a href="#"
                                           class="button product_type_simple add_to_cart_button ajax_add_to_cart">Add to
                                            cart</a></div>
                                    <a href="#" class="button yith-wcqv-button">Quick View</a>
                                    <div class="furgan product compare-button">
                                        <a href="#" class="compare button">Compare</a>
                                    </div>
                                    <div class="yith-wcwl-add-to-wishlist">
                                        <div class="yith-wcwl-add-button show">
                                            <a href="#" class="add_to_wishlist">Add to Wishlist</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="product-info">
                                <h3 class="product-name product_title">
                                    <a href="#"
                                       tabindex="0">${item.name }</a>
                                </h3>
                                <span class="price"><span class="furgan-Price-amount amount"><span
                                        class="furgan-Price-currencySymbol">$</span>109.00</span></span>
                                <div class="rating-wapper nostar">
                                    <div class="star-rating"><span style="width:0%">Rated <strong
                                            class="rating">0</strong> out of 5</span></div>
                                    <span class="review">(0)</span></div>
                            </div>
                        </div>
                    </div>
                  </c:forEach>  
               
                </div>
            </div>
        </div>
    </div>
	
	
	<div class="section-011">
        <div class="container">
            <div class="furgan-heading style-01">
                <div class="heading-inner">
                    <h3 class="title">
                        Sản phẩm bán chạy nhất </h3>
                    
                </div>
            </div>
            <div class="furgan-products style-04">
                <div class="response-product product-list-owl owl-slick equal-container better-height"
                     data-slick="{&quot;arrows&quot;:true,&quot;slidesMargin&quot;:30,&quot;dots&quot;:true,&quot;infinite&quot;:false,&quot;speed&quot;:300,&quot;slidesToShow&quot;:4,&quot;rows&quot;:1}"
                     data-responsive="[{&quot;breakpoint&quot;:480,&quot;settings&quot;:{&quot;slidesToShow&quot;:2,&quot;slidesMargin&quot;:&quot;10&quot;}},{&quot;breakpoint&quot;:768,&quot;settings&quot;:{&quot;slidesToShow&quot;:2,&quot;slidesMargin&quot;:&quot;10&quot;}},{&quot;breakpoint&quot;:992,&quot;settings&quot;:{&quot;slidesToShow&quot;:3,&quot;slidesMargin&quot;:&quot;20&quot;}},{&quot;breakpoint&quot;:1200,&quot;settings&quot;:{&quot;slidesToShow&quot;:3,&quot;slidesMargin&quot;:&quot;20&quot;}},{&quot;breakpoint&quot;:1500,&quot;settings&quot;:{&quot;slidesToShow&quot;:4,&quot;slidesMargin&quot;:&quot;30&quot;}}]">
                   
                   <c:forEach var="item" items="${listBestSelling}">  
                    <div class="product-item recent-product style-04 rows-space-0 post-93 product type-product status-publish has-post-thumbnail product_cat-light product_cat-table product_cat-new-arrivals product_tag-table product_tag-sock first instock shipping-taxable purchasable product-type-simple  ">
                        <div class="product-inner tooltip-top tooltip-all-top">
                            <div class="product-thumb">
                                <a class="thumb-link"
                                   href="#" tabindex="0">
                                    <img class="img-responsive"
                                   
                                         src="/images/${item.img }"
                                         alt="Woody Table" width="270" height="350">
                                </a>
                                <div class="flash">
                                    <span class="onnew"><span class="text">New</span></span></div>
                                <div class="group-button">
                                    <div class="add-to-cart">
                                        <a href="#"
                                           class="button product_type_simple add_to_cart_button ajax_add_to_cart">Add to
                                            cart</a></div>
                                    <a href="#" class="button yith-wcqv-button">Quick View</a>
                                    <div class="furgan product compare-button">
                                        <a href="#" class="compare button">Compare</a>
                                    </div>
                                    <div class="yith-wcwl-add-to-wishlist">
                                        <div class="yith-wcwl-add-button show">
                                            <a href="#" class="add_to_wishlist">Add to Wishlist</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="product-info">
                                <h3 class="product-name product_title">
                                    <a href="#"
                                       tabindex="0">${item.name }</a>
                                </h3>
                                <span class="price"><span class="furgan-Price-amount amount"><span
                                        class="furgan-Price-currencySymbol">$</span>109.00</span></span>
                                <div class="rating-wapper nostar">
                                    <div class="star-rating"><span style="width:0%">Rated <strong
                                            class="rating">0</strong> out of 5</span></div>
                                    <span class="review">(0)</span></div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                
                </div>
            </div>
        </div>
    </div>
	
	
	
	<div class="section-001">
			<div class="container">
				<div class="furgan-heading style-01">
					<div class="heading-inner">
						<h3 class="title">Tất cả sản phẩm</h3>
						<div class="subtitle">Duyệt qua trang web của chúng tôi để tìm các mặt hàng nội thất hót nhất trên thị trường bây giờ.</div>

						<span><i class="shoppinggg-cart"></i></span>
					</div>
				</div>
				
				<ul  class="dropdown2-menu" style="list-style-type: none; margin: 0; padding: 0;overflow: hidden;background-color: burlywood;">	
					<c:forEach var="item" items="${sessionScope.listCategory2}"> 
						<li id="${item.code}" style="float: left;" >
						<a  style="display: block; color: white;text-align: center;padding: 14px 56px;text-decoration: none;" 
							>${item.name}
						</a>
						</li>								
					</c:forEach>	
				</ul>
				
				<br>
				
				<div style="display: flex; justify-content: center;" class=""> 
			
				<div> <label for="cars">Hiển thị số sản phẩm</label> </div>
				<div class="">
				
				<div class="dropdownLimit">
					<select name="limit">
						<option value="5">5</option>
						<option value="10">10</option>
						<option value="15">15</option>
						<option value="20">20</option>
					</select>
				</div>
				</div>
				
				<div class="">
				<select name="orderBy" class="form-select" aria-label="Default select example">
				  <option value="" selected>Sắp xếp theo</option>
				  <option value="2">------Phổ biến------</option>
				  <option value="1">------Mới nhất------</option>
				  <option value="3">------Bán chạy------</option>
				</select>
				
				</div>
				
				<div class="">
				<select name="priceBy" class="form-select" aria-label="Default select example">
				  <option value="" selected>Giá</option>
				  <option value="Asc">Từ thấp đến cao</option>
				  <option value="Desc">Từ cao đến thấp</option>
				</select>
				</div>
				
				
				<div style="">
				<select name="category" class="form-select" aria-label="Default select example">
				<option selected>Danh muc</option>
				<c:forEach var="item" items="${sessionScope.listCategory2}"> 
					 <option value="${item.code}">${item.name}</option>  
				</c:forEach>
				</select>
				</div>
				
				</div>
				<br>
		


				<div class="furgan-products style-04">
					<form action="<c:url value='/trang-chu'/>" id="formSubmit"method="get">
						<div id="mylocation" class="proAppend response-product product-list-grid row auto-clear equal-container better-height ">
							<c:forEach var="item" items="${listProEntity}">  <!-- model.listResult -->
								<div
									class="product-item best-selling style-04 rows-space-30 col-bg-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-ts-6 post-25 product type-product status-publish has-post-thumbnail product_cat-light product_cat-chair product_cat-specials product_tag-light product_tag-sock first instock sale featured shipping-taxable purchasable product-type-simple">
									<div class="product-inner tooltip-top tooltip-all-top">
										<div class="product-thumb">
											<a class="thumb-link" href="/san-pham/${item.slug}"> <img
												class="img-responsive"
												src="<c:url value="/images"/>/${item.img}"
												alt="Office Chair" width="270" height="350">
											</a>
											<div class="flash">
												<span class="onsale"><span class="number">-${item.discount}%</span></span>
												<span class="onnew"><span class="text">New</span></span>
											</div>

											<div class="variations_form cart">
			                                    <table class="variations">
			                                        <tbody>
			                                        <tr>
			                                            <td class="value">
			                                                <select title="box_style" data-attributetype="box_style" data-id="pa_color" class="attribute-select "  data-show_option_none="yes">
			                                                    <option data-type="" data-pa_color="" value="">Choose an option
			                                                    </option>
			                                                    <option data-width="30" data-height="30" data-type="color" data-pa_color="#ff63cb" value="pink" class="">
			                                                    
			                                                    </option>
			                                                    <option data-width="30" data-height="30" data-type="color" data-pa_color="#a825ea" value="purple" class="attached enabled">Purple
			                                                    </option>
			                                                    <option data-width="30" data-height="30" data-type="color" data-pa_color="#db2b00" value="red" class="attached enabled">Red
			                                                    </option>
			                                                </select>
			                                                <div class="data-val attribute-pa_color" data-attributetype="box_style">
				                                                <c:forEach var="item2" items="${item.product_detailGroupByColor}">  
	                                                            <a class="change-value color" href="#"  style="background: ${item2.color.code};" data-value="red">  </a>      
	                                                            </c:forEach>
			                                                </div>
			                                                <a class="reset_variations" href="#" style="visibility: hidden;">Clear</a>
			                                            </td>
			                                        </tr>
			                                        </tbody>
			                                    </table>
                                			</div>

											<div class="variations_form2 cart">
                                                <table class="variations">
                                                    <tbody>
                                                    <tr>
                                                        <td class="value">
                                                            <select title="box_style" data-attributetype="box_style" data-id="pa_color" class="attribute-select "  data-show_option_none="yes">
                                                                <option data-type="" data-pa_color="" value="">Choose an
                                                                    option
                                                                </option>
                                                                <option data-width="30" data-height="30" data-type="color" data-pa_color="#000000" value="black" class="attached enabled">Black
                                                                </option>
                                                                <option data-width="30" data-height="30" data-type="color" data-pa_color="#db2b00" value="red" class="attached enabled">Red
                                                                </option>
                                                            </select>
                                                            <div class="data-val attribute-pa_color" data-attributetype="box_style">
	                                                            <c:forEach var="item2" items="${item.product_detailGroupBySize}">  
	                                                            	<a class="change-value color" href="#"  data-value="red"> ${item2.size.name} </a>
	                                                            </c:forEach>
                                                            </div>
                                                            <a class="reset_variations" href="#" style="visibility: hidden;">Clear</a></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
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
												<a href="/san-pham/${item.slug}">${item.name}</a>			 
											</h3>
											<span class="price">
											
											<c:if test="${item.discount==0}">
											
												<ins>
														<span class="furgan-Price-amount amount"><f:formatNumber value="${item.price} "   pattern="###,###" /> &nbsp;₫
														</span>
												</ins>
											</c:if>
											
											<c:if test="${item.discount>0}">
											
												<ins>
														<del>
													<span class="furgan-Price-amount amount"><f:formatNumber value="${item.price} "   pattern="###,###" /> &nbsp;₫
													</span>
											</del> 
											<ins>
													<span class="furgan-Price-amount amount"><f:formatNumber value="${(item.price  * ((100 - item.discount))) / 100} "   pattern="###,###" /> &nbsp;₫
													</span>
											</ins>
												</ins>
											</c:if>
											
											
											
											</span>
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

						<div id="DanhmucMa"> <input type="hidden" id="cateCode" name="danh-muc" /> </div>
						 <input type="hidden" value="${page}" id="page" name="page" /> 
						<input type="hidden" value="${limit}" id="limit" name="limit" /> 
						<div class="shop-all"><a href="" class="" id="loadMore"> Xem thêm</a></div>			
					</form>
					<input type="hidden" value="" id="pageT" name="pageT" /> 
				</div>
			</div>
		</div>
		
		
		
	</div>







<script type="text/javascript" charset="utf-8" >
page=1;

$(document).ready(function()  {
		    $('.dropdown2-menu li').click(function(e) 
		    { 
		    	cate=(this.id); 
		    	//c2 alert($(this).attr('id'));
		    	
		    	$("select[name=category]").val(cate);
				
				 var limit=$('select[name=limit]').val();
				 $('#limit').val(limit);
				 $.get("/ajax/getLstProduct", {
				    	page : 1,
				    	limit : limit,
				    	cate : cate
				    }, function(data) {  		
				    	$("#mylocation").html(data);	    
				    }); 
				 
		    });
});
		 
		 
	function swalAlert(mess,icon){
	Swal.fire({
			  position: 'top',
			  icon: icon,
			  title: mess,
			  showConfirmButton: false,
			  timer: 1500
			});
	}
	page=1;
	

	$( document ).ready(function(e) {
		/* css của ô search .ui-autocomplete {  max-height: 200px; overflow-y: auto; overflow-x: hidden;
  		var DataSearchAutocomplete = '${DataSearchAutocomplete}'.replace('[','').replace(']','').split(',');
  		$( "#site-search" ).autocomplete({ source: DataSearchAutocomplete}); */
		//$('select[name=limit]').val(${limit});
  		
		$("#loadMore").text("Xem thêm");
		
		//Fixed Header on Scroll
		window.onscroll = function() {myFunction()};

		var header = document.getElementById("myHeader");
		var sticky = header.offsetTop;

		function myFunction() {
		  if (window.pageYOffset > sticky) {
		    header.classList.add("sticky");
		    $( "#myHeader" ).addClass("sticky");
		  } else {
		    header.classList.remove("sticky"); 
		  }
		}  
	}); 
	
	
	$('select[name=limit]').on('change', function() {
		page=1;
		$("#loadMore").text("Xem thêm");
		 var limit=this.value;
		 $('#limit').val(limit);
		 $.get("/ajax/getLstProduct", {
		    	page : 1,
		    	limit : limit,
		    	cate : $('#cateCode').val()
		    }, function(data) {  		
		    	$("#mylocation").html(data);	    
		    }); 
		 
     });
	
	
	$('select[name=orderBy]').on('change', function() {
		page=1;
		$("#loadMore").text("Xem thêm");
		console.log($('select[name=limit]').val());
		 var oderBy=this.value;
		 var search=$("#site-search").val();
		 
		  $.get("/ajax/getLstProduct", {
		    	page : 1,
		    	limit : $('select[name=limit]').val(),
		    	cate : $('#cateCode').val(),
		    	orderBy : oderBy
		    }, function(data) {  		
		    	$("#mylocation").html(data);	    
		  });  
	});
	
	
	$('select[name=priceBy]').on('change', function() {
		page=1;
		console.log($('select[name=limit]').val());
		$("#loadMore").text("Xem thêm");
		 var typePrice=this.value;
		 var search=$("#site-search").val();
		  $.get("/ajax/getLstProduct", {
		    	page : 1,
		    	limit : $('select[name=limit]').val(),
		    	cate : $('#cateCode').val(),
		    	typePrice : typePrice
		    }, function(data) {  		
		    	$("#mylocation").html(data);	    
		  });  
	});
	
	$('select[name=category]').on('change', function() {
		page=1;
		$("#loadMore").text("Xem thêm");
		 var cate=this.value;
		 $('#cateCode').val(cate);
		 $.get("/ajax/getLstProduct", {
		    	page : 1,
		    	limit :  $('select[name=limit]').val(),
		    	cate :cate
		    }, function(data) {  		
		    	$("#mylocation").html(data);	    
		 }); 		  
	});
	
	
	
	$('#loadMore').click(function (e){
		e.preventDefault();
		page++;
		 var search=$("#site-search").val(); 
		 var typePrice=$('select[name=priceBy]').val(); 
		 var oderBy=$('select[name=orderBy]').val();
			console.log(typePrice);
			console.log(oderBy);
			console.log(oderBy==null);
			console.log(oderBy=="");
	     $.get("/ajax/getLstProduct", {
	    	page : page,
	    	limit : $('select[name=limit]').val(),
	    	cate : $('#cateCode').val(),
	    	typePrice : typePrice,
	    	oderBy :oderBy	    	
	    }, function(data) {
        		if(data.length<3){
        			$("#loadMore").text("Đã hết sản phẩm");
        		}else{
        			$("#mylocation").append(data);      	
        			/* if (typePrice=="" && oderBy =="" ) {
        				$("#mylocation").append(data);
					} 
        			else{
        				$("#mylocation").html(data);      				
        			} */
        			
        			
        		}
		});     	 
	});
	
	
</script>
</body>
</html>





