package com.wirecard.scd.kalaha;

import com.wirecard.scd.kalaha.domain.Board;
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
		Pit pit = null;
		Assert.assertNotNull(pit);

	}

	public Board createBoard(){
		Board board = new Board();
		return board;
	}

	public class Pit {

	}





}
