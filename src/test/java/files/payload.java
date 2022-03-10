package files;

public class payload {
	public static String Address = "29, side layout, cohen 09";
	public static String NewAddress = "jainKokila";
	
	public static String addBody(){
		
		return "{\r\n" + 
				"	\"location\": {\r\n" + 
				"	\"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"             },\r\n" + 
				"\"accuracy\": 50,\r\n" + 
				"\"name\": \"Frontline house\",\r\n" + 
				"\"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"\"address\": \""+Address+"\",\r\n" + 
				"\"types\": [\"shoe park\",\"shop\" ],\r\n" + 
				"\"website\":\"http://google.com\",\r\n" + 
				"\"language\": \"French-IN\"\r\n" + 
				"}";
	}
	
	public static String updateBody(String PlaceId){
		
		return "{\r\n" + 
				"    \"place_id\" :\""+PlaceId+"\",\r\n" + 
				"    \"address\": \""+NewAddress+"\",\r\n" + 
				"    \"key\": \"qaclick123\"\r\n" + 
				"}";
	}
	
	public static String deleteRequestPayload(String PlaceId){
		return "{\r\n" + 
				"    \"place_id\" : \""+PlaceId+"\"\r\n" + 
				"}";
	}
	
	public static String addComplexJson(){
		return "{\r\n" + 
				"	\"dashboard\": {\r\n" + 
				"		\"purchaseAmount\": 910,\r\n" + 
				"		\"website\": \"rahulshettyacademy.com\"\r\n" + 
				"	},\r\n" + 
				"	\"courses\":[\r\n" + 
				"	{\r\n" + 
				"		\"title\": \"Selenium\",\r\n" + 
				"		\"price\": 50,\r\n" + 
				"		\"copies\" :6\r\n" + 
				"	},\r\n" + 
				"	{\r\n" + 
				"		\"title\": \"JAVA\",\r\n" + 
				"		\"price\": 60,\r\n" + 
				"		\"copies\" :7\r\n" + 
				"	},\r\n" + 
				"	{\r\n" + 
				"		\"title\": \"Appium\",\r\n" + 
				"		\"price\": 30,\r\n" + 
				"		\"copies\" :3\r\n" + 
				"	}\r\n" + 
				"	]\r\n" + 
				"}";
	}
	
	public static String AddBook(String isbn, String aisle){
		String payLoad = "{\r\n" + 
				"\"name\":\"Learn Appium amit\",\r\n" + 
				"\"isbn\" : \""+isbn+"\",\r\n" + 
				"\"aisle\" : \""+aisle+"\",\r\n" + 
				"\"author\": \"john\"\r\n" + 
				"}";
		return payLoad;
	}

}
