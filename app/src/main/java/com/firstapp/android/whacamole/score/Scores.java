package com.firstapp.android.whacamole.score;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    private static final String POINTS = "POINTS";
    private static final String ID =  "ID";

    private static final int NUM_ID = 1;
    private static final int NUM_PSEUDO = 2;
    private static final int NUM_POINTS = 3;

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE
            + " (" + ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " + PSEUDO + "TEXT NOT NULL, " + POINTS + "INTEGER NOT NULL);";

    private SQLiteDatabase bd;

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

    public void openForWrite()
    {
        bd = this.getWritableDatabase();
    }

    public void openForRead()
    {
        bd = this.getReadableDatabase();
    }

    public void close()
    {
        bd.close();
    }

    public SQLiteDatabase getBD()
    {
        return this.bd;
    }

    public long insertScore(Score score)
    {
        ContentValues  content = new ContentValues();
        content.put(PSEUDO, score.getPseudo());
        content.put(POINTS, score.getPoints());
        return bd.insert(TABLE, null, content);
    }

    public Score getScore(int id)
    {
        Cursor c = bd.query(TABLE,
                new String[] {PSEUDO, POINTS},
                null,
                null,
                null,
                null,
                POINTS);
        return cursorToScore(c);
    }

    public Score cursorToScore(Cursor c)
    {
        if (c.getCount() == 0)
        {
            c.close();
            return null;
        }

        Score score = new Score();
        score.setPseudo(c.getString(NUM_PSEUDO));
        score.setPoints(c.getInt(NUM_POINTS));
        c.close();
        return score;
    }
}
