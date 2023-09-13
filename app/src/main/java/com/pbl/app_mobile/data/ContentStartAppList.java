package com.pbl.app_mobile.data;
import com.pbl.app_mobile.R;

import java.util.ArrayList;
import java.util.List;

public class ContentStartAppList {
    public List<ContentStart> contentStartApps;
    public ContentStartAppList() {
        contentStartApps = new ArrayList<>();
        contentStartApps.add(new ContentStart(R.drawable.overview_1,"Request Ride","Request a ride get picked up by a nearby community driver"));
        contentStartApps.add(new ContentStart(R.drawable.overview_2,"Confirm Your Driver","Huge drivers network helps you find comforable, safe and cheap ride"));
        contentStartApps.add(new ContentStart(R.drawable.overview_3,"Track your ride","Know your driver in advance and be able to view current location in real time on the map"));
    }
}
