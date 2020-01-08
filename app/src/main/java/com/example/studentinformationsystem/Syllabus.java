package com.example.studentinformationsystem;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class Syllabus extends AppCompatActivity {

    ProgressDialog PD;
    String link;
    FloatingActionButton fabDownload;

    String studentNumber;

    //Permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
    };
    String studentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        Intent i = getIntent();
        link = i.getStringExtra("syllabusLink");
        Bundle bundleForUserNumber = getIntent().getExtras();
        if (bundleForUserNumber != null) {
            studentNumber = bundleForUserNumber.getString("userNumber");
            studentName = bundleForUserNumber.getString("userName");
        }

        PDFView pdfView = findViewById(R.id.pdfViewOfSyllabus);
        pdfView.fromAsset("mufredatDurumu.pdf")
                .pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(0)
                .pageFitPolicy(FitPolicy.WIDTH) // mode to fit pages in the view
                .load();

        fabDownload = findViewById(R.id.fabDownloadOfSyllabus);

        fabDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permission = ActivityCompat.checkSelfPermission(Syllabus.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if (permission != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(Syllabus.this, PERMISSIONS_STORAGE,
                            REQUEST_EXTERNAL_STORAGE);
                }
                Syllabus.DownloadTask task = new Syllabus.DownloadTask();
                task.execute(link);
            }
        });

        FloatingActionButton fabBack = findViewById(R.id.fabBackSyllabus);

        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Syllabus.this, MainPage.class);
                i.putExtra("userNumber", studentNumber);
                i.putExtra("userName",studentName);
                startActivity(i);
            }
        });
    }

    class DownloadTask extends AsyncTask<String, Integer, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            PD = new ProgressDialog(Syllabus.this);
            PD.setMax(100);
            PD.setIndeterminate(false);
            PD.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            PD.setTitle("Downloading");
            PD.setMessage("Please wait...");
            PD.show();
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate(progress);
            PD.setProgress(progress[0]);
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String fileName = "tempSyllabus.jpg";
            String pdfPath = (Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS))
                    .toString() + "/" + fileName;

            Bitmap pdfImage = downloadFile(urls[0], pdfPath);

            return pdfImage;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            PD.dismiss();
        }

        private Bitmap downloadFile(String strURL, String pdfPath){
            try {
                URL url = new URL(strURL);
                URLConnection connection = url.openConnection();
                connection.connect();

                int fileSize = connection.getContentLength();
                InputStream input = new BufferedInputStream(url.openStream(), 8192);
                OutputStream output = new FileOutputStream(pdfPath);

                byte data[] = new byte[1024];
                long total = 0;
                int count;
                while ((count = input.read(data)) != -1){
                    output.write(data, 0, count);
                    total += count;

                    int percentage = (int)(((double) total / fileSize)*100);

                    publishProgress(percentage);
                }
                output.close();
                input.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return  BitmapFactory.decodeFile(pdfPath);
        }
    }
}
