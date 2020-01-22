package cricketLeague;

import java.util.Comparator;
import java.util.HashMap;

public class Sort {

    public enum sortFields{
        AVG_BATTING_RATE,
        STRIKING_RATE,
        S4_S6,
        S4_S6_SR,
        AVG_SR,
        RUN_AVG,
        ECONOMY,
        SR_5W_4W,
        MOST_5W_4W,
        WKT_AVG,
        Wkt, SR
    }


    public Comparator getRunField(Sort.sortFields sortField)
    {
    HashMap <sortFields,Comparator<CricketDAO>> compareField=new HashMap<>();

        compareField.put(sortFields.AVG_BATTING_RATE,(data1,data2)-> (int) (data2.avg-data1.avg));

        compareField.put(sortFields.STRIKING_RATE,(data1,data2)-> (int) (data2.sr-data1.sr));

        compareField.put(sortFields.S4_S6,(p1, p2)-> new Integer((p2.four_s*4+p2.six_s*6) - (p1.four_s*4+p1.six_s*6)));

        Comparator<CricketDAO> codecomparator=(p1, p2)-> new Integer((p2.four_s*4+p2.six_s*6) - (p1.four_s*4+p1.six_s*6));
        codecomparator.thenComparing((data1,data2) -> (int) (data2.sr - data1.sr));
        compareField.put(sortFields.S4_S6_SR,codecomparator);

        Comparator<CricketDAO> codecomparator1=(p1, p2)-> (int) (p2.avg-p1.avg);
        codecomparator1.thenComparing((data1,data2) -> (int) (data2.sr - data1.sr));
        compareField.put(sortFields.AVG_SR,codecomparator1);

        Comparator<CricketDAO> codecomparator2=(p1, p2)-> (int) (p2.runs-p1.runs);
        codecomparator2.thenComparing((data1,data2) -> (int) (data2.avg-data1.avg));
        compareField.put(sortFields.RUN_AVG,codecomparator2);

        compareField.put(sortFields.ECONOMY,(data1,data2)-> (int) (data1.econ<data2.econ?1:-1));

        compareField.put(sortFields.MOST_5W_4W,(data1,data2)->(data1.five_w*5 + data1.four_w*4) - (data2.five_w*5 + data2.four_w*4));
        compareField.put(sortFields.SR,(data1,data2)-> data1.sr < data2.sr?1:-1);
        compareField.put(sortFields.SR_5W_4W,compareField.get(sortFields.MOST_5W_4W).thenComparing(compareField.get(sortFields.SR)).reversed());

        compareField.put(sortFields.Wkt,(w1,w2)->w2.Wicket-w1.Wicket);
        compareField.put(sortFields.WKT_AVG,compareField.get(sortFields.Wkt).thenComparing(compareField.get(sortFields.AVG_BATTING_RATE)));

        Comparator comparator=compareField.get(sortField);
        return comparator;

    }


}
