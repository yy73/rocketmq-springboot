package com.yq.rocketmq.produce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduceController {

    @Autowired
    private CommandLineRunner commandLineRunner;

    @GetMapping("/demo")
    public void demo() throws Exception {
        commandLineRunner.run("123");
    }
}
