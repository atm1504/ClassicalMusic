package in.atm1504.classicalmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String GAME_FINISHED = "game_finished";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView highScoreTextView = (TextView) findViewById(R.id.highscoreText);

        // Get the high and max score.
        int highScore = QuizUtils.getHighScore(this);
        int maxScore = Sample.getAllSampleIDs(this).size() - 1;

        // Set the high score text.
        String highScoreText = getString(R.string.high_score, highScore, maxScore);
        highScoreTextView.setText(highScoreText);

        // If the game is over, show the game finished UI.
        if (getIntent().hasExtra(GAME_FINISHED)) {
            TextView gameFinishedTextView = (TextView) findViewById(R.id.gameResult);
            TextView yourScoreTextView = (TextView) findViewById(R.id.resultScore);

            Integer yourScore = QuizUtils.getCurrentScore(this);
            String yourScoreText = getString(R.string.score_result, yourScore, maxScore);
            yourScoreTextView.setText(yourScoreText);

            gameFinishedTextView.setVisibility(View.VISIBLE);
            yourScoreTextView.setVisibility(View.VISIBLE);
        }
    }
    public void newGame(View view) {
        Intent quizIntent = new Intent(this, QuizActivity.class);
        startActivity(quizIntent);
    }
}