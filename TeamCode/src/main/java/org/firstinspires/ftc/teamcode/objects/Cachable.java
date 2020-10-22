package org.firstinspires.ftc.teamcode.objects;

import java.util.HashMap;

public interface Cachable {
    HashMap<Object, Object> cache = new HashMap<Object, Object>();

    public abstract Object get(Object object);
}
