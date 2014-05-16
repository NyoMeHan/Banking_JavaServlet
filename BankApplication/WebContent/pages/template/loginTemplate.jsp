<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Banking System</title>
<link href="pages/assets/css/bootstrap.css" rel="stylesheet">
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}
</style>
<link href="pages/assets/css/bootstrap-responsive.css" rel="stylesheet">

</head>
<body>	
	<tiles:insertAttribute name="header" />
	<div style="position: absolute; left: 27%;top: 30%">
		<div class="row" >
			
			<!-- <div class="span9"> -->
			 <div style = "position: absolute" >
				<tiles:insertAttribute name="body" />
			</div>
			<hr>
		</div>
		
	</div>
	<!-- container -->


	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="pages/assets/js/jquery.js"></script>
	<script src="pages/assets/js/bootstrap-transition.js"></script>
	<script src="pages/assets/js/bootstrap-alert.js"></script>
	<script src="pages/assets/js/bootstrap-modal.js"></script>
	<script src="pages/assets/js/bootstrap-dropdown.js"></script>
	<script src="pages/assets/js/bootstrap-scrollspy.js"></script>
	<script src="pages/assets/js/bootstrap-tab.js"></script>
	<script src="pages/assets/js/bootstrap-tooltip.js"></script>
	<script src="pages/assets/js/bootstrap-popover.js"></script>
	<script src="pages/assets/js/bootstrap-button.js"></script>
	<script src="pages/assets/js/bootstrap-collapse.js"></script>
	<script src="pages/assets/js/bootstrap-carousel.js"></script>
	<script src="pages/assets/js/bootstrap-typeahead.js"></script>
</body>
</html>