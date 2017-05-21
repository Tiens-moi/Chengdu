package qingjiu.sj0132.s2.studyjams.cn.chengdu;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.KeyEvent;
        import android.view.View;
        import android.support.design.widget.NavigationView;
        import android.support.v4.view.GravityCompat;
        import android.support.v4.widget.DrawerLayout;
        import android.support.v7.app.ActionBarDrawerToggle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.Button;
        import android.widget.Toast;

        import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button btnjl,btnkzxz,btndfct,btnwhc,btndjy,btnqcs,btnset;
    public static final String JINGLI = "jinli";
    public static final String KZXZ = "kuanzhaixiangzi";
    public static final String DFCT = "dufucaotang";
    public static final String WHC = "wuhouci";
    public static final String DJY = "dujiangyan";
    public static final String QCS = "qingchengshan";

    private FirebaseAnalytics mFirebaseAnalytics;


    private View.OnClickListener lisenter = new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            Button btn = (Button)v;


            try{

                switch (btn.getId()){

                    case R.id.btnjl:
                    {
                        Intent intent=new Intent();
                        intent.setClass(MainActivity.this, ScrollingActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        Bundle b = new Bundle();
                        b.putString("place", MainActivity.JINGLI);
                        intent.putExtras( b );
                        startActivity(intent);


                        break;
                    }

                    case R.id.btnkzxz:
                    {

                        Intent intent=new Intent();
                        intent.setClass(MainActivity.this, ScrollingActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        Bundle b = new Bundle();
                        b.putString("place", MainActivity.KZXZ);
                        intent.putExtras( b );
                        startActivity(intent);


                        break;
                    }

                    case R.id.btndfct:
                    {
                        Intent intent=new Intent();
                        intent.setClass(MainActivity.this, ScrollingActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        Bundle b = new Bundle();
                        b.putString("place", MainActivity.DFCT);
                        intent.putExtras( b );
                        startActivity(intent);


                        break;
                    }
                    case R.id.btnwhc:
                    {

                        Intent intent=new Intent();
                        intent.setClass(MainActivity.this, ScrollingActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        Bundle b = new Bundle();
                        b.putString("place", MainActivity.WHC);
                        intent.putExtras( b );
                        startActivity(intent);

                        break;
                    }
                    case R.id.btndjy:
                    {

                        Intent intent=new Intent();
                        intent.setClass(MainActivity.this, ScrollingActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        Bundle b = new Bundle();
                        b.putString("place", MainActivity.DJY);
                        intent.putExtras( b );
                        startActivity(intent);

                        break;
                    }
                    case R.id.btnqcs:
                    {

                        Intent intent=new Intent();
                        intent.setClass(MainActivity.this, ScrollingActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        Bundle b = new Bundle();
                        b.putString("place", MainActivity.QCS);
                        intent.putExtras( b );
                        startActivity(intent);


                        break;
                    }
                }

            }catch(Exception e){}

        }
    };

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);


        btnjl = (Button)findViewById(R.id.btnjl);
        btnkzxz = (Button)findViewById(R.id.btnkzxz);
        btndfct = (Button)findViewById(R.id.btndfct);
        btnwhc = (Button)findViewById(R.id.btnwhc);
        btndjy = (Button)findViewById(R.id.btndjy);
        btnqcs = (Button)findViewById(R.id.btnqcs);
        btnset = (Button)findViewById(R.id.nav_setting);


        btnjl.setOnClickListener(lisenter);
        btnkzxz.setOnClickListener(lisenter);
        btndfct.setOnClickListener(lisenter);
        btnwhc.setOnClickListener(lisenter);
        btndjy.setOnClickListener(lisenter);
        btnqcs.setOnClickListener(lisenter);






        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "暂无设置",
                    Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_setting) {

            Toast.makeText(getApplicationContext(), "暂无设置",
                    Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_details) {
            Toast.makeText(getApplicationContext(), "作者：清酒。\n"+
                            "版本信息1.0\n"+"This is for 2017 google study jams",
                    Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_chat) {
            Toast.makeText(getApplicationContext(), "暂无评价",
                    Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_share) {

            Toast.makeText(getApplicationContext(), "感谢您的分享",
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_cancel) {
            Toast.makeText(getApplicationContext(), "再见",
                    Toast.LENGTH_SHORT).show();
            System.exit(0);
            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
