<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="single-thumb-vertical main-container shop-page no-sidebar">

<c:forEach var="item" items="${lstResult}"> 

<input id="proId_hidden" value="${item.id}" type="hidden">	
	
	<div class="container">
        <div class="row">
            <div class="main-content col-md-12">
                <div class="furgan-notices-wrapper"></div>
                <div id="product-27"
                     class="post-27 product type-product status-publish has-post-thumbnail product_cat-table product_cat-new-arrivals product_cat-lamp product_tag-table product_tag-sock first instock shipping-taxable purchasable product-type-variable has-default-attributes">
                    <div class="main-contain-summary">
                        <div class="contain-left has-gallery">
                            <div class="single-left">
                                <div class="furgan-product-gallery furgan-product-gallery--with-images furgan-product-gallery--columns-4 images">  <a href="#" class="furgan-product-gallery__trigger">  <img draggable="false" class="emoji" alt="🔍"src="https://s.w.org/images/core/emoji/11/svg/1f50d.svg"></a> 		
						      		<div class="flex-viewport">
                                        <figure class="furgan-product-gallery__wrapper">
                                        	<div class="furgan-product-gallery__image">
                                                <img src="<c:url value="/images"/>/${item.img }"/>   
                                            </div> 
                                        <c:forEach var="item3" items="${item.product_detail}">  
						      			<c:forEach var="item2" items="${item3.productImages}">
                                            <div class="furgan-product-gallery__image">
                                                <img src="<c:url value="/images"/>/${item2.img }"/>   
                                            </div> 
                                        </c:forEach>     
						      			</c:forEach>        
                                        </figure>
                                    </div>   
                                    <ol class="flex-control-nav flex-control-thumbs">
                                  		<li><img src="<c:url value="/images"/>/${item.img }"/></li>
                             			<c:forEach var="item3" items="${item.product_detail}">  
						      			<c:forEach var="item2" items="${item3.productImages}">  
											<li><img src="<c:url value="/images"/>/${item2.img }"/></li> 
										 </c:forEach>
										 </c:forEach>                                  
                                    </ol>  
                                </div>
                            </div>
                            <div class="summary entry-summary">         
                                <h1 class="product_title entry-title">${item.name }</h1>
                                <p class="price">
                                 
                                 <label>Giá: </label>    
                                
                                <c:set var = "discount" scope = "session" value = "${item.discount}"/>
						      	<c:if test = "${discount == 0}">
						         	<ins><span class="furgan-Price-amount amount"><span class="furgan-Price-currencySymbol">
                                    </span> <f:formatNumber value="${item.price }"  pattern="#,###" />  </span></ins>
						      	</c:if>  
						      	<c:if test = "${discount > 0}">
						         	<del><span class="furgan-Price-amount amount"><span class="furgan-Price-currencySymbol">
                                    </span> <f:formatNumber value="${item.price }"  pattern="#,###" />  </span></del>
                                    <ins><span class="furgan-Price-amount amount"><span class="furgan-Price-currencySymbol">
                                    </span> <f:formatNumber value="${(100-discount)/100 * item.price}"  pattern="#,###" /> (giảm ${item.discount} %) </span></ins>
                                
						      	</c:if>  
                                
                                
                                </p>
                                <c:set var = "quantity" scope = "session" value = "${item.quantity}"/>
						      	<c:if test = "${quantity == 0}">
						         	<p class="stock out-stock">  
                                    	Tình trạng: <span> Hết hàng</span>
                                	</p>
						      	</c:if>  
						      	<c:if test = "${quantity > 0}">
						         	<p class="stock in-stock">  
                                    Tình trạng: <span> Còn hàng</span>
                                </p>
						      	</c:if>                               
                                
                                <div class="furgan-product-details__short-description">
                                    <p>${item.description } </p>
                                    <ul>
                                        <li>Water-resistant fabric with soft lycra detailing inside</li>
                                        <li>CLean zip-front, and three piece hood</li>
                                        <li>Subtle branding and diagonal panel detail</li>
                                    </ul>
                                </div>   
                                <div class="row">
									<div class="col-md-2 pr-1">
										<div class="form-group"><label for="html">Size</label></div>
									</div>
									<div class="col-md-10 pr-1">
										<div>										   
											<form id="formSelectSize">
											<c:forEach var="item2" items="${item.product_detailGroupBySize}">  
									      		<input class="form-check-input" value="${item2.size.id}" type="radio" name="flexRadioSize" id=""> <!-- onclick="handleClickSize(this);" -->
												  <label> Size ${item2.size.name}  </label>
									      	</c:forEach> 
									      	</form>
										</div>
									</div>
					
								</div>
								<div class="row">
									<div class="col-md-2 pr-1">
										<div class="form-group"><label for="html">Màu sắc</label>	</div>
									</div>
									<div class="col-md-10 pr-1">
										<div>
											<form id="formSelectColor">
											<c:forEach var="item2" items="${item.product_detailGroupByColor}">  
									      		<input  class="form-check-input" name="flexRadioColor" type="radio" value="${item2.color.id}" id="flexCheckChecked" >	       
									      	    <a style="background: ${item2.color.code};" data-value="red">Màu ${item2.color.name} </a>  					      		
									      	</c:forEach>
									      	</form>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-2 pr-1">
										<div class="form-group"><label for="html">Số lượng</label></div>
									</div>
									<div class="col-md-3 pr-1">
										<input id="chooseQuantity" style="width: 101px; height: 30px;" type="number" min="1" max="9000" value="1" >
									</div>
									<div class="col-md-7 pr-1">
										<p id="valiableQuantity" > 123 sản phẩm có sẵn </p>
									</div>
								</div>
                                <div class="furgan-variation-add-to-cart variations_button furgan-variation-add-to-cart-disabled">
                                            <button  type="button" class="btnAddCart btn btn-info">Thêm vào giỏ</button>
                                            <button type="button" class="btnBuyNow btn btn-secondary">Mua ngay</button>
                                            <input name="add-to-cart" value="27" type="hidden">
                                            <input name="product_id" value="27" type="hidden">
                                            <input name="variation_id" class="variation_id" value="0" type="hidden">
                                            
                                        </div>
                              <br>
                              <div class="product_meta">      
                                    <!-- <span class="sku_wrapper">SKU: <span class="sku">885B712</span></span> -->
                                    <span class="posted_in">Danh mục: 
                                    <a href=""  rel="tag">${item.category.name }</a>
                                    </span>
                                    <span class="tagged_as">Tags: 
                                    <a href="#" rel="tag">Table</a>, <a href="#" rel="tag">Sock</a>
                                    </span>
                                </div>  
                            </div>
                        </div>
                    </div>
                </div>
            </div>             
        </div>
    </div>	
       
