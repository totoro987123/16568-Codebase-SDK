package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.auton.states.State;
import org.firstinspires.ftc.teamcode.settings.GlobalVariables;


@Autonomous(name = "AutonStateMachine")

public class AutonStateMachine extends OpMode {
    private GlobalVariables globalVariables;
    private StateManager sm;

    @Override
    public void init() {
        globalVariables = new GlobalVariables(hardwareMap);
        globalVariables.initAuton();

        State[] states = {

        };

        sm = new StateManager(states);
    }

    @Override
    public void start() {
        sm.startFirstState();
    }

    @Override
    public void loop() {
        sm.updateStates();

        telemetry.addLine("CurrentState: " + sm.getCurrentState());
        telemetry.addLine("StateCompleted" + sm.getCurrentState().completed());

        telemetry.update();
    }

    @Override
    public void stop() {
        sm.stopCurrentState();
    }
}