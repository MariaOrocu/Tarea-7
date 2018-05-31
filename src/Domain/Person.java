package Domain;

public class Person {

    // ******************** ATRIBUTOS ********************
    private String id;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private String birthdate;
    private String country;
    private String fatherId;

//constructores
    public Person(String id, String name, String firstSurname, String secondSurname, String birthdat, String country, String fatherId) {
        this.id = id;
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.birthdate = birthdat;
        this.country = country;
        this.fatherId = fatherId;
    }

//métodos accesores
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

}//Fin de la clase Person.
