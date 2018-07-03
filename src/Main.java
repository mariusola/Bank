import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Investitor inv1 = new Investitor("Robert", "Ionut","063424", "mads@fa.da",200,0.1);
        Investitor inv2 = new Investitor("Rob","Carmen","064123","ms2@gas.gg",5555,0.08);
        List<Investitor> list = new ArrayList<>();
        list.add(inv1);
        list.add(inv2);
        Collections.sort(list);
        Integer sum=0;
        for (Investitor investitor: list) {
            sum += investitor.getSuma().intValue();
        }
        try {
            FileReader fileReader = new FileReader("Database");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String[] parameters = line.split(" ");
                Client client = new Client(parameters[0], parameters[1], parameters[2], parameters[3], Integer.parseInt(parameters[4]), Double.parseDouble(parameters[5]));
                System.out.print(total(client, sum, list));
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public double total(Client client, Integer sum, List<Investitor> list){
        double debt = 0;
        if (client.getSuma().intValue() < sum  ){
            System.out.println("Suma ceruta nu este disponibila!");
        }
        else {
            int suma = client.getSuma().intValue();
            int index = 0;
            while (suma > 0) {
                if (list.get(index).getSuma().intValue() - client.getSuma().intValue() >= 0) {
                    debt = client.getSuma().intValue() + list.get(index).getDobanda().doubleValue() * suma;
                    suma = 0;
                    list.get(index).setSuma(list.get(index).getSuma().intValue() - client.getSuma().intValue());
                } else {
                    debt = client.getSuma().intValue() + list.get(index).getDobanda().doubleValue() * list.get(index).getSuma().intValue();
                    suma = suma - list.get(index).getSuma().intValue();
                    list.get(index).setSuma(0);
                }
                index++;
            }

        }
        return debt;
    }
}

