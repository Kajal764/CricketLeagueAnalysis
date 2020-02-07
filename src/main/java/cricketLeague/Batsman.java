package cricketLeague;

import com.opencsv.bean.CsvBindByName;

public class Batsman {

    @CsvBindByName(column = "POS", required = true)
    public int pos;

    @CsvBindByName(column ="PLAYER", required = true)
    public String player;

    @CsvBindByName(column ="Mat", required = true)
    public int mat;

    @CsvBindByName(column = "Inns", required = true)
    public int inns;

    @CsvBindByName(column = "No", required = true)
    public int No;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "HS", required = true)
    public int hs;

    @CsvBindByName(column = "Avg", required = true)
    public double avg;

    @CsvBindByName(column = "BF", required = true)
    public double bf;

    @CsvBindByName(column = "SR", required = true)
    public double sr;

    @CsvBindByName(column = "100", required = true)
    public int century;

    @CsvBindByName(column = "50", required = true)
    public int halfCentury;

    @CsvBindByName(column = "4s", required = true)
    public int four_s;

    @CsvBindByName(column = "6s", required = true)
    public int six_s;

    public Batsman(double avg, double sr, int four_s, int six_s, int runs, String player) {
        this.avg=avg;
        this.sr=sr;
        this.four_s=four_s;
        this.six_s=six_s;
        this.runs=runs;
        this.player=player;
    }

//    public Batsman() {
//    }

    @Override
    public String toString() {
        return "Batsman{" +
                "pos=" + pos +
                ", player='" + player + '\'' +
                ", mat='" + mat + '\'' +
                ", inns=" + inns +
                ", No=" + No +
                ", runs=" + runs +
                ", hs='" + hs + '\'' +
                ", avg='" + avg + '\'' +
                ", bf=" + bf +
                ", sr=" + sr +
                ", century=" + century +
                ", halfCentury=" + halfCentury +
                ", four_s=" + four_s +
                ", six_s=" + six_s +
                '}';
    }
}
