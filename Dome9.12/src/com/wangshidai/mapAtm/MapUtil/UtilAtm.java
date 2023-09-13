package com.wangshidai.mapAtm.MapUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UtilAtm {
    static Scanner sn=new Scanner(System.in);
    //输入非int类型异常处理
    public static int inputnum(){
        int num=0;
        try {
            num = sn.nextInt();
        }catch (InputMismatchException e){
            System.out.println("输入的非整数");
            sn.nextLine();
        }
        return num;
    }
    //输入非string类型异常处理
    public static String inputstr(){
        String str=null;
        try {
            str = sn.next();
        }catch (InputMismatchException e){
            System.out.println("输入的非字符");
            sn.nextLine();
        }
        return str;
    }
    //输入非double类型异常处理
    public static double inputdou(){
        double dou=0.00;
        try {
            dou = sn.nextInt();
        }catch (InputMismatchException e){
            System.out.println("输入的非数字");
            sn.nextLine();
        }
        return dou;
    }
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
        return inputnum();
    }
    public  static int choose() {
        int cc = 0;
        while (true) {
            System.out.println("\t1.继续其他业务\t\t2.退出登录");
            int yn=inputnum();
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
    public static int intou(){
        return inputnum();
    }
    public static String strou(){
        return inputstr();
    }
    public static double douou(){
        return inputdou();
    }
}