package com.tracker.demo.service;

import com.tracker.demo.model.medicine;
import com.tracker.demo.repository.medrep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ReminderService {

    @Autowired
    private medrep repo;

    @Scheduled(fixedRate = 60000)
    @Scheduled(fixedRate = 60000)
    public void checkReminders() {

        System.out.println("Checking reminders...");

        List<medicine> meds = repo.findAll();

        String currentTime = LocalTime.now()
                .withSecond(0)
                .withNano(0)
                .toString();

        System.out.println("Current time: " + currentTime);

        for (medicine m : meds) {

            System.out.println("DB time: " + m.getTime());

            String today = LocalDate.now().toString();

            if (m.getTime() != null) {

                if (m.getType().equals("DAILY") && m.getTime().equals(currentTime)) {
                    System.out.println("🔔 DAILY MEDICINE: " + m.getName());
                }

                if (m.getType().equals("ONCE") &&
                        m.getTime().equals(currentTime) &&
                        m.getDate().equals(today)) {

                    System.out.println("🔔 ONE-TIME MEDICINE: " + m.getName());
                }
            }
            }
        }
    }
