package cricketLeague;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

public class IPLAnalyzer {


    private  Cricket cricket;
    Map<String,CricketDAO> Csvlist = new HashMap<>();
    public MockClass factoryMock = new MockClass();
    public Sort sortMock=new Sort();

    public IPLAnalyzer(Cricket cricket){
        this.cricket=cricket;
    }

    public IPLAnalyzer(Cricket cricket, MockClass factoryMock) {
        this.cricket=cricket;
        this.factoryMock=factoryMock;
    }

    public IPLAnalyzer(Cricket batsman, MockClass factoryMock, Sort sort) {
        this.cricket=batsman;
        this.factoryMock=factoryMock;
        this.sortMock=sort;
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
        Comparator<CricketDAO> comparator= sortMock.getRunField(sortFields);
        List sortedlist= Csvlist.values().stream()
                .sorted(comparator)
                .map(cricketDTO -> cricketDTO.getIPLDTO(cricket))
                .collect(toCollection(ArrayList::new));
        return sortedlist;
    }
}
