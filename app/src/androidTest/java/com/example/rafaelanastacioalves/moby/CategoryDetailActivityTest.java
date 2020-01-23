package com.example.rafaelanastacioalves.moby;

import android.content.Intent;
import android.os.Bundle;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.rafaelanastacioalves.moby.jokeshowing.JokeShowingFragment;
import com.example.rafaelanastacioalves.moby.jokeshowing.JokeShowingActivity;
import com.example.rafaelanastacioalves.moby.util.RestServiceTestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;


@RunWith(AndroidJUnit4.class)
public class CategoryDetailActivityTest {
    @Rule
    public ActivityTestRule<JokeShowingActivity> tripPackageDetailActivityTestRule = new ActivityTestRule<JokeShowingActivity>(JokeShowingActivity.class, true, false);
    private String fileNameTripPackageDetailOKResponse = "package_detail_ok_response.json";
    private MockWebServer server;
    private String MOCK_PACKAGE_ID = "01";


    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();
        server.start(1234);
        InstrumentationRegistry.registerInstance(InstrumentationRegistry.getInstrumentation(),new Bundle());
        server.url("/").toString();
    }

    @Test
    public void shouldShowTripPackageDetailSuccess() throws IOException {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(RestServiceTestHelper.getStringFromFile(
                        InstrumentationRegistry.getInstrumentation().getContext()
                        , fileNameTripPackageDetailOKResponse)
                )
        );

        Intent intent = new Intent();
        intent.putExtra(JokeShowingFragment.Companion.getARG_JOKE_CATEGORY(), MOCK_PACKAGE_ID);
        tripPackageDetailActivityTestRule.launchActivity(intent);



        onView(allOf(withId(R.id.detail_entity_detail_name), withText("5000,00"))).check(matches(isDisplayed()));

    }


    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }
}
