package requestRepositoryPackage;

public class Post_Req_Repository {
	public static String Post_baseURI() {
		
		String baseURI = "https://api.restful-api.dev";
		return baseURI;
	}
	public static String Post_resource() {
		String resource = "/objects";
		return resource;
	}
	public static String Post_requestBody() {
		String requestBody="{\r\n"
				+ " \"name\": \"Apple MacBook Pro 16\",\r\n"
				+ " \"data\": {\r\n"
				+ " \"year\": 2019,\r\n"
				+ " \"price\": 1849.99,\r\n"
				+ " \"CPU_model\": \"Intel Core i9\",\r\n"
				+ " \"Harddisk_size\": \"1 TB\"\r\n"
				+ " }\r\n"
				+ "}";
		return requestBody; 
	}  
}

