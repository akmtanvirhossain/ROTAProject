package org.icddrb.rotaproject;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class Serumelectro_DataModel{

        private int _PreEnrollmentID = 0;
        public int getPreEnrollmentID(){
              return _PreEnrollmentID;
         }
        public void setPreEnrollmentID(int newValue){
              _PreEnrollmentID = newValue;
         }
        private int _SerElectro1 = 0;
        public int getSerElectro1(){
              return _SerElectro1;
         }
        public void setSerElectro1(int newValue){
              _SerElectro1 = newValue;
         }
        private String _TDateSer1 = "";
        public String getTDateSer1(){
              return _TDateSer1;
         }
        public void setTDateSer1(String newValue){
              _TDateSer1 = newValue;
         }
        private double _Sodium1 = 0.0;
        public double getSodium1(){
              return _Sodium1;
         }
        public void setSodium1(double newValue){
              _Sodium1 = newValue;
         }
        private int _Sodium1Not = 0;
        public int getSodium1Not(){
              return _Sodium1Not;
         }
        public void setSodium1Not(int newValue){
              _Sodium1Not = newValue;
         }
        private double _Potassium1 = 0.0;
        public double getPotassium1(){
              return _Potassium1;
         }
        public void setPotassium1(double newValue){
              _Potassium1 = newValue;
         }
        private int _Potassium1Not = 0;
        public int getPotassium1Not(){
              return _Potassium1Not;
         }
        public void setPotassium1Not(int newValue){
              _Potassium1Not = newValue;
         }
        private double _Chloride1 = 0.0;
        public double getChloride1(){
              return _Chloride1;
         }
        public void setChloride1(double newValue){
              _Chloride1 = newValue;
         }
        private int _Cloride1Not = 0;
        public int getCloride1Not(){
              return _Cloride1Not;
         }
        public void setCloride1Not(int newValue){
              _Cloride1Not = newValue;
         }
        private int _SerElectro2 = 0;
        public int getSerElectro2(){
              return _SerElectro2;
         }
        public void setSerElectro2(int newValue){
              _SerElectro2 = newValue;
         }
        private String _TDateSer2 = "";
        public String getTDateSer2(){
              return _TDateSer2;
         }
        public void setTDateSer2(String newValue){
              _TDateSer2 = newValue;
         }
        private double _Sodium2 = 0.0;
        public double getSodium2(){
              return _Sodium2;
         }
        public void setSodium2(double newValue){
              _Sodium2 = newValue;
         }
        private int _Sodium2Not = 0;
        public int getSodium2Not(){
              return _Sodium2Not;
         }
        public void setSodium2Not(int newValue){
              _Sodium2Not = newValue;
         }
        private double _Potassium2 = 0.0;
        public double getPotassium2(){
              return _Potassium2;
         }
        public void setPotassium2(double newValue){
              _Potassium2 = newValue;
         }
        private int _Potassium2Not = 0;
        public int getPotassium2Not(){
              return _Potassium2Not;
         }
        public void setPotassium2Not(int newValue){
              _Potassium2Not = newValue;
         }
        private double _Chloride2 = 0.0;
        public double getChloride2(){
              return _Chloride2;
         }
        public void setChloride2(double newValue){
              _Chloride2 = newValue;
         }
        private int _Chloride2Not = 0;
        public int getChloride2Not(){
              return _Chloride2Not;
         }
        public void setChloride2Not(int newValue){
              _Chloride2Not = newValue;
         }
        private String _StartTime = "";
        public void setStartTime(String newValue){
              _StartTime = newValue;
         }
        private String _EndTime = "";
        public void setEndTime(String newValue){
              _EndTime = newValue;
         }
        private String _DeviceID = "";
        public void setDeviceID(String newValue){
              _DeviceID = newValue;
         }
        private String _EntryUser = "";
        public void setEntryUser(String newValue){
              _EntryUser = newValue;
         }
        private String _Lat = "";
        public void setLat(String newValue){
              _Lat = newValue;
         }
        private String _Lon = "";
        public void setLon(String newValue){
              _Lon = newValue;
         }
        private String _EnDt = "";
        public void setEnDt(String newValue){
              _EnDt = newValue;
         }
        private int _Upload = 2;
        private String _modifyDate = "";
        public void setmodifyDate(String newValue){
        _modifyDate = newValue;
        }

        String TableName = "Serumelectro";

        public String SaveUpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
            {
                 if(C.Existence("Select * from "+ TableName +"  Where PreEnrollmentID='"+ _PreEnrollmentID +"' "))
                    response = UpdateData(context);
                 else
                    response = SaveData(context);
            }
            catch(Exception  e)
            {
                 response = e.getMessage();
            }
           return response;
        }
        Connection C;

        private String SaveData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
              {
                 SQL = "Insert into "+ TableName +" (PreEnrollmentID,SerElectro1,TDateSer1,Sodium1,Sodium1Not,Potassium1,Potassium1Not,Chloride1,Cloride1Not,SerElectro2,TDateSer2,Sodium2,Sodium2Not,Potassium2,Potassium2Not,Chloride2,Chloride2Not,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _PreEnrollmentID +"', '"+ _SerElectro1 +"', '"+ _TDateSer1 +"', '"+ _Sodium1 +"', '"+ _Sodium1Not +"', '"+ _Potassium1 +"', '"+ _Potassium1Not +"', '"+ _Chloride1 +"', '"+ _Cloride1Not +"', '"+ _SerElectro2 +"', '"+ _TDateSer2 +"', '"+ _Sodium2 +"', '"+ _Sodium2Not +"', '"+ _Potassium2 +"', '"+ _Potassium2Not +"', '"+ _Chloride2 +"', '"+ _Chloride2Not +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }

        private String UpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
              {
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,PreEnrollmentID = '"+ _PreEnrollmentID +"',SerElectro1 = '"+ _SerElectro1 +"',TDateSer1 = '"+ _TDateSer1 +"',Sodium1 = '"+ _Sodium1 +"',Sodium1Not = '"+ _Sodium1Not +"',Potassium1 = '"+ _Potassium1 +"',Potassium1Not = '"+ _Potassium1Not +"',Chloride1 = '"+ _Chloride1 +"',Cloride1Not = '"+ _Cloride1Not +"',SerElectro2 = '"+ _SerElectro2 +"',TDateSer2 = '"+ _TDateSer2 +"',Sodium2 = '"+ _Sodium2 +"',Sodium2Not = '"+ _Sodium2Not +"',Potassium2 = '"+ _Potassium2 +"',Potassium2Not = '"+ _Potassium2Not +"',Chloride2 = '"+ _Chloride2 +"',Chloride2Not = '"+ _Chloride2Not +"'  Where PreEnrollmentID='"+ _PreEnrollmentID +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<Serumelectro_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<Serumelectro_DataModel> data = new ArrayList<Serumelectro_DataModel>();
            Serumelectro_DataModel d = new Serumelectro_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new Serumelectro_DataModel();
                d._PreEnrollmentID = Integer.valueOf(cur.getString(cur.getColumnIndex("PreEnrollmentID")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PreEnrollmentID")));
                d._SerElectro1 = Integer.valueOf(cur.getString(cur.getColumnIndex("SerElectro1")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SerElectro1")));
                d._TDateSer1 = cur.getString(cur.getColumnIndex("TDateSer1"));
                d._Sodium1 = Double.parseDouble(cur.getString(cur.getColumnIndex("Sodium1")).length() == 0 ? "0.0" : cur.getString(cur.getColumnIndex("Sodium1")));
                d._Sodium1Not = Integer.valueOf(cur.getString(cur.getColumnIndex("Sodium1Not")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Sodium1Not")));
                d._Potassium1 = Double.parseDouble(cur.getString(cur.getColumnIndex("Potassium1")).length() == 0 ? "0.0" : cur.getString(cur.getColumnIndex("Potassium1")));
                d._Potassium1Not = Integer.valueOf(cur.getString(cur.getColumnIndex("Potassium1Not")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Potassium1Not")));
                d._Chloride1 = Double.parseDouble(cur.getString(cur.getColumnIndex("Chloride1")).length() == 0 ? "0.0" : cur.getString(cur.getColumnIndex("Chloride1")));
                d._Cloride1Not = Integer.valueOf(cur.getString(cur.getColumnIndex("Cloride1Not")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Cloride1Not")));
                d._SerElectro2 = Integer.valueOf(cur.getString(cur.getColumnIndex("SerElectro2")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SerElectro2")));
                d._TDateSer2 = cur.getString(cur.getColumnIndex("TDateSer2"));
                d._Sodium2 = Double.parseDouble(cur.getString(cur.getColumnIndex("Sodium2")).length() == 0 ? "0.0" : cur.getString(cur.getColumnIndex("Sodium2")));
                d._Sodium2Not = Integer.valueOf(cur.getString(cur.getColumnIndex("Sodium2Not")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Sodium2Not")));
                d._Potassium2 = Double.parseDouble(cur.getString(cur.getColumnIndex("Potassium2")).length() == 0 ? "0.0" : cur.getString(cur.getColumnIndex("Potassium2")));
                d._Potassium2Not = Integer.valueOf(cur.getString(cur.getColumnIndex("Potassium2Not")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Potassium2Not")));
                d._Chloride2 = Double.parseDouble(cur.getString(cur.getColumnIndex("Chloride2")).length() == 0 ? "0.0" : cur.getString(cur.getColumnIndex("Chloride2")));
                d._Chloride2Not = Integer.valueOf(cur.getString(cur.getColumnIndex("Chloride2Not")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Chloride2Not")));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }