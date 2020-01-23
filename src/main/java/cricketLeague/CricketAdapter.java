package cricketLeague;

import java.util.Map;

public class CricketAdapter extends IPLLoader {
    public Map<String, CricketDAO> getData(String[] csvFilePath) throws IplAnalyserException {
        Map<String,CricketDAO> batsmanData= super.loadData(Batsman.class,csvFilePath[0]);
        Map<String,CricketDAO> bowlerData = super.loadData( Bowler.class,csvFilePath[1]);

        bowlerData.values().stream()
                .filter(Runs->batsmanData.get(Runs.player)!=null)
                .forEach(Runs->batsmanData.get(Runs.player).bowl_avg =Runs.bowl_avg);

        return batsmanData;
    }
}
