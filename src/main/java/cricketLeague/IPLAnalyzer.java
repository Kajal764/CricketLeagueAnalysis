package cricketLeague;

import java.util.*;
import java.util.stream.Collectors;

public class IPLAnalyzer {

    List<CricketDAO> Csvlist = new ArrayList<>();

    public int loadRunData(String csvFilePath) throws IplAnalyserException {
        Csvlist =IPLLoader.loadData(csvFilePath,Batsman.class);
        return Csvlist.size();
    }

    public int loadWktData(String csvFilePath) throws IplAnalyserException {
        Csvlist =IPLLoader.loadData(csvFilePath,Bowler.class);
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