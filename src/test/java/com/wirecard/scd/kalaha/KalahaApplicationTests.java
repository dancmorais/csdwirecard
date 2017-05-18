package com.wirecard.scd.kalaha;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KalahaApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void hasBoard() {

	}

	public Board createBoard(){
		Board board = new Board();
		return board;
	}

	public class Board{



	}



}
