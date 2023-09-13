package com.wangshidai.mapAtm.MapAtmView;

import com.wangshidai.mapAtm.MapSever.SeverAtm;
import com.wangshidai.mapAtm.MapUtil.UtilAtm;
import com.wangshidai.mapAtm.domin.Accoun;

public class AtmTest01 {
    static SeverAtm severAtm=new SeverAtm();

    //开户
    public static void Openatm(){
        System.out.println("输入姓名:");
        String name=UtilAtm.strou();
        System.out.println("输入卡号:");
        int id=UtilAtm.intou();
        System.out.println("输入密码:");
        int password=UtilAtm.intou();
        System.out.println("再次输入密码:");
        int password1=UtilAtm.intou();
        Accoun accoun=new Accoun(id,name,password,password1,0);
        boolean state=severAtm.openAccoun(id,accoun);
        if (state){
            System.out.println("开户成功");
        }else {
            System.out.println("开户失败");
        }
    }

    //登录
    public static int longing(){
        System.out.println("输入卡号:");
        int id=UtilAtm.intou();
        System.out.println("输入密码:");
        int password=UtilAtm.intou();
        boolean state = severAtm.login(id,password);
        if (state){
            return id;
        }else {
            System.out.println("登录失败");
            id=-1;
        }
        return id;
    }

    //存款
    public static void inmoney(Integer id){
        System.out.println("输入存款金额:");
        double money=UtilAtm.douou();
        boolean state=severAtm.deposit(id,money);
        if (state){
            System.out.println("存款成功");
            //查询余额
            severAtm.inquire(id);
        }else {
            System.out.println("存款失败");
        }
    }

    //取款
    public static void  outMoney(Integer id){
        System.out.println("输入取款金额");
        double money=UtilAtm.douou();
        boolean state=severAtm.Withdrawal(id,money);
        if (state){
            System.out.println("取款成功");
            //查询余额
            severAtm.inquire(id);
        }else {
            System.out.println("取款失败");
        }
    }

    //转账
    public static void trenmoney(Integer id){
        System.out.println("输入转入账户:");
        int id1=UtilAtm.intou();
        System.out.println("输入转帐金额:");
        double money=UtilAtm.douou();
        boolean state=severAtm.transfer(id,money,id1);
        if (state){
            System.out.println("转账成功");
            //查询余额
            severAtm.inquire(id);
        }else {
            System.out.println("转账失败");
        }
    }
    //业务界面
    public static void atmView(Integer id){
        while (true) {
            UtilAtm.atm();
            int num = UtilAtm.atmA();
            //1.存款 2.取款 3.查询余额 4.转账 5.退出登录
            if (num==1){
                inmoney(id);
                int cc=UtilAtm.choose();
                if (cc==1){
                    System.out.println("欢迎下次使用");
                    break;
                }
            }else if (num==2){
                outMoney(id);
                int cc=UtilAtm.choose();
                if (cc==1){
                    System.out.println("欢迎下次使用");
                    break;
                }
            }else if (num==3){
                severAtm.inquire(id);
                int cc=UtilAtm.choose();
                if (cc==1){
                    System.out.println("欢迎下次使用");
                    break;
                }
            }else if (num==4){
                trenmoney(id);
                int cc=UtilAtm.choose();
                if (cc==1){
                    System.out.println("欢迎下次使用");
                    break;
                }
            }else if (num==5){
                System.out.println("欢迎下次使用");
                break;
            }else {
                System.out.println("选择错误");
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            UtilAtm.atm();
            System.out.println("\t1.开户\t2.登录\t3.关机");
            int num=UtilAtm.intou();
            if (num==1){
                Openatm();
            } else if (num == 2) {
                int id=longing();
                if (id!=-1){
                    atmView(id);
                }
            }else if (num==3){
                System.out.println("关机");
                break;
            }else {
                System.out.println("选择错误");
            }
        }
    }
}