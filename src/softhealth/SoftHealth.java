/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softhealth;

import Entity.Catégorie;
import Entity.Médicament;
import Entity.Ordonnance;
import Service.ServiceCateg;
import Service.ServiceMedic;
import Service.ServiceOrdo;
import Utils.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entity.Médicament;


/**
 *
 * @author ASSOUMA
 */
public class SoftHealth {
    
    
    private static String url="jdbc:mysql://localhost:3306/pharmacie";
    private static String user="root";
    private static String pwd="";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        try {
            // TODO code application logic here
            Connection con = DriverManager.getConnection(url,user,pwd);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            Logger.getLogger(SoftHealth.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  
        Médicament t1 = new Médicament(22,2345,"Sterdex",1,5499,49);
        Médicament t2 = new Médicament(23,9987,"Dolirhume",2,9999,90);
        Médicament t3 = new Médicament(24,1000,"Inflamil",3,2311,21);
        
        Catégorie ca1 = new Catégorie(3,"Sirop");
        Catégorie ca2 = new Catégorie(4,"seringue");

        Ordonnance ord1 = new Ordonnance(7,6,4,2,2,2,"Avant le dinner",7,1,3,5);
        Ordonnance ord2 = new Ordonnance(9,6,2,2,2,2,"Aprés le dinner",7,1,3,5);

        
        
        ServiceMedic  sm = new ServiceMedic();
        ServiceCateg  sc = new ServiceCateg();
        ServiceOrdo   so = new ServiceOrdo();
        
        try{
            
   /*     
      System.out.println("******** ajouter Médicament **********");
   
           Scanner s=new Scanner(System.in);
         try {
             System.out.println("Entrer le code de médicament:");
             int code =s.nextInt();
             System.out.println("Entrer le nom de médicament:");
             String name =s.next();
             System.out.println("Entrer l'id du categorie de médicament:");
             int categorie_id =s.nextInt();
             System.out.println("Entrer le prix du médicament:");
             int prix = s.nextInt();
             System.out.println("Entrer la stock de médicament:");
             int stock = s.nextInt();
            
            Connection con = DriverManager.getConnection(url,user,pwd);
 
        PreparedStatement pst
                = con.prepareStatement("INSERT INTO medicament (code,name,categorie_id,prix,stock)" +" VALUES (?,?,?,?,?)");
 
            pst.setInt(1,code);
            pst.setString(2,name);
            pst.setInt(3,categorie_id);
            pst.setInt(4,prix);
            pst.setInt(5,stock);
      int i = pst.executeUpdate();
      if(i!=0){
        System.out.println("Médicament Ajouté avec succé");
      }
      else{
        System.out.println("failed to add");
      }
    }
    catch (Exception e){
     System.out.println(e);
    }
  
 
        
        System.out.println("******** Afficher Médicament **********");
       System.out.println(sm.afficher());
        
        
        System.out.println("******** Modifier Médicament **********");
        //sm.modifier(t3);
        //System.out.println(sm.afficher());
            
            
            
                            Scanner medi = new Scanner(System.in);
              try{
     

                   System.out.println("Entrer l'id de Médicament que vous souhéte le modifier");
                   int id = medi.nextInt();
                   
             System.out.println("Entrer le nouveau code de médicament:");
             int code =medi.nextInt();
             System.out.println("Entrer le nouveau nom de médicament:");
             String name =medi.next();
             System.out.println("Entrer le nouveau id du categorie de médicament:");
             int categorie_id =medi.nextInt();
             System.out.println("Entrer le nouveau prix du médicament:");
             int prix = medi.nextInt();
             System.out.println("Entrer la nouvelle stock de médicament:");
             int stock = medi.nextInt();
                   Connection con = DriverManager.getConnection(url,user,pwd);
                                                                      
                    PreparedStatement pst= con.prepareStatement("update medicament set code = ?, name=?, categorie_id=?, prix=?, stock=?  where id = ?;");
                  
            pst.setInt(1,code);
            pst.setString(2,name);
            pst.setInt(3,categorie_id);
            pst.setInt(4,prix);
            pst.setInt(5,stock);
                   pst.setInt(6, id);
                   int i = pst.executeUpdate();
                    
                   if(i>0)
                   {
                       System.out.println("Médicament modifié avec succé"); 
                  
                    }else{
                            System.out.println("failed to Update");
                         }
       }
                     
                catch (Exception e){
                 System.out.println(e);
             }
       
       
       System.out.println(sm.afficher());
       
        
        
        
        System.out.println("******** Supprimer Médicament **********");
        //sm.supprimer(65);
        //System.out.println(sm.afficher());
            
            
                 
       
                            Scanner med = new Scanner(System.in);
              try{
     

                   System.out.println("Entrer l'id de medicament que vous souhéte le supprimer");
                   int id = med.nextInt();
                   
                   Connection con = DriverManager.getConnection(url,user,pwd);

                    PreparedStatement pst= con.prepareStatement("delete from medicament where id= ?");
        
                   pst.setInt(1, id);
                   int i = pst.executeUpdate();
                    
                   if(i>0)
                   {
                       System.out.println("medicament supprimé avec succé"); 
                  
                    }else{
                            System.out.println("failed to Delete");
                         }
       }
                     
                catch (Exception e){
                 System.out.println(e);
             }
       
         
     System.out.println(sm.afficher());
       
            
            
            
        
            
        
          
        System.out.println("******** Rechercher Médicament par nom **********");
        System.out.println(sm.findByName("Imodium"));
        
        System.out.println("******** Rechercher Médicament par id **********");
        System.out.println(sm.findById(4));
        
        System.out.println("******** Rechercher Médicament par Categorie **********");
        System.out.println(sm.findByCategory(1));
        
        System.out.println("******** Rechercher Médicament par Code **********");
        System.out.println(sm.findByCode (4469));
       
        System.out.println("******** Rechercher Médicament par Stock **********");
        System.out.println(sm.findByStock (40));
            
        System.out.println("******** Trier Médicament par Stock Croissant **********");
        System.out.println(sm.ListMediOrderByASC());
            
        System.out.println("******** Trier Médicament par Stock Déroissant **********");
        System.out.println(sm.ListMediOrderByDESC());
            
        System.out.println("******** Trier Médicament par Prix Croissant **********");
        System.out.println(sm.ListPrixASC());
            
        System.out.println("******** Trier Médicament par Prix Déroissant **********");
        System.out.println(sm.ListPrixDESC());
      
        
       */
      
       
   System.out.println("***********************************Catégorie***************************************************");

       System.out.println("****************** Ajouter Catégorie *********************");
       
       
           Scanner scann=new Scanner(System.in);
         try {
             System.out.println("Entrer le nom du catégorie:");
             String nom =scann.next();
           
            
            Connection con = DriverManager.getConnection(url,user,pwd);
 
        PreparedStatement pst
                = con.prepareStatement("INSERT INTO categorie (nom)" +" VALUES (?)");
 
            pst.setString(1,nom);
          
      int i = pst.executeUpdate();
      if(i!=0){
        System.out.println("Catégorie Ajouté avec succée");
      }
      else{
        System.out.println("failed to add");
      }
    }
    catch (Exception e){
     System.out.println(e);
    } 
       
     
       System.out.println("****************** Afficher Catégorie  ********************");
       System.out.println(sc.afficher());
        
        
       System.out.println("****************** Modifier Catégorie  ********************");
       //sc.modifier(ca2);
       //System.out.println(sc.afficher());
       
      
       
                            Scanner input = new Scanner(System.in);
              try{
     

                   System.out.println("Entrer l'id de catégorie que vous souhéte la modifier");
                   int id = input.nextInt();
                   
                    System.out.println("Entrer le nouveau nom de catégorie");
                   String nom = input.next();
                   
                   Connection con = DriverManager.getConnection(url,user,pwd);

                    PreparedStatement pst= con.prepareStatement("update categorie set nom = ?  where id = ?;");
                  
                   
                   pst.setString(1, nom);
                   pst.setInt(2, id);
                   int i = pst.executeUpdate();
                    
                   if(i>0)
                   {
                       System.out.println("Catégorie modifiée avec succé"); 
                  
                    }else{
                            System.out.println("failed to Update");
                         }
       }
                     
                catch (Exception e){
                 System.out.println(e);
             }
       
       
       System.out.println(sc.afficher());
       
        
        
        System.out.println("****************** Supprimer Catégorie ********************");
          //sc.supprimer(5);
       // System.out.println(sc.afficher());
        
       
       
       
                            Scanner scanne = new Scanner(System.in);
              try{
     

                   System.out.println("Entrer l'id de catégorie que vous souhéte la supprimer");
                   int id = scanne.nextInt();
                   
                   Connection con = DriverManager.getConnection(url,user,pwd);

                    PreparedStatement pst= con.prepareStatement("delete from categorie where id= ?");
        
                   pst.setInt(1, id);
                   int i = pst.executeUpdate();
                    
                   if(i>0)
                   {
                       System.out.println("catégorie supprimé avec succé"); 
                  
                    }else{
                            System.out.println("failed to Delete");
                         }
       }
                     
                catch (Exception e){
                 System.out.println(e);
             }
       
         
     System.out.println(sc.afficher());
   
   
        System.out.println("******** Rechercher Catégorie par nom **********");
        System.out.println(sc.findByNom("Sirop"));
    
        System.out.println("******** Trier Catégorie par Ordre Croissant **********");
        System.out.println(sc.ListNomASC());
            
        System.out.println("******** Trier Catégorie par Ordre Déroissant **********");
        System.out.println(sc.ListNomDESC());
         
     
     
     
     
     
     
                
                /*
        System.out.println("***************************************************Ordonnance********************************************");

        
         System.out.println("****************** Ajouter Ordonnance ********************");
         
         
         
                    Scanner scan=new Scanner(System.in);
         try {
             System.out.println("Entrer l'id de médicament:");
             int medicaments_id =scan.nextInt();
             System.out.println("Entrer l'id de categorie:");
             int categorie_id =scan.nextInt();
             System.out.println("Entrer l'id de consultation:");
             int consultation_id =scan.nextInt();
             System.out.println("Entrer l'id de patient:");
             int patient_id = scan.nextInt();
             System.out.println("Entrer l'id de l'utilisateur:");
             int users_id = scan.nextInt();
              System.out.println("Entrer la description:");
             String description = scan.next();
              System.out.println("Entrer le nombre de jours:");
             int nbr_jrs = scan.nextInt();
              System.out.println("Entrer le nombre de doses:");
             int nbr_doses = scan.nextInt();
              System.out.println("Entrer le nombre de fois:");
             int nbr_fois = scan.nextInt();
               System.out.println("Entrer le nombre de paquets:");
             int nbr_paquets = scan.nextInt();
             
         
            Connection con = DriverManager.getConnection(url,user,pwd);
 
        PreparedStatement pst
                = con.prepareStatement("INSERT INTO ordonnance (medicaments_id, categorie_id, consultation_id, patient_id, users_id, description, nbr_jrs, nbr_doses, nbr_fois, nbr_paquets)"
                 +" VALUES (?,?,?,?,?,?,?,?,?,?)");
 
             pst.setInt(1,medicaments_id);
             pst.setInt(2,categorie_id);
             pst.setInt(3,consultation_id);
             pst.setInt(4,patient_id);
             pst.setInt(5,users_id);
             pst.setString(6,description);
             pst.setInt(7,nbr_jrs);
             pst.setFloat(8,nbr_doses);
             pst.setInt(9,nbr_fois);
             pst.setInt(10,nbr_paquets);
             
      int i = pst.executeUpdate();
      if(i!=0){
        System.out.println("Ordonnance ajoutée avec succée");
      }
      else{
        System.out.println("failed to add");
      }
    }
    catch (Exception e){
     System.out.println(e);
    }
        
           
     
 
        System.out.println("****************** Afficher Ordonnance  ********************");
        System.out.println(so.afficher());
        
        
        System.out.println("****************** Modifier Ordonnance  *******************");
       // so.modifier(ord2);
        //System.out.println(so.afficher());
     
     
     
                            Scanner ordo = new Scanner(System.in);
              try{
     

                   System.out.println("Entrer l'id de l'ordonnance que vous souhéte la modifier");
                   int id = ordo.nextInt();
                   
                   System.out.println("Entrer l'id de médicament:");
             int medicaments_id =ordo.nextInt();
             System.out.println("Entrer l'id de categorie:");
             int categorie_id =ordo.nextInt();
             System.out.println("Entrer l'id de consultation:");
             int consultation_id =ordo.nextInt();
             System.out.println("Entrer l'id de patient:");
             int patient_id = ordo.nextInt();
             System.out.println("Entrer l'id de l'utilisateur:");
             int users_id = ordo.nextInt();
              System.out.println("Entrer la description:");
             String description = ordo.next();
              System.out.println("Entrer le nombre de jours:");
             int nbr_jrs = ordo.nextInt();
              System.out.println("Entrer le nombre de doses:");
             int nbr_doses = ordo.nextInt();
              System.out.println("Entrer le nombre de fois:");
             int nbr_fois = ordo.nextInt();
               System.out.println("Entrer le nombre de paquets:");
             int nbr_paquets = ordo.nextInt();
                   
                   Connection con = DriverManager.getConnection(url,user,pwd);

                    PreparedStatement pst= con.prepareStatement("update ordonnance set medicaments_id= ? , categorie_id= ?, consultation_id= ? , patient_id= ? , users_id = ? ,description=?, nbr_jrs=?, nbr_doses=?, nbr_fois=?, nbr_paquets=?  where id= ?;");
                  
                   
                     pst.setInt(1,medicaments_id);
             pst.setInt(2,categorie_id);
             pst.setInt(3,consultation_id);
             pst.setInt(4,patient_id);
             pst.setInt(5,users_id);
             pst.setString(6,description);
             pst.setInt(7,nbr_jrs);
             pst.setFloat(8,nbr_doses);
             pst.setInt(9,nbr_fois);
             pst.setInt(10,nbr_paquets);
             pst.setInt(11,id);

                   int i = pst.executeUpdate();
                    
                   if(i>0)
                   {
                       System.out.println("Ordonnance modifiée avec succé"); 
                  
                    }else{
                            System.out.println("failed to Update");
                         }
       }
                     
                catch (Exception e){
                 System.out.println(e);
             }
       
       
       System.out.println(so.afficher());
       
        
     
     
     
        
        
       System.out.println("****************** Supprimer Ordonnance ********************");
       // so.supprimer(3);
        //System.out.println(so.afficher());
     
     
     
       
                            Scanner ob = new Scanner(System.in);
              try{
     

                   System.out.println("Entrer l'id de l'ordonnance que vous souhéte la supprimer");
                   int id = ob.nextInt();
                   
                   Connection con = DriverManager.getConnection(url,user,pwd);

                    PreparedStatement pst= con.prepareStatement("delete from ordonnance where id= ?");
        
                   pst.setInt(1, id);
                   int i = pst.executeUpdate();
                    
                   if(i>0)
                   {
                       System.out.println("ordonnance supprimé avec succé"); 
                  
                    }else{
                            System.out.println("failed to Delete");
                         }
       }
                     
                catch (Exception e){
                 System.out.println(e);
             }
       
         
     System.out.println(so.afficher());
       
     
     
     
        
         
        
         System.out.println("******** Trier Les Ordonnances par ordre Croissant **********");
         
            System.out.println(so.ListOrdoOrderByAsc());


        System.out.println("******** Trier Les Ordonnances par ordre Décroissant **********");
          System.out.println(so.ListOrdoOrderByDesc());
                 
       

       
        */
        
        
        
        
  } catch (SQLException ex) {
           Logger.getLogger(SoftHealth.class.getName()).log(Level.SEVERE, null, ex);
       }

   }
    
}
