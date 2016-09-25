package net.cyclestreets;

import android.os.SystemClock;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Timothy on 9/25/2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.DEFAULT)
public class RouteByNumberTest {

    private String validInput;
    private String invalidInput1;
    private String invalidInput2;

    @Rule
    public ActivityTestRule<CycleStreets> cycleStreetsActivityRule = new ActivityTestRule<CycleStreets>(CycleStreets.class);

    @Before
    public void init()
    {
        validInput = "5";
        invalidInput1 = Long.toString(10l*10l*10l*10l*10l*10l*10l*10l*10l*10l);
        invalidInput2 = "0";
    }

    @Test
    public void validRouteNumber()
    {
        //need to open up the route by number dialog
        openActionBarOverflowOrOptionsMenu(cycleStreetsActivityRule.getActivity().getApplicationContext());
        onView(withText("Open route by number"));
        onView(withText("Open route by number")).perform(ViewActions.click());
        onView(withText("Yes"));
        onView(withText("Yes")).perform(ViewActions.click());

        //enter in valid route number
        onView(withId(net.cyclestreets.fragments.R.id.routeNumber));
        onView(withId(net.cyclestreets.fragments.R.id.routeNumber)).perform(ViewActions.typeText(validInput));
        onView(withId(net.cyclestreets.fragments.R.id.routeNumber)).check(ViewAssertions.matches(withText(validInput)));

        //find route
        onView(withText("Find route"));
        onView(withText("Find route")).perform(ViewActions.click());
    }

    @Test
    public void invalidRouteNumber()
    {
        //need to open up the route by number dialog
        openActionBarOverflowOrOptionsMenu(cycleStreetsActivityRule.getActivity().getApplicationContext());
        onView(withText("Open route by number"));
        onView(withText("Open route by number")).perform(ViewActions.click());
        onView(withText("Yes"));
        onView(withText("Yes")).perform(ViewActions.click());

        //enter in valid route number
        onView(withId(net.cyclestreets.fragments.R.id.routeNumber));
        onView(withId(net.cyclestreets.fragments.R.id.routeNumber)).perform(ViewActions.typeText(invalidInput1));
        onView(withId(net.cyclestreets.fragments.R.id.routeNumber)).check(ViewAssertions.matches(withText(invalidInput1)));

        //find route
        onView(withText("Find route"));
        onView(withText("Find route")).perform(ViewActions.click());
    }

    @Test
    public void invalidRoute2Number()
    {
        //need to open up the route by number dialog
        openActionBarOverflowOrOptionsMenu(cycleStreetsActivityRule.getActivity().getApplicationContext());
        onView(withText("Open route by number"));
        onView(withText("Open route by number")).perform(ViewActions.click());
        onView(withText("Yes"));
        onView(withText("Yes")).perform(ViewActions.click());

        //enter in valid route number
        onView(withId(net.cyclestreets.fragments.R.id.routeNumber));
        onView(withId(net.cyclestreets.fragments.R.id.routeNumber)).perform(ViewActions.typeText(invalidInput2));
        onView(withId(net.cyclestreets.fragments.R.id.routeNumber)).check(ViewAssertions.matches(withText(invalidInput2)));

        //find route
        onView(withText("Find route"));
        onView(withText("Find route")).perform(ViewActions.click());
    }
}
