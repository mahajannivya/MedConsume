
package com.medconsume.model;

        import jakarta.persistence.*;
        import java.time.LocalDateTime;

@Entity
@Table(name = "complaints")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long consumer_id;

    private LocalDateTime created_at;

    private String description;

    private String status;

    private String subject;

    // Constructors
    public Complaint() {}

    public Complaint(Long consumer_id, LocalDateTime created_at, String description, String status, String subject) {
        this.consumer_id = consumer_id;
        this.created_at = created_at;
        this.description = description;
        this.status = status;
        this.subject = subject;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public Long getConsumer_id() { return consumer_id; }
    public void setConsumer_id(Long consumer_id) { this.consumer_id = consumer_id; }
    public LocalDateTime getCreated_at() { return created_at; }
    public void setCreated_at(LocalDateTime created_at) { this.created_at = created_at; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
}
