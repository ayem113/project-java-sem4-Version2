<%@include file="/common/taglib.jsp"%>

<c:url var="API" value="/api/category"/>
<c:url var="API2" value="/api/product"/>
<div class="container-fluid">



<div id="jsGrid"></div>



                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Tables</h1>
                    <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover" id="example" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Name</th>
                                            <th>Price</th>
                                        
                                        </tr>
                                    </thead>
                                    
                                    <%-- <tbody>
                                    
                                    
                                    
                                    <c:forEach var="item" items="${List}"> 
                                        <tr class="table-info">
                                            <td>${item.id}</td>
                                            <td>${item.name}</td>
                                           
                                           <td><a href="#" class="btn btn-warning btn-circle btn-sm"> <i class="fas fa-edit"></i>
                                            <td><a href="#" class="btn btn-danger btn-circle btn-sm"> <i class="fas fa-trash"></i>
                                    </a></td>
                                            
                                        </tr> 
                                        </c:forEach>
                                    </tbody> --%>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
            
            
<script>

 
 $(document).ready( function () 
	{
	 $.get('${API2}', function(result) 
		{
         	$("#jsGrid").jsGrid
         	({
    	        width: "100%",
    	        height: "400px",
    	        sorting: true,
    	        paging: true,
    	        editing: true,
    	        inserting: true,
    	        insertItem: function(args) { alert(args.id); },
    	        updateItem: function(args) { console.log(args.id);  },
    	        deleteItem :function(args) {
    	        	alert(args.id);
    	        	
    	        	Swal.fire({
    	        		  title: 'Are you sure?',
    	        		  text: "You won't be able to revert this! "+args.id,
    	        		  icon: 'warning',
    	        		  showCancelButton: true,
    	        		  confirmButtonColor: '#3085d6',
    	        		  cancelButtonColor: '#d33',
    	        		  confirmButtonText: 'Yes, delete it!'
    	        		}).then((result) => {
    	        		  if (result.isConfirmed) 
    	        		  {
    	        		    

    	        			  $.ajax({
    	        			        url: '${API2}',
    	        			        type: 'DELETE',
    	        			        contentType: 'application/json',
    	        			        data: JSON.stringify(args.id),
    	        			        success: function (result) {
    	        			        	
    	        			        	$("#jsGrid").load(location.href + "#jsGrid");
    	        			        	Swal.fire
		        	        			  (
		    	    	        		      'Deleted!',
		    	    	        		      'Your file has been deleted.',
		    	    	        		      'success'
		        	        		      )
    	        			        },
    	        			        error: function (error) {
    	        			        	Swal.fire
		        	        			  (
		    	    	        		      'Deleted false!',
		    	    	        		      'Your file has been deleted.',
		    	    	        		      'error'
		        	        		      )
    	        			        }
    	        			    });
    	        			  
    	        			  
    	        			  
    	        					
    	        						
    	        						
    	        			  
    	        		    	
    	        		    	
    	        		    	
    	        		  }
    	        		})
    	        },
    	        
    	        
    	        data: result,
    	        fields: 
    	        	[
	    	            { name: "id", type: "text", width: 150, validate: "required" },
	    	            { name: "name", type: "number", width: 50 },
	    	            { type: "control" }
    	        	]
     		});
		}).fail(function (error) { alert("false");} ); 
	});     
 </script>   
            