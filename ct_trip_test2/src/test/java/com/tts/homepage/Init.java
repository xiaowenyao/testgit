package com.tts.homepage;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
/**
 * 
 * 项目名称：  ct_trip_tests   
 * 类名称：  Init   
 * 描述：  启动一个模拟器
 * @author  肖文瑶   
 * 创建时间：  2016年1月15日 下午4:07:48 
 * 修改人：肖文瑶    修改日期： 2016年1月15日
 * 修改备注：
 *
 */
public class Init {
	public  AndroidDriver  init(AndroidDriver driver){
		 File classpathRoot = new File(System.getProperty("user.dir"));
	        File appDir = new File(classpathRoot, "apps/ct_trip_test");
	        File app = new File(appDir, "app_debug.apk");
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("device","Android");
	        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	        capabilities.setCapability("platformName", "Android");
//	        设备名称在设置中，点击关于手机，型号
	        capabilities.setCapability("deviceName","Android Emulator");
//	        capabilities.setCapability("deviceName","Emulator-5554");
//	        capabilities.setCapability(CapabilityType.VERSION, "5.0.1");
	        capabilities.setCapability("deviceName","192.168.56.101:5555");
	        capabilities.setCapability(CapabilityType.VERSION, "4.4.4");        
//	        capabilities.setCapability("deviceName","410ae64894261100");
//	        capabilities.setCapability(CapabilityType.VERSION, "4.2.2");
	        capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
	        capabilities.setCapability("app", app.getAbsolutePath());
	        capabilities.setCapability("app-package","com.tts.hybird");
	        capabilities.setCapability("app-activity","com.tts.ct_trip.WelcomeActivity");
	        capabilities.setCapability("unicodeKeyboard", "True");
	        capabilities.setCapability("resetKeyboard", "True");
	        try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	        return driver;
	}
}
