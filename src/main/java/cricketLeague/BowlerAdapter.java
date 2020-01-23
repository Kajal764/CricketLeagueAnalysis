package cricketLeague;

import java.util.List;
import java.util.Map;

public class BowlerAdapter extends IPLLoader {

    public Map<String,CricketDAO> getData(Class<Bowler> bowlerClass, String... csvFilePath) throws IplAnalyserException {
        Map<String,CricketDAO> cricketDAO = super.loadData(csvFilePath[0], Bowler.class);
        return cricketDAO;
    }
}
