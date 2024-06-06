package com.react.practice.repository;

import com.react.practice.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    //게시판 조회수 업데이트

    //Entity기준 업데이트 쿼리
    @Modifying
    @Query(value = "update BoardEntity b set b.boardHits=b.boardHits+1 where b.boardId=:boardId")

    void updateHits(@Param("boardId")Long boardId);
}
