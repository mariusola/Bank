import java.util.List;
import java.util.Scanner;

public class Investitor implements Comparable<Investitor> {
    private String nume;
    private String prenume;
    private String telefon;
    private String email;
    private Number suma;
    private Number dobanda;


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
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

    public Number getDobanda() {
        return dobanda;
    }

    public void setDobanda(Number dobanda) {
        this.dobanda = dobanda;
    }
    public Investitor (String nume, String prenume, String telefon, String email, Number suma, Number dobanda){
        setNume(nume);
        setPrenume(prenume);
        setTelefon(telefon);
        setEmail(email);
        setSuma(suma);
        setDobanda(dobanda);
    }

    @Override
    public int compareTo(Investitor o) {
        if(this.getDobanda().doubleValue()< o.getDobanda().doubleValue()){
            return -1;
        }else if(this.getDobanda().doubleValue() == o.getDobanda().doubleValue()){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Investitor{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                ", suma=" + suma +
                ", dobanda=" + dobanda +
                '}';
    }
}