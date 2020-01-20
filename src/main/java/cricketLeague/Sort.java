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
        RUN_AVG
    }
    HashMap <sortFields,Comparator<BatsmanCsv>> compareField=new HashMap<>();

    public Comparator getField(Sort.sortFields sortField)
    {
        compareField.put(sortFields.AVG_BATTING_RATE,(data1,data2)-> (int) (data2.Avg-data1.Avg));

        compareField.put(sortFields.STRIKING_RATE,(data1,data2)-> (int) (data2.sr-data1.sr));

        compareField.put(sortFields.S4_S6,(p1, p2)-> new Integer((p2.four_s*4+p2.six_s*6) - (p1.four_s*4+p1.six_s*6)));

        Comparator<BatsmanCsv> codecomparator=(p1, p2)-> new Integer((p2.four_s*4+p2.six_s*6) - (p1.four_s*4+p1.six_s*6));
        codecomparator.thenComparing((data1,data2) -> (int) (data2.sr - data1.sr));
        compareField.put(sortFields.S4_S6_SR,codecomparator);

        Comparator<BatsmanCsv> codecomparator1=(p1, p2)-> (int) (p2.Avg-p1.Avg);
        codecomparator1.thenComparing((data1,data2) -> (int) (data2.sr - data1.sr));
        compareField.put(sortFields.AVG_SR,codecomparator1);

        Comparator<BatsmanCsv> codecomparator2=(p1, p2)-> (int) (p2.runs-p1.runs);
        codecomparator2.thenComparing((data1,data2) -> (int) (data2.Avg-data1.Avg));
        compareField.put(sortFields.RUN_AVG,codecomparator2);


        Comparator comparator=compareField.get(sortField);
        return comparator;

    }

}
