package com.agree.selenium.domain.test;

import com.agree.selenium.domain.utils.Log;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.agree.selenium.domain.utils.Constant.EXCEL_PATH;

/**
 * Created by 86183 on 2021/6/5.
 */
public class TestExcel {
    private static XSSFSheet excelSheet;
    private static XSSFWorkbook excelBook;
    private static XSSFCell cell;
    private static XSSFRow row;

    public TestExcel(){

    }
    /**
     * 读取excel
     * @param path
     * @param sheetName
     */
    public static void setExcelFile(String path,String sheetName){
        FileInputStream excelFile;
        try {
            excelFile = new FileInputStream(path);
            excelBook = new XSSFWorkbook(excelFile);
            excelSheet = excelBook.getSheet(sheetName);
        }catch (Exception e){
            Log.error("读取sheet出错");
        }
    }

    /**
     * 获取excel数据
     * @param rownum
     * @param celnum
     * @return
     */
    public static String getCellData(int rownum,int celnum){
        cell = excelSheet.getRow(rownum).getCell(celnum);
        return cell.getCellTypeEnum()== CellType.STRING?cell.getStringCellValue().toString()
                :String.valueOf(Math.round(cell.getNumericCellValue()));
    }

    /**
     * 写入excel数据
     * @param rownum
     * @param celnum
     * @return
     */
    public static void setCellData(int rownum,int celnum,String result){
        row = excelSheet.getRow(rownum);
        cell = row.getCell(celnum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
        if (cell == null) {
            cell = row.createCell(celnum);
            cell.setCellValue(result);
        }else{
            cell.setCellValue(result);
        }
        try {
            FileOutputStream out = new FileOutputStream(EXCEL_PATH);
            excelBook.write(out);
            out.flush();
            out.close();
        }catch (Exception e){
            Log.error(e.toString());
        }
    }

    /**
     * 静态数据
     * @param path
     * @param sheetName
     * @return
     * @throws IOException
     */
    public  Object[][] getExcelData()
            throws IOException {
        String path="D:\\testcase\\126测试案例.xlsx";
        String sheetName="登录案例";
        File file = new File(path);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;
        String fileExtensName = path.substring(path.indexOf("."));
        if (fileExtensName.equals(".xlsx")){
            workbook = new XSSFWorkbook(inputStream);
        }else if (fileExtensName.equals(".xls")){
            workbook = new HSSFWorkbook(inputStream);
        }
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        List<Object[]> records = new ArrayList<Object[]>();
        for (int i = 0; i <rowCount+1 ; i++) {
            Row row = sheet.getRow(i);
            String[] fields = new String[row.getLastCellNum() - 2];
            if (row.getCell(row.getLastCellNum()- 2).getStringCellValue().equals("Y")) {
                for (int j = 0; j < row.getLastCellNum()-2; j++) {
                    fields[j] = row.getCell(j).getCellTypeEnum()== CellType.STRING?row.getCell(j).getStringCellValue().toString()
                            :String.valueOf(Math.round(row.getCell(j).getNumericCellValue()));
                }
                records.add(fields);
            }
        }
        Object[][] result = new Object[records.size()][];
        List list = new ArrayList();
        for (int i = 0; i < records.size(); i++) {
            result[i] = records.get(i);
        }
        //objectdataToMap(result);
        return  result;

    }

    @Test
    public  void objectdataToMap() throws IOException {
        Object[][] excelData = getExcelData();
        for (int i = 0; i <excelData.length ; i++) {
            for (int j = 0; j < excelData[i].length; j++) {
                System.out.println("===="+excelData[i][j]);
            }
        }
    }

    @Test(dependsOnMethods = {"objectdataToMap"})
    public  void test(){
        //System.out.println("11111111111");

    }
    /**
     * 获取列数
     * @return
     */
    public static int getLastColumnNum(){
        return excelSheet.getRow(0).getLastCellNum()-1;
    }


}
