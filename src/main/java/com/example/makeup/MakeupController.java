package com.example.makeup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MakeupController {
    private final MakeupMapper makeupMapper;
    //NameMapperクラスのメンバ変数にあらかじめ　nameMapper　を付けておいて

    public MakeupController(MakeupMapper makeupMapper) {
        this.makeupMapper = makeupMapper;
    }

    //↑ここまでが　NameMapper　クラスのコンストラクター

    @GetMapping("/cosme")

    public List<com.example.makeup.Makeup> findAll() {
        //findAll　は関数　List<Name> この書き方をしているとListでnameが中に入った状態で使えるJISON
        return makeupMapper.findAll();
        //ここでnameMapperのfindAllを呼びだしている。ControllerからMapperを呼びだすにはMapperをフィールドに持たせる必要がある
    }
}
