import cricketLeague.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IPLAnalysisTest {

    private static final String FACTS_SHEET_MOST_RUNS_CSV_PATH="/home/admin1/Desktop/CricketLeague/src/test/resources/IPL2019FactssheetMostRuns1.csv";
    private static final String WRONG_FACTS_SHEET_MOST_RUNS_CSV_PATH="/home/admin1/Desktop/CricketLeague/src/test/resources/IPL2019FactssheetMostRuns1";
    private static final String FACTS_SHEET_MOST_WKT_CSV_PATH="/home/admin1/Desktop/CricketLeague/src/test/resources/IPL2019FactssheetMostWkts.csv";
    private static final String WKTS_FACTS_SHEET_MOST_WKT_CSV_PATH="/home/admin1/Desktop/CricketLeague/src/test/resources/IPL2019FactssheetMostWkts";


    @Test
    public void whenGivenIpl2019FactsSheetMostRuns_ShouldLoadCorrectRecord() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        int numOfRecords = iplAnalyzer.loadRunData(FACTS_SHEET_MOST_RUNS_CSV_PATH);
        Assert.assertEquals(100,numOfRecords);
    }
    @Test
    public void whenGivenWrongExtension_Ipl2019FactsSheetMostRuns_ShouldThrowException() throws IplAnalyserException {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            int numOfRecords = iplAnalyzer.loadRunData(WRONG_FACTS_SHEET_MOST_RUNS_CSV_PATH);
            Assert.assertEquals(100,numOfRecords);

        } catch (IplAnalyserException e) { }
    }

    @Test
    public void whenGivenIpl2019FactsSheetMostRuns_ShouldReturnCorrectTopAverage() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        iplAnalyzer.loadRunData(FACTS_SHEET_MOST_RUNS_CSV_PATH);
        List<CricketDAO> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.AVG_BATTING_RATE);
        Assert.assertEquals(83.2,CsvData.get(0).avg,0);
    }

    @Test
    public void whenGivenIpl2019FactsSheetMostRuns_ShouldReturnCorrectTopStrickingRate() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        iplAnalyzer.loadRunData(FACTS_SHEET_MOST_RUNS_CSV_PATH);
        List<CricketDAO> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.STRIKING_RATE);
       Assert.assertEquals(333.33,CsvData.get(0).sr,0);
    }

    @Test
    public void whenGivenIpl2019FactsSheetMostRuns_ShouldReturnCorrectTop4sAnd6s() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
       iplAnalyzer.loadRunData(FACTS_SHEET_MOST_RUNS_CSV_PATH);
        List<CricketDAO> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.S4_S6);
        Assert.assertEquals("Andre Russell",CsvData.get(0).player);
    }

    @Test
    public void whenGivenIpl2019FactsSheetMostRuns_ShouldReturnCorrectTop4sAnd6sWithStrikeRate() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        iplAnalyzer.loadRunData(FACTS_SHEET_MOST_RUNS_CSV_PATH);
        List<CricketDAO> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.S4_S6_SR);
      Assert.assertEquals("Andre Russell",CsvData.get(0).player);
    }


    @Test
    public void whenGivenIpl2019FactsSheetMostRuns_ShouldReturnCorrectTopAvgWithStrikeRate() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        iplAnalyzer.loadRunData(FACTS_SHEET_MOST_RUNS_CSV_PATH);
        List<CricketDAO> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.AVG_SR);
        Assert.assertEquals("MS Dhoni",CsvData.get(0).player);
    }

    @Test
    public void whenGivenIpl2019FactsSheetMostRuns_ShouldReturnCorrectTopRunsWithAvg() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        iplAnalyzer.loadRunData(FACTS_SHEET_MOST_RUNS_CSV_PATH);
        List<CricketDAO> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.RUN_AVG);
        Assert.assertEquals("David Warner",CsvData.get(0).player);
    }

//TestCases For Wickets Csv

@Test
public void whenGivenIpl2019FactsSheetMostWkt_ShouldLoadCorrectRecord() throws IplAnalyserException {
    IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
    int numOfRecords = iplAnalyzer.loadWktData(FACTS_SHEET_MOST_WKT_CSV_PATH);
    System.out.println(numOfRecords);
    Assert.assertEquals(100,numOfRecords);
}

    @Test
    public void whenGivenWrongExtension_Ipl2019FactsSheetMostWkts_ShouldThrowExtension() throws IplAnalyserException {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            int numOfRecords = iplAnalyzer.loadRunData(WKTS_FACTS_SHEET_MOST_WKT_CSV_PATH);
            Assert.assertEquals(100,numOfRecords);

        } catch (IplAnalyserException e) { }
    }

    @Test
    public void whenGivenIpl2019FactsSheetMostWkts_ShouldReturnCorrectTopAverage() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        iplAnalyzer.loadWktData(FACTS_SHEET_MOST_WKT_CSV_PATH);
        List<CricketDAO> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.AVG_BATTING_RATE);
        Assert.assertEquals(166.0,CsvData.get(0).avg,0);
    }

    @Test
    public void whenGivenIpl2019FactsSheetMostWkts_ShouldReturnCorrectTopStricking_Rate() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        iplAnalyzer.loadWktData(FACTS_SHEET_MOST_WKT_CSV_PATH);
        List<CricketDAO> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.STRIKING_RATE);
        Assert.assertEquals(120.0,CsvData.get(0).sr,0);
    }

    @Test
    public void whenGivenIpl2019FactsSheetMostWkts_ShouldReturnCorrectTopEconomy_Rate() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        iplAnalyzer.loadWktData(FACTS_SHEET_MOST_WKT_CSV_PATH);
        List<CricketDAO> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.ECONOMY);
        Assert.assertEquals(13.5,CsvData.get(0).econ,0);
    }


}
