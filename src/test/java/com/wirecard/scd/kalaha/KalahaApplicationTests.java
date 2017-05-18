package com.wirecard.scd.kalaha;

import com.wirecard.scd.kalaha.domain.Board;
import com.wirecard.scd.kalaha.domain.Pit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
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
		int stones = 0;
		Assert.assertEquals(6,0);

	}


	public Board createBoard(){
		Board board = new Board();
		return board;
	}
	public Pit createPit(){
		Pit pit = new Pit();
		return pit;
	}

}
