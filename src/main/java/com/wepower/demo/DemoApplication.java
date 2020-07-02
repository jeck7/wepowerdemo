package com.wepower.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date = " + currentDate);
        Calendar cal = Calendar.getInstance(Locale.US);
        int month = cal.get(Calendar.MONTH);
        int quarter = (month / 3) + 1;
        System.out.println("Quarter = " + quarter);
    }

}
