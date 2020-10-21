package org.firstinspires.ftc.teamcode.teleop.controlers;

import com.google.common.eventbus.Subscribe;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.events.controlerEvents.Button_gamepad1_A_Press;
import org.firstinspires.ftc.teamcode.settings.GlobalVariables;

public class TestControler extends Controler {

    public TestControler(GlobalVariables globalVariables){
        super.globalVariables = globalVariables;
    }

    @Override
    public void update() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {
    }
}
