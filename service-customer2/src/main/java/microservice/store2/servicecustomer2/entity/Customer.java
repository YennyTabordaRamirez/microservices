package microservice.store2.servicecustomer2.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customers")
@Data
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The number id don't be empty. It must have information")
    @Size(min = 8, max = 8, message = "the document size must be 8 characters")
    @Column(name = "number_id", unique = true, length = 8, nullable = false)
    private String numberID;

    @NotEmpty(message = "The name don't be empty. It must have information")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "The last name don't be empty. It must have information")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "The email name don't be empty. It must have information")
    @Email(message = "It isn't a correct email format. correct and try again")
    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "photo_url")
    private String photoUrl;

    @NotNull(message = "The region don't be null. It must have information")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Region region;

    private String state;
}
