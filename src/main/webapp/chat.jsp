<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@ page import="br.com.cafeina.chat.webserver.message.Message" %>
<%@ page import="java.util.List" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Chat Web Server</title>
	<link rel="icon" href="./assets/images/chat.png" />
	<link rel="stylesheet" href="./assets/styles/chatstyle.css">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" defer></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" defer></script>
	<script src="./assets/scripts/chat.js" defer></script>
</head>
<body>
	<div class="container-fluid mt-3">
		<div class="row clearfix">
		    <div class="col-lg-12">
		        <div class="card chat-app">
		            <div id="plist" class="people-list">
		                <div class="input-group">
	                        <span class="input-group-text"><i class="fa fa-search"></i></span>
		                    <input type="text" class="form-control" placeholder="Search..." readonly>
		                </div>
		                <ul class="list-unstyled chat-list mt-2 mb-0">
		                    <li class="clearfix active">
		                        <img src="https://www.freeiconspng.com/uploads/colors-icon-4.png" width="350" alt="colors icon" />
		                        <div class="about">
		                            <div class="name">Sala 1</div>
		                            <div class="status"> <i class="fa fa-circle online"></i> 2 membros online </div>                                            
		                        </div>
		                    </li>
		                    
		                    <li class="clearfix">
		                        <img src="./assets/images/people-group-solid.svg">
		                        <div class="about">
		                            <div class="name">Sala 2</div>
		                            <div class="status"> <i class="fa fa-circle online"></i> 1 membro online </div>                                            
		                        </div>
		                    </li>
		                    
		                    <li class="clearfix">
		                        <img src="./assets/images/people-group-solid.svg">
		                        <div class="about">
		                            <div class="name">Sala 3</div>
		                            <div class="status"> <i class="fa fa-circle offline"></i> 0 membros online </div>                                            
		                        </div>
		                    </li>
		                  <!--  <li class="clearfix">
		                        <img src="https://bootdey.com/img/Content/avatar/avatar2.png" alt="avatar">
		                        <div class="about">
		                            <div class="name">Aiden Chavez</div>
		                            <div class="status"> <i class="fa fa-circle online"></i> online </div>
		                        </div>
		                    </li> -->
		                </ul>
		            </div>
		            <div class="chat">
		                <div class="chat-header clearfix">
		                    <div class="row">
		                        <div class="col-lg-6">
		                            <a href="javascript:void(0);" data-toggle="modal" data-target="#view_info">
		                                <img src="https://www.freeiconspng.com/uploads/colors-icon-4.png" width="350" alt="colors icon" />
		                            </a>
		                            <div class="chat-about">
		                                <h5 class="mb-0">Sala 1</h5>
			                            <small>Membros Online: 2</small>
 		                            </div>
		                        </div>
		                        <div class="col-lg-6 hidden-sm text-end">
		                            <!-- <a href="javascript:void(0);" class="btn btn-outline-secondary"><i class="fa fa-camera"></i></a>
		                            <a href="javascript:void(0);" class="btn btn-outline-primary"><i class="fa fa-image"></i></a> -->
		                            <a href="javascript:void(0);" class="btn btn-outline-info"><i class="fa fa-cogs"></i></a>
		                            <a href="javascript:void(0);" class="btn btn-outline-warning"><i class="fa fa-question"></i></a>
		                        </div>
		                    </div>
		                </div>
		                <div class="chat-history chat-non-overflow" id="chat-history">
		                    <ul class="m-b-0">
		                    
		                    	<!-- MY MESSAGE -->
		                        <!-- <li class="clearfix">		                            
		                            <div class="message my-message float-right"> 
		                            	<h6 class="chat-message-username my-username text-start">Caroline</h6>
		                            	<p class="message-text text-start"> Oi povo !!</p>
		                            	<div class="message-data text-end">
		                                	<span class="message-data-time">10:10 AM, Today</span>
		                            	</div>
		                            </div>
		                        </li> -->		                        
		                        
		                        <!-- OTHER PEOPLE'S MESSAGES -->
		                        <!--  <li class="clearfix">
		                        	<div class="message other-message float-left"> 
		                        		<h6 class="chat-message-username other-username text-start">Mateus</h6>
			                            <p class="message-text text-start">Teste</p>
			                            <div class="message-data text-end">
		                                	<span class="message-data-time">11:00 AM, Today</span>
		                            	</div>
		                            </div>     
		                        </li>-->
		                        
		                       <c:forEach var="m" items="${messages}">
		                      		<c:if test="${m.user.currentSessionUser}">
										<li class="clearfix">		                            
				                            <div class="message my-message float-right"> 
				                            	<h6 class="chat-message-username my-username text-start">${m.user.userName}</h6>
				                            	<p class="message-text text-start"> ${m.textString}</p>
				                            	<div class="message-data text-end">
				                                	<span class="message-data-time">${m.dateTime}</span>
				                            	</div>
				                            </div>
			                        	</li>
		                        	</c:if>
		                      		<c:if test="${!m.user.currentSessionUser}">
		                      			<li class="clearfix">
				                        	<div class="message other-message float-left"> 
				                        		<h6 class="chat-message-username other-username text-start">${m.user.userName}</h6>
					                            <p class="message-text text-start"> ${m.textString} </p>
					                            <div class="message-data text-end">
				                                	<span class="message-data-time">${m.dateTime}</span>
				                            	</div>
				                            </div>                                    
				                        </li>								
		                        	</c:if>
								</c:forEach>
		                    </ul>
		                </div>
		                <form class="chat-message clearfix" method="post" action="">
		                    <div class="input-group mb-3"> 
							  <input type="text" class="form-control" placeholder="Escreva uma mensagem" aria-label="user message" name="user_form_input_message">
							  <button class="input-group-text btn btn-outline-secondary" type="button"><i class="fa fa-paperclip"></i></button>
							  <button class="input-group-text btn btn-secondary" type="submit" id="send-message"><i class="fa fa-paper-plane"></i></button>
							</div>
		            	</form> <!-- TODO: validate field before sending a message -->
		        	</div>
		    	</div>
			</div>
		</div>		
	</div>		
</body>
</html>