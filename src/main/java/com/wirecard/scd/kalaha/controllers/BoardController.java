package com.wirecard.scd.kalaha.controllers;

import com.wirecard.scd.kalaha.domain.Board;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pavol.harhovsky on 5/18/2017.
 */
@RestController
public class BoardController {

    @CrossOrigin
    @RequestMapping("/board/new")
    public Board newBoard() {
        return new Board();
    }
}
