package com.tts.homepage;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.jetty.html.List;
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
 * 类名称：  Homepage3   
 * 描述：  点击出发城市和到达城市，跳转到正确的页面
 * @author  肖文瑶   
 * 创建时间：  2016年1月13日 下午7:04:04 
 * 修改人：肖文瑶    修改日期： 2016年1月13日
 * 修改备注：
 *
 */
public class Homepage3 {
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
	public void homepage3() {
		Init2 init2=new Init2();
		driver=init2.init2(driver);
		
	   //选择出发城市为杭州
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    driver.findElement(By.id("tv_start_city_value")).click();
	    WebElement el2= wait.until(new  ExpectedCondition<WebElement>() {
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
	    
	    //选择日期为明天
	    driver.findElement(By.id("lin_busticket_date")).click();
	    //java.util.List<WebElement> lis = driver.findElementsByClassName("android.widget.CheckedTextView");//获取CheckedTextView的所有元素
	    //WebElement el4 = lis.get(31);//获取列表中第32个元素,即日期27号
	    driver.findElement(By.name("明天")).click();
	   	
	    //检查页面选择的出发城市到达城市和日期是否正确显示在首页
	    driver.findElement(By.name("杭州")).isDisplayed();
	    driver.findElement(By.name("南京")).isDisplayed();
	    driver.findElement(By.name("明天")).isDisplayed();
	    
	}

}
