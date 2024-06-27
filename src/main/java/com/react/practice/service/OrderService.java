package com.react.practice.service;

import com.react.practice.entity.BuyerEntity;
import com.react.practice.repository.BoardRepository;
import com.react.practice.repository.BuyerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //생성자 생성
public class OrderService {


    //생성자 의존성 주입
    private final BuyerRepository buyerRepository;
    private final BoardRepository boardRepository;

    //결제 정보 저장
    public void save_buyerInfo(BuyerEntity request) {
        buyerRepository.save(request);

    }

}