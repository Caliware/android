package net.cyclestreets;

import android.app.Application;

import net.cyclestreets.view.R;

/**
 * Created by Anthony on 9/23/2016.
 */

public class CycleStreetsAppTest extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        CycleStreetsPreferences.initialise(this, R.xml.prefs);
    }
}
