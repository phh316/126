package com.agree.selenium.domain.utils;

import org.openqa.selenium.By;

import java.io.*;
import java.util.Properties;

/**
 * Created by 86183 on 2021/5/29.
 */
public class ObjectMap {
    Properties properties;

    public ObjectMap(){
        properties = new Properties();
        try {
            Log.startCase("读取配置文件");
            Reader in = new InputStreamReader(new FileInputStream("src/main/resources/objectmap.properties"), "UTF-8");
            properties.load(in);
            in.close();
            Log.endtCase("读取文件结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public By getLocator(String locatorElementName)throws Exception{
        String locator = properties.getProperty(locatorElementName);
        String locatotType = locator.split(">")[0];
        String locatorValue = locator.split(">")[1];
        Log.info("获取的定位类型为 ："+locatotType+"\t 获取的定位表达式为 :"+locatorValue);
        if(locatotType.toLowerCase().equals("id")){
            return By.id(locatorValue);
        }else if (locatotType.toLowerCase().equals("name")) {
            return By.name(locatorValue);
        }else if (locatotType.toLowerCase().equals("classname")||locatotType.toLowerCase().equals("class")) {
            return By.className(locatorValue);
        }else if (locatotType.toLowerCase().equals("tagname")||locatotType.toLowerCase().equals("tag")) {
            return By.tagName(locatorValue);
        }else if (locatotType.toLowerCase().equals("linktext")||locatotType.toLowerCase().equals("link")) {
            return By.linkText(locatorValue);
        }else if (locatotType.toLowerCase().equals("css")||locatotType.toLowerCase().equals("cssselecctor")) {
            return By.cssSelector(locatorValue);
        }else if (locatotType.toLowerCase().equals("partiallinktext")) {
            return By.partialLinkText(locatorValue);
        }else if (locatotType.toLowerCase().equals("xpath")) {
            return By.xpath(locatorValue);
        }else{
            throw new Exception("输入的元素定位类型未定义"+locatotType);
        }
    }






















}
