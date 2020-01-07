package as.com.NoonLib;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;







public class Library extends AppCompatActivity {

   // private static int SPLASH_TIME_OUT = 4000;


    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
       /* new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent homeIntent = new Intent(Library.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);*/


        initialiser();


    }



    private void initialiser() {

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.library);

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            final Fragment[] fragment = {null};

            switch (item.getItemId()) {


                case R.id.library :

                    fragment[0] = new LibraryBooks();
                    break;

                case R.id.returnbook :

                    fragment[0] = new ReturnBooks();
                    break;

                case R.id.fine :

                    fragment[0] = new Fine();
                    break;

                case R.id.booksborrowed :

                    fragment[0] = new BooksId();
                    break;

                case R.id.studentborrowedbooks :

                    fragment[0] = new StudentsId();
                    break;

            }
            return loadFragment(fragment[0]);

        }
    };

    public boolean loadFragment(Fragment fragment)
    {
        if(fragment!=null)
        {
            android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.frame, fragment).addToBackStack("tag");
            ft.commit();
            return  true;
        }
        return false;

    }

}