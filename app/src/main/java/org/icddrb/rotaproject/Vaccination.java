
 package org.icddrb.rotaproject;


 //Android Manifest Code
 //<activity android:name=".Vaccination" android:label="Vaccination" />
 import java.text.ParseException;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Calendar;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import android.app.*;
 import android.app.AlertDialog;
 import android.app.DatePickerDialog;
 import android.app.Dialog;
 import android.app.TimePickerDialog;
 import android.content.Context;
 import android.content.DialogInterface;
 import android.content.Intent;
 import android.database.Cursor;
 import android.location.Location;
 import android.location.LocationListener;
 import android.location.LocationManager;
 import android.net.Uri;
 import android.provider.Settings;
 import android.view.KeyEvent;
 import android.os.Bundle;
 import android.view.Menu;
 import android.view.MenuInflater;
 import android.view.MenuItem;
 import android.view.View;
 import android.view.MotionEvent;
 import android.view.View.OnFocusChangeListener;
 import android.view.ViewGroup;
 import android.view.LayoutInflater;
 import android.widget.AdapterView;
 import android.widget.Button;
 import android.widget.CheckBox;
 import android.widget.DatePicker;
 import android.widget.EditText;
 import android.widget.ImageButton;
 import android.widget.LinearLayout;
 import android.widget.RadioButton;
 import android.widget.RadioGroup;
 import android.widget.ListView;
 import android.widget.SimpleAdapter;
 import android.widget.BaseAdapter;
 import android.widget.Spinner;
 import android.widget.TextView;
 import android.widget.TimePicker;
 import android.widget.ArrayAdapter;
 import android.widget.CompoundButton;
 import android.graphics.Color;
 import android.view.WindowManager;
 import Utility.*;
 import Common.*;

 public class Vaccination extends Activity {
    boolean networkAvailable=false;
    Location currentLocation; 
    double currentLatitude,currentLongitude; 
    //Disabled Back/Home key
    //--------------------------------------------------------------------------------------------------
    @Override 
    public boolean onKeyDown(int iKeyCode, KeyEvent event)
    {
        if(iKeyCode == KeyEvent.KEYCODE_BACK || iKeyCode == KeyEvent.KEYCODE_HOME) 
             { return false; }
        else { return true;  }
    }
    String VariableID;
    private int hour;
    private int minute;
    private int mDay;
    private int mMonth;
    private int mYear;
    static final int DATE_DIALOG = 1;
    static final int TIME_DIALOG = 2;

    Connection C;
    Global g;
    SimpleAdapter dataAdapter;
    ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
         TextView lblHeading;
         LinearLayout secVLabel;
         View lineVLabel;
         LinearLayout secPreEnrollmentID;
         View linePreEnrollmentID;
         TextView VlblPreEnrollmentID;
         EditText txtPreEnrollmentID;
         LinearLayout secReceiVacc;
         View lineReceiVacc;
         TextView VlblReceiVacc;
         RadioGroup rdogrpReceiVacc;
         
         RadioButton rdoReceiVacc1;
         RadioButton rdoReceiVacc2;
         RadioButton rdoReceiVacc3;
         LinearLayout secNumDose;
         View lineNumDose;
         TextView VlblNumDose;
         RadioGroup rdogrpNumDose;
         
         RadioButton rdoNumDose1;
         RadioButton rdoNumDose2;
         LinearLayout secSourInf;
         View lineSourInf;
         TextView VlblSourInf;
         RadioGroup rdogrpSourInf;
         
         RadioButton rdoSourInf1;
         RadioButton rdoSourInf2;
         RadioButton rdoSourInf3;

    static String TableName;

    static String STARTTIME = "";
    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    MySharedPreferences sp;

    Bundle IDbundle;
    static String PREENROLLMENTID = "";

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.vaccination);
         getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         PREENROLLMENTID = IDbundle.getString("PreEnrollmentID");

         TableName = "Vaccination";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Vaccination.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});


         secVLabel=(LinearLayout)findViewById(R.id.secVLabel);
         lineVLabel=(View)findViewById(R.id.lineVLabel);
         secPreEnrollmentID=(LinearLayout)findViewById(R.id.secPreEnrollmentID);
         linePreEnrollmentID=(View)findViewById(R.id.linePreEnrollmentID);
         VlblPreEnrollmentID=(TextView) findViewById(R.id.VlblPreEnrollmentID);
         txtPreEnrollmentID=(EditText) findViewById(R.id.txtPreEnrollmentID);
         txtPreEnrollmentID.setText(PREENROLLMENTID);
         secReceiVacc=(LinearLayout)findViewById(R.id.secReceiVacc);
         lineReceiVacc=(View)findViewById(R.id.lineReceiVacc);
         VlblReceiVacc = (TextView) findViewById(R.id.VlblReceiVacc);
         rdogrpReceiVacc = (RadioGroup) findViewById(R.id.rdogrpReceiVacc);
         
         rdoReceiVacc1 = (RadioButton) findViewById(R.id.rdoReceiVacc1);
         rdoReceiVacc2 = (RadioButton) findViewById(R.id.rdoReceiVacc2);
         rdoReceiVacc3 = (RadioButton) findViewById(R.id.rdoReceiVacc3);
         rdogrpReceiVacc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpReceiVacc = new String[] {"1","2","3"};
             for (int i = 0; i < rdogrpReceiVacc.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpReceiVacc.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpReceiVacc[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secNumDose.setVisibility(View.GONE);
                    lineNumDose.setVisibility(View.GONE);
                    rdogrpNumDose.clearCheck();
                    secSourInf.setVisibility(View.GONE);
                    lineSourInf.setVisibility(View.GONE);
                    rdogrpSourInf.clearCheck();
             }
             else if(rbData.equalsIgnoreCase("3"))
             {
                    secNumDose.setVisibility(View.GONE);
                    lineNumDose.setVisibility(View.GONE);
                    rdogrpNumDose.clearCheck();
                    secSourInf.setVisibility(View.GONE);
                    lineSourInf.setVisibility(View.GONE);
                    rdogrpSourInf.clearCheck();
             }
             else
             {
                    secNumDose.setVisibility(View.VISIBLE);
                    lineNumDose.setVisibility(View.VISIBLE);
                    secSourInf.setVisibility(View.VISIBLE);
                    lineSourInf.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secNumDose=(LinearLayout)findViewById(R.id.secNumDose);
         lineNumDose=(View)findViewById(R.id.lineNumDose);
         VlblNumDose = (TextView) findViewById(R.id.VlblNumDose);
         rdogrpNumDose = (RadioGroup) findViewById(R.id.rdogrpNumDose);
         
         rdoNumDose1 = (RadioButton) findViewById(R.id.rdoNumDose1);
         rdoNumDose2 = (RadioButton) findViewById(R.id.rdoNumDose2);
         secSourInf=(LinearLayout)findViewById(R.id.secSourInf);
         lineSourInf=(View)findViewById(R.id.lineSourInf);
         VlblSourInf = (TextView) findViewById(R.id.VlblSourInf);
         rdogrpSourInf = (RadioGroup) findViewById(R.id.rdogrpSourInf);
         
         rdoSourInf1 = (RadioButton) findViewById(R.id.rdoSourInf1);
         rdoSourInf2 = (RadioButton) findViewById(R.id.rdoSourInf2);
         rdoSourInf3 = (RadioButton) findViewById(R.id.rdoSourInf3);
         rdogrpSourInf.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpSourInf = new String[] {"1","2","3"};
             for (int i = 0; i < rdogrpSourInf.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpSourInf.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpSourInf[i];
             }

             if(rbData.equalsIgnoreCase("1"))
             {
                    /*sec.setVisibility(View.GONE);
                    line.setVisibility(View.GONE);*/
             }
             else
             {
                    /*sec.setVisibility(View.VISIBLE);
                    line.setVisibility(View.VISIBLE);*/
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 





         //Hide all skip variables
         secNumDose.setVisibility(View.GONE);
         lineNumDose.setVisibility(View.GONE);
         secSourInf.setVisibility(View.GONE);
         lineSourInf.setVisibility(View.GONE);
         secNumDose.setVisibility(View.GONE);
         lineNumDose.setVisibility(View.GONE);
         secSourInf.setVisibility(View.GONE);
         lineSourInf.setVisibility(View.GONE);
         //sec.setVisibility(View.GONE);
         //line.setVisibility(View.GONE);


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Vaccination.this, e.getMessage());
         return;
     }
 }

 private void DataSave()
 {
   try
     {
 
         String DV="";

         if(txtPreEnrollmentID.getText().toString().length()==0 & secPreEnrollmentID.isShown())
           {
             Connection.MessageBox(Vaccination.this, "Required field: PreEnrollment ID.");
             txtPreEnrollmentID.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0 ? "00000001" : txtPreEnrollmentID.getText().toString()) < 00000001 || Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0 ? "88888888" : txtPreEnrollmentID.getText().toString()) > 88888888)
           {
             Connection.MessageBox(Vaccination.this, "Value should be between 00000001 and 88888888(PreEnrollment ID).");
             txtPreEnrollmentID.requestFocus(); 
             return;	
           }
         
         else if(!rdoReceiVacc1.isChecked() & !rdoReceiVacc2.isChecked() & !rdoReceiVacc3.isChecked() & secReceiVacc.isShown())
           {
              Connection.MessageBox(Vaccination.this, "Select anyone options from (Did the child receive rota vaccine).");
              rdoReceiVacc1.requestFocus();
              return;
           }
         
         else if(!rdoNumDose1.isChecked() & !rdoNumDose2.isChecked() & secNumDose.isShown())
           {
              Connection.MessageBox(Vaccination.this, "Select anyone options from (1. Number of doses received).");
              rdoNumDose1.requestFocus();
              return;
           }
         
         else if(!rdoSourInf1.isChecked() & !rdoSourInf2.isChecked() & !rdoSourInf3.isChecked() & secSourInf.isShown())
           {
              Connection.MessageBox(Vaccination.this, "Select anyone options from (2. Source of Information).");
              rdoSourInf1.requestFocus();
              return;
           }
 
         String SQL = "";
         RadioButton rb;

         Vaccination_DataModel objSave = new Vaccination_DataModel();
         objSave.setPreEnrollmentID(Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0?"0":txtPreEnrollmentID.getText().toString()));
         String[] d_rdogrpReceiVacc = new String[] {"1","2","3"};
         objSave.setReceiVacc(0);
         for (int i = 0; i < rdogrpReceiVacc.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpReceiVacc.getChildAt(i);
             if (rb.isChecked()) objSave.setReceiVacc(Integer.valueOf(d_rdogrpReceiVacc[i]));
         }

         String[] d_rdogrpNumDose = new String[] {"1","2"};
         objSave.setNumDose(0);
         for (int i = 0; i < rdogrpNumDose.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpNumDose.getChildAt(i);
             if (rb.isChecked()) objSave.setNumDose(Integer.valueOf(d_rdogrpNumDose[i]));
         }

         String[] d_rdogrpSourInf = new String[] {"1","2","3"};
         objSave.setSourInf(0);
         for (int i = 0; i < rdogrpSourInf.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpSourInf.getChildAt(i);
             if (rb.isChecked()) objSave.setSourInf(Integer.valueOf(d_rdogrpSourInf[i]));
         }

         objSave.setEnDt(Global.DateTimeNowYMDHMS());
         objSave.setStartTime(STARTTIME);
         objSave.setEndTime(g.CurrentTime24());
         objSave.setDeviceID(DEVICEID);
         objSave.setEntryUser(ENTRYUSER); //from data entry user list
         objSave.setmodifyDate(Global.DateTimeNowYMDHMS());
         //objSave.setLat(Double.toString(currentLatitude));
         //objSave.setLon(Double.toString(currentLongitude));

         String status = objSave.SaveUpdateData(this);
         if(status.length()==0) {
             Intent returnIntent = new Intent();
             returnIntent.putExtra("res", "");
             setResult(Activity.RESULT_OK, returnIntent);

             Connection.MessageBox(Vaccination.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(Vaccination.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Vaccination.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String PreEnrollmentID)
     {
       try
        {
     
           RadioButton rb;
           Vaccination_DataModel d = new Vaccination_DataModel();
           String SQL = "Select * from "+ TableName +"  Where PreEnrollmentID='"+ PreEnrollmentID +"'";
           List<Vaccination_DataModel> data = d.SelectAll(this, SQL);
           for(Vaccination_DataModel item : data){
             txtPreEnrollmentID.setText(String.valueOf(item.getPreEnrollmentID()));
             String[] d_rdogrpReceiVacc = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpReceiVacc.length; i++)
             {
                 if (String.valueOf(item.getReceiVacc()).equals(String.valueOf(d_rdogrpReceiVacc[i])))
                 {
                     rb = (RadioButton)rdogrpReceiVacc.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpNumDose = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpNumDose.length; i++)
             {
                 if (String.valueOf(item.getNumDose()).equals(String.valueOf(d_rdogrpNumDose[i])))
                 {
                     rb = (RadioButton)rdogrpNumDose.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpSourInf = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpSourInf.length; i++)
             {
                 if (String.valueOf(item.getSourInf()).equals(String.valueOf(d_rdogrpSourInf[i])))
                 {
                     rb = (RadioButton)rdogrpSourInf.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Vaccination.this, e.getMessage());
            return;
        }
     }



 protected Dialog onCreateDialog(int id) {
   final Calendar c = Calendar.getInstance();
   hour = c.get(Calendar.HOUR_OF_DAY);
   minute = c.get(Calendar.MINUTE);
   switch (id) {
       case DATE_DIALOG:
           return new DatePickerDialog(this, mDateSetListener,g.mYear,g.mMonth-1,g.mDay);
       case TIME_DIALOG:
           return new TimePickerDialog(this, timePickerListener, hour, minute,false);
       }
     return null;
 }

 private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
      mYear = year; mMonth = monthOfYear+1; mDay = dayOfMonth;
      EditText dtpDate;


      /*dtpDate.setText(new StringBuilder()
      .append(Global.Right("00"+mDay,2)).append("/")
      .append(Global.Right("00"+mMonth,2)).append("/")
      .append(mYear));*/
      }
  };

 private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
       hour = selectedHour; minute = selectedMinute;
       EditText tpTime;


          //tpTime.setText(new StringBuilder().append(Global.Right("00"+hour,2)).append(":").append(Global.Right("00"+minute,2)));

    }
  };


 
 // turning off the GPS if its in on state. to avoid the battery drain.
 @Override
 protected void onDestroy() {
     // TODO Auto-generated method stub
     super.onDestroy();
 }
}