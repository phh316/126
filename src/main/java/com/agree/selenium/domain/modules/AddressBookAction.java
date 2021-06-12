package com.agree.selenium.domain.modules;

import com.agree.selenium.domain.pages.AddressBookPage;
import com.agree.selenium.domain.pages.HomePage;
import com.agree.selenium.domain.utils.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by 86183 on 2021/5/29.
 */
public class AddressBookAction {

    public static void execute(WebDriver driver, String loginName, String loginPwd,
                               String addName, String addEamil, String addPhone)throws Exception{
        LoginAction.execute(driver,loginName,loginPwd);
        Thread.sleep(2000);
        Log.info("判断检查点");
        Assert.assertTrue(driver.getPageSource().contains("未读邮件"));
        HomePage homePage = new HomePage(driver);
        Log.info("点击通讯录按钮");
        homePage.clickMailList().click();
        AddressBookPage bookPage = new AddressBookPage(driver);
        Log.info("点击新建联系人按钮");
        Thread.sleep(4000);
        bookPage.clickAddPerson().click();
        Thread.sleep(2000);
        Log.info("输入新建联系人姓名");
        bookPage.addUserName().sendKeys(addName);
        Log.info("输入新建联系人邮箱");
        bookPage.addUserEmail().sendKeys(addEamil);
        Log.info("输入新建联系人电话");
        bookPage.addUserPhone().sendKeys(addPhone);
        Log.info("输入保存按钮");
        bookPage.addUserSubmit().click();

    }
}
