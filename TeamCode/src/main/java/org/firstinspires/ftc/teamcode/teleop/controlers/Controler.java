package org.firstinspires.ftc.teamcode.teleop.controlers;

import org.firstinspires.ftc.teamcode.settings.GlobalVariables;

public abstract class Controler {
    //Variables
    public GlobalVariables globalVariables;

    //Methods
    public abstract void update();
    public abstract void start();
    public abstract void stop();
}
