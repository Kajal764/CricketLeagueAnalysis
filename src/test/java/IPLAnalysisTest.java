import cricketLeague.BatsmanCsv;
import cricketLeague.IPLAnalyzer;
import cricketLeague.IplAnalyserException;
import cricketLeague.Sort;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IPLAnalysisTest {

    private static final String FACTS_SHEET_MOST_RUNS_CSV_PATH="/home/admin1/Desktop/CricketLeague/src/test/resources/IPL2019FactssheetMostRuns1.csv";
    private static final String WRONG_FACTS_SHEET_MOST_RUNS_CSV_PATH="/home/admin1/Desktop/CricketLeague/src/test/resources/IPL2019FactssheetMostRuns1";

    @Test
    public void whenGivenIpl2019FactsSheetMostRuns_ShouldLoadCorrectRecord() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        int numOfRecords = iplAnalyzer.loadCSVData(FACTS_SHEET_MOST_RUNS_CSV_PATH);
        Assert.assertEquals(100,numOfRecords);
    }
    @Test
    public void whenGivenWrongExtension_Ipl2019FactsSheetMostRuns_ShouldRet() throws IplAnalyserException {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            int numOfRecords = iplAnalyzer.loadCSVData(WRONG_FACTS_SHEET_MOST_RUNS_CSV_PATH);
            Assert.assertEquals(100,numOfRecords);

        } catch (IplAnalyserException e) { }
    }

    @Test
    public void whenGivenIpl2019FactsSheetMostRuns_ShouldReturnCorrectTopAverage() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        iplAnalyzer.loadCSVData(FACTS_SHEET_MOST_RUNS_CSV_PATH);
        List<BatsmanCsv> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.AVG_BATTING_RATE);
        Assert.assertEquals(83.2,CsvData.get(0).Avg,0);
    }

    @Test
    public void whenGivenIpl2019FactsSheetMostRuns_ShouldReturnCorrectTopStrickingRate() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        iplAnalyzer.loadCSVData(FACTS_SHEET_MOST_RUNS_CSV_PATH);
        List<BatsmanCsv> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.STRIKING_RATE);
       Assert.assertEquals(333.33,CsvData.get(0).sr,0);
    }

    @Test
    public void whenGivenIpl2019FactsSheetMostRuns_ShouldReturnCorrectTop4sAnd6s() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
       iplAnalyzer.loadCSVData(FACTS_SHEET_MOST_RUNS_CSV_PATH);
        List<BatsmanCsv> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.S4_S6);
        Assert.assertEquals("Andre Russell",CsvData.get(0).player);
    }

    @Test
    public void whenGivenIpl2019FactsSheetMostRuns_ShouldReturnCorrectTop4sAnd6sWithStrikeRate() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        iplAnalyzer.loadCSVData(FACTS_SHEET_MOST_RUNS_CSV_PATH);
        List<BatsmanCsv> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.S4_S6_SR);
      Assert.assertEquals("Andre Russell",CsvData.get(0).player);
    }


    @Test
    public void whenGivenIpl2019FactsSheetMostRuns_ShouldReturnCorrectTopAvgWithStrikeRate() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        iplAnalyzer.loadCSVData(FACTS_SHEET_MOST_RUNS_CSV_PATH);
        List<BatsmanCsv> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.AVG_SR);
        Assert.assertEquals("MS Dhoni",CsvData.get(0).player);
    }

    @Test
    public void whenGivenIpl2019FactsSheetMostRuns_ShouldReturnCorrectTopRunsWithAvg() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        iplAnalyzer.loadCSVData(FACTS_SHEET_MOST_RUNS_CSV_PATH);
        List<BatsmanCsv> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.RUN_AVG);
        Assert.assertEquals("David Warner",CsvData.get(0).player);
    }



}
