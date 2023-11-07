package com.pbl.app_mobile.controller;

import android.view.MotionEvent;

import com.pbl.app_mobile.data.ContentStart;
import com.pbl.app_mobile.data.ContentStartAppList;
import com.pbl.app_mobile.model.DO.WelcomeDO;
import com.pbl.app_mobile.view.WelcomeView;

public class WelcomeController {
    private WelcomeView view;
    private WelcomeDO welcomeDO;
    public WelcomeController(WelcomeView view){
        this.view = view;
        welcomeDO = new WelcomeDO(this);
    }
    public void navigateToLogin(){
        welcomeDO.HandleButtonNext();
    }

    public void getCurrentUI(){
        welcomeDO.SetCurrentUI();
    }
    public void setCurrentUI(ContentStartAppList contentsStartApp, int size){
        view.setCurrentUI(contentsStartApp,size);
    }
    public void updateContentPage(ContentStart contentStart, int target,boolean check){
        if (!check) view.updateContentPage(contentStart,target);
        else view.navigateToLogin();
    }


}
