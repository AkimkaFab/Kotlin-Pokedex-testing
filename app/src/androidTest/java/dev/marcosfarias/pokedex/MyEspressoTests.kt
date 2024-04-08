package dev.marcosfarias.pokedex

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MyEspressoTests {

    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun runAppTest() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("dev.marcosfarias.pokedex", appContext.packageName)
    }

    @Test
    fun checkMainScreen() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val poksLookFor = appContext.getString(R.string.main_title)
        onView(withText(poksLookFor)).check(matches(allOf(isCompletelyDisplayed(), not(isClickable()))))
        val mainSearch = appContext.getString(R.string.main_search)
        onView(withText(mainSearch)).check(matches(isDisplayed()))
        val item1 = appContext.getString(R.string.menu_item_1)
        onView(withText(item1)).check(matches(allOf(isCompletelyDisplayed(), withText("Pokedex"))))

    }

    @Test
    fun openAllPoks() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val allPoks = appContext.getString(R.string.menu_item_1)
        onView(withText(allPoks)).perform(click())
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))

    }

    @Test
    fun openPokemon() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val allPoks = appContext.getString(R.string.menu_item_1)
        onView(withText(allPoks)).perform(click())
        onView(withId(R.id.recyclerView)).perform(click())
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }

    @Test
    fun speedDialClick() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val allPoks = appContext.getString(R.string.menu_item_1)
        onView(withText(allPoks)).perform(click())
        onView(withId(R.id.speedDial)).perform(click())
        onView(withText("All Type")).check(matches(isDisplayed()))
        onView(withText("All Gen")).check(matches(isDisplayed()))
        onView(withText("Search")).check(matches(isDisplayed()))
    }

    @Test
    fun openAllGens() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val allPoks = appContext.getString(R.string.menu_item_1)
        onView(withText(allPoks)).perform(click())
        onView(withId(R.id.speedDial)).perform(click())
        onView(withText("All Gen")).perform(click())
        onView(withText("Generation")).check(matches(isDisplayed()))
    }

    @Test
    fun openSearchWidget() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val allPoks = appContext.getString(R.string.menu_item_1)
        onView(withText(allPoks)).perform(click())
        onView(withId(R.id.speedDial)).perform(click())
        onView(withText("Search")).perform(click())
        onView(withText("Search Pokemon, Move, Ability, etc")).check(matches(isDisplayed()))
    }

    @Test
    fun findNewsFailingTest() {
        // Trying to find News in all Pokemons screen
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val allPoks = appContext.getString(R.string.menu_item_1)
        onView(withText(allPoks)).perform(click())
        onView(withText("Pokemons Rumble Rush")).check(matches(isDisplayed()))
    }


}
