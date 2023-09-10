package com.wangshidai.ATM.AtmUtil;

import java.util.Scanner;

public class UtilAtm {
    static Scanner sn=new Scanner(System.in);
    public static void atm(){
        System.out.println("******************************");
        System.out.println("*\t\t\t\t\t\t*");
        System.out.println("*\t\t\tATM\t\t\t*");
        System.out.println("*\t\t\t\t\t\t*");
        System.out.println("******************************");
    }
    public static int id(){
        System.out.println("输入卡号：");
        int id=sn.nextInt();
        return id;
    }
    public static String name(){
        System.out.println("输入姓名：");
        String name=sn.next();
        return name;
    }
    public static int password(){
        System.out.println("输入密码：");
       int password=sn.nextInt();
        return password;
    }
    public static int password1(){
        System.out.println("确认密码：");
        int password1=sn.nextInt();
        return password1;
    }
    public static double money(){
        System.out.println("存入：");
        double money=sn.nextDouble();
        return money;
    }
}
