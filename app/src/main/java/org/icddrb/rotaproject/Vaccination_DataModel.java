package org.icddrb.rotaproject;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class Vaccination_DataModel{

        private int _PreEnrollmentID = 0;
        public int getPreEnrollmentID(){
              return _PreEnrollmentID;
         }
        public void setPreEnrollmentID(int newValue){
              _PreEnrollmentID = newValue;
         }
        private int _ReceiVacc = 0;
        public int getReceiVacc(){
              return _ReceiVacc;
         }
        public void setReceiVacc(int newValue){
              _ReceiVacc = newValue;
         }
        private int _NumDose = 0;
        public int getNumDose(){
              return _NumDose;
         }
        public void setNumDose(int newValue){
              _NumDose = newValue;
         }
        private int _SourInf = 0;
        public int getSourInf(){
              return _SourInf;
         }
        public void setSourInf(int newValue){
              _SourInf = newValue;
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

        String TableName = "Vaccination";

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
                 SQL = "Insert into "+ TableName +" (PreEnrollmentID,ReceiVacc,NumDose,SourInf,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _PreEnrollmentID +"', '"+ _ReceiVacc +"', '"+ _NumDose +"', '"+ _SourInf +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,PreEnrollmentID = '"+ _PreEnrollmentID +"',ReceiVacc = '"+ _ReceiVacc +"',NumDose = '"+ _NumDose +"',SourInf = '"+ _SourInf +"'  Where PreEnrollmentID='"+ _PreEnrollmentID +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<Vaccination_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<Vaccination_DataModel> data = new ArrayList<Vaccination_DataModel>();
            Vaccination_DataModel d = new Vaccination_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new Vaccination_DataModel();
                d._PreEnrollmentID = Integer.valueOf(cur.getString(cur.getColumnIndex("PreEnrollmentID")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PreEnrollmentID")));
                d._ReceiVacc = Integer.valueOf(cur.getString(cur.getColumnIndex("ReceiVacc")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("ReceiVacc")));
                d._NumDose = Integer.valueOf(cur.getString(cur.getColumnIndex("NumDose")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("NumDose")));
                d._SourInf = Integer.valueOf(cur.getString(cur.getColumnIndex("SourInf")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SourInf")));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }