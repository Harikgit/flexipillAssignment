package loginCartOrder;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FlexLCO {
	@Test(priority = 0)
	public void lgIn() {
		/*Response resp=RestAssured.get("https://flexipill-ui-new-staging.vercel.app/");
		System.out.println(resp.getBody());
		int fSCode=resp.getStatusCode();
		System.out.println(fSCode);
		System.out.println(resp.asString());*/
		
		RestAssured.baseURI = "https://backendstaging.platinumrx.in";
        String requestBody = "{ \"phone_number\": \"1111111111\", \"otp_code\": \"1111\" }";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/auth/login")
                .then()
                .extract()
                .response();

//        System.out.println("Response 1: " + response.asPrettyString());
        int success_id = response.path("success");
        Assert.assertEquals(success_id, 1);
        System.out.println("\nLogged in");
	}
	
	@Test(priority = 1)
	public void cart() {
		Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjM3NjksImF1dGhfdHlwZSI6ImV4dGVybmFsX2F1dGgiLCJpYXQiOjE3MTczOTcxMjQsImV4cCI6MTcxODAwMTkyNH0.RDMroLyvijoSApVQuNSp6vgyb2mjdYpoJ5VgTyUDpfw")
                .body("{\"increaseQuantityBy\":\"2\",\"drugCode\": 1110806}")
                .post("https://backendstaging.platinumrx.in/cart/addItem");
        
        response.then().statusCode(200);
//        System.out.println("Response 2: "+response.asPrettyString());
        Boolean itemStatus = response.path("message.isNewItemAdded");
        Assert.assertEquals(true, itemStatus);
        System.out.println("Item added to the Cart");
	}
	
	@Test(priority = 2)
	public void order() {
		Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjM3NjksImF1dGhfdHlwZSI6ImV4dGVybmFsX2F1dGgiLCJpYXQiOjE3MTczOTcxMjQsImV4cCI6MTcxODAwMTkyNH0.RDMroLyvijoSApVQuNSp6vgyb2mjdYpoJ5VgTyUDpfw")
                .body("{\"paymentType\":\"COD\",\"orderType\":\"SEARCH\",\"patientName\":\"test\",\"patientAddress\":\"test-block test-city test-state 577201\",\"patientMobileNumber\":\"9876543219\",\"patientAge\":\"23\",\"patientGender\":\"male\",\"pincode\":577201,\"city\":\"test-city\",\"state\":\"test-state\"}")
                .post("https://backendstaging.platinumrx.in/orders/initiateOrder");
        
        response.then().statusCode(200);
//        System.out.println("Response 3: "+response.asPrettyString());
        int success_id = response.path("success");
        Assert.assertEquals(success_id, 1);
        System.out.println("Order created");
	}
	
	@Test(priority = 3)
	public void negLginTest() {
		String negRequestBody = "{ \"phone_number\": \"1111111111\", \"otp_code\": \"1211\" }";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(negRequestBody)
                .when()
                .post("/auth/login")
                .then()
                .extract()
                .response();

//        System.out.println("Response 4: " + response.asPrettyString());
        int success_id = response.path("success");
        Assert.assertEquals(success_id, 0);
        System.out.println("Negative OTP Test is done");
	}
	
	@Test(priority = 4)
	public void negCartTest() {
		Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer abcd.efgh")
                .body("{\"increaseQuantityBy\":\"2\",\"drugCode\": 1110806}")
                .post("https://backendstaging.platinumrx.in/cart/addItem");
        
        response.then().statusCode(401);
//        System.out.println("Response 5: "+response.asPrettyString());
        int success_id = response.path("sucess");
        Assert.assertEquals(success_id, 0);
        System.out.println("Negative Authorization Test is done");
        Response qResponse = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjM3NjksImF1dGhfdHlwZSI6ImV4dGVybmFsX2F1dGgiLCJpYXQiOjE3MTczOTcxMjQsImV4cCI6MTcxODAwMTkyNH0.RDMroLyvijoSApVQuNSp6vgyb2mjdYpoJ5VgTyUDpfw")
                .body("{\"increaseQuantityBy\":\"0\",\"drugCode\": 1110806}")
                .post("https://backendstaging.platinumrx.in/cart/addItem");
//        System.out.println("qResponse: "+qResponse.asPrettyString());
        String cartDetails=(qResponse.path("message.userCart")).toString();
//        System.out.println("Cart Details: "+cartDetails);
        Assert.assertEquals(cartDetails, "[]");
        System.out.println("Empty Cart test is done");
        Response codeResponse = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjM3NjksImF1dGhfdHlwZSI6ImV4dGVybmFsX2F1dGgiLCJpYXQiOjE3MTczOTcxMjQsImV4cCI6MTcxODAwMTkyNH0.RDMroLyvijoSApVQuNSp6vgyb2mjdYpoJ5VgTyUDpfw")
                .body("{\"increaseQuantityBy\":\"2\",\"drugCode\": -6}")
                .post("https://backendstaging.platinumrx.in/cart/addItem");
//        System.out.println("codeResponse: "+codeResponse.asPrettyString());
        String codeErrMsg=codeResponse.path("errorMessage");
        Assert.assertEquals(codeErrMsg, "Error with addItemToCart -> Drug Data Not Found in Catalog");
//        int codeSuccess_id = codeResponse.path("success");
//        Assert.assertEquals(codeSuccess_id, 0);
        System.out.println("Negative drug code test is done\n");
	}
}
