import cricketLeague.Bowler;
import cricketLeague.IPLAnalyzer;
import cricketLeague.IplAnalyserException;
import cricketLeague.Sort;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IPLBowlingTest {

    private static final String FACTS_SHEET_MOST_WKT_CSV_PATH="/home/admin1/Desktop/CricketLeague/src/test/resources/IPL2019FactssheetMostWkts.csv";
    private static final String WKTS_FACTS_SHEET_MOST_WKT_CSV_PATH="/home/admin1/Desktop/CricketLeague/src/test/resources/IPL2019FactssheetMostWkts";


    @Test
    public void whenGivenIpl2019FactsSheetMostWkt_ShouldLoadCorrectRecord() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer(IPLAnalyzer.Cricket.BOWLER);
        int numOfRecords = iplAnalyzer.loadCricketData(FACTS_SHEET_MOST_WKT_CSV_PATH);
        Assert.assertEquals(99,numOfRecords);
    }

    @Test
    public void whenGivenWrongExtension_Ipl2019FactsSheetMostWkts_ShouldThrowExtension() throws IplAnalyserException {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer(IPLAnalyzer.Cricket.BOWLER);
            int numOfRecords = iplAnalyzer.loadCricketData(WKTS_FACTS_SHEET_MOST_WKT_CSV_PATH);
            Assert.assertEquals(99,numOfRecords);

        } catch (IplAnalyserException e) { }
    }

    @Test
    public void whenGivenIpl2019FactsSheetMostWkts_ShouldReturnCorrectTopAverage() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer(IPLAnalyzer.Cricket.BOWLER);
        iplAnalyzer.loadCricketData(FACTS_SHEET_MOST_WKT_CSV_PATH);
        List<Bowler> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.AVG_BOWLING);
        Assert.assertEquals(166.0,CsvData.get(0).bowl_avg,0);
    }

    @Test
    public void whenGivenIpl2019FactsSheetMostWkts_ShouldReturnCorrectTopStricking_Rate() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer(IPLAnalyzer.Cricket.BOWLER);
        iplAnalyzer.loadCricketData(FACTS_SHEET_MOST_WKT_CSV_PATH);
        List<Bowler> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.STRIKING_RATE);
        Assert.assertEquals(120.0,CsvData.get(0).sr,0);
    }

    @Test
    public void whenGivenIpl2019FactsSheetMostWkts_ShouldReturnCorrectTopEconomy_Rate() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer(IPLAnalyzer.Cricket.BOWLER);
        iplAnalyzer.loadCricketData(FACTS_SHEET_MOST_WKT_CSV_PATH);
        List<Bowler> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.ECONOMY);
        Assert.assertEquals(13.5,CsvData.get(0).econ,0);
    }

    @Test
    public void whenGivenIpl2019FactsSheetMostWkts_ShouldReturnCorrectTopStrikingrateWith5WAnd4W() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer(IPLAnalyzer.Cricket.BOWLER);
        iplAnalyzer.loadCricketData(FACTS_SHEET_MOST_WKT_CSV_PATH);
        List<Bowler> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.SR_5W_4W);
        Assert.assertEquals("Kagiso Rabada",CsvData.get(0).player);
    }

    @Test
    public void whenGivenIpl2019FactsSheetMostWkts_ShouldReturnCorrectTopAvgWithStrickingRate() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer(IPLAnalyzer.Cricket.BOWLER);
        iplAnalyzer.loadCricketData(FACTS_SHEET_MOST_WKT_CSV_PATH);
        List<Bowler> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.AVG_SR);
        Assert.assertEquals("Krishnappa Gowtham",CsvData.get(0).player);
    }

    @Test
    public void whenGivenIpl2019FactsSheetMostWkts_ShouldReturnCorrectTopWicketsWithAvg() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer(IPLAnalyzer.Cricket.BOWLER);
        iplAnalyzer.loadCricketData(FACTS_SHEET_MOST_WKT_CSV_PATH);
        List<Bowler> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.WKT_AVG);
        Assert.assertEquals("Imran Tahir",CsvData.get(0).player);
    }


}
