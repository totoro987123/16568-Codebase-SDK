package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.settings.GlobalVariables;
import org.firstinspires.ftc.teamcode.teleop.controlers.Controler;
import org.firstinspires.ftc.teamcode.teleop.controlers.TestControler;

@TeleOp(name="Basic: Iterative OpMode", group="Iterative Opmode")

public class TeleOpMain extends OpMode
{
    private GlobalVariables globalVariables;
    private ControlerRegister controlerRegister;
    private ControllerInputEventHandler controllerInputEventHandler;
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void init() {

        this.globalVariables = new GlobalVariables(hardwareMap);
        this.globalVariables.initTeleOp(gamepad1, gamepad2);

        Controler[] controllers = {
            new TestControler(this.globalVariables, this.telemetry)
        };

        this.controlerRegister = new ControlerRegister(controllers, this.globalVariables);
        this.controllerInputEventHandler = new ControllerInputEventHandler(this.globalVariables);
    }


    @Override
    public void init_loop() {

    }

    @Override
    public void start() {
        this.runtime.reset();
        this.controlerRegister.start();
    }

    @Override
    public void loop() {
        this.controllerInputEventHandler.update();
        this.controlerRegister.update();

        // Show the elapsed game time
        this.telemetry.addData("Status", "Run Time: " + runtime.toString());
        this.telemetry.update();
    }

    @Override
    public void stop() {
        controlerRegister.stop();
    }

}
