
 package org.icddrb.rotaproject;


 //Android Manifest Code
 //<activity android:name=".EmergencyScreening" android:label="EmergencyScreening" />
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

 public class EmergencyScreening extends Activity {
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
         LinearLayout secEmerLabl;
         View lineEmerLabl;
         LinearLayout secPreEnrollmentID;
         View linePreEnrollmentID;
         TextView VlblPreEnrollmentID;
         EditText txtPreEnrollmentID;
         LinearLayout secStudyID;
         View lineStudyID;
         TextView VlblStudyID;
         EditText txtStudyID;
         LinearLayout secHosRegis;
         View lineHosRegis;
         TextView VlblHosRegis;
         EditText txtHosRegis;
         LinearLayout secDtEnroll;
         View lineDtEnroll;
         TextView VlblDtEnroll;
         EditText dtpDtEnroll;
         LinearLayout secCName;
         View lineCName;
         TextView VlblCName;
         EditText txtCName;
         LinearLayout secCDOB;
         View lineCDOB;
         TextView VlblCDOB;
         EditText dtpCDOB;
         LinearLayout secCAgeM;
         View lineCAgeM;
         TextView VlblCAgeM;
         EditText txtCAgeM;
         LinearLayout secCSex;
         View lineCSex;
         TextView VlblCSex;
         RadioGroup rdogrpCSex;
         
         RadioButton rdoCSex1;
         RadioButton rdoCSex2;
         LinearLayout secMFName;
         View lineMFName;
         TextView VlblMFName;
         EditText txtMFName;
         LinearLayout secContact1;
         View lineContact1;
         TextView VlblContact1;
         EditText txtContact1;
         LinearLayout secCont1Veri;
         View lineCont1Veri;
         TextView VlblCont1Veri;
         RadioGroup rdogrpCont1Veri;
         
         RadioButton rdoCont1Veri1;
         RadioButton rdoCont1Veri2;
         LinearLayout secCont1Rel;
         View lineCont1Rel;
         TextView VlblCont1Rel;
         EditText txtCont1Rel;
         LinearLayout secContact2;
         View lineContact2;
         TextView VlblContact2;
         EditText txtContact2;
         LinearLayout secCont2Veri;
         View lineCont2Veri;
         TextView VlblCont2Veri;
         RadioGroup rdogrpCont2Veri;
         
         RadioButton rdoCont2Veri1;
         RadioButton rdoCont2Veri2;
         LinearLayout secCont2Rel;
         View lineCont2Rel;
         TextView VlblCont2Rel;
         EditText txtCont2Rel;
         LinearLayout secZila;
         View lineZila;
         TextView VlblZila;
         Spinner spnZila;
         LinearLayout secUpazila;
         View lineUpazila;
         TextView VlblUpazila;
         Spinner spnUpazila;
         LinearLayout secUnions;
         View lineUnions;
         TextView VlblUnions;
         Spinner spnUnions;
         LinearLayout secVillage;
         View lineVillage;
         TextView VlblVillage;
         Spinner spnVillage;
         LinearLayout secLocation;
         View lineLocation;
         TextView VlblLocation;
         AutoCompleteTextView txtLocation;
         LinearLayout secStudyArea;
         View lineStudyArea;
         TextView VlblStudyArea;
         RadioGroup rdogrpStudyArea;
         
         RadioButton rdoStudyArea1;
         RadioButton rdoStudyArea2;
         LinearLayout secPreSumDiag;
         View linePreSumDiag;
         TextView VlblPreSumDiag;
         RadioGroup rdogrpPreSumDiag;
         
         RadioButton rdoPreSumDiag1;
         RadioButton rdoPreSumDiag2;
         LinearLayout secPreSumDiag1;
         View linePreSumDiag1;
         TextView VlblPreSumDiag1;
         AutoCompleteTextView txtPreSumDiag1;
         LinearLayout secPreSumDiag2;
         View linePreSumDiag2;
         TextView VlblPreSumDiag2;
         AutoCompleteTextView txtPreSumDiag2;
         LinearLayout secPreSumDiag3;
         View linePreSumDiag3;
         TextView VlblPreSumDiag3;
         AutoCompleteTextView txtPreSumDiag3;
         LinearLayout secPreSumDiag4;
         View linePreSumDiag4;
         TextView VlblPreSumDiag4;
         AutoCompleteTextView txtPreSumDiag4;
         LinearLayout secPreSumDiag5;
         View linePreSumDiag5;
         TextView VlblPreSumDiag5;
         AutoCompleteTextView txtPreSumDiag5;
         LinearLayout secOthSymp1;
         View lineOthSymp1;
         TextView VlblOthSymp1;
         AutoCompleteTextView txtOthSymp1;
         LinearLayout secSymp1Dur;
         View lineSymp1Dur;
         TextView VlblSymp1Dur;
         EditText txtSymp1Dur;
         LinearLayout secOthSymp2;
         View lineOthSymp2;
         TextView VlblOthSymp2;
         AutoCompleteTextView txtOthSymp2;
         LinearLayout secSymp2Dur;
         View lineSymp2Dur;
         TextView VlblSymp2Dur;
         EditText txtSymp2Dur;
         LinearLayout secRefuesAdm;
         View lineRefuesAdm;
         TextView VlblRefuesAdm;
         RadioGroup rdogrpRefuesAdm;
         
         RadioButton rdoRefuesAdm1;
         RadioButton rdoRefuesAdm2;
         RadioButton rdoRefuesAdm3;
         LinearLayout secTRefusal;
         View lineTRefusal;
         TextView VlblTRefusal;
         EditText txtTRefusal;

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
         setContentView(R.layout.emergencyscreening);
         getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         PREENROLLMENTID = IDbundle.getString("PreEnrollmentID");

         TableName = "EmergencyScreening";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(EmergencyScreening.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});


         secEmerLabl=(LinearLayout)findViewById(R.id.secEmerLabl);
         lineEmerLabl=(View)findViewById(R.id.lineEmerLabl);
         secPreEnrollmentID=(LinearLayout)findViewById(R.id.secPreEnrollmentID);
         linePreEnrollmentID=(View)findViewById(R.id.linePreEnrollmentID);
         VlblPreEnrollmentID=(TextView) findViewById(R.id.VlblPreEnrollmentID);
         txtPreEnrollmentID=(EditText) findViewById(R.id.txtPreEnrollmentID);
         secStudyID=(LinearLayout)findViewById(R.id.secStudyID);
         lineStudyID=(View)findViewById(R.id.lineStudyID);
         VlblStudyID=(TextView) findViewById(R.id.VlblStudyID);
         txtStudyID=(EditText) findViewById(R.id.txtStudyID);
         secHosRegis=(LinearLayout)findViewById(R.id.secHosRegis);
         lineHosRegis=(View)findViewById(R.id.lineHosRegis);
         VlblHosRegis=(TextView) findViewById(R.id.VlblHosRegis);
         txtHosRegis=(EditText) findViewById(R.id.txtHosRegis);
         secDtEnroll=(LinearLayout)findViewById(R.id.secDtEnroll);
         lineDtEnroll=(View)findViewById(R.id.lineDtEnroll);
         VlblDtEnroll=(TextView) findViewById(R.id.VlblDtEnroll);
         dtpDtEnroll=(EditText) findViewById(R.id.dtpDtEnroll);
         secCName=(LinearLayout)findViewById(R.id.secCName);
         lineCName=(View)findViewById(R.id.lineCName);
         VlblCName=(TextView) findViewById(R.id.VlblCName);
         txtCName=(EditText) findViewById(R.id.txtCName);
         secCDOB=(LinearLayout)findViewById(R.id.secCDOB);
         lineCDOB=(View)findViewById(R.id.lineCDOB);
         VlblCDOB=(TextView) findViewById(R.id.VlblCDOB);
         dtpCDOB=(EditText) findViewById(R.id.dtpCDOB);
         secCAgeM=(LinearLayout)findViewById(R.id.secCAgeM);
         lineCAgeM=(View)findViewById(R.id.lineCAgeM);
         VlblCAgeM=(TextView) findViewById(R.id.VlblCAgeM);
         txtCAgeM=(EditText) findViewById(R.id.txtCAgeM);
         secCSex=(LinearLayout)findViewById(R.id.secCSex);
         lineCSex=(View)findViewById(R.id.lineCSex);
         VlblCSex = (TextView) findViewById(R.id.VlblCSex);
         rdogrpCSex = (RadioGroup) findViewById(R.id.rdogrpCSex);
         
         rdoCSex1 = (RadioButton) findViewById(R.id.rdoCSex1);
         rdoCSex2 = (RadioButton) findViewById(R.id.rdoCSex2);
         secMFName=(LinearLayout)findViewById(R.id.secMFName);
         lineMFName=(View)findViewById(R.id.lineMFName);
         VlblMFName=(TextView) findViewById(R.id.VlblMFName);
         txtMFName=(EditText) findViewById(R.id.txtMFName);
         secContact1=(LinearLayout)findViewById(R.id.secContact1);
         lineContact1=(View)findViewById(R.id.lineContact1);
         VlblContact1=(TextView) findViewById(R.id.VlblContact1);
         txtContact1=(EditText) findViewById(R.id.txtContact1);
         secCont1Veri=(LinearLayout)findViewById(R.id.secCont1Veri);
         lineCont1Veri=(View)findViewById(R.id.lineCont1Veri);
         VlblCont1Veri = (TextView) findViewById(R.id.VlblCont1Veri);
         rdogrpCont1Veri = (RadioGroup) findViewById(R.id.rdogrpCont1Veri);
         
         rdoCont1Veri1 = (RadioButton) findViewById(R.id.rdoCont1Veri1);
         rdoCont1Veri2 = (RadioButton) findViewById(R.id.rdoCont1Veri2);
         secCont1Rel=(LinearLayout)findViewById(R.id.secCont1Rel);
         lineCont1Rel=(View)findViewById(R.id.lineCont1Rel);
         VlblCont1Rel=(TextView) findViewById(R.id.VlblCont1Rel);
         txtCont1Rel=(EditText) findViewById(R.id.txtCont1Rel);
         secContact2=(LinearLayout)findViewById(R.id.secContact2);
         lineContact2=(View)findViewById(R.id.lineContact2);
         VlblContact2=(TextView) findViewById(R.id.VlblContact2);
         txtContact2=(EditText) findViewById(R.id.txtContact2);
         secCont2Veri=(LinearLayout)findViewById(R.id.secCont2Veri);
         lineCont2Veri=(View)findViewById(R.id.lineCont2Veri);
         VlblCont2Veri = (TextView) findViewById(R.id.VlblCont2Veri);
         rdogrpCont2Veri = (RadioGroup) findViewById(R.id.rdogrpCont2Veri);
         
         rdoCont2Veri1 = (RadioButton) findViewById(R.id.rdoCont2Veri1);
         rdoCont2Veri2 = (RadioButton) findViewById(R.id.rdoCont2Veri2);
         secCont2Rel=(LinearLayout)findViewById(R.id.secCont2Rel);
         lineCont2Rel=(View)findViewById(R.id.lineCont2Rel);
         VlblCont2Rel=(TextView) findViewById(R.id.VlblCont2Rel);
         txtCont2Rel=(EditText) findViewById(R.id.txtCont2Rel);
         secZila=(LinearLayout)findViewById(R.id.secZila);
         lineZila=(View)findViewById(R.id.lineZila);
         VlblZila=(TextView) findViewById(R.id.VlblZila);
         spnZila=(Spinner) findViewById(R.id.spnZila);
         List<String> listZila = new ArrayList<String>();
         
         listZila.add("");
         listZila.add("01-District");
         ArrayAdapter<String> adptrZila= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listZila);
         spnZila.setAdapter(adptrZila);

         secUpazila=(LinearLayout)findViewById(R.id.secUpazila);
         lineUpazila=(View)findViewById(R.id.lineUpazila);
         VlblUpazila=(TextView) findViewById(R.id.VlblUpazila);
         spnUpazila=(Spinner) findViewById(R.id.spnUpazila);
         List<String> listUpazila = new ArrayList<String>();
         
         listUpazila.add("");
         listUpazila.add("1001-Upazila");
         ArrayAdapter<String> adptrUpazila= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listUpazila);
         spnUpazila.setAdapter(adptrUpazila);

         secUnions=(LinearLayout)findViewById(R.id.secUnions);
         lineUnions=(View)findViewById(R.id.lineUnions);
         VlblUnions=(TextView) findViewById(R.id.VlblUnions);
         spnUnions=(Spinner) findViewById(R.id.spnUnions);
         List<String> listUnions = new ArrayList<String>();
         
         listUnions.add("");
         listUnions.add("101-Unions");
         ArrayAdapter<String> adptrUnions= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listUnions);
         spnUnions.setAdapter(adptrUnions);

         secVillage=(LinearLayout)findViewById(R.id.secVillage);
         lineVillage=(View)findViewById(R.id.lineVillage);
         VlblVillage=(TextView) findViewById(R.id.VlblVillage);
         spnVillage=(Spinner) findViewById(R.id.spnVillage);
         List<String> listVillage = new ArrayList<String>();
         
         listVillage.add("");
         listVillage.add("101-Moholla");
         ArrayAdapter<String> adptrVillage= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listVillage);
         spnVillage.setAdapter(adptrVillage);

         secLocation=(LinearLayout)findViewById(R.id.secLocation);
         lineLocation=(View)findViewById(R.id.lineLocation);
         VlblLocation=(TextView) findViewById(R.id.VlblLocation);
         txtLocation=(AutoCompleteTextView) findViewById(R.id.txtLocation);
         txtLocation.setAdapter(C.getArrayAdapter("Select distinct Location from "+ TableName +" order by Location"));

         txtLocation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtLocation.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtLocation.getRight() - txtLocation.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secStudyArea=(LinearLayout)findViewById(R.id.secStudyArea);
         lineStudyArea=(View)findViewById(R.id.lineStudyArea);
         VlblStudyArea = (TextView) findViewById(R.id.VlblStudyArea);
         rdogrpStudyArea = (RadioGroup) findViewById(R.id.rdogrpStudyArea);
         
         rdoStudyArea1 = (RadioButton) findViewById(R.id.rdoStudyArea1);
         rdoStudyArea2 = (RadioButton) findViewById(R.id.rdoStudyArea2);
         secPreSumDiag=(LinearLayout)findViewById(R.id.secPreSumDiag);
         linePreSumDiag=(View)findViewById(R.id.linePreSumDiag);
         VlblPreSumDiag = (TextView) findViewById(R.id.VlblPreSumDiag);
         rdogrpPreSumDiag = (RadioGroup) findViewById(R.id.rdogrpPreSumDiag);
         
         rdoPreSumDiag1 = (RadioButton) findViewById(R.id.rdoPreSumDiag1);
         rdoPreSumDiag2 = (RadioButton) findViewById(R.id.rdoPreSumDiag2);
         secPreSumDiag1=(LinearLayout)findViewById(R.id.secPreSumDiag1);
         linePreSumDiag1=(View)findViewById(R.id.linePreSumDiag1);
         VlblPreSumDiag1=(TextView) findViewById(R.id.VlblPreSumDiag1);
         txtPreSumDiag1=(AutoCompleteTextView) findViewById(R.id.txtPreSumDiag1);
         txtPreSumDiag1.setAdapter(C.getArrayAdapter("Select distinct PreSumDiag1 from "+ TableName +" order by PreSumDiag1"));

         txtPreSumDiag1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtPreSumDiag1.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtPreSumDiag1.getRight() - txtPreSumDiag1.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secPreSumDiag2=(LinearLayout)findViewById(R.id.secPreSumDiag2);
         linePreSumDiag2=(View)findViewById(R.id.linePreSumDiag2);
         VlblPreSumDiag2=(TextView) findViewById(R.id.VlblPreSumDiag2);
         txtPreSumDiag2=(AutoCompleteTextView) findViewById(R.id.txtPreSumDiag2);
         txtPreSumDiag2.setAdapter(C.getArrayAdapter("Select distinct PreSumDiag2 from "+ TableName +" order by PreSumDiag2"));

         txtPreSumDiag2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtPreSumDiag2.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtPreSumDiag2.getRight() - txtPreSumDiag2.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secPreSumDiag3=(LinearLayout)findViewById(R.id.secPreSumDiag3);
         linePreSumDiag3=(View)findViewById(R.id.linePreSumDiag3);
         VlblPreSumDiag3=(TextView) findViewById(R.id.VlblPreSumDiag3);
         txtPreSumDiag3=(AutoCompleteTextView) findViewById(R.id.txtPreSumDiag3);
         txtPreSumDiag3.setAdapter(C.getArrayAdapter("Select distinct PreSumDiag3 from "+ TableName +" order by PreSumDiag3"));

         txtPreSumDiag3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtPreSumDiag3.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtPreSumDiag3.getRight() - txtPreSumDiag3.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secPreSumDiag4=(LinearLayout)findViewById(R.id.secPreSumDiag4);
         linePreSumDiag4=(View)findViewById(R.id.linePreSumDiag4);
         VlblPreSumDiag4=(TextView) findViewById(R.id.VlblPreSumDiag4);
         txtPreSumDiag4=(AutoCompleteTextView) findViewById(R.id.txtPreSumDiag4);
         txtPreSumDiag4.setAdapter(C.getArrayAdapter("Select distinct PreSumDiag4 from "+ TableName +" order by PreSumDiag4"));

         txtPreSumDiag4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtPreSumDiag4.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtPreSumDiag4.getRight() - txtPreSumDiag4.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secPreSumDiag5=(LinearLayout)findViewById(R.id.secPreSumDiag5);
         linePreSumDiag5=(View)findViewById(R.id.linePreSumDiag5);
         VlblPreSumDiag5=(TextView) findViewById(R.id.VlblPreSumDiag5);
         txtPreSumDiag5=(AutoCompleteTextView) findViewById(R.id.txtPreSumDiag5);
         txtPreSumDiag5.setAdapter(C.getArrayAdapter("Select distinct PreSumDiag5 from "+ TableName +" order by PreSumDiag5"));

         txtPreSumDiag5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtPreSumDiag5.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtPreSumDiag5.getRight() - txtPreSumDiag5.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
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
         secSymp1Dur=(LinearLayout)findViewById(R.id.secSymp1Dur);
         lineSymp1Dur=(View)findViewById(R.id.lineSymp1Dur);
         VlblSymp1Dur=(TextView) findViewById(R.id.VlblSymp1Dur);
         txtSymp1Dur=(EditText) findViewById(R.id.txtSymp1Dur);
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
         secSymp2Dur=(LinearLayout)findViewById(R.id.secSymp2Dur);
         lineSymp2Dur=(View)findViewById(R.id.lineSymp2Dur);
         VlblSymp2Dur=(TextView) findViewById(R.id.VlblSymp2Dur);
         txtSymp2Dur=(EditText) findViewById(R.id.txtSymp2Dur);
         secRefuesAdm=(LinearLayout)findViewById(R.id.secRefuesAdm);
         lineRefuesAdm=(View)findViewById(R.id.lineRefuesAdm);
         VlblRefuesAdm = (TextView) findViewById(R.id.VlblRefuesAdm);
         rdogrpRefuesAdm = (RadioGroup) findViewById(R.id.rdogrpRefuesAdm);
         
         rdoRefuesAdm1 = (RadioButton) findViewById(R.id.rdoRefuesAdm1);
         rdoRefuesAdm2 = (RadioButton) findViewById(R.id.rdoRefuesAdm2);
         rdoRefuesAdm3 = (RadioButton) findViewById(R.id.rdoRefuesAdm3);
         secTRefusal=(LinearLayout)findViewById(R.id.secTRefusal);
         lineTRefusal=(View)findViewById(R.id.lineTRefusal);
         VlblTRefusal=(TextView) findViewById(R.id.VlblTRefusal);
         txtTRefusal=(EditText) findViewById(R.id.txtTRefusal);


         dtpDtEnroll.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpDtEnroll.getRight() - dtpDtEnroll.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnDtEnroll"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpCDOB.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpCDOB.getRight() - dtpCDOB.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnCDOB"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });


         txtTRefusal.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtTRefusal.getRight() - txtTRefusal.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btnTRefusal"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });

         //Hide all skip variables


        DataSearch(PREENROLLMENTID);


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(EmergencyScreening.this, e.getMessage());
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
             Connection.MessageBox(EmergencyScreening.this, "Required field: PreEnrollment ID.");
             txtPreEnrollmentID.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0 ? "00000001" : txtPreEnrollmentID.getText().toString()) < 00000001 || Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0 ? "88888888" : txtPreEnrollmentID.getText().toString()) > 88888888)
           {
             Connection.MessageBox(EmergencyScreening.this, "Value should be between 00000001 and 88888888(PreEnrollment ID).");
             txtPreEnrollmentID.requestFocus(); 
             return;	
           }
         else if(txtStudyID.getText().toString().length()==0 & secStudyID.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: Study ID.");
             txtStudyID.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtStudyID.getText().toString().length()==0 ? "00000001" : txtStudyID.getText().toString()) < 00000001 || Integer.valueOf(txtStudyID.getText().toString().length()==0 ? "88888888" : txtStudyID.getText().toString()) > 88888888)
           {
             Connection.MessageBox(EmergencyScreening.this, "Value should be between 00000001 and 88888888(Study ID).");
             txtStudyID.requestFocus(); 
             return;	
           }
         else if(txtHosRegis.getText().toString().length()==0 & secHosRegis.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: Hospital registration no.");
             txtHosRegis.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtHosRegis.getText().toString().length()==0 ? "00001" : txtHosRegis.getText().toString()) < 00001 || Integer.valueOf(txtHosRegis.getText().toString().length()==0 ? "88888" : txtHosRegis.getText().toString()) > 88888)
           {
             Connection.MessageBox(EmergencyScreening.this, "Value should be between 00001 and 88888(Hospital registration no).");
             txtHosRegis.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpDtEnroll.getText().toString());
         if(DV.length()!=0 & secDtEnroll.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, DV);
             dtpDtEnroll.requestFocus(); 
             return;	
           }
         else if(txtCName.getText().toString().length()==0 & secCName.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: Name of the child.");
             txtCName.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpCDOB.getText().toString());
         if(DV.length()!=0 & secCDOB.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, DV);
             dtpCDOB.requestFocus(); 
             return;	
           }
         else if(txtCAgeM.getText().toString().length()==0 & secCAgeM.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: Child age (months).");
             txtCAgeM.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtCAgeM.getText().toString().length()==0 ? "00" : txtCAgeM.getText().toString()) < 00 || Integer.valueOf(txtCAgeM.getText().toString().length()==0 ? "12" : txtCAgeM.getText().toString()) > 12)
           {
             Connection.MessageBox(EmergencyScreening.this, "Value should be between 00 and 12(Child age (months)).");
             txtCAgeM.requestFocus(); 
             return;	
           }
         
         else if(!rdoCSex1.isChecked() & !rdoCSex2.isChecked() & secCSex.isShown())
           {
              Connection.MessageBox(EmergencyScreening.this, "Select anyone options from (Child sex).");
              rdoCSex1.requestFocus();
              return;
           }
         else if(txtMFName.getText().toString().length()==0 & secMFName.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: Mother/Father name.");
             txtMFName.requestFocus(); 
             return;	
           }
         else if(txtContact1.getText().toString().length()==0 & secContact1.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: Contact No 1.");
             txtContact1.requestFocus(); 
             return;	
           }
         
         else if(!rdoCont1Veri1.isChecked() & !rdoCont1Veri2.isChecked() & secCont1Veri.isShown())
           {
              Connection.MessageBox(EmergencyScreening.this, "Select anyone options from (Contact No 1 verified).");
              rdoCont1Veri1.requestFocus();
              return;
           }
         else if(txtCont1Rel.getText().toString().length()==0 & secCont1Rel.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: Contact No 1 relationship with patient.");
             txtCont1Rel.requestFocus(); 
             return;	
           }
         else if(txtContact2.getText().toString().length()==0 & secContact2.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: Contact No 2.");
             txtContact2.requestFocus(); 
             return;	
           }
         
         else if(!rdoCont2Veri1.isChecked() & !rdoCont2Veri2.isChecked() & secCont2Veri.isShown())
           {
              Connection.MessageBox(EmergencyScreening.this, "Select anyone options from (Contact No 2 verified).");
              rdoCont2Veri1.requestFocus();
              return;
           }
         else if(txtCont2Rel.getText().toString().length()==0 & secCont2Rel.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: Contact No 2 relation with patient.");
             txtCont2Rel.requestFocus(); 
             return;	
           }
         else if(spnZila.getSelectedItemPosition()==0  & secZila.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: Zila Address  of the patient.");
             spnZila.requestFocus(); 
             return;	
           }
         else if(spnUpazila.getSelectedItemPosition()==0  & secUpazila.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: Upazila.");
             spnUpazila.requestFocus(); 
             return;	
           }
         else if(spnUnions.getSelectedItemPosition()==0  & secUnions.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: Union/ward.");
             spnUnions.requestFocus(); 
             return;	
           }
         else if(spnVillage.getSelectedItemPosition()==0  & secVillage.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: Village or mahollah.");
             spnVillage.requestFocus(); 
             return;	
           }
         else if(txtLocation.getText().toString().length()==0 & secLocation.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: Location.");
             txtLocation.requestFocus(); 
             return;	
           }
         
         else if(!rdoStudyArea1.isChecked() & !rdoStudyArea2.isChecked() & secStudyArea.isShown())
           {
              Connection.MessageBox(EmergencyScreening.this, "Select anyone options from (Study area).");
              rdoStudyArea1.requestFocus();
              return;
           }
         
         else if(!rdoPreSumDiag1.isChecked() & !rdoPreSumDiag2.isChecked() & secPreSumDiag.isShown())
           {
              Connection.MessageBox(EmergencyScreening.this, "Select anyone options from (Presumptive diagnosis available ?).");
              rdoPreSumDiag1.requestFocus();
              return;
           }
         else if(txtPreSumDiag1.getText().toString().length()==0 & secPreSumDiag1.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: 1. What is/are Presumptive diagnosis /es?.");
             txtPreSumDiag1.requestFocus(); 
             return;	
           }
         else if(txtPreSumDiag2.getText().toString().length()==0 & secPreSumDiag2.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: 2. What is/are Presumptive diagnosis /es?.");
             txtPreSumDiag2.requestFocus(); 
             return;	
           }
         else if(txtPreSumDiag3.getText().toString().length()==0 & secPreSumDiag3.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: 3. What is/are Presumptive diagnosis /es?.");
             txtPreSumDiag3.requestFocus(); 
             return;	
           }
         else if(txtPreSumDiag4.getText().toString().length()==0 & secPreSumDiag4.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: 4. What is/are Presumptive diagnosis /es?.");
             txtPreSumDiag4.requestFocus(); 
             return;	
           }
         else if(txtPreSumDiag5.getText().toString().length()==0 & secPreSumDiag5.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: 5. What is/are Presumptive diagnosis /es?.");
             txtPreSumDiag5.requestFocus(); 
             return;	
           }
         else if(txtOthSymp1.getText().toString().length()==0 & secOthSymp1.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: Other symptoms 1.");
             txtOthSymp1.requestFocus(); 
             return;	
           }
         else if(txtSymp1Dur.getText().toString().length()==0 & secSymp1Dur.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: Other symptoms 1 duration  (days).");
             txtSymp1Dur.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtSymp1Dur.getText().toString().length()==0 ? "00" : txtSymp1Dur.getText().toString()) < 00 || Integer.valueOf(txtSymp1Dur.getText().toString().length()==0 ? "88" : txtSymp1Dur.getText().toString()) > 88)
           {
             Connection.MessageBox(EmergencyScreening.this, "Value should be between 00 and 88(Other symptoms 1 duration  (days)).");
             txtSymp1Dur.requestFocus(); 
             return;	
           }
         else if(txtOthSymp2.getText().toString().length()==0 & secOthSymp2.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: Other symptomps 2.");
             txtOthSymp2.requestFocus(); 
             return;	
           }
         else if(txtSymp2Dur.getText().toString().length()==0 & secSymp2Dur.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: Other symptoms 2 duration  (days).");
             txtSymp2Dur.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtSymp2Dur.getText().toString().length()==0 ? "00" : txtSymp2Dur.getText().toString()) < 00 || Integer.valueOf(txtSymp2Dur.getText().toString().length()==0 ? "88" : txtSymp2Dur.getText().toString()) > 88)
           {
             Connection.MessageBox(EmergencyScreening.this, "Value should be between 00 and 88(Other symptoms 2 duration  (days)).");
             txtSymp2Dur.requestFocus(); 
             return;	
           }
         
         else if(!rdoRefuesAdm1.isChecked() & !rdoRefuesAdm2.isChecked() & !rdoRefuesAdm3.isChecked() & secRefuesAdm.isShown())
           {
              Connection.MessageBox(EmergencyScreening.this, "Select anyone options from (Refuesed admission).");
              rdoRefuesAdm1.requestFocus();
              return;
           }
         else if(txtTRefusal.getText().length()==0 & secTRefusal.isShown())
           {
             Connection.MessageBox(EmergencyScreening.this, "Required field: Time of refusal.");
             txtTRefusal.requestFocus(); 
             return;	
           }
 
         String SQL = "";
         RadioButton rb;

         EmergencyScreening_DataModel objSave = new EmergencyScreening_DataModel();
         objSave.setPreEnrollmentID(Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0?"0":txtPreEnrollmentID.getText().toString()));
         objSave.setStudyID(Integer.valueOf(txtStudyID.getText().toString().length()==0?"0":txtStudyID.getText().toString()));
         objSave.setHosRegis(Integer.valueOf(txtHosRegis.getText().toString().length()==0?"0":txtHosRegis.getText().toString()));
         objSave.setDtEnroll(dtpDtEnroll.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpDtEnroll.getText().toString()) : dtpDtEnroll.getText().toString());
         objSave.setCName(txtCName.getText().toString());
         objSave.setCDOB(dtpCDOB.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpCDOB.getText().toString()) : dtpCDOB.getText().toString());
         objSave.setCAgeM(Integer.valueOf(txtCAgeM.getText().toString().length()==0?"0":txtCAgeM.getText().toString()));
         String[] d_rdogrpCSex = new String[] {"1","2"};
         objSave.setCSex(0);
         for (int i = 0; i < rdogrpCSex.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpCSex.getChildAt(i);
             if (rb.isChecked()) objSave.setCSex(Integer.valueOf(d_rdogrpCSex[i]));
         }

         objSave.setMFName(txtMFName.getText().toString());
         objSave.setContact1(txtContact1.getText().toString());
         String[] d_rdogrpCont1Veri = new String[] {"1","2"};
         objSave.setCont1Veri(0);
         for (int i = 0; i < rdogrpCont1Veri.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpCont1Veri.getChildAt(i);
             if (rb.isChecked()) objSave.setCont1Veri(Integer.valueOf(d_rdogrpCont1Veri[i]));
         }

         objSave.setCont1Rel(txtCont1Rel.getText().toString());
         objSave.setContact2(txtContact2.getText().toString());
         String[] d_rdogrpCont2Veri = new String[] {"1","2"};
         objSave.setCont2Veri(0);
         for (int i = 0; i < rdogrpCont2Veri.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpCont2Veri.getChildAt(i);
             if (rb.isChecked()) objSave.setCont2Veri(Integer.valueOf(d_rdogrpCont2Veri[i]));
         }

         objSave.setCont2Rel(txtCont2Rel.getText().toString());
         objSave.setZila(Integer.valueOf(spnZila.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnZila.getSelectedItem().toString(), "-")));
         objSave.setUpazila(Integer.valueOf(spnUpazila.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnUpazila.getSelectedItem().toString(), "-")));
         objSave.setUnions(Integer.valueOf(spnUnions.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnUnions.getSelectedItem().toString(), "-")));
         objSave.setVillage(Integer.valueOf(spnVillage.getSelectedItemPosition() == 0 ? "0" : Connection.SelectedSpinnerValue(spnVillage.getSelectedItem().toString(), "-")));
         objSave.setLocation(txtLocation.getText().toString());
         String[] d_rdogrpStudyArea = new String[] {"1","2"};
         objSave.setStudyArea(0);
         for (int i = 0; i < rdogrpStudyArea.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpStudyArea.getChildAt(i);
             if (rb.isChecked()) objSave.setStudyArea(Integer.valueOf(d_rdogrpStudyArea[i]));
         }

         String[] d_rdogrpPreSumDiag = new String[] {"1","2"};
         objSave.setPreSumDiag(0);
         for (int i = 0; i < rdogrpPreSumDiag.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpPreSumDiag.getChildAt(i);
             if (rb.isChecked()) objSave.setPreSumDiag(Integer.valueOf(d_rdogrpPreSumDiag[i]));
         }

         objSave.setPreSumDiag1(txtPreSumDiag1.getText().toString());
         objSave.setPreSumDiag2(txtPreSumDiag2.getText().toString());
         objSave.setPreSumDiag3(txtPreSumDiag3.getText().toString());
         objSave.setPreSumDiag4(txtPreSumDiag4.getText().toString());
         objSave.setPreSumDiag5(txtPreSumDiag5.getText().toString());
         objSave.setOthSymp1(txtOthSymp1.getText().toString());
         objSave.setSymp1Dur(Integer.valueOf(txtSymp1Dur.getText().toString().length()==0?"0":txtSymp1Dur.getText().toString()));
         objSave.setOthSymp2(txtOthSymp2.getText().toString());
         objSave.setSymp2Dur(Integer.valueOf(txtSymp2Dur.getText().toString().length()==0?"0":txtSymp2Dur.getText().toString()));
         String[] d_rdogrpRefuesAdm = new String[] {"1","2","3"};
         objSave.setRefuesAdm(0);
         for (int i = 0; i < rdogrpRefuesAdm.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpRefuesAdm.getChildAt(i);
             if (rb.isChecked()) objSave.setRefuesAdm(Integer.valueOf(d_rdogrpRefuesAdm[i]));
         }

         objSave.setTRefusal(txtTRefusal.getText().toString());
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

             Connection.MessageBox(EmergencyScreening.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(EmergencyScreening.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(EmergencyScreening.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String PreEnrollmentID)
     {
       try
        {
     
           RadioButton rb;
           EmergencyScreening_DataModel d = new EmergencyScreening_DataModel();
           String SQL = "Select * from "+ TableName +"  Where PreEnrollmentID='"+ PreEnrollmentID +"'";
           List<EmergencyScreening_DataModel> data = d.SelectAll(this, SQL);
           for(EmergencyScreening_DataModel item : data){
             txtPreEnrollmentID.setText(String.valueOf(item.getPreEnrollmentID()));
             txtStudyID.setText(String.valueOf(item.getStudyID()));
             txtHosRegis.setText(String.valueOf(item.getHosRegis()));
             dtpDtEnroll.setText(item.getDtEnroll().toString().length()==0 ? "" : Global.DateConvertDMY(item.getDtEnroll()));
             txtCName.setText(item.getCName());
             dtpCDOB.setText(item.getCDOB().toString().length()==0 ? "" : Global.DateConvertDMY(item.getCDOB()));
             txtCAgeM.setText(String.valueOf(item.getCAgeM()));
             String[] d_rdogrpCSex = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpCSex.length; i++)
             {
                 if (String.valueOf(item.getCSex()).equals(String.valueOf(d_rdogrpCSex[i])))
                 {
                     rb = (RadioButton)rdogrpCSex.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtMFName.setText(item.getMFName());
             txtContact1.setText(item.getContact1());
             String[] d_rdogrpCont1Veri = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpCont1Veri.length; i++)
             {
                 if (String.valueOf(item.getCont1Veri()).equals(String.valueOf(d_rdogrpCont1Veri[i])))
                 {
                     rb = (RadioButton)rdogrpCont1Veri.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtCont1Rel.setText(item.getCont1Rel());
             txtContact2.setText(item.getContact2());
             String[] d_rdogrpCont2Veri = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpCont2Veri.length; i++)
             {
                 if (String.valueOf(item.getCont2Veri()).equals(String.valueOf(d_rdogrpCont2Veri[i])))
                 {
                     rb = (RadioButton)rdogrpCont2Veri.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtCont2Rel.setText(item.getCont2Rel());
             spnZila.setSelection(Global.SpinnerItemPositionAnyLength(spnZila, String.valueOf(item.getZila())));
             spnUpazila.setSelection(Global.SpinnerItemPositionAnyLength(spnUpazila, String.valueOf(item.getUpazila())));
             spnUnions.setSelection(Global.SpinnerItemPositionAnyLength(spnUnions, String.valueOf(item.getUnions())));
             spnVillage.setSelection(Global.SpinnerItemPositionAnyLength(spnVillage, String.valueOf(item.getVillage())));
             txtLocation.setText(item.getLocation());
             String[] d_rdogrpStudyArea = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpStudyArea.length; i++)
             {
                 if (String.valueOf(item.getStudyArea()).equals(String.valueOf(d_rdogrpStudyArea[i])))
                 {
                     rb = (RadioButton)rdogrpStudyArea.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpPreSumDiag = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpPreSumDiag.length; i++)
             {
                 if (String.valueOf(item.getPreSumDiag()).equals(String.valueOf(d_rdogrpPreSumDiag[i])))
                 {
                     rb = (RadioButton)rdogrpPreSumDiag.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtPreSumDiag1.setText(item.getPreSumDiag1());
             txtPreSumDiag2.setText(item.getPreSumDiag2());
             txtPreSumDiag3.setText(item.getPreSumDiag3());
             txtPreSumDiag4.setText(item.getPreSumDiag4());
             txtPreSumDiag5.setText(item.getPreSumDiag5());
             txtOthSymp1.setText(item.getOthSymp1());
             txtSymp1Dur.setText(String.valueOf(item.getSymp1Dur()));
             txtOthSymp2.setText(item.getOthSymp2());
             txtSymp2Dur.setText(String.valueOf(item.getSymp2Dur()));
             String[] d_rdogrpRefuesAdm = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpRefuesAdm.length; i++)
             {
                 if (String.valueOf(item.getRefuesAdm()).equals(String.valueOf(d_rdogrpRefuesAdm[i])))
                 {
                     rb = (RadioButton)rdogrpRefuesAdm.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtTRefusal.setText(item.getTRefusal());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(EmergencyScreening.this, e.getMessage());
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


              dtpDate = (EditText)findViewById(R.id.dtpDtEnroll);
             if (VariableID.equals("btnDtEnroll"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpDtEnroll);
              }
             else if (VariableID.equals("btnCDOB"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpCDOB);
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


              tpTime = (EditText)findViewById(R.id.txtTRefusal);
             if (VariableID.equals("btnTRefusal"))
              {
                  tpTime = (EditText)findViewById(R.id.txtTRefusal);
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