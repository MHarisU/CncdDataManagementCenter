package com.cncd.first.Models.MedicationModel;

import java.io.Serializable;

public class MedicationList implements Serializable {


    String drug_id, drug_name, generic_name, duration_months;

    public MedicationList(String drug_id, String drug_name, String generic_name, String duration_months) {
        this.drug_id = drug_id;
        this.drug_name = drug_name;
        this.generic_name = generic_name;
        this.duration_months = duration_months;
    }

    public String getDrug_id() {
        return drug_id;
    }

    public void setDrug_id(String drug_id) {
        this.drug_id = drug_id;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public String getGeneric_name() {
        return generic_name;
    }

    public void setGeneric_name(String generic_name) {
        this.generic_name = generic_name;
    }

    public String getDuration_months() {
        return duration_months;
    }

    public void setDuration_months(String duration_months) {
        this.duration_months = duration_months;
    }
}
