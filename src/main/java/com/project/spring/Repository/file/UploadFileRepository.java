package com.project.spring.Repository.file;

import com.project.spring.VO.UploadFileVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UploadFileRepository {
    int fileInsert(UploadFileVO uploadFileVO);
}
