package org.firstinspires.ftc.teamcode.teleop.controlers;

import com.google.common.eventbus.Subscribe;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.events.controlerEvents.Button_gamepad1_A_Lift;
import org.firstinspires.ftc.teamcode.events.controlerEvents.Button_gamepad1_A_Press;
import org.firstinspires.ftc.teamcode.settings.GlobalVariables;

public class TestControler extends Controler {

    private boolean pressed = false;
    private Telemetry telemetry;

    public TestControler(GlobalVariables globalVariables, Telemetry telemetry){
        super.globalVariables = globalVariables;
        this.telemetry = telemetry;
    }

    @Override
    public void update() {
        telemetry.addData("Button A Press: ", "Button A Press: " + String.valueOf(this.pressed));
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Subscribe
    public void buttonAPress(Button_gamepad1_A_Press event) {
        this.pressed = true;
    }

    @Subscribe
    public void buttonALift(Button_gamepad1_A_Lift event) {
        this.pressed = false;
    }
}
