package com.myccb.mapper;

import com.myccb.bean.db.DictionaryDb;
import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;

import java.util.List;

@Mapper
public interface DictionaryDbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictionaryDb record);

    int insertSelective(DictionaryDb record);

    DictionaryDb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictionaryDb record);

    int updateByPrimaryKey(DictionaryDb record);

    DictionaryDb find(DictionaryDb record);

    List<DictionaryDb> list(DictionaryDb record);

    Page<DictionaryDb> pageList(DictionaryDb record);
}