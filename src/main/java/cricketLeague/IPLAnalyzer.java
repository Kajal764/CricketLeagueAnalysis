package cricketLeague;

import com.brideglabz.CSVBuilderException;
import com.brideglabz.CSVBuilderFactory;
import com.brideglabz.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
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
        ArrayList c= (ArrayList) runsCsvlist.stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        return c;
    }



}