package com.react.practice.entity;


import com.react.practice.dto.BoardDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
    private Long boardId;

    @Column(nullable = false)
    private String boardTitle;
    @Column//(nullable = false)
    private String boardWriter;
    @Column
    private String boardContents;
    @Column
    private int boardHits;

    @Column
    private String bookImage;
    @Column(nullable = false)
    private String bookTitle;
    @Column(nullable = false)
    private String bookWriter;
    @Column(nullable = false)
    private String bookPublisher;
    @Column(nullable = false)
    private String bookState;
    @Column
    private String bookPrice;

    public static BoardEntity toSaveEntity(BoardDTO boardDTO){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(0);

        boardEntity.setBookImage(boardDTO.getBookImage());
        boardEntity.setBookTitle(boardDTO.getBookTitle());
        boardEntity.setBookWriter(boardDTO.getBookWriter());
        boardEntity.setBookPublisher(boardDTO.getBookPublisher());
        boardEntity.setBookState(boardDTO.getBookState());
        boardEntity.setBookPrice(boardDTO.getBookPrice());

        return boardEntity;
    }


    public static BoardEntity toUpdateEntity(BoardDTO boardDTO) {

        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardId(boardDTO.getBoardId());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(boardDTO.getBoardHits());

        boardEntity.setBookImage(boardDTO.getBookImage());
        boardEntity.setBookTitle(boardDTO.getBookTitle());
        boardEntity.setBookWriter(boardDTO.getBookWriter());
        boardEntity.setBookPublisher(boardDTO.getBookPublisher());
        boardEntity.setBookState(boardDTO.getBookState());
        boardEntity.setBookPrice(boardDTO.getBookPrice());

        return boardEntity;
    }
}

