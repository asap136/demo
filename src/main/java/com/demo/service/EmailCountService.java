package com.demo.service;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Service
public class EmailCountService {

    final private static String GMAIL_SUFFIX = "@gmail.com";

    final private EmailValidator emailValidator = EmailValidator.getInstance();

    /**
     *
     * @param listEmails : List of emails.
     * @return : Map of NORMALIZED email to count. NORMALIZED email is an email where the prefix string ( i.e the part before @ ) has any '.' character removed.
     * It also excludes any part after the '+' character. IMPORTANT NOTE : Any email that is NOT valid AND does NOT end in "gmail.com" is excluded from the result.
     */
    public Map<String, Integer> emailCount(List<String> listEmails) {
        Map<String, Integer> map = listEmails.stream().map(s -> {
            int index;
            if( emailValidator.isValid(s) && ((index = s.indexOf("@gmail.com")) != -1 )) {
                String prefix = s.substring(0, index);
                if(!prefix.isEmpty()) {
                    String[] subTokens = prefix.split("\\+");
                    if (subTokens != null && subTokens.length >= 1) {
                        prefix = subTokens[0];
                    }
                    prefix = prefix.replace(".", "");
                    return prefix;
                }
            }
            return null;
        }).filter( s -> s != null && !s.isEmpty()).collect(toMap(s -> s + GMAIL_SUFFIX, v -> 1, (a1, a2) -> a1));

        return map;
    }
}
