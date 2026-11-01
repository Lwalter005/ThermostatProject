package org.fooddoodsinc.thermostatproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ThermostatController {
    @FXML
    protected Label currentTempDisplay;
    @FXML
    protected Label targetTempDisplay;
    @FXML
    private Label fanDisplay;
    @FXML
    private Label systemModeDisplay;

    private Boolean powerOn = false;
    protected Integer currentTemp = 75;
    protected Integer targetTemp = 75;
    private SystemMode systemMode = SystemMode.COOL;
    private FanMode fanMode = FanMode.AUTO;

    private enum SystemMode {
        COOL,
        HEAT
    }
    private enum FanMode {
        AUTO,
        OFF,
        ON
    }

    @FXML
    protected void onPowerButtonClick() {
        if (!powerOn) {
            currentTemp = 75;
            currentTempDisplay.setText(String.valueOf(currentTemp));
            targetTempDisplay.setText(String.valueOf(targetTemp));
            switch(systemMode) {
                case COOL:
                    systemModeDisplay.setText("Cool");
                    break;
                case HEAT:
                    systemModeDisplay.setText("Heat");
                    break;
            }
            switch(fanMode) {
                case AUTO:
                    fanDisplay.setText("Auto");
                    break;
                case OFF:
                    fanDisplay.setText("Off");
                    break;
                case ON:
                    fanDisplay.setText("On");
                    break;
            }
            powerOn = true;
        } else {
            currentTempDisplay.setText("");
            targetTempDisplay.setText("");
            systemModeDisplay.setText("");
            fanDisplay.setText("");
            powerOn = false;
        }
    }

    @FXML
    protected void onTempUpButtonClick() {
        if(powerOn) {
            targetTempDisplay.setText(String.valueOf(++targetTemp));
        }
    }

    @FXML
    protected void onTempDownButtonClick() {
        if(powerOn) {
            targetTempDisplay.setText(String.valueOf(--targetTemp));
        }
    }

    @FXML
    protected void onModeButtonClick() {
        if(powerOn) {
            switch (systemMode) {
                case COOL:
                    systemMode = SystemMode.HEAT;
                    systemModeDisplay.setText("Heat");
                    break;
                case HEAT:
                    systemMode = SystemMode.COOL;
                    systemModeDisplay.setText("Cool");
                    break;
            }
        }
    }

    @FXML
    protected void onFanButtonClick() {
        if(powerOn) {
        switch(fanMode) {
            case AUTO:
                fanMode = FanMode.OFF;
                fanDisplay.setText("Off");
                break;
            case OFF:
                fanMode = FanMode.ON;
                fanDisplay.setText("On");
                break;
            case ON:
                fanMode = FanMode.AUTO;
                fanDisplay.setText("Auto");
                break;
        }
        }
    }
}