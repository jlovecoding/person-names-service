package com.example.hellokubernetes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;

import static java.lang.String.format;
import static java.net.InetAddress.getLocalHost;
import static org.apache.commons.lang.RandomStringUtils.random;

@RestController
public class PersonNamesController {

    @GetMapping("/personNames")
    public String getPersonName() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        return format("from-%s-%s", getLocalIp(), random(length, useLetters, useNumbers));
    }

    private String getLocalIp() {
        String localIp = "unknown";
        try {
            localIp = getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return localIp;
    }
}
