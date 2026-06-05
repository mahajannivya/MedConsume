
package com.medconsume.repository;

        import com.medconsume.model.Complaint;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends CrudRepository<Complaint, Long> {
}
