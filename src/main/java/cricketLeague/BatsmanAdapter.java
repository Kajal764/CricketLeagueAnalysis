package cricketLeague;

import java.util.Map;

public class BatsmanAdapter extends IPLLoader{

    public Map<String,CricketDAO> getData(Class<Batsman> batsmanClass, String... csvFilePath)throws IplAnalyserException {
        Map<String,CricketDAO> cricketDAO = super.loadData(batsmanClass,csvFilePath[0]);
        return cricketDAO;
    }









}
