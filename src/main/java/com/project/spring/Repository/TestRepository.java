package com.project.spring.Repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface TestRepository {
    List<Map<String, Object>> getBoard();
}
