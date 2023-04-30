package com.example.aahaarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity2 extends AppCompatActivity {
    EditText edit_input;
    Button bt_generate;
    ImageView iv_gr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edit_input=findViewById(R.id.edit_input);
        bt_generate=findViewById(R.id.bt_generate);
        iv_gr=findViewById(R.id.iv_qr);

        bt_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               generateQR();
            }
        });
    }

    private void generateQR() {
        String text=edit_input.getText().toString().trim();
        MultiFormatWriter writer=new MultiFormatWriter();
        try {
            BitMatrix matrix=writer.encode(text, BarcodeFormat.QR_CODE,400,400);
            BarcodeEncoder encode=new BarcodeEncoder();
            Bitmap bitmap=encode.createBitmap(matrix);
            iv_gr.setImageBitmap(bitmap);

        }
        catch (WriterException e){
            e.printStackTrace();
        }
    }
}