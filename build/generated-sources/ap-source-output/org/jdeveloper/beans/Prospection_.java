package org.jdeveloper.beans;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.jdeveloper.beans.Clients;
import org.jdeveloper.beans.Employes;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-14T16:54:17")
@StaticMetamodel(Prospection.class)
public class Prospection_ { 

    public static volatile SingularAttribute<Prospection, String> besoinsAttenteClient;
    public static volatile SingularAttribute<Prospection, String> objectifProspection;
    public static volatile SingularAttribute<Prospection, Clients> idClients;
    public static volatile SingularAttribute<Prospection, String> type;
    public static volatile SingularAttribute<Prospection, Date> dateProspection;
    public static volatile SingularAttribute<Prospection, Employes> idEmploye;
    public static volatile SingularAttribute<Prospection, Integer> idProspection;

}