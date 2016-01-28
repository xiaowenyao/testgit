package com.tts.login;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tts.homepage.Init;

/**
 * 
 * 项目名称：  ct_trip_tests   
 * 类名称：  LoginSuccess   
 * 描述：  输入正确的用户名和密码能够成功登录
 * @author  肖文瑶   
 * 创建时间：  2016年1月12日 下午12:58:17 
 * 修改人：肖文瑶    修改日期： 2016年1月12日
 * 修改备注：
 *
 */
public class LoginSuccess {
private AndroidDriver driver;
	
    @BeforeClass
    public void setUp() {
    	Init init = new Init();
    	driver = init.init(driver);
    }
    
	@AfterClass
    public void tearDown (){
		driver.quit();
    }
	
	@Test
	public void login(){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement el= wait.until(new  ExpectedCondition<WebElement>() {
	            public WebElement apply(WebDriver d) {
	                return d.findElement(By.className("android.widget.ImageView"));
	            }
	        });
	    el.click();//等待春运欢迎页面加载
	    driver.swipe(400,400,50,400,1000);//向左滑动页面，展示第二张欢迎页
	    wait = new WebDriverWait(driver, 60);
	    
	    java.util.List<WebElement> lis = driver.findElementsByClassName("android.widget.RelativeLayout");//获取ImageView的所有元素
	    WebElement targetEle = lis.get(0);//获取列表中第一个元素
	    targetEle.click();//点击立即体验
	    
	    driver.findElement(By.name("我的")).click();
		driver.findElement(By.name("登录/注册")).click();
		driver.findElement(By.id("loginNameET")).sendKeys("15651711729");
		driver.findElement(By.id("loginPasswordET")).sendKeys("123qweasdzxc");
	    driver.swipe(400,400, 400,250, 1000);
        WebElement el2= wait.until(new  ExpectedCondition<WebElement>() {
	            public WebElement apply(WebDriver d) {
	                return d.findElement(By.id("loginBT"));
	            }
	        });
        el2.click();
	}

}
