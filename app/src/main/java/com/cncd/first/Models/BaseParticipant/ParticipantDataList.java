package com.cncd.first.Models.BaseParticipant;

import java.io.Serializable;

public class ParticipantDataList implements Serializable {

    String study_id, name, father_husband_name, address, gender, age, cnic_no, phone_no, whatsapp_no, last_meal_date, last_meal_time, blood_sampling_date, blood_sampling_time;


    public ParticipantDataList(String study_id, String name, String father_husband_name, String address, String gender, String age,
                               String cnic_no, String phone_no, String whatsapp_no, String last_meal_date, String last_meal_time, String blood_sampling_date, String blood_sampling_time) {


        this.study_id = study_id;
        this.name = name;
        this.father_husband_name = father_husband_name;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.cnic_no = cnic_no;
        this.phone_no = phone_no;
        this.whatsapp_no = whatsapp_no;
        this.last_meal_date = last_meal_date;
        this.last_meal_time = last_meal_time;
        this.blood_sampling_date = blood_sampling_date;
        this.blood_sampling_time = blood_sampling_time;
    }


    public String getStudy_id() {
        return study_id;
    }

    public void setStudy_id(String study_id) {
        this.study_id = study_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather_husband_name() {
        return father_husband_name;
    }

    public void setFather_husband_name(String father_husband_name) {
        this.father_husband_name = father_husband_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCnic_no() {
        return cnic_no;
    }

    public void setCnic_no(String cnic_no) {
        this.cnic_no = cnic_no;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getWhatsapp_no() {
        return whatsapp_no;
    }

    public void setWhatsapp_no(String whatsapp_no) {
        this.whatsapp_no = whatsapp_no;
    }

    public String getLast_meal_date() {
        return last_meal_date;
    }

    public void setLast_meal_date(String last_meal_date) {
        this.last_meal_date = last_meal_date;
    }

    public String getLast_meal_time() {
        return last_meal_time;
    }

    public void setLast_meal_time(String last_meal_time) {
        this.last_meal_time = last_meal_time;
    }

    public String getBlood_sampling_date() {
        return blood_sampling_date;
    }

    public void setBlood_sampling_date(String blood_sampling_date) {
        this.blood_sampling_date = blood_sampling_date;
    }

    public String getBlood_sampling_time() {
        return blood_sampling_time;
    }

    public void setBlood_sampling_time(String blood_sampling_time) {
        this.blood_sampling_time = blood_sampling_time;
    }
}
