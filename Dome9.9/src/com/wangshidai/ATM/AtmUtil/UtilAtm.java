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
    //选择业务
    public static int  atmA(){
        System.out.println("\t1.存款\t\t2.取款\n\t3.查询余额\t4.转账\n\t5.退出登录");
        System.out.println("选择业务:");
        int num = sn.nextInt();
        return num;
    }
    public  static int choose() {
        int cc = 0;
        while (true) {
            System.out.println("\t1.继续其他业务\t\t2.退出登录");
            int yn = sn.nextInt();
            if (yn == 1) {
                return cc;
            } else if (yn == 2) {
                cc = 1;
                return cc;
            } else {
                System.out.println("选择错误");
            }
        }
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
        System.out.println("金额：");
        double money=sn.nextDouble();
        return money;
    }
}