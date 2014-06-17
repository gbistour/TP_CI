/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import fsu.ContinuousIntegration.Project.DAL.CRUD.PersonData;
import fsu.ContinuousIntegration.Project.DAL.Entities.Person;
import java.util.List;

/**
 *
 * @author flo
 */
public class PersonManagementService {
            /// <summary>
    /// Retrieve all Ancien entities from database
    /// </summary>
    /// <returns></returns>
    public static List<Person> RetrieveAllAnciens() {
        return PersonData.getAll();
    }
}
