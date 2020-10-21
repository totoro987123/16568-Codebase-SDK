package org.firstinspires.ftc.teamcode.auton;

import org.firstinspires.ftc.teamcode.auton.states.State;

public class StateManager {
    //Instance Variables
    private State[] states;
    private int currentState;

    //Constructor
    public StateManager(State[] states){
        this.states = states;
        this.currentState = 0;
    }

    //Private Methods
    private void startNextState(){
        if (this.currentState != this.states.length - 1) {
            this.currentState++;
            this.states[this.currentState].start();
        }
    }

    //Public Methods
    public State getCurrentState(){
        return states[currentState];
    }

    public void updateStates(){
        this.states[this.currentState].update();
        if (this.states[this.currentState].completed()) {
            this.states[this.currentState].stop();
            this.startNextState();
        }
    }

    public void startFirstState(){
        this.states[this.currentState].start();
    }

    public void stopCurrentState(){
        this.states[this.currentState].stop();
    }
}
