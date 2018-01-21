<%@ include file="/WEB-INF/pages/includes.jsp"%> 
<body> 
<%@ include file="/WEB-INF/pages/header.jsp"%> 
<custom:view userRole="all" activeTab="${activeTab}" /> 
<div id="organisation" class="response" >
<div class="info"><c:out value="${msg}"/></div>

 <table id="employeeList"  class="table zebra-style">
	<tr>
		<th>Employee Id</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Phone Number</th>
		<th>Hire Date</th>
		<th>Job Id</th>
		<th>Salary</th>
		<th>Commission Pct</th>
		<th>Manager Id</th>
		<th>Department Id</th>
	</tr> 
<c:forEach var="emp" items="${employees}">
      <tr class="table zebra-style">
		<td><a href="#" onclick="javascript:editEmployee('<c:out value="${emp.employeeId}"/>')"><c:out value="${emp.employeeId}"/></a></td>
		<td><c:out value="${emp.firstName}"/></td>
		<td><c:out value="${emp.lastName}"/></td>
		<td><c:out value="${emp.email}"/></td>
		<td><c:out value="${emp.phoneNumber}"/></td>
		<td><c:out value="${emp.hireDate}"/></td>
		<td><c:out value="${emp.jobId}"/></td>
		<td><c:out value="${emp.salary}"/></td>
		<td><c:out value="${emp.commissionPct}"/></td>
		<td><c:out value="${emp.managerId}"/></td>
		<td><c:out value="${emp.departmentId.departmentId}"/></td>
	</tr> 
 </c:forEach> 
	</table>
<custom:paginate max="15" offset="${offset}" count="${count}" uri="${uri}"
  next="&raquo;" previous="&laquo;" />
</div> 
<%@ include file="/WEB-INF/pages/footer.jsp"%>
</body>
</html>
