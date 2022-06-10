package com.project.spring.serviceImpl.board;

import com.project.spring.Repository.Board.BoardRepository;
import com.project.spring.Repository.RegisterRepository;
import com.project.spring.VO.BoardVO;
import com.project.spring.VO.MemberVO;
import com.project.spring.service.RegisterService;
import com.project.spring.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Override
    public int insertBoard(BoardVO boardVO) {
        return boardRepository.insertBoard(boardVO);
    }

}
