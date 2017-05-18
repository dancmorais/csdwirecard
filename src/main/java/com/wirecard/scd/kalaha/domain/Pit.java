package com.wirecard.scd.kalaha.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by pavol.harhovsky on 5/18/2017.
 */
@Setter
@Getter
public class Pit {

    private int stones;
    private boolean endZone;

    public Pit() {
        this.stones = 6;
        this.endZone = false;
    }
    public Pit(boolean endZone) {
        this.stones = 0;
        this.endZone = true;
    }
}
