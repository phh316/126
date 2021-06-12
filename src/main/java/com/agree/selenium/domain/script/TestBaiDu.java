package com.agree.selenium.domain.script;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * Created by 86183 on 2021/6/12.
 */
public class TestBaiDu {
    @Test
    public void test001(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        driver.manage().window().maximize();
        //driver.findElement(By.id("s-usersetting-top")).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='设置']"))).perform();
        actions.moveToElement(driver.findElement(By.xpath("//a[text()='高级搜索']"))).click().perform();

    }
}
