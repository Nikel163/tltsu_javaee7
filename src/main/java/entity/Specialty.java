package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "specialties")
@NoArgsConstructor
public class Specialty implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "specialty", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<StudentGroup> groupSet;

    @NotNull
    @Column(name = "spec_code")
    private String specCode;

    @NotNull
    @Column(name = "spec_name")
    private String specName;

    @NotNull
    @Column(name = "spec_name_short")
    private String specNameShort;

    public Specialty(int id, String specCode, String specName, String specNameShort) {
        this.id = id;
        this.specCode = specCode;
        this.specName = specName;
        this.specNameShort = specNameShort;
    }
}
