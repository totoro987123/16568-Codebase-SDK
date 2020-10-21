package org.firstinspires.ftc.teamcode.teleop;

import org.firstinspires.ftc.teamcode.teleop.controlers.Controler;

public class ControlerRegister {

    //Instance Variables
    private Controler[] controlers;
    private boolean running = false;

    //Constructor
    public ControlerRegister(Controler[] controlers){
        this.controlers = controlers;
    }

    //Public Methods

    public void update(){
        if (this.running) {
            for (Controler controler : this.controlers){
                controler.update();
            }
        }
    }

    public void start(){
        this.running = true;

        for (Controler controler : this.controlers){
            controler.start();
        }
    }

    public void stop(){
        this.running = false;

        for (Controler controler : this.controlers){
            controler.stop();
        }
    }
}
