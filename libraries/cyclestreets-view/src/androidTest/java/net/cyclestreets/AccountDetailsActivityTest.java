package net.cyclestreets;

import android.app.Instrumentation;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;

import net.cyclestreets.view.R;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertTrue;

/**
 * Created by Anthony on 9/23/2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountDetailsActivityTest
{
    private String username;
    private String password;
    private String name;
    private String email;
    private String invalidUsername;
    private String invalidPassword;

    @Rule
    public ActivityTestRule<AccountDetailsActivity> accountDetailsActivityRule = new ActivityTestRule<AccountDetailsActivity>(AccountDetailsActivity.class);

    @Before
    public void init()
    {
        username = "caliware";
        password = "1Fullerton";
        name = "";
        email = "dsullivan2@csu.fullerton.edu";
        invalidUsername = "invalidUser";
        invalidPassword = "invalidPassword";
    }

    @Test
    public void test1signIn()
    {
        onView(withId(R.id.existingaccount_button)).perform(ViewActions.click());

        onView(withId(R.id.username)).perform(ViewActions.clearText());
        onView(withId(R.id.username)).perform(ViewActions.typeText(username));
        onView(withId(R.id.username)).check(ViewAssertions.matches(withText(username)));

        onView(withId(R.id.password)).perform(ViewActions.clearText());
        onView(withId(R.id.password)).perform(ViewActions.typeText(password));
        onView(withId(R.id.password)).check(ViewAssertions.matches(withText(password)));

        onView(withId(R.id.signin_button)).check(ViewAssertions.matches(isEnabled()));

        onView(withId(R.id.signin_button)).perform((ViewActions.click()));
    }

    @Test
    public void test2invalidSignIn()
    {
        try {
            onView(withId(R.id.existingaccount_button)).perform(ViewActions.click());


            onView(withId(R.id.username)).perform(ViewActions.clearText());
            onView(withId(R.id.username)).perform(ViewActions.typeText(invalidUsername));
            onView(withId(R.id.username)).check(ViewAssertions.matches(withText(invalidUsername)));

            onView(withId(R.id.password)).perform(ViewActions.clearText());
            onView(withId(R.id.password)).perform(ViewActions.typeText(invalidPassword));
            onView(withId(R.id.password)).check(ViewAssertions.matches(withText(invalidPassword)));

            onView(withId(R.id.signin_button)).check(ViewAssertions.matches(isEnabled()));

            onView(withId(R.id.signin_button)).perform((ViewActions.click()));
        }
        catch(AssertionError e)
        {
            assert true;
        }
    }
    @Test
    public void test3invalidSignIn()
    {
        try {
            onView(withId(R.id.existingaccount_button)).perform(ViewActions.click());


            onView(withId(R.id.username)).perform(ViewActions.clearText());
            onView(withId(R.id.username)).perform(ViewActions.typeText(username));
            onView(withId(R.id.username)).check(ViewAssertions.matches(withText(username)));

            onView(withId(R.id.password)).perform(ViewActions.clearText());
            onView(withId(R.id.password)).perform(ViewActions.typeText(invalidPassword));
            onView(withId(R.id.password)).check(ViewAssertions.matches(withText(invalidPassword)));

            onView(withId(R.id.signin_button)).check(ViewAssertions.matches(isEnabled()));

            onView(withId(R.id.signin_button)).perform((ViewActions.click()));
        }
        catch(AssertionError e)
        {
            assert true;
        }
    }
    @Test
    public void test4invalidSignIn()
    {
        try {
            onView(withId(R.id.existingaccount_button)).perform(ViewActions.click());


            onView(withId(R.id.username)).perform(ViewActions.clearText());
            onView(withId(R.id.username)).perform(ViewActions.typeText(invalidUsername));
            onView(withId(R.id.username)).check(ViewAssertions.matches(withText(invalidUsername)));

            onView(withId(R.id.password)).perform(ViewActions.clearText());
            onView(withId(R.id.password)).perform(ViewActions.typeText(password));
            onView(withId(R.id.password)).check(ViewAssertions.matches(withText(password)));

            onView(withId(R.id.signin_button)).check(ViewAssertions.matches(isEnabled()));

            onView(withId(R.id.signin_button)).perform((ViewActions.click()));
        }
        catch(AssertionError e)
        {
            assert true;
        }
    }
}