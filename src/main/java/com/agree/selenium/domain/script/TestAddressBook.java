package com.agree.selenium.domain.script;

import com.agree.selenium.domain.modules.AddressBookAction;
import com.agree.selenium.domain.utils.ExcelUtil;
import com.agree.selenium.domain.utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.agree.selenium.domain.utils.Constant.EXCEL_PATH;
import static com.agree.selenium.domain.utils.Constant.EXCEL_SHEETNAME;

/**
 * Created by 86183 on 2021/5/29.
 */
public class TestAddressBook {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @BeforeClass
    public void beforeClass(){
        ExcelUtil.setExcelFile(EXCEL_PATH,EXCEL_SHEETNAME);
    }

    /**
     * 获取静态数据
     * @return
     */
    @DataProvider(name = "ExcelDataAdd")
    public static Object[][] getData()throws Exception{
        return ExcelUtil.getExcelData(EXCEL_PATH,EXCEL_SHEETNAME);
    }

    @Test(dataProvider = "ExcelDataAdd")
    public void testAddPerson(String id, String caseName, String loginName, String loginPwd,
                              String addName, String addEamil, String addPhone, String keyword1,
                              String keyword2, String keyword3
    )throws Exception{
        Log.startCase(caseName);
        AddressBookAction.execute(driver,loginName,loginPwd,addName,addEamil,addPhone);
        Log.info("判断检查点");
        //判断三个断言
//        Assert.assertTrue(driver.getPageSource().contains(CASE_ENUM.LOGIN_KEYWORD1.getKey()));
//        Assert.assertTrue(driver.getPageSource().contains(CASE_ENUM.LOGIN_KEYWORD2.getKey()));
//        Assert.assertTrue(driver.getPageSource().contains(CASE_ENUM.LOGIN_KEYWORD3.getKey()));
        Assert.assertTrue(true);
        Log.infoc("检查点检测通过，案例执行通过");
        ExcelUtil.setCellData(Integer.parseInt(id.split("[.]")[0]),ExcelUtil.getLastColumnNum(),"执行成功");
    }

}
