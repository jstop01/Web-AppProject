package com.project.spring.VO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class BoardVO {
    private int bno;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private int viewCnt;
    private String filePath;
}
