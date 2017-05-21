package qingjiu.sj0132.s2.studyjams.cn.chengdu;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;




public class ScrollingActivity extends AppCompatActivity {


    private String in;
    private Drawable image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView tv = (TextView)findViewById(R.id.text);
        ImageView im = (ImageView)findViewById(R.id.img);


        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String str=bundle.getString("place");


        switch (str){
            case MainActivity.JINGLI:
            {

                in = getResources().getString(R.string.jin);
                image = getResources().getDrawable(R.mipmap.jinli);
                tv.setText(in);
                im.setImageDrawable(image);
                break;
            }
            case MainActivity.KZXZ:
            {
                in = getResources().getString(R.string.kuan);
                image = getResources().getDrawable(R.mipmap.kzxz);
                tv.setText(in);
                im.setImageDrawable(image);
                break;
            }
            case MainActivity.DFCT:
            {
                in = getResources().getString(R.string.dufu);
                image = getResources().getDrawable(R.mipmap.dfct);
                tv.setText(in);
                im.setImageDrawable(image);
                break;
            }
            case MainActivity.WHC:
            {
                in = getResources().getString(R.string.wu);
                image = getResources().getDrawable(R.mipmap.whc);
                tv.setText(in);
                im.setImageDrawable(image);
                break;
            }
            case MainActivity.DJY:
            {
                in = getResources().getString(R.string.dujiang);
                image = getResources().getDrawable(R.mipmap.djy);
                tv.setText(in);
                im.setImageDrawable(image);
                break;
            }
            case MainActivity.QCS:
            {
                in = getResources().getString(R.string.qing);
                image = getResources().getDrawable(R.mipmap.qcs);
                tv.setText(in);
                im.setImageDrawable(image);
                break;
            }


        }




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScrollingActivity.this,MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                ScrollingActivity.this.startActivity(intent);
            }
        });
    }




}
