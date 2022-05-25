package com.project.spring.serviceImpl;

import com.project.spring.Repository.RegisterRepository;
import com.project.spring.VO.MemberVO;
import com.project.spring.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterRepository registerRepository;


    @Override
    public int userRegister(MemberVO memberVO) {
        int result = registerRepository.userRegister(memberVO);

        return result;
    }
}
