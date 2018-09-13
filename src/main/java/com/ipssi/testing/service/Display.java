package com.ipssi.testing.service;

import com.ipssi.testing.domain.User;
import com.ipssi.testing.ressources.RestUser;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static com.ipssi.testing.Gender.MAN;
import static com.ipssi.testing.Gender.WOMAN;
import static java.util.Arrays.asList;

@Service
public class Display {

    public List<RestUser> getUsers() {

        final LocalDateTime birthday = LocalDateTime.of(2015, Month.JUNE, 29, 9, 28, 45);

        RestUser user1 = new RestUser(new User("Jon", "Doe", birthday, MAN,
                "75012", "Paris", "rue de la paix"));
        RestUser user2 = new RestUser(new User("Marie", "Doe", birthday, WOMAN,
                "75013", "Paris", "rue de la croix"));
        RestUser user3 = new RestUser(new User("Laurent", "Doe", birthday, MAN,
                "75014", "Paris", "rue de la lois"));

        return asList(user1, user2, user3);
    }
}
