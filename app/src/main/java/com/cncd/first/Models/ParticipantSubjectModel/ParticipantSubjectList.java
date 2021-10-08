package com.cncd.first.Models.ParticipantSubjectModel;

import java.io.Serializable;

public class ParticipantSubjectList implements Serializable {

    String subject_id, subject_name, subject_father_husband, subject_age, subject_gender, subject_relationship_with_participant, subject_relationship_with_spouse;

    public ParticipantSubjectList(String subject_id, String subject_name, String subject_father_husband, String subject_age,
                                  String subject_gender, String subject_relationship_with_participant, String subject_relationship_with_spouse) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.subject_father_husband = subject_father_husband;
        this.subject_age = subject_age;
        this.subject_gender = subject_gender;
        this.subject_relationship_with_participant = subject_relationship_with_participant;
        this.subject_relationship_with_spouse = subject_relationship_with_spouse;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public String getSubject_father_husband() {
        return subject_father_husband;
    }

    public String getSubject_age() {
        return subject_age;
    }

    public String getSubject_gender() {
        return subject_gender;
    }

    public String getSubject_relationship_with_participant() {
        return subject_relationship_with_participant;
    }

    public String getSubject_relationship_with_spouse() {
        return subject_relationship_with_spouse;
    }
}
