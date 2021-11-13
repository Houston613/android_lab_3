package com.example.lab_3_3

import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class RotationTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(FirstActivity::class.java)

    @Test
    fun first_activityRotationTest() {
        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT }
        Thread.sleep(1000)
        first_activityOnScreen()

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE }
        Thread.sleep(1000)
        first_activityOnScreen()
    }

    @Test
    fun second_activityRotationTest() {
        onView(withId(R.id.button_1_to_2)).perform(ViewActions.click())
        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT }
        Thread.sleep(1000)
        second_activityOnScreen()

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE }
        Thread.sleep(1000)
        second_activityOnScreen()
    }

    @Test
    fun third_activityRotationTest() {
        onView(withId(R.id.button_1_to_2)).perform(ViewActions.click())
        onView(withId(R.id.button_2_to_3)).perform(ViewActions.click())
        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT }
        Thread.sleep(1000)
        third_activityOnScreen()

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE }
        Thread.sleep(1000)
        third_activityOnScreen()
    }

    @Test
    fun aboutRotationTest() {
        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT }
        openAbout()
        Thread.sleep(1000)
        aboutOnScreen()

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE }
        Thread.sleep(1000)
        aboutOnScreen()
    }


    private fun first_activityOnScreen() {
        onView(withId(R.id.first_activity)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.button_1_to_2)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun second_activityOnScreen() {
        onView(withId(R.id.second_activity)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.button_2_to_1)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.button_2_to_3)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun third_activityOnScreen() {
        onView(withId(R.id.third_activity)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.button_3_to_1)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.button_3_to_2)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun aboutOnScreen() {
        onView(withId(R.id.about_activity)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}