<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.List" %>
<%@ page import ="com.spring.shopsmart.model.Items" %>
 <html>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<body>
		<%
		List<Items> items = (List<Items>) request.getAttribute("listItems"); 
		%>
			
						
		
	       <div class="container-fluid" style="margin: 0%; padding: 0px;">
	           <div class="row">
	               <div class="col-lg-12">
					<%@ include file="navbar.jsp" %>	
	               </div>
	           </div>
	           <div class="row">
	               
	               <div class="col-md-12  mt-4">
					
	                    
	                   <div class="row">
	                        
	                       <div class="col-lg-12">
	                           <table class="table">
	                               <thead>
	                                 <tr>
	                                   <th scope="col">#</th>
	                                   <th scope="col">Item Name</th>
	                                   <th scope="col">Category</th>
									   <th scope="col">Actions</th>
	                                   
	                                 </tr>
	                               </thead>
	                               <tbody>
									<% for( Items i:items){
										%>
										<tr>
										  <th scope="row"> <%=i.getId() %></th>
										  <td><%=i.getItemName() %></td>
										  <td><%=i.getCategory() %></td>
										  <td>
											
										 
										  	<a href="<%=request.getContextPath() %>/delete-item?iid=<%=i.getId() %>">Delete</a>
										  </td>
										  
										  
										</tr>										
									<%	
									} 
									%>

	                                 
	                               </tbody>
	                             </table>
	                       </div>
	                   </div>
	               </div>
	           </div>
	       </div>
	   </body>
</html>	