<ul class="nav nav-tabs" style="justify-content: space-evenly">
  <li><a data-toggle="tab" href="#menu1">Sản phẩm yêu thích</a></li>
  <li><a data-toggle="tab" href="#menu2">Sản phẩm cùng loại</a></li>
  <li><a data-toggle="tab" href="#menu3">Sản phẩm đã xem</a></li>
</ul>

<div class="tab-content">
  <div id="menu1" class="tab-pane fade in active show">
    <div>
    <c:forEach var="item" items="${listWishlist}"> 
						<a href="${item.slug}"><img src="/images/${item.img}" alt="HTML tutorial" style="width:70px;height:70px;"></a>
					</c:forEach> </div>
  </div>
  <div id="menu2" class="tab-pane fade">
    <c:forEach var="item" items="${listWishlist}"> 
						<a href="${item.slug}"><img src="/images/${item.img}" alt="HTML tutorial" style="width:70px;height:70px;"></a>
					</c:forEach> 
  </div>
  <div id="menu3" class="tab-pane fade">
    <c:forEach var="item" items="${listWishlist}"> 
						<a href="${item.slug}"><img src="/images/${item.img}" alt="HTML tutorial" style="width:70px;height:70px;"></a>
					</c:forEach> 
  </div>
</div> 	

</c:forEach>		
</div>

<script type="text/javascript">

/* function handleClickColor(myRadio) {
    alert('New value: ' + myRadio.value);
}
function handleClickSize(myRadio) {
    alert('New value: ' + myRadio.value);
}
	 */
	 
	 
	 		
