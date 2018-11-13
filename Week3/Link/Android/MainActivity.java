// Change this to your own package
package com.example.renske.adaptermegatestwoehoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;

/*
    Primary activity containing a the ListView to show plants.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Plant> plants = new ArrayList<>(Arrays.asList(
                new Plant("Opuntia Microdasys", "blue", 30),
                new Plant("Spathiphyllum Wallisii", "gray", 75),
                new Plant("Crassula Ovata", "black", 20),
                new Plant("Callisia Repens", "yellow", 15),
                new Plant("Aquilegia Vulgaris", "white", 70),
                new Plant("Dieffenbachia Seguine", "pink", 90),
                new Plant("Sansevieria Trifasciata", "green", 120),
                new Plant("Thunbergia Alata", "brown", 200),
                new Plant("Euphorbia Trigona", "orange", 140)
        ));

    }
}