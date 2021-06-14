package org.jdeveloper.beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.jdeveloper.beans.Employes;
import org.jdeveloper.beans.Groupuser;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-14T16:54:17")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Groupuser> groupid;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile SingularAttribute<User, Employes> idEmploye;

}