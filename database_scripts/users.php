<?php

require "init.php";

$sql = "SELECT name,address FROM test";
$result = mysqli_query($con, $sql);

$response = array();

while ($row = mysqli_fetch_assoc($result)){
	array_push($response, array("Name"=>$row["name"],"Address"=>$row["address"]));
}
echo json_encode($response);

mysqli_close($con);
?>