package com.example.rafaelanastacioalves.moby

import android.content.Intent
import android.os.Bundle
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import com.example.rafaelanastacioalves.moby.categorylisting.CategoryListingActivity
import com.example.rafaelanastacioalves.moby.util.RestServiceTestHelper

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import java.io.IOException

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.view.View
import com.example.rafaelanastacioalves.moby.util.HelperMethods.withHolderContainingId
import org.hamcrest.core.AllOf.allOf


@RunWith(AndroidJUnit4::class)
class CategoryListingActivityTest {

    @get:Rule
    var mainActivityActivityTestRule = ActivityTestRule(CategoryListingActivity::class.java, true, false)
    private val fileNameJokeOKResponse = "single_joke_ok_response.json"
    private var server: MockWebServer? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        server = MockWebServer()
        server!!.start(1234)
        InstrumentationRegistry.registerInstance(InstrumentationRegistry.getInstrumentation(), Bundle())
        server!!.url("/").toString()


    }

    @Test
    @Throws(IOException::class)
    fun shouldShowTripPackageSuccess() {
        server!!.enqueue(MockResponse()
                .setResponseCode(200)
                .setBody(RestServiceTestHelper.getStringFromFile(
                        InstrumentationRegistry.getInstrumentation().context, fileNameJokeOKResponse)
                )
        )

        val intent = Intent()

        mainActivityActivityTestRule.launchActivity(intent)

        onView(
                withId(R.id.joke_category_list)
        ).perform(
                RecyclerViewActions.scrollToHolder(
                        withHolderContainingId(R.id.joke_category_title_textview)
                )
        )
        onView(allOf<View>(withId(R.id.joke_category_title_textview), withText("animal"))).check(matches(isDisplayed()))

    }


    @After
    @Throws(Exception::class)
    fun tearDown() {
        server!!.shutdown()
    }
}
