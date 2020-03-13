<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../includes/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/signup" var="userActionUrl" />


	<form:form modelAttribute="student" action="${userActionUrl}">

		<form:errors />
		<form:hidden path="id"/>
		<div class="form-group">
			<form:label path="firstname">First Name</form:label>
			<form:input path="firstname" type="text" class="form-control"
				id="exampleInputfirstname1" placeholder="firstname" />
			<form:errors path="firstname" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="lastname">Last Name</form:label>
			<form:input path="lastname" type="text" class="form-control"
				id="exampleInputlastname1" placeholder="lastname" />
			<form:errors path="lastname" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="fathername">Father Name</form:label>
			<form:input path="fathername" type="text" class="form-control"
				id="exampleInputfathername1" placeholder="fathername" />
			<form:errors path="fathername" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="email">Email address</form:label>
			<form:input path="email" type="text" class="form-control"
				id="exampleInputEmail1" placeholder="Email" />
			<form:errors path="email" cssClass="text-danger" />
		</div>

		<div class="form-group">
			<form:label path="class1">Class</form:label>
			<form:input path="class1" type="text" class="form-control"
				id="exampleInputclass1" placeholder="class1" />
			<form:errors path="class1" cssClass="text-danger" />
		</div>
				<div class="form-group">
			<form:label path="age">Age</form:label>
			<form:input path="age" type="text" class="form-control"
				id="exampleInputage1" placeholder="age" />
			<form:errors path="age" cssClass="text-danger" />
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>		
	
	</form:form>
<%@include file="../includes/footer.jsp" %>