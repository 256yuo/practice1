package com.wangshidai.ATM.AtmView;
import com.wangshidai.ATM.AtmUtil.UtilAtm;
import com.wangshidai.ATM.Atmdome.Accoun;
import com.wangshidai.ATM.Atmsever.SeverAtm;

import java.util.Scanner;

public class AtmTest01 {
    public static void main(String[] args) {
        Scanner an = new Scanner(System.in);
        SeverAtm severAtm=new SeverAtm();
        int index;
        while (true) {
            UtilAtm.atm();
            System.out.println("\t1:登录\t2:开户");
            int num = an.nextInt();
            if (num == 1) {
                String id=UtilAtm.id();
                int password=UtilAtm.password();
                index=severAtm.login(id,password);
                if (index!=-1){
                    System.out.println("登录成功");
                    break;
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
            }else {
                System.out.println("选择错误");
            }
        }
        while (true){
            UtilAtm.atm();
            System.out.println("\t1.存款\t\t2.取款\n\t3.查询余额\t4.转账\n\t5.退出");
            System.out.println("选择业务:");
            int num1 = an.nextInt();
            if (num1==1){
                System.out.println("11");
            }else if (num1==2){
                System.out.println("22");
            }else if (num1==3){
                System.out.println("33");
            }else if (num1==4){
                System.out.println("44");
            }else if (num1==5){
                System.out.println("感谢使用");
                break;
            }else {
                System.out.println("选择错误");
            }
        }
    }
}
