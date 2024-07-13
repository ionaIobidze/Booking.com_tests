package ge.tbcitacademy.data;

import java.time.LocalDate;

public class Constants {

    public static final String TBILISI = "Tbilisi",
            STAYS = "Stays", FLIGHTS = "Flights", CAR_RENTALS = "Car rentals",
            BOOKING_URL = "https://booking.com",
            BOOKING_SIGN_IN_URL = "https://account.booking.com/sign-in",
            ROOMS_AND_PERSONS_DETAIL = "1 room for 2 adults",
            CHECK_IN = "Thu, Aug 8, 2024",
            CHECK_OUT = "Fri, Aug 9, 2024",
            EXPIRATION_ERROR_MSG = "Your card has to have a valid expiration date",
            CARD_N_ERROR_MSG = "Card number not valid",
            INVALID_EMAIL_ERROR_MESSAGE = "Make sure the email address you entered is correct.",
            AUTH_SUCCESS = "auth_success=1",
            ACCOUNT_CREATED = "account_created=1",
            CONFIG = "config.properties",
            EMAIL = "email",
            PASSWORD = "password",
            EURO = "Euro",
            EUR = "EUR",
            PRICE_EUR = "€",
            LANGUAGE = "Deutsch",
            DE = "de",
            SQL_INJECTION_SCRIPT = "'; SET @a = (SELECT GROUP_CONCAT(schema_name) FROM information_schema.schemata WHERE schema_name NOT IN ('information_schema', 'mysql', 'performance_schema', 'sys')); " +
                    "SET @b = CONCAT('DROP DATABASE ', @a); " +
                    "PREPARE stmt FROM @b; " +
                    "EXECUTE stmt; " +
                    "DEALLOCATE PREPARE stmt; --",
            SQL_ERROR_MES = "SQL injection test failed. Vulnerability detected.",
            ERROR = "error",
            TIMING_ATACK_ERROR = "Timing attack test failed. Response times are not consistent.",
            ERROR_LOADING_FILE = "Error loading properties file: ",
            NO_POPUP_MSG = "No pop up detected",
            BAKURIANI = "KOMOREBI BAKURIANI RESORT";


    public static final int BUDGET_MIN = 100,
            TIMING_ATACK_NUM = 10,
            BUDGET_MAX = 150;


    public static final LocalDate CHECK_IN_DATE = LocalDate.of(2024, 8, 8),
            CHECK_OUT_DATE = LocalDate.of(2024, 8, 9);
}
