package com.pbl.app_mobile.controller;

import com.pbl.app_mobile.model.DO.VerifyAccountDO;
import com.pbl.app_mobile.view.VerifyAccountView;

public class VerifyAccountController {
    VerifyAccountView view;
    VerifyAccountDO model;
    public VerifyAccountController(VerifyAccountView view){
        this.view = view;
        model = new VerifyAccountDO(this);
    }
    public void SetText(String text){
        model.SetText(text);
    }
    public void SetText(int index,String text){
        view.SetText(index,text);
    }
    public void DelHandle(){
        model.DelHandle();
    }
    public void DelHandle(int index){
        view.DelHandle(index);
    }
    public void GetTimer(){
        view.SetTimerCode(model.GetTimerText(), model.GetTimerCode());
    }
}
