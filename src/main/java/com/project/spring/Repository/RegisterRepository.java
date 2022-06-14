package com.project.spring.Repository;

import com.project.spring.VO.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RegisterRepository {
    int userRegister(MemberVO memberVO);

    int idOverlapCheck(MemberVO memberVO);
}
