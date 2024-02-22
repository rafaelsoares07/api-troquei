package com.Troquei.troquei.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clothes")
public class ClothesController {
    @GetMapping
    private String get(){
        return "OK";
    }
}
