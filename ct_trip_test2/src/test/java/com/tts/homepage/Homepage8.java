package com.tts.homepage;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
/**
 * 
 * 项目名称：  ct_trip_test2   
 * 类名称：  Homepage8   
 * 描述：  点击底部4个控件会跳转到对应的页面
 * @author  肖文瑶   
 * 创建时间：  2016年1月22日 下午1:55:44 
 * 修改人：肖文瑶    修改日期： 2016年1月22日
 * 修改备注：
 *
 */
public class Homepage8 {
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
	public void homepage7() {
		Init2 init2 = new Init2();
		driver = init2.init2(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.findElement(By.name("活动")).click();//点击底部活动标签
		//跳转到活动页面
		WebElement el1 = wait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				return d.findElement(By.id("tv_TitleBarText"));
			}
		});
	    assertThat(el1.getText(),equals("活动"));//检查顶部标题是否为“活动”
	    
	    driver.findElement(By.name("订单")).click();//点击底部订单标签
		//未登录情况下跳转到登录页面
		WebElement el2 = wait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				return d.findElement(By.id("tv_TitleBarText"));
			}
		});
	    assertThat(el2.getText(),equals("登录"));//检查顶部标题是否为“登录”
	    driver.findElement(By.id("iv_TitleBarBack")).click();//点击返回按钮，返回首页
	    
	    driver.findElement(By.name("我的")).click();//点击底部我的畅途标签
		//跳转到我的畅途页面，检查页面是否有“欢迎来到畅途”几个字
		wait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				return d.findElement(By.name("欢迎来到畅途"));
			}
		});
	}

	private void assertThat(String text, boolean equals) {
		// TODO Auto-generated method stub
		
	}

}
