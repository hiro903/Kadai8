package com.example.makeup;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MakeupMapper {

    @Select("SELECT * FROM makeup")
    List<Makeup> findAll();

    @Select("SELECT * FROM makeup WHERE name LIKE CONCAT(#{prefix}, '%')AND name LIKE CONCAT('%',#{suffix}) AND name LIKE CONCAT('%',#{contains}, '%')")
    List<Makeup> findByNameStartingWith(String prefix, String suffix, String contains);
}
//WHERE句に入るのは、自分が探したい文字列が入っているカラム名を書くこと.fromの後ろはテーブル名
//@Param("prefix")
