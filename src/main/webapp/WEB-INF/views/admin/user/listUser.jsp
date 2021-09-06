<%@include file="/common/taglib.jsp"%>

<c:url var="API" value="/api/user"/>
<div class="container-fluid">

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
                                            <th>FullName</th>
                                            <th>User</th>
                                            <th>Password</th>
                                            <th>ADdress</th>

						</tr>
                                    </thead>
                                    
                                    <%-- <tbody>
                                    <c:forEach var="item" items="${List}"> 
                                        <tr class="table-info">
                                            <td>${item.id}</td>
                                            <td>${item.name}</td>
                                            <td>${item.price}</td>
                                            <td>${item.createdDate}</td>
                                            <td>${item.modifiedDate}</td>
                                            <td>${item.stt}</td>
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
 
 
 
 
 
 
 var table;
 var urlUsers = '${API}';
 
 $(document).ready( function () 
	{
	 //$("#"example"").jsGrid()
	 
	 $.get(urlUsers, function(responseData) 
		{
    				
		//Mofify "responseData" before showing ?
	    	/* var modifiedUsers = responseData.map(eachUser => {
	    		return {
	    			id: eachUser.id,
	    			fullname: eachUser.fullname,
	  				email: eachUser.email,
	  				address: `${eachUser.address.street}, ${eachUser.address.suite}, ${eachUser.address.city}`,
	  				phone: eachUser.phone
	  				phone: eachUser.phone
	    		};
	    		};
	    	}); */
	    	
		 
    	
		    	table = $('#example').DataTable
		    	({
		    	"processing": true,
		    	data: responseData,
		    	columns:[
				    		{ data: 'id' },		
				    		{ data: 'fullname' },
				    		{ data: 'username' },
				    		{ data: 'address' },
				    		{ data: 'password' }
		    			]
		    	});
    	
    	
    	}).fail(function() { alert( "Cannot get data from URL" ); });
	 
	
	 
	 
	});     
 </script>   