package testClassPackage;

import java.io.IOException;
import java.time.LocalDate;
import org.testng.Assert;
import commonFunctionPackage.API_Common_Function;
import commonFunctionPackage.utility_Common_Function;
import io.restassured.path.json.JsonPath;
import requestRepositoryPackage.Post_Req_Repository;

public class Post_tc_1 {
	public static void execute() throws IOException {

		String baseURI = Post_Req_Repository.Post_baseURI();
		String resource = Post_Req_Repository.Post_resource();
		String requestBody = Post_Req_Repository.Post_requestBody();

		int statusCode = API_Common_Function.Post_statusCode(baseURI, resource, requestBody);
		System.out.println(statusCode);
		
		String responseBody = API_Common_Function.post_responseBody(baseURI, resource, requestBody);
		System.out.println(responseBody);
		
		// fetch the responsebody 
		JsonPath jsp = new JsonPath(responseBody);
		String res_id = jsp.getString("id");
		String res_name = jsp.getString("name");
		String res_createdAt = jsp.getString("createdAt");
		String res_year = jsp.getString("data.year");
		String res_price = jsp.getString("data.price");
		String res_CPU_model = jsp.getString("data.CPU_model");
		String res_Harddisk_size = jsp.getString("data.Harddisk_size");
		
		//parse request body
		JsonPath jspreq=new JsonPath(requestBody);
		String req_name=jspreq.getString("name");
		String req_year=jspreq.getString("data.year");
		String req_price=jspreq.getString("data.price");
		String req_CPU_model=jspreq.getString("data.CPU_model");
		String req_Harddisk_size=jspreq.getString("data.Harddisk_size");
		String currentdate=LocalDate.now().toString();
		
		//validate 
		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_year, req_year);
		Assert.assertEquals(res_price, req_price);
		Assert.assertEquals(res_CPU_model, req_CPU_model);
		Assert.assertEquals(res_Harddisk_size, req_Harddisk_size);
		Assert.assertEquals(res_createdAt.substring(0,10), currentdate);
		Assert.assertNotNull(res_id);
		
		utility_Common_Function.evidencefilecreate("Post_tc_1", requestBody, responseBody);
	}
}
