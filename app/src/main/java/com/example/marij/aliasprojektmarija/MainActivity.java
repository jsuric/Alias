package com.example.marij.aliasprojektmarija;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBAdapter db = new DBAdapter(this);

        /*
        //---add a contact---
        db.open();
        long id = db.insertWord("Nogometaš", "Nogomet, Lopta, Manekenka");
        id = db.insertWord("Matematika", "Škola, Predmet, Brojevi");
        id = db.insertWord("Skijanje", "Snijeg, Zima, Skijaška oprema");
        id = db.insertWord("Prsten", "Prst, Zaručnički, Dragi kamen");
        id = db.insertWord("Bolnica", "Liječnik, Pacijent, Liječiti");
        id = db.insertWord("Odvjetnik", "Parnica, Sud, Odijelo");
        id = db.insertWord("Plaža", "Pijesak, Ljeto, Ležati");
        id = db.insertWord("Knjižnica", "Čitati, Knjiga, Zakasnina");
        id = db.insertWord("Čaj", "Kava, Voćni, Hladnoća");
        id = db.insertWord("Glavobolja", "Glava, Migrena, Mamurluk");
        id = db.insertWord("Kino", "Film, Kokice, Ljubavno sjedalo");
        id = db.insertWord("Plitvička jezera", "Lika, Jezero, Nacionalni park");
        id = db.insertWord("Češalj", "Češljati, Kosa, Četka");
        db.close();
        */



        /*
        //---obriši sve riječi u bazi, trenutno ih je 13
        db.open();
        for(int i=1; i<=26; i++)
        {
            if (db.deleteWord(i))
                Toast.makeText(this, "Delete successful.", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "Delete failed.", Toast.LENGTH_LONG).show();
        }

        db.close();
        */

        //--sve riječi sa zabranjenim---
        db.open();
        Cursor c1 = db.getAllWords();
        if (c1.moveToFirst())
        {
            do {
                DisplayContact(c1);
            } while (c1.moveToNext());
        }
        db.close();


     /*
        //---određena riječ---
        db.open();
        Cursor cu = db.getWord(2);
        if (cu.moveToFirst())
            DisplayContact(cu);
        else
            Toast.makeText(this, "No contact found", Toast.LENGTH_LONG).show();
        db.close();
    */



    }
    public void DisplayContact(Cursor c)
    {
        TextView t = (TextView)findViewById(R.id.tekst);
        t.append("id: " + c.getString(0) + "\n" +
                "Riječ: " + c.getString(1) + "\n" +
                "Zabranjene riječi:  " + c.getString(2) + "\n");

    }


}
