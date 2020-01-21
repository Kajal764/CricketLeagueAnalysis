package cricketLeague;


import java.util.*;
import java.util.stream.Collectors;

public class IPLAnalyzer {

    List<Batsman> runsCsvlist = new ArrayList<>();
    List<Bowler> wktsCsvList= new ArrayList<>();
    HashMap<Sort.sortFields,Comparator> compareField=new HashMap<>();

    public int loadRunData(String csvFilePath) throws IplAnalyserException {

        runsCsvlist = IPLLoader.loadMostRunSheetData(csvFilePath);
        return runsCsvlist.size();

    }

    public int loadWktData(String csvFilePath) throws IplAnalyserException {

        wktsCsvList = IPLLoader.loadMostWicketsSheetData(csvFilePath);
        return wktsCsvList.size();

    }


    public List<Batsman> getTopRecords(Sort.sortFields sortFields) {
        Comparator<Batsman> comparator=new Sort().getRunField(sortFields);
        ArrayList sortedlist= (ArrayList) runsCsvlist.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return sortedlist;
    }
    public List<Bowler> getTopBowlingRecords(Sort.sortFields sortFields) {
        Comparator<Bowler> comparator=new Sort().getWktField(sortFields);
        ArrayList sortedlist= (ArrayList) wktsCsvList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        System.out.println(sortedlist);
        return sortedlist;
    }



}