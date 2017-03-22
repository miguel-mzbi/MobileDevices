package com.mobiledevices.miguel.a170314_activityinclass;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // Return from different activities
    private final static int TAKE_PICTURE = 0;
    private final static int SAVE_PICTURE = 1;
    private final static int TAKE_VIDEO = 2;
    private final static int STORAGE_PERMISSION = 3;

    private ImageView iv;
    private VideoView vv;
    private MediaController mc;
    private String lastImageURI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.imageView);
        vv = (VideoView) findViewById(R.id.videoView);

        mc = new MediaController(getApplicationContext());

        mc.setMediaPlayer(vv);
        vv.setMediaController(mc);

        Toast.makeText(getApplicationContext(), getString(R.string.toast), Toast.LENGTH_SHORT).show();
    }

    public void takePicture(View v) {

        // We used to open an activity knowing the class
        // Now we know the action
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, TAKE_PICTURE);
        }
    }

    public  void savePicture(View v) {

        if(Build.VERSION.SDK_INT >= 23 && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION);
        }
        else {
            savePicturePermitted();
        }
    }

    public void savePicturePermitted() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(intent.resolveActivity(getPackageManager()) != null) {
            File photo = null;

            try {
                String time = new SimpleDateFormat("yyyMMdd-HHmmss").format(new Date());
                String name = "IMAGE_" + time;

                File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                photo = File.createTempFile(name, "jpg", directory);
                lastImageURI = photo.getAbsolutePath();
            }
            catch(IOException ioe) {
                ioe.printStackTrace();
            }

            if(photo != null) {
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photo));
                startActivityForResult(intent, SAVE_PICTURE);
            }
        }
    }

    public void takeVideo(View v) {

        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        if(intent.resolveActivity(getPackageManager()) !=  null) {
            startActivityForResult(intent, TAKE_VIDEO);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == Activity.RESULT_OK) {

            switch(requestCode) {

                case TAKE_PICTURE:
                    Bundle extra = data.getExtras();
                    Bitmap image = (Bitmap) extra.get("data");
                    iv.setImageBitmap(image);
                    break;
                case SAVE_PICTURE:
                    Bitmap image2 = BitmapFactory.decodeFile(lastImageURI);
                    iv.setImageBitmap(image2);
                    break;
                case TAKE_VIDEO:
                    Uri video = data.getData();
                    vv.setVideoURI(video);
                    vv.start();
                    break;
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == STORAGE_PERMISSION && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            savePicturePermitted();
        }
    }
}
