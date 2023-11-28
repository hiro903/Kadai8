package com.example.makeup;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    public List<Makeup> findByName(MakeupSearchRequest request) {
        //findAll　は関数　List<Name> この書き方をしているとListでnameが中に入った状態で使えるJSON
        return makeupMapper.findByNameStartingWith(request.getStartsWith(), request.getEndsWith(), request.getContains());
        //ここでnameMapperのfindAllを呼びだしている。ControllerからMapperを呼びだすにはMapperをフィールドに持たせる必要がある
    }
}
