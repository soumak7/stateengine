package com.search.controller;

import com.search.model.request.StateRequest;
import com.search.response.Meta;
import com.search.response.MetaDataResponse;
import com.search.service.ProcessStateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/state")
public class ResponseController {

    @Autowired
    ProcessStateServiceImpl processStateService;

    @PostMapping("/request")
    public ResponseEntity<?> storeResponse(@RequestBody StateRequest state){

        if(processStateService.storeSearchHistory(state))
            return new ResponseEntity<>(new MetaDataResponse<>(new Meta("Success", String.valueOf(System.currentTimeMillis()),"0"),null), HttpStatus.OK);
        else
            return new ResponseEntity<>(new MetaDataResponse<>(new Meta("Error", String.valueOf(System.currentTimeMillis()),"1"),null), HttpStatus.OK);
    }

    @GetMapping("/response")
    public ResponseEntity<?> returnSearch(){
        return new ResponseEntity<>(new MetaDataResponse<>(new Meta("Success", String.valueOf(System.currentTimeMillis()),"0"),processStateService.returnSearchHistory()), HttpStatus.OK);
    }

}
