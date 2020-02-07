package cricketLeague;

import java.util.*;
import java.util.stream.Collectors;

public class IPLAnalyzer {

    private  Cricket cricket;
    Map<String,CricketDAO> Csvlist = new TreeMap<>();
    public MockClass factoryMock = new MockClass();

    public IPLAnalyzer(Cricket cricket){
        this.cricket=cricket;
    }

    public IPLAnalyzer(Cricket cricket, MockClass factoryMock) {
        this.cricket=cricket;
        this.factoryMock=factoryMock;
    }

    public enum Cricket{
        BATSMAN,
        BOWLER,
        BATSMAN_BOWLER
    }

    public int loadCricketData(String... csvFilePath ) throws IplAnalyserException{
        Csvlist=factoryMock.getLoadingData(cricket,csvFilePath);
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