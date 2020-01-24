package cricketLeague;

import java.util.Map;

public class BowlerAdapter extends IPLLoader {
    @Override
    public Map<String, CricketDAO> loadData(String[] csvFilePath) throws IplAnalyserException {
        Map<String,CricketDAO> cricketDAO = super.loadData(Bowler.class,csvFilePath[0] );
        return cricketDAO;
    }
}
