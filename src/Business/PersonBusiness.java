package Business;

import Data.*;
import Domain.*;
import java.io.*;
import org.jdom.*;

public class PersonBusiness {

    PersonData personData;
    

    public PersonBusiness(String routeFile) throws JDOMException, IOException {
        personData = new PersonData(routeFile);
    }//Fin del constructor.

    public void insertPerson(Person person) throws IOException {
        personData.insertPerson(person);
    }//Fin de la clase insertPerson.

    public Person[] getPerson() {
        return personData.getPersona();
    }//Fin de la clase getPerson.

    public void deletePerson(String name) {
        personData.deletePerson(name);
    }

    public void modifyData(String name, Person person) {
        personData.modifyData(name, person);
    }

}//Fin de la clase PersonBusiness.
