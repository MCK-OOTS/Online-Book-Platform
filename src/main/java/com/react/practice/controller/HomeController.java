package com.react.practice.controller;

import com.react.practice.dto.BoardDTO;
import com.react.practice.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor//생성자 생성
public class HomeController {
    private final BoardService boardService;

    //기본 페이지 요청
    @GetMapping("/")
    public String index(Model model){

        //게시판 정보 가져오기
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList",boardDTOList);
        return "index.html";
    }


}
