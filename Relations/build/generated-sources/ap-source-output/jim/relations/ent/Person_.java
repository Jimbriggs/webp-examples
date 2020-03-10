package jim.relations.ent;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jim.relations.ent.Address;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-10T14:39:13")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> name;
    public static volatile SingularAttribute<Person, Long> id;
    public static volatile ListAttribute<Person, Address> placesPassed;
    public static volatile SingularAttribute<Person, Address> home;

}