package com.wirecard.scd.kalaha;

import com.wirecard.scd.kalaha.domain.Board;
import com.wirecard.scd.kalaha.domain.Pit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
// SpringBootTest
public class KalahaApplicationTests {


    @Test
    public void hasBoard() {
        Board board = createBoard();
        Assert.assertNotNull(board);

    }

    @Test
    public void hasPit() {
        Pit pit = createPit();
        Assert.assertNotNull(pit);

    }

    @Test
    public void has6Stones() {
        int stones = createPit().getStones();
        Assert.assertEquals(6, stones);

    }

    @Test
    public void isPitEndZone() {
        boolean endZone = createEndZone().isEndZone();
        Assert.assertTrue(endZone);
    }

    @Test
    public void doesBoardHavePits() {
        Board board = createBoard();
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.getPits());
        Assert.assertEquals(12, board.getPits()
                .size());
    }

    @Test
    public void isEmptyPitTest() {
        Pit pit = new Pit();
        pit.setStones(0);
        Assert.assertEquals(0, pit.getStones());
    }

    // Select a pit, move the rocks and empty the pit
    @Test
    public void selectPitTest() {
        Board board = new Board();
        board.selectPit(0);
        Assert.assertEquals(0, board.selectPit(0)
                .getStones());
    }

    @Test
    public void doesBoardHaveEndZones() {
        Board board = createBoard();
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.getEndZones());
        Assert.assertEquals(2, board.getEndZones()
                .size());
    }


    @Test
    public void distributeStonesAfterSelectPit() {
        Board board = createBoard();
        int stones = 6;
        Pit pit = board.selectPit(0);
        Assert.assertEquals(0, pit.getStones());
        for (int i = 1; i <= stones; i++) {
            Pit nextPit = board.getPitsAndZones().get(i);
            Assert.assertEquals(nextPit.isEndZone() ? 1 : 7, nextPit.getStones());
        }
    }

    @Test
    public void dontFillOponentEndZone() {
        Board board = createBoard();
        for (Pit pit : board.getPitsAndZones()) {
            if (!pit.isEndZone()) {
                pit.setStones(8);
            }
        }
        board.selectPit(5);
        Assert.assertEquals(0, board.getPitsAndZones().get(13).getStones());

    }

    @Test
    public void captureStoneIfLastStoneInPlayer1OwnEmptyPit(){
        Board board = createBoard();
        board.getPitsAndZones().get(0).setStones(0);
        board.getPitsAndZones().get(5).setStones(8);
        board.selectPit(5);
        Assert.assertEquals(0, board.getPitsAndZones().get(12).getStones());
        Assert.assertEquals(0, board.getPitsAndZones().get(0).getStones());
        Assert.assertEquals(9, board.getPitsAndZones().get(6).getStones());
    }

    @Test
    public void captureWithLuckyNumber13(){
        Board board = createBoard();
        board.getPitsAndZones().get(0).setStones(13);
        board.selectPit(0);
        Assert.assertEquals("0th pit is not 0", 0, board.getPitsAndZones().get(0).getStones());
        Assert.assertEquals("12th pit is not 0", 0, board.getPitsAndZones().get(12).getStones());
        Assert.assertEquals("endZone pit is not 9", 9, board.getPitsAndZones().get(6).getStones());

    }
//
//    @Test
//    public void captureStoneIfLastStoneInPlayer2OwnEmptyPit(){
//        Board board = createBoard();
//        board.getPitsAndZones().get(7).setStones(0);
//        board.getPitsAndZones().get(12).setStones(8);
//        board.selectPit(12);
//        Assert.assertEquals(0, board.getPitsAndZones().get(5).getStones());
//        Assert.assertEquals(0, board.getPitsAndZones().get(7).getStones());
//        Assert.assertEquals(9, board.getPitsAndZones().get(13).getStones());
//    }

    public Board createBoard() {
        return new Board();
    }

    public Pit createPit() {
        return new Pit();
    }

    public Pit createEndZone() {
        return new Pit(true);

    }
}
