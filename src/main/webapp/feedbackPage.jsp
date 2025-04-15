<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback Page</title>
<link  href="feedbackPageCss.css" rel="stylesheet"/>
<script>
let count = localStorage.getItem("feedbackCount") || 1;

function autoincrement() {
    document.getElementById("id").value = count;
    localStorage.setItem("feedbackCount", ++count);
}

</script>
</head>
<body>

<div class="container">

<h3>feedback form</h3>
<form action="feedbackPage" method="post" onsubmit="autoincrement()">

Id:<br><input type="text"  id="id"name="id1" placeholder="Enter the id-Number" readonly/><br/><br/>
Student Roll-no: <br><input type="text" name="stdrollno1" placeholder="Enter the Roll-Number" required/><br/><br/>
subject-name:<br><input type="text"  name="subjectname1" placeholder="Enter the Full-name" required/><br/><br/>
Teacher-name:<br><input type="text"  name="teachername1" placeholder="Enter the Teacher-name" required/><br/><br/>
Comments:<br><textarea  name="comment1" required></textarea><br/><br/>
Rating out of five :
<br><input type="radio" name="rating1"   value="1" required/><label>1</label><br/>
<input type="radio" name="rating1"  value="1"  required/><label>2</label><br/>
<input type="radio" name="rating1"  value="1"  required/><label>3</label><br/>
<input type="radio" name="rating1"  value="1"  required/><label>4</label><br/>
<input type="radio" name="rating1"  value="1"  required/><label>5</label><br/>
<input type="submit" value="submit"/>

</form>

</div>



</body>
</html>