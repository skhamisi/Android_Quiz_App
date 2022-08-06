package com.example.quizapproadsigns;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class AttemptsRecordActivity extends AppCompatActivity {

    private DbManager dbManager;

    private ListView listView;

    private SimpleCursorAdapter adapter;

    final String[] from = new String[] {
            DbHelper._ID,
            DbHelper.PERCENTAGE,
            DbHelper.SCORE,
            DbHelper.STATUS};

    final int[] to = new int[] {
            R.id.attemptTextView,
            R.id.percentageTextView,
            R.id.scoreTextView,
            R.id.statusTextView};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_attempts_record);
        setContentView(R.layout.fragment_emp_list);

        dbManager = new DbManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        listView = findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.emptyTextView));

        adapter = new SimpleCursorAdapter(this, R.layout.activity_attempts_record, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        // OnCLickListener For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {

                TextView attemptTextView = view.findViewById(R.id.attemptTextView);
                String id = attemptTextView.getText().toString();
                Long _id = Long.parseLong(id);

                AlertDialog delete_entry = new AlertDialog.Builder(AttemptsRecordActivity.this)
                        .setTitle("Delete entry")
                        .setMessage("Are you sure you want to delete this entry?")

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Continue with delete operation
                                dbManager.delete(_id);
                                returnHome();
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.back, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.backButton) {

            Intent back = new Intent(this, MainActivity.class);
            startActivity(back);

        }
        return super.onOptionsItemSelected(item);
    }

    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), AttemptsRecordActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }
}