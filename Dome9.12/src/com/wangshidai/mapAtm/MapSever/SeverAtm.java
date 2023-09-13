package com.wangshidai.mapAtm.MapSever;

import com.wangshidai.mapAtm.domin.Accoun;
import java.util.HashMap;
import java.util.Map;

public class SeverAtm {
    private Map<Integer, Accoun> map=new HashMap<>();

    //添加账户
    public boolean openAccoun(Integer id,Accoun accoun){
        //判断account是否为空
        if (accoun==null){
            return false;
        }
        //判断卡号是否重复
        if (map.containsKey(id)){
            System.out.println("卡号重复");
            return false;
        }
        //判断密码是否一致
        if (accoun.getPassword()!=accoun.getPassword1()){
            System.out.println("密码不一致");
            return false;
        }
        map.put(id,accoun);
        return true;
    }
    //登录
    public boolean login(Integer id,Integer password){
        if (!map.containsKey(id)){
            System.out.println("卡号错误或不存在");
            return false;
        }
        if (map.get(id).getPassword()!=password){
            System.out.println("密码错误");
            return false;
        }
        return true;
    }
    //存款
    public boolean deposit(Integer id,double money){
        //判断金额是否大于0
        if (money<0){
            System.out.println("金额小于0");
            return false;
        }
        Accoun mon=map.get(id);
        mon.setMoney(money);
        return true;
    }
    //取款
    public boolean Withdrawal(Integer id,double money){
        //判断卡中金额是否小于取款金额
        if (map.get(id).getMoney()<money){
            System.out.println("金额不足");
            return false;
        }
        Accoun mon=map.get(id);
        mon.setMoney(mon.getMoney()-money);
        return true;
    }
    //查询余额
    public void inquire(Integer id){
        System.out.println("尊敬的"+map.get(id).getName()+"先生，您的账户当前余额为:"+map.get(id).getMoney());
    }

    //转账
    public boolean transfer(Integer id,double money,Integer id1){
        //账户转账操作:从id中转入id1中
        //判断id1是否存在
        if (!map.containsKey(id1)){
            System.out.println("转账账户不存在");
            return false;
        }
        //判断账户id1是不是账户id
        if (id.equals(id1)){
            System.out.println("不能向自己的账户进行此操作");
            return false;
        }
        //判断转账金额是否大于账户余额
        if (map.get(id).getMoney()<money){
            System.out.println("转账金额不足");
            return false;
        }
        Accoun str=map.get(id);
        Accoun str1=map.get(id1);
        str.setMoney(str.getMoney()-money);
        str1.setMoney(str1.getMoney()+money);
        return true;
    }
}