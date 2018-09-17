package org.icddrb.rotaproject;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class Discharge_DataModel{

        private int _PreEnrollmentID = 0;
        public int getPreEnrollmentID(){
              return _PreEnrollmentID;
         }
        public void setPreEnrollmentID(int newValue){
              _PreEnrollmentID = newValue;
         }
        private String _DisDate = "";
        public String getDisDate(){
              return _DisDate;
         }
        public void setDisDate(String newValue){
              _DisDate = newValue;
         }
        private String _FinalDiag1 = "";
        public String getFinalDiag1(){
              return _FinalDiag1;
         }
        public void setFinalDiag1(String newValue){
              _FinalDiag1 = newValue;
         }
        private String _FinalDiag2 = "";
        public String getFinalDiag2(){
              return _FinalDiag2;
         }
        public void setFinalDiag2(String newValue){
              _FinalDiag2 = newValue;
         }
        private String _FinalDiag3 = "";
        public String getFinalDiag3(){
              return _FinalDiag3;
         }
        public void setFinalDiag3(String newValue){
              _FinalDiag3 = newValue;
         }
        private String _FinalDiag4 = "";
        public String getFinalDiag4(){
              return _FinalDiag4;
         }
        public void setFinalDiag4(String newValue){
              _FinalDiag4 = newValue;
         }
        private String _FinalDiag5 = "";
        public String getFinalDiag5(){
              return _FinalDiag5;
         }
        public void setFinalDiag5(String newValue){
              _FinalDiag5 = newValue;
         }
        private int _HOutcome = 0;
        public int getHOutcome(){
              return _HOutcome;
         }
        public void setHOutcome(int newValue){
              _HOutcome = newValue;
         }
        private int _IntFluid = 0;
        public int getIntFluid(){
              return _IntFluid;
         }
        public void setIntFluid(int newValue){
              _IntFluid = newValue;
         }
        private int _Antibiotic = 0;
        public int getAntibiotic(){
              return _Antibiotic;
         }
        public void setAntibiotic(int newValue){
              _Antibiotic = newValue;
         }
        private String _Antibiotic1 = "";
        public String getAntibiotic1(){
              return _Antibiotic1;
         }
        public void setAntibiotic1(String newValue){
              _Antibiotic1 = newValue;
         }
        private String _SDateAnti1 = "";
        public String getSDateAnti1(){
              return _SDateAnti1;
         }
        public void setSDateAnti1(String newValue){
              _SDateAnti1 = newValue;
         }
        private String _EDateAnti1 = "";
        public String getEDateAnti1(){
              return _EDateAnti1;
         }
        public void setEDateAnti1(String newValue){
              _EDateAnti1 = newValue;
         }
        private String _Antibiotic2 = "";
        public String getAntibiotic2(){
              return _Antibiotic2;
         }
        public void setAntibiotic2(String newValue){
              _Antibiotic2 = newValue;
         }
        private String _SDateAnti2 = "";
        public String getSDateAnti2(){
              return _SDateAnti2;
         }
        public void setSDateAnti2(String newValue){
              _SDateAnti2 = newValue;
         }
        private String _EDateAnti2 = "";
        public String getEDateAnti2(){
              return _EDateAnti2;
         }
        public void setEDateAnti2(String newValue){
              _EDateAnti2 = newValue;
         }
        private String _Antibiotic3 = "";
        public String getAntibiotic3(){
              return _Antibiotic3;
         }
        public void setAntibiotic3(String newValue){
              _Antibiotic3 = newValue;
         }
        private String _SDateAnti3 = "";
        public String getSDateAnti3(){
              return _SDateAnti3;
         }
        public void setSDateAnti3(String newValue){
              _SDateAnti3 = newValue;
         }
        private String _EDateAnti3 = "";
        public String getEDateAnti3(){
              return _EDateAnti3;
         }
        public void setEDateAnti3(String newValue){
              _EDateAnti3 = newValue;
         }
        private String _Antibiotic4 = "";
        public String getAntibiotic4(){
              return _Antibiotic4;
         }
        public void setAntibiotic4(String newValue){
              _Antibiotic4 = newValue;
         }
        private String _SDateAnti4 = "";
        public String getSDateAnti4(){
              return _SDateAnti4;
         }
        public void setSDateAnti4(String newValue){
              _SDateAnti4 = newValue;
         }
        private String _EDateAnti4 = "";
        public String getEDateAnti4(){
              return _EDateAnti4;
         }
        public void setEDateAnti4(String newValue){
              _EDateAnti4 = newValue;
         }
        private String _Antibiotic5 = "";
        public String getAntibiotic5(){
              return _Antibiotic5;
         }
        public void setAntibiotic5(String newValue){
              _Antibiotic5 = newValue;
         }
        private String _SDateAnti5 = "";
        public String getSDateAnti5(){
              return _SDateAnti5;
         }
        public void setSDateAnti5(String newValue){
              _SDateAnti5 = newValue;
         }
        private String _EDateAnti5 = "";
        public String getEDateAnti5(){
              return _EDateAnti5;
         }
        public void setEDateAnti5(String newValue){
              _EDateAnti5 = newValue;
         }
        private String _DtEnrolled = "";
        public String getDtEnrolled(){
              return _DtEnrolled;
         }
        public void setDtEnrolled(String newValue){
              _DtEnrolled = newValue;
         }
        private String _TmEnrolled = "";
        public String getTmEnrolled(){
              return _TmEnrolled;
         }
        public void setTmEnrolled(String newValue){
              _TmEnrolled = newValue;
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

        String TableName = "Discharge";

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
                 SQL = "Insert into "+ TableName +" (PreEnrollmentID,DisDate,FinalDiag1,FinalDiag2,FinalDiag3,FinalDiag4,FinalDiag5,HOutcome,IntFluid,Antibiotic,Antibiotic1,SDateAnti1,EDateAnti1,Antibiotic2,SDateAnti2,EDateAnti2,Antibiotic3,SDateAnti3,EDateAnti3,Antibiotic4,SDateAnti4,EDateAnti4,Antibiotic5,SDateAnti5,EDateAnti5,DtEnrolled,TmEnrolled,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _PreEnrollmentID +"', '"+ _DisDate +"', '"+ _FinalDiag1 +"', '"+ _FinalDiag2 +"', '"+ _FinalDiag3 +"', '"+ _FinalDiag4 +"', '"+ _FinalDiag5 +"', '"+ _HOutcome +"', '"+ _IntFluid +"', '"+ _Antibiotic +"', '"+ _Antibiotic1 +"', '"+ _SDateAnti1 +"', '"+ _EDateAnti1 +"', '"+ _Antibiotic2 +"', '"+ _SDateAnti2 +"', '"+ _EDateAnti2 +"', '"+ _Antibiotic3 +"', '"+ _SDateAnti3 +"', '"+ _EDateAnti3 +"', '"+ _Antibiotic4 +"', '"+ _SDateAnti4 +"', '"+ _EDateAnti4 +"', '"+ _Antibiotic5 +"', '"+ _SDateAnti5 +"', '"+ _EDateAnti5 +"', '"+ _DtEnrolled +"', '"+ _TmEnrolled +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,PreEnrollmentID = '"+ _PreEnrollmentID +"',DisDate = '"+ _DisDate +"',FinalDiag1 = '"+ _FinalDiag1 +"',FinalDiag2 = '"+ _FinalDiag2 +"',FinalDiag3 = '"+ _FinalDiag3 +"',FinalDiag4 = '"+ _FinalDiag4 +"',FinalDiag5 = '"+ _FinalDiag5 +"',HOutcome = '"+ _HOutcome +"',IntFluid = '"+ _IntFluid +"',Antibiotic = '"+ _Antibiotic +"',Antibiotic1 = '"+ _Antibiotic1 +"',SDateAnti1 = '"+ _SDateAnti1 +"',EDateAnti1 = '"+ _EDateAnti1 +"',Antibiotic2 = '"+ _Antibiotic2 +"',SDateAnti2 = '"+ _SDateAnti2 +"',EDateAnti2 = '"+ _EDateAnti2 +"',Antibiotic3 = '"+ _Antibiotic3 +"',SDateAnti3 = '"+ _SDateAnti3 +"',EDateAnti3 = '"+ _EDateAnti3 +"',Antibiotic4 = '"+ _Antibiotic4 +"',SDateAnti4 = '"+ _SDateAnti4 +"',EDateAnti4 = '"+ _EDateAnti4 +"',Antibiotic5 = '"+ _Antibiotic5 +"',SDateAnti5 = '"+ _SDateAnti5 +"',EDateAnti5 = '"+ _EDateAnti5 +"',DtEnrolled = '"+ _DtEnrolled +"',TmEnrolled = '"+ _TmEnrolled +"'  Where PreEnrollmentID='"+ _PreEnrollmentID +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<Discharge_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<Discharge_DataModel> data = new ArrayList<Discharge_DataModel>();
            Discharge_DataModel d = new Discharge_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new Discharge_DataModel();
                d._PreEnrollmentID = Integer.valueOf(cur.getString(cur.getColumnIndex("PreEnrollmentID")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PreEnrollmentID")));
                d._DisDate = cur.getString(cur.getColumnIndex("DisDate"));
                d._FinalDiag1 = cur.getString(cur.getColumnIndex("FinalDiag1"));
                d._FinalDiag2 = cur.getString(cur.getColumnIndex("FinalDiag2"));
                d._FinalDiag3 = cur.getString(cur.getColumnIndex("FinalDiag3"));
                d._FinalDiag4 = cur.getString(cur.getColumnIndex("FinalDiag4"));
                d._FinalDiag5 = cur.getString(cur.getColumnIndex("FinalDiag5"));
                d._HOutcome = Integer.valueOf(cur.getString(cur.getColumnIndex("HOutcome")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HOutcome")));
                d._IntFluid = Integer.valueOf(cur.getString(cur.getColumnIndex("IntFluid")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("IntFluid")));
                d._Antibiotic = Integer.valueOf(cur.getString(cur.getColumnIndex("Antibiotic")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Antibiotic")));
                d._Antibiotic1 = cur.getString(cur.getColumnIndex("Antibiotic1"));
                d._SDateAnti1 = cur.getString(cur.getColumnIndex("SDateAnti1"));
                d._EDateAnti1 = cur.getString(cur.getColumnIndex("EDateAnti1"));
                d._Antibiotic2 = cur.getString(cur.getColumnIndex("Antibiotic2"));
                d._SDateAnti2 = cur.getString(cur.getColumnIndex("SDateAnti2"));
                d._EDateAnti2 = cur.getString(cur.getColumnIndex("EDateAnti2"));
                d._Antibiotic3 = cur.getString(cur.getColumnIndex("Antibiotic3"));
                d._SDateAnti3 = cur.getString(cur.getColumnIndex("SDateAnti3"));
                d._EDateAnti3 = cur.getString(cur.getColumnIndex("EDateAnti3"));
                d._Antibiotic4 = cur.getString(cur.getColumnIndex("Antibiotic4"));
                d._SDateAnti4 = cur.getString(cur.getColumnIndex("SDateAnti4"));
                d._EDateAnti4 = cur.getString(cur.getColumnIndex("EDateAnti4"));
                d._Antibiotic5 = cur.getString(cur.getColumnIndex("Antibiotic5"));
                d._SDateAnti5 = cur.getString(cur.getColumnIndex("SDateAnti5"));
                d._EDateAnti5 = cur.getString(cur.getColumnIndex("EDateAnti5"));
                d._DtEnrolled = cur.getString(cur.getColumnIndex("DtEnrolled"));
                d._TmEnrolled = cur.getString(cur.getColumnIndex("TmEnrolled"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }