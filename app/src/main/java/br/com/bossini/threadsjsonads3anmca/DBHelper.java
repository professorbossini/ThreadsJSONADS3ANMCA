package br.com.bossini.threadsjsonads3anmca;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rodrigo on 09/04/18.
 */

public class DBHelper extends SQLiteOpenHelper{

    private Context context;

    public DBHelper (Context context){
        super(context, "temperaturas.db",null ,1);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE previsao (id INTEGER PRIMARY KEY AUTOINCREMENT, descricao VARCHAR(200), min DOUBLE, max DOUBLE)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
