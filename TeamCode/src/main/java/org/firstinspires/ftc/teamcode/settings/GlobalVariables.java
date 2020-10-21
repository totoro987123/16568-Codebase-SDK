package org.firstinspires.ftc.teamcode.settings;


import com.google.common.eventbus.EventBus;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class GlobalVariables {
    //Gamepads
    public Gamepad gamepad1;
    public Gamepad gamepad2;

    //Event Handling
    public EventBus eventBus = new EventBus();

    //Declare the DcMotors
    private HardwareMap hwm;

    public DcMotor fl; //front left motor
    public DcMotor fr; //front right motor
    public DcMotor bl; //back left motor
    public DcMotor br; //back right motor
    public DcMotor[] wheels = new DcMotor[4];

    //Wheel math values
    public double wheelCircum = (1.97 * 2) * Math.PI;
    public int ticksPerTurn = 1120; //our gear ratio is 1:

    //Touch Sensor
    public DigitalChannel digitalTouch;

    //Constructor
    public GlobalVariables(HardwareMap hwm){
        this.hwm = hwm;
    }

    //Methods
    private void initGlobal(){
        //Set up motors
        fl = hwm.dcMotor.get("fl");
        fr = hwm.dcMotor.get("fr");
        bl = hwm.dcMotor.get("bl");
        br = hwm.dcMotor.get("br");

        fl.setDirection(DcMotor.Direction.REVERSE); //because the wheels are pointed in opposite directions
        fr.setDirection(DcMotor.Direction.FORWARD);
        bl.setDirection(DcMotor.Direction.REVERSE);
        br.setDirection(DcMotor.Direction.FORWARD);
        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        DcMotor[] newWheels = {fl, fr, bl, br};
        this.wheels = newWheels;
    }

    public void initAuton() {
        //Run global init
        this.initGlobal();

        //Set up touch sensor
        digitalTouch = hwm.digitalChannel.get("touch_sensor");
        digitalTouch.setMode(DigitalChannel.Mode.INPUT);

    }

    public void initTeleOp(Gamepad gamepad1, Gamepad gamepad2){
        //Run global init
        this.initGlobal();

        //Add gamepads
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
    }



}
