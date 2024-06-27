package com.react.practice.controller;

import com.react.practice.dto.BoardDTO;
import com.react.practice.dto.PaymentDTO;
import com.react.practice.entity.BoardEntity;
import com.react.practice.entity.BuyerEntity;
import com.react.practice.service.OrderService;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequiredArgsConstructor//생성자 생성
@Getter
public class PaymentController {


    //생성자 의조성 주입
    private final OrderService orderService;
    private final IamportClient iamportClient;



    //apiket, apiSecret으로 객체생성
    //orderService와 smsController 메소드 호출을 위해 주입
    @Autowired
    public PaymentController(OrderService orderService){
        this.orderService = orderService;
        this.iamportClient = new IamportClient("2432830381011165", "w2oi7Kp2XK7sqBjTVC67LfgmQbgUEVaruq197psIstZ6wDqcnQtacg0YL0wM6bT86PAPU5hjZvK8jXTQ");
    }

    //결제 팝업창
    @GetMapping("payment/paymentPopup")
    public String paymentPopup(){

        return "payment/paymentPopup";
    }

    //결제 사후검증
    @PostMapping("payment/verify")
    @ResponseBody
    private IamportResponse<Payment> paymentByImpUid(@RequestBody PaymentDTO paymentDTO)
            throws IamportResponseException, IOException{
        System.out.println("payment verify");
        return iamportClient.paymentByImpUid(paymentDTO.getImp_uid());
    }

    //DB저장
    @PostMapping("payment/buyerInfo_save")
    @ResponseBody
    public void save_buyerInfo(@RequestBody BuyerEntity request){
        System.out.println("buyerInfo Controller");
        orderService.save_buyerInfo(request);
    }


}
