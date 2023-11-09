package API.dataProviders;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MockDataGenerator {
    protected static final Locale locale = new Locale("EN");
    protected static Faker faker = new Faker(locale);
    protected String mockFirstname = generateMockFirstname();
    protected String mockLastname = generateLastname();
    protected String mockEmail = generateEmail();
    protected String mockLogin = generateMockLogin();

    protected String generateMockFirstname() {
        return faker.name().firstName();
    }

    protected String generateMockID() {
        return String.valueOf(faker.number().numberBetween(2, 100));
    }

    protected String generatePassword() {
        return faker.internet().password(5, 10, true, true,true);
    }

    protected String generateLastname() {
        return faker.name().lastName();
    }

    protected String generateEmail() {
        return faker.internet().emailAddress();
    }

    protected String generateMockLogin() {
        return faker.name().username();
    }

    protected String generateMockRestrictEmail() {
        return String.valueOf(0);
    }

    protected String generateMockUserType() {
        List<String> userType = new ArrayList<>();
        userType.add("Learner-Type");
        userType.add("Admin-Type");
        userType.add("Trainer-Type");
        return userType.get(faker.number().numberBetween(0, userType.size()));
    }

//    protected String generateMockLanguage() {
//        List<String> languages = new AddUser().getAllLanguages();
//        System.out.println(languages.get(faker.number().numberBetween(0, languages.size())));
//        return languages.get(faker.number().numberBetween(0, languages.size()));
//    }
//
//    protected String generateMockTimeZone() {
//        List<String> timeZones = new AddUser().getAllTimeZone();
//        return timeZones.get(faker.number().numberBetween(0, timeZones.size()));
//    }

    protected String generateMockStatus() {
        return "active";
    }

    protected String generateMockDeactivationDate() {
        return "";
    }

    protected String generateMockLevel() {
        return "1";
    }

    protected String generateMockPoints() {
        return "0";
    }

    protected String generateMockDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy, hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
