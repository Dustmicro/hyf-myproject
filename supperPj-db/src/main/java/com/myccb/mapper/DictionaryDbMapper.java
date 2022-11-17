package com.myccb.mapper;

import com.github.pagehelper.Page;
import com.myccb.bean.db.DictionaryDb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DictionaryDbMapper {
    int deleteByPrimaryKey(Integer dicId);

    int insert(DictionaryDb record);

    int insertSelective(DictionaryDb record);

    DictionaryDb selectByPrimaryKey(Integer dicId);

    int updateByPrimaryKeySelective(DictionaryDb record);

    int updateByPrimaryKey(DictionaryDb record);

    DictionaryDb find(DictionaryDb record);

    List<DictionaryDb> list(DictionaryDb record);

    Page<DictionaryDb> pageList(DictionaryDb record);
}