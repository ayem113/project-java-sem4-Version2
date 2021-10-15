<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:url var="ProAPI" value="/api/product" />
<style>
table, th, td {
  border: 1px solid black;
}
</style>


<div class="modal fade" id="detailPro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog modal-lg" role="document">
		<form class="form-horizontal" method="POST" id="formSubmit2"
			role="form" enctype="multipart/form-data">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">Chọn phân loại sản phẩm</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">	
					<div style="overflow-x:auto;">
									
						<table style="width: 100%">
							  <thead>
							    <tr>
							      <th></th>
							      <c:forEach var="item" items="${listColor}">  
									  <th>
										${item.name} 
							  		 </th>    		 
							  	 </c:forEach>    
							    </tr>
							  </thead>
							  <tbody>
							  	<c:forEach var="size" items="${listSize}"> 
							    <tr data-idSize=" ${size.id}">
							      <td>${size.name}</td>			      
								      <c:forEach var="color" items="${listColor}">  
								      	
								      	
									   <td style="text-align: center;">
									   	<form method="post" action=""  enctype="multipart/form-data" >
							   				
							            <div >
							                <label>sl</label>  
							                <input data-idColor="${color.id}"  data-idSize="${size.id}" name="quantity" type="number" style="width: 50px;"/>
							                <input style="width: 125px" type="file" class="file-upload" data-idC="${color.id}" data-idS="${size.id}" multiple="multiple" name="file[]" />
							                <input type="hidden" class="filenames" data-idC="${color.id}" data-idS="${size.id}" name="filename[]" />
							                
							            </div>
							        	</form>		
									    </td>  
									   
								  	 </c:forEach>  	 
							    </tr>
							    </c:forEach> 
							  </tbody>			  
					   </table>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button id="btnAddOrUpdate2" type="button"class="saveContact2 btn btn-primary" data-id="">OK</button>
				</div>
			</div>
		</form>	
	</div>
</div>




<div class="modal fade" id="addOrEditModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog modal-lg" role="document">
		<form:form class="form-horizontal"  id="formSubmit" role="form"  modelAttribute="model"  enctype="multipart/form-data">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">Thêm mới sản phẩm</h4>
					<button type="button" class="close" data-dismiss="modal"	aria-label="Close"> <span aria-hidden="true">&times;</span></button>
				</div>
				<div class="modal-body">
					<div class="row">
						<input type="hidden" id="ProId" name="id">
						<input type="hidden" id="imgInout" class="form-control" name="img" multiple placeholder="img" multiple />
						<div class="col-md-6 pr-1">
							<div class="form-group">
								<label for="html">Thuộc danh mục</label>
								<%-- <form:select path="categoryCode" id="categoryCode">
							  	 	<form:option value="" label="-- Chọn thể loại --"/>
							  	 	<form:options items="${categories}"/>
							  	 </form:select> --%>
								
								
								<form:select path="categoryCode" name="category" class="form-select" aria-label="Default select example">
										<option selected>Chọn danh muc</option>
										<c:forEach var="item" items="${sessionScope.listCategory}"> 
											 <option value="${item.code}">${item.name}</option>  
										</c:forEach>
								</form:select>
								
								
							</div>
						</div>
						<div class="col-md-6 pr-1">
							<div class="form-group">
								<label for="html">Chọn ảnh</label>
								<form:input path="fileUpload2" type="file"   class="form-control" accept="image/*"  id="imgInp"     />
						 		<img id="blah" src="<c:url value="/images"/>/${model.img}" alt="your image"  alt="img" width="445" height="350"/>
							</div>
						</div>						
					</div>
	
					<div class="row">
						<div class="col-md-6 pr-1">
							<div class="form-group">
								<label for="html">Tên sản phẩm</label>
								<form:input path="name" type="text"   class="form-control"   placeholder="Tên sản phẩm"  />
								
							</div>
						</div>
						<div class="col-md-6 pr-1">
							<div class="form-group">
								<label for="html">Số lượng sản phẩm</label>
								<form:input path="quantity"  type="number" class="form-control" placeholder="Số lượng"/>
							</div>
						</div>	
					</div>
				
				    <div class="row">
						<div class="col-md-6 pr-1">
							<div class="form-group">
								<label for="html">Giá của sản phẩm</label>
								<form:input path="price" type="number"  class="form-control" placeholder="Giá gốc" />
							</div>
						</div>
						<div class="col-md-6 pr-1">
							<div class="form-group">
								<label for="html">Giảm giá %</label>
								<form:input  path="discount" type="text"  class="form-control" placeholder="Giá sale"/>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label for="html">Mô tả cho sản phẩm</label>
								<form:textarea rows="4" cols="80" class="form-control" path="description" placeholder="Mô tả"/>
							</div>
						</div>
					</div>	
					
					 <%-- <c:forEach var="item" items="${listColor}">  
					 <c:forEach var="item2" items="${listSize}"> 
							    <input  value="${item2.id}" type="checkbox" name="SizeAndColor[${item.id}][${item2.id}]" id="${item2.id}">${item2.name}
					</c:forEach> 
					 
										  <td style="text-align: center;">
										  	<input  value="${item.id}" type="checkbox" name="flexRadioColor[]" id="${item.id}">
										  	${item.name}
										  </td>  		 
					</c:forEach>  	  --%>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button  type="submit"class="saveContact3 btn btn-primary" data-id="">OK</button>
				</div>
			</div>
		</form:form>
	</div>
