<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@include file="../includes/header.jsp" %>


<table class="table table-striped">
    <thead>
      <tr>
      	<th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Father Name</th>
        <th>Email</th>
       	<th>Class</th>
        <th>Age</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="student">


 <tr>   <td>${student.id}</td>
        <td>${student.firstname}</td>
        <td>${student.lastname}</td>
        <td>${student.fathername}</td>
        <td>${student.email}</td>
        <td>${student.class1}</td>
        <td>${student.age}</td>
         <td><a href="/students/${student.id}" class="btn btn-primary">Edit</a> </td>
      </tr>

</c:forEach>
     
      
    </tbody>
  </table>



<%@include file="../includes/footer.jsp" %>

