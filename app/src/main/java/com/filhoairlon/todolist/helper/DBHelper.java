package com.filhoairlon.todolist.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NAME__DB = "DB_TODO";
    public  static String TABLE_TODO = "todo";



    public DBHelper(Context context) {
        super(context, NAME__DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE todo (\n" +
                "    ID int,\n" +
                "    NAME varchar(255) NOT NULL,\n" +
                "    PRIMARY KEY (ID)\n" +
                ");";

        try{
            db.execSQL(sql);
            Log.i("INFO DB", "Sucesso ao criar a tabela");
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
