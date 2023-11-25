package com.example.makeup;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MakeupMapper {
 @Select("SELECT * FROM makeup")
 List<Makeup> findAll();
}
