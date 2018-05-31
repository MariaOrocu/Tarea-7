package Data;

import Domain.*;
import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.*;

public class PersonData {

    // ********** ATRIBUTOS **********
    private final Document document;
    private final Element root;
    private final String rutaArchivo;
    private int positionNodo;
    
    //constructor
    public PersonData(String routeFile) throws JDOMException, IOException {
        this.rutaArchivo = routeFile;
        this.positionNodo = 0;
        File archivo = new File(this.rutaArchivo);
        if (archivo.exists()) {
            SAXBuilder saxBuilder = new SAXBuilder();
            saxBuilder.setIgnoringElementContentWhitespace(true);
            this.document = saxBuilder.build(archivo);
            this.root = this.document.getRootElement();
        } else {
            this.root = new Element("Persona");
            this.document = new Document(this.root);
            saveXML();
        }//If que hace cosas diferentes dependiendo de si ya existe o no el archivo.
    }//Fin del constructor.
    
    // Almacena en disco duro nuestro documento xml en la ruta especificada
    private void saveXML() throws IOException {
        XMLOutputter xmlOutputter = new XMLOutputter();
        xmlOutputter.output(this.document, new PrintWriter(this.rutaArchivo));
    }//Fin del método saveXML.
    
    //método para crear la persona, los elementos y agregar los elementos a la persona
    private Element newNodo(Person person) {
        
        Element eId = new Element("Persona");
        eId.setAttribute("Cedula", person.getId());

        Element eName = new Element("Nombre");
        eName.addContent(person.getName());
        
        Element eFirstSurname = new Element("PrimerApellido");
        eFirstSurname.addContent(person.getFirstSurname());

        Element eSecondSurname = new Element("SegundoApellido");
        eSecondSurname.addContent(person.getSecondSurname());

        Element eDate = new Element("Fecha");
        eDate.addContent(person.getBirthdate());

        Element eCountry = new Element("Pais");
        eCountry.addContent(person.getCountry());

        Element eFatherId = new Element("CedulaPadre");
        eFatherId.addContent(person.getFatherId());

        eId.addContent(eName);
        eId.addContent(eFirstSurname);
        eId.addContent(eSecondSurname);
        eId.addContent(eDate);
        eId.addContent(eCountry);
        eId.addContent(eFatherId);
        
        return eId;
    }//Fin del método nuevoNodo.
    
    //método para insertar un estudiante nuevo
    public void insertPerson(Person person) throws IOException {
        this.root.addContent(newNodo(person));
        saveXML();
    }
    
    //método para obtener todos los objetos xml
    public Person[] getPersona() {
        int quantityPerson = this.root.getContentSize();
        Person[] person = new Person[quantityPerson];
        List elementsList = this.root.getChildren();
        int cont = 0;

        for (Object actualObjet : elementsList) {
            Element actualElement = (Element) actualObjet;
            Person actualPerson = new Person(
                    actualElement.getAttributeValue("Cedula"),
                    actualElement.getChild("Nombre").getValue(),
                    actualElement.getChild("PrimerApellido").getValue(),
                    actualElement.getChild("SegundoApellido").getValue(),
                    actualElement.getChild("Fecha").getValue(),
                    actualElement.getChild("Pais").getValue(),
                    actualElement.getChild("CedulaPadre").getValue()
                    );

            person[cont++] = actualPerson;
        }////Fin del for each que recorre la lista de nodos del XML.
        return person;
    }
    
    //método para modificar 
    public void modifyData(String name, Person person) {
            if (searchNodo(name)) {
                try {
                    Element nodo = newNodo(person);
                    this.root.setContent(this.positionNodo, nodo);
                } catch (Exception ex) {
                }//Try-catch.
            }//If que busca el nodo con el respectivo nombre.
        try {
            saveXML();
        } catch (IOException ex) {
        }//Fin del try-catch.
        this.positionNodo = 0;
    }//Fin del método eliminarVideo.
    
    //método para eliminar la persona
    public void deletePerson(String name) {
            if (searchNodo(name)) {
                try {
                    this.root.removeContent(this.positionNodo);
                } catch (Exception ex) {
                }//Try-catch.
            }//If que busca el nodo a eliminar.
        try {
            saveXML();
        } catch (IOException ex) {
        }//Fin del try-catch.
        this.positionNodo = 0;
    }//Fin del método eliminarVideo.
    
    //método para buscar 
    private boolean searchNodo(String nombre) {
        List elementList = this.root.getChildren();
        boolean exist = false;
        for (Object actualObject : elementList) {
            Element actualElement = (Element) actualObject;
            Person actualPerson = new Person(
                   actualElement.getAttributeValue("Cedula"),
                    actualElement.getChild("Nombre").getValue(),
                    actualElement.getChild("PrimerApellido").getValue(),
                    actualElement.getChild("SegundoApellido").getValue(),
                    actualElement.getChild("Fecha").getValue(),
                    actualElement.getChild("Pais").getValue(),
                    actualElement.getChild("CedulaPadre").getValue()
            );
             if (actualPerson.getName().equalsIgnoreCase(nombre)) {
                exist = true;
                break;
            }else{
                this.positionNodo++;
             }
        }   return exist;
    }//Fin del método buscarNodo.

}//Fin de la clase PersonData.
