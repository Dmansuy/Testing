package com.ipssi.testing.domain;

import com.ipssi.testing.Gender;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    private final String firstName = "Jon";
    private final String lastName = "Doe";
    private final LocalDateTime birthday = LocalDateTime.of(2015, Month.JUNE, 29, 9, 28, 45);
    private final Gender sex = Gender.MAN;
    private final String zipCode = "75012";
    private final String city = "Paris";
    private final String address = "rue de la paix";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_return_validate_user() {
        User user = new User(firstName, lastName, birthday, sex, zipCode, city, address);

        System.out.print(birthday);

        assertThat(user.getFirstName()).isEqualTo(firstName);
        assertThat(user.getLastName()).isEqualTo(lastName);
        assertThat(user.getBirthday()).isEqualTo(birthday);
        assertThat(user.isSex()).isEqualTo(sex);
        assertThat(user.getZipCode()).isEqualTo(zipCode);
        assertThat(user.getCity()).isEqualTo(city);
        assertThat(user.getAddress()).isEqualTo(address);
    }

    @Test
    public void should_thrown_exception_when_first_name_is_blank() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("first name cannot be blank");

        new User(null, lastName, birthday, sex, zipCode, city, address);
    }

    @Test
    public void should_thrown_exception_when_last_name_is_blank() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("last name cannot be blank");

        new User(firstName, null, birthday, sex, zipCode, city, address);
    }

    @Test
    public void should_thrown_exception_when_birthday_is_null() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("birthday cannot be null");

        new User(firstName, lastName, null, sex, zipCode, city, address);
    }

    @Test
    public void should_thrown_exception_when_birthday_is_after_current_date() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("birthday cannot be after the current day");

        LocalDateTime now = LocalDateTime.now();
        new User(firstName, lastName, now.plusDays(1), sex, zipCode, city, address);
    }

    @Test
    public void should_thrown_exception_when_zip_code_is_null() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("zip code cannot be null");

        new User(firstName, lastName, birthday, sex, null, city, address);
    }

    @Test
    public void should_thrown_exception_when_zip_code_is_to_short() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("the postal code must be composed of 5 characters");

        String toShortZipCode = "012";
        new User(firstName, lastName, birthday, sex, toShortZipCode, city, address);
    }

    @Test
    public void should_thrown_exception_when_zip_code_is_to_long() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("the postal code must be composed of 5 characters");

        String toLongZipCode = "012345";
        new User(firstName, lastName, birthday, sex, toLongZipCode, city, address);
    }

    @Test
    public void should_thrown_exception_when_city_is_null() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("city cannot be null");

        new User(firstName, lastName, birthday, sex, zipCode, null, address);
    }

    @Test
    public void should_thrown_exception_when_address_is_null() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("address cannot be null");

        new User(firstName, lastName, birthday, sex, zipCode, city, null);
    }
}