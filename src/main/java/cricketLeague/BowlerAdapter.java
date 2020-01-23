package cricketLeague;

import java.util.Map;

public class BowlerAdapter extends IPLLoader {

    public Map<String,CricketDAO> getData(Class<Bowler> bowlerClass, String... csvFilePath) throws IplAnalyserException {
        Map<String,CricketDAO> cricketDAO = super.loadData(bowlerClass,csvFilePath[0] );
        return cricketDAO;
    }
}
