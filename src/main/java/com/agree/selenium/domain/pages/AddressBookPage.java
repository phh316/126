package com.agree.selenium.domain.pages;

import com.agree.selenium.domain.utils.ObjectMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by 86183 on 2021/5/29.
 */
public class AddressBookPage {

    private ObjectMap objectMap = new ObjectMap();

    private WebElement element = null;

    private WebDriver driver;

    public AddressBookPage(WebDriver driver){
        this.driver = driver;
    }
    /**
     * 点击新建联系人
     * @return
     * @throws Exception
     */
    public WebElement clickAddPerson()throws Exception{
        element = driver.findElement(objectMap.getLocator("project.login.newAddPerson"));
        return element!=null?element:null;
    }
    /**
     * 返回新建联系人姓名
     * @return
     * @throws Exception
     */
    public WebElement addUserName()throws Exception{
        element = driver.findElement(objectMap.getLocator("project.login.newPersonName"));
        return element!=null?element:null;
    }

    /**
     * 返回新建联系人邮箱
     * @return
     * @throws Exception
     */
    public WebElement addUserEmail()throws Exception{
        element = driver.findElement(objectMap.getLocator("project.login.newPersonEmail"));
        return element!=null?element:null;
    }
    /**
     * 返回新建联系人手机号
     * @return
     * @throws Exception
     */
    public WebElement addUserPhone()throws Exception{
        element = driver.findElement(objectMap.getLocator("project.login.newPersonPhone"));
        return element!=null?element:null;
    }
    /**
     * 返回新建联系人提交
     * @return
     * @throws Exception
     */
    public WebElement addUserSubmit()throws Exception{
        element = driver.findElement(objectMap.getLocator("project.login.newPersonSubmit"));
        return element!=null?element:null;
    }
}
