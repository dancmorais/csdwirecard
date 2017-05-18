package com.wirecard.scd.kalaha;

import com.wirecard.scd.kalaha.domain.Board;
import com.wirecard.scd.kalaha.domain.Pit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//SpringBootTest
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
    public void doesBoardHavePits(){
        Board board = createBoard();
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.getPits());
        Assert.assertEquals(12, board.getPits().size());
    }

    @Test
    public void isEmptyPitTest(){
        Pit pit = new Pit();
        pit.setStones(0);
        Assert.assertEquals(0,pit.getStones());
    }

    //Select a pit, move the rocks and empty the pit
    @Test
    public void selectPitTest(){
        Board board = new Board();
        board.selectPit(0);
        Assert.assertEquals(0, board.selectPit(0).getStones());
    }

    @Test
    public void doesBoardHaveEndZones(){
        Board board = createBoard();
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.getEndZones());
        Assert.assertEquals(2, board.getEndZones().size());
    }

    @Test
    public void distributeStonesAfterSelectPit(){
        Board board = createBoard();
        Pit pit = board.getPits().get(0);
        Assert.assertEquals(0, pit.getStones());
        Pit nextPit = board.getPits().get(1);
        Assert.assertEquals(7, nextPit.getStones());
    }

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
