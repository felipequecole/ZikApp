package com.example.frankson.zikapp;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class AedesInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aedes_info);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Aedes Aegypti");
        actionBar.setDisplayHomeAsUpEnabled(true);

        //TextView tvAedes = (TextView) findViewById(R.id.textViewAedes);
        //tvAedes.setMovementMethod(new ScrollingMovementMethod());;
        /*WebView mWebView = (WebView) findViewById(R.id.webview);

        String text = "<html><body>"
                + "<p align=\"justify\">"
                + getString(R.string.AedesText)
                + "</p> "
                + "</body></html>";

        mWebView.loadData(text, "text/html", "iso-8859-1");*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
