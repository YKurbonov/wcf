import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class WriteCSV {
    public static void saveDataInFile(String fileName, List<State> allStates)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (State w : allStates)
                writer.append(w.getSTATE()+", "+w.getMIN_BALANCE()+", "+w.getMAX_BALANCE()+", "+w.getMEAN_BALANCE()+", "+ w.getTOTAL_BALANCE()+"\n");
            writer.close();
        } catch(Exception e){
        }
    }
}
