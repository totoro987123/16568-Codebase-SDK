package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.settings.GlobalVariables;
import org.firstinspires.ftc.teamcode.teleop.inputs.Input;

@TeleOp(name="Basic: Iterative OpMode", group="Iterative Opmode")

public class TeleOpMain extends OpMode
{
    private GlobalVariables vars;
    private InputRegister inputRegister;
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void init() {

        vars = new GlobalVariables(hardwareMap);
        vars.initTeleOp(gamepad1, gamepad2);

        Input[] inputs = {

        };

        inputRegister = new InputRegister(inputs);
    }


    @Override
    public void init_loop() {

    }

    @Override
    public void start() {
        runtime.reset();
        inputRegister.start();
    }

    @Override
    public void loop() {
        inputRegister.update();

        // Show the elapsed game time
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.update();
    }

    @Override
    public void stop() {
        inputRegister.stop();
    }

}
