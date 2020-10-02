package com.nanangarifudin.IntentIntent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import static com.nanangarifudin.IntentIntent.ScondActivity.EXTRA_MESSAGE;
import static com.nanangarifudin.IntentIntent.ScondActivity.EXTRA_REPLY;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static  final int TEXT_REQUEST = 1;
    private EditText mMessageEditText;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.edit_text);
        mReplyTextView = findViewById(R.id.text_message_reply);

    }

    public void launchSecondActivity(View view) {
        //ini onclick di button activity_main.xml harus sama
        Log.d(LOG_TAG,"Button clicked");
        String message = mMessageEditText.getText().toString();

        Intent intent = new Intent(this, ScondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent,TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST){
            if (resultCode == RESULT_OK){
                String reply = data.getStringExtra(EXTRA_REPLY);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
                Log.d(LOG_TAG,"Kirim Reply");
            }
        }
    }
}