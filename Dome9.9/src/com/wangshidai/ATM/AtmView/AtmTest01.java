package com.wangshidai.ATM.AtmView;
import com.wangshidai.ATM.AtmUtil.UtilAtm;
import com.wangshidai.ATM.Atmdome.Accoun;
import com.wangshidai.ATM.Atmsever.SeverAtm;

import java.util.Scanner;

public class AtmTest01 {
    public static void main(String[] args) {
        Scanner an = new Scanner(System.in);
        SeverAtm severAtm=new SeverAtm();
        int index=0;
        while (true) {
            UtilAtm.atm();
            System.out.println("\t1:登录\t2:开户\t3.关闭");
            int num = an.nextInt();
            if (num == 1) {
                String id=UtilAtm.id();
                int password=UtilAtm.password();
                index=severAtm.login(id,password);
                if (index!=-1){
                    System.out.println("登录成功");
                    while (true){
                        UtilAtm.atm();
                        int num1=UtilAtm.atmA();
                        //存款
                        if (num1==1){
                            System.out.print("欢迎您！"+severAtm.name(index)+"\n请输入存款");
                            double money=UtilAtm.money();
                            boolean sta=severAtm.deposit(index,money);
                            if (sta){
                                System.out.println("存入成功");
                                //打印用户信息
                                severAtm.inquire(index);
                                System.out.println("\n\n");
                                //选择是否继续业务
                                int cc=UtilAtm.choose();
                                if (cc==1){//退出
                                    System.out.println("再见");
                                    break;
                                }
                            }else{
                                System.out.println("存入失败");
                            }
                        }else if (num1==2){//取款
                            System.out.print("欢迎您！"+severAtm.name(index)+"\n请输入取款");
                            double money=UtilAtm.money();
                            boolean sta=severAtm.Withdrawal(index,money);
                            if (sta) {
                                System.out.println("取款成功");
                                //打印用户信息
                                severAtm.inquire(index);
                                System.out.println("\n\n");
                            }else {
                                System.out.println("取款失败");
                            }
                            //选择是否继续业务
                            int cc=UtilAtm.choose();
                            if (cc==1){//退出
                                System.out.println("再见");
                                break;
                            }
                        }else if (num1==3){//查询余额
                            //打印用户信息
                            severAtm.inquire(index);
                            System.out.println("\n\n");
                            //选择是否继续业务
                            int cc=UtilAtm.choose();
                            if (cc==1){//退出
                                System.out.println("再见");
                                break;
                            }
                        }else if (num1==4){//转账
                            System.out.println("请输入转账卡号:");
                            String id1= an.next();
                            int index1=severAtm.index(id1);
                            if (index==-1){
                                System.out.println("转账账户不存在，转账失败");
                            }else {
                                System.out.print("输入转账");
                                double money=UtilAtm.money();
                                boolean state=severAtm.transfer(index,money,index1);
                                if (state){
                                    System.out.println("转账成功");
                                    //打印用户信息
                                    severAtm.inquire(index);
                                }else {
                                    System.out.println("转账失败");
                                }
                            }
                            //选择是否继续业务
                            int cc=UtilAtm.choose();
                            if (cc==1){//退出
                                System.out.println("再见");
                                break;
                            }
                        }else if (num1==5){//退出
                            System.out.println("感谢使用");
                            break;
                        }else {
                            System.out.println("选择错误");
                        }
                    }
                }else{
                    System.out.println("登录失败");
                }
            } else if (num == 2) {
                System.out.println("开始注册");
                String id=UtilAtm.uid();
                System.out.println("卡号:\n"+id);
                String name=UtilAtm.name();
                int password=UtilAtm.password();
                int password1=UtilAtm.password1();
                Accoun accoun=new Accoun(id,name, password,password1,0);
                boolean state=severAtm.openAccoun(accoun);
                if (state){
                    System.out.println("开户成功");
                }else {
                    System.out.println("开户失败");
                }
            }else if (num==3){
                System.out.println("关闭");
                break;
            } else {
                System.out.println("选择错误");
            }
        }

    }
}