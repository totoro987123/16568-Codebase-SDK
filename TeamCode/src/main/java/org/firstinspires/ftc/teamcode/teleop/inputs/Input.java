package org.firstinspires.ftc.teamcode.teleop.inputs;

import org.firstinspires.ftc.teamcode.settings.GlobalVariables;

public abstract class Input {
    //Variables
    public GlobalVariables vars;

    //Methods
    public abstract void update();
    public abstract void start();
    public abstract void stop();
}
