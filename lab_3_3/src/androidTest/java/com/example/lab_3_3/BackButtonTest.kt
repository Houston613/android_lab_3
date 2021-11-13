package com.example.lab_3_3
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Test
class BackButtonTest {
    @Test
    fun backFromSecondToFirst() {
        launchActivity<FirstActivity>()
        first_activityOnScreen()
        onView(withId(R.id.button_1_to_2)).perform(click())
        second_activityOnScreen()
        pressBack()
        first_activityOnScreen()
    }
    @Test(expected = androidx.test.espresso.NoActivityResumedException::class)
    fun backFromFirstToNothing() {
        launchActivity<FirstActivity>()
        first_activityOnScreen()
        pressBack()
    }

    @Test
    fun backFromThirdToSecond() {
        launchActivity<FirstActivity>()
        first_activityOnScreen()
        onView(withId(R.id.button_1_to_2)).perform(click())
        second_activityOnScreen()
        onView(withId(R.id.button_2_to_3)).perform(click())
        third_activityOnScreen()
        pressBack()
        second_activityOnScreen()
    }
    @Test
    fun backFromThirdToFirst() {
        launchActivity<FirstActivity>()
        first_activityOnScreen()
        onView(withId(R.id.button_1_to_2)).perform(click())
        second_activityOnScreen()
        onView(withId(R.id.button_2_to_3)).perform(click())
        third_activityOnScreen()
        pressBack()
        second_activityOnScreen()
        pressBack()
        first_activityOnScreen()

    }

    @Test
    fun backFromAboutToFirst() {
        launchActivity<FirstActivity>()
        first_activityOnScreen()
        openAbout()
        aboutOnScreen()
        pressBack()
        first_activityOnScreen()
    }

    @Test
    fun backFromAboutToSecond() {
        launchActivity<FirstActivity>()
        first_activityOnScreen()
        onView(withId(R.id.button_1_to_2)).perform(click())
        second_activityOnScreen()
        openAbout()
        aboutOnScreen()
        pressBack()
        second_activityOnScreen()
    }

    @Test
    fun backFromAboutToThird() {
        launchActivity<FirstActivity>()
        first_activityOnScreen()
        onView(withId(R.id.button_1_to_2)).perform(click())
        second_activityOnScreen()
        onView(withId(R.id.button_2_to_3)).perform(click())
        third_activityOnScreen()
        openAbout()
        aboutOnScreen()
        pressBack()
        third_activityOnScreen()
    }


    private fun first_activityOnScreen() {
        onView(withId(R.id.first_activity)).check(matches(isDisplayed()))
        onView(withId(R.id.button_1_to_2)).check(matches(isDisplayed()))
    }

    private fun second_activityOnScreen() {
        onView(withId(R.id.second_activity)).check(matches(isDisplayed()))
        onView(withId(R.id.button_2_to_1)).check(matches(isDisplayed()))
        onView(withId(R.id.button_2_to_3)).check(matches(isDisplayed()))
    }

    private fun third_activityOnScreen() {
        onView(withId(R.id.third_activity)).check(matches(isDisplayed()))
        onView(withId(R.id.button_3_to_1)).check(matches(isDisplayed()))
        onView(withId(R.id.button_3_to_2)).check(matches(isDisplayed()))
    }

    private fun aboutOnScreen() {
        onView(withId(R.id.about_activity)).check(matches(isDisplayed()))
    }
}