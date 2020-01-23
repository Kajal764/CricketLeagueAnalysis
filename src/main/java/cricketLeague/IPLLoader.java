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
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.StreamSupport;

public class IPLLoader {
    List<CricketDAO> CsvList = new ArrayList<>();
    Map<String, CricketDAO> CsvMap=new TreeMap<>();

    public <E> List<CricketDAO> loadData(String csvFilePath, Class<E> CSVClass) throws IplAnalyserException {


        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<E> csvFileList = icsvBuilder.getCSVFileList(reader, CSVClass);
            if (CSVClass.getName().equals("cricketLeague.Batsman")) {
                {
                    StreamSupport.stream(csvFileList.spliterator(), false)
                            .map(Batsman.class::cast)
                            .forEach(cricketCSV -> CsvList.add(new CricketDAO((Batsman) cricketCSV)));
                }
            } else {
                StreamSupport.stream(csvFileList.spliterator(), false)
                        .map(Bowler.class::cast)
                        .forEach(cricketCSV -> CsvList.add(new CricketDAO((Bowler) cricketCSV)));
            }
            return CsvList;

        } catch (NoSuchFileException e1) {
            throw new IplAnalyserException(e1.getMessage(),
                    IplAnalyserException.ExceptionType.FILE_LOAD_PROBLEM);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
        return null;
    }

    }
