package jim.entwa1718.ent;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jim.entwa1718.ent.Customer;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T15:11:35")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> city;
    public static volatile SingularAttribute<Address, Long> id;
    public static volatile ListAttribute<Address, Customer> occupiers;

}