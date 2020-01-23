package cricketLeague;

import java.util.List;
import java.util.Map;

public class BatsmanAdapter extends IPLLoader{

    public Map<String,CricketDAO> getData(Class<Batsman> batsmanClass, String... csvFilePath)throws IplAnalyserException {
        Map<String,CricketDAO> cricketDAO = super.loadData(csvFilePath[0], Batsman.class);
        return cricketDAO;
    }









}
