package com.wirecard.scd.kalaha.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Board {
  private List<Pit> pits;
  private List<Pit> endZones;

  public Board() {
    pits = new ArrayList<>();
    // Add 12 pits: 6 for each player
    for (int i = 0; i < 12; i++) {
      pits.add(new Pit());
    }
    // Add two endZones: one for each player
    endZones = new ArrayList<>();
    endZones.add(new Pit(true));
    endZones.add(new Pit(true));
  }

}
