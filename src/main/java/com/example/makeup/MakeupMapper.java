package com.example.makeup;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MakeupMapper {

 @Select("SELECT * FROM makeup")
 List<Makeup> findAll();

 @Select("SELECT * FROM makeup WHERE name LIKE CONCAT(#{prefix}, '%')AND makeup LIKE CONCAT('%',#{suffix}) AND makeup LIKE CONCAT('%',#{contains}, '%')")
 List<Makeup> findByNameStartingWith(String prefix,String suffix, String contains);
}
//@Param("prefix")
