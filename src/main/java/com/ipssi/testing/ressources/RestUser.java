package com.ipssi.testing.ressources;

import com.ipssi.testing.Gender;
import com.ipssi.testing.domain.User;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;

public class RestUser {

    private final String firstName;
    private final String lastName;
    private final String birthday;
    private final String sex;
    private final String zipCode;
    private final String city;
    private final String address;

    public RestUser(@Nonnull User user) {
        firstName = user.getFirstName();
        lastName = user.getLastName();
        birthday = String.valueOf(user.getBirthday());
        sex = String.valueOf(user.isSex());
        zipCode = user.getZipCode();
        city = user.getCity();
        address = user.getAddress();
    }

    @Nonnull
    public User toDomainUsers() {
        return new User(firstName, lastName, LocalDateTime.parse(birthday), Gender.valueOf(sex), zipCode, city, address);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getSex() {
        return sex;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}
