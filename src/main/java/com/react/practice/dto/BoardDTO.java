package com.react.practice.dto;


import com.react.practice.entity.BoardEntity;
import lombok.*;

@Getter //Get메소드
@Setter //Set메소드
@ToString //toString 메소드
@NoArgsConstructor //기본생성자
@AllArgsConstructor // 모든 필드를 매개변수로 갖는 생성자
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
