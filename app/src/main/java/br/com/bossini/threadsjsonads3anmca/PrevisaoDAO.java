package br.com.bossini.threadsjsonads3anmca;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodrigo on 09/04/18.
 */

public class PrevisaoDAO {

    private Context context;
    public PrevisaoDAO (Context context){
        this.context = context;
    }


    public void atualizar (Previsao previsao){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("min", previsao.getMin());
        cv.put ("max", previsao.getMax());
        cv.put ("descricao", previsao.getDescricao());
        /*String clausulaWhere = "id = ?";
        String [] paramWhere = new String[1];
        paramWhere[0] = Integer.toString(previsao.getId());*/
        db.update("previsao",
                cv, "id = ?",
                new String []{Integer.toString(previsao.getId())});
        db.close();
        dbHelper.close();
    }

    public void apagar (Previsao previsao){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //DELETE FROM previsao WHERE id = ?
        //ps.setInt(1, previsao.getId());
        String [] parametros = new String [1];
        parametros[0] = Integer.toString(previsao.getId());
        db.delete("previsao", "id = ?", parametros);
        db.close();
        dbHelper.close();
    }



    public long inserir (Previsao previsao){
        ContentValues cv = new ContentValues ();
        cv.put("min", previsao.getMin());
        cv.put ("max", previsao.getMax());
        cv.put ("descricao", previsao.getDescricao());
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long id = db.insert("previsao", null, cv);
        db.close();
        return id;
    }



    public List<Previsao> listar (){
        List <Previsao> previsoes = new ArrayList<>();
        DBHelper helper = new DBHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query("previsao", null, null, null, null, null, null);
        while (cursor.moveToNext()){
            int ondeEstaOId = cursor.getColumnIndexOrThrow("id");
            int id = cursor.getInt(ondeEstaOId);
            int ondeEstaOMin = cursor.getColumnIndexOrThrow("min");
            double min = cursor.getDouble(ondeEstaOMin);
            int ondeEstaOMax = cursor.getColumnIndexOrThrow("max");
            double max = cursor.getDouble(ondeEstaOMax);
            int ondeEstaADescricao =
                    cursor.getColumnIndexOrThrow("descricao");
            String descricao = cursor.getString(ondeEstaADescricao);
            Previsao p = new Previsao (id, min, max, descricao);
            previsoes.add(p);
        }
        cursor.close();
        db.close();
        helper.close();
        return previsoes;
    }
}
