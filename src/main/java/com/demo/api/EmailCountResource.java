package com.demo.api;

import com.demo.service.EmailCountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@ExposesResourceFor(EmailCountResource.class)
@Slf4j
public class EmailCountResource {
    private static final String PATH = "/api/v1/gmails";

    @Autowired
    EmailCountService emailCountService;

    @RequestMapping(value = PATH + "/uniqueCount", method = RequestMethod.POST)
    public EmailCountResponse emailCounts(@RequestBody EmailCountRequest emailCountRequest) {
        Map<String, Integer> mapEmailToCount = emailCountService.emailCount(emailCountRequest.getEmails());
        return new EmailCountResponse(mapEmailToCount);
    }
}
