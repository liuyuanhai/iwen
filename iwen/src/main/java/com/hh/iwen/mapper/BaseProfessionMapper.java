package com.hh.iwen.mapper;

import com.hh.iwen.bean.BaseProfession;

public interface BaseProfessionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseProfession record);

    int insertSelective(BaseProfession record);

    BaseProfession selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseProfession record);

    int updateByPrimaryKey(BaseProfession record);
}