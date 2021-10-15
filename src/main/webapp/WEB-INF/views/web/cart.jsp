<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="Url" value="/cart/getPriceByCheckboxChecked"/>
<style>
.showAndHide{display: none;}
</style>

<div class="banner-wrapper has_background">
	<div class="banner-wrapper-inner">
		<h1 class="page-title">Giỏ Hàng</h1>
		<div role="navigation" aria-label="Breadcrumbs"
			class="breadcrumb-trail breadcrumbs">
			<ul class="trail-items breadcrumb">
				<li class="trail-item trail-begin"><a href="http://localhost:8080/trang-chu"><span>Home</span></a></li>
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
							<table class="ProTabale   shop_table shop_table_responsive cart furgan-cart-form__contents"	>
								<thead>
									<tr>
										<th class="product-remove">Chon </th>
										<th class="product-thumbnail">Ảnh</th>
										<th class="product-name">Tên sản phẩm</th>
										<th style="text-align: center;" class="product-name">Phân loại  </th>
										<th class="product-price">Giá gốc</th>
										<th class="product-price">Giảm giá</th>
										<th class="product-quantity">Số lượng</th>
										<th class="product-subtotal">Tổng tiền</th>
										<th class="product-remove">Xóa</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="p" items="${sessionScope['scopedTarget.cartService2'].all}">
										<tr class="furgan-cart-form__cart-item cart_item">				
											<td> <input type="checkbox" class="vehicle1" id="vehicle1${p.id}" name="vehicle1" value="${p.id}"> </td>	
											<td class="product-thumbnail"><a href="#"><img src="<c:url value="/images"/>/${p.product.img}"/></a></td>
											<td class="product-name" data-title="Product"><a href="#">${p.product.name}</a></td>
											<td class="product-name" data-title="Product"><a href="#">  Size : ${p.size.name}   /   Color  : ${p.color.name}</a>
												
											
											
											<i onclick="showModalAttribute(${p.id})" class="fa fa-sort-desc" aria-hidden="true"></i>
												
												<div  id="cc${p.id}"  class="showAndHide">
													
	                                             
	                                             
	                                             			<div class="row">
																<div class="col-md-2 pr-1">
																	<div class="form-group"><label for="html">Size</label></div>
																</div>
																<div class="col-md-10 pr-1">
																	<div>										   
																		<form id="formSelectSize${p.id}" class="ClassformSelectSize">
																		<c:forEach var="item2" items="${p.product.product_detailGroupBySize}">  
															
																      		<input data-idProDetail="${p.id}" data-idSize="${item2.size.id}"  data-idPro="${p.product.id}" class="form-check-input" value="${item2.size.id}" type="radio" name="flexRadioSize" id=""> <!-- onclick="handleClickSize(this);" -->
																			  <label>  ${item2.size.name}  </label>
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
																		<form id="formSelectColor${p.id}" class="ClassformSelectColor">
																		<c:forEach var="item2" items="${p.product.product_detailGroupByColor}">  
																      		<input data-idProDetail="${p.id}"  data-idColor="${item2.color.id}" data-idPro="${p.product.id}" class="form-check-input" name="flexRadioColor" type="radio" value="${item2.color.id}" id="flexCheckChecked" >	       
																      	    <a style="background: ${item2.color.code};" data-value="red"> ${item2.color.name} </a>  					      		
																      	</c:forEach>
																      	</form>
																	</div>
																</div>
															</div>
															<p  class="validateQuantity"  id="valiableQuantity${p.id}" >  </p>
	                                            		 <div class="row"> 
	                                            		 		<div class="col-md-6 pr-1" style="text-align: center;">
																	<button onclick="onClickBtnCancel(${p.id})" style="width: 70px; font-size: x-small;height: 28px;" class="btnCancel btn btn-light"> Trở lại </button>
																</div>
																<div  class="col-md-6 pr-1" style="text-align: center;">
												<%-- onclick="onClickBtnChange(${p.id})		 --%>			<button data-idProDetail="${p.id }"  style="width: 70px; font-size: x-small;height: 28px;"    class="btnChangeAttribute btn btn-success"> Xác nhận </button>
																</div>
	                                            		 </div>
	                                             
												</div>
											
											</td>
											<td class="product-price" data-title="Price"><span class="furgan-Price-amount amount"><span
													class="furgan-Price-currencySymbol"></span> <f:formatNumber value="${p.product.price }"  pattern="#,###" />  </span></td>
											<td class="product-price" data-title="Discount"><span class="furgan-Price-amount amount">
												${p.product.discount}% (còn: <f:formatNumber value="${(p.product.price  * ((100 - p.product.discount))) / 100}"  pattern="#,###" />) </span></td>
											<td class="" data-title="Quantity">
												<input style="width: 80px;padding: 10px;" data-idProDetail="${p.id}" data-price="${p.product.price}"  data-discount="${p.product.discount}" 
												class="inputQuantity"  type="number" min=1 value="${p.quantity_order}" title="Qty"> 
											</td>
											<td class="product-subtotal" data-title="Total">
												 <span class="furgan-Price-amount amount   span-singer-price"><span class="furgan-Price-currencySymbol"></span> 
													<f:formatNumber value="${(p.product.price * p.quantity_order * ((100 - p.product.discount))) / 100} "   pattern="###,###" /> &nbsp;₫
												 </span>
												 
											</td>
											<td class="product-remove"><a href="#" class="remove btnRemove" aria-label="Remove this item" data-product_id="27"	data-id="${p.id}">×</a>	</td>
										</tr>
									</c:forEach>
 									
								</tbody>				
									<tr>
									<td>
										<input type="checkbox"  id="checkAll" name="checkAll" >   
										<p id="txtSizeCart"> chọn tất cả</p>  
									</td>
                                    	<td colspan="12" style="text-align: right;">
                                         	<label >Tổng tiền là:</label>    
                                         	<label id="totolPrice" ></label>    
              						</tr> 
							</table>
							<button  class="button btn btn-info btnClear" >Làm trống giỏ hàng </button>
                            <button  class="button btn btn-success btnCheckout" >Thanh toán ngay  </button>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>

