<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="banner-wrapper has_background">
    
    <div class="banner-wrapper-inner">
        <h1 class="page-title">Checkout</h1>
        <div role="navigation" aria-label="Breadcrumbs" class="breadcrumb-trail breadcrumbs">
            <ul class="trail-items breadcrumb">
                <li class="trail-item trail-begin"><a href="index.html"><span>Home</span></a></li>
                <li class="trail-item trail-end active"><span>Checkout</span>
                </li>
            </ul>
        </div>
    </div>
</div>
<main class="site-main  main-container no-sidebar">
    <div class="container">
        <div class="row">
            <div class="main-content col-md-12">
                <div class="page-main-content">
                    <div class="furgan">
                        <div class="furgan-notices-wrapper"></div>
                        <div class="checkout-before-top">
                            <div class="furgan-checkout-login">
                                <div class="furgan-form-login-toggle">
                                    <div class="furgan-info">
                                        Bạn đã có tài khoản? <a href="#" class="showlogin">Click Để đăng nhập</a></div>
                                </div>
                                
                            </div>
                            <div class="furgan-checkout-coupon">
                                <div class="furgan-notices-wrapper"></div>
                                <div class="furgan-form-coupon-toggle">
                                    <div class="furgan-info">
                                        Bạn có mã code? <a href="#" class="showcoupon">Click để nhập mã code của bạn</a>
                                    </div>
                                </div>
                                
                            </div>
                        </div>
                        
                            <div class="col2-set" id="customer_details">
                                <div class="col-1">
                                    <div class="furgan-billing-fields">
                                        <h3>Thông tin thanh toán</h3>
                                        <div class="furgan-billing-fields__field-wrapper">
                                            <p class="form-row form-row-first validate-required"
                                               id="billing_first_name_field" data-priority="10"><label
                                                    for="billing_first_name" class="">Tên&nbsp;<abbr
                                                    class="required" title="required">*</abbr></label><span
                                                    class="furgan-input-wrapper"><input type="text"
                                                                                             class="input-text "
                                                                                             name="billing_first_name"
                                                                                             id="billing_first_name"
                                                                                             placeholder="" value=""
                                                                                             autocomplete="given-name"></span>
                                            </p>
                                            <p class="form-row form-row-last validate-required"
                                               id="billing_last_name_field" data-priority="20"><label
                                                    for="billing_last_name" class="">SDT&nbsp;<abbr
                                                    class="required" title="required">*</abbr></label><span
                                                    class="furgan-input-wrapper"><input type="number"
                                                                                             class="input-text "
                                                                                             name="billing_last_name"
                                                                                             id="billing_last_name"
                                                                                             placeholder="" value=""
                                                                                             autocomplete="family-name"></span>
                                            </p>
                                            <p class="form-row form-row-wide adchair-field update_totals_on_change validate-required"
                                               id="billing_country_field" data-priority="40"><label
                                                    for="billing_country" class="">Tỉnh/TP &nbsp;<abbr class="required" title="required">*</abbr></label>
                                                <span class="furgan-input-wrapper">
                                                <select name="billing_country"
                                                        id="billing_country"
                                                        class="country_to_state country_select"
                                                        autocomplete="country"
                                                        tabindex="-1"
                                                        aria-hidden="true"><option
                                                    value="">Select a country…</option><option
                                                    value="AX">Åland Islands</option><option
                                                    value="AF">Afghanistan</option><option value="AL">Albania</option><option
                                                    value="DZ">Algeria</option><option
                                                    value="AS">American Samoa</option><option
                                                    value="AD">Andorra</option><option value="AO">Angola</option><option
                                                    value="AI">Anguilla</option><option value="AQ">Antarctica</option><option
                                                    value="ZW">Zimbabwe</option></select>
                                                </span>
                                            </p>
                                            <p class="form-row form-row-wide adchair-field update_totals_on_change validate-required"
                                               id="billing_country_field" data-priority="40"><label
                                                    for="billing_country" class="">Quận/Huyện &nbsp;<abbr class="required" title="required">*</abbr></label>
                                                <span class="furgan-input-wrapper">
                                                <select name="billing_country"
                                                        id="billing_country"
                                                        class="country_to_state country_select"
                                                        autocomplete="country"
                                                        tabindex="-1"
                                                        aria-hidden="true"><option
                                                    value="">Select a country…</option><option
                                                    value="AX">Åland Islands</option><option
                                                    value="AF">Afghanistan</option><option value="AL">Albania</option><option
                                                    value="DZ">Algeria</option><option
                                                    value="AS">American Samoa</option><option
                                                    value="AD">Andorra</option><option value="AO">Angola</option><option
                                                    value="AI">Anguilla</option><option value="AQ">Antarctica</option><option
                                                    value="ZW">Zimbabwe</option></select>
                                                </span>
                                            </p>
                                            
                                            <p class="form-row form-row-wide adchair-field update_totals_on_change validate-required"
                                               id="billing_country_field" data-priority="40"><label
                                                    for="billing_country" class="">Phường/Thị xã &nbsp;<abbr class="required" title="required">*</abbr></label>
                                                <span class="furgan-input-wrapper">
                                                <select name="billing_country"
                                                        id="billing_country"
                                                        class="country_to_state country_select"
                                                        autocomplete="country"
                                                        tabindex="-1"
                                                        aria-hidden="true"><option
                                                    value="">Select a country…</option><option
                                                    value="AX">Åland Islands</option><option
                                                    value="AF">Afghanistan</option><option value="AL">Albania</option><option
                                                    value="DZ">Algeria</option><option
                                                    value="AS">American Samoa</option><option
                                                    value="AD">Andorra</option><option value="AO">Angola</option><option
                                                    value="AI">Anguilla</option><option value="AQ">Antarctica</option><option
                                                    value="ZW">Zimbabwe</option></select>
                                                </span>
                                            </p>
                                            <p class="form-row form-row-wide validate-required validate-phone"
                                               id="billing_phone_field" data-priority="100"><label for="billing_phone"
                                                                                                   class="">Địa chỉ cụ thể&nbsp;<abbr
                                                    class="required" title="required">*</abbr></label><span
                                                    class="furgan-input-wrapper"><input type="tel"
                                                                                             class="input-text "
                                                                                             name="billing_phone"
                                                                                             id="billing_phone"
                                                                                             placeholder="" value=""
                                                                                             autocomplete="tel"></span>
                                            </p>
                                            <p class="form-row form-row-wide adchair-field update_totals_on_change validate-required"
                                               id="billing_country_field" data-priority="40"><label
                                                    for="billing_country" class="">HÌnh thức thanh toán &nbsp;<abbr class="required" title="required">*</abbr></label>
                                                <span class="furgan-input-wrapper">
                                                <select name="billing_country"
                                                        id="billing_country"
                                                        class="country_to_state country_select"
                                                        autocomplete="country"
                                                        tabindex="-1"
                                                        aria-hidden="true"><option
                                                    value="">Select a country…</option><option
                                                    value="AX">Thanh toán khi nhận hàng</option><option
                                                    value="AF">Thanh toán trực tuyến</option><option value="AL">Albania</option><option
                                                    value="DZ">Thẻ ngân hàng</option><option
                                                    value="AS">Chuyển kho</option><option></select>
                                                </span>
                                            </p>
                                            
                                            
                                            </div>
                                    </div>
                                    
                                </div>
                                
                            </div>
                            <h3 id="order_review_heading">Sản phẩm</h3>
                            <div id="order_review" class="furgan-checkout-review-order">
                                <table class="shop_table furgan-checkout-review-order-table">
                                    <thead>
                                    <tr>
                                        <th class="product-name">Product</th>
                                        <th class="product-total">Total</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="p" items="${sessionScope['scopedTarget.cartService'].all}">
                                    <tr class="cart_item">
                                        <td class="product-name"> ${p.name}
                                            <strong class="product-quantity">×  ${p.quantity}</strong>
                                        </td>
                                        <td class="product-total">
                                           <span class="furgan-Price-amount amount"><span class="furgan-Price-currencySymbol"></span>${(p.price * p.quantity * ((100 - p.discount))) / 100}</span>
                                        </td>
                                        </tr>            
                                     </c:forEach>
                                    </tbody>
                                    <tfoot>
                                    <tr class="order-total">
                                        <th>Total</th>
                                        <td><strong><span class="furgan-Price-amount amount"><span
                                                class="furgan-Price-currencySymbol">VND </span>${sessionScope['scopedTarget.cartService'].totalPrice}</span></strong>
                                        </td>
                                    </tr>
                                    </tfoot>
                                </table>
                                
                                    <div class="form-row place-order">
                                        <noscript>
                                            Since your browser does not support JavaScript, or it is disabled, please
                                            ensure you click the <em>Update Totals</em> button before placing your
                                            order. You may be charged more than the amount stated above if you fail to
                                            do so. <br/>
                                            <button type="submit" class="button alt"
                                                    name="furgan_checkout_update_totals" value="Update totals">
                                                Update totals
                                            </button>
                                        </noscript>
                                        <div class="furgan-terms-and-conditions-wrapper">
                                            <div class="furgan-privacy-policy-text"><p>Your personal data will be
                                                used to process your order, support your experience throughout this
                                                website, and for other purposes described in our <a
                                                        href="#"
                                                        class="furgan-privacy-policy-link" target="_blank">privacy
                                                    policy</a>.</p>
                                            </div>
                                        </div>
                                        <button type="submit" class="button alt btnChekout" name="furgan_checkout_place_order"
                                                id="place_order" value="Place order" data-value="Place order">Thanh toán
                                        </button>
                                        <input type="hidden" id="furgan-process-checkout-nonce"
                                               name="furgan-process-checkout-nonce" value="634590c981"><input
                                            type="hidden" name="_wp_http_referer"
                                            value="/furgan/?furgan-ajax=update_order_review"></div>
                                </div>
                            </div>
                        
                    </div>
                </div>
            </div>
        </div>
    
    </main>
    
    
    
    
    
    
<script type="text/javascript">

$(".btnChekout").click(function (e){
	
	alert("ok");
}    );
    
</script>