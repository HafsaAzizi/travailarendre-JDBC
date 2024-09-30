
package exojdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class ExoJDBC {

  
    public static void main(String[] args) {
        
        
        // Établir la connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/travailrendre";
        String user = "root";
        String password = "";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Charger le driver JDBC
            Class.forName("com.mysql.jdbc.Driver");

            // Établir la connexion
            conn = DriverManager.getConnection(url, user, password);

            // Créer un objet Statement
            stmt = conn.createStatement();

          /////////////////////////////////////Parti 1/////////////////////
            
          String query ="SELECT Developpeurs, Jour, max(NbScripts)  as c "+
                            " from devdata"+
                            " group by Jour";
           
            
            
            rs = stmt.executeQuery(query);

            // Parcourir les résultats
            while (rs.next()) {
                String developpeur = rs.getString("Developpeurs");
                 String  jour =rs.getString("Jour");
                int nbScripts = rs.getInt("c");

                //System.out.println("Le développeur " + developpeur + " a réalisé " + nbScripts + " scripts");
                
                System.out.println("Le jour " + jour + " le nombre de script " + nbScripts + " scripts");
                
            }
            
        } 
       

        catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
                }
        catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du driver JDBC");
                }
        finally {
            
            
            // Fermer les ressources
            try    {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } 
            catch (SQLException e) {
                System.out.println("Erreur de fermeture des ressources");
           
            }        
       }
        
        /////////////////////////////*partie b */////////////////////////
        
         System.out.println("b)	la liste des personnes triée dans l’ordre décroissant selon leur nombre de scripts");
        
        
         try {
            // Charger le driver JDBC
            Class.forName("com.mysql.jdbc.Driver");

            // Établir la connexion
            conn = DriverManager.getConnection(url, user, password);

            // Créer un objet Statement
            stmt = conn.createStatement();

  ////Exécuter la requête SQL
           String query = "SELECT Developpeurs, sum(NBScripts) as c " +
                           "FROM devdata " +
                           "GROUP BY Developpeurs " +
                           "ORDER BY c DESC"; 
   
            
            rs = stmt.executeQuery(query);

            // Parcourir les résultats
            while (rs.next()) {
                String developpeur = rs.getString("Developpeurs");
                int nbScripts = rs.getInt("c");

                System.out.println("Le développeur " + developpeur + " a réalisé " + nbScripts + " scripts");
            }
            
        } 
        
        
       
        ////////////////////////////////////////////////////////////////////

        catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
                }
        catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du driver JDBC");
                }
        finally {
            
            
            // Fermer les ressources
            try    {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } 
            catch (SQLException e) {
                System.out.println("Erreur de fermeture des ressources");
           
            }        
       }
        
        ////////////////////////////////////partie 3////////////////////////
         
         System.out.println(" afficher le nombre total de scripts réalisés en une semaine");
          
         
         try {
            // Charger le driver JDBC
            Class.forName("com.mysql.jdbc.Driver");

            // Établir la connexion
            conn = DriverManager.getConnection(url, user, password);

            // Créer un objet Statement
            stmt = conn.createStatement();

  ////Exécuter la requête SQL
          
            String query ="SELECT WEEK(Jour) AS semaine, SUM(NbScripts) AS totalScripts " +
                           "FROM devdata " +
                           "GROUP BY WEEK(Jour)";
              rs = stmt.executeQuery(query);

            // Parcourir les résultats
            while (rs.next()) {
                int semaine = rs.getInt("semaine");
                int totalScripts = rs.getInt("totalScripts");
                System.out.println("Semaine " + semaine + " : " + totalScripts + " scripts réalisés");
            }
            
        } 
        

        catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
                }
        catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du driver JDBC");
                }
        finally {
            
            
            // Fermer les ressources
            try    {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } 
            catch (SQLException e) {
                System.out.println("Erreur de fermeture des ressources");
           
            }        
       }
         
         
         //////////////partie 4////////////
         
         System.out.println("le nombre total de scripts réalisés");
         
     // Lecture du nom du développeur à partir de l'entrée utilisateur
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom du développeur : ");
        String nomDeveloppeur = scanner.nextLine();
        
        
         try {
            // Charger le driver JDBC
            Class.forName("com.mysql.jdbc.Driver");

            // Établir la connexion
            conn = DriverManager.getConnection(url, user, password);

            // Créer un objet Statement
            stmt = conn.createStatement();

  ////Exécuter la requête SQL
          String query = "SELECT SUM(NbScripts) AS totalScripts " +
                           "FROM devdata " +
                           "WHERE Developpeurs = '" + nomDeveloppeur + "'";
            rs = stmt.executeQuery(query);

            // Parcourir les résultats
            if (rs.next()) {
                int totalScripts = rs.getInt("totalScripts");
                System.out.println("Le développeur " + nomDeveloppeur + " a réalisé un total de " + totalScripts + " scripts.");
            } else {
                System.out.println("Aucun résultat trouvé pour le développeur " + nomDeveloppeur);
            }

        

         } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
                }
        catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du driver JDBC");
                }
        finally {
            
            
            // Fermer les ressources
            try    {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } 
            catch (SQLException e) {
                System.out.println("Erreur de fermeture des ressources");
           
            }        
       }
         
         /////////////partie 5//////////////////
         
         System.out.println("la requête libre et la méta information sur les types de données du résultat");
         
        try {
             // Charger le driver JDBC
            Class.forName("com.mysql.jdbc.Driver");
          
             // Établir la connexion
            conn = DriverManager.getConnection(url, user, password);

            // Créer un objet Statement
            stmt = conn.createStatement();
            
              // Debug : afficher la requête avant exécution
            // Lecture de la requête SQL à partir de l'entrée utilisateur
            System.out.print("Entrez votre requête SQL : ");
            String query = scanner.nextLine(); // Assign the input SQL query to the variable

             // Debug : afficher la requête avant exécution
             System.out.println("Requête SQL exécutée : " + query);

           
            // Exécuter la requête SQL
            boolean isResultSet = stmt.execute(query);

            if (isResultSet) {
                // La requête a renvoyé un ResultSet (exemple : SELECT)
                rs = stmt.getResultSet();

                // Obtenir les méta-informations sur les colonnes du ResultSet
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                
                // Afficher le nombre de colonnes
                System.out.println("Nombre de colonnes dans le résultat : " + columnCount);

                // Afficher le nom et le type de chaque colonne
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnType = metaData.getColumnTypeName(i);
                    System.out.println("Colonne " + i + ": " + columnName + " (Type: " + columnType + ")");
                }

                // Afficher le contenu du ResultSet ligne par ligne
                System.out.println("\nContenu du ResultSet :");
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(rs.getString(i) + "\t");
                    }
                    System.out.println();
                }

            } else {
                // La requête a modifié les données (exemple : INSERT, UPDATE, DELETE)
                int rowsAffected = stmt.getUpdateCount();
                System.out.println("Nombre de lignes affectées : " + rowsAffected);
            }

        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
                }
        catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du driver JDBC");
                }
        finally {
            
            
            // Fermer les ressources
            try    {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } 
            catch (SQLException e) {
                System.out.println("Erreur de fermeture des ressources");
           
            }        
       }
         
  }
      
}




 
        
