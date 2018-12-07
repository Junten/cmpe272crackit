<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html lang="en">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="http://sjsu.cmpe272crackit.me:8080/css/sidebar.css" rel="stylesheet">
        <style type="text/css">
            .login-form {
                width: 340px;
                margin: 50px auto;
            }
            .login-form form {
                margin-bottom: 15px;
                background: #f7f7f7;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 30px;
            }
            .login-form h2 {
                margin: 0 0 15px;
            }
            .form-control, .btn {
                min-height: 38px;
                border-radius: 2px;
            }
            .btn {        
                font-size: 15px;
                font-weight: bold;
            }
        </style>
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
    	</div>
        
        <div class="main">
        	<div class="login-form">
            	<div class="col vcenter center-block">
            	
                	<h2 class="form-signin-heading">Create New User</h2>
                	
                	<form:form method="POST">                                 
                    	<div class="form-group ${status.error ? 'has-error' : ''}">
                       		<input name='username' type="text" class="form-control" placeholder="Username"/>
                        	<form:errors path="username"></form:errors>
                    	</div>
                
                    	<div class="form-group ${status.error ? 'has-error' : ''}">
                        	<input name="employeeId" type="text"  class="form-control" placeholder="Emnployee ID" />
                        	<form:errors path="empNo"></form:errors>
                    	</div>
   
                    	<div class="form-group">
                        	<input class="btn btn-primary btn-block" name="submit" type="submit" value="Create" />  
                    	</div>         
                	</form:form>
            	</div>
        	</div>                    
        </div>
    </body>
</html>