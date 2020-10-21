package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.events.Event;
import org.firstinspires.ftc.teamcode.settings.GlobalVariables;

import java.util.HashMap;

public class ControlerInputEventHandler {

    // FINAL VARIABLES
    private final String eventsClassPath = "org.firstinspires.ftc.teamcode.events.controlerEvents.";
    //private final String[] inputNamesBoolean = {"a", "b", "back", "dpad_down", "dpad_left", "dpad_right", "dpad_up", "left_bumper", "left_stick_button", "right_bumper", "right_stick_button", "x", "y"};
    private final String[] inputNamesBoolean = {"a"};


    // INSTANCE VARIABLES
    private GlobalVariables globalVariables;
    private HashMap<String, Boolean> booleanInputStoreGamepad1 = new HashMap<String, Boolean>();
    private HashMap<String, Boolean> booleanInputStoreGamepad2 = new HashMap<String, Boolean>();

    // CONSTRUCTOR
    public ControlerInputEventHandler(GlobalVariables globalVariables) {
        this.globalVariables = globalVariables;
    }

    // METHODS

    // MAKE IT WORK WITH DIFFERENT GAMEPADS
    private void updateGamepadStatus(Gamepad gamepad, String gamepadName, HashMap<String, Boolean> booleanInputStore) {
        Object object = (Object) gamepad;
        Class<?> gamepadClass = object.getClass();

        for (String variableName : this.inputNamesBoolean) {
            try {
                boolean lastValue = booleanInputStore.get(variableName);
                boolean currentValue = (boolean) gamepadClass.getField(variableName).get(gamepad);

                if ((lastValue != currentValue) && booleanInputStore.containsKey(variableName)) {
                    if (currentValue) {
                        Class<?> eventClass = Class.forName(this.eventsClassPath + "Button_" + gamepadName + "_" + variableName.toUpperCase() + "_Press");
                        Event event = (Event) eventClass.newInstance();
                        this.globalVariables.eventBus.post(event);
                    } else {
                        Class<?> eventClass = Class.forName(this.eventsClassPath + "Button_" + gamepadName + "_" + variableName.toUpperCase() + "_Lift");
                        Event event = (Event) eventClass.newInstance();
                        this.globalVariables.eventBus.post(event);
                    }
                }
                booleanInputStore.put(variableName, currentValue);

            } catch (NoSuchFieldException e) {
                System.out.println(e.toString());
            } catch (SecurityException e) {
                System.out.println(e.toString());
            } catch (IllegalArgumentException e) {
                System.out.println(e.toString());
            } catch (IllegalAccessException e) {
                System.out.println(e.toString());
            } catch (ClassNotFoundException e) {
                System.out.println(e.toString());
            } catch (InstantiationException e) {
                System.out.println(e.toString());
            }
        }
    }

    private void update() {
        this.updateGamepadStatus(this.globalVariables.gamepad1, "gamepad1", this.booleanInputStoreGamepad1);
        this.updateGamepadStatus(this.globalVariables.gamepad2, "gamepad2", this.booleanInputStoreGamepad2);
    }
}
