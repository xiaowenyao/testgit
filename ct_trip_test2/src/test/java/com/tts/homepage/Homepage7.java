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
 * 项目名称：  ct_trip_tests   
 * 类名称：  Homepage7   
 * 描述：  出发城市，到达城市有值時，点击搜索跳转到对应的班次列表页
 * @author  肖文瑶   
 * 创建时间：  2016年1月18日 下午8:05:11 
 * 修改人：肖文瑶    修改日期： 2016年1月18日
 * 修改备注：
 *
 */
public class Homepage7 {
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
		
		// 选择出发城市为杭州
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.findElement(By.id("tv_start_city_value")).click();
		WebElement el2 = wait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				return d.findElement(By.id("searchET"));
			}
		});
		el2.sendKeys("杭州");
		wait = new WebDriverWait(driver, 60);
		driver.findElement(By.id("item_content")).click();		
		
		//选择到达城市为南京
	    driver.findElement(By.id("tv_end_city_value")).click();
	    WebElement el3= wait.until(new  ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver d) {
                return d.findElement(By.id("searchET"));
            }
        });
	    el3.sendKeys("nanjing");
	    wait = new WebDriverWait(driver, 60);
	    driver.findElement(By.name("南京")).click();
	    
	    driver.findElement(By.name("搜索")).click();//点击搜索按钮
	    //跳转到班次列表页
	    WebElement el4 = wait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				return d.findElement(By.id("tv_TitleBarText"));
			}
		});
	    assertThat(el4.getText(),equals("杭州-南京"));//检查标题是否为“杭州-南京”
	}

	private void assertThat(String text, boolean equals) {
		// TODO Auto-generated method stub
		
	}

}
