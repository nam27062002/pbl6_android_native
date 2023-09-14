package com.pbl.app_mobile.view;

import com.pbl.app_mobile.data.ContentStart;
import com.pbl.app_mobile.data.ContentStartAppList;

public interface WelcomeView{
    void navigateToLogin();
    void setCurrentUI(ContentStartAppList contentsStartApp,int size);
    void updateContentPage(ContentStart contentStart,int target);
}
