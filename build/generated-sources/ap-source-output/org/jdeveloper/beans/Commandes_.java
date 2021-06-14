package org.jdeveloper.beans;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.jdeveloper.beans.Clients;
import org.jdeveloper.beans.Factures;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-14T16:54:17")
@StaticMetamodel(Commandes.class)
public class Commandes_ { 

    public static volatile SingularAttribute<Commandes, Clients> idClients;
    public static volatile SingularAttribute<Commandes, Date> dateCommande;
    public static volatile SingularAttribute<Commandes, Integer> idCommande;
    public static volatile ListAttribute<Commandes, Factures> facturesList;

}