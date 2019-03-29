package com.example.hellokubernetes.service;

import com.example.hellokubernetes.model.PersonName;
import com.example.hellokubernetes.repository.PersonNamesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.net.InetAddress.getLocalHost;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang.RandomStringUtils.random;

@Service
@Slf4j
public class PersonNamesService {

    @Autowired
    private PersonNamesRepository personNamesRepository;

    private static final int PERSON_NAME_LENGTH = 10;
    private static final boolean USE_LETTERS = true;
    private static final boolean USE_NUMBERS = false;

    public List<PersonName> getRandomPersonNames() {
        return Stream.of(1L, 2L)
                .map(PersonNamesService::createPersonName)
                .collect(toList());
    }

    public List<PersonName> getPersonNames() {
        return personNamesRepository.findAll();
    }

    private static PersonName createPersonName(final Long id) {
        return PersonName.builder()
                .id(id)
                .personName(format("from-%s-%s", getLocalIp(), random(PERSON_NAME_LENGTH, USE_LETTERS, USE_NUMBERS)))
                .build();
    }

    private static String getLocalIp() {
        String localIp = "unknown";
        try {
            localIp = getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.error("Error getting local IP", e);
        }

        return localIp;
    }

    public PersonName createPersonName(final PersonName personName) {
        return personNamesRepository.save(personName);
    }
}
