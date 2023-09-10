package com.wangshidai.ATM.AtmView;
import com.wangshidai.ATM.AtmUtil.UtilAtm;
import com.wangshidai.ATM.Atmdome.Accoun;
import com.wangshidai.ATM.Atmsever.SeverAtm;

import java.util.Scanner;

public class AtmTest01 {
    public static void main(String[] args) {
        Scanner an = new Scanner(System.in);
        SeverAtm severAtm=new SeverAtm();
        while (true) {
            UtilAtm.atm();
            System.out.println("\t1:登录\t2:注册");
            int num = an.nextInt();
            if (num == 1) {
                System.out.println("---1--");
                break;
            } else if (num == 2) {
                System.out.println("开始注册");
                int id=UtilAtm.id();
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
    }
}
