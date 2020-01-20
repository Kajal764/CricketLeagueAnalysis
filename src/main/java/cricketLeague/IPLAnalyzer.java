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
    private List<BatsmanCsv> Avg;

    public int loadMostRunSheetData(String csvFilePath) throws IplAnalyserException {

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
            List csvFileList = icsvBuilder.getCSVFileList(reader, BatsmanCsv.class);
                csvFileList.stream().filter(CensusData -> runsCsvlist.add((BatsmanCsv) CensusData)).collect(Collectors.toList());
                return runsCsvlist.size();
        }catch (NoSuchFileException e1){
            throw new IplAnalyserException(e1.getMessage(),
                    IplAnalyserException.ExceptionType.FILE_LOAD_PROBLEM);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            throw new IplAnalyserException(e.getMessage(), e.type.name());
        }
        return 0;
    }


    public List<BatsmanCsv> getTopRecords(Sort.sortFields sortFields) {
        Comparator<BatsmanCsv> comparator=new Sort().getField(sortFields);
        ArrayList c= (ArrayList) runsCsvlist.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return c;
    }



}