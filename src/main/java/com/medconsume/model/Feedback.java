
package com.medconsume.model;

        import jakarta.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String type;        // complaint or request
    private String medicine;    // only for complaint
    private String problem;     // complaint details
    private String message;     // request message

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getMedicine() { return medicine; }

    public void setMedicine(String medicine) { this.medicine = medicine; }

    public String getProblem() { return problem; }

    public void setProblem(String problem) { this.problem = problem; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }
}
