package com.project.spring.VO;

import lombok.Data;

@Data
public class UploadFileVO {
    private String userId; // 유저Id
    private int fileNumber; // 파일번호
    private String uploadFileName; //저장할때 파일 이름
    private String originFileName; //받아올 때 파일 이름
    private String fileUrl; //저장 및 불러올 경로
}
