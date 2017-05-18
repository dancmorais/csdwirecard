package com.wirecard.scd.kalaha.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Board {
  private List<Pit> pits;
  // private List<Pit> endZones;

  public Board() {
    pits = new ArrayList<>();
    // Add 12 pits: 6 for each player
    for (int i = 0; i < 14; i++) {
      if (i == 6 || i == 13) {
        pits.add(new Pit(true));
      } else {
        pits.add(new Pit());
      }
    }

  }

  public List<Pit> getEndZones() {
    List<Pit> zones = new ArrayList<>();
    for (Pit pit : pits) {
      if (pit.isEndZone()) {
        zones.add(pit);
      }
    }
    return zones;
  }

  public List<Pit> getPits() {
    List<Pit> pits = new ArrayList<>();
    for (Pit pit : this.pits) {
      if (!pit.isEndZone()) {
        pits.add(pit);
      }
    }
    return pits;
  }

  public List<Pit> getPitsAndZones(){
    return this.pits;
  }

  public Pit selectPit(int i) {
//    Pit selectedPit = pits.get(i);
    pits.get(i).setStones(0);
    return pits.get(i);
  }

  public void distributeStones(){

  }



}
