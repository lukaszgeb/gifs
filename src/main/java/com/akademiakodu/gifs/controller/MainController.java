package com.akademiakodu.gifs.controller;

import com.akademiakodu.gifs.model.Gif;
import com.akademiakodu.gifs.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

//    @Autowired
//    GifRepository gifRepository;

    final GifRepository gifRepository;

    public MainController(GifRepository gifRepository) {
        this.gifRepository = gifRepository;
    }

    @GetMapping("/")
    public String hello(ModelMap modelMap){
        // 1. Wyciagniecie gifow
        List<Gif> gifList = gifRepository.getGifs();
        // 2. Przekazanie do view
        modelMap.put("gifs", gifList);
        // 3. Zwrocenie widoku
        return "home";
    }

    @GetMapping("/showgifsinbrowser")
    @ResponseBody
    public String showGifNames(){
        return gifRepository.getGifNames();
    }

    @GetMapping("/favorites")
    public String favoritesGifs(ModelMap modelMap){
        // 1. Wyciagniecie wartosci
        List<Gif> favoritesGifs = gifRepository.getFavoritesGifs();
        // 2. Przekazanie do view
        modelMap.put("gifs", favoritesGifs);
        // 3. Zwrocenie widoku
        return "favorites";
    }



}
