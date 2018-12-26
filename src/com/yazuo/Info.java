package com.yazuo;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/11/7 15:31
 */
public class Info {
 String name ;
    String people;
            String tel;
    String stoNum;
    String memNum;
    String tradeNum;
    String trandMoney;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getStoNum() {
        return stoNum;
    }

    public void setStoNum(String stoNum) {
        this.stoNum = stoNum;
    }

    public String getMemNum() {
        return memNum;
    }

    public void setMemNum(String memNum) {
        this.memNum = memNum;
    }

    public String getTradeNum() {
        return tradeNum;
    }

    public void setTradeNum(String tradeNum) {
        this.tradeNum = tradeNum;
    }

    public String getTrandMoney() {
        return trandMoney;
    }

    public void setTrandMoney(String trandMoney) {
        this.trandMoney = trandMoney;
    }

    @Override
    public String toString() {
        return "Info{" +
                "name='" + name + '\'' +
                ", people='" + people + '\'' +
                ", tel='" + tel + '\'' +
                ", stoNum=" + stoNum +
                ", memNum=" + memNum +
                ", tradeNum=" + tradeNum +
                ", trandMoney=" + trandMoney +
                '}';
    }
}
