package cricketLeague;

import com.opencsv.bean.CsvBindByName;

public class Bowler {

    @CsvBindByName(column = "POS", required = true)
    public int pos;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int mat;

    @CsvBindByName(column = "Inns", required = true)
    public int inns;

    @CsvBindByName(column = "Ov", required = true)
    public double ov;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "Wkts", required = true)
    public int wkts;

    @CsvBindByName(column = "BBI", required = true)
    public int bbi;

    @CsvBindByName(column = "Avg", required = true)
    public double bowl_avg;

    @CsvBindByName(column = "Econ", required = true)
    public double econ;

    @CsvBindByName(column = "SR", required = true)
    public double sr;

    @CsvBindByName(column = "4w", required = true)
    public int four_wickets;

    @CsvBindByName(column = "5w", required = true)
    public int five_wickets;


    @Override
    public String toString() {
        return "Bowler{" +
                "pos=" + pos +
                ", player='" + player + '\'' +
                ", mat=" + mat +
                ", inns=" + inns +
                ", ov=" + ov +
                ", runs=" + runs +
                ", wkts=" + wkts +
                ", bbi=" + bbi +
                ", bowl_avg=" + bowl_avg +
                ", econ=" + econ +
                ", sr=" + sr +
                ", four_wickets=" + four_wickets +
                ", five_wickets=" + five_wickets +
                '}';
    }
}
