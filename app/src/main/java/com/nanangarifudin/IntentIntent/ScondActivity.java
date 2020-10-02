package com.nanangarifudin.IntentIntent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ScondActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private EditText mReply;
    public static final String EXTRA_MESSAGE = "extra_message";
    public static final String EXTRA_REPLY="extra_reply";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scond);

        mReply = findViewById(R.id.edit_text_reply);


        Intent intent = getIntent();
        if(intent.hasExtra(ScondActivity.EXTRA_MESSAGE)){
            String message = intent.getStringExtra(EXTRA_MESSAGE);
            TextView textView = findViewById(R.id.text_message_receiver);
            textView.setText(message);

        }

    }

    public void returnReply(View view) {
        Log.d(LOG_TAG,"Reply button");

        String reply = mReply.getText().toString();

        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK,replyIntent);
        finish();


    }
}