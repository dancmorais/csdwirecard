package com.wirecard.scd.kalaha.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Board {
    private List<Pit> pits;
    private int lastPit;
    private int activePlayer;

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

    public List<Pit> getPitsAndZones() {
        return this.pits;
    }

    public Pit selectPit(int i) {

        distributeStones(i);
        captureOponentsStones();
        activePlayer = activePlayer == 0 ? 1 : 0;
        return pits.get(i);
    }

    private void distributeStones(int selectedPit) {

        int stones = pits.get(selectedPit).getStones();
        pits.get(selectedPit).setStones(0);

        boolean isMyEndZone = true;
        for (int j = 1; j <= stones; j++) {
            if (selectedPit + j > 13) {
                selectedPit = selectedPit - (selectedPit + j);
            }

            Pit currentPit = pits.get(selectedPit + j);
            lastPit = selectedPit + j;
            if (isMyEndZone && currentPit.isEndZone()) {
                currentPit.setStones(currentPit.getStones() + 1);
                isMyEndZone = false;
            } else if (!isMyEndZone && currentPit.isEndZone()) {
                isMyEndZone = true;
                stones++;
                continue;
            } else {
                currentPit.setStones(currentPit.getStones() + 1);
            }

        }
    }

    private void captureOponentsStones() {
        int oppositePit = Math.abs(lastPit - 12);

        if(getPitsAndZones().get(lastPit).getStones() == 1
                && (activePlayer == 0 && lastPit >= 0 && lastPit <= 5)){

            int totalStones = getPitsAndZones().get(oppositePit).getStones() +
                    getPitsAndZones().get(lastPit).getStones() +
                    getPitsAndZones().get(6).getStones();

            getPitsAndZones().get(oppositePit).setStones(0);
            getPitsAndZones().get(lastPit).setStones(0);
            getPitsAndZones().get(6).setStones(totalStones);


        }
        if(getPitsAndZones().get(lastPit).getStones() == 1
                && (activePlayer == 1 && lastPit >= 7 && lastPit <= 12)){
            int totalStones = getPitsAndZones().get(oppositePit).getStones() +
                    getPitsAndZones().get(lastPit).getStones() +
                    getPitsAndZones().get(13).getStones();

            getPitsAndZones().get(oppositePit).setStones(0);
            getPitsAndZones().get(lastPit).setStones(0);
            getPitsAndZones().get(13).setStones(totalStones);
        }
    }

}
