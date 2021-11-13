package com.example.lab_3_5

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @Test
    fun testAbout() {
        launchActivity<MainActivity>()
        openAbout()
        aboutOnScreen()
    }

    @Test
    fun testFromFirstToSecond() {
        launchActivity<MainActivity>()
        first_activityOnScreen()
        onView(ViewMatchers.withId(R.id.button_1_to_2)).perform(ViewActions.click())
        second_activityOnScreen()

    }

    @Test
    fun testFromSecondToFirst() {
        launchActivity<MainActivity>()
        first_activityOnScreen()
        onView(ViewMatchers.withId(R.id.button_1_to_2)).perform(ViewActions.click())
        second_activityOnScreen()
        onView(ViewMatchers.withId(R.id.button_2_to_1)).perform(ViewActions.click())
        first_activityOnScreen()

    }

    @Test
    fun testFromSecondToThird(){
        launchActivity<MainActivity>()
        first_activityOnScreen()
        onView(ViewMatchers.withId(R.id.button_1_to_2)).perform(ViewActions.click())
        second_activityOnScreen()
        onView(ViewMatchers.withId(R.id.button_2_to_3)).perform(ViewActions.click())
        third_activityOnScreen()
    }

    @Test
    fun testFromThirdToFirst(){
        launchActivity<MainActivity>()
        first_activityOnScreen()
        onView(ViewMatchers.withId(R.id.button_1_to_2)).perform(ViewActions.click())
        second_activityOnScreen()
        onView(ViewMatchers.withId(R.id.button_2_to_3)).perform(ViewActions.click())
        third_activityOnScreen()
        onView(ViewMatchers.withId(R.id.button_3_to_1)).perform(ViewActions.click())
        first_activityOnScreen()

    }

    @Test
    fun testFromThirdToSecond(){
        launchActivity<MainActivity>()
        first_activityOnScreen()
        onView(ViewMatchers.withId(R.id.button_1_to_2)).perform(ViewActions.click())
        second_activityOnScreen()
        onView(ViewMatchers.withId(R.id.button_2_to_3)).perform(ViewActions.click())
        third_activityOnScreen()
        onView(ViewMatchers.withId(R.id.button_3_to_2)).perform(ViewActions.click())
        second_activityOnScreen()
    }
    private fun first_activityOnScreen() {
        onView(ViewMatchers.withId(R.id.fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.button_1_to_2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun second_activityOnScreen() {
        onView(ViewMatchers.withId(R.id.fragment2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.button_2_to_1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.button_2_to_3))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun third_activityOnScreen() {
        onView(ViewMatchers.withId(R.id.fragment3))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.button_3_to_1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.button_3_to_2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun aboutOnScreen() {
        onView(ViewMatchers.withId(R.id.about_activity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}