package com.react.practice.dto;


import com.react.practice.entity.BoardEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

     //작성글 정보
     private Long boardId;
     private String boardTitle;
     private String boardWriter;
     private String boardContents;
     private int boardHits; //조회수


     //책정보
     private String bookImage;
     private String bookTitle;
     private String bookWriter;
     private String bookPublisher; // 출판사
     private String bookState; // 판매의사
     private String bookPrice;


     public static BoardDTO toBoardDTO(BoardEntity boardEntity){
          BoardDTO boardDTO = new BoardDTO();

          //Entity > DTO
          boardDTO.setBoardId(boardEntity.getBoardId());
          boardDTO.setBoardTitle(boardEntity.getBoardTitle());
          boardDTO.setBoardWriter(boardEntity.getBoardWriter());
          boardDTO.setBoardContents(boardEntity.getBoardContents());
          boardDTO.setBoardHits(boardEntity.getBoardHits());

          boardDTO.setBookImage(boardEntity.getBookImage());
          boardDTO.setBookTitle(boardEntity.getBookTitle());
          boardDTO.setBookWriter(boardEntity.getBookWriter());
          boardDTO.setBookPublisher(boardEntity.getBookPublisher());
          boardDTO.setBookState(boardEntity.getBookState());
          boardDTO.setBookPrice(boardEntity.getBookPrice());

          return boardDTO;
     }



}
