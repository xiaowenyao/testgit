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
 * 类名称：  Homepage4   
 * 描述：  出发城市有值，到达城市为空时，互换按钮可点击，且内容互换
 * @author  肖文瑶   
 * 创建时间：  2016年1月15日 下午4:20:26 
 * 修改人：肖文瑶    修改日期： 2016年1月15日
 * 修改备注：
 *
 */
public class Homepage4 {
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
	public void homepage4() {
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
		
		//检查出发城市元素名称是否为“杭州”
		WebElement el4 = driver.findElement(By.id("tv_start_city_value"));
		assertThat(el4.getText(),equals("杭州"));
		
		driver.findElement(By.id("img_change")).click();//点击交换按钮
		
		//交换后，检查到达城市元素名称是否为“杭州”
		WebElement el5 = driver.findElement(By.id("tv_end_city_value"));
		assertThat(el5.getText(),equals("杭州"));
	}

	private void assertThat(String text, boolean equals) {}
}
