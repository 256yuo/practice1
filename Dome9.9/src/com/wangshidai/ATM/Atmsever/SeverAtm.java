package com.wangshidai.ATM.Atmsever;

import com.wangshidai.ATM.Atmdome.Accoun;

import java.util.ArrayList;
import java.util.List;

public class SeverAtm {
    private List<Accoun> accouns=new ArrayList<>();
    //获取姓名
    public String name(int index){
        String name=accouns.get(index).getName();
        return name;
    }
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
    public int  login(String id,int password){
        int index=index(id);
        if (index==-1){
            System.out.println("账户不存在");
            return index;
        }else {
            if (accouns.get(index).getPassword()==password) {
                return index;
            }
        }
        System.out.println("密码错误");
        return index;
    }
    //存款
    public boolean deposit(int index,double money){
        Accoun str1=accouns.get(index);
        if (!(money>=0)) {
            return false;
        }
        str1.setMoney(str1.getMoney() + money);
        return true;
    }
    //取款
    public boolean Withdrawal(int index,double money){
        //判断取款金额是否大于账户余额
        if (money>accouns.get(index).getMoney()){
            System.out.println("当前账户余额不足");
            return false;
        }
        Accoun str=accouns.get(index);
        str.setMoney(str.getMoney()-money);
        return true;
    }
    //查询余额
    public void inquire(int index){
        System.out.println("尊敬的"+accouns.get(index).getName()+"先生，您的账户当前余额为:"+accouns.get(index).getMoney());
    }
    //查询账户下标
    public int index(String id){
        int index=-1;
        for (int i = 0; i < accouns.size(); i++) {
            //判断账户存在下标
            if (accouns.get(i).getId().equals(id)){
                index=i;
            }
        }
        return index;
    }
    //转账
    public boolean transfer(int index,double money,int index1){
        //判断转账账户是不是自己的账户
        if (accouns.get(index).getId().equals(accouns.get(index1).getId())){
            System.out.println("不得输入自己的账户");
            return false;
        }
        //判断转账金额是否大于账户余额
        if (money>accouns.get(index).getMoney()){
            System.out.println("当前账户余额不足");
            return false;
        }
        //账户转账操作:从str中转入str1中
        Accoun str=accouns.get(index);
        Accoun str1=accouns.get(index1);
        str.setMoney(str.getMoney()-money);
        str1.setMoney(str1.getMoney()+money);
        return true;
    }
}