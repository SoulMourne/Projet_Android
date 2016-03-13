package com.firstapp.android.whacamole.score;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.firstapp.android.whacamole.score.Score;

import java.util.ArrayList;

/**
 * Created by Jean-Paul on 13/03/2016.
 */
public class Scores extends SQLiteOpenHelper
{
    ArrayList<Score> scores;

    private static final String TABLE = "SCORES";
    private static final String PSEUDO = "PSEUDO";
    private static final String SCORE = "SCORE";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE
            + " (" + PSEUDO + "TEXT NOT NULL, " + SCORE + "INTEGER NOT NULL);";

    public Scores(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
        this.scores = new ArrayList<>();
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE " + TABLE);
        this.onCreate(db);
    }
}
