package inheritance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Setter
@Getter
@NoArgsConstructor

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//        @DiscriminatorColumn(name = "person_type")


//@MappedSuperclass - when uses then remove @Entity


abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;

}