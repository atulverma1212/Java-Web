<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
function submitForm() {
	var formData = JSON.stringify({"name" :  $("#name").val(),
        "salary" : $("#salary").val(),
        "city": $("#city").val(),
        "state": $("#state").val(),
        "pincode": $("#pincode").val() });
	$.ajax({
		url : "rest/submit",
		type : "POST",
		contentType: "application/json",
		data: formData,
		success : function(data) {
			 window.alert(data);
			 $("form")[0].reset();
			 $("#listButton").click();
		}
	});
}

function del(id)
{
	$.ajax({
		url : "rest/del/"+id,
		type : "GET",
		contentType: "application/json",
		success : function(data) {
			$("#empList").empty().append(data);
		}
	});
}

$(document).ready(function(){
	$("#listButton").click(function(){
		if($("#listButton").val()=="List Employees"){
			$.get("rest/list", function(data){
		    	$("#empList").empty().append(data);
		    	$("#listButton").val("Clear List");
		    });
		} else {
			$("#empList").empty();
			$("#listButton").val("List Employees");
		}	    
	});
});
</script>
</head>
<body>
<%
         Date date = new Date();
         out.print( "<h5 align = \"right\">" +date.toString() + "</h5>");
      %>
<center>
<h2>Registration Form</h2>
<h4>Please fill the details below</h4>
<hr>
<form method="post" name="myForm" enctype='application/json'>
<b>Name: </b>
<input name="name" id="name" value="hello" type="text" maxlength="10"/><br>
<b>Salary: </b>
<input name="salary" id="salary" value="5000" type="text" maxlength="6"/><br>
<b>City: </b>
<input name="city" id="city" value="hello" type="text" maxlength="10"/><br>
<b>State: </b>
<input name="state" id="state" value="hello" type="text" maxlength="10"/><br>
<b>Pincode: </b>
<input name="pincode" id="pincode" value="5000"  type="text" maxlength="6"/><br>
<hr>
<input type="Button" value="Make Payment" onclick="submitForm()"></input> 
&emsp;
<input type="Button" value="List Employees" id="listButton"></input>
</form>
<div id="empList" name="empList">
</div>
</center>
</body>
</html>