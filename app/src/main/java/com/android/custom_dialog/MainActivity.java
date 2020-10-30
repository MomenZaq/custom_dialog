package com.android.custom_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.custom_dialog_app.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void editTextDialog(View view) {
        displayEditTextDialog();
    }

    public void multiChoiceDialog(View view) {
        displayMultiChoiceDialog();
    }

    private void displayEditTextDialog() {

        final CustomDialog customDialog1 = new CustomDialog(getBaseContext());
        customDialog1.setTitle("Dialog Title");
        // optional
        customDialog1.setSubTitle("Dialog Subtitle");
        // optional
        customDialog1.setBackgroundColor(R.color.card_white_bck);
        // optional
        customDialog1.setRTL(false);
        // optional
        customDialog1.setCustomFont("my_app_font.ttf"); //  font name that inside assets

        customDialog1.setEditTextType("optional text", new OnFinishEditInterface() {
            @Override
            public void onFinish(String text) {

                Toast.makeText(MainActivity.this.getBaseContext(), "Text: " + text, Toast.LENGTH_SHORT).show();
            customDialog1.dismiss();
            }
        });

        // optional
        customDialog1.setOnCancelInterface(new OnCancelInterface() {
            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this, "dialog has been canceled", Toast.LENGTH_SHORT).show();
            }
        });
        customDialog1.show(getSupportFragmentManager(), CustomDialog.TAG);


    }


    private void displayMultiChoiceDialog() {
        List<MultiChoiceModel> multiChoiceAdapterList = new ArrayList<>();

        // set font is optional
        MultiChoiceModel multiChoiceModel = new MultiChoiceModel("Option 1", R.color.font);
        multiChoiceAdapterList.add(multiChoiceModel);
        multiChoiceModel = new MultiChoiceModel("Option 2",R.color.colorPrimaryDark);
        multiChoiceAdapterList.add(multiChoiceModel);
        multiChoiceModel = new MultiChoiceModel("Option 3");
        multiChoiceAdapterList.add(multiChoiceModel);
        multiChoiceModel = new MultiChoiceModel("Option 4");
        multiChoiceAdapterList.add(multiChoiceModel);

        final CustomDialog customDialog = new CustomDialog(getBaseContext());
        customDialog.setTitle(getBaseContext().getResources().getString(R.string.options), R.color.font_black);
        //optional
        customDialog.setBackgroundColor(R.color.card_white_bck);

        customDialog.setMultiChoiceType(multiChoiceAdapterList, new OnSelectItemInterface() {
            @Override
            public void onSelect(int position1) {
                Toast.makeText(MainActivity.this.getBaseContext(), "Selected: " + position1, Toast.LENGTH_SHORT).show();
                customDialog.dismiss();
            }
        });
        customDialog.show(getSupportFragmentManager(), CustomDialog.TAG);
    }
}