package com.react.practice.controller;


import com.react.practice.dto.BoardDTO;
import com.react.practice.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLEncoder;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor //생성자 생성
@Setter

public class BoardController {

    //의존성 주입
    private final BoardService boardService;

    //네이버 검색 API를 사용하기 위해 API ID, SECRET을 통한 의존성 주입
    private final String NAVER_API_ID = "oJ2q0QKw3V9rXWHOMBM5";
    private final String NAVER_API_SECRET = "38dakeeB2E";


    //글 작성 폼
    @GetMapping("board/write")
    public String write(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String LoginState = boardService.LoginCheck(request);
        if (LoginState.equals("login")) {
            return "board/write";
        } else {
            return "member/login";
        }

    }

    //글 작성 완료
    @PostMapping("board/writeFinish")
    public String index(@ModelAttribute BoardDTO boardDTO) {
            boardService.save(boardDTO);
            return "board/writeSuccess";

    }

    //게시글 조회
    //게시판 번호를 url로 가져옴
    @GetMapping("board/{boardId}")
    public String findById(@PathVariable("boardId") Long boardId, Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();

        String LoginState = boardService.LoginCheck(request);
        if (LoginState.equals("login")) { //로그인 상태 시에 서비스 이용

            boardService.updateHits(boardId); //조회수 증가

            BoardDTO boardDTO = boardService.findById(boardId);

            if (boardDTO == null) {
                return "board/postNotFound";
            }
            model.addAttribute("board", boardDTO);

            return "board/post"; //게시글 상세 조회 페이지

        } else {
            return "member/login";
        }


    }

    //api를 활용한 검색 페이지로 이동
    @GetMapping("board/searchPopup")
    public String popup(){

        return "board/bookSearch";
    }




    //API활용한 책 정보검색
    @PostMapping("board/bookSearch")
    public String bookSearch(@ModelAttribute("keyword") String keyword, Model model) throws IOException {

            //검색을 통해 JSON 형식으로 데이터 받기
            String encodedKeyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8);//UTF-8로 검색
            String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + encodedKeyword;//키워드로 검색요청
            URL url = new URL(apiURL);


            //HTTP헤더에 API의 ID, SECRET을 넣어준다
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", NAVER_API_ID);
            con.setRequestProperty("X-Naver-Client-Secret", NAVER_API_SECRET);

            //응답 데이터 읽어오기
            int reponseCode = con.getResponseCode();
            BufferedReader br;
            if (reponseCode == 200) {//정상적인 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }


            String inputLine; //HTTP 요청 결과
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            //요청값 중 'itmes'의 데이터를 jsonArray로 가져오기
            JSONObject jsObject = new JSONObject(response.toString());
            JSONArray jsonArray = (JSONArray) jsObject.get("items");

            List<BoardDTO> bookList = new ArrayList<>();


            //검색정보를 저장
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);

                String bookTitle = obj.getString("title");
                String bookWriter = obj.getString("author");
                String bookImage = obj.getString("image");
                String bookPublisher = obj.getString("publisher");


                BoardDTO bookDTO = new BoardDTO();
                bookDTO.setBookImage(bookImage);
                bookDTO.setBookTitle(bookTitle);
                bookDTO.setBookWriter(bookWriter);
                bookDTO.setBookPublisher(bookPublisher);
                bookList.add(bookDTO);
            }

            model.addAttribute("bookList", bookList);


            return "board/bookSearch";
    }

    //업데이트 폼으로 전달
    @GetMapping("board/update/{boardId}")
    public String updateForm(@PathVariable("boardId") Long boardId, Model model){
        BoardDTO boardDTO = boardService.findById(boardId);

        model.addAttribute("boardUpdate", boardDTO);
        return "board/postUpdate";
    }

    //업데이트 완료
    @PostMapping("board/updateFinish")
    public String postUpdate(@ModelAttribute BoardDTO boardDTO, Model model){

        BoardDTO board = boardService.postUpdate(boardDTO);
        model.addAttribute("board", board);
        return "board/post";
    }


    //게시글 삭제
    @GetMapping("board/delete/{boardId}")
    public String postDelete(@PathVariable ("boardId") Long boardId){
        boardService.postDelete(boardId);
        return "redirect:/";
    }
}