</div>




<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800">Thêm mới</h1>

	<a class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
		data-toggle="tooltip" title='Thêm mới sản phẩm' id="btnNewPro">
		<span> <i class="fa fa-plus-circle bigger-110 red"></i></span>
	</a>
	 <a class="btn btn-danger btn-circle btn-sm"
		data-toggle="tooltip" title='Xóa sản phẩm' id="btnDelete">
		<span> <i class="fas fa-trash"></i></span>
	</a>
	<a class="btn btn-danger btn-circle btn-sm"
		data-toggle="tooltip" title='Xóa sản phẩm' id="btnDelete2">
		<span> <i class="fas fa-trash"></i></span>
	</a>


	<!-- DataTales Example -->
	<div id="dataTableSum" class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Danh sách tất cả sản phẩm</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered table-hover" id="dataTable">
					<thead>
						<tr>
							<th>Xóa</th>
							<th>Tên</th>
							<th>Giá gốc</th>
							<th>Giảm giá</th>
							<th>Thuộc danh mục</th>
							<th>Số lượng</th>
							<th>Trạng thái</th>
							<th>Ảnh đại diện</th>
							<th>Ảnh chi tiết</th>
							<th>Ngày thêm</th>
						<!-- 	<th>Ngày cập nhật</th>
							<th>Người thêm</th>
							<th>Người cập nhật</th> -->
							<th>Mô tả</th>
							<th>Sửa</th>
							<th>Sửa modal</th>
							

						</tr>
					</thead>

					<tbody class="Pro_body">
						<%-- <c:forEach var="item" items="${List}">
							<tr class="table-info">
								<td>${item.name}</td>
								<td>${item.price}</td>
								<td>${item.discount}</td>
								<td>${item.id_category}</td>
								<td>${item.quantity}</td>
								<td>${item.stt}</td>
								<td>${item.img}</td>
								<td>${item.img}</td>
								<td>${item.createdDate}</td>
								<td>${item.modifiedDate}</td>
								<td>${item.createdBy}</td>
								<td>${item.modifiedBy}</td>
								<td>${item.description}</td>
								<td><a
									href="/quan-tri/san-pham/them-hoac-sua?Id=${item.id}"
									class="btn btn-warning btn-circle btn-sm"> <i
										class="fas fa-edit"></i></a></td>
								<td><a onclick="showModal(${item.id})"
									class="btn btn-warning btn-circle btn-sm"> <i
										class="fas fa-edit"></i></a></td>
								<td><a href="/quan-tri/san-pham/xoa-san-pham?Id=${item.id}"
									class="btn btn-danger btn-circle btn-sm"> <i
										class="fas fa-trash"></i></a></td>
							</tr>
						</c:forEach> --%>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>


<script>

