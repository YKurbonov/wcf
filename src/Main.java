import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Customer> allCustomers = ReadCSV.returnCustomer("balances.csv");
        List<State> allStates = new ArrayList<>();
        State state1 = new State();
        state1.setSTATE("STATE");
        state1.setMIN_BALANCE("MIN_BALANCE");
        state1.setMAX_BALANCE("MAX_BALANCE");
        state1.setMEAN_BALANCE("MEAN_BALANCE");
        state1.setTOTAL_BALANCE("TOTAL_BALANCE");
        allStates.add(state1);

        allCustomers.remove(0);
        Map<String, String> balancesPerState = new HashMap<>();

//       balancesPerState.put("STATE", "BALANCE") ;
        for (Customer w : allCustomers)
        {
//            System.out.println(w.getSTATE());
            if(balancesPerState.containsKey(w.getSTATE())){
                balancesPerState.replace(w.getSTATE(),  balancesPerState.get(w.getSTATE())+" "+w.getBALANCE());
            } else {
                balancesPerState.put(w.getSTATE(),  w.getBALANCE());
            }
//            System.out.println(balancesPerState.get(w.getSTATE())+" "+w.getBALANCE());
        }
//        System.out.println(balancesPerState);
//        for (String key: balancesPerState.keySet()){
//            System.out.println(key+ " = " + balancesPerState.get(key));
//        }
        for (String key: balancesPerState.keySet()){
        State state = new State();
        String[] eachState = balancesPerState.get(key).split(" ");
            int n =0;
            double min =50000000.0;
            double max =0.0;
            double sum =0.0;
        for(String st : eachState){
             double num =  Double.parseDouble( st.substring(1));
            if(num< min){min=num;}
            if(num> max){max=num;}
            sum = sum + num;
            n++;
        }
        state.setSTATE(key);
        state.setMIN_BALANCE("$"+ Math.round(min*100)/100d);
        state.setMAX_BALANCE("$"+Math.round(max*100)/100d);
        state.setMEAN_BALANCE("$"+Math.round(sum*100/n)/100d);
        state.setTOTAL_BALANCE("$"+Math.round(sum*100)/100d);
        allStates.add(state);}

        for(State w : allStates) {
            System.out.println(w.getSTATE()+", "+w.getMIN_BALANCE()+", "+w.getMAX_BALANCE()+", "+w.getMEAN_BALANCE()+", "+ w.getTOTAL_BALANCE());
        }

        WriteCSV.saveDataInFile("summaryJava.csv", allStates);
    }
}
