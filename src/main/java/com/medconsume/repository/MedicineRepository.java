package com.medconsume.repository;

import com.medconsume.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    List<Medicine> findByMedicineNameContainingIgnoreCase(String medicineName);
    boolean existsByMedicineNameIgnoreCase(String medicineName);
}



