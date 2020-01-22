package cricketLeague;

import java.util.*;
import java.util.stream.Collectors;

public class IPLAnalyzer {

    private  Cricket cricket;
    List<CricketDAO> Csvlist = new ArrayList<>();

    public enum Cricket{
        BATSMAN,BOWLER
    }

    public IPLAnalyzer(Cricket cricket){
        this.cricket=cricket;
    }

    public int loadCricketData(String csvFilePath)throws IplAnalyserException{
        if(cricket.equals(Cricket.BATSMAN))
             Csvlist= new BatsmanAdapter().getData(csvFilePath);
        else if(cricket.equals(Cricket.BOWLER))
            Csvlist= new BowlerAdapter().getData(csvFilePath);
        else
            throw new IplAnalyserException("INCORRECT DATA",IplAnalyserException.ExceptionType.NO_IPL_FILE_DATA);
        return Csvlist.size();
    }

    public List<CricketDAO> getTopRecords(Sort.sortFields sortFields) {
        Comparator<CricketDAO> comparator=new Sort().getRunField(sortFields);
        ArrayList sortedlist= (ArrayList) Csvlist.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return sortedlist;
    }
}