function swalAlert(mess,icon){
	Swal.fire({
		 position: 'top',
		 icon: icon,
		 title: mess,
		 showConfirmButton: false,
		 timer: 1500
	});
};	 
$( document ).ready(function() {
		 $("#valiableQuantity").text("");
});
	
$('#formSelectColor input').on('change', function() {
	   idColor= ($('input[name=flexRadioColor]:checked', '#formSelectColor').val()); 
	   idSize=($('input[name=flexRadioSize]:checked', '#formSelectSize').val());
	   if (idColor!=null && idSize!=null ) {
			   $.get("/getQuantityBySizeAndColor", {
			    	idSize : idSize,
			    	idColor : idColor,
			    	idProduct :$("#proId_hidden").val()
			    }, function(data) {  		
			    	console.log(data);
			    	if(data=='0'){
			    		$("#valiableQuantity").text("Phân loại này đã hết hàng !").css({"color":"red"});
			    	}
			    	else{
			    		$("#valiableQuantity").text(data+" sản phẩm có sẵn").css({"color":"#868686;"});
			    	}
			  });  
	   }   
});

$('#formSelectSize input').on('change', function() {	
		idColor= ($('input[name=flexRadioColor]:checked', '#formSelectColor').val());
	    idSize=($('input[name=flexRadioSize]:checked', '#formSelectSize').val());
	    if (idColor!=null && idSize!=null ) {
	    	$.get("/getQuantityBySizeAndColor", {
		    	idSize : idSize,
		    	idColor : idColor,
		    	idProduct :$("#proId_hidden").val()
		    }, function(data) {  		
		    	console.log(data);	
		    	if(data=='0'){
		    		$("#valiableQuantity").text("Phân loại này đã hết hàng !").css({"color":"red"});
		    	}
		    	else{
		    		$("#valiableQuantity").text(data+" sản phẩm có sẵn").css({"color":"#868686;"});
		    	}
		  });  
		}   
});

function setInfo(){
	  $.get("/cart/getInfo/", function(data, status){
	 	$("#cart-total-items").html(data[0]);
	  }); 
}; 

function checkValidateColorAndSize(valiableQuantity){
	idColor= ($('input[name=flexRadioColor]:checked', '#formSelectColor').val());
    idSize=($('input[name=flexRadioSize]:checked', '#formSelectSize').val());
	return ((idColor==null ||idSize==null || valiableQuantity=="Phân loại này đã hết hàng !" ||valiableQuantity=="Vui lòng chọn Phân loại hàng !")); 
}

function addCart(){
	
	var idProduct =$("#proId_hidden").val();
    var quantity =$("#chooseQuantity").val();
    
    $.get("/cart/add",{
    	quantity:quantity,
    	idSize : idSize,
    	idColor : idColor,
    	idProduct :idProduct
    }, function(data){
    	console.log(data);
    	if (data=="false") {
    		swalAlert("Sản phẩm đã tồn tại trong giỏ hàng","warning");
		}  	
    	else{
    		setInfo();
    		 $(".tableShopingCart").load($(location).attr("href") + " .tableShopingCart");
    		 //$(".contentTableShopingCart").load($(location).attr("href") + " .contentTableShopingCart");
    		 //$(".widget_shopping_cart_content").load($(location).attr("href") + " .widget_shopping_cart_content");
    		swalAlert("Đã thêm vào giỏ hàng","success");
    	}
     });	 
}

$('.furgan-variation-add-to-cart').on('click',".btnAddCart", function() {

    if (checkValidateColorAndSize($("#valiableQuantity").text()) ) {
    	$("#valiableQuantity").text("Vui lòng chọn Phân loại hàng !").css({"color":"red"});
	}
    else{
    	addCart();
    }    
});


$('.btnBuyNow').on('click', function() {
	
    if (checkValidateColorAndSize($("#valiableQuantity").text())) {
    	$("#valiableQuantity").text("Vui lòng chọn Phân loại hàng !").css({"color":"red"});
	}
    else{
    	console.log($("#valiableQuantity").val());
    	addCart();
    	window.location.href = "http://localhost:8080/thanh-toan";
    }
 
});
</script>



