package jim.entwa1718.ent;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jim.entwa1718.ent.Address;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T15:11:35")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> name;
    public static volatile SingularAttribute<Customer, Long> id;
    public static volatile SingularAttribute<Customer, Address> home;

}