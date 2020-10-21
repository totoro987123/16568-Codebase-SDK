package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.settings.GlobalVariables;
import org.firstinspires.ftc.teamcode.teleop.controlers.Controler;

@TeleOp(name="Basic: Iterative OpMode", group="Iterative Opmode")

public class TeleOpMain extends OpMode
{
    private GlobalVariables vars;
    private ControlerRegister controlerRegister;
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void init() {

        vars = new GlobalVariables(hardwareMap);
        vars.initTeleOp(gamepad1, gamepad2);

        Controler[] controlers = {

        };

        controlerRegister = new ControlerRegister(controlers);
    }


    @Override
    public void init_loop() {

    }

    @Override
    public void start() {
        runtime.reset();
        controlerRegister.start();
    }

    @Override
    public void loop() {
        controlerRegister.update();

        // Show the elapsed game time
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.update();
    }

    @Override
    public void stop() {
        controlerRegister.stop();
    }

}
