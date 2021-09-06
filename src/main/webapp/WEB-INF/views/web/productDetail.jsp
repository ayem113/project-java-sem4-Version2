<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp"%>
<div class="single-thumb-vertical main-container shop-page no-sidebar">




<c:forEach var="item" items="${listWishlist}"> 

			<div> ${item.name }</div>
			<div> ${item.price }</div>
 
</c:forEach>

		
			

    <div class="container">
        <div class="row">
            <div class="main-content col-md-12">
                <div class="furgan-notices-wrapper"></div>
                <div id="product-27"
                     class="post-27 product type-product status-publish has-post-thumbnail product_cat-table product_cat-new-arrivals product_cat-lamp product_tag-table product_tag-sock first instock shipping-taxable purchasable product-type-variable has-default-attributes">
                    <div class="main-contain-summary">
                        <div class="contain-left has-gallery">
                            <div class="single-left">
                                <div class="furgan-product-gallery furgan-product-gallery--with-images furgan-product-gallery--columns-4 images">
                                    <a href="#" class="furgan-product-gallery__trigger">
                                        <img draggable="false" class="emoji" alt="🔍"
                                             src="https://s.w.org/images/core/emoji/11/svg/1f50d.svg"></a>
                                    <div class="flex-viewport">
                                        <figure class="furgan-product-gallery__wrapper">
                                            <div class="furgan-product-gallery__image">
                                                <img src="<c:url value="/images"/>/${productDetail.img }"/>
                                                
                                                
                                            </div>
                                            <div class="furgan-product-gallery__image">
                                                <img src="assets/images/apro134-1.jpg"
                                                     alt="img">
                                            </div>
                                            <div class="furgan-product-gallery__image">
                                                <img src="assets/images/apro132-1.jpg"
                                                     class="" alt="img">
                                            </div>
                                            <div class="furgan-product-gallery__image">
                                                <img src="assets/images/apro133-1.jpg"
                                                     class="" alt="img">
                                            </div>
                                        </figure>
                                    </div>
                                    <ol class="flex-control-nav flex-control-thumbs">
                                        <li><img src="<c:url value="/images"/>/${productDetail.img }"/>
                                        </li>
                                        <li><img
                                                src="assets/images/apro134-1-100x100.jpg" alt="img">
                                        </li>
                                        <li><img
                                                src="assets/images/apro132-1-100x100.jpg" alt="img">
                                        </li>
                                        <li><img
                                                src="assets/images/apro133-1-100x100.jpg" alt="img">
                                        </li>
                                    </ol>
                                </div>
                            </div>
                            <div class="summary entry-summary">
                                <div class="flash">
                                    <span class="onnew"><span class="text">New</span></span></div>
                                <h1 class="product_title entry-title">${productDetail.name }</h1>
                                <p class="price">
                                    <del><span class="furgan-Price-amount amount"><span class="furgan-Price-currencySymbol">$</span>${productDetail.price }</span></del>
                                    <ins><span class="furgan-Price-amount amount"><span class="furgan-Price-currencySymbol">$</span>${productDetail.sale }</span></ins>
                                </p>
                                <p class="stock out-stock">  <!-- class="stock out-stock" -->
                                    Availability: <span> In stock</span>
                                </p>
                                <div class="furgan-product-details__short-description">
                                    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac
                                        turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor
                                        sit amet, ante.</p>
                                    <ul>
                                        <li>Water-resistant fabric with soft lycra detailing inside</li>
                                        <li>CLean zip-front, and three piece hood</li>
                                        <li>Subtle branding and diagonal panel detail</li>
                                    </ul>
                                </div>
                                <form class="variations_form cart">
                                    <div class="single_variation_wrap">
                                        <div class="furgan-variation single_variation"></div>
                                        <div class="furgan-variation-add-to-cart variations_button furgan-variation-add-to-cart-disabled">
                                            <div class="quantity">
                                                <span class="qty-label">Quantiy: ${productDetail.quantity }</span>
                                                <div class="control">
                                                    <a class="btn-number qtyminus quantity-minus" href="#">-</a>
                                                    <input type="text" data-step="1" min="0" max="" name="quantity[25]" value="0" title="Qty" class="input-qty input-text qty text" size="4" pattern="[0-9]*" inputmode="numeric">
                                                    <a class="btn-number qtyplus quantity-plus" href="#">+</a>
                                                </div>
                                            </div>
                                            <button type="submit"
                                                    class="single_add_to_cart_button button alt disabled furgan-variation-selection-needed">
                                                Add to cart
                                            </button>
                                            <input name="add-to-cart" value="27" type="hidden">
                                            <input name="product_id" value="27" type="hidden">
                                            <input name="variation_id" class="variation_id" value="0" type="hidden">
                                        </div>
                                    </div>
                                </form>
                                <div class="yith-wcwl-add-to-wishlist">
                                    <div class="yith-wcwl-add-button show">
                                        <a href="#" rel="nofollow"
                                           data-product-id="27" data-product-type="variable" class="add_to_wishlist">
                                            Add to Wishlist</a>
                                    </div>
                                </div>
                                <div class="clear"></div>
                                <a href="#"
                                   class="compare button" data-product_id="27" rel="nofollow">Compare</a>
                                <div class="product_meta">
                                    <div class="wcml-dropdown product wcml_currency_switcher">
                                        <ul>
                                            <li class="wcml-cs-active-currency">
                                                <a class="wcml-cs-item-toggle">USD</a>
                                                <ul class="wcml-cs-submenu">
                                                    <li>
                                                        <a>EUR</a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </div>
                                    <span class="sku_wrapper">SKU: <span class="sku">885B712</span></span>
                                    <span class="posted_in">Categories: <a
                                            href="#"
                                            rel="tag">Table</a>, <a
                                            href="#" rel="tag">New arrivals</a>, <a
                                            href="#" rel="tag">Lamp</a></span>
                                    <span class="tagged_as">Tags: <a href="#"
                                                                     rel="tag">Table</a>, <a
                                            href="#" rel="tag">Sock</a></span>
                                </div>
                                <div class="furgan-share-socials">
                                    <h5 class="social-heading">Share: </h5>
                                    <a target="_blank" class="facebook" href="#">
                                        <i class="fa fa-facebook-f"></i>
                                    </a>
                                    <a target="_blank" class="twitter"
                                       href="#"><i class="fa fa-twitter"></i>
                                    </a>
                                    <a target="_blank" class="pinterest"
                                       href="#"> <i class="fa fa-pinterest"></i>
                                    </a>
                                    <a target="_blank" class="googleplus"
                                       href="#"><i class="fa fa-google-plus"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="furgan-tabs furgan-tabs-wrapper">
                        <ul class="tabs dreaming-tabs" role="tablist">
                            <li class="description_tab active" id="tab-title-description" role="tab"
                                aria-controls="tab-description">
                                <a href="#tab-description">Description</a>
                            </li>
                            <li class="additional_information_tab" id="tab-title-additional_information" role="tab"
                                aria-controls="tab-additional_information">
                                <a href="#tab-additional_information">Additional information</a>
                            </li>
                            <li class="reviews_tab" id="tab-title-reviews" role="tab" aria-controls="tab-reviews">
                                <a href="#tab-reviews">Reviews (0)</a>
                            </li>
                        </ul>
                        <div class="furgan-Tabs-panel furgan-Tabs-panel--description panel entry-content furgan-tab"
                             id="tab-description" role="tabpanel" aria-labelledby="tab-title-description">
                            <h2>Description</h2>
                            <div class="container-table">
                                <div class="container-cell">
                                    <h2 class="az_custom_heading">Platea viverra aenean<br>dictumst</h2>
                                    <p>Lorem ipsum dolor sit amet consectetur adipiscing elit
                                        scelerisque integer, quam dapibus per risus donec semper
                                        vulputate interdum, imperdiet mus rhoncus commodo ultricies
                                        class urna tincidunt. Imperdiet vitae lacus etiam metus ut nisl
                                        curae, conubia enim scelerisque quis facilisis torquent,
                                        ultricies orci faucibus dictumst mauris curabitur. Massa risus
                                        nec sociosqu fames montes accumsan iaculis justo turpis
                                        luctus</p>
                                </div>
                                <div class="container-cell">
                                    <div class="az_single_image-wrapper az_box_border_grey">
                                        <img src="assets/images/single-pro1.jpg"
                                             class="az_single_image-img attachment-full" alt="img"></div>
                                </div>
                            </div>
                            <div class="container-table">
                                <div class="container-cell">
                                    <div class="az_single_image-wrapper az_box_border_grey">
                                        <img src="assets/images/single-pro2.jpg"
                                             class="az_single_image-img attachment-full" alt="img"></div>
                                </div>
                                <div class="container-cell">
                                    <h2 class="az_custom_heading">
                                        Potenti praesent molestie<br>
                                        at viverra</h2>
                                    <p>This generator uses a dictionary of Latin words to construct
                                        passages of Lorem Ipsum text that meet your desired length. The
                                        sentence and paragraph durations and punctuation dispersal are
                                        calculated using Gaussian distribution, based on statistical
                                        analysis of real world texts. This ensures that the generated
                                        Lorem Ipsum text is unique, free of repetition and also
                                        resembles readable text as much as possible.</p>
                                </div>
                            </div>
                        </div>
                        <div class="furgan-Tabs-panel furgan-Tabs-panel--additional_information panel entry-content furgan-tab"
                             id="tab-additional_information" role="tabpanel"
                             aria-labelledby="tab-title-additional_information">
                            <h2>Additional information</h2>
                            <table class="shop_attributes">
                                <tbody>
                                <tr>
                                    <th>Color</th>
                                    <td><p>Blue, Pink, Red, Yellow</p>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="furgan-Tabs-panel furgan-Tabs-panel--reviews panel entry-content furgan-tab"
                             id="tab-reviews" role="tabpanel" aria-labelledby="tab-title-reviews">
                            <div id="reviews" class="furgan-Reviews">
                                <div id="comments">
                                    <h2 class="furgan-Reviews-title">Reviews</h2>
                                    <p class="furgan-noreviews">There are no reviews yet.</p>
                                </div>
                                <div id="review_form_wrapper">
                                    <div id="review_form">
                                        <div id="respond" class="comment-respond">
                                            <span id="reply-title" class="comment-reply-title">Be the first to review “T-shirt with skirt”</span>
                                            <form id="commentform" class="comment-form">
                                                <p class="comment-notes"><span id="email-notes">Your email adchair will not be published.</span>
                                                    Required fields are marked <span class="required">*</span></p>
                                                <p class="comment-form-author">
                                                    <label for="author">Name&nbsp;<span
                                                            class="required">*</span></label>
                                                    <input id="author" name="author" value="" size="30" required=""
                                                           type="text"></p>
                                                <p class="comment-form-email"><label for="email">Email&nbsp;
                                                    <span class="required">*</span></label>
                                                    <input id="email" name="email" value="" size="30" required=""
                                                           type="email"></p>
                                                <div class="comment-form-rating"><label for="rating">Your rating</label>
                                                    <p class="stars">
                                                        <span>
                                                        <a class="star-1" href="#">1</a>
                                                        <a class="star-2" href="#">2</a>
                                                        <a class="star-3" href="#">3</a>
                                                        <a class="star-4" href="#">4</a>
                                                        <a class="star-5" href="#">5</a>
                                                        </span>
                                                    </p>
                                                    <select title="product_cat" name="rating" id="rating" required=""
                                                            style="display: none;">
                                                        <option value="">Rate…</option>
                                                        <option value="5">Perfect</option>
                                                        <option value="4">Good</option>
                                                        <option value="3">Average</option>
                                                        <option value="2">Not that bad</option>
                                                        <option value="1">Very poor</option>
                                                    </select></div>
                                                <p class="comment-form-comment"><label for="comment">Your
                                                    review&nbsp;<span class="required">*</span></label><textarea
                                                        id="comment" name="comment" cols="45" rows="8"
                                                        required=""></textarea></p><input name="wpml_language_code"
                                                                                          value="en" type="hidden">
                                                <p class="form-submit"><input name="submit" id="submit" class="submit"
                                                                              value="Submit" type="submit"> <input
                                                        name="comment_post_ID" value="27" id="comment_post_ID"
                                                        type="hidden">
                                                    <input name="comment_parent" id="comment_parent" value="0"
                                                           type="hidden">
                                                </p></form>
                                        </div><!-- #respond -->
                                    </div>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
                       
        </div>
    </div>
</div>