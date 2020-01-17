package cricketLeague;

import com.opencsv.bean.CsvBindByName;

public class RunsCsvPojo {

    @CsvBindByName(column = "POS", required = true)
    public int pos;

    @CsvBindByName(column ="PLAYER", required = true)
    public String player;

    @CsvBindByName(column ="Mat", required = true)
    public String mat;

    @CsvBindByName(column = "Inns", required = true)
    public int inns;

    @CsvBindByName(column = "No", required = true)
    public int No;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "HS", required = true)
    public String hs;

    @CsvBindByName(column = "Avg", required = true)
    public String Avg;

    @CsvBindByName(column = "BF", required = true)
    public int bf;

    @CsvBindByName(column = "SR", required = true)
    public Double sr;

    @CsvBindByName(column = "100", required = true)
    public int century;

    @CsvBindByName(column = "50", required = true)
    public int halfCentury;

    @CsvBindByName(column = "4s", required = true)
    public int four_s;

    @CsvBindByName(column = "6s", required = true)
    public int six_s;

    @Override
    public String toString() {
        return "RunsCsvPojo{" +
                "pos=" + pos +
                ", player='" + player + '\'' +
                ", mat='" + mat + '\'' +
                ", inns=" + inns +
                ", No=" + No +
                ", runs=" + runs +
                ", hs='" + hs + '\'' +
                ", Avg='" + Avg + '\'' +
                ", bf=" + bf +
                ", sr=" + sr +
                ", century=" + century +
                ", halfCentury=" + halfCentury +
                ", four_s=" + four_s +
                ", six_s=" + six_s +
                '}';
    }
}