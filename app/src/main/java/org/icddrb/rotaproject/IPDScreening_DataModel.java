package org.icddrb.rotaproject;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class IPDScreening_DataModel{

        private int _PreEnrollmentID = 0;
        public int getPreEnrollmentID(){
              return _PreEnrollmentID;
         }
        public void setPreEnrollmentID(int newValue){
              _PreEnrollmentID = newValue;
         }
        private int _hasDiarr = 0;
        public int gethasDiarr(){
              return _hasDiarr;
         }
        public void sethasDiarr(int newValue){
              _hasDiarr = newValue;
         }
        private int _IBDID = 0;
        public int getIBDID(){
              return _IBDID;
         }
        public void setIBDID(int newValue){
              _IBDID = newValue;
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
        private int _CAge = 0;
        public int getCAge(){
              return _CAge;
         }
        public void setCAge(int newValue){
              _CAge = newValue;
         }
        private int _CSex = 0;
        public int getCSex(){
              return _CSex;
         }
        public void setCSex(int newValue){
              _CSex = newValue;
         }
        private String _HosAdDate = "";
        public String getHosAdDate(){
              return _HosAdDate;
         }
        public void setHosAdDate(String newValue){
              _HosAdDate = newValue;
         }
        private String _HosAdTime = "";
        public String getHosAdTime(){
              return _HosAdTime;
         }
        public void setHosAdTime(String newValue){
              _HosAdTime = newValue;
         }
        private String _HosRegis1 = "";
        public String getHosRegis1(){
              return _HosRegis1;
         }
        public void setHosRegis1(String newValue){
              _HosRegis1 = newValue;
         }
        private String _HosBed1 = "";
        public String getHosBed1(){
              return _HosBed1;
         }
        public void setHosBed1(String newValue){
              _HosBed1 = newValue;
         }
        private String _HosWard1 = "";
        public String getHosWard1(){
              return _HosWard1;
         }
        public void setHosWard1(String newValue){
              _HosWard1 = newValue;
         }
        private String _HosRegis2 = "";
        public String getHosRegis2(){
              return _HosRegis2;
         }
        public void setHosRegis2(String newValue){
              _HosRegis2 = newValue;
         }
        private String _HosBed2 = "";
        public String getHosBed2(){
              return _HosBed2;
         }
        public void setHosBed2(String newValue){
              _HosBed2 = newValue;
         }
        private String _HosWard2 = "";
        public String getHosWard2(){
              return _HosWard2;
         }
        public void setHosWard2(String newValue){
              _HosWard2 = newValue;
         }
        private String _HosRegis3 = "";
        public String getHosRegis3(){
              return _HosRegis3;
         }
        public void setHosRegis3(String newValue){
              _HosRegis3 = newValue;
         }
        private String _HosBed3 = "";
        public String getHosBed3(){
              return _HosBed3;
         }
        public void setHosBed3(String newValue){
              _HosBed3 = newValue;
         }
        private String _HosWard3 = "";
        public String getHosWard3(){
              return _HosWard3;
         }
        public void setHosWard3(String newValue){
              _HosWard3 = newValue;
         }
        private String _ProviDaig1 = "";
        public String getProviDaig1(){
              return _ProviDaig1;
         }
        public void setProviDaig1(String newValue){
              _ProviDaig1 = newValue;
         }
        private String _ProviDiag2 = "";
        public String getProviDiag2(){
              return _ProviDiag2;
         }
        public void setProviDiag2(String newValue){
              _ProviDiag2 = newValue;
         }
        private String _ProviDiag3 = "";
        public String getProviDiag3(){
              return _ProviDiag3;
         }
        public void setProviDiag3(String newValue){
              _ProviDiag3 = newValue;
         }
        private String _ProviDiag4 = "";
        public String getProviDiag4(){
              return _ProviDiag4;
         }
        public void setProviDiag4(String newValue){
              _ProviDiag4 = newValue;
         }
        private String _ProviDiag5 = "";
        public String getProviDiag5(){
              return _ProviDiag5;
         }
        public void setProviDiag5(String newValue){
              _ProviDiag5 = newValue;
         }
        private int _Age5Yr = 0;
        public int getAge5Yr(){
              return _Age5Yr;
         }
        public void setAge5Yr(int newValue){
              _Age5Yr = newValue;
         }
        private int _Occur3 = 0;
        public int getOccur3(){
              return _Occur3;
         }
        public void setOccur3(int newValue){
              _Occur3 = newValue;
         }
        private int _DurDiarr = 0;
        public int getDurDiarr(){
              return _DurDiarr;
         }
        public void setDurDiarr(int newValue){
              _DurDiarr = newValue;
         }
        private int _BldDiarr = 0;
        public int getBldDiarr(){
              return _BldDiarr;
         }
        public void setBldDiarr(int newValue){
              _BldDiarr = newValue;
         }
        private int _EligiEnrol = 0;
        public int getEligiEnrol(){
              return _EligiEnrol;
         }
        public void setEligiEnrol(int newValue){
              _EligiEnrol = newValue;
         }
        private int _Consent = 0;
        public int getConsent(){
              return _Consent;
         }
        public void setConsent(int newValue){
              _Consent = newValue;
         }
        private int _StudyID = 0;
        public int getStudyID(){
              return _StudyID;
         }
        public void setStudyID(int newValue){
              _StudyID = newValue;
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
        private int _cont1Veri = 0;
        public int getcont1Veri(){
              return _cont1Veri;
         }
        public void setcont1Veri(int newValue){
              _cont1Veri = newValue;
         }
        private String _cont1Rel = "";
        public String getcont1Rel(){
              return _cont1Rel;
         }
        public void setcont1Rel(String newValue){
              _cont1Rel = newValue;
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
        private int _SpeColAdv = 0;
        public int getSpeColAdv(){
              return _SpeColAdv;
         }
        public void setSpeColAdv(int newValue){
              _SpeColAdv = newValue;
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

        String TableName = "IPDScreening";

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
                 SQL = "Insert into "+ TableName +" (PreEnrollmentID,hasDiarr,IBDID,CName,CDOB,CAge,CSex,HosAdDate,HosAdTime,HosRegis1,HosBed1,HosWard1,HosRegis2,HosBed2,HosWard2,HosRegis3,HosBed3,HosWard3,ProviDaig1,ProviDiag2,ProviDiag3,ProviDiag4,ProviDiag5,Age5Yr,Occur3,DurDiarr,BldDiarr,EligiEnrol,Consent,StudyID,MFName,Contact1,cont1Veri,cont1Rel,Contact2,Cont2Veri,Cont2Rel,Zila,Upazila,Unions,Village,Location,StudyArea,SpeColAdv,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _PreEnrollmentID +"', '"+ _hasDiarr +"', '"+ _IBDID +"', '"+ _CName +"', '"+ _CDOB +"', '"+ _CAge +"', '"+ _CSex +"', '"+ _HosAdDate +"', '"+ _HosAdTime +"', '"+ _HosRegis1 +"', '"+ _HosBed1 +"', '"+ _HosWard1 +"', '"+ _HosRegis2 +"', '"+ _HosBed2 +"', '"+ _HosWard2 +"', '"+ _HosRegis3 +"', '"+ _HosBed3 +"', '"+ _HosWard3 +"', '"+ _ProviDaig1 +"', '"+ _ProviDiag2 +"', '"+ _ProviDiag3 +"', '"+ _ProviDiag4 +"', '"+ _ProviDiag5 +"', '"+ _Age5Yr +"', '"+ _Occur3 +"', '"+ _DurDiarr +"', '"+ _BldDiarr +"', '"+ _EligiEnrol +"', '"+ _Consent +"', '"+ _StudyID +"', '"+ _MFName +"', '"+ _Contact1 +"', '"+ _cont1Veri +"', '"+ _cont1Rel +"', '"+ _Contact2 +"', '"+ _Cont2Veri +"', '"+ _Cont2Rel +"', '"+ _Zila +"', '"+ _Upazila +"', '"+ _Unions +"', '"+ _Village +"', '"+ _Location +"', '"+ _StudyArea +"', '"+ _SpeColAdv +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,PreEnrollmentID = '"+ _PreEnrollmentID +"',hasDiarr = '"+ _hasDiarr +"',IBDID = '"+ _IBDID +"',CName = '"+ _CName +"',CDOB = '"+ _CDOB +"',CAge = '"+ _CAge +"',CSex = '"+ _CSex +"',HosAdDate = '"+ _HosAdDate +"',HosAdTime = '"+ _HosAdTime +"',HosRegis1 = '"+ _HosRegis1 +"',HosBed1 = '"+ _HosBed1 +"',HosWard1 = '"+ _HosWard1 +"',HosRegis2 = '"+ _HosRegis2 +"',HosBed2 = '"+ _HosBed2 +"',HosWard2 = '"+ _HosWard2 +"',HosRegis3 = '"+ _HosRegis3 +"',HosBed3 = '"+ _HosBed3 +"',HosWard3 = '"+ _HosWard3 +"',ProviDaig1 = '"+ _ProviDaig1 +"',ProviDiag2 = '"+ _ProviDiag2 +"',ProviDiag3 = '"+ _ProviDiag3 +"',ProviDiag4 = '"+ _ProviDiag4 +"',ProviDiag5 = '"+ _ProviDiag5 +"',Age5Yr = '"+ _Age5Yr +"',Occur3 = '"+ _Occur3 +"',DurDiarr = '"+ _DurDiarr +"',BldDiarr = '"+ _BldDiarr +"',EligiEnrol = '"+ _EligiEnrol +"',Consent = '"+ _Consent +"',StudyID = '"+ _StudyID +"',MFName = '"+ _MFName +"',Contact1 = '"+ _Contact1 +"',cont1Veri = '"+ _cont1Veri +"',cont1Rel = '"+ _cont1Rel +"',Contact2 = '"+ _Contact2 +"',Cont2Veri = '"+ _Cont2Veri +"',Cont2Rel = '"+ _Cont2Rel +"',Zila = '"+ _Zila +"',Upazila = '"+ _Upazila +"',Unions = '"+ _Unions +"',Village = '"+ _Village +"',Location = '"+ _Location +"',StudyArea = '"+ _StudyArea +"',SpeColAdv = '"+ _SpeColAdv +"'  Where PreEnrollmentID='"+ _PreEnrollmentID +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<IPDScreening_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<IPDScreening_DataModel> data = new ArrayList<IPDScreening_DataModel>();
            IPDScreening_DataModel d = new IPDScreening_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new IPDScreening_DataModel();
                d._PreEnrollmentID = Integer.valueOf(cur.getString(cur.getColumnIndex("PreEnrollmentID")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PreEnrollmentID")));
                d._hasDiarr = Integer.valueOf(cur.getString(cur.getColumnIndex("hasDiarr")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("hasDiarr")));
                d._IBDID = Integer.valueOf(cur.getString(cur.getColumnIndex("IBDID")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("IBDID")));
                d._CName = cur.getString(cur.getColumnIndex("CName"));
                d._CDOB = cur.getString(cur.getColumnIndex("CDOB"));
                d._CAge = Integer.valueOf(cur.getString(cur.getColumnIndex("CAge")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("CAge")));
                d._CSex = Integer.valueOf(cur.getString(cur.getColumnIndex("CSex")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("CSex")));
                d._HosAdDate = cur.getString(cur.getColumnIndex("HosAdDate"));
                d._HosAdTime = cur.getString(cur.getColumnIndex("HosAdTime"));
                d._HosRegis1 = cur.getString(cur.getColumnIndex("HosRegis1"));
                d._HosBed1 = cur.getString(cur.getColumnIndex("HosBed1"));
                d._HosWard1 = cur.getString(cur.getColumnIndex("HosWard1"));
                d._HosRegis2 = cur.getString(cur.getColumnIndex("HosRegis2"));
                d._HosBed2 = cur.getString(cur.getColumnIndex("HosBed2"));
                d._HosWard2 = cur.getString(cur.getColumnIndex("HosWard2"));
                d._HosRegis3 = cur.getString(cur.getColumnIndex("HosRegis3"));
                d._HosBed3 = cur.getString(cur.getColumnIndex("HosBed3"));
                d._HosWard3 = cur.getString(cur.getColumnIndex("HosWard3"));
                d._ProviDaig1 = cur.getString(cur.getColumnIndex("ProviDaig1"));
                d._ProviDiag2 = cur.getString(cur.getColumnIndex("ProviDiag2"));
                d._ProviDiag3 = cur.getString(cur.getColumnIndex("ProviDiag3"));
                d._ProviDiag4 = cur.getString(cur.getColumnIndex("ProviDiag4"));
                d._ProviDiag5 = cur.getString(cur.getColumnIndex("ProviDiag5"));
                d._Age5Yr = Integer.valueOf(cur.getString(cur.getColumnIndex("Age5Yr")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Age5Yr")));
                d._Occur3 = Integer.valueOf(cur.getString(cur.getColumnIndex("Occur3")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Occur3")));
                d._DurDiarr = Integer.valueOf(cur.getString(cur.getColumnIndex("DurDiarr")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DurDiarr")));
                d._BldDiarr = Integer.valueOf(cur.getString(cur.getColumnIndex("BldDiarr")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("BldDiarr")));
                d._EligiEnrol = Integer.valueOf(cur.getString(cur.getColumnIndex("EligiEnrol")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("EligiEnrol")));
                d._Consent = Integer.valueOf(cur.getString(cur.getColumnIndex("Consent")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Consent")));
                d._StudyID = Integer.valueOf(cur.getString(cur.getColumnIndex("StudyID")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("StudyID")));
                d._MFName = cur.getString(cur.getColumnIndex("MFName"));
                d._Contact1 = cur.getString(cur.getColumnIndex("Contact1"));
                d._cont1Veri = Integer.valueOf(cur.getString(cur.getColumnIndex("cont1Veri")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("cont1Veri")));
                d._cont1Rel = cur.getString(cur.getColumnIndex("cont1Rel"));
                d._Contact2 = cur.getString(cur.getColumnIndex("Contact2"));
                d._Cont2Veri = Integer.valueOf(cur.getString(cur.getColumnIndex("Cont2Veri")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Cont2Veri")));
                d._Cont2Rel = cur.getString(cur.getColumnIndex("Cont2Rel"));
                d._Zila = Integer.valueOf(cur.getString(cur.getColumnIndex("Zila")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Zila")));
                d._Upazila = Integer.valueOf(cur.getString(cur.getColumnIndex("Upazila")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Upazila")));
                d._Unions = Integer.valueOf(cur.getString(cur.getColumnIndex("Unions")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Unions")));
                d._Village = Integer.valueOf(cur.getString(cur.getColumnIndex("Village")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("Village")));
                d._Location = cur.getString(cur.getColumnIndex("Location"));
                d._StudyArea = Integer.valueOf(cur.getString(cur.getColumnIndex("StudyArea")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("StudyArea")));
                d._SpeColAdv = Integer.valueOf(cur.getString(cur.getColumnIndex("SpeColAdv")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SpeColAdv")));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }