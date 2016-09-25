package net.cyclestreets;

import android.app.Application;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

public class CycleStreetsAppTest extends Application
{
  @Override
  public void onCreate()
  {
    super.onCreate();

    CycleStreetsAppSupport.initialise(this, R.xml.prefs);
  }
}
