<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html lang="en">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="http://sjsu.cmpe272crackit.me:8080/css/sidebar.css" rel="stylesheet">
        
    </head>
    <body>
        <nav class="navbar navbar-default"> 
        	<div style="padding-right: 20px">
            	<form action="/" method="get" >   
            		<span style="float: right ">
            		<span style="padding-right: 10px"> Hi, ${employee.firstName} </span>
                	<button type="Submit" class="btn btn-default">
                    	<span class="glyphicon glyphicon-log-out"></span> 
                    	Log out
                	</button>
                	</span>
            	</form>
            </div>
        </nav>
      		
   	 	<div class="sidenav">
    	    <h2 class=" ">CrackIt</h2>
    		<br>
			<a href="/home"><i class="fa fa-users"></i>User</a>
        	<a href="/home/manager"><i class="fa fa-address-book"></i>Manager</a>
        	<a href="/home/salary"><i class="fa fa-calendar"></i>Salary</a>
        	<a href="/home/department"><i class="fa fa-building"></i>Department</a>
            <security:authorize access="hasAuthority('Admin')">
                <a href="/home/allusers"><i class="fa fa-users"></i>All Users</a>
            </security:authorize>
            <security:authorize access="hasAuthority('Admin')">
             	<a href="/home/allemployees"><i class="fa fa-users"></i>All Employees</a>
           	</security:authorize>
    	</div>
		<div class="main">
			<div class="container ">
            	<table id="users" class="table">
                	<thead>
                   		<tr>
                        	<th>ID</th>
                        	<th>Username</th>
                        	<th>Firstname</th>
                        	<th>Lastname</th>
                        	<th>Edit</th>
                        	<th>Delete</th>
                    	</tr>
                	</thead>
                	<tbody>
                		
                	</tbody>
            	</table>
        	</div>
		</div>
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
        
        <script type="text/javascript" src="http://104.248.178.223:8080/js/jquery.spring-friendly.js"></script>     
        <script>
        $(document).ready(function (){
            var table = $('table#users').DataTable({
            	processing: true,
                ajax: '/users',
                serverSide: true,
                columns: [
                    {    
                        data: 'id'    
                    },        	
                    {    
                        data: 'username'    
                    },
                    {    
                        data: 'employee.firstName'   
                    },        
                    {    
                        data: 'employee.lastName'
                    },
                    {  
                        data: 'id',
                        render: function (data) { return "<button class='btn-info btn-xs' id='edit'> <span class='glyphicon glyphicon-edit btn'></span>  </button>"; }
                    },        
                    {  
                        data: 'id',
                        render: function (data) { return "<button class='btn-danger btn-xs' id='delete'> <span class='glyphicon glyphicon-trash btn'></span> </button>"; }
                    } 
                ],
/*                 columnDefs: [ 
                    {
                    	targets: -1,
                    	data: 'id'',
                    	defaultContent: "<button>Click!</button>"
                	} 
                ], */
            });

            $('table#users').on( 'click', 'tr', function () {
            	var id = this.id;
                var index = $.inArray(id, selected);
         
                if ( index === -1 ) {
                    selected.push( id );
                } else {
                    selected.splice( index, 1 );
                }
         
                $(this).toggleClass('selected');
            } );
            
            $('#users tbody').on('click', 'button#delete', function() {
            	var data = table.row( $(this).parents('tr') ).data();
            	var deleteURL ="/user/delete/" + data.id;
            	$.ajax({
                	type: 'DELETE',
                	url: deleteURL,
                	success: function(result) {
                		window.location = "/home/allusers";
                    }
                });
    			alert( data.id + " is ID." );
            }); 
        });       
        </script>
    </body>
</html>