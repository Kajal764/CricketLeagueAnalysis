package cricketLeague;


import java.util.*;
import java.util.stream.Collectors;

public class IPLAnalyzer {

    List<CricketDAO> runsCsvlist = new ArrayList<>();

    HashMap<Sort.sortFields,Comparator> compareField=new HashMap<>();

    public int loadRunData(String csvFilePath) throws IplAnalyserException {
        runsCsvlist = IPLLoader.loadMostRunSheetData(csvFilePath);
        return runsCsvlist.size();
    }

    public int loadWktData(String csvFilePath) throws IplAnalyserException {
        runsCsvlist = IPLLoader.loadMostWicketsSheetData(csvFilePath);
        return runsCsvlist.size();

    }

    public List<CricketDAO> getTopRecords(Sort.sortFields sortFields) {
        Comparator<CricketDAO> comparator=new Sort().getRunField(sortFields);
        ArrayList sortedlist= (ArrayList) runsCsvlist.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return sortedlist;
    }


}