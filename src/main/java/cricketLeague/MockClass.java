package cricketLeague;

import java.util.Map;

public class MockClass {
    public  Map<String,CricketDAO > getLoadingData(IPLAnalyzer.Cricket player, String... csvFilePath) throws IplAnalyserException {
        return IPlAdapterFactory.getLoadingData(player,csvFilePath);
    }

}
