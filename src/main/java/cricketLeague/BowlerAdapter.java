package cricketLeague;

import java.util.List;

public class BowlerAdapter extends IPLLoader {

    public List getData(String csvFilePath) throws IplAnalyserException {
        List<CricketDAO> cricketDAO = super.loadData(csvFilePath, Bowler.class);
        return cricketDAO;
    }
}
