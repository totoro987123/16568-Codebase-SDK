package org.firstinspires.ftc.teamcode.teleop;

import org.firstinspires.ftc.teamcode.teleop.inputs.Input;

public class InputRegister{

    //Instance Variables
    private Input[] inputs;
    private boolean running = false;

    //Constructor
    public InputRegister(Input[] inputs){
        this.inputs = inputs;
    }

    //Public Methods

    public void update(){
        if (this.running) {
            for (Input input : this.inputs){
                input.start();
            }
        }
    }

    public void start(){
        this.running = true;

        for (Input input : this.inputs){
            input.start();
        }
    }

    public void stop(){
        this.running = false;

        for (Input input : this.inputs){
            input.stop();
        }
    }
}
