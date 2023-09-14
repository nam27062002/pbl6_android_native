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
        SetContentUI();
    }
    private void SetContentUI(){
        welcomeController.updateContentPage(contentsStartApp.contentStartApps.get(target),target);
    }
    public void HandleEventSwipeHorizontal(MotionEvent e1, MotionEvent e2){
        if (e1.getX() - e2.getX() > 50 && target < size - 1) {
            target++;
            SetContentUI();
        } else if (e2.getX() - e1.getX() > 50 && target > 0) {
            target--;
            SetContentUI();
        }
    }
}
