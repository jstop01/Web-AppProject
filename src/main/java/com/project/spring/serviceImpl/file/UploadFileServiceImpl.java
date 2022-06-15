package com.project.spring.serviceImpl.file;

import com.project.spring.Repository.file.UploadFileRepository;
import com.project.spring.VO.UploadFileVO;
import com.project.spring.service.file.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadFileServiceImpl implements UploadFileService {

    @Autowired
    UploadFileRepository uploadFileRepository;


    @Override
    public int fileInsert(UploadFileVO uploadFileVO) {
        uploadFileRepository.fileInsert(uploadFileVO);
        return 0;
    }
}