$(document).ready(function() {	
	$('#detailPro').on('change','input[type=file].file-upload',function (e) {
		//e.preventDefault();
		
		var idColor = $(this).attr('data-idC');
		var idSize = $(this).attr('data-idS');
		
		var fd = new FormData(); 
		var arrFile = e.currentTarget.files;
		
		for (var i = 0; i < arrFile.length; i++) {
		    fd.append("file[]", arrFile[i]);
		}
		
		$.ajax({
            url: '/upload/uploadFileTam',
            type: 'post',
            data: fd, 
            contentType: false,
            processData: false,
            success: function(response){
            	console.log(response);
                if(response != null){
                	$('input.filenames[data-idC='+idColor+'][data-idS='+idSize+']').val(response);
                	console.log(response);
                } else {
                	alert('Upload không thành công');
                }
            },
        });
	});  
});

var titlePage = $('#myModalLabel');
	function Swalalert(mess,icon) {
		Swal.fire({
		  position: 'top',
		  icon: icon,
		  title: mess,
		  showConfirmButton: false,
		  timer: 1500
		});
	};

	$(document).ready(function() {
		LoadTable();
		//khi close modal thì clear fiel của modal
		$('#addOrEditModal').on('hidden.bs.modal', function () {
			$(this).find("input,textarea,select,img").val('').end();
		    //$(this).find('form')[0].reset();
			//$(this).find('form').trigger('reset');
			$('#blah').attr('src', 'newImage.jpg');
			
			
		});
	});
	
		
	$( "#btnNewPro" ).click(function() {
		titlePage.text("Thêm mới sản phẩm ");
		$('#addOrEditModal').modal("show");
	});
	
	function showModal(id) {
		
		$.get('${ProAPI}/'+id, function(pro, status){
			console.log(pro);
			$("div.id_100 select").val("val2");
        	$('#addOrEditModal #ProId').val(pro.id);
        	$('#addOrEditModal #name').val(pro.name);
        	$('#addOrEditModal #price').val(pro.price);
        	$('#addOrEditModal #discount').val(pro.discount);
        	$('#addOrEditModal #quantity').val(pro.quantity);
        	$('#addOrEditModal #blah').attr("src", '/images/'+pro.img);;
        	$('#addOrEditModal #description').val(pro.description);
        	titlePage.text("Cập nhật sản phẩm ");
        	$('#addOrEditModal').modal("show");
		})
	};
	
	
	imgInp.onchange = evt => {  //show ảnh cho người dùng xem trước khi thêm
		  const [file] = imgInp.files
		  if (file) {
		    blah.src = URL.createObjectURL(file)
		  }
		}  
	
	
	$('#formSubmit').submit(function (e) {
		e.preventDefault(); 
		
	    $.ajax({
            url: '${ProAPI}',
            type: 'POST',
            dataType: "JSON",
            data: new FormData(this),
            processData: false,
            contentType: false,
            success: function (data) {
            	console.log(data);
            	if (data==true) {
            		Swalalert("Thêm thành công!","success");
            		$('#addOrEditModal').modal("hide");
            		$('#detailPro').modal("show");
            		
				}else{
					Swalalert("Thêm không thành công!","error");
				}
            	
            	
            	//window.location = 'http://localhost:8080/quan-tri/san-pham/danh-sach';
            },
            error: function (error) {
            	Swalalert("lỗi hệ thống!","error");
            }
        });
	});
	
	
	$('#formSubmit2').submit(function (e) {
		e.preventDefault(); 
	    $.ajax({
            url: '${ProDetailAPI}',
            type: 'POST',
            dataType: "JSON",
            //enctype: 'multipart/form-data',
            data: new FormData(this),
            processData: false,
            contentType: false,
            success: function (result) {
            	Swalalert(result);
            	//window.location = 'http://localhost:8080/quan-tri/san-pham/danh-sach';
            },
            error: function (error) {
            	Swalalert(error);
            }
        });
	});
	
	
	  $('#btnAddOrUpdate2').click(function (e) {
		e.preventDefault();	
		var proDetail=[];				
		$.each($("tbody").find("tr"), function(i,item){
		    var idSize=$(this).attr("data-idSize");
    
		    /* $.each($(item).find('input:checked'), function(index, value){
		    	colorIds.push($(value).val());
		    }); */
		    $.each($(item).find('input[name=quantity]'), function(index, value){
		    	
		    	if ($(value).val()!="") { 
		    		console.log( $(this).parent().find('input[type=hidden].filenames').val());
		    		var obj ={ 
		    			idSize:idSize,
		    			idColor: $(value).attr("data-idColor"),
		    			soluong: $(value).val(),
		    			listImgs: $(this).parent().find('input[type=hidden].filenames').val()
		    		};
		    		proDetail.push(obj);
				}	
		    });
		});
		
		console.log(proDetail);

	     $.post({ url: '/api/product/addDetailAndImg', data: JSON.stringify(proDetail), contentType: 'application/json; charset=utf-8'}).done(function (response) 
				{
					console.log(response);
		   
	   			 }); 
 
	});



	
	function addOrEdit(orderDetailBySizeColor) {
		 $.post({ url: '${ProAPI}', data: JSON.stringify(orderDetailBySizeColor), contentType: 'application/json; charset=utf-8'}).done(function (response) 
			{
				console.log(response);
	    		$('#addOrEditModal').modal('hide');
	    		var mytbl = $("#dataTable").DataTable();
	    		mytbl.clear();
	    		mytbl.ajax.reload;
	    		  
	    		 //$("#dataTable").DataTable().ajax.reload(null, false);
				//LoadTable();
	    		//$( "#dataTableSum" ).load(window.location.href + " #dataTableSum" );
	    		//location.reload();
	    		
	    		//$("#dataTable").load("http://localhost:8080/quan-tri/san-pham/danh-sach" + " #dataTable");
   			 });
	}
	
	function parseJsonDate( jsonDate) { //1293034567877
		 return (new Date(jsonDate).toISOString().substr(0,10));   //2015-10-26T07:46:36.611Z  (substr(0,10) =>2015-10-26)
    }; 
       
	
	function LoadTable(){
		 $.get('${ProAPI}', function(result, status){
			 var rows = '';
     		 var date= '';
     		 $.each(result, function (idex, item) {
     			// console.log(item.discount); 
     			  if (item.createdDate != null) { date=parseJsonDate(item.createdDate);} 	 
     			  rows+=`<tr class="table-info">
     				 		<td> <input class="checkToDelete" type="checkbox" value="`+item.id+`" id="flexCheckDefault">	</td>
							<td>` + item.name + `</td>
							<td>` + item.price + `</td>
							<td>` +item.discount+ `</td>
							<td>` +item.name_category+ `</td>
							<td>` +item.quantity+ `</td>						
							<td>` +item.stt+ `</td>		  
							<td>    <img src="/images/` +item.img+ `"  width="100" height="100">	</td>
							<td>ảnh chi tiết</td>
							<td>`+ date+ `</td>
							<td>` +item.description+ `</td>
							<td><a href="/quan-tri/san-pham/them-hoac-sua?Id=`+item.id+`" class="btn btn-warning btn-circle btn-sm"> <i class="fas fa-edit"></i></a></td>
							<td><a onclick="showModal(`+item.id+`)" class="btn btn-warning btn-circle btn-sm"> <i class="fas fa-edit"></i></a></td>	
							
						</tr>`;		 
     			 $(".Pro_body").html(rows);
     		 }) 
     		$('#dataTable').DataTable();
		    }); 
	}
	
	
	function deletePro(data) {
        $.ajax({
            url: '${ProAPI}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
            	console.log(result);
            	if (result=="true"){
            		Swalalert("Xóa thành công !","success");
            		window.location.href = "http://localhost:8080/quan-tri/san-pham/danh-sach";
            	}
            	else{
            		Swalalert("Xóa lỗi !","error")	
            	} 	
            },
            error: function (error) {
            	Swalalert("Lỗi hệ thống !","error")	
            }
        });
	}; 
	
	$(document).on('click','#btnDelete', function() {
		
		var ids = $('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();

		Swal.fire({
			  title: 'Bạn chắc chứ ?',
			  text: "Xóa "+ids.length+" sản phẩm được chọn",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Yes'
			}).then((result) => {
				console.log(ids);
				
			  if (result.isConfirmed) {
				  deletePro(ids);
			  }
			})
	});
	$(document).on('click','#btnDelete2', function() {
		
		$('#detailPro').modal("show");
	});
	
	
</script>
