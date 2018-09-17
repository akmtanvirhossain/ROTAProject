package org.icddrb.rotaproject;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class EmergencyScreening_DataModel{

        private int _PreEnrollmentID = 0;
        public int getPreEnrollmentID(){
              return _PreEnrollmentID;
         }
        public void setPreEnrollmentID(int newValue){
              _PreEnrollmentID = newValue;
         }
        private int _StudyID = 0;
        public int getStudyID(){
              return _StudyID;
         }
        public void setStudyID(int newValue){
              _StudyID = newValue;
         }
        private int _HosRegis = 0;
        public int getHosRegis(){
              return _HosRegis;
         }
        public void setHosRegis(int newValue){
              _HosRegis = newValue;
         }
        private String _DtEnroll = "";
        public String getDtEnroll(){
              return _DtEnroll;
         }
        public void setDtEnroll(String newValue){
              _DtEnroll = newValue;
         }
        private String _CName = "";
        public String getCName(){
              return _CName;
         }
        public void setCName(String newValue){
              _CName = newValue;
         }
        private String _CDOB = "";
        public String getCDOB(){
              return _CDOB;
         }
        public void setCDOB(String newValue){
              _CDOB = newValue;
         }
        private int _CAgeM = 0;
        public int getCAgeM(){
              return _CAgeM;
         }
        public void setCAgeM(int newValue){
              _CAgeM = newValue;
         }
        private int _CSex = 0;
        public int getCSex(){
              return _CSex;
         }
        public void setCSex(int newValue){
              _CSex = newValue;
         }
        private String _MFName = "";
        public String getMFName(){
              return _MFName;
         }
        public void setMFName(String newValue){
              _MFName = newValue;
         }
        private String _Contact1 = "";
        public String getContact1(){
              return _Contact1;
         }
        public void setContact1(String newValue){
              _Contact1 = newValue;
         }
        private int _Cont1Veri = 0;
        public int getCont1Veri(){
              return _Cont1Veri;
         }
        public void setCont1Veri(int newValue){
              _Cont1Veri = newValue;
         }
        private String _Cont1Rel = "";
        public String getCont1Rel(){
              return _Cont1Rel;
         }
        public void setCont1Rel(String newValue){
              _Cont1Rel = newValue;
         }
        private String _Contact2 = "";
        public String getContact2(){
              return _Contact2;
         }
        public void setContact2(String newValue){
              _Contact2 = newValue;
         }
        private int _Cont2Veri = 0;
        public int getCont2Veri(){
              return _Cont2Veri;
         }
        public void setCont2Veri(int newValue){
              _Cont2Veri = newValue;
         }
        private String _Cont2Rel = "";
        public String getCont2Rel(){
              return _Cont2Rel;
         }
        public void setCont2Rel(String newValue){
              _Cont2Rel = newValue;
         }
        private int _Zila = 0;
        public int getZila(){
              return _Zila;
         }
        public void setZila(int newValue){
              _Zila = newValue;
         }
        private int _Upazila = 0;
        public int getUpazila(){
              return _Upazila;
         }
        public void setUpazila(int newValue){
              _Upazila = newValue;
         }
        private int _Unions = 0;
        public int getUnions(){
              return _Unions;
         }
        public void setUnions(int newValue){
              _Unions = newValue;
         }
        private int _Village = 0;
        public int getVillage(){
              return _Village;
         }
        public void setVillage(int newValue){
              _Village = newValue;
         }
        private String _Location = "";
        public String getLocation(){
              return _Location;
         }
        public void setLocation(String newValue){
              _Location = newValue;
         }
        private int _StudyArea = 0;
        public int getStudyArea(){
              return _StudyArea;
         }
        public void setStudyArea(int newValue){
              _StudyArea = newValue;
         }
        private int _PreSumDiag = 0;
        public int getPreSumDiag(){
              return _PreSumDiag;
         }
        public void setPreSumDiag(int newValue){
              _PreSumDiag = newValue;
         }
        private String _PreSumDiag1 = "";
        public String getPreSumDiag1(){
              return _PreSumDiag1;
         }
        public void setPreSumDiag1(String newValue){
              _PreSumDiag1 = newValue;
         }
        private String _PreSumDiag2 = "";
        public String getPreSumDiag2(){
              return _PreSumDiag2;
         }
        public void setPreSumDiag2(String newValue){
              _PreSumDiag2 = newValue;
         }
        private String _PreSumDiag3 = "";
        public String getPreSumDiag3(){
              return _PreSumDiag3;
         }
        public void setPreSumDiag3(String newValue){
              _PreSumDiag3 = newValue;
         }
        private String _PreSumDiag4 = "";
        public String getPreSumDiag4(){
              return _PreSumDiag4;
         }
        public void setPreSumDiag4(String newValue){
              _PreSumDiag4 = newValue;
         }
        private String _PreSumDiag5 = "";
        public String getPreSumDiag5(){
              return _PreSumDiag5;
         }
        public void setPreSumDiag5(String newValue){
              _PreSumDiag5 = newValue;
         }
        private String _OthSymp1 = "";
        public String getOthSymp1(){
              return _OthSymp1;
         }
        public void setOthSymp1(String newValue){
              _OthSymp1 = newValue;
         }
        private int _Symp1Dur = 0;
        public int getSymp1Dur(){
              return _Symp1Dur;
         }
        public void setSymp1Dur(int newValue){
              _Symp1Dur = newValue;
         }
        private String _OthSymp2 = "";
        public String getOthSymp2(){
              return _OthSymp2;
         }
        public void setOthSymp2(String newValue){
              _OthSymp2 = newValue;
         }
        private int _Symp2Dur = 0;
        public int getSymp2Dur(){
              return _Symp2Dur;
         }
        public void setSymp2Dur(int newValue){
              _Symp2Dur = newValue;
         }
        private int _RefuesAdm = 0;
        public int getRefuesAdm(){
              return _RefuesAdm;
         }
        public void setRefuesAdm(int newValue){
              _RefuesAdm = newValue;
         }
        private String _TRefusal = "";
        public String getTRefusal(){
              return _TRefusal;
         }
        public void setTRefusal(String newValue){
              _TRefusal = newValue;
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

        String TableName = "EmergencyScreening";

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
                 SQL = "Insert into "+ TableName +" (PreEnrollmentID,StudyID,HosRegis,DtEnroll,CName,CDOB,CAgeM,CSex,MFName,Contact1,Cont1Veri,Cont1Rel,Contact2,Cont2Veri,Cont2Rel,Zila,Upazila,Unions,Village,Location,StudyArea,PreSumDiag,PreSumDiag1,PreSumDiag2,PreSumDiag3,PreSumDiag4,PreSumDiag5,OthSymp1,Symp1Dur,OthSymp2,Symp2Dur,RefuesAdm,TRefusal,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _PreEnrollmentID +"', '"+ _StudyID +"', '"+ _HosRegis +"', '"+ _DtEnroll +"', '"+ _CName +"', '"+ _CDOB +"', '"+ _CAgeM +"', '"+ _CSex +"', '"+ _MFName +"', '"+ _Contact1 +"', '"+ _Cont1Veri +"', '"+ _Cont1Rel +"', '"+ _Contact2 +"', '"+ _Cont2Veri +"', '"+ _Cont2Rel +"', '"+ _Zila +"', '"+ _Upazila +"', '"+ _Unions +"', '"+ _Village +"', '"+ _Location +"', '"+ _StudyArea +"', '"+ _PreSumDiag +"', '"+ _PreSumDiag1 +"', '"+ _PreSumDiag2 +"', '"+ _PreSumDiag3 +"', '"+ _PreSumDiag4 +"', '"+ _PreSumDiag5 +"', '"+ _OthSymp1 +"', '"+ _Symp1Dur +"', '"+ _OthSymp2 +"', '"+ _Symp2Dur +"', '"+ _RefuesAdm +"', '"+ _TRefusal +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,PreEnrollmentID = '"+ _PreEnrollmentID +"',StudyID = '"+ _StudyID +"',HosRegis = '"+ _HosRegis +"',DtEnroll = '"+ _DtEnroll +"',CName = '"+ _CName +"',CDOB = '"+ _CDOB +"',CAgeM = '"+ _CAgeM +"',CSex = '"+ _CSex +"',MFName = '"+ _MFName +"',Contact1 = '"+ _Contact1 +"',Cont1Veri = '"+ _Cont1Veri +"',Cont1Rel = '"+ _Cont1Rel +"',Contact2 = '"+ _Contact2 +"',Cont2Veri = '"+ _Cont2Veri +"',Cont2Rel = '"+ _Cont2Rel +"',Zila = '"+ _Zila +"',Upazila = '"+ _Upazila +"',Unions = '"+ _Unions +"',Village = '"+ _Village +"',Location = '"+ _Location +"',StudyArea = '"+ _StudyArea +"',PreSumDiag = '"+ _PreSumDiag +"',PreSumDiag1 = '"+ _PreSumDiag1 +"',PreSumDiag2 = '"+ _PreSumDiag2 +"',PreSumDiag3 = '"+ _PreSumDiag3 +"',PreSumDiag4 = '"+ _PreSumDiag4 +"',PreSumDiag5 = '"+ _PreSumDiag5 +"',OthSymp1 = '"+ _OthSymp1 +"',Symp1Dur = '"+ _Symp1Dur +"',OthSymp2 = '"+ _OthSymp2 +"',Symp2Dur = '"+ _Symp2Dur +"',RefuesAdm = '"+ _RefuesAdm +"',TRefusal = '"+ _TRefusal +"'  Where PreEnrollmentID='"+ _PreEnrollmentID +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<EmergencyScreening_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<EmergencyScreening_DataModel> data = new ArrayList<EmergencyScreening_DataModel>();
            EmergencyScreening_DataModel d = new EmergencyScreening_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new EmergencyScreening_DataModel();
                d._PreEnrollmentID = Integer.valueOf(cur.getString(cur.getColumnIndex("PreEnrollmentID")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PreEnrollmentID")));
                d._StudyID = Integer.valueOf(cur.getString(cur.getColumnIndex("StudyID")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("StudyID")));
                d._HosRegis = Integer.valueOf(cur.getString(cur.getColumnIndex("HosRegis")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("HosRegis")));
                d._DtEnroll = cur.getString(cur.getColumnIndex("DtEnroll"));
                d._CName = cur.getString(cur.getColumnIndex("CName"));
                d._CDOB = cur.getString(cur.getColumnIndex("CDOB"));
                d._CAgeM = Integer.valueOf(cur.getString(cur.getColumnIndex("CAgeM")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("CAgeM")));
                d._CSex = Integer.valueOf(cur.getString(cur.getColumnIndex("CSex")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("CSex")));
                d._MFName = cur.getString(cur.getColumnIndex("MFName"));
                d._Contact1 = cur.getString(cur.getColumnIndex("Contact1"));
                d._Cont1Veri = Integer.valueOf(cur.getString(cur.getColumnIndex("Cont1Veri")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Cont1Veri")));
                d._Cont1Rel = cur.getString(cur.getColumnIndex("Cont1Rel"));
                d._Contact2 = cur.getString(cur.getColumnIndex("Contact2"));
                d._Cont2Veri = Integer.valueOf(cur.getString(cur.getColumnIndex("Cont2Veri")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Cont2Veri")));
                d._Cont2Rel = cur.getString(cur.getColumnIndex("Cont2Rel"));
                d._Zila = Integer.valueOf(cur.getString(cur.getColumnIndex("Zila")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Zila")));
                d._Upazila = Integer.valueOf(cur.getString(cur.getColumnIndex("Upazila")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Upazila")));
                d._Unions = Integer.valueOf(cur.getString(cur.getColumnIndex("Unions")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Unions")));
                d._Village = Integer.valueOf(cur.getString(cur.getColumnIndex("Village")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Village")));
                d._Location = cur.getString(cur.getColumnIndex("Location"));
                d._StudyArea = Integer.valueOf(cur.getString(cur.getColumnIndex("StudyArea")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("StudyArea")));
                d._PreSumDiag = Integer.valueOf(cur.getString(cur.getColumnIndex("PreSumDiag")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PreSumDiag")));
                d._PreSumDiag1 = cur.getString(cur.getColumnIndex("PreSumDiag1"));
                d._PreSumDiag2 = cur.getString(cur.getColumnIndex("PreSumDiag2"));
                d._PreSumDiag3 = cur.getString(cur.getColumnIndex("PreSumDiag3"));
                d._PreSumDiag4 = cur.getString(cur.getColumnIndex("PreSumDiag4"));
                d._PreSumDiag5 = cur.getString(cur.getColumnIndex("PreSumDiag5"));
                d._OthSymp1 = cur.getString(cur.getColumnIndex("OthSymp1"));
                d._Symp1Dur = Integer.valueOf(cur.getString(cur.getColumnIndex("Symp1Dur")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Symp1Dur")));
                d._OthSymp2 = cur.getString(cur.getColumnIndex("OthSymp2"));
                d._Symp2Dur = Integer.valueOf(cur.getString(cur.getColumnIndex("Symp2Dur")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Symp2Dur")));
                d._RefuesAdm = Integer.valueOf(cur.getString(cur.getColumnIndex("RefuesAdm")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("RefuesAdm")));
                d._TRefusal = cur.getString(cur.getColumnIndex("TRefusal"));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }