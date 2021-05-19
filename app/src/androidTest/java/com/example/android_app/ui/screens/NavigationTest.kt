package com.example.android_app.ui.screens

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.android_app.MainActivity
import com.example.android_app.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class NavigationTest {

    @Test
    fun testSettingsFragmentsNavigation() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.register_input_phone_number))
            .check(matches(isDisplayed()))

        onView(withId(R.id.settings_btn_change_username)).perform(click())
        onView(withId(R.id.settings_input_username))
            .check(matches(isDisplayed()))

        pressBack()
        onView(withId(R.id.settings_user_photo))
            .check(matches(isDisplayed()))

        onView(withId(R.id.settings_btn_change_bio)).perform(click())
        onView(withId(R.id.settings_input_bio))
            .check(matches(isDisplayed()))
    }
}
