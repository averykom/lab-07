package com.example.lab_07

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    @Test
    fun navigate_to_drivers_add_clear_and_return_home() {
        // navigate to drivers screen
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        // verify drivers screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // add first driver
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Lewis Hamilton")
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // add second driver
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Max Verstappen")
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify drivers appear in the list
        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("Max Verstappen")
            .assertIsDisplayed()

        // clear all drivers
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        // verify drivers were removed
        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertDoesNotExist()
        composeTestRule
            .onNodeWithText("Max Verstappen")
            .assertDoesNotExist()

        // return to home screen
        composeTestRule
            .onNodeWithTag("driversBackButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertDoesNotExist()
    }
}

