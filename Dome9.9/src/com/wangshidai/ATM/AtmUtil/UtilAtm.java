package com.wangshidai.ATM.AtmUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UtilAtm {
    static Scanner sn=new Scanner(System.in);
    public static void atm(){
        System.out.println("*********************************");
        System.out.println("*\t\t\t        \t\t\t*");
        System.out.println("*\t\t\t 中国银行 \t\t\t*");
        System.out.println("*\t\t\t        \t\t\t*");
        System.out.println("*********************************");
    }
    //生成卡号：四位随机数+系统时间+用户身份证后四位
    public static String uid(){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String strTime=simpleDateFormat.format(date);
        //剔除系统时间字符串中的“-”
        String strTime1=strTime.replace("-","");
        System.out.println("输入身份证后四位:");
        int numid=sn.nextInt();
        //四位随机数
        int nuid=(int) (Math.random()*10000);
        String uid=nuid+strTime1+numid;
        return uid;
    }
    public static String id(){
        System.out.println("输入卡号：");
        String id=sn.next();
        return id;
    }
    public static String name(){
        System.out.println("输入姓名：");
        String name=sn.next();
        return name;
    }
    public static int password(){
        int count=0;
        System.out.println("输入六位数密码：");
        int password=sn.nextInt();
        return password;
    }
    public static int password1(){
        System.out.println("确认六位数密码：");
        int password1=sn.nextInt();
        return password1;
    }
    public static double money(){
        System.out.println("存入：");
        double money=sn.nextDouble();
        return money;
    }
}
