package cricketLeague;

import java.util.*;
import java.util.stream.Collectors;

public class IPLAnalyzer {

    private  Cricket cricket;
    List<CricketDAO> Csvlist = new ArrayList<>();

    public enum Cricket{
        BATSMAN,BOWLER
    }

    public IPLAnalyzer(Cricket cricket){
        this.cricket=cricket;
    }

    public int loadCricketData(String... csvFilePath ) throws IplAnalyserException{
        Csvlist=IPlAdapterFactory.getLoadingData(cricket,csvFilePath);
        return Csvlist.size();
    }

    public List<CricketDAO> getTopRecords(Sort.sortFields sortFields) {
        Comparator<CricketDAO> comparator=new Sort().getRunField(sortFields);
        ArrayList sortedlist= (ArrayList) Csvlist.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return sortedlist;
    }
}