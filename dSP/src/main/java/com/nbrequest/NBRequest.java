package com.nbrequest;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;






public class NBRequest {
	@Test
	public void generateNBRequest() {
		//10.151.33.63:30322
		RestAssured.baseURI = "http://10.151.33.63:30322";
		//RestAssured.baseURI = "http://10.151.33.63:30330";
		//RestAssured.baseURI = "http://10.151.32.200:30580";
		
		
		//RestAssured.baseURI = "http://10.151.33.63:30330";
		given().header("Content-Type", "application/json").header("callBackUrl","http://10.151.33.63:30322/nbrequest/fullfillmentServiceOrder/dummy/receive")
		.body("{\r\n" + 
				"  \"ACTION\":\"TESTPROVISIONINGJSON\",\r\n" + 
				"  \"ORDER_ID\":\"TEST_TC_00503fc8576-09d7-4a54-84e6-950773343796_11\",\r\n" + 
				"  \"SCHEDULE\":\"DYNAMIC\",\r\n" + 
				"  \"orderData\":{\r\n" + 
				"    \"IMSI\":\"414061130340108\",\r\n" + 
				"    \"CIRCLE_ID\":\"1\",\r\n" + 
				"    \"CATEGORY\":\"PREPAID_USIM\",\r\n" + 
				"    \"SUB_CATEGORY\":\"REGULAR\",\r\n" + 
				"    \"KI\":\"8AED970E288D33EACCFDD64BE7FDC99E\",\r\n" + 
				"    \"K4\":\"2\",\r\n" + 
				"    \"TRANSPORTKEYID\":\"40\",\r\n" + 
				"    \"AUC_SUBTEMPLATE\":\"123450000000806\",\r\n" + 
				"    \"SCHEDULE\":\"2018-01-22T13:06:33\"\r\n" + 
				"  }\r\n" + 
				"}")
	.when().post("nbrequest/fullfillmentServiceOrder/processServiceOrderAsync/wom")
	.then().assertThat().statusCode(202);
	}

}
