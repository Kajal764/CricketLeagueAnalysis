package cricketLeague;

import csvbuilder.CSVBuilderException;
import csvbuilder.CSVBuilderFactory;
import csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.StreamSupport;

public abstract  class IPLLoader {

    public abstract Map<String, CricketDAO> loadData(String... csvFilePath) throws IplAnalyserException;

    public <E> Map<String,CricketDAO> loadData(Class<E> CSVClass,String... csvFilePath ) throws IplAnalyserException {
        Map<String, CricketDAO> CsvMap = new TreeMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath[0]))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<E> csvFileList = icsvBuilder.getListCsvFile(reader, CSVClass);
            if (CSVClass.getName().equals("cricketLeague.Batsman")) {
                {
                    StreamSupport.stream(csvFileList.spliterator(), false)
                            .map(Batsman.class::cast)
                            .forEach(cricketCSV -> CsvMap.put(cricketCSV.player,new CricketDAO(cricketCSV)));
                }
            }
            if (CSVClass.getName().equals("cricketLeague.Bowler")) {
                StreamSupport.stream(csvFileList.spliterator(), false)
                        .map(Bowler.class::cast)
                        .forEach(cricketCSV -> CsvMap.put(cricketCSV.player,new CricketDAO(cricketCSV)));
            }
            return CsvMap;

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