<script type="text/javascript">
const formatMoney=new Intl.NumberFormat('vn-VN', { style: 'currency', currency: 'VND' });
$( document ).ready(function() {
	 $("#valiableQuantity").text("");
});
function swalAlert(mess,icon){
	Swal.fire({
		 position: 'top',
		 icon: icon,
		 title: mess,
		 showConfirmButton: false,
		 timer: 1500
	});
};	 
$(".inputQuantity").on("input", function(e) {
	   e.preventDefault();
	    var _this = this;
		var quantity =$(this).val();
		var idProDetail =($(this).attr("data-idProDetail"));
		var price =($(this).attr("data-price"));
		var discount =($(this).attr("data-discount"));
		
		
		var calculatePrice=formatMoney.format(quantity*price* ((100 - discount) / 100));
		
	    $.get("/cart/updateQuantity/"+idProDetail+"/"+quantity, function(data, status){
	    	$(_this).parents('tr').find("span.span-singer-price").html(calculatePrice);
	    	
	    	var ids = $('input:checkbox[name=vehicle1]:checked').map(function () {
	            return $(this).val();
	        }).get();
	    	
	    	//nếu 1 cheeckbox được chọn thì tính tiền dựa trên checkbox đó
	    	if ($("#vehicle1"+idProDetail).val()==idProDetail && $("#vehicle1"+idProDetail).is(":checked")	&&  ids.length==1)
		    	{
		    			$("#totolPrice").text(calculatePrice);  
				}
	    	//nếu nhiều hơn 1 cheeckbox được chọn thì gọi ajax tính tiền dựa trên danh sách checbox
	    	if (ids.length>1) {	
	    		$.ajax({
	    	        url: '/cart/getPriceByCheckboxChecked',
	    	        type: 'post',
	    	        contentType: 'application/json',
	    	        data:  JSON.stringify(ids),
	    	        success: function (data) {
	    	        	console.log(data);
	    	        	$("#totolPrice").text(formatMoney.format(data[1]));
	    	        	$("#txtSizeCart").text("đã chọn "+ids.length+" sp");	
	    	        }
	    	    });   
			}
	    }); 
	});
	
	
