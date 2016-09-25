package net.cyclestreets;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import net.cyclestreets.view.R;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static net.cyclestreets.CycleStreetsPreferences.PREF_EMAIL_KEY;
import static net.cyclestreets.CycleStreetsPreferences.PREF_NAME_KEY;
import static net.cyclestreets.CycleStreetsPreferences.PREF_PASSWORD_KEY;
import static net.cyclestreets.CycleStreetsPreferences.PREF_USERNAME_KEY;
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

    private String registerName;
    private String registerEmail;

    private String registerUsernameValid;
    private String registerPasswordValid;
    private String registerConfirmPasswordValid;

    private String registerUsernameInvalid;
    private String registerPasswordInvalid;
    private String registerConfirmPasswordInvalid;

    private String registerUsernameInvalidNonAlpha;

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

        registerName = "David";
        registerEmail = email;

        registerUsernameValid = "Valid";
        registerPasswordValid = "Valid6";
        registerConfirmPasswordValid = "Valid6";

        registerUsernameInvalid = "Test";
        registerPasswordInvalid = "Test";
        registerConfirmPasswordInvalid = "Test";

        registerUsernameInvalidNonAlpha = "!!!!!";

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void test1signIn()
//    {
//        onView(withId(R.id.existingaccount_button)).perform(ViewActions.click());
//
//        onView(withId(R.id.username)).perform(ViewActions.clearText());
//        onView(withId(R.id.username)).perform(ViewActions.typeText(username));
//        onView(withId(R.id.username)).check(ViewAssertions.matches(withText(username)));
//
//        onView(withId(R.id.password)).perform(ViewActions.clearText());
//        onView(withId(R.id.password)).perform(ViewActions.typeText(password));
//        onView(withId(R.id.password)).check(ViewAssertions.matches(withText(password)));
//
//        onView(withId(R.id.signin_button)).check(ViewAssertions.matches(isEnabled()));
//
//        onView(withId(R.id.signin_button)).perform((ViewActions.click()));
//    }
//
//    @Test
//    public void test2invalidSignIn()
//    {
//        try {
//            onView(withId(R.id.existingaccount_button)).perform(ViewActions.click());
//
//
//            onView(withId(R.id.username)).perform(ViewActions.clearText());
//            onView(withId(R.id.username)).perform(ViewActions.typeText(invalidUsername));
//            onView(withId(R.id.username)).check(ViewAssertions.matches(withText(invalidUsername)));
//
//            onView(withId(R.id.password)).perform(ViewActions.clearText());
//            onView(withId(R.id.password)).perform(ViewActions.typeText(invalidPassword));
//            onView(withId(R.id.password)).check(ViewAssertions.matches(withText(invalidPassword)));
//
//            onView(withId(R.id.signin_button)).check(ViewAssertions.matches(isEnabled()));
//
//            onView(withId(R.id.signin_button)).perform((ViewActions.click()));
//        }
//        catch(AssertionError e)
//        {
//            assert true;
//        }
//    }
//    @Test
//    public void test3invalidSignIn()
//    {
//        try {
//            onView(withId(R.id.existingaccount_button)).perform(ViewActions.click());
//
//
//            onView(withId(R.id.username)).perform(ViewActions.clearText());
//            onView(withId(R.id.username)).perform(ViewActions.typeText(username));
//            onView(withId(R.id.username)).check(ViewAssertions.matches(withText(username)));
//
//            onView(withId(R.id.password)).perform(ViewActions.clearText());
//            onView(withId(R.id.password)).perform(ViewActions.typeText(invalidPassword));
//            onView(withId(R.id.password)).check(ViewAssertions.matches(withText(invalidPassword)));
//
//            onView(withId(R.id.signin_button)).check(ViewAssertions.matches(isEnabled()));
//
//            onView(withId(R.id.signin_button)).perform((ViewActions.click()));
//        }
//        catch(AssertionError e)
//        {
//            assert true;
//        }
//    }
//    @Test
//    public void test4invalidSignIn()
//    {
//        try {
//            onView(withId(R.id.existingaccount_button)).perform(ViewActions.click());
//
//
//            onView(withId(R.id.username)).perform(ViewActions.clearText());
//            onView(withId(R.id.username)).perform(ViewActions.typeText(invalidUsername));
//            onView(withId(R.id.username)).check(ViewAssertions.matches(withText(invalidUsername)));
//
//            onView(withId(R.id.password)).perform(ViewActions.clearText());
//            onView(withId(R.id.password)).perform(ViewActions.typeText(password));
//            onView(withId(R.id.password)).check(ViewAssertions.matches(withText(password)));
//
//            onView(withId(R.id.signin_button)).check(ViewAssertions.matches(isEnabled()));
//
//            onView(withId(R.id.signin_button)).perform((ViewActions.click()));
//        }
//        catch(AssertionError e)
//        {
//            assert true;
//        }
//    }

    @Test
    public void test5validRegister()
    {
        //clcik new account button to get to register view
        onView(withId(R.id.newaccount_button));
        onView(withId(R.id.newaccount_button)).perform(ViewActions.click());

        onView(withId(R.id.name));
        onView(withId(R.id.name)).perform(ViewActions.clearText());
        onView(withId(R.id.name)).perform(ViewActions.typeText(registerName));
        onView(withId(R.id.name)).check(ViewAssertions.matches(withText(registerName)));

        onView(withId(R.id.email));
        onView(withId(R.id.email)).perform(ViewActions.clearText());
        onView(withId(R.id.email)).perform(ViewActions.typeText(registerEmail));
        onView(withId(R.id.email)).check(ViewAssertions.matches(withText(registerEmail)));

        onView(withId(R.id.username));
        onView(withId(R.id.username)).perform(ViewActions.clearText());
        onView(withId(R.id.username)).perform(ViewActions.typeText(registerUsernameValid));
        onView(withId(R.id.username)).check(ViewAssertions.matches(withText(registerUsernameValid)));

        onView(withId(R.id.password));
        onView(withId(R.id.password)).perform(ViewActions.scrollTo());
        onView(withId(R.id.password)).perform(ViewActions.clearText());
        onView(withId(R.id.password)).perform(ViewActions.typeText(registerPasswordValid));
        onView(withId(R.id.password)).check(ViewAssertions.matches(withText(registerPasswordValid)));

        onView(withId(R.id.confirm_password));
        onView(withId(R.id.confirm_password)).perform(ViewActions.scrollTo());
        onView(withId(R.id.confirm_password)).perform(ViewActions.clearText());
        onView(withId(R.id.confirm_password)).perform(ViewActions.typeText(registerConfirmPasswordValid));
        onView(withId(R.id.confirm_password)).check(ViewAssertions.matches(withText(registerConfirmPasswordValid)));

        //check  confirm password is the same
        onView(withId(R.id.confirm_password)).check(ViewAssertions.matches(withText(registerConfirmPasswordValid)));

        //try to register
        onView(withId(R.id.register_button));
        onView(withId(R.id.register_button)).perform(ViewActions.click());

        //check if accoutn was recreated
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(accountDetailsActivityRule.getActivity().getApplicationContext());

        assertTrue(prefs.getString(PREF_USERNAME_KEY, null) != null);

        assertTrue(prefs.getString(PREF_PASSWORD_KEY, null) != null);

        assertTrue(prefs.getString(PREF_NAME_KEY, null) != null);

        assertTrue(prefs.getString(PREF_EMAIL_KEY, null) != null);
    }

    @Test
    public void test6InvalidRegister()
    {
        //clcik new account button to get to register view
        onView(withId(R.id.newaccount_button));
        onView(withId(R.id.newaccount_button)).perform(ViewActions.click());

        onView(withId(R.id.name));
        onView(withId(R.id.name)).perform(ViewActions.clearText());
        onView(withId(R.id.name)).perform(ViewActions.typeText(registerName));
        onView(withId(R.id.name)).check(ViewAssertions.matches(withText(registerName)));

        onView(withId(R.id.email));
        onView(withId(R.id.email)).perform(ViewActions.clearText());
        onView(withId(R.id.email)).perform(ViewActions.typeText(registerEmail));
        onView(withId(R.id.email)).check(ViewAssertions.matches(withText(registerEmail)));

        onView(withId(R.id.username));
        onView(withId(R.id.username)).perform(ViewActions.clearText());
        onView(withId(R.id.username)).perform(ViewActions.typeText(registerUsernameInvalid));
        onView(withId(R.id.username)).check(ViewAssertions.matches(withText(registerUsernameInvalid)));

        onView(withId(R.id.password));
        onView(withId(R.id.password)).perform(ViewActions.scrollTo());
        onView(withId(R.id.password)).perform(ViewActions.clearText());
        onView(withId(R.id.password)).perform(ViewActions.typeText(registerPasswordInvalid));
        onView(withId(R.id.password)).check(ViewAssertions.matches(withText(registerPasswordInvalid)));

        onView(withId(R.id.confirm_password));
        onView(withId(R.id.confirm_password)).perform(ViewActions.scrollTo());
        onView(withId(R.id.confirm_password)).perform(ViewActions.clearText());
        onView(withId(R.id.confirm_password)).perform(ViewActions.typeText(registerConfirmPasswordInvalid));
        onView(withId(R.id.confirm_password)).check(ViewAssertions.matches(withText(registerConfirmPasswordInvalid)));

        //check  confirm password is the same
        onView(withId(R.id.confirm_password)).check(ViewAssertions.matches(withText(registerConfirmPasswordInvalid)));

        //try to register
        onView(withId(R.id.register_button));
        onView(withId(R.id.register_button)).perform(ViewActions.click());

        //check if accoutn was recreated
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(accountDetailsActivityRule.getActivity().getApplicationContext());

        assertTrue(prefs.getString(PREF_USERNAME_KEY, null) != null);

        assertTrue(prefs.getString(PREF_PASSWORD_KEY, null) != null);

        assertTrue(prefs.getString(PREF_NAME_KEY, null) != null);

        assertTrue(prefs.getString(PREF_EMAIL_KEY, null) != null);
    }

    @Test
    public void test7InvalidRegister()
    {
        //clcik new account button to get to register view
        onView(withId(R.id.newaccount_button));
        onView(withId(R.id.newaccount_button)).perform(ViewActions.click());

        onView(withId(R.id.name));
        onView(withId(R.id.name)).perform(ViewActions.clearText());
        onView(withId(R.id.name)).perform(ViewActions.typeText(registerName));
        onView(withId(R.id.name)).check(ViewAssertions.matches(withText(registerName)));

        onView(withId(R.id.email));
        onView(withId(R.id.email)).perform(ViewActions.clearText());
        onView(withId(R.id.email)).perform(ViewActions.typeText(registerEmail));
        onView(withId(R.id.email)).check(ViewAssertions.matches(withText(registerEmail)));

        onView(withId(R.id.username));
        onView(withId(R.id.username)).perform(ViewActions.clearText());
        onView(withId(R.id.username)).perform(ViewActions.typeText(registerUsernameInvalid));
        onView(withId(R.id.username)).check(ViewAssertions.matches(withText(registerUsernameInvalid)));

        onView(withId(R.id.password));
        onView(withId(R.id.password)).perform(ViewActions.scrollTo());
        onView(withId(R.id.password)).perform(ViewActions.clearText());
        onView(withId(R.id.password)).perform(ViewActions.typeText(registerPasswordValid));
        onView(withId(R.id.password)).check(ViewAssertions.matches(withText(registerPasswordValid)));

        onView(withId(R.id.confirm_password));
        onView(withId(R.id.confirm_password)).perform(ViewActions.scrollTo());
        onView(withId(R.id.confirm_password)).perform(ViewActions.clearText());
        onView(withId(R.id.confirm_password)).perform(ViewActions.typeText(registerConfirmPasswordValid));
        onView(withId(R.id.confirm_password)).check(ViewAssertions.matches(withText(registerConfirmPasswordValid)));

        //check  confirm password is the same
        onView(withId(R.id.confirm_password)).check(ViewAssertions.matches(withText(registerConfirmPasswordValid)));

        //try to register
        onView(withId(R.id.register_button));
        onView(withId(R.id.register_button)).perform(ViewActions.click());

        //check if accoutn was recreated
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(accountDetailsActivityRule.getActivity().getApplicationContext());

        assertTrue(prefs.getString(PREF_USERNAME_KEY, null) != null);

        assertTrue(prefs.getString(PREF_PASSWORD_KEY, null) != null);

        assertTrue(prefs.getString(PREF_NAME_KEY, null) != null);

        assertTrue(prefs.getString(PREF_EMAIL_KEY, null) != null);
    }

    @Test
    public void test8InvalidRegister()
    {
        //clcik new account button to get to register view
        onView(withId(R.id.newaccount_button));
        onView(withId(R.id.newaccount_button)).perform(ViewActions.click());

        onView(withId(R.id.name));
        onView(withId(R.id.name)).perform(ViewActions.clearText());
        onView(withId(R.id.name)).perform(ViewActions.typeText(registerName));
        onView(withId(R.id.name)).check(ViewAssertions.matches(withText(registerName)));

        onView(withId(R.id.email));
        onView(withId(R.id.email)).perform(ViewActions.clearText());
        onView(withId(R.id.email)).perform(ViewActions.typeText(registerEmail));
        onView(withId(R.id.email)).check(ViewAssertions.matches(withText(registerEmail)));

        onView(withId(R.id.username));
        onView(withId(R.id.username)).perform(ViewActions.clearText());
        onView(withId(R.id.username)).perform(ViewActions.typeText(registerUsernameValid));
        onView(withId(R.id.username)).check(ViewAssertions.matches(withText(registerUsernameValid)));

        onView(withId(R.id.password));
        onView(withId(R.id.password)).perform(ViewActions.scrollTo());
        onView(withId(R.id.password)).perform(ViewActions.clearText());
        onView(withId(R.id.password)).perform(ViewActions.typeText(registerPasswordInvalid));
        onView(withId(R.id.password)).check(ViewAssertions.matches(withText(registerPasswordInvalid)));

        onView(withId(R.id.confirm_password));
        onView(withId(R.id.confirm_password)).perform(ViewActions.scrollTo());
        onView(withId(R.id.confirm_password)).perform(ViewActions.clearText());
        onView(withId(R.id.confirm_password)).perform(ViewActions.typeText(registerConfirmPasswordInvalid));
        onView(withId(R.id.confirm_password)).check(ViewAssertions.matches(withText(registerConfirmPasswordInvalid)));

        //check  confirm password is the same
        onView(withId(R.id.confirm_password)).check(ViewAssertions.matches(withText(registerConfirmPasswordInvalid)));

        //try to register
        onView(withId(R.id.register_button));
        onView(withId(R.id.register_button)).perform(ViewActions.click());

        //check if accoutn was recreated
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(accountDetailsActivityRule.getActivity().getApplicationContext());

        assertTrue(prefs.getString(PREF_USERNAME_KEY, null) != null);

        assertTrue(prefs.getString(PREF_PASSWORD_KEY, null) != null);

        assertTrue(prefs.getString(PREF_NAME_KEY, null) != null);

        assertTrue(prefs.getString(PREF_EMAIL_KEY, null) != null);
    }

    @Test
    public void test9InvalidRegister()
    {
        //clcik new account button to get to register view
        onView(withId(R.id.newaccount_button));
        onView(withId(R.id.newaccount_button)).perform(ViewActions.click());

        onView(withId(R.id.name));
        onView(withId(R.id.name)).perform(ViewActions.clearText());
        onView(withId(R.id.name)).perform(ViewActions.typeText(registerName));
        onView(withId(R.id.name)).check(ViewAssertions.matches(withText(registerName)));

        onView(withId(R.id.email));
        onView(withId(R.id.email)).perform(ViewActions.clearText());
        onView(withId(R.id.email)).perform(ViewActions.typeText(registerEmail));
        onView(withId(R.id.email)).check(ViewAssertions.matches(withText(registerEmail)));

        onView(withId(R.id.username));
        onView(withId(R.id.username)).perform(ViewActions.clearText());
        onView(withId(R.id.username)).perform(ViewActions.typeText(registerUsernameInvalidNonAlpha));
        onView(withId(R.id.username)).check(ViewAssertions.matches(withText(registerUsernameInvalidNonAlpha)));

        onView(withId(R.id.password));
        onView(withId(R.id.password)).perform(ViewActions.scrollTo());
        onView(withId(R.id.password)).perform(ViewActions.clearText());
        onView(withId(R.id.password)).perform(ViewActions.typeText(registerPasswordInvalid));
        onView(withId(R.id.password)).check(ViewAssertions.matches(withText(registerPasswordInvalid)));

        onView(withId(R.id.confirm_password));
        onView(withId(R.id.confirm_password)).perform(ViewActions.scrollTo());
        onView(withId(R.id.confirm_password)).perform(ViewActions.clearText());
        onView(withId(R.id.confirm_password)).perform(ViewActions.typeText(registerConfirmPasswordInvalid));
        onView(withId(R.id.confirm_password)).check(ViewAssertions.matches(withText(registerConfirmPasswordInvalid)));

        //check  confirm password is the same
        onView(withId(R.id.confirm_password)).check(ViewAssertions.matches(withText(registerConfirmPasswordInvalid)));

        //try to register
        onView(withId(R.id.register_button));
        onView(withId(R.id.register_button)).perform(ViewActions.click());

        //check if accoutn was recreated
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(accountDetailsActivityRule.getActivity().getApplicationContext());

        assertTrue(prefs.getString(PREF_USERNAME_KEY, null) != null);

        assertTrue(prefs.getString(PREF_PASSWORD_KEY, null) != null);

        assertTrue(prefs.getString(PREF_NAME_KEY, null) != null);

        assertTrue(prefs.getString(PREF_EMAIL_KEY, null) != null);
    }

    @Test
    public void test10InvalidRegister()
    {
        //clcik new account button to get to register view
        onView(withId(R.id.newaccount_button));
        onView(withId(R.id.newaccount_button)).perform(ViewActions.click());

        onView(withId(R.id.name));
        onView(withId(R.id.name)).perform(ViewActions.clearText());
        onView(withId(R.id.name)).perform(ViewActions.typeText(registerName));
        onView(withId(R.id.name)).check(ViewAssertions.matches(withText(registerName)));

        onView(withId(R.id.email));
        onView(withId(R.id.email)).perform(ViewActions.clearText());
        onView(withId(R.id.email)).perform(ViewActions.typeText(registerEmail));
        onView(withId(R.id.email)).check(ViewAssertions.matches(withText(registerEmail)));

        onView(withId(R.id.username));
        onView(withId(R.id.username)).perform(ViewActions.clearText());
        onView(withId(R.id.username)).perform(ViewActions.typeText(registerUsernameInvalidNonAlpha));
        onView(withId(R.id.username)).check(ViewAssertions.matches(withText(registerUsernameInvalidNonAlpha)));

        onView(withId(R.id.password));
        onView(withId(R.id.password)).perform(ViewActions.scrollTo());
        onView(withId(R.id.password)).perform(ViewActions.clearText());
        onView(withId(R.id.password)).perform(ViewActions.typeText(registerPasswordValid));
        onView(withId(R.id.password)).check(ViewAssertions.matches(withText(registerPasswordValid)));

        onView(withId(R.id.confirm_password));
        onView(withId(R.id.confirm_password)).perform(ViewActions.scrollTo());
        onView(withId(R.id.confirm_password)).perform(ViewActions.clearText());
        onView(withId(R.id.confirm_password)).perform(ViewActions.typeText(registerConfirmPasswordValid));
        onView(withId(R.id.confirm_password)).check(ViewAssertions.matches(withText(registerConfirmPasswordValid)));

        //check  confirm password is the same
        onView(withId(R.id.confirm_password)).check(ViewAssertions.matches(withText(registerConfirmPasswordValid)));

        //try to register
        onView(withId(R.id.register_button));
        onView(withId(R.id.register_button)).perform(ViewActions.click());

        //check if accoutn was recreated
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(accountDetailsActivityRule.getActivity().getApplicationContext());

        assertTrue(prefs.getString(PREF_USERNAME_KEY, null) != null);

        assertTrue(prefs.getString(PREF_PASSWORD_KEY, null) != null);

        assertTrue(prefs.getString(PREF_NAME_KEY, null) != null);

        assertTrue(prefs.getString(PREF_EMAIL_KEY, null) != null);
    }
}
