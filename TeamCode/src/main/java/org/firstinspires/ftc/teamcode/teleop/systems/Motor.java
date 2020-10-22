package org.firstinspires.ftc.teamcode.teleop.systems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.objects.Cachable;

public class Motor implements Cachable {

    private DcMotor motorObject;

    public Motor(DcMotor motorObject) {
        this.motorObject = motorObject;
    }

    @Override
    public Object get(Object object) {

        if (cache.containsKey(object)) {
            return (Motor) cache.get(object);
        }

        Motor newMotor = new Motor((DcMotor) object);

        cache.put(object, newMotor);

        return newMotor;
    }
}
