package com.tts.homepage;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
/**
 * 
 * 项目名称：  ct_trip_tests   
 * 类名称：  Homepage1   
 * 描述：  检查首页的页面元素是否存在
 * @author  肖文瑶   
 * 创建时间：  2016年1月12日 下午12:59:01 
 * 修改人：肖文瑶    修改日期： 2016年1月12日
 * 修改备注：
 *
 */
public class Homepage1 {
private AndroidDriver driver;
	
	@BeforeClass
	public void setUp() {
		//调用init方法，启动模拟器
		Init init=new Init();
		driver=init.init(driver);
	}
	
	@AfterClass
    public void tearDown() {
		driver.quit();
    }
	
	@Test
	public void homepage1() {
		//调用init2方法，跳过app的欢迎页面
		Init2 init2=new Init2();
		driver=init2.init2(driver);
	    
	    Assert.assertTrue(driver.findElement(By.id("btn_qr")).isDisplayed());//检查扫码图标是否存在
	    Assert.assertTrue(driver.findElement(By.id("btn_call")).isDisplayed());//检查客服电话图标是否存在
	    
	    //检查各页面元素是否存在
		Assert.assertTrue(driver.findElement(By.name("出发城市")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.name("到达城市")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("tv_start_city_value")).isEnabled());
		Assert.assertTrue(driver.findElement(By.id("tv_end_city_value")).isEnabled());
		Assert.assertTrue(driver.findElement(By.id("img_change")).isEnabled());
		Assert.assertTrue(driver.findElement(By.name("出发日期")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.name("搜索")).isEnabled());
	}

}
