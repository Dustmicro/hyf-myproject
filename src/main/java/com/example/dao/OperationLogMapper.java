package com.example.dao;

import com.example.bean.OperationLog;
import com.github.pagehelper.Page;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperationLogMapper {
    int deleteByPrimaryKey(Long operationId);

    int insert(OperationLog record);

    int insertSelective(OperationLog record);

    OperationLog selectByPrimaryKey(Long operationId);

    int updateByPrimaryKeySelective(OperationLog record);

    int updateByPrimaryKey(OperationLog record);

    OperationLog find(OperationLog record);

    List<OperationLog> list(OperationLog record);

    Page<OperationLog> pageList(OperationLog record);
}