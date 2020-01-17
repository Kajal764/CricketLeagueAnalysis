import cricketLeague.IPLAnalyzer;
import cricketLeague.IplAnalyserException;
import org.junit.Test;

public class IPLAnalysisTest {

    private static final String FACTS_SHEET_MOST_RUNS_CSV_PATH="/home/admin1/Desktop/CricketLeague/src/test/resources/IPL2019FactssheetMostRuns1.csv";

    @Test
    public void whenGivenIpl2019FactsSheetMostRuns_ShouldLoadCorrectRecord() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        int numOfRecords = iplAnalyzer.loadMostRunSheetData(FACTS_SHEET_MOST_RUNS_CSV_PATH);
        System.out.println(numOfRecords);

    }
}
