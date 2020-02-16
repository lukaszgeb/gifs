package com.akademiakodu.gifs.controller;

import com.akademiakodu.gifs.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

//    @Autowired
//    GifRepository gifRepository;

    final GifRepository gifRepository;

    public MainController(GifRepository gifRepository) {
        this.gifRepository = gifRepository;
    }

    @GetMapping("/")
    @ResponseBody
    public String hello(){
        return "dziala";
    }

    @GetMapping("/showgifsinbrowser")
    @ResponseBody
    public String showGifNames(){
        return gifRepository.getGifNames();
    }


}
