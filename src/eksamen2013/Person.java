package eksamen2013;

public class Person
{
    private String navn;
    private String fødselsdato;

    //< Konstruktør som mottar navn og fødselsdato som
    //parametre og foretar initialisering av datafeltene. >

    public Person(String navn, String fødselsdato){
        this.navn = navn;
        this.fødselsdato = fødselsdato;
    }

    public String getNavn(){
        return navn;
    }

    public String getFødselsdato(){
        return fødselsdato;
    }

    public String toString()
    {
        return "Navn: " + navn+ "\n"
                + "Fødtelsdato: " + fødselsdato;
    }
} // end of class Person
