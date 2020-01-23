package cricketLeague;

import java.util.List;

public class IPlAdapterFactory {
    public static <E> List <CricketDAO >getLoadingData(IPLAnalyzer.Cricket cricket, String... csvFilePath) throws IplAnalyserException {

        if(cricket.equals(IPLAnalyzer.Cricket.BATSMAN))
            return new BatsmanAdapter().getData(csvFilePath);
       else if(cricket.equals(IPLAnalyzer.Cricket.BOWLER))
           return new BowlerAdapter().getData(csvFilePath);
       else
            throw new IplAnalyserException("INCORRECT DATA",IplAnalyserException.ExceptionType.NO_IPL_FILE_DATA);
    }
}
