package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.events.Event;
import org.firstinspires.ftc.teamcode.settings.GlobalVariables;

import java.util.HashMap;

public class ControlerInputEventHandler {

    private final String eventsClassPath = "org.firstinspires.ftc.teamcode.events.controlerEvents.";

    private GlobalVariables globalVariables;

    private String[] inputNamesBoolean = {"a", "b", "back", "dpad_down", "dpad_left", "dpad_right", "dpad_up", "left_bumper", "left_stick_button", "right_bumper", "right_stick_button", "x", "y"};
    private HashMap<String, Boolean> booleanInputStore = new HashMap<String, Boolean>();

    public ControlerInputEventHandler(GlobalVariables globalVariables) {
        this.globalVariables = globalVariables;
    }

    private void updateGamepadStatus(Gamepad gamepad) {
        Object object = (Object) gamepad;
        Class<?> gamepadClass = object.getClass();

        for (String variableName : this.inputNamesBoolean) {
            try {
                boolean lastValue = booleanInputStore.get(variableName);
                boolean currentValue = (boolean) gamepadClass.getField(variableName).get(gamepad);

                if ((lastValue != currentValue) && booleanInputStore.containsKey(variableName)) {
                    if (currentValue) {
                        Class<?> eventClass = Class.forName(this.eventsClassPath + "Button" + variableName.toUpperCase() + "Press");
                        Event event = (Event) eventClass.newInstance();
                        this.globalVariables.eventBus.post(event);
                    } else {
                        Class<?> eventClass = Class.forName(this.eventsClassPath + "Button" + variableName.toUpperCase() + "Lift");
                        Event event = (Event) eventClass.newInstance();
                        this.globalVariables.eventBus.post(event);
                    }
                }
                this.booleanInputStore.put(variableName, currentValue);

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
}
