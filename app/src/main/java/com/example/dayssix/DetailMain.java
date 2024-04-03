package com.example.dayssix;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DetailMain extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_DATA = "key_object";


    private ImageView ivfoto;
    private TextView tvnama, tvumur, tvnegara, tvgaji;
    private Button btnKirim;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivfoto = findViewById(R.id.ivForo);
        tvnama = findViewById(R.id.tvNama);
        tvumur = findViewById(R.id.tvUmur);
        tvnegara = findViewById(R.id.tvNegara);
        tvgaji = findViewById(R.id.tvGaji);
        btnKirim = findViewById(R.id.btnKirim);

        btnKirim.setOnClickListener(this);


        ListModel detail = getIntent().getParcelableExtra(KEY_DATA);

        if (detail != null) {
            ivfoto.setImageResource(detail.getFotoPlayer());
            tvnama.setText(detail.getNamaPlayer());
            tvumur.setText(detail.getUmurPlayer());
            tvnegara.setText(detail.getNegaraPlayer());
            tvgaji.setText(detail.getGajiPlayer());

        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnKirim) {
            ListModel detail = getIntent().getParcelableExtra(KEY_DATA);
            if (detail != null) {
                // Konversi ImageView ke Bitmap
                ivfoto.setDrawingCacheEnabled(true);
                Bitmap bitmap = Bitmap.createBitmap(ivfoto.getDrawingCache());
                ivfoto.setDrawingCacheEnabled(false);

                // Buat Intent untuk berbagi teks dan gambar
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("image/jpeg"); // Tipe MIME untuk gambar JPEG
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String path = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "Title", null);
                Uri imageUri = Uri.parse(path);
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Nama: " + detail.getNamaPlayer() +
                        "\nUmur: " + detail.getUmurPlayer() +
                        "\nNegara: " + detail.getNegaraPlayer());
                startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"));
            }

        }
    }
}