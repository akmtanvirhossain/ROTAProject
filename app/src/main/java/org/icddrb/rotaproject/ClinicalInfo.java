
 package org.icddrb.rotaproject;


 //Android Manifest Code
 //<activity android:name=".ClinicalInfo" android:label="ClinicalInfo" />
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
 import android.widget.AutoCompleteTextView;

 public class ClinicalInfo extends Activity {
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
         LinearLayout secCliLabl;
         View lineCliLabl;
         LinearLayout secPreEnrollmentID;
         View linePreEnrollmentID;
         TextView VlblPreEnrollmentID;
         EditText txtPreEnrollmentID;
         LinearLayout secFever;
         View lineFever;
         TextView VlblFever;
         RadioGroup rdogrpFever;
         
         RadioButton rdoFever1;
         RadioButton rdoFever2;
         LinearLayout secFeverDur;
         View lineFeverDur;
         TextView VlblFeverDur;
         EditText txtFeverDur;
         LinearLayout secVomit;
         View lineVomit;
         TextView VlblVomit;
         RadioGroup rdogrpVomit;
         
         RadioButton rdoVomit1;
         RadioButton rdoVomit2;
         LinearLayout secVomitDur;
         View lineVomitDur;
         TextView VlblVomitDur;
         EditText txtVomitDur;
         LinearLayout secOthSymp;
         View lineOthSymp;
         TextView VlblOthSymp;
         RadioGroup rdogrpOthSymp;
         
         RadioButton rdoOthSymp1;
         RadioButton rdoOthSymp2;
         LinearLayout secOthSymp1;
         View lineOthSymp1;
         TextView VlblOthSymp1;
         AutoCompleteTextView txtOthSymp1;
         LinearLayout secOthDur1;
         View lineOthDur1;
         TextView VlblOthDur1;
         EditText txtOthDur1;
         LinearLayout secOthSymp2;
         View lineOthSymp2;
         TextView VlblOthSymp2;
         AutoCompleteTextView txtOthSymp2;
         LinearLayout secOthDur2;
         View lineOthDur2;
         TextView VlblOthDur2;
         EditText txtOthDur2;

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
         setContentView(R.layout.clinicalinfo);
         getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         PREENROLLMENTID = IDbundle.getString("PreEnrollmentID");

         TableName = "ClinicalInfo";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(ClinicalInfo.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});


         secCliLabl=(LinearLayout)findViewById(R.id.secCliLabl);
         lineCliLabl=(View)findViewById(R.id.lineCliLabl);
         secPreEnrollmentID=(LinearLayout)findViewById(R.id.secPreEnrollmentID);
         linePreEnrollmentID=(View)findViewById(R.id.linePreEnrollmentID);
         VlblPreEnrollmentID=(TextView) findViewById(R.id.VlblPreEnrollmentID);
         txtPreEnrollmentID=(EditText) findViewById(R.id.txtPreEnrollmentID);
         txtPreEnrollmentID.setText(PREENROLLMENTID);
         secFever=(LinearLayout)findViewById(R.id.secFever);
         lineFever=(View)findViewById(R.id.lineFever);
         VlblFever = (TextView) findViewById(R.id.VlblFever);
         rdogrpFever = (RadioGroup) findViewById(R.id.rdogrpFever);
         
         rdoFever1 = (RadioButton) findViewById(R.id.rdoFever1);
         rdoFever2 = (RadioButton) findViewById(R.id.rdoFever2);
         rdogrpFever.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpFever = new String[] {"1","2"};
             for (int i = 0; i < rdogrpFever.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpFever.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpFever[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secFeverDur.setVisibility(View.GONE);
                    lineFeverDur.setVisibility(View.GONE);
                    txtFeverDur.setText("");
             }
             else
             {
                    secFeverDur.setVisibility(View.VISIBLE);
                    lineFeverDur.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secFeverDur=(LinearLayout)findViewById(R.id.secFeverDur);
         lineFeverDur=(View)findViewById(R.id.lineFeverDur);
         VlblFeverDur=(TextView) findViewById(R.id.VlblFeverDur);
         txtFeverDur=(EditText) findViewById(R.id.txtFeverDur);
         secVomit=(LinearLayout)findViewById(R.id.secVomit);
         lineVomit=(View)findViewById(R.id.lineVomit);
         VlblVomit = (TextView) findViewById(R.id.VlblVomit);
         rdogrpVomit = (RadioGroup) findViewById(R.id.rdogrpVomit);
         
         rdoVomit1 = (RadioButton) findViewById(R.id.rdoVomit1);
         rdoVomit2 = (RadioButton) findViewById(R.id.rdoVomit2);
         rdogrpVomit.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpVomit = new String[] {"1","2"};
             for (int i = 0; i < rdogrpVomit.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpVomit.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpVomit[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secVomitDur.setVisibility(View.GONE);
                    lineVomitDur.setVisibility(View.GONE);
                    txtVomitDur.setText("");
             }
             else
             {
                    secVomitDur.setVisibility(View.VISIBLE);
                    lineVomitDur.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secVomitDur=(LinearLayout)findViewById(R.id.secVomitDur);
         lineVomitDur=(View)findViewById(R.id.lineVomitDur);
         VlblVomitDur=(TextView) findViewById(R.id.VlblVomitDur);
         txtVomitDur=(EditText) findViewById(R.id.txtVomitDur);
         secOthSymp=(LinearLayout)findViewById(R.id.secOthSymp);
         lineOthSymp=(View)findViewById(R.id.lineOthSymp);
         VlblOthSymp = (TextView) findViewById(R.id.VlblOthSymp);
         rdogrpOthSymp = (RadioGroup) findViewById(R.id.rdogrpOthSymp);
         
         rdoOthSymp1 = (RadioButton) findViewById(R.id.rdoOthSymp1);
         rdoOthSymp2 = (RadioButton) findViewById(R.id.rdoOthSymp2);
         rdogrpOthSymp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpOthSymp = new String[] {"1","2"};
             for (int i = 0; i < rdogrpOthSymp.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpOthSymp.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpOthSymp[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secOthSymp1.setVisibility(View.GONE);
                    lineOthSymp1.setVisibility(View.GONE);
                    txtOthSymp1.setText("");
                    secOthDur1.setVisibility(View.GONE);
                    lineOthDur1.setVisibility(View.GONE);
                    txtOthDur1.setText("");
                    secOthSymp2.setVisibility(View.GONE);
                    lineOthSymp2.setVisibility(View.GONE);
                    txtOthSymp2.setText("");
                    secOthDur2.setVisibility(View.GONE);
                    lineOthDur2.setVisibility(View.GONE);
                    txtOthDur2.setText("");
             }
             else
             {
                    secOthSymp1.setVisibility(View.VISIBLE);
                    lineOthSymp1.setVisibility(View.VISIBLE);
                    secOthDur1.setVisibility(View.VISIBLE);
                    lineOthDur1.setVisibility(View.VISIBLE);
                    secOthSymp2.setVisibility(View.VISIBLE);
                    lineOthSymp2.setVisibility(View.VISIBLE);
                    secOthDur2.setVisibility(View.VISIBLE);
                    lineOthDur2.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secOthSymp1=(LinearLayout)findViewById(R.id.secOthSymp1);
         lineOthSymp1=(View)findViewById(R.id.lineOthSymp1);
         VlblOthSymp1=(TextView) findViewById(R.id.VlblOthSymp1);
         txtOthSymp1=(AutoCompleteTextView) findViewById(R.id.txtOthSymp1);
         txtOthSymp1.setAdapter(C.getArrayAdapter("Select distinct OthSymp1 from "+ TableName +" order by OthSymp1"));

         txtOthSymp1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtOthSymp1.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtOthSymp1.getRight() - txtOthSymp1.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secOthDur1=(LinearLayout)findViewById(R.id.secOthDur1);
         lineOthDur1=(View)findViewById(R.id.lineOthDur1);
         VlblOthDur1=(TextView) findViewById(R.id.VlblOthDur1);
         txtOthDur1=(EditText) findViewById(R.id.txtOthDur1);
         secOthSymp2=(LinearLayout)findViewById(R.id.secOthSymp2);
         lineOthSymp2=(View)findViewById(R.id.lineOthSymp2);
         VlblOthSymp2=(TextView) findViewById(R.id.VlblOthSymp2);
         txtOthSymp2=(AutoCompleteTextView) findViewById(R.id.txtOthSymp2);
         txtOthSymp2.setAdapter(C.getArrayAdapter("Select distinct OthSymp2 from "+ TableName +" order by OthSymp2"));

         txtOthSymp2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtOthSymp2.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtOthSymp2.getRight() - txtOthSymp2.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secOthDur2=(LinearLayout)findViewById(R.id.secOthDur2);
         lineOthDur2=(View)findViewById(R.id.lineOthDur2);
         VlblOthDur2=(TextView) findViewById(R.id.VlblOthDur2);
         txtOthDur2=(EditText) findViewById(R.id.txtOthDur2);





         //Hide all skip variables
         secFeverDur.setVisibility(View.GONE);
         lineFeverDur.setVisibility(View.GONE);
         secVomitDur.setVisibility(View.GONE);
         lineVomitDur.setVisibility(View.GONE);
         secOthSymp1.setVisibility(View.GONE);
         lineOthSymp1.setVisibility(View.GONE);
         secOthDur1.setVisibility(View.GONE);
         lineOthDur1.setVisibility(View.GONE);
         secOthSymp2.setVisibility(View.GONE);
         lineOthSymp2.setVisibility(View.GONE);
         secOthDur2.setVisibility(View.GONE);
         lineOthDur2.setVisibility(View.GONE);


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(ClinicalInfo.this, e.getMessage());
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
             Connection.MessageBox(ClinicalInfo.this, "Required field: PreEnrollment ID.");
             txtPreEnrollmentID.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0 ? "1" : txtPreEnrollmentID.getText().toString()) < 1 || Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0 ? "88888888" : txtPreEnrollmentID.getText().toString()) > 88888888)
           {
             Connection.MessageBox(ClinicalInfo.this, "Value should be between 1 and 88888888(PreEnrollment ID).");
             txtPreEnrollmentID.requestFocus(); 
             return;	
           }
         
         else if(!rdoFever1.isChecked() & !rdoFever2.isChecked() & secFever.isShown())
           {
              Connection.MessageBox(ClinicalInfo.this, "Select anyone options from (Fever).");
              rdoFever1.requestFocus();
              return;
           }
         else if(txtFeverDur.getText().toString().length()==0 & secFeverDur.isShown())
           {
             Connection.MessageBox(ClinicalInfo.this, "Required field: 1. Fever duration (days).");
             txtFeverDur.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtFeverDur.getText().toString().length()==0 ? "00" : txtFeverDur.getText().toString()) < 00 || Integer.valueOf(txtFeverDur.getText().toString().length()==0 ? "88" : txtFeverDur.getText().toString()) > 88)
           {
             Connection.MessageBox(ClinicalInfo.this, "Value should be between 00 and 88(1. Fever duration (days)).");
             txtFeverDur.requestFocus(); 
             return;	
           }
         
         else if(!rdoVomit1.isChecked() & !rdoVomit2.isChecked() & secVomit.isShown())
           {
              Connection.MessageBox(ClinicalInfo.this, "Select anyone options from (Vomitting).");
              rdoVomit1.requestFocus();
              return;
           }
         else if(txtVomitDur.getText().toString().length()==0 & secVomitDur.isShown())
           {
             Connection.MessageBox(ClinicalInfo.this, "Required field: 1. Vomiting duration (days).");
             txtVomitDur.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtVomitDur.getText().toString().length()==0 ? "00" : txtVomitDur.getText().toString()) < 00 || Integer.valueOf(txtVomitDur.getText().toString().length()==0 ? "88" : txtVomitDur.getText().toString()) > 88)
           {
             Connection.MessageBox(ClinicalInfo.this, "Value should be between 00 and 88(1. Vomiting duration (days)).");
             txtVomitDur.requestFocus(); 
             return;	
           }
         
         else if(!rdoOthSymp1.isChecked() & !rdoOthSymp2.isChecked() & secOthSymp.isShown())
           {
              Connection.MessageBox(ClinicalInfo.this, "Select anyone options from (Other symptomps).");
              rdoOthSymp1.requestFocus();
              return;
           }
         else if(txtOthSymp1.getText().toString().length()==0 & secOthSymp1.isShown())
           {
             Connection.MessageBox(ClinicalInfo.this, "Required field: 1. Other symptomps 1.");
             txtOthSymp1.requestFocus(); 
             return;	
           }
         else if(txtOthDur1.getText().toString().length()==0 & secOthDur1.isShown())
           {
             Connection.MessageBox(ClinicalInfo.this, "Required field: 1.1. Other symptomps 1 duration (days).");
             txtOthDur1.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtOthDur1.getText().toString().length()==0 ? "00" : txtOthDur1.getText().toString()) < 00 || Integer.valueOf(txtOthDur1.getText().toString().length()==0 ? "88" : txtOthDur1.getText().toString()) > 88)
           {
             Connection.MessageBox(ClinicalInfo.this, "Value should be between 00 and 88(1.1. Other symptomps 1 duration (days)).");
             txtOthDur1.requestFocus(); 
             return;	
           }
         else if(txtOthSymp2.getText().toString().length()==0 & secOthSymp2.isShown())
           {
             Connection.MessageBox(ClinicalInfo.this, "Required field: 2. Other symptoms 2.");
             txtOthSymp2.requestFocus(); 
             return;	
           }
         else if(txtOthDur2.getText().toString().length()==0 & secOthDur2.isShown())
           {
             Connection.MessageBox(ClinicalInfo.this, "Required field: 2.1. Other symptomps 2 duration (days).");
             txtOthDur2.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtOthDur2.getText().toString().length()==0 ? "00" : txtOthDur2.getText().toString()) < 00 || Integer.valueOf(txtOthDur2.getText().toString().length()==0 ? "88" : txtOthDur2.getText().toString()) > 88)
           {
             Connection.MessageBox(ClinicalInfo.this, "Value should be between 00 and 88(2.1. Other symptomps 2 duration (days)).");
             txtOthDur2.requestFocus(); 
             return;	
           }
 
         String SQL = "";
         RadioButton rb;

         ClinicalInfo_DataModel objSave = new ClinicalInfo_DataModel();
         objSave.setPreEnrollmentID(Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0?"0":txtPreEnrollmentID.getText().toString()));
         String[] d_rdogrpFever = new String[] {"1","2"};
         objSave.setFever(0);
         for (int i = 0; i < rdogrpFever.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpFever.getChildAt(i);
             if (rb.isChecked()) objSave.setFever(Integer.valueOf(d_rdogrpFever[i]));
         }

         objSave.setFeverDur(Integer.valueOf(txtFeverDur.getText().toString().length()==0?"0":txtFeverDur.getText().toString()));
         String[] d_rdogrpVomit = new String[] {"1","2"};
         objSave.setVomit(0);
         for (int i = 0; i < rdogrpVomit.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpVomit.getChildAt(i);
             if (rb.isChecked()) objSave.setVomit(Integer.valueOf(d_rdogrpVomit[i]));
         }

         objSave.setVomitDur(Integer.valueOf(txtVomitDur.getText().toString().length()==0?"0":txtVomitDur.getText().toString()));
         String[] d_rdogrpOthSymp = new String[] {"1","2"};
         objSave.setOthSymp(0);
         for (int i = 0; i < rdogrpOthSymp.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpOthSymp.getChildAt(i);
             if (rb.isChecked()) objSave.setOthSymp(Integer.valueOf(d_rdogrpOthSymp[i]));
         }

         objSave.setOthSymp1(txtOthSymp1.getText().toString());
         objSave.setOthDur1(Integer.valueOf(txtOthDur1.getText().toString().length()==0?"0":txtOthDur1.getText().toString()));
         objSave.setOthSymp2(txtOthSymp2.getText().toString());
         objSave.setOthDur2(Integer.valueOf(txtOthDur2.getText().toString().length()==0?"0":txtOthDur2.getText().toString()));
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

             Connection.MessageBox(ClinicalInfo.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(ClinicalInfo.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(ClinicalInfo.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String PreEnrollmentID)
     {
       try
        {
     
           RadioButton rb;
           ClinicalInfo_DataModel d = new ClinicalInfo_DataModel();
           String SQL = "Select * from "+ TableName +"  Where PreEnrollmentID='"+ PreEnrollmentID +"'";
           List<ClinicalInfo_DataModel> data = d.SelectAll(this, SQL);
           for(ClinicalInfo_DataModel item : data){
             txtPreEnrollmentID.setText(String.valueOf(item.getPreEnrollmentID()));
             String[] d_rdogrpFever = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpFever.length; i++)
             {
                 if (String.valueOf(item.getFever()).equals(String.valueOf(d_rdogrpFever[i])))
                 {
                     rb = (RadioButton)rdogrpFever.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtFeverDur.setText(String.valueOf(item.getFeverDur()));
             String[] d_rdogrpVomit = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpVomit.length; i++)
             {
                 if (String.valueOf(item.getVomit()).equals(String.valueOf(d_rdogrpVomit[i])))
                 {
                     rb = (RadioButton)rdogrpVomit.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtVomitDur.setText(String.valueOf(item.getVomitDur()));
             String[] d_rdogrpOthSymp = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpOthSymp.length; i++)
             {
                 if (String.valueOf(item.getOthSymp()).equals(String.valueOf(d_rdogrpOthSymp[i])))
                 {
                     rb = (RadioButton)rdogrpOthSymp.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtOthSymp1.setText(item.getOthSymp1());
             txtOthDur1.setText(String.valueOf(item.getOthDur1()));
             txtOthSymp2.setText(item.getOthSymp2());
             txtOthDur2.setText(String.valueOf(item.getOthDur2()));
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(ClinicalInfo.this, e.getMessage());
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