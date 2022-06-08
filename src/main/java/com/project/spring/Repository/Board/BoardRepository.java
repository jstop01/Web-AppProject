package com.project.spring.Repository.Board;

import com.project.spring.VO.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardRepository {
    int insertBoard(BoardVO boardVO);
}
