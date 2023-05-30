package sg.edu.rp.c346.id22024713.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView dbs, ocbc, uob;
    String btnClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.tvDBS);
        ocbc = findViewById(R.id.tvOCBC);
        uob = findViewById(R.id.tvUOB);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Contact the Bank");
        menu.add(0, 1, 1, "Website");
        menu.add(0, 2, 2, "Favourite/Un-favourite");

        if (v == dbs) {
            btnClicked = "DBS";
        } else if (v == ocbc) {
            btnClicked = "OCBC";
        } else if (v == uob) {
            btnClicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (btnClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                long number = 18001111111L;
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentWebsite);
                return true;
            } else if (item.getItemId() == 2) {
                if (dbs.getCurrentTextColor() == Color.parseColor("black")) {
                    dbs.setTextColor(Color.parseColor("#FF0000"));
                } else {
                    dbs.setTextColor(Color.parseColor("black"));
                }
                return true;
            }
        } else if (btnClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                long number = 18003633333L;
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentWebsite);
                return true;
            } else if (item.getItemId() == 2) {
                if (ocbc.getCurrentTextColor() == Color.parseColor("black")) {
                    ocbc.setTextColor(Color.parseColor("#FF0000"));
                } else {
                    ocbc.setTextColor(Color.parseColor("black"));
                }
                return true;
            }
        } else if (btnClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                long number = 18002222121L;
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentWebsite);
                return true;
            } else if (item.getItemId() == 2) {
                uob.setTextColor(Color.parseColor("#FF0000"));
                if (uob.getCurrentTextColor() == Color.parseColor("black")) {
                    uob.setTextColor(Color.parseColor("#FF0000"));
                } else {
                    uob.setTextColor(Color.parseColor("black"));
                }
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.englishSelection) {
            Toast.makeText(MainActivity.this, "English is chosen.", Toast.LENGTH_SHORT).show();
            dbs.setText("DBS");
            ocbc.setText("OCBC");
            uob.setText("UOB");
            return true;
        } else if (id == R.id.malaySelection) {
            Toast.makeText(MainActivity.this, "Bahasa Melayu dipilih.", Toast.LENGTH_SHORT).show();
            dbs.setText("Bank Pembangunan Singapura Berhad");
            ocbc.setText("Perbadanan Perbankan Luar Negara-Cina");
            uob.setText("Bank Luar Negara Terhad");
            return true;
        } else {
            dbs.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

}