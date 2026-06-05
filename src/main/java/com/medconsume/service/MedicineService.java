package com.medconsume.service;

import com.medconsume.model.Medicine;
import com.medconsume.repository.MedicineRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class MedicineService {

    private final MedicineRepository medRepo;

    public MedicineService(MedicineRepository medRepo) {
        this.medRepo = medRepo;
    }

    @PostConstruct
    public void loadData() {
        try {
            if (medRepo.count() > 0) {
                System.out.println(" Medicines already loaded in database. Skipping CSV import.");
                return;
            }

            InputStream inputStream = getClass().getResourceAsStream("/medicines.csv");
            if (inputStream == null) {
                System.out.println("CSV file not found in resources folder!");
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String line;
            boolean firstLine = true;
            int addedCount = 0;


            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip header line
                    continue;
                }

                String[] data = line.split(",");
                if (data.length >= 7) {
                    String medicineName = data[0].trim();

                    // Avoid duplicates
                    if (medRepo.existsByMedicineNameIgnoreCase(medicineName)) {
                        continue;
                    }

                    Medicine m = new Medicine();
                    m.setMedicineName(medicineName);
                    m.setCategory(data[1].trim());
                    m.setStorageForm(data[2].trim());
                    m.setStrength(data[3].trim());
                    m.setManufacturer(data[4].trim());
                    m.setIndication(data[5].trim());
                    m.setClassification(data[6].trim());
                    medRepo.save(m);
                    addedCount++;
                }
            }

            System.out.println("CSV data loaded successfully! " + addedCount + " medicines added.");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" Error loading medicines from CSV!");
        }
    }
    public List<Medicine> getFirst15Medicines() {
        return medRepo.findAll().stream().limit(15).toList();
    }


    public List<Medicine> searchMedicine(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return medRepo.findAll();
        }
        return medRepo.findByMedicineNameContainingIgnoreCase(keyword);
    }
    public List<Medicine> getAll() {
        return medRepo.findAll();
    }

    public Medicine getById(Long id) {
        return medRepo.findById(id).orElse(null);
    }

    public void save(Medicine m) {
        medRepo.save(m);
    }

    public void delete(Long id) {
        medRepo.deleteById(id);
    }

}
