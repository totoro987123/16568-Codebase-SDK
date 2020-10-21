package org.firstinspires.ftc.teamcode.teleop.controlers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.settings.GlobalVariables;

public class DriveControler extends Controler {

    public DriveControler(GlobalVariables globalVariables){
        super.globalVariables = globalVariables;
    }

    @Override
    public void update() {
        double drive = -globalVariables.gamepad1.left_stick_y;
        double turn  =  globalVariables.gamepad1.right_stick_x;

        double leftPower = Range.clip(drive + turn, -1.0, 1.0);
        double rightPower   = Range.clip(drive - turn, -1.0, 1.0);

        globalVariables.fl.setPower(leftPower);
        globalVariables.bl.setPower(leftPower);
        globalVariables.fr.setPower(rightPower);
        globalVariables.br.setPower(rightPower);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        for (DcMotor wheel : globalVariables.wheels) {
            wheel.setPower(0);
        }
    }
}
