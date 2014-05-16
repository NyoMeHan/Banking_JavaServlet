  <%@ page import="dto.CurrentUser" %>
  <div  align="center">

 			<img src="pages/assets/ico/bank.ico"> 
 			<font size=26 color='#800080'>Team 4B Bank Application</font>
			<div align="right" >
            <form >
           
              <%if(session.getAttribute("currentUser")!=null){
            		CurrentUser currentUser = (CurrentUser)session.getAttribute("currentUser");
            	  out.println("Hi "+currentUser.getFirstName()+" "+currentUser.getLastName()); 
              }%>
              <br>
            <a href="${pageContext.request.contextPath}/logout.iss">logout</a>
                     
            </form>
          </div>
          <hr>
    </div>