$('.ClassformSelectColor input').on('change', function() {
	   idProductDetail =($(this).attr("data-idProDetail")); 
	   idProduct =($(this).attr("data-idPro"));    
	   idSize=($('input[name=flexRadioSize]:checked', '#formSelectSize'+idProductDetail).val());  
	   idColor=($(this).attr("data-idColor"));
	   
	   	  console.log("idProduct "+idProduct);
		  console.log("idSize "+idSize);
		  console.log("idColor "+idColor);
	   
	   if (idColor!=null && idSize!=null ) {
			   $.get("/getQuantityBySizeAndColor", {
			    	idSize : idSize,
			    	idColor : idColor,
			    	idProduct :idProduct
			    }, function(data) {  		
			    	console.log(data);
			    	if(data=='0'){
			    		$("#valiableQuantity"+idProductDetail).text("Phân loại này đã hết hàng !").css({"color":"red"});
			    	}
			    	else{
			    		$("#valiableQuantity"+idProductDetail).text(data+" sản phẩm có sẵn").css({"color":"#868686;"});
			    	}
			  });  
	   }   
});

$('.ClassformSelectSize input').on('change' , function() {	

		idProductDetail =($(this).attr("data-idProDetail")); 
	    idProduct =($(this).attr("data-idPro"));    
	    idColor=($('input[name=flexRadioColor]:checked', '#formSelectColor'+idProductDetail).val());  
		idSize=($(this).attr("data-idSize"));
		  
		  console.log("idProduct "+idProduct);
		  console.log("idSize "+idSize);
		  console.log("idColor "+idColor);
	    
	    if (idColor!=null && idSize!=null ) {
	    	$.get("/getQuantityBySizeAndColor", {
		    	idSize : idSize,
		    	idColor : idColor,
		    	idProduct :idProduct
		    }, function(data) {  		
		    	console.log(data);	
		    	if(data=='0'){
		    		$("#valiableQuantity"+idProductDetail).text("Phân loại này đã hết hàng !").css({"color":"red"});
		    	}
		    	else{
		    		$("#valiableQuantity"+idProductDetail).text(data+" sản phẩm có sẵn").css({"color":"#868686;"});
		    	}
		  });  
		}   
});

function setInfo(){
	  $.get("/cart/getInfo/", function(data, status){
	 	//$("#cart-total-items").html(data[0]);
	 	 //$("#cart-total-price").html(data[1]);
		  $(".tableShopingCart").load($(location).attr("href") + " .tableShopingCart");
	  }); 
}; 

function showModalAttribute(id) {
	$("#cc"+id).toggleClass("showAndHide");
};
function onClickBtnCancel(id) {
	$("#cc"+id).toggleClass("showAndHide");
};

function checkValidateColorAndSize(idColor,idSize,valiableQuantity){
	return ((idColor==null ||idSize==null || valiableQuantity=="Phân loại này đã hết hàng !" )); 
}


