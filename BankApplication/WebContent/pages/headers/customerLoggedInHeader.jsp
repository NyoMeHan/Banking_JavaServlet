<%@ page import="dto.CurrentUser" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%--   <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
       			<img src="pages/assets/ico/bank.ico"> 
 			<font size=26 color='#800080'>Team 4B Bank Application</font>
			<hr>
              <form class="navbar-form pull-right">    
               <ul class="nav">          
                <li class="active" >              
                <c:if test="${sessionScope.currentUser!=null}">
              <strong> <font color="orange"> Hi ${sessionScope.currentUser.firstName}</font> </strong>
                </c:if></li>
                  
           <li class="active"> <a href="/Team4bBankApplication/logout.iss">logout</a>
              </li>       
            </ul>
            </form>
          </div><!--/.nav-collapse -->
        </div>
      </div> --%>
      
  <div align="center">

 			<img src="pages/assets/ico/bank.ico"> 
 			<font size=24 color='#008000'>Team 4B Bank Application</font>
			<div align="right" >
            <form align="right" >
          		 <c:if test="${sessionScope.currentUser!=null}">
             	 <strong> <font color="orange"> Hi ${sessionScope.currentUser.firstName}</font> </strong>
               	</c:if>
              <br>
            <a href="${pageContext.request.contextPath}/logout.iss">logout</a>
                     
            </form>
          </div>
          <hr>
    </div>