package com.agree.selenium.domain.modules;

import com.agree.selenium.domain.pages.LoginPage;
import com.agree.selenium.domain.utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.agree.selenium.domain.utils.Constant.BASE_URL;


/**
 * Created by 86183 on 2021/5/29.
 */
public class LoginAction {

    public static void execute(WebDriver driver,String name,String pwd)throws Exception{
        Log.startCase("开始执行登录案例");
        Log.info("打开网站");
        driver.get(BASE_URL);
        try{
            Boolean flag =  new WebDriverWait(driver,10).until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    return driver.getTitle().equals("126网易免费邮--你的专业电子邮");
                }
            });
            Log.info("打开网站成功");
        }catch (Exception e){
            Log.error("打开网站失败");
        }
        LoginPage loginPage = new LoginPage(driver);
        loginPage.switchToframe();
        Log.info("休眠2s");
        Thread.sleep(2000);
        Log.info("输入用户名："+name);
        loginPage.userName().sendKeys(name);
        Log.info("输入用户名完成");
        Thread.sleep(2000);
        Log.info("休眠2s");
        Log.info("输入密码："+pwd);
        loginPage.userPassWord().sendKeys(pwd);
        Log.info("输入密码完成");
        Thread.sleep(1000);
        Log.info("休眠2s");
        Log.info("点击登录");
        loginPage.userSubmit().click();
        Thread.sleep(3000);
        Log.infoc("登录完成");
    }
}
