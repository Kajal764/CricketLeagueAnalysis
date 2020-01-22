package cricketLeague;

import java.util.List;

public class BatsmanAdapter extends IPLLoader{

    public List<CricketDAO> getData(String csvFilePath)throws IplAnalyserException {
        List<CricketDAO> cricketDAO = super.loadData(csvFilePath, Batsman.class);
        return cricketDAO;
    }

}
