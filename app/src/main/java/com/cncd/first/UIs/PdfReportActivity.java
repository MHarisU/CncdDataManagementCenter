package com.cncd.first.UIs;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cncd.first.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PdfReportActivity extends AppCompatActivity implements OnPageChangeListener, OnLoadCompleteListener {
    private static final String TAG = PdfReportActivity.class.getSimpleName();
    //  public static final String SAMPLE_FILE = "android_tutorial.pdf";
    PDFView pdfView;
    Integer pageNumber = 0;
    Button viewPDF;

    // variables for our buttons.
    Button generatePDFbtn;

    // declaring width and height
    // for our PDF file.
    int pageHeight = 1240;
    int pagewidth = 874;

    // creating a bitmap variable
    // for storing our images
    Bitmap bmp, scaledbmp;

    // constant code for runtime permissions
    private static final int PERMISSION_REQUEST_CODE = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_report);


        // initializing our variables.
        generatePDFbtn = findViewById(R.id.idBtnGeneratePDF);
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.app_logo_two);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 80, 80, false);

        // below code is used for
        // checking our permissions.
        if (checkPermission()) {
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
        } else {
            requestPermission();
        }

        generatePDFbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling method to
                // generate our PDF file.
                generatePDF();
            }
        });


        viewPDF = findViewById(R.id.viewPDF);
        pdfView = (PDFView) findViewById(R.id.pdfView);
        viewPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                displayFromAsset();
            }
        });

    }


    private void displayFromAsset() {

        File file;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD_MR1) {

            file = new File(getExternalFilesDir(Environment.DIRECTORY_DCIM), "GFG.pdf");


            // mPath= getActivity().getExternalFilesDir(Environment.DIRECTORY_DCIM) + "/" + now + ".jpeg";
        } else {

            file = new File(Environment.getExternalStorageDirectory().toString(), "GFG.pdf");

            //  mPath= Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpeg";
        }

        pdfView.fromFile(file)
                .defaultPage(pageNumber)
                .enableSwipe(true)

                .swipeHorizontal(false)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }


    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        setTitle(String.format("%s %s / %s", "GFG.pdf", page + 1, pageCount));
    }


    @Override
    public void loadComplete(int nbPages) {
        // PdfDocument.Meta

        com.shockwave.pdfium.PdfDocument.Meta meta = pdfView.getDocumentMeta();
        printBookmarksTree(pdfView.getTableOfContents(), "-");

    }


    public void printBookmarksTree(List<com.shockwave.pdfium.PdfDocument.Bookmark> tree, String sep) {
        for (com.shockwave.pdfium.PdfDocument.Bookmark b : tree) {

            Log.e(TAG, String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));

            if (b.hasChildren()) {
                printBookmarksTree(b.getChildren(), sep + "-");
            }
        }
    }

    private void generatePDF() {
        // for our PDF document.
        PdfDocument pdfDocument = new PdfDocument();


        // we are adding page info to our PDF file
        // in which we will be passing our pageWidth,
        // pageHeight and number of pages and after that
        // we are calling it to create our PDF.
        PdfDocument.PageInfo mypageInfo = new PdfDocument.PageInfo.Builder(pagewidth, pageHeight, 1).create();

        // below line is used for setting
        // start page for our PDF file.
        PdfDocument.Page myPage = pdfDocument.startPage(mypageInfo);

        // creating a variable for canvas
        // from our page of PDF.
        Canvas canvas = myPage.getCanvas();

        // below line is used to draw our image on our PDF file.
        // the first parameter of our drawbitmap method is
        // our bitmap
        // second parameter is position from left
        // third parameter is position from top and last
        // one is our variable for paint.
        Paint paint = new Paint();
        canvas.drawBitmap(scaledbmp, 80, 50, paint);


        // two variables for paint "paint" is used
        // for drawing shapes and we will use "title"
        // for adding text in our PDF file.
        // below line is used for adding typeface for
        // our text which we will be adding in our PDF file.
        Paint header = new Paint();
        Paint regular = new Paint();
        Paint regularBold = new Paint();
        header.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        regular.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        regularBold.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));

        // below line is used for setting text size
        // which we will be displaying in our PDF file.
        header.setTextSize(20);
        regular.setTextSize(15);
        regularBold.setTextSize(16);

        // below line is sued for setting color
        // of our text inside our PDF file.
        header.setColor(ContextCompat.getColor(this, R.color.blue));
        regular.setColor(ContextCompat.getColor(this, R.color.black));
        regularBold.setColor(ContextCompat.getColor(this, R.color.Gray));


        // below line is used to draw text in our PDF file.
        // the first parameter is our text, second parameter
        // is position from start, third parameter is position from top
        // and then we are passing our variable of paint which is title.
        canvas.drawText("Center for Non-Communicable Disease", 170, 105, header);
        canvas.drawText("Recruitment Report", 170, 125, header);
        canvas.drawText("Date : 25/12/2021", 650, 105, regularBold);


        // below line is used for setting
        // our text to center of PDF.
        header.setTextAlign(Paint.Align.CENTER);

        regularBold.setColor(ContextCompat.getColor(this, R.color.blue));


        canvas.drawText("Study ID : ", 82, 170, regularBold);
        canvas.drawText("KL56847", 160, 170, regular);

        canvas.drawText("Center : ", 330, 170, regularBold);
        canvas.drawText("AKH", 390, 170, regular);

        canvas.drawText("Status : ", 600, 170, regularBold);
        canvas.drawText("CASE", 660, 170, regular);


        header.setTextSize(20);
        regular.setTextSize(15);
        regularBold.setTextSize(16);

        // below line is sued for setting color
        // of our text inside our PDF file.
        header.setColor(ContextCompat.getColor(this, R.color.blue));
        regular.setColor(ContextCompat.getColor(this, R.color.black));
        regularBold.setColor(ContextCompat.getColor(this, R.color.Gray));


        canvas.drawText("Name : ", 82, 230, regularBold);
        canvas.drawText("Muhammad Haris", 140, 230, regular);

        canvas.drawText("Gender : ", 330, 230, regularBold);
        canvas.drawText("Male", 400, 230, regular);

        canvas.drawText("Age : ", 600, 230, regularBold);
        canvas.drawText("43 years", 640, 230, regular);

        canvas.drawLine(82, 250, 780, 250, paint);
        // canvas.drawLine(20, 0, 0, 20, paint);


        canvas.drawText("Mobile No. : ", 82, 280, regularBold);
        canvas.drawText("03473647030", 180, 280, regular);

        canvas.drawText("Whatsapp No. : ", 330, 280, regularBold);
        canvas.drawText("03473647030", 450, 280, regular);

        canvas.drawText("CNIC : ", 600, 280, regularBold);
        canvas.drawText("45403-2947846-7", 650, 280, regular);

        canvas.drawLine(82, 300, 780, 300, paint);


        canvas.drawText("Address : ", 82, 330, regularBold);
        canvas.drawText("CC-65/1, Defence View, Main Service Road, Near Iqra University Main Campus, Karachi", 160, 330, regular);

        canvas.drawLine(82, 350, 780, 350, paint);


        // after adding all attributes to our
        // PDF file we will be finishing our page.
        pdfDocument.finishPage(myPage);

        // below line is used to set the name of
        // our PDF file and its path.

        File file;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD_MR1) {

            file = new File(getExternalFilesDir(Environment.DIRECTORY_DCIM), "GFG.pdf");


            // mPath= getActivity().getExternalFilesDir(Environment.DIRECTORY_DCIM) + "/" + now + ".jpeg";
        } else {

            file = new File(Environment.getExternalStorageDirectory().toString(), "GFG.pdf");

            //  mPath= Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpeg";
        }


        try {
            // after creating a file name we will
            // write our PDF file to that location.
            pdfDocument.writeTo(new FileOutputStream(file));

            // below line is to print toast message
            // on completion of PDF generation.
            Toast.makeText(PdfReportActivity.this, "PDF file generated successfully.", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            // below line is used
            // to handle error
            e.printStackTrace();
        }
        // after storing our pdf to that
        // location we are closing our PDF file.
        pdfDocument.close();
    }


    private boolean checkPermission() {
        // checking of permissions.
        int permission1 = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int permission2 = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        return permission1 == PackageManager.PERMISSION_GRANTED && permission2 == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        // requesting permissions if not provided.
        ActivityCompat.requestPermissions(this, new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0) {

                // after requesting permissions we are showing
                // users a toast message of permission granted.
                boolean writeStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean readStorage = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                if (writeStorage && readStorage) {
                    Toast.makeText(this, "Permission Granted..", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission Denined.", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    }

}