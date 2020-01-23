package cricketLeague;

import java.util.*;
import java.util.stream.Collectors;

public class IPLAnalyzer {

    private  Cricket cricket;
    Map<String,CricketDAO> Csvlist = new TreeMap<>();

    public enum Cricket{
        BATSMAN,
        BOWLER,
        BATSMAN_BOWLER
    }

    public IPLAnalyzer(Cricket cricket){
        this.cricket=cricket;
    }

    public int loadCricketData(String... csvFilePath ) throws IplAnalyserException{
        Csvlist=IPlAdapterFactory.getLoadingData(cricket,csvFilePath);
        return Csvlist.size();
    }


    public List getTopRecords(Sort.sortFields sortFields) {
        Comparator<CricketDAO> comparator=new Sort().getRunField(sortFields);
        List sortedlist= Csvlist.values().stream()
                .sorted(comparator)
                .map(cricketDTO -> cricketDTO.getIPLDTO(cricket))
                .collect(Collectors.toList());
        return sortedlist;
    }
}