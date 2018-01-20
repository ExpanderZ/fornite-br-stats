package com.example.a031310.fornite;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends Activity {
    protected TextView textViewName, textViewLife, WinsLF, Wins, KillsLF, Kills, KDLF, winperLF, KillsKD, MatchesLF, Matches, WinPercentage, Solo, WinsSolo1, WinsSolo, MatchesSolo, MatchesSolo1, KillsSolo, KillsSolo1, KillsKDSolo, KDSolo1, WinPercentageSolo, WinPercentageSolo1, Duo,
            WinsDuo, WinsDuo1, MatchesDuo, MatchesDuo1, KillsDuo, KillsDuo1, KillsKDDuo, KDDuo1, WinPercentageDuo, WinPercentageDuo1, Squad, WinsSquad, WinsSquad1, MatchesSquad, MatchesSquad1, KillsSquad, KillsSquad1, KillsKDSquad, KDSquad1, WinPercentageSquad, WinPercentageSquad1;
    protected String nickname;
    protected AdaptadorBaseDados a;
    protected Button deletePlayer;
    List<String> nickNames;
    List<Integer> ids;
    AsyncGenerator backgroundTask;
    Activity activity;

    String nome, winsLF, matchesLF, killsLF, kdLF, winperlf, winssolo, killssolo, matchessolo, kdsolo, winpersolo, winsduo, killsduo, matchesduo, kdduo, winperduo, winssquad, killssquad, kdsquad, winpersquad, matchessquad;

    protected void onStart() {
        super.onStart();
        a = new AdaptadorBaseDados(this).open();

        ids = new ArrayList<Integer>();
        nickNames = new ArrayList<String>();

    }

    protected void onStop() {
        super.onStop();
        a.close();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewLife = (TextView) findViewById(R.id.textViewLife);
        WinsLF = (TextView) findViewById(R.id.WinsLF);
        Wins = (TextView) findViewById(R.id.Wins);
        KillsLF = (TextView) findViewById(R.id.KillsLF);
        Kills = (TextView) findViewById(R.id.Kills);
        KDLF = (TextView) findViewById(R.id.KDLF);
        winperLF = (TextView) findViewById(R.id.winperLF);
        KillsKD = (TextView) findViewById(R.id.KillsKD);
        MatchesLF = (TextView) findViewById(R.id.MatchesLF);
        Matches = (TextView) findViewById(R.id.Matches);
        WinPercentage = (TextView) findViewById(R.id.WinPercentage);
        Solo = (TextView) findViewById(R.id.Solo);
        WinsSolo1 = (TextView) findViewById(R.id.WinsSolo1);
        WinsSolo = (TextView) findViewById(R.id.WinsSolo);
        MatchesSolo = (TextView) findViewById(R.id.MatchesSolo);
        KillsSolo = (TextView) findViewById(R.id.KillsSolo);
        KillsKDSolo = (TextView) findViewById(R.id.KillsKDSolo);
        WinPercentageSolo = (TextView) findViewById(R.id.WinPercentageSolo);
        Duo = (TextView) findViewById(R.id.Duo);
        WinsDuo = (TextView) findViewById(R.id.WinsDuo);
        WinsDuo1 = (TextView) findViewById(R.id.WinsDuo1);
        MatchesDuo = (TextView) findViewById(R.id.MatchesDuo);
        MatchesDuo1 = (TextView) findViewById(R.id.MatchesDuo1);
        KillsDuo = (TextView) findViewById(R.id.KillsDuo);
        KillsDuo1 = (TextView) findViewById(R.id.KillsDuo1);
        KillsKDDuo = (TextView) findViewById(R.id.KillsKDDuo);
        KDDuo1 = (TextView) findViewById(R.id.KDDuo1);
        WinPercentageDuo = (TextView) findViewById(R.id.WinPercentageDuo);
        WinPercentageDuo1 = (TextView) findViewById(R.id.WinPercentageDuo1);
        Squad = (TextView) findViewById(R.id.Squad);
        WinsSquad = (TextView) findViewById(R.id.WinsSquad);
        WinsSquad1 = (TextView) findViewById(R.id.WinsSquad1);
        MatchesSquad = (TextView) findViewById(R.id.MatchesSquad);
        MatchesSquad1 = (TextView) findViewById(R.id.MatchesSquad1);
        KillsSquad = (TextView) findViewById(R.id.KillsSquad);
        KillsSquad1 = (TextView) findViewById(R.id.KillsSquad1);
        KillsKDSquad = (TextView) findViewById(R.id.KillsKDSquad);
        KDSquad1 = (TextView) findViewById(R.id.KDSquad1);
        WinPercentageSquad = (TextView) findViewById(R.id.WinPercentageSquad);
        WinPercentageSquad1 = (TextView) findViewById(R.id.WinPercentageSquad1);
        KillsSolo1 = (TextView) findViewById(R.id.KillsSolo1);
        MatchesSolo1 = (TextView) findViewById(R.id.MatchesSolo1);
        KDSolo1 = (TextView) findViewById(R.id.KDSolo1);
        WinPercentageSolo1 = (TextView) findViewById(R.id.WinPercentageSolo1);

        deletePlayer = (Button) findViewById(R.id.deletePlayer);

        Intent x = getIntent();
        nickname = x.getStringExtra("aTag");


        activity = this;

        textViewName.setText(nickname);

        backgroundTask = new AsyncGenerator();
        backgroundTask.execute();
    }

    private final class AsyncGenerator extends AsyncTask<Void, Void, Void> {
        boolean error;

        public AsyncGenerator() {

        }

        protected Void doInBackground(Void... args) {
            try {
                Document document = Jsoup.connect("https://www.stormshield.one/pvp/stats/" + nickname).get();



                Element verificar = document.select("body > div.alerts-row.pvp > div > div > div > div > h2").first();

                if (verificar == null) {
                    error = true;
                } else {
                    nome = document.select("body > div.alerts-row.pvp > div > div > div > div > h2").text();
                    winsLF = document.select("body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-4 > div:nth-child(1) > div.post > div:nth-child(2) > div:nth-child(1) > a > div.istat__value").text();
                    killsLF = document.select("body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-4 > div:nth-child(1) > div.post > div:nth-child(3) > div:nth-child(1) > div > a > div.stat__value").text();
                    matchesLF = document.select("body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-4 > div:nth-child(1) > div.post > div:nth-child(3) > div:nth-child(5) > div > a > div.stat__value").text();
                    kdLF = document.select("body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-4 > div:nth-child(1) > div.post > div:nth-child(3) > div:nth-child(2) > div > a > div.stat__value").text();
                    winperlf = document.select("body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-4 > div:nth-child(1) > div.post > div:nth-child(3) > div:nth-child(6) > div > a > div.stat__value").text();
                    winssolo = document.select("body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-8 > div:nth-child(1) > div:nth-child(2) > div > div.post > div:nth-child(2) > div:nth-child(2) > a > div.istat__value").text();
                    killssolo = document.select("body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-8 > div:nth-child(1) > div:nth-child(2) > div > div.post > div:nth-child(3) > div:nth-child(1) > div > a > div.stat__value").text();
                    matchessolo = document.select("body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-8 > div:nth-child(1) > div:nth-child(2) > div > div.post > div:nth-child(3) > div:nth-child(5) > div > a > div.stat__value").text();
                    kdsolo = document.select("body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-8 > div:nth-child(1) > div:nth-child(2) > div > div.post > div:nth-child(3) > div:nth-child(2) > div > a > div.stat__value").text();
                    winpersolo = document.select("body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-8 > div:nth-child(1) > div:nth-child(2) > div > div.post > div:nth-child(3) > div:nth-child(6) > div > a > div.stat__value").text();
                    winsduo = document.select("body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-8 > div:nth-child(1) > div:nth-child(3) > div > div.post > div:nth-child(3) > div:nth-child(1) > div > a > div.stat__value").text();
                    killsduo = document.select(" body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-8 > div:nth-child(1) > div:nth-child(3) > div > div.post > div:nth-child(2) > div:nth-child(2) > a > div.istat__value").text();
                    matchesduo = document.select("body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-8 > div:nth-child(1) > div:nth-child(3) > div > div.post > div:nth-child(3) > div:nth-child(5) > div > a > div.stat__value").text();
                    kdduo = document.select("body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-8 > div:nth-child(1) > div:nth-child(3) > div > div.post > div:nth-child(3) > div:nth-child(2) > div > a > div.stat__value").text();
                    winperduo = document.select("body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-8 > div:nth-child(1) > div:nth-child(3) > div > div.post > div:nth-child(3) > div:nth-child(6) > div > a > div.stat__value").text();
                    winssquad = document.select("body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-8 > div:nth-child(1) > div:nth-child(4) > div > div.post > div:nth-child(2) > div:nth-child(2) > a > div.istat__value").text();
                    killssquad = document.select("body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-8 > div:nth-child(1) > div:nth-child(4) > div > div.post > div:nth-child(3) > div:nth-child(1) > div > a > div.stat__value").text();
                    matchessquad = document.select("body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-8 > div:nth-child(1) > div:nth-child(4) > div > div.post > div:nth-child(3) > div:nth-child(5) > div > a > div.stat__value").text();
                    kdsquad = document.select("body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-8 > div:nth-child(1) > div:nth-child(4) > div > div.post > div:nth-child(3) > div:nth-child(2) > div > a > div.stat__value").text();
                    winpersquad = document.select("body > div.container.pvp > div:nth-child(1) > div.col-12.col-md-8 > div:nth-child(1) > div:nth-child(4) > div > div.post > div:nth-child(3) > div:nth-child(6) > div > a > div.stat__value").text();
                }

            } catch (IOException e) {
                Toast.makeText(activity, "Falha de internet", Toast.LENGTH_SHORT).show();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (error) {
                Toast.makeText(activity, "Jogador não existe", Toast.LENGTH_SHORT).show();
            }

            textViewName.setText(nome);
            WinsLF.setText("" + winsLF);
            KillsLF.setText("" + killsLF);
            MatchesLF.setText("" + matchesLF);
            KDLF.setText("" + kdLF);
            winperLF.setText("" + winperlf);
            WinsSolo1.setText("" + winssolo);
            KillsSolo1.setText("" + killssolo);
            MatchesSolo1.setText("" + matchessolo);
            KDSolo1.setText("" + kdsolo);
            WinPercentageSolo1.setText("" + winpersolo);
            WinsDuo1.setText("" + winsduo);
            KillsDuo1.setText("" + killsduo);
            MatchesDuo1.setText("" + matchesduo);
            KDDuo1.setText("" + kdduo);
            WinPercentageDuo1.setText("" + winperduo);
            WinsSquad1.setText("" + winssquad);
            KillsSquad1.setText("" + killssquad);
            MatchesSquad1.setText("" + matchessquad);
            KDSquad1.setText("" + kdsquad);
            WinPercentageSquad1.setText("" + winpersquad);

            deletePlayer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    a.deletePlayer(nickname);
                    finish();
                }
            });

        }
    }

}