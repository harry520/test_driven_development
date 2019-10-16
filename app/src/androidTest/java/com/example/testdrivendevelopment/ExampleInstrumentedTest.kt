package com.example.testdrivendevelopment

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Rule
    @JvmField
    val rule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.testdrivendevelopment", appContext.packageName)
    }

    @Test
    fun userCanEnterFirstName() {
        onView(withId(R.id.firstName)).perform(typeText("Harry"))
    }

    @Test
    fun userCanEnterLastName() {
        onView(withId(R.id.lastName)).perform(typeText("Jiang"))
    }

    @Test
    fun whenUserEntersFirstAndLastNameCheckToConfirmThatMessageIsCorrect() {
        onView(withId(R.id.firstName)).perform(typeText("Jake"))
        onView(withId(R.id.lastName)).perform(typeText("Smith"))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.message)).check(matches(withText("Welcome, Jake Smith!")))
    }

    @Test
    fun firstMessageAgain() {
        onView(withId(R.id.firstName)).perform(typeText("Mel"))
        onView(withId(R.id.lastName)).perform(typeText("Johnson"))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.message)).check(matches(withText("Welcome, Mel Johnson!")))
    }

}
