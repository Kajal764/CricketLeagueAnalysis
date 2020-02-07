package cricketLeague;

import java.util.Map;

public class BatsmanAdapter extends IPLLoader{

    @Override
    public Map<String, CricketDAO> loadData(String... csvFilePath) throws IplAnalyserException {
        Map<String,CricketDAO> cricketDAO = super.loadData(Batsman.class,csvFilePath[0]);
        return cricketDAO;
    }
}
