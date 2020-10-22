package org.firstinspires.ftc.teamcode.teleop;

import android.provider.Settings;

import org.firstinspires.ftc.teamcode.settings.GlobalVariables;
import org.firstinspires.ftc.teamcode.teleop.controlers.Controler;

public class ControlerRegister {

    //Instance Variables
    private Controler[] controlers;
    private GlobalVariables globalVariables;
    private boolean running = false;

    //Constructor
    public ControlerRegister(Controler[] controlers, GlobalVariables globalVariables){
        this.controlers = controlers;
        this.globalVariables = globalVariables;
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
            this.globalVariables.eventBus.register(controler);
            controler.start();
        }
    }

    public void stop(){
        this.running = false;

        for (Controler controler : this.controlers){
            this.globalVariables.eventBus.unregister(controler);
            controler.stop();
        }
    }
}
