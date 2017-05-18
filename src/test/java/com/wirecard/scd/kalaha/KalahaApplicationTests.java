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
    public void doesBoardHaveEndZones(){
        Board board = createBoard();
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.getEndZones());
        Assert.assertEquals(2, board.getEndZones().size());
    }

    public Board createBoard() {
        Board board = new Board();
        return board;
    }

    public Pit createPit() {
        Pit pit = new Pit();
        return pit;
    }

    public Pit createEndZone() {
        Pit pit = new Pit(true);
        return pit;

    }
}
