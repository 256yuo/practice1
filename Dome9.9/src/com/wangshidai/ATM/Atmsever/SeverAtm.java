package com.wangshidai.ATM.Atmsever;

import com.wangshidai.ATM.Atmdome.Accoun;
import sun.security.util.Password;

import java.util.ArrayList;
import java.util.List;

public class SeverAtm {
    private List<Accoun> accouns=new ArrayList<>();
    //添加账户
    public boolean openAccoun(Accoun accoun){
        //判断accoun是否为空
        if (accoun==null){
            return false;
        }
        //判断密码是否是6位
        int pass=accoun.getPassword();
        int count=1;
        while (true){
            if (pass/10==0){
                break;
            }else {
                pass/=10;
                count++;
            }
        }
        if (count!=6){
            return false;
        }
        //判断确认密码和密码是否一致
        if (accoun.getPassword()!=accoun.getPassword1()){
            return false;
        }
        //判断卡号是否重复
        for (int i = 0; i < accouns.size(); i++) {
            if (accouns.get(i).getId().equals(accoun.getId())){
                System.out.println("卡号重复");
                return false;
            }
        }
        accouns.add(accoun);
        return true;
    }
    //登录
    public int login(String id,int password){
        int flag=-1;
        for (int i = 0; i < accouns.size(); i++) {
            if (accouns.get(i).getId().equals(id)){
                if (accouns.get(i).getPassword()==password){
                    flag=i;
                    return flag;
                }else {
                    flag=-2;
                    System.out.println("密码错误");
                }
            }
        }
        if (flag==-1){
            System.out.println("账户不存在");
            return flag;
        }else {
            flag=-1;
        }
        return flag;
    }
    //存款
    //取款
    //查询余额
    //转账
}
