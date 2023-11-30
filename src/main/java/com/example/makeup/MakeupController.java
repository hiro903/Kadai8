package com.example.makeup;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController

public class MakeupController {
    private MakeupMapper makeupMapper;

    //NameMapperクラスのメンバ変数にあらかじめ　nameMapper　を付けておいて
    public MakeupController(MakeupMapper makeupMapper) {
        this.makeupMapper = makeupMapper;
    }

    //↑ここまでが　NameMapper　クラスのコンストラクター
    @GetMapping("/cosme")

    public List<Makeup> findByName(@NotNull MakeupSearchRequest request) {
        //findAll　は関数　List<Name> この書き方をしているとListでnameが中に入った状態で使えるJSON
        return makeupMapper.findByNameStartingWith(request.getPrefix(), request.getSuffix(), request.getContains());
        //ここでnameMapperのfindAllを呼びだしている。ControllerからMapperを呼びだすにはMapperをフィールドに持たせる必要がある
    }

}
