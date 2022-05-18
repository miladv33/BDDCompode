package com.example.composeuitest

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class MyComposeTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule(MainActivity::class.java)
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    @Test
    fun myTest() {
        composeTestRule.onNodeWithTag("ChangeButton").performClick()
        composeTestRule.onNodeWithTag("textTest")
            .assertIsDisplayed()
            .assertTextEquals("Android clicked")
    }
}