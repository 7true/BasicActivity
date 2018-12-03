package tk.alltrue.basicactivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Snackbar mSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSnackbar = Snackbar.make(view, "Do you like it?", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Yes", snackbarOnClickListener);
                View snackbarView = mSnackbar.getView();
                snackbarView.setBackgroundColor(Color.BLUE);
                TextView snackTextView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                snackTextView.setTextColor(Color.RED);
                mSnackbar.show();

                mSnackbar.addCallback(new Snackbar.Callback() {
                    @Override
                    public void onDismissed(Snackbar snackbar, int event) {
                        if (event == Snackbar.Callback.DISMISS_EVENT_TIMEOUT) {
                            Log.i("SnackBar", "Закрыт по тайм-ауту");
                        }
                        if (event == Snackbar.Callback.DISMISS_EVENT_SWIPE) {
                            Log.i("SnackBar", "Swipe");
                        }
                        if (event == Snackbar.Callback.DISMISS_EVENT_MANUAL) {
                            Log.i("SnackBar", "Button");
                        }
                    }

                    @Override
                    public void onShown(Snackbar snackbar) {
                        Log.i("SnackBar", "onShown");
                    }
                });
            }
        });



        Button dismissButton = (Button) findViewById(R.id.dismissButton);
        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSnackbar.dismiss();
            }
        });

    }

    View.OnClickListener snackbarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "Cool!", Toast.LENGTH_LONG).show();
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
