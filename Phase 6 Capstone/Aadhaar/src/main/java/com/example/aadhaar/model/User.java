package com.example.aadhaar.model;

import com.example.aadhaar.vo.UserRegistrationRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    public static final String DATEFORMAT = "dd/MM/yyyy";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @JsonIgnore
    private String password;
    private LocalDate dob;
    private String address;
    private String email;
    private long mobileNo;
    private String gender;
    private boolean admin;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private AadhaarCard aadhaarCard;

    public static User from(UserRegistrationRequest userRequest){
        return builder()
                .withName(userRequest.getName())
                .withPassword(userRequest.getDob().toString())
                .withDob(userRequest.getDob())
                .withAddress(userRequest.getAddress())
                .withEmail(userRequest.getEmail())
                .withMobileNo(userRequest.getMobileNo())
                .withGender(userRequest.getGender().getValue())
                .withAdmin(false)
                .build();
    }
}
