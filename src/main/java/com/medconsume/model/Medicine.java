package com.medconsume.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String medicineName;
    private String category;
    private String storageForm;
    private String strength;
    private String manufacturer;
    private String indication;
    private String classification;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Constructors
    public Medicine() {}

    public String getMedicineName() {
        return medicineName;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStorageForm() {
        return storageForm;
    }

    public void setStorageForm(String storageForm) {
        this.storageForm = storageForm;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Medicine(String medicineName, String category, String storageForm, String strength, String manufacturer, String indication, String classification) {
        this.id = id;
        this.medicineName = medicineName;
        this.category = category;
        this.storageForm = storageForm;
        this.strength = strength;
        this.manufacturer = manufacturer;
        this.indication = indication;
        this.classification = classification;
        this.status = status;
    }



}
