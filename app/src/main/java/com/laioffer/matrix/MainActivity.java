package com.laioffer.matrix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity  implements EventFragment.OnItemSelectListener, CommentFragment.OnItemSelectListener  {

    private EventFragment listFragment;
    private CommentFragment gridFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Show different fragments based on screen size.
        listFragment = getSupportFragmentManager().findFragmentById(R.id.event_container) == null ? new EventFragment() :
                (EventFragment) getSupportFragmentManager().findFragmentById(R.id.event_container);
        getSupportFragmentManager().beginTransaction().replace(R.id.event_container, listFragment).commit();

        if (isTablet()) {
            gridFragment = getSupportFragmentManager().findFragmentById(R.id.comment_container) == null ? new CommentFragment() :
                    (CommentFragment) getSupportFragmentManager().findFragmentById(R.id.comment_container);

            getSupportFragmentManager().beginTransaction().replace(R.id.comment_container, gridFragment).commit();
        }
    // or use a flag, if frist time add, do add, othrewise do nothing

    }

    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    @Override
    public void onItemSelected(int position) {
        if (!isTablet()) {
            Intent intent = new Intent(this, EventGridActivity.class);
            intent.putExtra("position", position);
            startActivity(intent);
        } else {
            gridFragment.onItemSelected(position);
        }
    }

    @Override
    public void onCommentSelected(int position) {
        listFragment.onItemSelected(position);
    }
    /**
     * A dummy function to get fake event names.
     */
    private String[] getEventNames() {
        String[] names = {
                "Event1", "Event2", "Event3",
                "Event4", "Event5", "Event6",
                "Event7", "Event8", "Event9",
                "Event10", "Event11", "Event12"};
        return names;
    }
}