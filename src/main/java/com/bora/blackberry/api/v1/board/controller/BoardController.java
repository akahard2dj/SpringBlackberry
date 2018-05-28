package com.bora.blackberry.api.v1.board.controller;

import com.bora.blackberry.api.v1.board.form.BoardForm;
import com.bora.blackberry.api.v1.common.ResponseWrapper;
import com.bora.blackberry.domain.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/boards")
    public ResponseWrapper addBoard(@Valid @RequestBody BoardForm boardForm) {
        long id = boardService.addBoard(boardForm);
        return ResponseWrapper.ok(id);
    }
}
