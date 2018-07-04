import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static double sumatotala;

    public static double getSumatotala() {
        return sumatotala;
    }

    public static void setSumatotala(double sumatotala) {
        Main.sumatotala = sumatotala;
    }

    public static void main(String[] args) {

        Client client = new Client("Robert", "Ionut","063424", "mads@fa.da",700,10);
        ArrayList<Investitor> list = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("Database");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                String[] parameters = line.split(" ");

                try {
                Investitor investitor= new Investitor(parameters[0], parameters[1], parameters[2], parameters[3], Integer.parseInt(parameters[4]), Double.parseDouble(parameters[5]));
                list.add(investitor);
                }catch (NumberFormatException e){
                    System.out.println();
                }
                }
        }catch (IOException e){
            e.printStackTrace();
        }
        int sum=0;
        for (Investitor investitor: list) {
            sum += investitor.getSuma().intValue();
        }
        Collections.sort(list);
        setSumatotala(total(client, sum, list));

        System.out.println("Total debt is:" + getSumatotala());
        System.out.println("Monthly installment is:" + lunar(client, sum, list));
        System.out.println("DAE:" + dae(client, sum, list));

    }

    public static double total(Client client, int sum, ArrayList<Investitor> list){
        double debt = 0;
        if (client.getSuma().intValue() > sum  ){
            System.out.println("Suma ceruta nu este disponibila!");
        }
        else {
            int suma = client.getSuma().intValue();
            int index = 0;
            while (suma > 0 && index < list.size()) {
                if (list.get(index).getSuma().intValue() - client.getSuma().intValue() >= 0) {
                    debt = client.getSuma().intValue() + list.get(index).getDobanda().doubleValue() * client.getSuma().intValue() / 12 * client.getPerioada().intValue();
                    suma = 0;
                    list.get(index).setSuma(list.get(index).getSuma().intValue() - client.getSuma().intValue());
                } else {
                    debt = client.getSuma().intValue() + list.get(index).getDobanda().doubleValue() * list.get(index).getSuma().intValue()/ 12 * client.getPerioada().intValue();
                    suma = suma - list.get(index).getSuma().intValue();
                    list.get(index).setSuma(0);
                }
                index++;
            }
        }
        return debt;
    }
    public static double lunar(Client client, Integer sum, ArrayList<Investitor> list){
        double rataLunara = 0;
        rataLunara = getSumatotala() / client.getPerioada().intValue();
        return rataLunara;
    }
    public static double dae(Client client, Integer sum, ArrayList<Investitor> list){
        double dae = 0;
        dae = (getSumatotala() - client.getSuma().intValue()) * 12 / (client.getSuma().intValue()*client.getPerioada().intValue())*100;
        return dae;
    }
}

