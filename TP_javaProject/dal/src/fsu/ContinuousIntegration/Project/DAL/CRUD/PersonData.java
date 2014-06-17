/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsu.ContinuousIntegration.Project.DAL.CRUD;

import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import fsu.ContinuousIntegration.Project.DAL.Entities.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fsureau
 */
public class PersonData {

    private static final String PersonTableName = "Ancien";
    private static final String FirstNameColumnName = "FIRSTNAME";
    private static final String LastNameColumnName = "LASTNAME";

    public static ArrayList<Person> getAll() {
        ArrayList<Person> results = new ArrayList<Person>();

        try {
            DataContext dc = DataContext.getInstance();
            SQLiteStatement resultSet = dc.retrieveAllFrom(PersonTableName);

            while (resultSet.step()) {
                Person person = new Person();
                person.setFirstName(resultSet.columnString(0));
                person.setLastName(resultSet.columnString(1));
                results.add(person);
            }
            dc.CloseConnection();

        } catch (SQLiteException ex) {
            Logger.getLogger(PersonData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
}
