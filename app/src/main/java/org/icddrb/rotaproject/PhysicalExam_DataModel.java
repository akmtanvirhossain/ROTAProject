package org.icddrb.rotaproject;

import android.content.Context;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Date;
 public class PhysicalExam_DataModel{

        private int _PreEnrollmentID = 0;
        public int getPreEnrollmentID(){
              return _PreEnrollmentID;
         }
        public void setPreEnrollmentID(int newValue){
              _PreEnrollmentID = newValue;
         }
        private double _TempAdm = 0.0;
        public double getTempAdm(){
              return _TempAdm;
         }
        public void setTempAdm(double newValue){
              _TempAdm = newValue;
         }
        private double _TempEnrol = 0.0;
        public double getTempEnrol(){
              return _TempEnrol;
         }
        public void setTempEnrol(double newValue){
              _TempEnrol = newValue;
         }
        private int _BodyWght = 0;
        public int getBodyWght(){
              return _BodyWght;
         }
        public void setBodyWght(int newValue){
              _BodyWght = newValue;
         }
        private double _Weight = 0.0;
        public double getWeight(){
              return _Weight;
         }
        public void setWeight(double newValue){
              _Weight = newValue;
         }
        private int _LethaAdm = 0;
        public int getLethaAdm(){
              return _LethaAdm;
         }
        public void setLethaAdm(int newValue){
              _LethaAdm = newValue;
         }
        private int _LathaEn = 0;
        public int getLathaEn(){
              return _LathaEn;
         }
        public void setLathaEn(int newValue){
              _LathaEn = newValue;
         }
        private int _SunEyeAdm = 0;
        public int getSunEyeAdm(){
              return _SunEyeAdm;
         }
        public void setSunEyeAdm(int newValue){
              _SunEyeAdm = newValue;
         }
        private int _SunEyeEn = 0;
        public int getSunEyeEn(){
              return _SunEyeEn;
         }
        public void setSunEyeEn(int newValue){
              _SunEyeEn = newValue;
         }
        private int _SkinPinAdm = 0;
        public int getSkinPinAdm(){
              return _SkinPinAdm;
         }
        public void setSkinPinAdm(int newValue){
              _SkinPinAdm = newValue;
         }
        private int _SkinPoorEn = 0;
        public int getSkinPoorEn(){
              return _SkinPoorEn;
         }
        public void setSkinPoorEn(int newValue){
              _SkinPoorEn = newValue;
         }
        private int _DrinkPoorAdm = 0;
        public int getDrinkPoorAdm(){
              return _DrinkPoorAdm;
         }
        public void setDrinkPoorAdm(int newValue){
              _DrinkPoorAdm = newValue;
         }
        private int _DrinkPoorEn = 0;
        public int getDrinkPoorEn(){
              return _DrinkPoorEn;
         }
        public void setDrinkPoorEn(int newValue){
              _DrinkPoorEn = newValue;
         }
        private int _ThitstAdm = 0;
        public int getThitstAdm(){
              return _ThitstAdm;
         }
        public void setThitstAdm(int newValue){
              _ThitstAdm = newValue;
         }
        private int _ThitstEn = 0;
        public int getThitstEn(){
              return _ThitstEn;
         }
        public void setThitstEn(int newValue){
              _ThitstEn = newValue;
         }
        private int _IrritAdm = 0;
        public int getIrritAdm(){
              return _IrritAdm;
         }
        public void setIrritAdm(int newValue){
              _IrritAdm = newValue;
         }
        private int _IrritEn = 0;
        public int getIrritEn(){
              return _IrritEn;
         }
        public void setIrritEn(int newValue){
              _IrritEn = newValue;
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

        String TableName = "PhysicalExam";

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
                 SQL = "Insert into "+ TableName +" (PreEnrollmentID,TempAdm,TempEnrol,BodyWght,Weight,LethaAdm,LathaEn,SunEyeAdm,SunEyeEn,SkinPinAdm,SkinPoorEn,DrinkPoorAdm,DrinkPoorEn,ThitstAdm,ThitstEn,IrritAdm,IrritEn,StartTime,EndTime,DeviceID,EntryUser,Lat,Lon,EnDt,Upload,modifyDate)Values('"+ _PreEnrollmentID +"', '"+ _TempAdm +"', '"+ _TempEnrol +"', '"+ _BodyWght +"', '"+ _Weight +"', '"+ _LethaAdm +"', '"+ _LathaEn +"', '"+ _SunEyeAdm +"', '"+ _SunEyeEn +"', '"+ _SkinPinAdm +"', '"+ _SkinPoorEn +"', '"+ _DrinkPoorAdm +"', '"+ _DrinkPoorEn +"', '"+ _ThitstAdm +"', '"+ _ThitstEn +"', '"+ _IrritAdm +"', '"+ _IrritEn +"', '"+ _StartTime +"', '"+ _EndTime +"', '"+ _DeviceID +"', '"+ _EntryUser +"', '"+ _Lat +"', '"+ _Lon +"', '"+ _EnDt +"', '"+ _Upload +"', '"+ _modifyDate +"')";
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
                 SQL = "Update "+ TableName +" Set Upload='2',modifyDate='" + _modifyDate + "' ,PreEnrollmentID = '"+ _PreEnrollmentID +"',TempAdm = '"+ _TempAdm +"',TempEnrol = '"+ _TempEnrol +"',BodyWght = '"+ _BodyWght +"',Weight = '"+ _Weight +"',LethaAdm = '"+ _LethaAdm +"',LathaEn = '"+ _LathaEn +"',SunEyeAdm = '"+ _SunEyeAdm +"',SunEyeEn = '"+ _SunEyeEn +"',SkinPinAdm = '"+ _SkinPinAdm +"',SkinPoorEn = '"+ _SkinPoorEn +"',DrinkPoorAdm = '"+ _DrinkPoorAdm +"',DrinkPoorEn = '"+ _DrinkPoorEn +"',ThitstAdm = '"+ _ThitstAdm +"',ThitstEn = '"+ _ThitstEn +"',IrritAdm = '"+ _IrritAdm +"',IrritEn = '"+ _IrritEn +"'  Where PreEnrollmentID='"+ _PreEnrollmentID +"'";
                 response = C.SaveData(SQL);
                 C.close();
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        public List<PhysicalExam_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<PhysicalExam_DataModel> data = new ArrayList<PhysicalExam_DataModel>();
            PhysicalExam_DataModel d = new PhysicalExam_DataModel();
            Cursor cur = C.ReadData(SQL);

            cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                d = new PhysicalExam_DataModel();
                d._PreEnrollmentID = Integer.valueOf(cur.getString(cur.getColumnIndex("PreEnrollmentID")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("PreEnrollmentID")));
                d._TempAdm = Double.parseDouble(cur.getString(cur.getColumnIndex("TempAdm")).length() == 0 ? "000.0" : cur.getString(cur.getColumnIndex("TempAdm")));
                d._TempEnrol = Double.parseDouble(cur.getString(cur.getColumnIndex("TempEnrol")).length() == 0 ? "000.0" : cur.getString(cur.getColumnIndex("TempEnrol")));
                d._BodyWght = Integer.valueOf(cur.getString(cur.getColumnIndex("BodyWght")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("BodyWght")));
                d._Weight = Double.parseDouble(cur.getString(cur.getColumnIndex("Weight")).length() == 0 ? "0.0" : cur.getString(cur.getColumnIndex("Weight")));
                d._LethaAdm = Integer.valueOf(cur.getString(cur.getColumnIndex("LethaAdm")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("LethaAdm")));
                d._LathaEn = Integer.valueOf(cur.getString(cur.getColumnIndex("LathaEn")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("LathaEn")));
                d._SunEyeAdm = Integer.valueOf(cur.getString(cur.getColumnIndex("SunEyeAdm")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SunEyeAdm")));
                d._SunEyeEn = Integer.valueOf(cur.getString(cur.getColumnIndex("SunEyeEn")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SunEyeEn")));
                d._SkinPinAdm = Integer.valueOf(cur.getString(cur.getColumnIndex("SkinPinAdm")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SkinPinAdm")));
                d._SkinPoorEn = Integer.valueOf(cur.getString(cur.getColumnIndex("SkinPoorEn")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("SkinPoorEn")));
                d._DrinkPoorAdm = Integer.valueOf(cur.getString(cur.getColumnIndex("DrinkPoorAdm")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DrinkPoorAdm")));
                d._DrinkPoorEn = Integer.valueOf(cur.getString(cur.getColumnIndex("DrinkPoorEn")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("DrinkPoorEn")));
                d._ThitstAdm = Integer.valueOf(cur.getString(cur.getColumnIndex("ThitstAdm")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("ThitstAdm")));
                d._ThitstEn = Integer.valueOf(cur.getString(cur.getColumnIndex("ThitstEn")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("ThitstEn")));
                d._IrritAdm = Integer.valueOf(cur.getString(cur.getColumnIndex("IrritAdm")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("IrritAdm")));
                d._IrritEn = Integer.valueOf(cur.getString(cur.getColumnIndex("IrritEn")).length() == 0 ? "0" : cur.getString(cur.getColumnIndex("IrritEn")));
                data.add(d);

                cur.moveToNext();
            }
            cur.close();
          return data;
        }
 }