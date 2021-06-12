package com.agree.selenium.domain.entity;

/**
 * Created by 86183 on 2021/6/5.
 */

public class Case {
    private String Id;
    private String caseName;
    private String userName;
    private String userPwd;
    private String inputKey1;
    private String inputKey2;
    private String inputKey3;
    private String flag;
    private String result;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getInputKey1() {
        return inputKey1;
    }

    public void setInputKey1(String inputKey1) {
        this.inputKey1 = inputKey1;
    }

    public String getInputKey2() {
        return inputKey2;
    }

    public void setInputKey2(String inputKey2) {
        this.inputKey2 = inputKey2;
    }

    public String getInputKey3() {
        return inputKey3;
    }

    public void setInputKey3(String inputKey3) {
        this.inputKey3 = inputKey3;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Case(Case c) {
        Id = c.getId();
        this.caseName = c.getCaseName();
        this.userName = c.getUserName();
        this.userPwd = c.getUserPwd();
        this.inputKey1 = c.getInputKey1();
        this.inputKey2 = c.getInputKey2();
        this.inputKey3 = c.getInputKey3();
        this.flag = c.getFlag();
        this.result = c.getResult();
    }
    public Case() {

    }

    @Override
    public String toString() {
        return "Case{" +
                "Id='" + Id + '\'' +
                ", caseName='" + caseName + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", inputKey1='" + inputKey1 + '\'' +
                ", inputKey2='" + inputKey2 + '\'' +
                ", inputKey3='" + inputKey3 + '\'' +
                ", flag='" + flag + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
