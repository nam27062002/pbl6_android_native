package com.pbl.app_mobile.model.DO;

import com.pbl.app_mobile.controller.VerifyAccountController;

public class VerifyAccountDO {
    VerifyAccountController controller;
    private int currentIndex = 0;
    private int codeLength = 4;
    private String code = "";
    private int timerCode = 10;
    public int GetTimerCode(){
        return timerCode;
    }
    public VerifyAccountDO(VerifyAccountController controller){
        this.controller = controller;
    }
    public void SetText(String text){
        if (currentIndex < codeLength){
            code += text;
            controller.SetText(currentIndex,text);
            currentIndex++;
        }
    }
    public void DelHandle(){
        if (currentIndex > 0){
            currentIndex--;
            code = code.substring(0, code.length() - 1);
            controller.DelHandle(currentIndex);
        }
    }
    public String GetTimerText(){
        if (timerCode >= 0){
            int minutes = timerCode / 60;
            int seconds = timerCode % 60;
            String formattedTime = "Enter code: (" + minutes + ":" + seconds + ")";
            timerCode--;
            return formattedTime;
        }
        else{
            return "Resend";
        }
    }
}
