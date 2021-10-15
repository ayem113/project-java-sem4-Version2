<%-- <%@include file="/common/taglib.jsp"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<c:forEach var="item" items="${listProEntity}">
	<!-- model.listResult -->


	<div
		class="product-item best-selling style-04 rows-space-30 col-bg-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-ts-6 post-25 product type-product status-publish has-post-thumbnail product_cat-light product_cat-chair product_cat-specials product_tag-light product_tag-sock first instock sale featured shipping-taxable purchasable product-type-simple">
		<div class="product-inner tooltip-top tooltip-all-top">
			<div class="product-thumb">
				<a class="thumb-link" href="#"> <img class="img-responsive"
					src="/template/web/assets/images/apro151-1-270x350.jpg"
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
								<td class="value"><select title="box_style"
									data-attributetype="box_style" data-id="pa_color"
									class="attribute-select " data-show_option_none="yes">
										<option data-type="" data-pa_color="" value="">Choose
											an option</option>
										<option data-width="30" data-height="30" data-type="color"
											data-pa_color="#ff63cb" value="pink" class=""></option>
										<option data-width="30" data-height="30" data-type="color"
											data-pa_color="#a825ea" value="purple"
											class="attached enabled">Purple</option>
										<option data-width="30" data-height="30" data-type="color"
											data-pa_color="#db2b00" value="red" class="attached enabled">Red
										</option>
								</select>
									<div class="data-val attribute-pa_color"
										data-attributetype="box_style">

										<c:forEach var="item2"
											items="${item.product_detailGroupByColor}">




											<a class="change-value color" href="#"
												style="background: ${item2.color.code};" data-value="red">
											</a>

										</c:forEach>


									</div> <a class="reset_variations" href="#"
									style="visibility: hidden;">Clear</a></td>
							</tr>
						</tbody>
					</table>
				</div>





				<div class="variations_form2 cart">
					<table class="variations">
						<tbody>
							<tr>
								<td class="value"><select title="box_style"
									data-attributetype="box_style" data-id="pa_color"
									class="attribute-select " data-show_option_none="yes">
										<option data-type="" data-pa_color="" value="">Choose
											an option</option>
										<option data-width="30" data-height="30" data-type="color"
											data-pa_color="#000000" value="black"
											class="attached enabled">Black</option>
										<option data-width="30" data-height="30" data-type="color"
											data-pa_color="#db2b00" value="red" class="attached enabled">Red
										</option>
								</select>


									<div class="data-val attribute-pa_color"
										data-attributetype="box_style">

										<c:forEach var="item2" items="${item.product_detail}">


											<a class="change-value color" href="#" data-value="red">
												${item2.size.name} </a>

										</c:forEach>
									</div> <a class="reset_variations" href="#"
									style="visibility: hidden;">Clear</a></td>
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
							<a data-id='${item.id}' class="btnAddToWishlist add_to_wishlist">Add
								to Wishlist</a>
						</div>
					</div>
				</div>
			</div>
			<div class="product-info">

				<h3 class="product-name product_title">

					<a href="/san-pham/${item.slug}">${item.name}</a>



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
 --%>