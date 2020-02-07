package iplAnalyzer;

import cricketLeague.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

public class mockTestCase {

    Map<String, CricketDAO> batsman=new HashMap<>();
    @Before
    public void setdata(){
        Batsman batsman1 =new Batsman(69.2,1,57,21,692,"David Warner");
        Batsman batsman2=new Batsman(53.9,2,49,25,93,"Kl Rahul");
        Batsman batsman3 =new Batsman(69.2,1,57,21,992,"David Warner");
        batsman.put("Batting",new CricketDAO(batsman1));
        batsman.put("Batting",new CricketDAO(batsman2));
        batsman.put("Batting",new CricketDAO(batsman3));
    }

    @Mock
    MockClass factoryMock;

    @Mock
    Sort sort;

    @Rule
    public MockitoRule mockitoRule= MockitoJUnit.rule();

    private static final String FACTS_SHEET_MOST_RUNS_CSV_PATH = "/home/admin244/Desktop/CricketLeagueAnalysis/src/test/resources/IPL2019FactssheetMostRuns1.csv";

    @Test
    public void WhenLoadData_ReturnMockFactoryObject() throws IplAnalyserException {
        IPLAnalyzer iplAnalyzer1=new IPLAnalyzer(IPLAnalyzer.Cricket.BATSMAN,factoryMock);
        when(factoryMock.getLoadingData(IPLAnalyzer.Cricket.BATSMAN,FACTS_SHEET_MOST_RUNS_CSV_PATH)).thenReturn(batsman);
        int numOfRecords = iplAnalyzer1.loadCricketData(FACTS_SHEET_MOST_RUNS_CSV_PATH);
        Assert.assertEquals(1,numOfRecords);
    }

    @Test
    public void WhenSortData_ReturnMockFactoryObject() throws IplAnalyserException {

        Comparator<Batsman> comparator=(data1, data2)-> (int) (data2.runs -data1.runs);
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer(IPLAnalyzer.Cricket.BATSMAN,factoryMock, sort);
        when(factoryMock.getLoadingData(IPLAnalyzer.Cricket.BATSMAN,FACTS_SHEET_MOST_RUNS_CSV_PATH)).thenReturn(batsman);
        iplAnalyzer.loadCricketData(FACTS_SHEET_MOST_RUNS_CSV_PATH);
        when(sort.getRunField(Sort.sortFields.AVG_BATSMAN)).thenReturn(comparator);
        List<Batsman> CsvData = iplAnalyzer.getTopRecords(Sort.sortFields.AVG_BATSMAN);
        Assert.assertEquals(992,CsvData.get(0).runs,0.0);
    }
}
