package com.project.spring.serviceImpl;

import com.project.spring.Repository.RegisterRepository;
import com.project.spring.VO.MemberVO;
import com.project.spring.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterRepository registerRepository;


    @Override
    public int userRegister(MemberVO memberVO) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        String today = sdf.format(calendar.getTime());

        memberVO.setRegDate(today);

        return registerRepository.userRegister(memberVO);
    }

    @Override
    public int idOverlapCheck(MemberVO memberVO) {
        return registerRepository.idOverlapCheck(memberVO);
    }
}
