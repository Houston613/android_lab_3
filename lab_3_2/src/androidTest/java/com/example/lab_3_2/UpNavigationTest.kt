package com.example.lab_3_2


import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Test

class UpNavigationTest {
    @Test
    fun testNavigateUpFromSecond() {
        launchActivity<FirstActivity>()
        onView(withId(R.id.button_1_to_2)).perform(click())
        second_activityOnScreen()
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        first_activityOnScreen()
    }
    @Test
    fun testNavigateUpFromThird() {
        launchActivity<FirstActivity>()
        first_activityOnScreen()
        onView(withId(R.id.button_1_to_2)).perform(click())
        second_activityOnScreen()
        onView(withId(R.id.button_2_to_3)).perform(click())
        third_activityOnScreen()
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        second_activityOnScreen()
    }
    @Test
    fun testNavigateUpFromAboutToFirst() {
        launchActivity<FirstActivity>()
        first_activityOnScreen()
        openAbout()
        aboutOnScreen()
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        first_activityOnScreen()
    }
    @Test
    fun testNavigateUpFromAboutToSecond() {
        launchActivity<FirstActivity>()
        first_activityOnScreen()
        onView(withId(R.id.button_1_to_2)).perform(click())
        second_activityOnScreen()
        openAbout()
        aboutOnScreen()
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        second_activityOnScreen()
    }
    @Test
    fun testNavigateUpFromAboutToThird() {
        launchActivity<FirstActivity>()
        first_activityOnScreen()
        onView(withId(R.id.button_1_to_2)).perform(click())
        second_activityOnScreen()
        onView(withId(R.id.button_2_to_3)).perform(click())
        third_activityOnScreen()
        openAbout()
        aboutOnScreen()
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        third_activityOnScreen()
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