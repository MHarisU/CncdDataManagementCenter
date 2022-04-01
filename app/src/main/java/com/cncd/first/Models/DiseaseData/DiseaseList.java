package com.cncd.first.Models.DiseaseData;

import java.io.Serializable;

public class DiseaseList implements Serializable {

    String data_name, data_value;

    public DiseaseList(String data_name, String data_value) {
        this.data_name = data_name;
        this.data_value = data_value;
    }

    public String getData_name() {
        return data_name;
    }

    public void setData_name(String data_name) {
        this.data_name = data_name;
    }

    public String getData_value() {
        return data_value;
    }

    public void setData_value(String data_value) {
        this.data_value = data_value;
    }
}
