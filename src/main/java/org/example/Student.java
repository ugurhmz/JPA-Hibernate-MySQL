package org.example;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
@Data // Lombok tarafından getter, setter, equals, hashCode ve toString metodlarını otomatik olarak ekler
@NoArgsConstructor // Parametresiz constructor
@AllArgsConstructor // Parametreli constructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="std_Id")
    private int studentId;

    @NonNull
    @Column(name = "std_firstname", length = 50)
    private String firstName;

    @NonNull
    @Column(name = "std_lastname",  length = 250)
    private String lastName;

    @NonNull
    @Column(name = "std_number", unique = true, length = 5)
    private String studentNumber;

    @Lob
    @Column(name = "std_about")
    private String studentProfile;

    @Temporal(TemporalType.DATE)
    @NonNull
    @Column(name="std_birthofdate")
    private Date studentBirthOfDate;

    @Transient // Db'de sütun oluşmasın.
    private String studentDepartment;

}
