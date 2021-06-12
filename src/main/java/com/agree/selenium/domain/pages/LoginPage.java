package com.agree.selenium.domain.pages;

import com.agree.selenium.domain.utils.Log;
import com.agree.selenium.domain.utils.ObjectMap;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by 86183 on 2021/5/29.
 */
public class LoginPage {

    private ObjectMap objectMap = new ObjectMap();

    private WebElement element = null;

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * 登录时，嵌套的iframe，使用switchto进行切换
     */
    public void switchToframe(){
        try {
            Log.startCase("开始切换iframe");
            Thread.sleep(1000);
            Log.startCase("休眠1s");
            driver.switchTo().frame(driver.findElement(objectMap.getLocator("project.login.iframe1")));
            Log.startCase("切换完成");
        } catch (NoSuchElementException e) {
            Log.error("未找到iframe");
        }catch (Exception e) {
            Log.error("查找iframe失败");
        }
    }
    /**
     * 回到默认的frame
     */
    public void defaultToFrame(){
        driver.switchTo().defaultContent();
    }

    /**
     * 返回用户名元素
     * @return
     * @throws Exception
     */
    public WebElement userName()throws Exception{
        element = driver.findElement(objectMap.getLocator("project.login.userName"));
        return element!=null?element:null;
    }

    /**
     * 返回用户密码
     * @return
     * @throws Exception
     */
    public WebElement userPassWord()throws Exception{
        element = driver.findElement(objectMap.getLocator("project.login.userpwd"));
        return element!=null?element:null;
    }
    /**
     * 返回登录
     * @return
     * @throws Exception
     */
    public WebElement userSubmit()throws Exception{
        element = driver.findElement(objectMap.getLocator("project.login.submit"));
        return element!=null?element:null;
    }
}
