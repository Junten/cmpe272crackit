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
                        	<th>Employee Number</th>
                        	<th>Hire Date</th>
                        	<th>Firstname</th>
                        	<th>Lastname</th>
                        	<th>Username</th>
                        	<th>Submit</th>
                        	<!-- <th>Edit</th>
                        	<th>Delete</th -->
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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
        
        <script type="text/javascript" src="http://104.248.178.223:8080/js/jquery.spring-friendly.js"></script>     
        <script>
        $(document).ready(function (){
            var table = $('table#users').DataTable({
            	processing: true,
                ajax: '/employees',
                serverSide: true,
                columns: [
                    {    
                        data: 'empNo'   
                    },        	
                    {    
                        data: 'hireDate',
                        render: function (data) { return moment(data).format('YYYY-MM-DD'); }
                    },
                    {    
                        data: 'firstName'   
                    },        
                    {    
                        data: 'lastName'
                    },
                    {
						data: 'empNo',
						render: function (data) { return "<input type='text' id='add' name='adduser' placeholder='Username'>";}   
                    },
                    {  
                        data: 'empNo',  
                        render: function (data) { return "<button class='btn-info btn-xs' id='edit'> <span class='glyphicon glyphicon-edit btn'></span>  </button>"; }
                    },          
                ],
            });
            
            $('#users tbody').on('click', 'button#edit', function() {
            	var data = table.row( $(this).parents('tr') ).data();
            	var username = document.getElementById("add").value;
                var addURL = "/user/add/" + username + "/" + data.empNo;
             	$.ajax({
                	type: 'POST',
                	url: addURL,
                	success: function(result) {
                		window.location = "/home/allusers";
                    },
                	fail: function(result) {
                		alert("Fail: User has not yet been add. Please try again!");	
                    },
                    error: function(result) {
                		alert("Error: User has not yet been add. Please try again!");	
                    }                
                }); 
            });
        });       
        </script>
    </body>
</html>