package com.cncd.first.Models.FamilyModel;

import java.io.Serializable;

public class FamilyList implements Serializable {

    String family_id, medical_condition_name, specify_condition_name, relation_name, age_diagnosed;

    public FamilyList(String family_id, String medical_condition_name, String specify_condition_name, String relation_name, String age_diagnosed) {
        this.family_id = family_id;
        this.medical_condition_name = medical_condition_name;
        this.specify_condition_name = specify_condition_name;
        this.relation_name = relation_name;
        this.age_diagnosed = age_diagnosed;
    }

    public String getFamily_id() {
        return family_id;
    }

    public String getMedical_condition_name() {
        return medical_condition_name;
    }

    public String getSpecify_condition_name() {
        return specify_condition_name;
    }

    public String getRelation_name() {
        return relation_name;
    }

    public String getAge_diagnosed() {
        return age_diagnosed;
    }
}
