/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Catégorie;
import Utils.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import IServices.CategServices;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
/**
 *
 * @author ASSOUMA
 */
public class ServiceCateg implements CategServices <Catégorie> {
    private Connection cnx;
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet res;
    
    
    
    public ServiceCateg() {
             cnx=Database.getInstance().getCon();

    }

    
    
    @Override
    public void ajouter(Catégorie c) throws SQLException {
         String req = "INSERT INTO categorie (nom)" +" VALUES (?)";
        try{
            
             PreparedStatement pst = cnx.prepareStatement(req);
            
            
            pst.setString(1,c.getNom());
            
           
            pst.executeUpdate();
            System.out.println("Catégory added successfully");
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @Override
    
      public boolean supprimer(int id) throws SQLException  {
       
        String sql="delete from categorie where id= ? ";
				
		try {
                    pst=cnx.prepareStatement(sql);
                    pst.setInt(1, id);
                    pst.execute();
                System.out.println("catégorie supprimé avec succé");
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
  
    }

    @Override
    public void modifier(Catégorie c) throws SQLException {
        
        
        PreparedStatement pst
                = cnx.prepareStatement("update categorie set nom= ?  where id= ?");    
       
            pst.setString(1,c.getNom());
            pst.setInt(2,c.getId());

        
          
            pst.executeUpdate();
            System.out.println("category updated");
           
        
    }

    @Override
    public List<Catégorie> afficher() throws SQLException {
        
         List<Catégorie> liste=new ArrayList<Catégorie>();
          PreparedStatement pt = cnx.prepareStatement("Select * from categorie");
          
          
            ResultSet rs = pt.executeQuery();
          
            while(rs.next()){
                int id = rs.getInt(1);
                String nom = rs.getString(2);

   
                       
            Catégorie c = new Catégorie( id, nom );
                liste.add(c);
            }
            return liste;
        

    }
    
    
     public List<Catégorie> findByNom(String nom) {
   
           String sql="Select* from categorie";
         List<Catégorie> list =new ArrayList<>();
         
         try {
            stmt=cnx.createStatement();
            res=stmt.executeQuery(sql);
            while(res.next()){
                list.add(new Catégorie(res.getInt(1),res.getString(2)));
            }
                    return list.stream().filter(x->x.getNom().equals(nom)).collect(Collectors.toList());
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMedic.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        
        }    }
    
     
     
     
        public List<Catégorie> ListNomASC() throws SQLException {
         
        List<Catégorie> list = new ArrayList<Catégorie>();
            PreparedStatement pt = cnx.prepareStatement("select * from categorie ORDER BY nom ASC");
            
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                
               int id = rs.getInt(1);
                String nom = rs.getString(2);
              
                                        

             Catégorie cat = new Catégorie(id,nom );
                list.add(cat);
            }
            return list;
            }
    
     public List<Catégorie> ListNomDESC() throws SQLException {
         
        List<Catégorie> list = new ArrayList<Catégorie>();
            PreparedStatement pt = cnx.prepareStatement("select * from categorie ORDER BY nom DESC");
            
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                
                int id = rs.getInt(1);
                String nom = rs.getString(2);
              
                
                                        

             Catégorie cat = new Catégorie(id,nom );
                list.add(cat);
            }
            return list;
            }

     
}
