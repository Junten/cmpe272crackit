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
        	<div id="users">
        		<h4>Username: </h4>${username}
        		<br>
        		<h4>First Name: </h4>${employee.firstName}
            	<br>
            	<h4>Last Name: </h4>${employee.lastName}
            	<br>
            	<h4>Hire Date: </h4> <fmt:formatDate pattern="yyyy-MM-dd" value="${employee.hireDate}" />
            	<br/>
            	<c:forEach var="listValue" items="${titleList}">
            		<c:if test = "${listValue.toDate == '9999-01-01 00:00:00.0'}">
            			<h4>Title: </h4>${listValue.title}            			
            		</c:if>
        		</c:forEach>
        	</div>                     
        </div>
    </body>
</html>