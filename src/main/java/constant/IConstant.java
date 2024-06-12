package constant;

public interface IConstant {

	String CONFIG_FILE 				= "config.properties";
	String CLOUD_CONFIG_FILE		= "cloud_config.properties";
	
	// ------ MODE Value
	
	String LOCAL					= "local";
	String CLOUD					= "cloud";
	
	
	// ------ Key in config.properties
	
	String MODE						= "mode";
	String URL 						= "url";
	String PAGE_LOAD_TIME 			= "page_load";
	String IMPLICITLY_WAIT_TIME 	= "imlicitly_wait";
	
	
	// ------ Cloud Config Key
	
	String BS_OPT 					= "bstack:options";
	String BS_USER					= "user_name";
	String BS_KEY					= "bs_key";
	String BS_OS					= "os";
	String BS_OS_VER				= "osVersion";
	String BS_BROWSER				= "browserName";
	String BS_BEROWSER_VER			= "browserVersion";
	String BS_DEVICE_NAME			= "deviceName";
	String BS_DEVICE_ORIENTATION	= "deviceOrientation";
	String BS_URL					= "bs_url";
	
}
