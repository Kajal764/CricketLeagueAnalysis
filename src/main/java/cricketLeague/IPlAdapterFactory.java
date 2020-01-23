package cricketLeague;

import java.util.List;
import java.util.Map;

public class IPlAdapterFactory {
    public static <E> Map<String,CricketDAO > getLoadingData(IPLAnalyzer.Cricket cricket, String... csvFilePath) throws IplAnalyserException {

        if (cricket.equals(IPLAnalyzer.Cricket.BATSMAN))
            return new BatsmanAdapter().getData(Batsman.class,csvFilePath);
        else if(cricket.equals(IPLAnalyzer.Cricket.BOWLER))
           return new BowlerAdapter().getData(Bowler.class,csvFilePath);
       else {
            throw new IplAnalyserException("INCORRECT DATA",IplAnalyserException.ExceptionType.NO_IPL_FILE_DATA);
        }
    }
}
