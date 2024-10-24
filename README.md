<<<<<<< HEAD
# Online-Book-Platform
온라인 독서후기 및 거래 웹 사이트
=======
# 독서 후기 작성 및 거래 웹 사이트
3학년 **개인프로젝트** 


# 프로젝트 설명
자신이 읽은 책의 느낀 점과 후기를 작성하고 후기를 보고 다른 사용자가 원하면 구매할 수 있는 사이트

# 프로젝트 정보
- IDE : **Intelij**
- Framework : **Spring-boot**
- 개발언어 : **JAVA**
- DB : **MySQL**
- 프로젝트 개발 기간 : **약 3개월** (2024.03.07 ~ 2024.06.19)

# 주요 기능
- 회원가입 및 로그인
- 게시글 작성, 수정, 삭제
- 네이버 API를 사용한 책 검색
- 포트원 API를 사용한 카카오 페이 간편결제


- - - 

<img src="https://github.com/MCK-OOTS/Online-Book-Platform/assets/153693799/bbac64f7-57eb-494a-be56-598fbd958afe" width=300 height=300>
<img src="https://github.com/MCK-OOTS/Online-Book-Platform/assets/153693799/e7f0ea8c-d83f-41e8-8ccb-1154ea0911c8" width=300 height=300>
<img src="https://github.com/MCK-OOTS/Online-Book-Platform/assets/153693799/f8bb8554-0542-47ae-9fd3-95d042163ad2" width=300 height=300>

<img src="https://github.com/MCK-OOTS/Online-Book-Platform/assets/153693799/d7cebb01-1484-4268-8796-a278a56d28e9" width=300 height=300>  
<img src="https://github.com/MCK-OOTS/Online-Book-Platform/assets/153693799/84e2a7c5-35ef-4a66-bf35-e644ac86e2a1" width=300 height=300>  

- - - -

Issue 정리
1.**html파일 찾지 못함 404**
- 타임리프 의존성 추가해서 해결
2.**Lombok**
- 스프링 다운로드 받을 때 의존성설치로 Lombok을 같이 설정 받았다.
- 다른 어노테이션은 정상작동하는데 @Getter와 @Setter에서만 빨간줄이 생겼다.
- 컴파일을 하면 에러는 없고 정상작동한다
- 구글에 검색해봐도 빨간줄이 없어지지는 않는다
- 나중에 스프링에서 Lombok을 따로 설치를 받은후 사라졋다...
- 뭐지?? 
3.**컨트롤러에서 경로를 찾지 못하는 에러 404**
- @RequestMapping 어노테이션을 사용해서 공통 url을 지정해 주었다.
- 수정을 반복하며 에러를 잡다가 웹 url에 공통 url로 지정한 부분이 빠져있는 것을 보고 @PostMapping에 공통Url를 직접 작성하여 컴파일해보니 정상작동하였다.
4.**느낀 점**
- 처음 사용해보는 프레임워크로 개발을 하다보니 자잘한 에러들이 많았다.
- 프레임워크라는 것이 장점도 있지만, 처음 사용해보는 사람들은 오히려 어려운 점도 적지 않은 것 같다.
- 첫 프로젝트 후 첫 계획, 요구사항, 설계 단계를 보다 신중히 했음에도 불구하고 개발을 하다보니 처음과 변경된 부분도 생겼다.
- 그렇지만 첫 프로젝트만큼의 변경사항은 발생하지 않아서 다행이다.
