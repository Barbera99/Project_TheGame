package com.example.project_thegame.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.example.project_thegame.R;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;
public class AboutPageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Element adsElement = new Element();
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription("Som una empresa formada per progmadors i dissenyadors enfocada en el desenvolupament de videojocs innovadors en la indústria.\nVam sorgir arrel de la manca de generes de videjocs nous en la industria.\n" +
                        "\n" +
                        "Venim a crear aplicacions mai vistes, amb mecàniques innovadores. Som l’empresa que crea nous generes de videojocs.\n" +
                        "\n" +
                        "Som la millor opció a l’hora de presentar al mercat aplicacions que no s’han vist abans.")
                .setImage(R.drawable.logo)
                .addItem(new Element().setTitle("Versió 1.0"))
                .addGroup("Troba'ns a:")
                .addEmail("ecgbgames@contacte.com", "Contacta'ns")
                .addWebsite("https://ecgbgames.wordpress.com/", "Visita'ns'")
                .addYoutube("UdLUniversitatdeLleida", "Mira'ns")   //Enter your youtube link here (replace with my channel link)
                //.addPlayStore("com.example.yourprojectname")   //Replace all this with your package name
                .addInstagram("campusigualadaudl", "Segueix'nos")    //Your instagram id
                .addItem(createCopyright())
                .create();
        setContentView(aboutPage);
    }
    private Element createCopyright()
    {
        Element copyright = new Element();
        @SuppressLint("DefaultLocale") final String copyrightString = String.format("Copyright %d ECGB Games", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        // copyright.setIcon(R.mipmap.ic_launcher);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutPageActivity.this,copyrightString,Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;
    }


}