package com.cac.lib.Control;

import com.cac.lib.Event;
import com.cac.lib.Camera.Camera;

public class Control {
    private int speed = Set.Ca

    public void detect() {
        if (Event.getPressedDown("w")) {
            Camera.translate(, 0, 0);
        }
    }
}
