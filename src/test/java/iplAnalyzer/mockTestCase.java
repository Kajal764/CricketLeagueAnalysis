package iplAnalyzer;

import cricketLeague.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;


import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

public class mockTestCase {

    @Mock
    MockClass factoryMock;

    @Rule
    public MockitoRule mockitoRule= MockitoJUnit.rule();

    private static final String FACTS_SHEET_MOST_RUNS_CSV_PATH = "/home/admin244/Desktop/CricketLeagueAnalysis/src/test/resources/IPL2019FactssheetMostRuns1.csv";

    @Test
    public void WhenLoadData_ReturnMockFactoryObject() throws IplAnalyserException {
        Map<String, CricketDAO> batsman=new HashMap<>();
        batsman.put("aaa",new CricketDAO());
        IPLAnalyzer iplAnalyzer1=new IPLAnalyzer(IPLAnalyzer.Cricket.BATSMAN,factoryMock);
        when(factoryMock.getLoadingData(IPLAnalyzer.Cricket.BATSMAN,FACTS_SHEET_MOST_RUNS_CSV_PATH)).thenReturn(batsman);
        int numOfRecords = iplAnalyzer1.loadCricketData(FACTS_SHEET_MOST_RUNS_CSV_PATH);
        Assert.assertEquals(1,  batsman.size());
    }
}
