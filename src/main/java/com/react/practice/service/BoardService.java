package com.react.practice.service;


import com.react.practice.dto.BoardDTO;
import com.react.practice.entity.BoardEntity;
import com.react.practice.repository.BoardRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //생성자 생성
public class BoardService {
    //생성자 의존성 주입
    private final BoardRepository boardRepository;


    //로그인 유무 확인 메소드
    public String LoginCheck(HttpServletRequest request){
        String result;
        HttpSession session = request.getSession(false);
        System.out.println(session);
        if(session.getAttribute("LoginID") != null){//로그인이 되어 있을 경우
            result = "login";
        }else{
            result = "logout";
        }
        return result;
    }


    //작성글 저장 메소드
    public String save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        boardRepository.save(boardEntity);
        return "board/writeSuccess";

    }

    //게시글의 정보를 가져오는 메소드
    public List<BoardDTO> findAll(){
        //repository로 가져올 때는 Entity로 가져온다.
        List<BoardEntity> boardEntityList = boardRepository.findAll();

        //Entity > DTO
        List<BoardDTO> boardDTOList = new ArrayList<>();

        //repository에서 DB에서 받아온 값(boardEntitiyLIst)을
        // boardEntity객체에 넘기고 그 값을 DTO로 변환하고 DTOList에 추가
        for(BoardEntity boardEntity: boardEntityList){
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }

        return boardDTOList;
    }

    @Transactional //JPA 제공이 아닌 별도 추가 메소드를 사용하는 경우 사용하는 어노테이션, 게시글 조회수 증가 메소드
    public void updateHits(Long boardId) {
        boardRepository.updateHits(boardId);
    }

    //사용자의 아이디를 찾는 매소드
    public BoardDTO findById(Long boardId) {
        Optional<BoardEntity> OptionBoardEntity = boardRepository.findById(boardId);

        if(OptionBoardEntity.isPresent()){
            BoardEntity boardEntity = OptionBoardEntity.get();
            BoardDTO boardDTO = BoardDTO.toBoardDTO(boardEntity);

            return  boardDTO;
        }else{
            return null;
        }
    }

    //게시글 업데이트
    public BoardDTO postUpdate(BoardDTO boardDTO) {
        //JPA는 업데이트를 따로 제공하지 않는다. 아이디의 유무로 insert, update 판단
        BoardEntity boardEntity = BoardEntity.toUpdateEntity(boardDTO);
        boardRepository.save(boardEntity);

        return findById(boardDTO.getBoardId());
    }

    //게시글 삭제
    public void postDelete(Long boardId) {
        boardRepository.deleteById(boardId);
    }
}
