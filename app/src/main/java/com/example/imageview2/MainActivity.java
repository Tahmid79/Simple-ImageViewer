package com.example.imageview2;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.content.Intent ;
import android.widget.Gallery;
import android.widget.Button ;
import android.widget.ImageView ;


public class MainActivity extends AppCompatActivity {

    public static final int GALLERY_REQUEST_CODE = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button btn = (Button)findViewById(R.id.button) ;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickFromGallery();

            }
        });

    }

    public void pickFromGallery(){

        Intent intent = new Intent(Intent.ACTION_PICK) ;
        intent.setType("image/*") ;

        String[] mimeTypes  =  {"image/jpeg" , "image/png"}  ;
        intent.putExtra(Intent.EXTRA_MIME_TYPES , mimeTypes) ;

        startActivityForResult(intent , GALLERY_REQUEST_CODE );

    }

    protected void onActivityResult(int requestCode , int resultCode , Intent data){
        super.onActivityResult(requestCode , resultCode , data);

        if(requestCode == GALLERY_REQUEST_CODE && resultCode ==RESULT_OK){

            try{

                Uri uri = data.getData()  ;

                ImageView imageView = (ImageView)findViewById(R.id.imageView) ;
                imageView.setImageURI(uri);


            }catch (Exception e){
                e.printStackTrace();
            }




        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
