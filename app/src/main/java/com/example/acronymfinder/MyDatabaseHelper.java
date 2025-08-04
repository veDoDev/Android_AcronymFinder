package com.example.acronymfinder;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyDatabaseHelper extends SQLiteOpenHelper
{
    private static final String DB_NAME = "acronyms.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "acronyms";
    private Context context;

    public MyDatabaseHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // Create the acronyms table
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "acronym TEXT, " +
                "fullform TEXT)";
        db.execSQL(createTable);

        // Insert bulk data
        insertAcronymsFromFile(db);
    }

    private void insertAcronymsFromFile(SQLiteDatabase db)
    {
        try {
            InputStream is = context.getAssets().open("acronyms.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            db.beginTransaction();
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",", 2);
                if (parts.length == 2)
                {
                    String acronym = parts[0].trim();
                    String fullform = parts[1].trim();
                    db.execSQL("INSERT INTO " + TABLE_NAME + " (acronym, fullform) VALUES (?, ?)",
                            new Object[]{acronym, fullform});
                }
            }
            db.setTransactionSuccessful();
            db.endTransaction();
            reader.close();
        } catch (Exception e) {
            Log.e("DBHelper", "Error loading acronyms: " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // Drop and recreate table if structure changes
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public String getFullForm(String acronymQuery)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String fullForm = null;

        Cursor cursor = db.rawQuery("SELECT fullform FROM acronyms WHERE acronym = ?", new String[]{acronymQuery});

        if (cursor.moveToFirst())
            fullForm = cursor.getString(0);


        cursor.close();
        db.close();
        return fullForm;
    }

    public String getRandomAcronym()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT acronym FROM acronyms ORDER BY RANDOM() LIMIT 1", null);

        if (cursor.moveToFirst())
        {
            String acronym = cursor.getString(0);
            cursor.close();
            return acronym;
        }
        else
        {
            cursor.close();
            return null;
        }
    }


}
