package cricketLeague;


import java.util.*;
import java.util.stream.Collectors;

public class IPLAnalyzer {

    List<Batsman> runsCsvlist = new ArrayList<>();
    HashMap<Sort.sortFields,Comparator> compareField=new HashMap<>();

    public int loadRunData(String csvFilePath) throws IplAnalyserException {

        runsCsvlist = IPLLoader.loadMostRunSheetData(csvFilePath);
        return runsCsvlist.size();

    }

    public int loadWktData(String csvFilePath) throws IplAnalyserException {

        runsCsvlist = IPLLoader.loadMostWicketsSheetData(csvFilePath);
        return runsCsvlist.size();

    }


    public List<Batsman> getTopRecords(Sort.sortFields sortFields) {
        Comparator<Batsman> comparator=new Sort().getField(sortFields);
        ArrayList sortedlist= (ArrayList) runsCsvlist.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return sortedlist;
    }



}