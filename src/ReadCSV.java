import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {
    public static List<Customer> returnCustomer(String filePath){
        List<Customer> allcustomers = new ArrayList<>();

        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\yarki\\Desktop\\Test DEV prep\\WCF\\balances.csv"));
            while ((line = br.readLine()) != null)

            { Customer customer = new Customer();
                String[] eachCustomer = line.split(splitBy);
                customer.setFIRST_NAME(eachCustomer[0]);
                customer.setLAST_NAME(eachCustomer[1]);
                customer.setADDRESS(eachCustomer[2]);
                customer.setCITY(eachCustomer[3]);
                customer.setSTATE(eachCustomer[4]);
                customer.setZIP(eachCustomer[5]);
                customer.setPHONE(eachCustomer[6]);
                customer.setBALANCE(eachCustomer[7]);
                allcustomers.add(customer);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return allcustomers;
}
}
