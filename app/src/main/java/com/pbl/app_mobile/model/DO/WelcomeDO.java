package com.pbl.app_mobile.model.DO;

import android.view.MotionEvent;

import com.pbl.app_mobile.controller.WelcomeController;
import com.pbl.app_mobile.data.ContentStartAppList;

public class WelcomeDO {
    private WelcomeController welcomeController;
    private ContentStartAppList contentsStartApp;
    private int size;
    private int target;
    public WelcomeDO(WelcomeController welcomeController){
        this.welcomeController = welcomeController;
        contentsStartApp = new ContentStartAppList();
        size = contentsStartApp.contentStartApps.size();
    }
    public void SetCurrentUI(){
        welcomeController.setCurrentUI(contentsStartApp,size);
        SetContentUI(false);
    }
    private void SetContentUI(boolean check){
        welcomeController.updateContentPage(contentsStartApp.contentStartApps.get(target),target,check);
    }
    public void HandleButtonNext(){
        if (target < size - 1) {
            target++;
            SetContentUI(false);
        }
        else{
            SetContentUI(true);
        }
    }
}
