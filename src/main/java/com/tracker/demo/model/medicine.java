package com.tracker.demo.model;

import jakarta.persistence.*;
import lombok.Data;




// @Entity
@Data
public class medicine {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String dosage;
        private String time;
        private String date;
    private String status;
    private String type;



        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDosage() {
            return dosage;
        }

        public String getTime() {
            return time;
        }

        public String getDate() {
            return date;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDosage(String dosage) {
            this.dosage = dosage;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setDate(String date) {
            this.date = date;
        }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
