package com.bora.blackberry.domain.board.service;

import com.bora.blackberry.api.v1.board.form.BoardForm;
import com.bora.blackberry.domain.board.entity.Board;
import com.bora.blackberry.domain.board.repository.BoardRepository;
import com.bora.blackberry.domain.constant.IsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public long addBoard(BoardForm boardForm) {

        return boardRepository.save(Board.builder()
                    .title(boardForm.getTitle())
                    .description(boardForm.getDescription())
                    .countOfStudent(0L)
                    .deleted(IsType.N)
                    .build()).getId();
    }
}
