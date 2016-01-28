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
 * 类名称：  Homepage2   
 * 描述：  测试汽车票和汽车站的切换效果是否正确
 * @author  肖文瑶   
 * 创建时间：  2016年1月13日 下午2:12:31 
 * 修改人：肖文瑶    修改日期： 2016年1月13日
 * 修改备注：
 *
 */
public class Homepage2 {
private AndroidDriver driver;
	
	@BeforeClass
	public void setUp() {
		Init init=new Init();
		driver=init.init(driver);
	}
	
	@AfterClass
    public void tearDown() {
		driver.quit();
    }
	
	@Test
	public void homepage2() {
		Init2 init2=new Init2();
		driver=init2.init2(driver);
		
	    driver.findElement(By.name("汽车站")).click();//切换到“汽车站”标签
	    Assert.assertTrue(driver.findElement(By.name("城市")).isDisplayed());//检查页面元素“城市”是否存在
	    Assert.assertTrue(driver.findElement(By.id("textView5")).isEnabled());//检查选择城市标签是否可用
	    Assert.assertTrue(driver.findElement(By.name("搜索")).isEnabled());//检查搜索按钮是否可用
	}

}
