package com.agree.selenium.domain.pages;

import com.agree.selenium.domain.utils.ObjectMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by 86183 on 2021/5/29.
 */
public class HomePage {

    private ObjectMap objectMap = new ObjectMap();

    private WebElement element = null;

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    /**
     * 点击通讯录
     * @return
     * @throws Exception
     */
    public WebElement clickMailList()throws Exception{
        element = driver.findElement(objectMap.getLocator("project.login.mailListClick"));
        return element!=null?element:null;
    }

}
