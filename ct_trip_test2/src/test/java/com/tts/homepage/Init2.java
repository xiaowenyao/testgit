package com.tts.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
/**
 * 
 * 项目名称：  ct_trip_tests   
 * 类名称：  Init2   
 * 描述：  打开app后展示的欢迎页上的操作
 * @author  肖文瑶   
 * 创建时间：  2016年1月15日 下午4:08:19 
 * 修改人：肖文瑶    修改日期： 2016年1月15日
 * 修改备注：
 *
 */
public class Init2 {
	public  AndroidDriver  init2(AndroidDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement el= wait.until(new  ExpectedCondition<WebElement>() {
	            public WebElement apply(WebDriver d) {
	                return d.findElement(By.className("android.widget.ImageView"));
	            }
	        });
	    el.click();//等待春运欢迎页面加载
	    
	    //向左滑动页面，展示第二张欢迎页
	    int width=driver.manage().window().getSize().width;
        int height=driver.manage().window().getSize().height;  
        driver.swipe(width*5/6,height/2, width*1/6,height/2, 1200);
	    wait = new WebDriverWait(driver, 60);
	    //查找“立即体验”元素
	    java.util.List<WebElement> lis = driver.findElementsByClassName("android.widget.RelativeLayout");//获取ImageView的所有元素
	    WebElement targetEle = lis.get(0);//获取列表中第一个元素
	    targetEle.click();//点击立即体验
	    
	    return driver;
	}

}
