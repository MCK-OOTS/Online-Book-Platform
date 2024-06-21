package com.react.practice.service;

import com.react.practice.entity.BuyerEntity;
import com.react.practice.repository.BoardRepository;
import com.react.practice.repository.BuyerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final BuyerRepository buyerRepository;

    private final BoardRepository boardRepository;

    public void save_buyerInfo(BuyerEntity request) {
        buyerRepository.save(request);

    }

    public void update_state() {

    }
}