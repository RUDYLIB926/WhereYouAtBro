
<?php

$name = $_POST["name"];
$email = $_POST["email"];
$pass = $_POST["password"];
$address = "";
require "init.php";

$query = "select * from test where email like '".$email."';";
$result = mysqli_query($con, $query);

if(mysqli_num_rows($result)>0){
	$response = array();
	$code = "reg_false";
	$message = "User Already Exists...";
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode(array("server_response"=>$response));
}
else{
	$query = "INSERT INTO `test`(`email`, `name`, `password`, `address`) VALUES('".$email."','".$name."','".$pass."','".$address."');";
	$result = mysqli_query($con,$query);

	if(!$result){
		$response = array();
		$code = "reg_false";
		$message = "Some server error Occurred. Try again...";
		array_push($response,array("code"=>$code,"message"=>$message));
		echo json_encode(array("server_response"=>$response));
	}
	else{
		$response = array();
		$code = "reg_true";
		$message = "Registration Success... Thank you...";
		array_push($response,array("code"=>$code,"message"=>$message));
		echo json_encode(array("server_response"=>$response));
	}
}
mysqli_close($con);
?>