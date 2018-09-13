package com.ipssi.testing.domain;

import com.ipssi.testing.Gender;
import org.apache.commons.lang3.Validate;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;

import static java.util.Objects.requireNonNull;

public class User {

    private String firstName;
    private String lastName;
    private LocalDateTime birthday;
    private Gender sex;
    private String zipCode;
    private String city;
    private String address;

    public User(@Nonnull String firstName, @Nonnull String lastName, @Nonnull LocalDateTime birthday,
                @Nonnull Gender sex, @Nonnull String zipCode, @Nonnull String city, @Nonnull String address) {
        validateBirthday(birthday);
        validateZipCode(zipCode);

        this.firstName = requireNonNull(firstName, "first name cannot be blank");
        this.lastName = requireNonNull(lastName, "last name cannot be blank");
        this.birthday = birthday;
        this.sex = requireNonNull(sex, "gender cannot be null");
        this.zipCode = zipCode;
        this.city = requireNonNull(city, "city cannot be null");
        this.address = requireNonNull(address, "address cannot be null");
    }

    @Nonnull
    private void validateBirthday(@Nonnull LocalDateTime birthday) {
        LocalDateTime now = LocalDateTime.now();

        requireNonNull(birthday, "birthday cannot be null");
        Validate.isTrue(birthday.isBefore(now), "birthday cannot be after the current day");
    }

    @Nonnull
    private void validateZipCode(@Nonnull String zipCode) {
        requireNonNull(zipCode, "zip code cannot be null");

        Validate.isTrue(zipCode.length() == 5, "the postal code must be composed of 5 characters");
    }

    @Nonnull
    public String getFirstName() {
        return firstName;
    }

    @Nonnull
    public String getLastName() {
        return lastName;
    }

    @Nonnull
    public LocalDateTime getBirthday() {
        return birthday;
    }

    @Nonnull
    public Gender isSex() {
        return sex;
    }

    @Nonnull
    public String getZipCode() {
        return zipCode;
    }

    @Nonnull
    public String getCity() {
        return city;
    }

    @Nonnull
    public String getAddress() {
        return address;
    }
}
