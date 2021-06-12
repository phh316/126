package com.agree.selenium.domain.script;

import com.agree.selenium.domain.modules.LoginAction;
import com.agree.selenium.domain.utils.Constant;
import com.agree.selenium.domain.utils.ExcelUtil;
import com.agree.selenium.domain.utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


/**
 * Created by 86183 on 2021/5/29.
 */
public class TestLogin {

    public WebDriver driver;

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
        ExcelUtil.setExcelFile(Constant.EXCEL_PATH, Constant.EXCEL_SHEETNAME);
    }

    @DataProvider(name = "ExcelData")
    public static Object[][] getData()throws Exception{
        Object[][] result = ExcelUtil.getExcelData(Constant.EXCEL_PATH, Constant.EXCEL_SHEETNAME);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        return result;
//        List<Object[]> list = new ArrayList<>();
//        Case c1 = new Case();
//        c1.setId("00001");
//        c1.setCaseName("00001");
//        c1.setFlag("00001");
//        c1.setInputKey1("00001");
//        c1.setInputKey2("00001");
//        c1.setInputKey3("00001");
//        c1.setUserName("00001");
//        c1.setUserPwd("00001");
//        c1.setResult("00001");
//        Case c2 = new Case();
//        c2.setId("0002");
//        c2.setCaseName("0002");
//        c2.setFlag("0002");
//        c2.setInputKey1("0002");
//        c2.setInputKey1("0002");
//        c2.setInputKey1("0002");
//        c2.setUserName("0002");
//        c2.setUserPwd("0002");
//        c2.setResult("0002");
//        Object[] obj = new Object[2];
//        obj[0] = c1;
//        obj[1] = c2;
//        list.add(obj);
//        return new Object[][]{new Object[]{new Case(c1)}};
    }


    @Test(dataProvider ="ExcelData")
    public void testLogin001(String id, String caseName, String loginName, String loginPwd,
                             String keyword1, String keyword2, String keyword3)throws Exception{
        Log.startCase(caseName);
        LoginAction.execute(driver,loginName,loginPwd);
        Log.info("判断检查点");
        Assert.assertTrue(driver.getPageSource().contains("未读邮件"));
        Log.infoc("检查点检测通过，案例执行通过");
        ExcelUtil.setCellData(Integer.parseInt(id.split("[.]")[0]),ExcelUtil.getLastColumnNum(),"执行成功");
    }
}
