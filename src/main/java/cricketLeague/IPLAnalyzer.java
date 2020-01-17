package cricketLeague;

import com.brideglabz.CSVBuilderException;
import com.brideglabz.CSVBuilderFactory;
import com.brideglabz.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IPLAnalyzer {

    List<RunsCsvPojo> runsCsvlist = new ArrayList<>();

    public int loadMostRunSheetData(String csvFilePath) throws IplAnalyserException {

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
            List csvFileList = icsvBuilder.getCSVFileList(reader, RunsCsvPojo.class);
                csvFileList.stream().filter(CensusData -> runsCsvlist.add((RunsCsvPojo) CensusData)).collect(Collectors.toList());
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

    public List<RunsCsvPojo> reverseSortBasedOnAvg() throws IplAnalyserException {
        if(runsCsvlist == null || runsCsvlist.size()==0)
        {
            throw new IplAnalyserException("NO CENSUS DATA",
                    IplAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }

        List <RunsCsvPojo> sortedList = runsCsvlist.stream().sorted(Comparator.comparing(RunsCsvPojo::getAvg).reversed()).collect(Collectors.toList());
        return sortedList;

    }

    public List<RunsCsvPojo> reverseSortBasedOnStrickingRate() throws IplAnalyserException {
        if(runsCsvlist == null || runsCsvlist.size()==0)
        {
            throw new IplAnalyserException("NO CENSUS DATA",
                    IplAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        List <RunsCsvPojo> sortedList = runsCsvlist.stream().sorted(Comparator.comparing(RunsCsvPojo::getSr).reversed()).collect(Collectors.toList());
        System.out.println(sortedList);
        return sortedList;

    }

    public List<RunsCsvPojo> reverseSortBasedOn4sAnd6s() throws IplAnalyserException {
        if(runsCsvlist == null || runsCsvlist.size()==0)
        {
            throw new IplAnalyserException("NO CENSUS DATA",
                    IplAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }

        Comparator<RunsCsvPojo> codecomparator=(p1,p2)-> new Integer((p1.four_s*4+p1.six_s*6) < (p2.four_s*4+p2.six_s*6)?1:-1);
        Collections.sort(runsCsvlist,codecomparator);
        System.out.println(runsCsvlist);
        return runsCsvlist;
    }


    public List<RunsCsvPojo> getreverseSortBasedOn4sAnd6sAndStrikeRate() throws IplAnalyserException {
        if(runsCsvlist == null || runsCsvlist.size()==0)
        {
            throw new IplAnalyserException("NO CENSUS DATA",
                    IplAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }

        Comparator<RunsCsvPojo> codecomparator=(p1,p2)-> new Integer((p1.four_s*4+p1.six_s*6) < (p2.four_s*4+p2.six_s*6)?1:-1);
        codecomparator = codecomparator.thenComparing((data1,data2) -> data1.sr - data2.sr < 0 ? -1 : 1);

        Collections.sort(runsCsvlist,codecomparator);
        System.out.println(runsCsvlist);
        return runsCsvlist;
    }
}