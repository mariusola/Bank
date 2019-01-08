import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    private String nume;
    private String prenume;
    private String telefon;
    private String email;
    private Number suma;
    private Number perioada;

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

        public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Number getSuma() {
        return suma;
    }

    public void setSuma(Number suma) {
        this.suma = suma;
    }

    public Number getPerioada() {
        return perioada;
    }

    public void setPerioada(Number perioada) {
        this.perioada = perioada;
    }

    public Client (String nume, String prenume, String telefon, String email, Number suma, Number perioada) {
        setNume(nume);
        setPrenume(prenume);
        setTelefon(telefon);
        setEmail(email);
        setSuma(suma);
        setPerioada(perioada);
    }
    }

