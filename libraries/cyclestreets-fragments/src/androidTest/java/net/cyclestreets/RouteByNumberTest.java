package net.cyclestreets;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Timothy on 9/25/2016.
 */

public class RouteByNumberTest {

    private long validInput;
    private long invalidInput1;
    private long invalidInput2;

    @Rule
    public ActivityTestRule<RouteByNumber> accountDetailsActivityRule = new ActivityTestRule<RouteByNumber>(RouteByNumber.class);

    @Before
    public void init()
    {
        validInput = 999;
        invalidInput1 = (1 * (10^10));
        invalidInput2 = 0;
    }

    @Test
    public void test1signIn()
    {
        //need to find the correct button
        onView(withId(net.cyclestreets.view.R.id.existingaccount_button)).perform(ViewActions.click());

        onView(withId(net.cyclestreets.view.R.id.routeNumber)).perform(ViewActions.clearText());
        onView(withId(net.cyclestreets.view.R.id.routeNumber)).perform(ViewActions.typeText(String.valueOf(validInput)));
        onView(withId(net.cyclestreets.view.R.id.routeNumber)).check(ViewAssertions.matches(withText(String.valueOf(validInput))));
        //need to find the correct button
        onView(withId(net.cyclestreets.view.R.id.signin_button)).check(ViewAssertions.matches(isEnabled()));
        //need to find the correct button
        onView(withId(net.cyclestreets.view.R.id.signin_button)).perform((ViewActions.click()));
    }
}
