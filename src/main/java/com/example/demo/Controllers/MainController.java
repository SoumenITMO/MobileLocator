package com.example.demo.Controllers;

import com.example.demo.Services.MobileStationSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    MobileStationSearchService mobileStationSearchService;

    @RequestMapping(value = "location/{uuid}", method = RequestMethod.GET)
    public ResponseEntity<?> getData(@PathVariable("uuid")Integer uuid) {

        return mobileStationSearchService.searchLocation(uuid);
    }
}