$(".ProTabale").on("click",".btnChangeAttribute",function (e) {
 		var idProDetail=$(this).attr("data-idProDetail");
 		
		idColor= ($('input[name=flexRadioColor]:checked', '#formSelectColor'+idProDetail).val());
		idSize=($('input[name=flexRadioSize]:checked', '#formSelectSize'+idProDetail).val());
		console.log("idProDetail " + idProDetail);
		console.log("idColor " + idColor);
		console.log("idSize " + idSize);
		
		
		if (checkValidateColorAndSize(idColor,idSize,$(".validateQuantity").text())) {
			$("#valiableQuantity"+idProDetail).text("Vui lòng chọn Phân loại hàng !").css({"color":"red"});
		}
		else{
			$.get("/cart/updateAttribute",
					{
						idProDetail:idProDetail, 
						idSize:idSize,
						idColor: idColor
					}, function(data, status){
						
						swalAlert("Thay đổi thành công","success");
						
						window.location.href = $(location).attr("href");
						
			    	   //$(".tableShopingCart").load($(location).attr("href") + " .tableShopingCart");
			    	   //$(".ProTabale").load($(location).attr("href") + " .ProTabale");
			    }); 
		}

});

/* function onClickBtnChange(id) {
	console.log(id);
	var _this = this;
	idColor= ($('input[name=flexRadioColor]:checked', '#formSelectColor'+id).val());
    idSize=($('input[name=flexRadioSize]:checked', '#formSelectSize'+id).val());
    
    console.log("idColor " + idColor);
    console.log("idSize " + idSize);
    if (idColor==null ||idSize==null ) {
    	$("#valiableQuantity").text("Vui lòng chọn Phân loại hàng !").css({"color":"red"});
	}
    else{
    	$.get("/cart/updateAttribute",
    			{
    				idProDetail:id, 
    				idSize:idSize,
    				idColor: idColor
    			}, function(data, status){
    				swalAlert("Thay đổi thành công","success");
    	    	   $(".tableShopingCart").load($(location).attr("href") + " .tableShopingCart");
    	    	   $(".ProTabale").load($(location).attr("href") + " .ProTabale");
    	    }); 
    }

}; */

$('.btnClear').click(function (e) {
	e.preventDefault(); 
	var id =($(this).attr("data-id"));
    $.get("/cart/clear/", function(data, status){
    	 	//$("#cart-total-items").html(0);
    	    //$("#cart-total-price").html(0);
    	    $(".tableShopingCart").load($(location).attr("href") + " .tableShopingCart");
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
      $(".tableShopingCart").load($(location).attr("href") + " .tableShopingCart");
});

$('.btnCheckout').click(function (e) {
	window.location.href = "http://localhost:8080/thanh-toan";
});

$('#checkAll').change(function (e) {
	$('input:checkbox[name=vehicle1]:checked').prop("checked", false);

	if ($('#checkAll').is(":checked")) {
		 $.get("/cart/getInfo/", function(data, status){
			 console.log(data);
			 $("#txtSizeCart").text("đã chọn "+data[0]+" sp");
			 $("#totolPrice").text(formatMoney.format(data[1]));  
		});  
	}
	else{
		$("#totolPrice").text("");
		$("#txtSizeCart").text("chọn tất cả");
	}	 
});

$('.vehicle1').change(function () {
	$("#checkAll").prop( "checked", false );
	var ids = $('input:checkbox[name=vehicle1]:checked').map(function () {
        return $(this).val();
    }).get();
	console.log(ids); 
	if (ids.length>0) {
		var person = {name:"John", age:31, city:"New York"};
		console.log(person); 
		console.log(JSON.stringify(person)); 
		console.log({person}); 
		console.log(ids); //array
		console.log(JSON.stringify(ids)); //string json
		console.log({ids}); //object json
		  
	    
	    
		 $.ajax({
	        url: '/cart/getPriceByCheckboxChecked',
	        type: 'post',
	        contentType: 'application/json',
	        data:  JSON.stringify(ids),
	        success: function (data) {
	        	console.log(data);
	        	$("#totolPrice").text(formatMoney.format(data[1]));
	        	$("#txtSizeCart").text("đã chọn "+ids.length+" sp");	
	        }
	    });   
	    
	}
	else{
		$("#totolPrice").text("");
		$("#txtSizeCart").text("chọn tất cả");
	}
	
 });
 
 

</script>