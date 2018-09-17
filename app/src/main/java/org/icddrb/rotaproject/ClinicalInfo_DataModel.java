package org.icddrb.rotaproject;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class ClinicalInfo_DataModel{

        private int _PreEnrollmentID = 0;
        public int getPreEnrollmentID(){
              return _PreEnrollmentID;
         }
        public void setPreEnrollmentID(int newValue){
              _PreEnrollmentID = newValue;
         }
        private int _Fever = 0;
        public int getFever(){
              return _Fever;
         }
        public void setFever(int newValue){
              _Fever = newValue;
         }
        private int _FeverDur = 0;
        public int getFeverDur(){
              return _FeverDur;
         }
        public void setFeverDur(int newValue){
              _FeverDur = newValue;
         }
        private int _Vomit = 0;
        public int getVomit(){
              return _Vomit;
         }
        public void setVomit(int newValue){
              _Vomit = newValue;
         }
        private int _VomitDur = 0;
        public int getVomitDur(){
              return _VomitDur;
         }
        public void setVomitDur(int newValue){
              _VomitDur = newValue;
         }
        private int _OthSymp = 0;
        public int getOthSymp(){
              return _OthSymp;
         }
        public void setOthSymp(int newValue){
              _OthSymp = newValue;
         }
        private String _OthSymp1 = "";
        public String getOthSymp1(){
              return _OthSymp1;
         }
        public void setOthSymp1(String newValue){
              _OthSymp1 = newValue;
         }
        private int _OthDur1 = 0;
        public int getOthDur1(){
              return _OthDur1;
         }
        public void setOthDur1(int newValue){
              _OthDur1 = newValue;
         }
        private String _OthSymp2 = "";
        public String getOthSymp2(){
              return _OthSymp2;
         }
        public void setOthSymp2(String newValue){
              _OthSymp2 = newValue;
         }
        private int _OthDur2 = 0;
        public int getOthDur2(){
              return _OthDur2;
         }
        public void setOthDur2(int newValue){
              _OthDur2 = newValue;
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

        String TableName = "ClinicalInfo";

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
                 SQL = "Insert into "+ TableName +" (PreEnrollmentID,Fever,FeverDur,Vomit,VomitDur,OthSymp,OthSymp1,OthDur1,OthSymp2,OthDur2,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _PreEnrollmentID +"', '"+ _Fever +"', '"+ _FeverDur +"', '"+ _Vomit +"', '"+ _VomitDur +"', '"+ _OthSymp +"', '"+ _OthSymp1 +"', '"+ _OthDur1 +"', '"+ _OthSymp2 +"', '"+ _OthDur2 +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,PreEnrollmentID = '"+ _PreEnrollmentID +"',Fever = '"+ _Fever +"',FeverDur = '"+ _FeverDur +"',Vomit = '"+ _Vomit +"',VomitDur = '"+ _VomitDur +"',OthSymp = '"+ _OthSymp +"',OthSymp1 = '"+ _OthSymp1 +"',OthDur1 = '"+ _OthDur1 +"',OthSymp2 = '"+ _OthSymp2 +"',OthDur2 = '"+ _OthDur2 +"'  Where PreEnrollmentID='"+ _PreEnrollmentID +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<ClinicalInfo_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<ClinicalInfo_DataModel> data = new ArrayList<ClinicalInfo_DataModel>();
            ClinicalInfo_DataModel d = new ClinicalInfo_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new ClinicalInfo_DataModel();
                d._PreEnrollmentID = Integer.valueOf(cur.getString(cur.getColumnIndex("PreEnrollmentID")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PreEnrollmentID")));
                d._Fever = Integer.valueOf(cur.getString(cur.getColumnIndex("Fever")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Fever")));
                d._FeverDur = Integer.valueOf(cur.getString(cur.getColumnIndex("FeverDur")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("FeverDur")));
                d._Vomit = Integer.valueOf(cur.getString(cur.getColumnIndex("Vomit")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Vomit")));
                d._VomitDur = Integer.valueOf(cur.getString(cur.getColumnIndex("VomitDur")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("VomitDur")));
                d._OthSymp = Integer.valueOf(cur.getString(cur.getColumnIndex("OthSymp")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OthSymp")));
                d._OthSymp1 = cur.getString(cur.getColumnIndex("OthSymp1"));
                d._OthDur1 = Integer.valueOf(cur.getString(cur.getColumnIndex("OthDur1")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OthDur1")));
                d._OthSymp2 = cur.getString(cur.getColumnIndex("OthSymp2"));
                d._OthDur2 = Integer.valueOf(cur.getString(cur.getColumnIndex("OthDur2")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("OthDur2")));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }