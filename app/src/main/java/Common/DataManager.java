package Common;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by TanvirHossain on 06/02/2017.
 */

public class DataManager {
    private SQLiteDatabase database;
    private Context context;

    public DataManager(Context context) {
        this.context = context;
        //database = new Connection(context).getWritableDatabase();
    }
    private void openDatabaseW() {
        database = new Connection(context).getWritableDatabase();
    }
    private void openDatabaseR() {database = new Connection(context).getReadableDatabase();}
    private void closeDatabase() {
        database.close();
    }


    private String _tableName="";
    public void setTableName(String tableName){
        _tableName = tableName;
    }

    private String _id="";
    public void setID(String id){
        _id = id;
    }

    private String _variableName="";
    public void setVariableName(String variableName){
        _variableName = variableName;
    }

    private String _data="";
    public void setData(String data){
        _data = data;
    }

    private String SaveData()
    {
        try
        {
            String SQL = "Insert into "+ _tableName +"(tableName,id,variableName,data)Values('"+ _tableName +"','"+ _id +"','"+ _variableName +"','"+ _data +"')";
            openDatabaseW();
            database.execSQL(SQL);
        }catch(Exception ex)
        {
            closeDatabase();
            return ex.getMessage();
        }
        finally {
            closeDatabase();
            return "";
        }
    }

    private String UpdateData()
    {
        try
        {
            String SQL = "Update "+ _tableName +" Set "+ _variableName +" = '"+ _data +"' where id='"+ _id +"'";
            openDatabaseW();
            database.execSQL(SQL);
        }catch(Exception ex)
        {
            closeDatabase();
            return ex.getMessage();
        }
        finally {
            closeDatabase();
            return "";
        }
    }
}
