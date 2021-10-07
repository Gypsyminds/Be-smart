/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import gestiondesfactures.entite.Categorie;

/**
 *
 * @author ZNJ
 */
public class ServiceFacture {
       public float calcul( Categorie[] c){
       float s=0;
    for( int i=0;i<=c.length;i++)
         {s=c[i].getPrixcat()+s;
     
       }
       return s;
       
       }
}
