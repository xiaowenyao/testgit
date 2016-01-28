package com.tts.login;

import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tts.homepage.Init;
import com.tts.homepage.Init2;
/**
 * 
 * 项目名称：  ct_trip_test2   
 * 类名称：  LoginFailed   
 * 描述：  登录失败的几种情况
 * @author  肖文瑶   
 * 创建时间：  2016年1月22日 下午4:40:39 
 * 修改人：肖文瑶    修改日期： 2016年1月22日
 * 修改备注：
 *
 */
public class LoginFailed {
	private AndroidDriver driver;

	@BeforeClass
	public void setUp() {
		Init init = new Init();
		driver = init.init(driver);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void loginpage() {
		Init2 init2 = new Init2();
		driver = init2.init2(driver);
		
		//输入
	}

}
