package com.wangshidai.ATM.Atmsever;

import com.wangshidai.ATM.Atmdome.Accoun;

import java.util.ArrayList;
import java.util.List;

public class SeverAtm {
    private List<Accoun> accouns=new ArrayList<>();
    //添加
    public boolean openAccoun(Accoun accoun){
        if (accoun==null){
            return false;
        }
        if (accoun.getPassword()==accoun.getPassword1()){
            return false;
        }
        for (int i = 0; i < accouns.size(); i++) {
            if (accouns.get(i).getId()==accoun.getId()){
                System.out.println("卡号重复");
                return false;
            }
        }
        accouns.add(accoun);
        return true;
    }
}
