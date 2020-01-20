package cricketLeague;


import java.util.*;
import java.util.stream.Collectors;

public class IPLAnalyzer {

    List<BatsmanCsv> runsCsvlist = new ArrayList<>();
    HashMap<Sort.sortFields,Comparator> compareField=new HashMap<>();

    public int loadCSVData(String csvFilePath) throws IplAnalyserException {

        runsCsvlist = IPLLoader.loadMostRunSheetData(csvFilePath);
        return runsCsvlist.size();

    }


    public List<BatsmanCsv> getTopRecords(Sort.sortFields sortFields) {
        Comparator<BatsmanCsv> comparator=new Sort().getField(sortFields);
        ArrayList sortedlist= (ArrayList) runsCsvlist.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return sortedlist;
    }



}