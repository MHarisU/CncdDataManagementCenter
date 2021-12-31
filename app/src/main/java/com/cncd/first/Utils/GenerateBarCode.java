package com.cncd.first.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.cncd.first.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class GenerateBarCode {


    public static Bitmap getBarCodeImageBitmap(Context context, String text) {



        int size = 660;
        int size_width = 660;
        int size_height = 100;

      //  ImageView imageView = findViewById(R.id.imageView);



        BitMatrix bitMatrix = null;
        // BitMatrix bitMatrix = new MultiFormatWriter().encode(message, BarcodeFormat.QR_CODE, size, size);

        try {
            bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.CODE_128, size_width, size_height);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        int[] pixels = new int[width * height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (bitMatrix.get(j, i)) {
                    pixels[i * width + j] = 0xff000000;
                } else {
                    pixels[i * width + j] = 0xffffffff;
                }
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
      //  imageView.setImageBitmap(bitmap);

        return  bitmap;
    }

}
