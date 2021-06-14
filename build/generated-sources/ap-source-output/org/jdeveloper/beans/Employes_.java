package org.jdeveloper.beans;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.jdeveloper.beans.Prospection;
import org.jdeveloper.beans.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-14T16:54:17")
@StaticMetamodel(Employes.class)
public class Employes_ { 

    public static volatile SingularAttribute<Employes, String> prenomEmploye;
    public static volatile ListAttribute<Employes, User> userBackupList;
    public static volatile SingularAttribute<Employes, String> departement;
    public static volatile SingularAttribute<Employes, Date> dateNaissance;
    public static volatile SingularAttribute<Employes, String> genre;
    public static volatile SingularAttribute<Employes, String> adresse;
    public static volatile ListAttribute<Employes, Prospection> prospectionList;
    public static volatile SingularAttribute<Employes, String> telephone;
    public static volatile SingularAttribute<Employes, String> nomEmploye;
    public static volatile SingularAttribute<Employes, String> courriel;
    public static volatile SingularAttribute<Employes, String> idEmploye;

}