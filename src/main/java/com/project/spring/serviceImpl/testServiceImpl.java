package com.project.spring.serviceImpl;

import com.project.spring.Repository.TestRepository;
import com.project.spring.service.TestService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class testServiceImpl implements TestService {

    @Autowired
    TestRepository testRepository;

    @Override
    public List<Map<String, Object>> getBoard() {
        return testRepository.getBoard();
    }
}
