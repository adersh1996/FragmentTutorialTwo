package com.example.fragmenttutorialtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button buttonOne, buttonTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOne=findViewById(R.id.button_one);
        buttonTwo =findViewById(R.id.button_two);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //note that the fragment transaction is only created when savedInstanceState is null.
                // This is to ensure that the fragment is added only once, when the activity is first created.
                // When a configuration change occurs and the activity is recreated,
                // savedInstanceState is no longer null, and the fragment does
                // not need to be added a second time, as the fragment is automatically
                // restored from the savedInstanceState.


                if (savedInstanceState == null) {
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .add(R.id.fragment_container_view, FragmentOne.class, null)
                            .commit();
                }

                //For behavior compatibility, the reordering flag is not enabled by default.
                // It is required, however, to allow FragmentManager to properly execute your FragmentTransaction,
                // particularly when it operates on the back stack and runs animations and transitions.
                // Enabling the flag ensures that if multiple transactions are executed together,
                // any intermediate fragments (i.e. ones that are added and then immediately replaced)
                // do not go through lifecycle changes or have their animations or transitions executed.
                // Note that this flag affects both the initial execution of the transaction and
                // reversing the transaction with popBackStack().

            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (savedInstanceState == null) {
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .add(R.id.fragment_container_view, FragmentTwo.class, null)
                            .commit();
                }

            }
        });

    }
}