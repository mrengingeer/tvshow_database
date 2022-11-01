/**
 * @author Taninder Thiara
 *         500888351
 */

package net.codejava;
import java.sql.*;
import java.util.Scanner;


public class TVShowDatabase {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;
        System.out.println("T.V Show Database!");
        System.out.println("To see a list of tv shows, press 1 \nTo see a list of episodes, press 2 \nTo see a list of actors, press 3\n"
                           + "To see a list of characters, press 4 \nTo see a list of distributing companies, press 5\n"
                           + "To see a list of shows that are ongoing, press 6 \nTo see a list of shows that have ended, press 7\n"
                           + "To see a list of shows with a rating of more than 9/10, press 8\n"
                           + "To see a list of actors who are aged more than 20 but less than 45, press 9\n"
                           + "To see a list of the companies that make shows with characters with the role of CriminalCEO, press 10\n");
        Scanner sc = new Scanner (System.in);
        String input = sc.next();
        
        switch (input) {
            case "1":
                try {
                    Class.forName("org.sqlite.JDBC");
                    c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\tanin\\OneDrive\\7th Semester\\COE 848\\Labs\\Lab 3\\tvshow.db"); //path to database file
                    stmt = c.createStatement();
                    ResultSet result = stmt.executeQuery("SELECT title from tvShow");
                    while(result.next()){
                        String name = result.getString("title");
                        System.out.println(name);
                    }
                }
                catch (Exception e) {
                    System.err.println("Problem Encountered");
                }   break;
            case "2":
                try {
                    Class.forName("org.sqlite.JDBC");
                    c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\tanin\\OneDrive\\7th Semester\\COE 848\\Labs\\Lab 3\\tvshow.db");
                    stmt = c.createStatement();
                    ResultSet result = stmt.executeQuery("SELECT title from episodes");
                    while(result.next()){
                        String name = result.getString("title");
                        System.out.println(name);
                    }
                }
                catch (Exception e) {
                    System.err.println("Problem Encountered");
                }   break;
            case "3":
                try {
                    Class.forName("org.sqlite.JDBC");
                    c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\tanin\\OneDrive\\7th Semester\\COE 848\\Labs\\Lab 3\\tvshow.db");
                    stmt = c.createStatement();
                    ResultSet result = stmt.executeQuery("SELECT name from actor");
                    while(result.next()){
                        String name = result.getString("name");
                        System.out.println(name);
                    }
                }
                catch (Exception e) {
                    System.err.println("Problem Encountered");
                }   break;
            case "4":
                try {
                    Class.forName("org.sqlite.JDBC");
                    c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\tanin\\OneDrive\\7th Semester\\COE 848\\Labs\\Lab 3\\tvshow.db");
                    stmt = c.createStatement();
                    ResultSet result = stmt.executeQuery("SELECT name from character");
                    while(result.next()){
                        String name = result.getString("name");
                        System.out.println(name);
                    }
                }
                catch (Exception e) {
                    System.err.println("Problem Encountered");
                }   break;
            case "5":
                try {
                    Class.forName("org.sqlite.JDBC");
                    c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\tanin\\OneDrive\\7th Semester\\COE 848\\Labs\\Lab 3\\tvshow.db");
                    stmt = c.createStatement();
                    ResultSet result = stmt.executeQuery("SELECT companyName from company");
                    while(result.next()){
                        String name = result.getString("companyName");
                        System.out.println(name);
                    }
                }
                catch (Exception e) {
                    System.err.println("Problem Encountered");
                }   break;
            case "6":
                try {
                    Class.forName("org.sqlite.JDBC");
                    c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\tanin\\OneDrive\\7th Semester\\COE 848\\Labs\\Lab 3\\tvshow.db");
                    stmt = c.createStatement();
                    ResultSet result = stmt.executeQuery("SELECT title from tvshow where endDate = 'NULL'");
                    while(result.next()){
                        String name = result.getString("title");
                        System.out.println(name);
                    }
                }
                catch (Exception e) {
                    System.err.println("Problem Encountered");
                }   break;
            case "7":
                try {
                    Class.forName("org.sqlite.JDBC");
                    c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\tanin\\OneDrive\\7th Semester\\COE 848\\Labs\\Lab 3\\tvshow.db");
                    stmt = c.createStatement();
                    ResultSet result = stmt.executeQuery("SELECT title from tvshow where endDate != 'NULL'");
                    while(result.next()){
                        String name = result.getString("title");
                        System.out.println(name);
                    }
                }
                catch (Exception e) {
                    System.err.println("Problem Encountered");
                }   break;
            case "8":
                try {
                    Class.forName("org.sqlite.JDBC");
                    c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\tanin\\OneDrive\\7th Semester\\COE 848\\Labs\\Lab 3\\tvshow.db");
                    stmt = c.createStatement();
                    ResultSet result = stmt.executeQuery("SELECT title FROM tvshow where showID IN (SELECT showID FROM episodes where rating > 9)");
                    while(result.next()){
                        String name = result.getString("title");
                        System.out.println(name);
                    }
                }
                catch (Exception e) {
                    System.err.println("Problem Encountered");
                }   break;
            case "9":
                try {
                    Class.forName("org.sqlite.JDBC");
                    c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\tanin\\OneDrive\\7th Semester\\COE 848\\Labs\\Lab 3\\tvshow.db");
                    stmt = c.createStatement();
                    ResultSet result = stmt.executeQuery("SELECT name FROM actor where age > 20 AND age < 45");
                    while(result.next()){
                        String name = result.getString("name");
                        System.out.println(name);
                    }
                }
                catch (Exception e) {
                    System.err.println("Problem Encountered");
                }   break;
            case "10":
                try {
                    Class.forName("org.sqlite.JDBC");
                    c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\tanin\\OneDrive\\7th Semester\\COE 848\\Labs\\Lab 3\\tvshow.db");
                    stmt = c.createStatement();
                    ResultSet result = stmt.executeQuery("SELECT companyName FROM company where companyID IN (SELECT companyID from tvshow "
                            + "where showID IN (SELECT showID from character where role = 'CriminalCEO'));");
                    while(result.next()){
                        String name = result.getString("companyName");
                        System.out.println(name);
                    }
                }
                catch (Exception e) {
                    System.err.println("Problem Encountered");
                }   break;
            default:
                break;
        }
    }
}