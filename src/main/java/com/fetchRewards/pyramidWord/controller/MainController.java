package com.fetchRewards.pyramidWord.controller;

import com.fetchRewards.pyramidWord.service.PyramidWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    PyramidWord pyramidWord;

    @GetMapping("/isAPyramidWord")
    public ResponseEntity<Boolean> isAPyramidWord(@RequestParam(value = "word") String word) {
        try{
            boolean result = pyramidWord.isPyramid(word);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}