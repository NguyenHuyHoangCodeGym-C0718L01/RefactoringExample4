public class TennisGame {

    public static final int LOVESCORE = 0;
    public static final int FIFTEENSCORE = 1;
    public static final int THIRTYSCORE = 2;
    public static final int FORTYSCORE = 3;

    public static String getScore(int firstPlayerScore, int secondPlayerScore) {

        boolean checkEqualScoreTwoPlayer = firstPlayerScore==secondPlayerScore;

        boolean checkScoreGreaterThanForty = firstPlayerScore >= 4 || secondPlayerScore >=4;

        if (checkEqualScoreTwoPlayer)
        {
            return handlerEqualScoreBetweenTwoPlayers(firstPlayerScore, secondPlayerScore);
        }
        else if (checkScoreGreaterThanForty)
        {
            return handlerScoreGreaterThanForty(firstPlayerScore, secondPlayerScore);
        }
        else
        {
            return handlerScoreSmallerThanForty(firstPlayerScore, secondPlayerScore);
        }
    }

    public static String handlerEqualScoreBetweenTwoPlayers(int firstPlayerScore, int secondPlayerScore){
        switch (firstPlayerScore)
        {
            case LOVESCORE:
                return  "Love-All";
            case FIFTEENSCORE:
                return  "Fifteen-All";
            case THIRTYSCORE:
                return  "Thirty-All";
            case FORTYSCORE:
                return  "Forty-All";
            default:
                return  "Deuce";
        }
    }

    public static String handlerScoreGreaterThanForty(int firstPlayerScore, int secondPlayerScore){
        int resultBetweenTwoPlayers = firstPlayerScore-secondPlayerScore;

        boolean checkFirstPlayerScoreGreaterThanSecondPlayerScore = resultBetweenTwoPlayers == 1;

        boolean checkFirstPlayerScoreSmallerThanSecondPlayerScore = resultBetweenTwoPlayers == -1;

        boolean checkFirstPlayerScoreGreaterThanSecondPlayerScoreTwoPoints = resultBetweenTwoPlayers >= 2;

        if (checkFirstPlayerScoreGreaterThanSecondPlayerScore) return "Advantage player1";

        else if (checkFirstPlayerScoreSmallerThanSecondPlayerScore) return "Advantage player2";

        else if (checkFirstPlayerScoreGreaterThanSecondPlayerScoreTwoPoints) return "Win for player1";

        else return "Win for player2";
    }

    public static String handlerScoreSmallerThanForty(int firstPlayerScore, int secondPlayerScore){
        int tempScore = 0;
        String scoreCall = "";
        for (int i=1; i<3; i++)
        {
            if (i==1) tempScore = firstPlayerScore;
            else { scoreCall+="-"; tempScore = secondPlayerScore;}
            switch(tempScore)
            {
                case LOVESCORE:
                    scoreCall+="Love";
                    break;
                case FIFTEENSCORE:
                    scoreCall+="Fifteen";
                    break;
                case THIRTYSCORE:
                    scoreCall+="Thirty";
                    break;
                case FORTYSCORE:
                    scoreCall+="Forty";
                    break;
            }
        }
        return scoreCall;
    }
}
