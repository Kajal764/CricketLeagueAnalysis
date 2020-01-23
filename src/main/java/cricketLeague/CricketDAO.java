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
    public double avg;
    public double bowl_avg;

    public CricketDAO(Batsman batsman) {
        avg =batsman.avg;
        sr=batsman.sr;
        four_s=batsman.four_s;
        six_s=batsman.six_s;
        runs=batsman.runs;
        player=batsman.player;

    }

    public CricketDAO(Bowler bowler) {
        player=bowler.player;
        bowl_avg =bowler.bowl_avg;
        sr=bowler.sr;
        four_w=bowler.four_wickets;
        five_w=bowler.five_wickets;
        runs=bowler.runs;
        econ=bowler.econ;
        Wicket=bowler.wkts;

    }

    public Object getIPLDTO(IPLAnalyzer.Cricket cricket)
    {
        if(cricket.equals(IPLAnalyzer.Cricket.BATSMAN))
            return new Batsman(avg,sr,four_s,six_s,runs,player);
        return new Bowler(player,bowl_avg,sr,four_w,five_w,runs,econ,Wicket);

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
                ", avg=" + avg +
                ", bowl_avg=" + bowl_avg +
                '}';
    }
}
