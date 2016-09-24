package net.cyclestreets;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

/**
 * Created by Anthony on 9/23/2016.
 */

public class CycleStreetsViewTestRunner extends AndroidJUnitRunner
{
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        return super.newApplication(cl, CycleStreetsAppTest.class.getName(), context);
    }
}
