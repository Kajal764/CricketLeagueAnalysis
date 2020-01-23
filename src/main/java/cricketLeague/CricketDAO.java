package cricketLeague;

public class CricketDAO {

    public int Wicket;
    public double econ;
    public String player;
    public int five_w;
    public int four_w;
    public double sr;
    public int four_s;
    public int six_s;
    public int runs;
    public double batsmanAvg;
    public double bowlingAvg;

    public CricketDAO(Batsman batsman) {
        batsmanAvg=batsman.avg;
        sr=batsman.sr;
        four_s=batsman.four_s;
        six_s=batsman.six_s;
        runs=batsman.runs;
        player=batsman.player;

    }

    public CricketDAO(Bowler bowler) {
        player=bowler.player;
        bowlingAvg=bowler.avg;
        sr=bowler.sr;
        four_w=bowler.four_wickets;
        five_w=bowler.five_wickets;
        runs=bowler.runs;
        econ=bowler.econ;
        Wicket=bowler.wkts;

    }

    @Override
    public String toString() {
        return "CricketDAO{" +
                "Wicket=" + Wicket +
                ", econ=" + econ +
                ", player='" + player + '\'' +
                ", five_w=" + five_w +
                ", four_w=" + four_w +
                ", sr=" + sr +
                ", four_s=" + four_s +
                ", six_s=" + six_s +
                ", runs=" + runs +
                ", batsmanAvg=" + batsmanAvg +
                ", bowlingAvg=" + bowlingAvg +
                '}';
    }
}
