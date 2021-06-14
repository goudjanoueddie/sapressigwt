package org.jdeveloper.beans;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.jdeveloper.beans.Commandes;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-14T16:54:17")
@StaticMetamodel(Factures.class)
public class Factures_ { 

    public static volatile SingularAttribute<Factures, Date> dateEdition;
    public static volatile SingularAttribute<Factures, Double> montant;
    public static volatile SingularAttribute<Factures, Integer> idFacture;
    public static volatile SingularAttribute<Factures, Commandes> idCommande;

}