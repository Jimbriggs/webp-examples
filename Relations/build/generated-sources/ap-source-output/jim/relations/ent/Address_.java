package jim.relations.ent;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jim.relations.ent.Person;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-10T14:39:13")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> city;
    public static volatile SingularAttribute<Address, Long> id;
    public static volatile ListAttribute<Address, Person> passersby;
    public static volatile ListAttribute<Address, Person> occupants;

}