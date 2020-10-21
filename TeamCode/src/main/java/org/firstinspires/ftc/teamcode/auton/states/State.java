package org.firstinspires.ftc.teamcode.auton.states;

import org.firstinspires.ftc.teamcode.settings.GlobalVariables;

public abstract class State {
    //Variables
    public GlobalVariables vars;

    //Methods
    public abstract String toString();
    public abstract boolean completed();
    public abstract void update();
    public abstract void start();
    public abstract void stop();
}
