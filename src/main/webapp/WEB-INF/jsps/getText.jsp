<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html>

<link href="resources/css/bootstrap/bootstrap.min.css" rel="stylesheet"/>
<link href="resources/css/bootstrap/bootstrap-responsive.min.css" rel="stylesheet"/>
<link href="resources/css/text.css" rel="stylesheet"/>

<script src="<c:url value='resources/js/jquery-1.11.1.min.js' />"></script>
<script src="<c:url value='resources/js/bootstrap/bootstrap.min.js' />"></script>
<script src="<c:url value='resources/js/myText/getText.js' />"></script>
<script>
$(document).ready(function(){
	getTexts();
})
</script>
<body>
<div id="headingDiv">
	<h2>My Text</h2>
</div>
<div id="searchDiv" >
	<input type="search" id="searchText" class="searchInput" value="" placeholder="search" onchange="searchName();" />
	<div id="tableSection" class="displayTable">
		<table id="currentText" class="searchTable" border=1>
		
		</table>
	</div>
	<br/>
	<input type="button" id="submitButton" value="Add" onclick="swapSection('searchDiv','editDiv');">
</div>
<div id="editDiv" style="display:none;">
	<label>Title : </label>
	<input type="text" id="newText" value="" />
	<br/>
	<label>Text : </label>
	<textarea id="textDescription" rows="3" cols="20">
		Enter your text here...
	</textarea>
	<br/>
	<input type="button" id="saveButton" value="Save" onclick="saveContents(10);">
</div>

</body>
</html>