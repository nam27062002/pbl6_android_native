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
        view.navigateToLogin();
    }

    public void getCurrentUI(){
        welcomeDO.SetCurrentUI();
    }
    public void setCurrentUI(ContentStartAppList contentsStartApp, int size){
        view.setCurrentUI(contentsStartApp,size);
    }
    public void eventSwipeHorizontal(MotionEvent e1, MotionEvent e2){
        welcomeDO.HandleEventSwipeHorizontal(e1,e2);
    }
    public void updateContentPage(ContentStart contentStart, int target){
        view.updateContentPage(contentStart,target);
    }


}
