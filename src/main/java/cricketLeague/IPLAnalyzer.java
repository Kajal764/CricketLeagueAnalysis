package cricketLeague;

import com.brideglabz.CSVBuilderException;
import com.brideglabz.CSVBuilderFactory;
import com.brideglabz.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IPLAnalyzer {

    List<RunsCsvPojo> runsCsvlist = new ArrayList<>();

    public int loadMostRunSheetData(String csvFilePath) throws IplAnalyserException {

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
            List csvFileList = icsvBuilder.getCSVFileList(reader, RunsCsvPojo.class);
                csvFileList.stream().filter(CensusData -> runsCsvlist.add((RunsCsvPojo) CensusData)).collect(Collectors.toList());
                return csvFileList.size();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            throw new IplAnalyserException(e.getMessage(), e.type.name());
        }
        return 0;
    }
}