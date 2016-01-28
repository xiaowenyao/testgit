package com.tts.login;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tts.homepage.Init;
import com.tts.homepage.Init2;
/**
 * 
 * 项目名称：  ct_trip_test2   
 * 类名称：  Loginpage   
 * 描述：  检查登录页面各元素是否正常显示
 * @author  肖文瑶   
 * 创建时间：  2016年1月22日 下午2:16:47 
 * 修改人：肖文瑶    修改日期： 2016年1月22日
 * 修改备注：
 *
 */
public class Loginpage {
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
		//进入登录页面
		driver.findElement(By.name("我的")).click();
		driver.findElement(By.name("登录/注册")).click();
		//检查顶部标题是否为“登录”
		WebElement el1 = driver.findElement(By.id("tv_TitleBarText"));
		asserThat(el1.getText(),equals("登录"));
		//检查页面元素是否有“普通登录”控件
		WebElement el2 = driver.findElement(By.id("normalLoginRB"));
		asserThat(el2.getText(),equals("普通登录"));
		//检查页面元素是否有“动态密码登录”控件
		WebElement el3 = driver.findElement(By.id("dynamicPasswordRB"));
		asserThat(el3.getText(),equals("动态密码登录"));
		//检查页面元素是否有“验证手机/昵称/邮箱”
		WebElement el4 = driver.findElement(By.id("loginNameET"));
		asserThat(el4.getText(),equals("验证手机/昵称/邮箱"));
		//检查页面元素是否有“密码”
		WebElement el5 = driver.findElement(By.id("loginPasswordET"));
		asserThat(el5.getText(),equals("密码"));
		//检查页面元素是否有“忘记密码”控件
		WebElement el6 = driver.findElement(By.id("forgetPasswordTV"));
		asserThat(el6.getText(),equals("忘记密码"));
		//检查页面元素是否有“快速注册”控件
		WebElement el7 = driver.findElement(By.id("quickRegisterTV"));
		asserThat(el7.getText(),equals("快速注册"));
		//检查页面元素是否有“登录”按钮
		WebElement el8 = driver.findElement(By.id("loginBT"));
		asserThat(el8.getText(),equals("登录"));		
	}

	private void asserThat(String text, boolean equals) {
		// TODO Auto-generated method stub
		
	}
}
