package com.cncd.first.Utils;

import com.cncd.first.Models.DiseaseData.DiseaseList;

import java.util.ArrayList;

public interface  ReturnValueFromDialog {
    public void onReturnDiabetesData(String data, ArrayList<DiseaseList> diseaseList);
    public void onReturnThyroidData(String data, ArrayList<DiseaseList> diseaseList);
    public void onReturnValvularData(String data, ArrayList<DiseaseList> diseaseList);
    public void onReturnDyslipidemiaData(String data, ArrayList<DiseaseList> diseaseList);
    public void onReturnHypertensionData(String data, ArrayList<DiseaseList> diseaseList);
    public void onReturnLiverData(String data, ArrayList<DiseaseList> diseaseList);
    public void onReturnMIData(String data, ArrayList<DiseaseList> diseaseList);
    public void onReturnSeizureData(String data, ArrayList<DiseaseList> diseaseList);

}
