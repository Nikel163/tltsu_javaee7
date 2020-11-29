package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "student_groups")
@NoArgsConstructor
public class StudentGroup implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "group_code")
    private String groupCode;

    @ManyToOne
    @JoinColumn(name = "specialty_id", nullable = false)
    private Specialty specialty;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Student> studentSet;

    public StudentGroup(int id, String groupCode, Specialty specialty) {
        this.id = id;
        this.groupCode = groupCode;
        this.specialty = specialty;
    }
}
