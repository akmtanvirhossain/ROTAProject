
 package org.icddrb.rotaproject;


 //Android Manifest Code
 //<activity android:name=".Discharge" android:label="Discharge" />
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

 public class Discharge extends Activity {
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
         LinearLayout secDisLabl1;
         View lineDisLabl1;
         LinearLayout secPreEnrollmentID;
         View linePreEnrollmentID;
         TextView VlblPreEnrollmentID;
         EditText txtPreEnrollmentID;
         LinearLayout secDisDate;
         View lineDisDate;
         TextView VlblDisDate;
         EditText dtpDisDate;
         LinearLayout secFinalDiag1;
         View lineFinalDiag1;
         TextView VlblFinalDiag1;
         AutoCompleteTextView txtFinalDiag1;
         LinearLayout secFinalDiag2;
         View lineFinalDiag2;
         TextView VlblFinalDiag2;
         AutoCompleteTextView txtFinalDiag2;
         LinearLayout secFinalDiag3;
         View lineFinalDiag3;
         TextView VlblFinalDiag3;
         AutoCompleteTextView txtFinalDiag3;
         LinearLayout secFinalDiag4;
         View lineFinalDiag4;
         TextView VlblFinalDiag4;
         AutoCompleteTextView txtFinalDiag4;
         LinearLayout secFinalDiag5;
         View lineFinalDiag5;
         TextView VlblFinalDiag5;
         AutoCompleteTextView txtFinalDiag5;
         LinearLayout secHOutcome;
         View lineHOutcome;
         TextView VlblHOutcome;
         RadioGroup rdogrpHOutcome;
         
         RadioButton rdoHOutcome1;
         RadioButton rdoHOutcome2;
         RadioButton rdoHOutcome3;
         RadioButton rdoHOutcome4;
         RadioButton rdoHOutcome5;
         LinearLayout secDisLabl2;
         View lineDisLabl2;
         LinearLayout secIntFluid;
         View lineIntFluid;
         TextView VlblIntFluid;
         RadioGroup rdogrpIntFluid;
         
         RadioButton rdoIntFluid1;
         RadioButton rdoIntFluid2;
         LinearLayout secAntibiotic;
         View lineAntibiotic;
         TextView VlblAntibiotic;
         RadioGroup rdogrpAntibiotic;
         
         RadioButton rdoAntibiotic1;
         RadioButton rdoAntibiotic2;
         LinearLayout secAntibiotic1;
         View lineAntibiotic1;
         TextView VlblAntibiotic1;
         AutoCompleteTextView txtAntibiotic1;
         LinearLayout secSDateAnti1;
         View lineSDateAnti1;
         TextView VlblSDateAnti1;
         EditText dtpSDateAnti1;
         LinearLayout secEDateAnti1;
         View lineEDateAnti1;
         TextView VlblEDateAnti1;
         EditText dtpEDateAnti1;
         LinearLayout secAntibiotic2;
         View lineAntibiotic2;
         TextView VlblAntibiotic2;
         AutoCompleteTextView txtAntibiotic2;
         LinearLayout secSDateAnti2;
         View lineSDateAnti2;
         TextView VlblSDateAnti2;
         EditText dtpSDateAnti2;
         LinearLayout secEDateAnti2;
         View lineEDateAnti2;
         TextView VlblEDateAnti2;
         EditText dtpEDateAnti2;
         LinearLayout secAntibiotic3;
         View lineAntibiotic3;
         TextView VlblAntibiotic3;
         AutoCompleteTextView txtAntibiotic3;
         LinearLayout secSDateAnti3;
         View lineSDateAnti3;
         TextView VlblSDateAnti3;
         EditText dtpSDateAnti3;
         LinearLayout secEDateAnti3;
         View lineEDateAnti3;
         TextView VlblEDateAnti3;
         EditText dtpEDateAnti3;
         LinearLayout secAntibiotic4;
         View lineAntibiotic4;
         TextView VlblAntibiotic4;
         AutoCompleteTextView txtAntibiotic4;
         LinearLayout secSDateAnti4;
         View lineSDateAnti4;
         TextView VlblSDateAnti4;
         EditText dtpSDateAnti4;
         LinearLayout secEDateAnti4;
         View lineEDateAnti4;
         TextView VlblEDateAnti4;
         EditText dtpEDateAnti4;
         LinearLayout secAntibiotic5;
         View lineAntibiotic5;
         TextView VlblAntibiotic5;
         AutoCompleteTextView txtAntibiotic5;
         LinearLayout secSDateAnti5;
         View lineSDateAnti5;
         TextView VlblSDateAnti5;
         EditText dtpSDateAnti5;
         LinearLayout secEDateAnti5;
         View lineEDateAnti5;
         TextView VlblEDateAnti5;
         EditText dtpEDateAnti5;
         LinearLayout secDtEnrolled;
         View lineDtEnrolled;
         TextView VlblDtEnrolled;
         EditText dtpDtEnrolled;
         LinearLayout secTmEnrolled;
         View lineTmEnrolled;
         TextView VlblTmEnrolled;
         EditText txtTmEnrolled;

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
         setContentView(R.layout.discharge);
         getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         PREENROLLMENTID = IDbundle.getString("PreEnrollmentID");

         TableName = "Discharge";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Discharge.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});


         secDisLabl1=(LinearLayout)findViewById(R.id.secDisLabl1);
         lineDisLabl1=(View)findViewById(R.id.lineDisLabl1);
         secPreEnrollmentID=(LinearLayout)findViewById(R.id.secPreEnrollmentID);
         linePreEnrollmentID=(View)findViewById(R.id.linePreEnrollmentID);
         VlblPreEnrollmentID=(TextView) findViewById(R.id.VlblPreEnrollmentID);
         txtPreEnrollmentID=(EditText) findViewById(R.id.txtPreEnrollmentID);
         txtPreEnrollmentID.setText(PREENROLLMENTID);
         secDisDate=(LinearLayout)findViewById(R.id.secDisDate);
         lineDisDate=(View)findViewById(R.id.lineDisDate);
         VlblDisDate=(TextView) findViewById(R.id.VlblDisDate);
         dtpDisDate=(EditText) findViewById(R.id.dtpDisDate);
         secFinalDiag1=(LinearLayout)findViewById(R.id.secFinalDiag1);
         lineFinalDiag1=(View)findViewById(R.id.lineFinalDiag1);
         VlblFinalDiag1=(TextView) findViewById(R.id.VlblFinalDiag1);
         txtFinalDiag1=(AutoCompleteTextView) findViewById(R.id.txtFinalDiag1);
         txtFinalDiag1.setAdapter(C.getArrayAdapter("Select distinct FinalDiag1 from "+ TableName +" order by FinalDiag1"));

         txtFinalDiag1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtFinalDiag1.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtFinalDiag1.getRight() - txtFinalDiag1.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secFinalDiag2=(LinearLayout)findViewById(R.id.secFinalDiag2);
         lineFinalDiag2=(View)findViewById(R.id.lineFinalDiag2);
         VlblFinalDiag2=(TextView) findViewById(R.id.VlblFinalDiag2);
         txtFinalDiag2=(AutoCompleteTextView) findViewById(R.id.txtFinalDiag2);
         txtFinalDiag2.setAdapter(C.getArrayAdapter("Select distinct FinalDiag2 from "+ TableName +" order by FinalDiag2"));

         txtFinalDiag2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtFinalDiag2.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtFinalDiag2.getRight() - txtFinalDiag2.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secFinalDiag3=(LinearLayout)findViewById(R.id.secFinalDiag3);
         lineFinalDiag3=(View)findViewById(R.id.lineFinalDiag3);
         VlblFinalDiag3=(TextView) findViewById(R.id.VlblFinalDiag3);
         txtFinalDiag3=(AutoCompleteTextView) findViewById(R.id.txtFinalDiag3);
         txtFinalDiag3.setAdapter(C.getArrayAdapter("Select distinct FinalDiag3 from "+ TableName +" order by FinalDiag3"));

         txtFinalDiag3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtFinalDiag3.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtFinalDiag3.getRight() - txtFinalDiag3.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secFinalDiag4=(LinearLayout)findViewById(R.id.secFinalDiag4);
         lineFinalDiag4=(View)findViewById(R.id.lineFinalDiag4);
         VlblFinalDiag4=(TextView) findViewById(R.id.VlblFinalDiag4);
         txtFinalDiag4=(AutoCompleteTextView) findViewById(R.id.txtFinalDiag4);
         txtFinalDiag4.setAdapter(C.getArrayAdapter("Select distinct FinalDiag4 from "+ TableName +" order by FinalDiag4"));

         txtFinalDiag4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtFinalDiag4.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtFinalDiag4.getRight() - txtFinalDiag4.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secFinalDiag5=(LinearLayout)findViewById(R.id.secFinalDiag5);
         lineFinalDiag5=(View)findViewById(R.id.lineFinalDiag5);
         VlblFinalDiag5=(TextView) findViewById(R.id.VlblFinalDiag5);
         txtFinalDiag5=(AutoCompleteTextView) findViewById(R.id.txtFinalDiag5);
         txtFinalDiag5.setAdapter(C.getArrayAdapter("Select distinct FinalDiag5 from "+ TableName +" order by FinalDiag5"));

         txtFinalDiag5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtFinalDiag5.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtFinalDiag5.getRight() - txtFinalDiag5.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secHOutcome=(LinearLayout)findViewById(R.id.secHOutcome);
         lineHOutcome=(View)findViewById(R.id.lineHOutcome);
         VlblHOutcome = (TextView) findViewById(R.id.VlblHOutcome);
         rdogrpHOutcome = (RadioGroup) findViewById(R.id.rdogrpHOutcome);
         
         rdoHOutcome1 = (RadioButton) findViewById(R.id.rdoHOutcome1);
         rdoHOutcome2 = (RadioButton) findViewById(R.id.rdoHOutcome2);
         rdoHOutcome3 = (RadioButton) findViewById(R.id.rdoHOutcome3);
         rdoHOutcome4 = (RadioButton) findViewById(R.id.rdoHOutcome4);
         rdoHOutcome5 = (RadioButton) findViewById(R.id.rdoHOutcome5);
         secDisLabl2=(LinearLayout)findViewById(R.id.secDisLabl2);
         lineDisLabl2=(View)findViewById(R.id.lineDisLabl2);
         secIntFluid=(LinearLayout)findViewById(R.id.secIntFluid);
         lineIntFluid=(View)findViewById(R.id.lineIntFluid);
         VlblIntFluid = (TextView) findViewById(R.id.VlblIntFluid);
         rdogrpIntFluid = (RadioGroup) findViewById(R.id.rdogrpIntFluid);
         
         rdoIntFluid1 = (RadioButton) findViewById(R.id.rdoIntFluid1);
         rdoIntFluid2 = (RadioButton) findViewById(R.id.rdoIntFluid2);
         secAntibiotic=(LinearLayout)findViewById(R.id.secAntibiotic);
         lineAntibiotic=(View)findViewById(R.id.lineAntibiotic);
         VlblAntibiotic = (TextView) findViewById(R.id.VlblAntibiotic);
         rdogrpAntibiotic = (RadioGroup) findViewById(R.id.rdogrpAntibiotic);
         
         rdoAntibiotic1 = (RadioButton) findViewById(R.id.rdoAntibiotic1);
         rdoAntibiotic2 = (RadioButton) findViewById(R.id.rdoAntibiotic2);
         rdogrpAntibiotic.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpAntibiotic = new String[] {"1","2"};
             for (int i = 0; i < rdogrpAntibiotic.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpAntibiotic.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpAntibiotic[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secAntibiotic1.setVisibility(View.GONE);
                    lineAntibiotic1.setVisibility(View.GONE);
                    txtAntibiotic1.setText("");
                    secSDateAnti1.setVisibility(View.GONE);
                    lineSDateAnti1.setVisibility(View.GONE);
                    dtpSDateAnti1.setText("");
                    secEDateAnti1.setVisibility(View.GONE);
                    lineEDateAnti1.setVisibility(View.GONE);
                    dtpEDateAnti1.setText("");
                    secAntibiotic2.setVisibility(View.GONE);
                    lineAntibiotic2.setVisibility(View.GONE);
                    txtAntibiotic2.setText("");
                    secSDateAnti2.setVisibility(View.GONE);
                    lineSDateAnti2.setVisibility(View.GONE);
                    dtpSDateAnti2.setText("");
                    secEDateAnti2.setVisibility(View.GONE);
                    lineEDateAnti2.setVisibility(View.GONE);
                    dtpEDateAnti2.setText("");
                    secAntibiotic3.setVisibility(View.GONE);
                    lineAntibiotic3.setVisibility(View.GONE);
                    txtAntibiotic3.setText("");
                    secSDateAnti3.setVisibility(View.GONE);
                    lineSDateAnti3.setVisibility(View.GONE);
                    dtpSDateAnti3.setText("");
                    secEDateAnti3.setVisibility(View.GONE);
                    lineEDateAnti3.setVisibility(View.GONE);
                    dtpEDateAnti3.setText("");
                    secAntibiotic4.setVisibility(View.GONE);
                    lineAntibiotic4.setVisibility(View.GONE);
                    txtAntibiotic4.setText("");
                    secSDateAnti4.setVisibility(View.GONE);
                    lineSDateAnti4.setVisibility(View.GONE);
                    dtpSDateAnti4.setText("");
                    secEDateAnti4.setVisibility(View.GONE);
                    lineEDateAnti4.setVisibility(View.GONE);
                    dtpEDateAnti4.setText("");
                    secAntibiotic5.setVisibility(View.GONE);
                    lineAntibiotic5.setVisibility(View.GONE);
                    txtAntibiotic5.setText("");
                    secSDateAnti5.setVisibility(View.GONE);
                    lineSDateAnti5.setVisibility(View.GONE);
                    dtpSDateAnti5.setText("");
                    secEDateAnti5.setVisibility(View.GONE);
                    lineEDateAnti5.setVisibility(View.GONE);
                    dtpEDateAnti5.setText("");
             }
             else
             {
                    secAntibiotic1.setVisibility(View.VISIBLE);
                    lineAntibiotic1.setVisibility(View.VISIBLE);
                    secSDateAnti1.setVisibility(View.VISIBLE);
                    lineSDateAnti1.setVisibility(View.VISIBLE);
                    secEDateAnti1.setVisibility(View.VISIBLE);
                    lineEDateAnti1.setVisibility(View.VISIBLE);
                    secAntibiotic2.setVisibility(View.VISIBLE);
                    lineAntibiotic2.setVisibility(View.VISIBLE);
                    secSDateAnti2.setVisibility(View.VISIBLE);
                    lineSDateAnti2.setVisibility(View.VISIBLE);
                    secEDateAnti2.setVisibility(View.VISIBLE);
                    lineEDateAnti2.setVisibility(View.VISIBLE);
                    secAntibiotic3.setVisibility(View.VISIBLE);
                    lineAntibiotic3.setVisibility(View.VISIBLE);
                    secSDateAnti3.setVisibility(View.VISIBLE);
                    lineSDateAnti3.setVisibility(View.VISIBLE);
                    secEDateAnti3.setVisibility(View.VISIBLE);
                    lineEDateAnti3.setVisibility(View.VISIBLE);
                    secAntibiotic4.setVisibility(View.VISIBLE);
                    lineAntibiotic4.setVisibility(View.VISIBLE);
                    secSDateAnti4.setVisibility(View.VISIBLE);
                    lineSDateAnti4.setVisibility(View.VISIBLE);
                    secEDateAnti4.setVisibility(View.VISIBLE);
                    lineEDateAnti4.setVisibility(View.VISIBLE);
                    secAntibiotic5.setVisibility(View.VISIBLE);
                    lineAntibiotic5.setVisibility(View.VISIBLE);
                    secSDateAnti5.setVisibility(View.VISIBLE);
                    lineSDateAnti5.setVisibility(View.VISIBLE);
                    secEDateAnti5.setVisibility(View.VISIBLE);
                    lineEDateAnti5.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secAntibiotic1=(LinearLayout)findViewById(R.id.secAntibiotic1);
         lineAntibiotic1=(View)findViewById(R.id.lineAntibiotic1);
         VlblAntibiotic1=(TextView) findViewById(R.id.VlblAntibiotic1);
         txtAntibiotic1=(AutoCompleteTextView) findViewById(R.id.txtAntibiotic1);
         txtAntibiotic1.setAdapter(C.getArrayAdapter("Select distinct Antibiotic1 from "+ TableName +" order by Antibiotic1"));

         txtAntibiotic1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtAntibiotic1.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtAntibiotic1.getRight() - txtAntibiotic1.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secSDateAnti1=(LinearLayout)findViewById(R.id.secSDateAnti1);
         lineSDateAnti1=(View)findViewById(R.id.lineSDateAnti1);
         VlblSDateAnti1=(TextView) findViewById(R.id.VlblSDateAnti1);
         dtpSDateAnti1=(EditText) findViewById(R.id.dtpSDateAnti1);
         secEDateAnti1=(LinearLayout)findViewById(R.id.secEDateAnti1);
         lineEDateAnti1=(View)findViewById(R.id.lineEDateAnti1);
         VlblEDateAnti1=(TextView) findViewById(R.id.VlblEDateAnti1);
         dtpEDateAnti1=(EditText) findViewById(R.id.dtpEDateAnti1);
         secAntibiotic2=(LinearLayout)findViewById(R.id.secAntibiotic2);
         lineAntibiotic2=(View)findViewById(R.id.lineAntibiotic2);
         VlblAntibiotic2=(TextView) findViewById(R.id.VlblAntibiotic2);
         txtAntibiotic2=(AutoCompleteTextView) findViewById(R.id.txtAntibiotic2);
         txtAntibiotic2.setAdapter(C.getArrayAdapter("Select distinct Antibiotic2 from "+ TableName +" order by Antibiotic2"));

         txtAntibiotic2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtAntibiotic2.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtAntibiotic2.getRight() - txtAntibiotic2.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secSDateAnti2=(LinearLayout)findViewById(R.id.secSDateAnti2);
         lineSDateAnti2=(View)findViewById(R.id.lineSDateAnti2);
         VlblSDateAnti2=(TextView) findViewById(R.id.VlblSDateAnti2);
         dtpSDateAnti2=(EditText) findViewById(R.id.dtpSDateAnti2);
         secEDateAnti2=(LinearLayout)findViewById(R.id.secEDateAnti2);
         lineEDateAnti2=(View)findViewById(R.id.lineEDateAnti2);
         VlblEDateAnti2=(TextView) findViewById(R.id.VlblEDateAnti2);
         dtpEDateAnti2=(EditText) findViewById(R.id.dtpEDateAnti2);
         secAntibiotic3=(LinearLayout)findViewById(R.id.secAntibiotic3);
         lineAntibiotic3=(View)findViewById(R.id.lineAntibiotic3);
         VlblAntibiotic3=(TextView) findViewById(R.id.VlblAntibiotic3);
         txtAntibiotic3=(AutoCompleteTextView) findViewById(R.id.txtAntibiotic3);
         txtAntibiotic3.setAdapter(C.getArrayAdapter("Select distinct Antibiotic3 from "+ TableName +" order by Antibiotic3"));

         txtAntibiotic3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtAntibiotic3.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtAntibiotic3.getRight() - txtAntibiotic3.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secSDateAnti3=(LinearLayout)findViewById(R.id.secSDateAnti3);
         lineSDateAnti3=(View)findViewById(R.id.lineSDateAnti3);
         VlblSDateAnti3=(TextView) findViewById(R.id.VlblSDateAnti3);
         dtpSDateAnti3=(EditText) findViewById(R.id.dtpSDateAnti3);
         secEDateAnti3=(LinearLayout)findViewById(R.id.secEDateAnti3);
         lineEDateAnti3=(View)findViewById(R.id.lineEDateAnti3);
         VlblEDateAnti3=(TextView) findViewById(R.id.VlblEDateAnti3);
         dtpEDateAnti3=(EditText) findViewById(R.id.dtpEDateAnti3);
         secAntibiotic4=(LinearLayout)findViewById(R.id.secAntibiotic4);
         lineAntibiotic4=(View)findViewById(R.id.lineAntibiotic4);
         VlblAntibiotic4=(TextView) findViewById(R.id.VlblAntibiotic4);
         txtAntibiotic4=(AutoCompleteTextView) findViewById(R.id.txtAntibiotic4);
         txtAntibiotic4.setAdapter(C.getArrayAdapter("Select distinct Antibiotic4 from "+ TableName +" order by Antibiotic4"));

         txtAntibiotic4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtAntibiotic4.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtAntibiotic4.getRight() - txtAntibiotic4.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secSDateAnti4=(LinearLayout)findViewById(R.id.secSDateAnti4);
         lineSDateAnti4=(View)findViewById(R.id.lineSDateAnti4);
         VlblSDateAnti4=(TextView) findViewById(R.id.VlblSDateAnti4);
         dtpSDateAnti4=(EditText) findViewById(R.id.dtpSDateAnti4);
         secEDateAnti4=(LinearLayout)findViewById(R.id.secEDateAnti4);
         lineEDateAnti4=(View)findViewById(R.id.lineEDateAnti4);
         VlblEDateAnti4=(TextView) findViewById(R.id.VlblEDateAnti4);
         dtpEDateAnti4=(EditText) findViewById(R.id.dtpEDateAnti4);
         secAntibiotic5=(LinearLayout)findViewById(R.id.secAntibiotic5);
         lineAntibiotic5=(View)findViewById(R.id.lineAntibiotic5);
         VlblAntibiotic5=(TextView) findViewById(R.id.VlblAntibiotic5);
         txtAntibiotic5=(AutoCompleteTextView) findViewById(R.id.txtAntibiotic5);
         txtAntibiotic5.setAdapter(C.getArrayAdapter("Select distinct Antibiotic5 from "+ TableName +" order by Antibiotic5"));

         txtAntibiotic5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtAntibiotic5.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtAntibiotic5.getRight() - txtAntibiotic5.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secSDateAnti5=(LinearLayout)findViewById(R.id.secSDateAnti5);
         lineSDateAnti5=(View)findViewById(R.id.lineSDateAnti5);
         VlblSDateAnti5=(TextView) findViewById(R.id.VlblSDateAnti5);
         dtpSDateAnti5=(EditText) findViewById(R.id.dtpSDateAnti5);
         secEDateAnti5=(LinearLayout)findViewById(R.id.secEDateAnti5);
         lineEDateAnti5=(View)findViewById(R.id.lineEDateAnti5);
         VlblEDateAnti5=(TextView) findViewById(R.id.VlblEDateAnti5);
         dtpEDateAnti5=(EditText) findViewById(R.id.dtpEDateAnti5);
         secDtEnrolled=(LinearLayout)findViewById(R.id.secDtEnrolled);
         lineDtEnrolled=(View)findViewById(R.id.lineDtEnrolled);
         VlblDtEnrolled=(TextView) findViewById(R.id.VlblDtEnrolled);
         dtpDtEnrolled=(EditText) findViewById(R.id.dtpDtEnrolled);
         secTmEnrolled=(LinearLayout)findViewById(R.id.secTmEnrolled);
         lineTmEnrolled=(View)findViewById(R.id.lineTmEnrolled);
         VlblTmEnrolled=(TextView) findViewById(R.id.VlblTmEnrolled);
         txtTmEnrolled=(EditText) findViewById(R.id.txtTmEnrolled);


         dtpDisDate.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpDisDate.getRight() - dtpDisDate.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnDisDate"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpSDateAnti1.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpSDateAnti1.getRight() - dtpSDateAnti1.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnSDateAnti1"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpEDateAnti1.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpEDateAnti1.getRight() - dtpEDateAnti1.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnEDateAnti1"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpSDateAnti2.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpSDateAnti2.getRight() - dtpSDateAnti2.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnSDateAnti2"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpEDateAnti2.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpEDateAnti2.getRight() - dtpEDateAnti2.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnEDateAnti2"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpSDateAnti3.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpSDateAnti3.getRight() - dtpSDateAnti3.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnSDateAnti3"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpEDateAnti3.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpEDateAnti3.getRight() - dtpEDateAnti3.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnEDateAnti3"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpSDateAnti4.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpSDateAnti4.getRight() - dtpSDateAnti4.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnSDateAnti4"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpEDateAnti4.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpEDateAnti4.getRight() - dtpEDateAnti4.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnEDateAnti4"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpSDateAnti5.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpSDateAnti5.getRight() - dtpSDateAnti5.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnSDateAnti5"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpEDateAnti5.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpEDateAnti5.getRight() - dtpEDateAnti5.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnEDateAnti5"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpDtEnrolled.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpDtEnrolled.getRight() - dtpDtEnrolled.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnDtEnrolled"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });


         txtTmEnrolled.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtTmEnrolled.getRight() - txtTmEnrolled.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btnTmEnrolled"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });

         //Hide all skip variables
         secAntibiotic1.setVisibility(View.GONE);
         lineAntibiotic1.setVisibility(View.GONE);
         secSDateAnti1.setVisibility(View.GONE);
         lineSDateAnti1.setVisibility(View.GONE);
         secEDateAnti1.setVisibility(View.GONE);
         lineEDateAnti1.setVisibility(View.GONE);
         secAntibiotic2.setVisibility(View.GONE);
         lineAntibiotic2.setVisibility(View.GONE);
         secSDateAnti2.setVisibility(View.GONE);
         lineSDateAnti2.setVisibility(View.GONE);
         secEDateAnti2.setVisibility(View.GONE);
         lineEDateAnti2.setVisibility(View.GONE);
         secAntibiotic3.setVisibility(View.GONE);
         lineAntibiotic3.setVisibility(View.GONE);
         secSDateAnti3.setVisibility(View.GONE);
         lineSDateAnti3.setVisibility(View.GONE);
         secEDateAnti3.setVisibility(View.GONE);
         lineEDateAnti3.setVisibility(View.GONE);
         secAntibiotic4.setVisibility(View.GONE);
         lineAntibiotic4.setVisibility(View.GONE);
         secSDateAnti4.setVisibility(View.GONE);
         lineSDateAnti4.setVisibility(View.GONE);
         secEDateAnti4.setVisibility(View.GONE);
         lineEDateAnti4.setVisibility(View.GONE);
         secAntibiotic5.setVisibility(View.GONE);
         lineAntibiotic5.setVisibility(View.GONE);
         secSDateAnti5.setVisibility(View.GONE);
         lineSDateAnti5.setVisibility(View.GONE);
         secEDateAnti5.setVisibility(View.GONE);
         lineEDateAnti5.setVisibility(View.GONE);


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Discharge.this, e.getMessage());
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
             Connection.MessageBox(Discharge.this, "Required field: PreEnrollment ID.");
             txtPreEnrollmentID.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0 ? "00000001" : txtPreEnrollmentID.getText().toString()) < 00000001 || Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0 ? "88888888" : txtPreEnrollmentID.getText().toString()) > 88888888)
           {
             Connection.MessageBox(Discharge.this, "Value should be between 00000001 and 88888888(PreEnrollment ID).");
             txtPreEnrollmentID.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpDisDate.getText().toString());
         if(DV.length()!=0 & secDisDate.isShown())
           {
             Connection.MessageBox(Discharge.this, DV);
             dtpDisDate.requestFocus(); 
             return;	
           }
         else if(txtFinalDiag1.getText().toString().length()==0 & secFinalDiag1.isShown())
           {
             Connection.MessageBox(Discharge.this, "Required field: 1. Final diagnosis.");
             txtFinalDiag1.requestFocus(); 
             return;	
           }
         else if(txtFinalDiag2.getText().toString().length()==0 & secFinalDiag2.isShown())
           {
             Connection.MessageBox(Discharge.this, "Required field: 2. Final diagnosis.");
             txtFinalDiag2.requestFocus(); 
             return;	
           }
         else if(txtFinalDiag3.getText().toString().length()==0 & secFinalDiag3.isShown())
           {
             Connection.MessageBox(Discharge.this, "Required field: 3. Final diagnosis.");
             txtFinalDiag3.requestFocus(); 
             return;	
           }
         else if(txtFinalDiag4.getText().toString().length()==0 & secFinalDiag4.isShown())
           {
             Connection.MessageBox(Discharge.this, "Required field: 4. Final diagnosis.");
             txtFinalDiag4.requestFocus(); 
             return;	
           }
         else if(txtFinalDiag5.getText().toString().length()==0 & secFinalDiag5.isShown())
           {
             Connection.MessageBox(Discharge.this, "Required field: 5. Final diagnosis.");
             txtFinalDiag5.requestFocus(); 
             return;	
           }
         
         else if(!rdoHOutcome1.isChecked() & !rdoHOutcome2.isChecked() & !rdoHOutcome3.isChecked() & !rdoHOutcome4.isChecked() & !rdoHOutcome5.isChecked() & secHOutcome.isShown())
           {
              Connection.MessageBox(Discharge.this, "Select anyone options from (Hospital outcome).");
              rdoHOutcome1.requestFocus();
              return;
           }
         
         else if(!rdoIntFluid1.isChecked() & !rdoIntFluid2.isChecked() & secIntFluid.isShown())
           {
              Connection.MessageBox(Discharge.this, "Select anyone options from (Inrvenous fluid given?).");
              rdoIntFluid1.requestFocus();
              return;
           }
         
         else if(!rdoAntibiotic1.isChecked() & !rdoAntibiotic2.isChecked() & secAntibiotic.isShown())
           {
              Connection.MessageBox(Discharge.this, "Select anyone options from (Antibiotic given).");
              rdoAntibiotic1.requestFocus();
              return;
           }
         else if(txtAntibiotic1.getText().toString().length()==0 & secAntibiotic1.isShown())
           {
             Connection.MessageBox(Discharge.this, "Required field: 1. Name of the Antibiotic.");
             txtAntibiotic1.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpSDateAnti1.getText().toString());
         if(DV.length()!=0 & secSDateAnti1.isShown())
           {
             Connection.MessageBox(Discharge.this, DV);
             dtpSDateAnti1.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpEDateAnti1.getText().toString());
         if(DV.length()!=0 & secEDateAnti1.isShown())
           {
             Connection.MessageBox(Discharge.this, DV);
             dtpEDateAnti1.requestFocus(); 
             return;	
           }
         else if(txtAntibiotic2.getText().toString().length()==0 & secAntibiotic2.isShown())
           {
             Connection.MessageBox(Discharge.this, "Required field: 2. Name of the Antibiotic.");
             txtAntibiotic2.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpSDateAnti2.getText().toString());
         if(DV.length()!=0 & secSDateAnti2.isShown())
           {
             Connection.MessageBox(Discharge.this, DV);
             dtpSDateAnti2.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpEDateAnti2.getText().toString());
         if(DV.length()!=0 & secEDateAnti2.isShown())
           {
             Connection.MessageBox(Discharge.this, DV);
             dtpEDateAnti2.requestFocus(); 
             return;	
           }
         else if(txtAntibiotic3.getText().toString().length()==0 & secAntibiotic3.isShown())
           {
             Connection.MessageBox(Discharge.this, "Required field: 3. Name of the Antibiotic.");
             txtAntibiotic3.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpSDateAnti3.getText().toString());
         if(DV.length()!=0 & secSDateAnti3.isShown())
           {
             Connection.MessageBox(Discharge.this, DV);
             dtpSDateAnti3.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpEDateAnti3.getText().toString());
         if(DV.length()!=0 & secEDateAnti3.isShown())
           {
             Connection.MessageBox(Discharge.this, DV);
             dtpEDateAnti3.requestFocus(); 
             return;	
           }
         else if(txtAntibiotic4.getText().toString().length()==0 & secAntibiotic4.isShown())
           {
             Connection.MessageBox(Discharge.this, "Required field: 4. Name of the Antibiotic.");
             txtAntibiotic4.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpSDateAnti4.getText().toString());
         if(DV.length()!=0 & secSDateAnti4.isShown())
           {
             Connection.MessageBox(Discharge.this, DV);
             dtpSDateAnti4.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpEDateAnti4.getText().toString());
         if(DV.length()!=0 & secEDateAnti4.isShown())
           {
             Connection.MessageBox(Discharge.this, DV);
             dtpEDateAnti4.requestFocus(); 
             return;	
           }
         else if(txtAntibiotic5.getText().toString().length()==0 & secAntibiotic5.isShown())
           {
             Connection.MessageBox(Discharge.this, "Required field: 5. Name of the Antibiotic.");
             txtAntibiotic5.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpSDateAnti5.getText().toString());
         if(DV.length()!=0 & secSDateAnti5.isShown())
           {
             Connection.MessageBox(Discharge.this, DV);
             dtpSDateAnti5.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpEDateAnti5.getText().toString());
         if(DV.length()!=0 & secEDateAnti5.isShown())
           {
             Connection.MessageBox(Discharge.this, DV);
             dtpEDateAnti5.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpDtEnrolled.getText().toString());
         if(DV.length()!=0 & secDtEnrolled.isShown())
           {
             Connection.MessageBox(Discharge.this, DV);
             dtpDtEnrolled.requestFocus(); 
             return;	
           }
         else if(txtTmEnrolled.getText().length()==0 & secTmEnrolled.isShown())
           {
             Connection.MessageBox(Discharge.this, "Required field: Time of enrollment HH:MM: (24h format).");
             txtTmEnrolled.requestFocus(); 
             return;	
           }
 
         String SQL = "";
         RadioButton rb;

         Discharge_DataModel objSave = new Discharge_DataModel();
         objSave.setPreEnrollmentID(Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0?"0":txtPreEnrollmentID.getText().toString()));
         objSave.setDisDate(dtpDisDate.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpDisDate.getText().toString()) : dtpDisDate.getText().toString());
         objSave.setFinalDiag1(txtFinalDiag1.getText().toString());
         objSave.setFinalDiag2(txtFinalDiag2.getText().toString());
         objSave.setFinalDiag3(txtFinalDiag3.getText().toString());
         objSave.setFinalDiag4(txtFinalDiag4.getText().toString());
         objSave.setFinalDiag5(txtFinalDiag5.getText().toString());
         String[] d_rdogrpHOutcome = new String[] {"1","2","3","4","5"};
         objSave.setHOutcome(0);
         for (int i = 0; i < rdogrpHOutcome.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpHOutcome.getChildAt(i);
             if (rb.isChecked()) objSave.setHOutcome(Integer.valueOf(d_rdogrpHOutcome[i]));
         }

         String[] d_rdogrpIntFluid = new String[] {"1","2"};
         objSave.setIntFluid(0);
         for (int i = 0; i < rdogrpIntFluid.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpIntFluid.getChildAt(i);
             if (rb.isChecked()) objSave.setIntFluid(Integer.valueOf(d_rdogrpIntFluid[i]));
         }

         String[] d_rdogrpAntibiotic = new String[] {"1","2"};
         objSave.setAntibiotic(0);
         for (int i = 0; i < rdogrpAntibiotic.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpAntibiotic.getChildAt(i);
             if (rb.isChecked()) objSave.setAntibiotic(Integer.valueOf(d_rdogrpAntibiotic[i]));
         }

         objSave.setAntibiotic1(txtAntibiotic1.getText().toString());
         objSave.setSDateAnti1(dtpSDateAnti1.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpSDateAnti1.getText().toString()) : dtpSDateAnti1.getText().toString());
         objSave.setEDateAnti1(dtpEDateAnti1.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpEDateAnti1.getText().toString()) : dtpEDateAnti1.getText().toString());
         objSave.setAntibiotic2(txtAntibiotic2.getText().toString());
         objSave.setSDateAnti2(dtpSDateAnti2.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpSDateAnti2.getText().toString()) : dtpSDateAnti2.getText().toString());
         objSave.setEDateAnti2(dtpEDateAnti2.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpEDateAnti2.getText().toString()) : dtpEDateAnti2.getText().toString());
         objSave.setAntibiotic3(txtAntibiotic3.getText().toString());
         objSave.setSDateAnti3(dtpSDateAnti3.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpSDateAnti3.getText().toString()) : dtpSDateAnti3.getText().toString());
         objSave.setEDateAnti3(dtpEDateAnti3.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpEDateAnti3.getText().toString()) : dtpEDateAnti3.getText().toString());
         objSave.setAntibiotic4(txtAntibiotic4.getText().toString());
         objSave.setSDateAnti4(dtpSDateAnti4.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpSDateAnti4.getText().toString()) : dtpSDateAnti4.getText().toString());
         objSave.setEDateAnti4(dtpEDateAnti4.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpEDateAnti4.getText().toString()) : dtpEDateAnti4.getText().toString());
         objSave.setAntibiotic5(txtAntibiotic5.getText().toString());
         objSave.setSDateAnti5(dtpSDateAnti5.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpSDateAnti5.getText().toString()) : dtpSDateAnti5.getText().toString());
         objSave.setEDateAnti5(dtpEDateAnti5.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpEDateAnti5.getText().toString()) : dtpEDateAnti5.getText().toString());
         objSave.setDtEnrolled(dtpDtEnrolled.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpDtEnrolled.getText().toString()) : dtpDtEnrolled.getText().toString());
         objSave.setTmEnrolled(txtTmEnrolled.getText().toString());
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

             Connection.MessageBox(Discharge.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(Discharge.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Discharge.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String PreEnrollmentID)
     {
       try
        {
     
           RadioButton rb;
           Discharge_DataModel d = new Discharge_DataModel();
           String SQL = "Select * from "+ TableName +"  Where PreEnrollmentID='"+ PreEnrollmentID +"'";
           List<Discharge_DataModel> data = d.SelectAll(this, SQL);
           for(Discharge_DataModel item : data){
             txtPreEnrollmentID.setText(String.valueOf(item.getPreEnrollmentID()));
             dtpDisDate.setText(item.getDisDate().toString().length()==0 ? "" : Global.DateConvertDMY(item.getDisDate()));
             txtFinalDiag1.setText(item.getFinalDiag1());
             txtFinalDiag2.setText(item.getFinalDiag2());
             txtFinalDiag3.setText(item.getFinalDiag3());
             txtFinalDiag4.setText(item.getFinalDiag4());
             txtFinalDiag5.setText(item.getFinalDiag5());
             String[] d_rdogrpHOutcome = new String[] {"1","2","3","4","5"};
             for (int i = 0; i < d_rdogrpHOutcome.length; i++)
             {
                 if (String.valueOf(item.getHOutcome()).equals(String.valueOf(d_rdogrpHOutcome[i])))
                 {
                     rb = (RadioButton)rdogrpHOutcome.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpIntFluid = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpIntFluid.length; i++)
             {
                 if (String.valueOf(item.getIntFluid()).equals(String.valueOf(d_rdogrpIntFluid[i])))
                 {
                     rb = (RadioButton)rdogrpIntFluid.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpAntibiotic = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpAntibiotic.length; i++)
             {
                 if (String.valueOf(item.getAntibiotic()).equals(String.valueOf(d_rdogrpAntibiotic[i])))
                 {
                     rb = (RadioButton)rdogrpAntibiotic.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtAntibiotic1.setText(item.getAntibiotic1());
             dtpSDateAnti1.setText(item.getSDateAnti1().toString().length()==0 ? "" : Global.DateConvertDMY(item.getSDateAnti1()));
             dtpEDateAnti1.setText(item.getEDateAnti1().toString().length()==0 ? "" : Global.DateConvertDMY(item.getEDateAnti1()));
             txtAntibiotic2.setText(item.getAntibiotic2());
             dtpSDateAnti2.setText(item.getSDateAnti2().toString().length()==0 ? "" : Global.DateConvertDMY(item.getSDateAnti2()));
             dtpEDateAnti2.setText(item.getEDateAnti2().toString().length()==0 ? "" : Global.DateConvertDMY(item.getEDateAnti2()));
             txtAntibiotic3.setText(item.getAntibiotic3());
             dtpSDateAnti3.setText(item.getSDateAnti3().toString().length()==0 ? "" : Global.DateConvertDMY(item.getSDateAnti3()));
             dtpEDateAnti3.setText(item.getEDateAnti3().toString().length()==0 ? "" : Global.DateConvertDMY(item.getEDateAnti3()));
             txtAntibiotic4.setText(item.getAntibiotic4());
             dtpSDateAnti4.setText(item.getSDateAnti4().toString().length()==0 ? "" : Global.DateConvertDMY(item.getSDateAnti4()));
             dtpEDateAnti4.setText(item.getEDateAnti4().toString().length()==0 ? "" : Global.DateConvertDMY(item.getEDateAnti4()));
             txtAntibiotic5.setText(item.getAntibiotic5());
             dtpSDateAnti5.setText(item.getSDateAnti5().toString().length()==0 ? "" : Global.DateConvertDMY(item.getSDateAnti5()));
             dtpEDateAnti5.setText(item.getEDateAnti5().toString().length()==0 ? "" : Global.DateConvertDMY(item.getEDateAnti5()));
             dtpDtEnrolled.setText(item.getDtEnrolled().toString().length()==0 ? "" : Global.DateConvertDMY(item.getDtEnrolled()));
             txtTmEnrolled.setText(item.getTmEnrolled());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Discharge.this, e.getMessage());
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


              dtpDate = (EditText)findViewById(R.id.dtpDisDate);
             if (VariableID.equals("btnDisDate"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpDisDate);
              }
             else if (VariableID.equals("btnSDateAnti1"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpSDateAnti1);
              }
             else if (VariableID.equals("btnEDateAnti1"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpEDateAnti1);
              }
             else if (VariableID.equals("btnSDateAnti2"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpSDateAnti2);
              }
             else if (VariableID.equals("btnEDateAnti2"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpEDateAnti2);
              }
             else if (VariableID.equals("btnSDateAnti3"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpSDateAnti3);
              }
             else if (VariableID.equals("btnEDateAnti3"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpEDateAnti3);
              }
             else if (VariableID.equals("btnSDateAnti4"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpSDateAnti4);
              }
             else if (VariableID.equals("btnEDateAnti4"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpEDateAnti4);
              }
             else if (VariableID.equals("btnSDateAnti5"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpSDateAnti5);
              }
             else if (VariableID.equals("btnEDateAnti5"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpEDateAnti5);
              }
             else if (VariableID.equals("btnDtEnrolled"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpDtEnrolled);
              }
      dtpDate.setText(new StringBuilder()
      .append(Global.Right("00"+mDay,2)).append("/")
      .append(Global.Right("00"+mMonth,2)).append("/")
      .append(mYear));
      }
  };

 private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
       hour = selectedHour; minute = selectedMinute;
       EditText tpTime;


              tpTime = (EditText)findViewById(R.id.txtTmEnrolled);
             if (VariableID.equals("btnTmEnrolled"))
              {
                  tpTime = (EditText)findViewById(R.id.txtTmEnrolled);
              }
          tpTime.setText(new StringBuilder().append(Global.Right("00"+hour,2)).append(":").append(Global.Right("00"+minute,2)));

    }
  };


 
 // turning off the GPS if its in on state. to avoid the battery drain.
 @Override
 protected void onDestroy() {
     // TODO Auto-generated method stub
     super.onDestroy();
 }
}