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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class IPLLoader {



    public static  List<CricketDAO> loadMostRunSheetData(String csvFilePath) throws IplAnalyserException {
        List<CricketDAO> runsCsvlist = new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
            List csvFileList1 = icsvBuilder.getCSVFileList(reader, Batsman.class);
            StreamSupport.stream(csvFileList1.spliterator(),false)
                    .map(Batsman.class::cast)
                    .forEach(cricketCSV -> runsCsvlist.add(new CricketDAO((Batsman) cricketCSV)));

            return runsCsvlist;
        } catch (NoSuchFileException e1) {
            throw new IplAnalyserException(e1.getMessage(),
                    IplAnalyserException.ExceptionType.FILE_LOAD_PROBLEM);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            throw new IplAnalyserException(e.getMessage(), e.type.name());
        }
        return null;
    }


    public static List loadMostWicketsSheetData(String csvFilePath) throws IplAnalyserException {
        List<CricketDAO> runsCsvlist = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
            List csvFileList = icsvBuilder.getCSVFileList(reader, Bowler.class);
            StreamSupport.stream(csvFileList.spliterator(),false)
                    .map(Bowler.class::cast)
                    .forEach(cricketCSV -> runsCsvlist.add(new CricketDAO((Bowler) cricketCSV)));
            return runsCsvlist;
        } catch (NoSuchFileException e1) {
            throw new IplAnalyserException(e1.getMessage(),
                    IplAnalyserException.ExceptionType.FILE_LOAD_PROBLEM);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            throw new IplAnalyserException(e.getMessage(), e.type.name());
        }
        return null;
    }



}
