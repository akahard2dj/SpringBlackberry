package com.bora.blackberry.domain.board.repository;

import com.bora.blackberry.domain.board.entity.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long> {

    Board findById(long id);
}
