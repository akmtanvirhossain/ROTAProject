
 package org.icddrb.rotaproject;


 //Android Manifest Code
 //<activity android:name=".IPDScreening" android:label="IPDScreening" />
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

 public class IPDScreening extends Activity {
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
         LinearLayout secScrLabel1;
         View lineScrLabel1;
         LinearLayout secPreEnrollmentID;
         View linePreEnrollmentID;
         TextView VlblPreEnrollmentID;
         EditText txtPreEnrollmentID;
         LinearLayout sechasDiarr;
         View linehasDiarr;
         TextView VlblhasDiarr;
         RadioGroup rdogrphasDiarr;
         
         RadioButton rdohasDiarr1;
         RadioButton rdohasDiarr2;
         LinearLayout secIBDID;
         View lineIBDID;
         TextView VlblIBDID;
         EditText txtIBDID;
         LinearLayout secCName;
         View lineCName;
         TextView VlblCName;
         EditText txtCName;
         LinearLayout secCDOB;
         View lineCDOB;
         TextView VlblCDOB;
         EditText dtpCDOB;
         LinearLayout secCAge;
         View lineCAge;
         TextView VlblCAge;
         EditText txtCAge;
         LinearLayout secCSex;
         View lineCSex;
         TextView VlblCSex;
         RadioGroup rdogrpCSex;
         
         RadioButton rdoCSex1;
         RadioButton rdoCSex2;
         LinearLayout secHosAdDate;
         View lineHosAdDate;
         TextView VlblHosAdDate;
         EditText dtpHosAdDate;
         LinearLayout secHosAdTime;
         View lineHosAdTime;
         TextView VlblHosAdTime;
         EditText txtHosAdTime;
         LinearLayout secHosRegis1;
         View lineHosRegis1;
         TextView VlblHosRegis1;
         EditText txtHosRegis1;
         LinearLayout secHosBed1;
         View lineHosBed1;
         TextView VlblHosBed1;
         EditText txtHosBed1;
         LinearLayout secHosWard1;
         View lineHosWard1;
         TextView VlblHosWard1;
         EditText txtHosWard1;
         LinearLayout secHosRegis2;
         View lineHosRegis2;
         TextView VlblHosRegis2;
         EditText txtHosRegis2;
         LinearLayout secHosBed2;
         View lineHosBed2;
         TextView VlblHosBed2;
         EditText txtHosBed2;
         LinearLayout secHosWard2;
         View lineHosWard2;
         TextView VlblHosWard2;
         EditText txtHosWard2;
         LinearLayout secHosRegis3;
         View lineHosRegis3;
         TextView VlblHosRegis3;
         EditText txtHosRegis3;
         LinearLayout secHosBed3;
         View lineHosBed3;
         TextView VlblHosBed3;
         EditText txtHosBed3;
         LinearLayout secHosWard3;
         View lineHosWard3;
         TextView VlblHosWard3;
         EditText txtHosWard3;
         LinearLayout secProviDaig1;
         View lineProviDaig1;
         TextView VlblProviDaig1;
         AutoCompleteTextView txtProviDaig1;
         LinearLayout secProviDiag2;
         View lineProviDiag2;
         TextView VlblProviDiag2;
         AutoCompleteTextView txtProviDiag2;
         LinearLayout secProviDiag3;
         View lineProviDiag3;
         TextView VlblProviDiag3;
         AutoCompleteTextView txtProviDiag3;
         LinearLayout secProviDiag4;
         View lineProviDiag4;
         TextView VlblProviDiag4;
         AutoCompleteTextView txtProviDiag4;
         LinearLayout secProviDiag5;
         View lineProviDiag5;
         TextView VlblProviDiag5;
         AutoCompleteTextView txtProviDiag5;
         LinearLayout secScrLabel2;
         View lineScrLabel2;
         LinearLayout secAge5Yr;
         View lineAge5Yr;
         TextView VlblAge5Yr;
         RadioGroup rdogrpAge5Yr;
         
         RadioButton rdoAge5Yr1;
         RadioButton rdoAge5Yr2;
         LinearLayout secOccur3;
         View lineOccur3;
         TextView VlblOccur3;
         RadioGroup rdogrpOccur3;
         
         RadioButton rdoOccur31;
         RadioButton rdoOccur32;
         LinearLayout secDurDiarr;
         View lineDurDiarr;
         TextView VlblDurDiarr;
         EditText txtDurDiarr;
         LinearLayout secBldDiarr;
         View lineBldDiarr;
         TextView VlblBldDiarr;
         RadioGroup rdogrpBldDiarr;
         
         RadioButton rdoBldDiarr1;
         RadioButton rdoBldDiarr2;
         LinearLayout secEligiEnrol;
         View lineEligiEnrol;
         TextView VlblEligiEnrol;
         RadioGroup rdogrpEligiEnrol;
         
         RadioButton rdoEligiEnrol1;
         RadioButton rdoEligiEnrol2;
         LinearLayout secConsent;
         View lineConsent;
         TextView VlblConsent;
         RadioGroup rdogrpConsent;
         
         RadioButton rdoConsent1;
         RadioButton rdoConsent2;
         LinearLayout secStudyID;
         View lineStudyID;
         TextView VlblStudyID;
         EditText txtStudyID;
         LinearLayout secMFName;
         View lineMFName;
         TextView VlblMFName;
         EditText txtMFName;
         LinearLayout secContact1;
         View lineContact1;
         TextView VlblContact1;
         EditText txtContact1;
         LinearLayout seccont1Veri;
         View linecont1Veri;
         TextView Vlblcont1Veri;
         RadioGroup rdogrpcont1Veri;
         
         RadioButton rdocont1Veri1;
         RadioButton rdocont1Veri2;
         LinearLayout seccont1Rel;
         View linecont1Rel;
         TextView Vlblcont1Rel;
         EditText txtcont1Rel;
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
         LinearLayout seclbladd;
         View linelbladd;
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
         LinearLayout secSpeColAdv;
         View lineSpeColAdv;
         TextView VlblSpeColAdv;
         RadioGroup rdogrpSpeColAdv;
         
         RadioButton rdoSpeColAdv1;
         RadioButton rdoSpeColAdv2;

    static String TableName;

    static String STARTTIME = "";
    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    MySharedPreferences sp;

    Bundle IDbundle;
    static String PREENROLLMENTID = "";

     static String STUDYID     = "";
     static String CALLFROM      = "";
 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.ipdscreening);
         getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         PREENROLLMENTID = IDbundle.getString("PreEnrollmentID");

         TableName = "IPDScreening";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(IPDScreening.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});


         secScrLabel1=(LinearLayout)findViewById(R.id.secScrLabel1);
         lineScrLabel1=(View)findViewById(R.id.lineScrLabel1);
         secPreEnrollmentID=(LinearLayout)findViewById(R.id.secPreEnrollmentID);
         linePreEnrollmentID=(View)findViewById(R.id.linePreEnrollmentID);
         VlblPreEnrollmentID=(TextView) findViewById(R.id.VlblPreEnrollmentID);
         txtPreEnrollmentID=(EditText) findViewById(R.id.txtPreEnrollmentID);
         if(PREENROLLMENTID.length()==0)
             txtPreEnrollmentID.setText(NewParticipantID(DEVICEID));
         else
             txtPreEnrollmentID.setText(PREENROLLMENTID);
         txtPreEnrollmentID.setEnabled(false);

         sechasDiarr=(LinearLayout)findViewById(R.id.sechasDiarr);
         linehasDiarr=(View)findViewById(R.id.linehasDiarr);
         VlblhasDiarr = (TextView) findViewById(R.id.VlblhasDiarr);
         rdogrphasDiarr = (RadioGroup) findViewById(R.id.rdogrphasDiarr);
         
         rdohasDiarr1 = (RadioButton) findViewById(R.id.rdohasDiarr1);
         rdohasDiarr2 = (RadioButton) findViewById(R.id.rdohasDiarr2);
         rdogrphasDiarr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrphasDiarr = new String[] {"1","2"};
             for (int i = 0; i < rdogrphasDiarr.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrphasDiarr.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrphasDiarr[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secIBDID.setVisibility(View.GONE);
                    lineIBDID.setVisibility(View.GONE);
                    txtIBDID.setText("");
                    secCName.setVisibility(View.GONE);
                    lineCName.setVisibility(View.GONE);
                    txtCName.setText("");
                    secCDOB.setVisibility(View.GONE);
                    lineCDOB.setVisibility(View.GONE);
                    dtpCDOB.setText("");
                    secCAge.setVisibility(View.GONE);
                    lineCAge.setVisibility(View.GONE);
                    txtCAge.setText("");
                    secCSex.setVisibility(View.GONE);
                    lineCSex.setVisibility(View.GONE);
                    rdogrpCSex.clearCheck();
                    secHosAdDate.setVisibility(View.GONE);
                    lineHosAdDate.setVisibility(View.GONE);
                    dtpHosAdDate.setText("");
                    secHosAdTime.setVisibility(View.GONE);
                    lineHosAdTime.setVisibility(View.GONE);
                    txtHosAdTime.setText("");
                    secHosRegis1.setVisibility(View.GONE);
                    lineHosRegis1.setVisibility(View.GONE);
                    txtHosRegis1.setText("");
                    secHosBed1.setVisibility(View.GONE);
                    lineHosBed1.setVisibility(View.GONE);
                    txtHosBed1.setText("");
                    secHosWard1.setVisibility(View.GONE);
                    lineHosWard1.setVisibility(View.GONE);
                    txtHosWard1.setText("");
                    secHosRegis2.setVisibility(View.GONE);
                    lineHosRegis2.setVisibility(View.GONE);
                    txtHosRegis2.setText("");
                    secHosBed2.setVisibility(View.GONE);
                    lineHosBed2.setVisibility(View.GONE);
                    txtHosBed2.setText("");
                    secHosWard2.setVisibility(View.GONE);
                    lineHosWard2.setVisibility(View.GONE);
                    txtHosWard2.setText("");
                    secHosRegis3.setVisibility(View.GONE);
                    lineHosRegis3.setVisibility(View.GONE);
                    txtHosRegis3.setText("");
                    secHosBed3.setVisibility(View.GONE);
                    lineHosBed3.setVisibility(View.GONE);
                    txtHosBed3.setText("");
                    secHosWard3.setVisibility(View.GONE);
                    lineHosWard3.setVisibility(View.GONE);
                    txtHosWard3.setText("");
                    secProviDaig1.setVisibility(View.GONE);
                    lineProviDaig1.setVisibility(View.GONE);
                    txtProviDaig1.setText("");
                    secProviDiag2.setVisibility(View.GONE);
                    lineProviDiag2.setVisibility(View.GONE);
                    txtProviDiag2.setText("");
                    secProviDiag3.setVisibility(View.GONE);
                    lineProviDiag3.setVisibility(View.GONE);
                    txtProviDiag3.setText("");
                    secProviDiag4.setVisibility(View.GONE);
                    lineProviDiag4.setVisibility(View.GONE);
                    txtProviDiag4.setText("");
                    secProviDiag5.setVisibility(View.GONE);
                    lineProviDiag5.setVisibility(View.GONE);
                    txtProviDiag5.setText("");
                    secScrLabel2.setVisibility(View.GONE);
                    lineScrLabel2.setVisibility(View.GONE);
                    secAge5Yr.setVisibility(View.GONE);
                    lineAge5Yr.setVisibility(View.GONE);
                    rdogrpAge5Yr.clearCheck();
                    secOccur3.setVisibility(View.GONE);
                    lineOccur3.setVisibility(View.GONE);
                    rdogrpOccur3.clearCheck();
                    secDurDiarr.setVisibility(View.GONE);
                    lineDurDiarr.setVisibility(View.GONE);
                    txtDurDiarr.setText("");
                    secBldDiarr.setVisibility(View.GONE);
                    lineBldDiarr.setVisibility(View.GONE);
                    rdogrpBldDiarr.clearCheck();
                    secEligiEnrol.setVisibility(View.GONE);
                    lineEligiEnrol.setVisibility(View.GONE);
                    rdogrpEligiEnrol.clearCheck();
                    secConsent.setVisibility(View.GONE);
                    lineConsent.setVisibility(View.GONE);
                    rdogrpConsent.clearCheck();
                    secStudyID.setVisibility(View.GONE);
                    lineStudyID.setVisibility(View.GONE);
                    txtStudyID.setText("");
                    secMFName.setVisibility(View.GONE);
                    lineMFName.setVisibility(View.GONE);
                    txtMFName.setText("");
                    secContact1.setVisibility(View.GONE);
                    lineContact1.setVisibility(View.GONE);
                    txtContact1.setText("");
                    seccont1Veri.setVisibility(View.GONE);
                    linecont1Veri.setVisibility(View.GONE);
                    rdogrpcont1Veri.clearCheck();
                    seccont1Rel.setVisibility(View.GONE);
                    linecont1Rel.setVisibility(View.GONE);
                    txtcont1Rel.setText("");
                    secContact2.setVisibility(View.GONE);
                    lineContact2.setVisibility(View.GONE);
                    txtContact2.setText("");
                    secCont2Veri.setVisibility(View.GONE);
                    lineCont2Veri.setVisibility(View.GONE);
                    rdogrpCont2Veri.clearCheck();
                    secCont2Rel.setVisibility(View.GONE);
                    lineCont2Rel.setVisibility(View.GONE);
                    txtCont2Rel.setText("");
                    seclbladd.setVisibility(View.GONE);
                    linelbladd.setVisibility(View.GONE);
                    secZila.setVisibility(View.GONE);
                    lineZila.setVisibility(View.GONE);
                    spnZila.setSelection(0);
                    secUpazila.setVisibility(View.GONE);
                    lineUpazila.setVisibility(View.GONE);
                    spnUpazila.setSelection(0);
                    secUnions.setVisibility(View.GONE);
                    lineUnions.setVisibility(View.GONE);
                    spnUnions.setSelection(0);
                    secVillage.setVisibility(View.GONE);
                    lineVillage.setVisibility(View.GONE);
                    spnVillage.setSelection(0);
                    secLocation.setVisibility(View.GONE);
                    lineLocation.setVisibility(View.GONE);
                    txtLocation.setText("");
                    secStudyArea.setVisibility(View.GONE);
                    lineStudyArea.setVisibility(View.GONE);
                    rdogrpStudyArea.clearCheck();
                    secSpeColAdv.setVisibility(View.GONE);
                    lineSpeColAdv.setVisibility(View.GONE);
                    rdogrpSpeColAdv.clearCheck();
             }
             else
             {
                    secIBDID.setVisibility(View.VISIBLE);
                    lineIBDID.setVisibility(View.VISIBLE);
                    secCName.setVisibility(View.VISIBLE);
                    lineCName.setVisibility(View.VISIBLE);
                    secCDOB.setVisibility(View.VISIBLE);
                    lineCDOB.setVisibility(View.VISIBLE);
                    secCAge.setVisibility(View.VISIBLE);
                    lineCAge.setVisibility(View.VISIBLE);
                    secCSex.setVisibility(View.VISIBLE);
                    lineCSex.setVisibility(View.VISIBLE);
                    secHosAdDate.setVisibility(View.VISIBLE);
                    lineHosAdDate.setVisibility(View.VISIBLE);
                    secHosAdTime.setVisibility(View.VISIBLE);
                    lineHosAdTime.setVisibility(View.VISIBLE);
                    secHosRegis1.setVisibility(View.VISIBLE);
                    lineHosRegis1.setVisibility(View.VISIBLE);
                    secHosBed1.setVisibility(View.VISIBLE);
                    lineHosBed1.setVisibility(View.VISIBLE);
                    secHosWard1.setVisibility(View.VISIBLE);
                    lineHosWard1.setVisibility(View.VISIBLE);
                    secHosRegis2.setVisibility(View.VISIBLE);
                    lineHosRegis2.setVisibility(View.VISIBLE);
                    secHosBed2.setVisibility(View.VISIBLE);
                    lineHosBed2.setVisibility(View.VISIBLE);
                    secHosWard2.setVisibility(View.VISIBLE);
                    lineHosWard2.setVisibility(View.VISIBLE);
                    secHosRegis3.setVisibility(View.VISIBLE);
                    lineHosRegis3.setVisibility(View.VISIBLE);
                    secHosBed3.setVisibility(View.VISIBLE);
                    lineHosBed3.setVisibility(View.VISIBLE);
                    secHosWard3.setVisibility(View.VISIBLE);
                    lineHosWard3.setVisibility(View.VISIBLE);
                    secProviDaig1.setVisibility(View.VISIBLE);
                    lineProviDaig1.setVisibility(View.VISIBLE);
                    secProviDiag2.setVisibility(View.VISIBLE);
                    lineProviDiag2.setVisibility(View.VISIBLE);
                    secProviDiag3.setVisibility(View.VISIBLE);
                    lineProviDiag3.setVisibility(View.VISIBLE);
                    secProviDiag4.setVisibility(View.VISIBLE);
                    lineProviDiag4.setVisibility(View.VISIBLE);
                    secProviDiag5.setVisibility(View.VISIBLE);
                    lineProviDiag5.setVisibility(View.VISIBLE);
                    secScrLabel2.setVisibility(View.VISIBLE);
                    lineScrLabel2.setVisibility(View.VISIBLE);
                    secAge5Yr.setVisibility(View.VISIBLE);
                    lineAge5Yr.setVisibility(View.VISIBLE);
                    secOccur3.setVisibility(View.VISIBLE);
                    lineOccur3.setVisibility(View.VISIBLE);
                    secDurDiarr.setVisibility(View.VISIBLE);
                    lineDurDiarr.setVisibility(View.VISIBLE);
                    secBldDiarr.setVisibility(View.VISIBLE);
                    lineBldDiarr.setVisibility(View.VISIBLE);
                    secEligiEnrol.setVisibility(View.VISIBLE);
                    lineEligiEnrol.setVisibility(View.VISIBLE);
                    secConsent.setVisibility(View.VISIBLE);
                    lineConsent.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secIBDID=(LinearLayout)findViewById(R.id.secIBDID);
         lineIBDID=(View)findViewById(R.id.lineIBDID);
         VlblIBDID=(TextView) findViewById(R.id.VlblIBDID);
         txtIBDID=(EditText) findViewById(R.id.txtIBDID);
         secCName=(LinearLayout)findViewById(R.id.secCName);
         lineCName=(View)findViewById(R.id.lineCName);
         VlblCName=(TextView) findViewById(R.id.VlblCName);
         txtCName=(EditText) findViewById(R.id.txtCName);
         secCDOB=(LinearLayout)findViewById(R.id.secCDOB);
         lineCDOB=(View)findViewById(R.id.lineCDOB);
         VlblCDOB=(TextView) findViewById(R.id.VlblCDOB);
         dtpCDOB=(EditText) findViewById(R.id.dtpCDOB);
         secCAge=(LinearLayout)findViewById(R.id.secCAge);
         lineCAge=(View)findViewById(R.id.lineCAge);
         VlblCAge=(TextView) findViewById(R.id.VlblCAge);
         txtCAge=(EditText) findViewById(R.id.txtCAge);
         secCSex=(LinearLayout)findViewById(R.id.secCSex);
         lineCSex=(View)findViewById(R.id.lineCSex);
         VlblCSex = (TextView) findViewById(R.id.VlblCSex);
         rdogrpCSex = (RadioGroup) findViewById(R.id.rdogrpCSex);
         
         rdoCSex1 = (RadioButton) findViewById(R.id.rdoCSex1);
         rdoCSex2 = (RadioButton) findViewById(R.id.rdoCSex2);
         secHosAdDate=(LinearLayout)findViewById(R.id.secHosAdDate);
         lineHosAdDate=(View)findViewById(R.id.lineHosAdDate);
         VlblHosAdDate=(TextView) findViewById(R.id.VlblHosAdDate);
         dtpHosAdDate=(EditText) findViewById(R.id.dtpHosAdDate);
         secHosAdTime=(LinearLayout)findViewById(R.id.secHosAdTime);
         lineHosAdTime=(View)findViewById(R.id.lineHosAdTime);
         VlblHosAdTime=(TextView) findViewById(R.id.VlblHosAdTime);
         txtHosAdTime=(EditText) findViewById(R.id.txtHosAdTime);
         secHosRegis1=(LinearLayout)findViewById(R.id.secHosRegis1);
         lineHosRegis1=(View)findViewById(R.id.lineHosRegis1);
         VlblHosRegis1=(TextView) findViewById(R.id.VlblHosRegis1);
         txtHosRegis1=(EditText) findViewById(R.id.txtHosRegis1);
         secHosBed1=(LinearLayout)findViewById(R.id.secHosBed1);
         lineHosBed1=(View)findViewById(R.id.lineHosBed1);
         VlblHosBed1=(TextView) findViewById(R.id.VlblHosBed1);
         txtHosBed1=(EditText) findViewById(R.id.txtHosBed1);
         secHosWard1=(LinearLayout)findViewById(R.id.secHosWard1);
         lineHosWard1=(View)findViewById(R.id.lineHosWard1);
         VlblHosWard1=(TextView) findViewById(R.id.VlblHosWard1);
         txtHosWard1=(EditText) findViewById(R.id.txtHosWard1);
         secHosRegis2=(LinearLayout)findViewById(R.id.secHosRegis2);
         lineHosRegis2=(View)findViewById(R.id.lineHosRegis2);
         VlblHosRegis2=(TextView) findViewById(R.id.VlblHosRegis2);
         txtHosRegis2=(EditText) findViewById(R.id.txtHosRegis2);
         secHosBed2=(LinearLayout)findViewById(R.id.secHosBed2);
         lineHosBed2=(View)findViewById(R.id.lineHosBed2);
         VlblHosBed2=(TextView) findViewById(R.id.VlblHosBed2);
         txtHosBed2=(EditText) findViewById(R.id.txtHosBed2);
         secHosWard2=(LinearLayout)findViewById(R.id.secHosWard2);
         lineHosWard2=(View)findViewById(R.id.lineHosWard2);
         VlblHosWard2=(TextView) findViewById(R.id.VlblHosWard2);
         txtHosWard2=(EditText) findViewById(R.id.txtHosWard2);
         secHosRegis3=(LinearLayout)findViewById(R.id.secHosRegis3);
         lineHosRegis3=(View)findViewById(R.id.lineHosRegis3);
         VlblHosRegis3=(TextView) findViewById(R.id.VlblHosRegis3);
         txtHosRegis3=(EditText) findViewById(R.id.txtHosRegis3);
         secHosBed3=(LinearLayout)findViewById(R.id.secHosBed3);
         lineHosBed3=(View)findViewById(R.id.lineHosBed3);
         VlblHosBed3=(TextView) findViewById(R.id.VlblHosBed3);
         txtHosBed3=(EditText) findViewById(R.id.txtHosBed3);
         secHosWard3=(LinearLayout)findViewById(R.id.secHosWard3);
         lineHosWard3=(View)findViewById(R.id.lineHosWard3);
         VlblHosWard3=(TextView) findViewById(R.id.VlblHosWard3);
         txtHosWard3=(EditText) findViewById(R.id.txtHosWard3);
         secProviDaig1=(LinearLayout)findViewById(R.id.secProviDaig1);
         lineProviDaig1=(View)findViewById(R.id.lineProviDaig1);
         VlblProviDaig1=(TextView) findViewById(R.id.VlblProviDaig1);
         txtProviDaig1=(AutoCompleteTextView) findViewById(R.id.txtProviDaig1);
         txtProviDaig1.setAdapter(C.getArrayAdapter("Select distinct ProviDaig1 from "+ TableName +" order by ProviDaig1"));

         txtProviDaig1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtProviDaig1.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtProviDaig1.getRight() - txtProviDaig1.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secProviDiag2=(LinearLayout)findViewById(R.id.secProviDiag2);
         lineProviDiag2=(View)findViewById(R.id.lineProviDiag2);
         VlblProviDiag2=(TextView) findViewById(R.id.VlblProviDiag2);
         txtProviDiag2=(AutoCompleteTextView) findViewById(R.id.txtProviDiag2);
         txtProviDiag2.setAdapter(C.getArrayAdapter("Select distinct ProviDiag2 from "+ TableName +" order by ProviDiag2"));

         txtProviDiag2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtProviDiag2.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtProviDiag2.getRight() - txtProviDiag2.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secProviDiag3=(LinearLayout)findViewById(R.id.secProviDiag3);
         lineProviDiag3=(View)findViewById(R.id.lineProviDiag3);
         VlblProviDiag3=(TextView) findViewById(R.id.VlblProviDiag3);
         txtProviDiag3=(AutoCompleteTextView) findViewById(R.id.txtProviDiag3);
         txtProviDiag3.setAdapter(C.getArrayAdapter("Select distinct ProviDiag3 from "+ TableName +" order by ProviDiag3"));

         txtProviDiag3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtProviDiag3.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtProviDiag3.getRight() - txtProviDiag3.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secProviDiag4=(LinearLayout)findViewById(R.id.secProviDiag4);
         lineProviDiag4=(View)findViewById(R.id.lineProviDiag4);
         VlblProviDiag4=(TextView) findViewById(R.id.VlblProviDiag4);
         txtProviDiag4=(AutoCompleteTextView) findViewById(R.id.txtProviDiag4);
         txtProviDiag4.setAdapter(C.getArrayAdapter("Select distinct ProviDiag4 from "+ TableName +" order by ProviDiag4"));

         txtProviDiag4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtProviDiag4.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtProviDiag4.getRight() - txtProviDiag4.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secProviDiag5=(LinearLayout)findViewById(R.id.secProviDiag5);
         lineProviDiag5=(View)findViewById(R.id.lineProviDiag5);
         VlblProviDiag5=(TextView) findViewById(R.id.VlblProviDiag5);
         txtProviDiag5=(AutoCompleteTextView) findViewById(R.id.txtProviDiag5);
         txtProviDiag5.setAdapter(C.getArrayAdapter("Select distinct ProviDiag5 from "+ TableName +" order by ProviDiag5"));

         txtProviDiag5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) {

             }
         });
         txtProviDiag5.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
         
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtProviDiag5.getRight() - txtProviDiag5.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });
         secScrLabel2=(LinearLayout)findViewById(R.id.secScrLabel2);
         lineScrLabel2=(View)findViewById(R.id.lineScrLabel2);
         secAge5Yr=(LinearLayout)findViewById(R.id.secAge5Yr);
         lineAge5Yr=(View)findViewById(R.id.lineAge5Yr);
         VlblAge5Yr = (TextView) findViewById(R.id.VlblAge5Yr);
         rdogrpAge5Yr = (RadioGroup) findViewById(R.id.rdogrpAge5Yr);
         
         rdoAge5Yr1 = (RadioButton) findViewById(R.id.rdoAge5Yr1);
         rdoAge5Yr2 = (RadioButton) findViewById(R.id.rdoAge5Yr2);
         secOccur3=(LinearLayout)findViewById(R.id.secOccur3);
         lineOccur3=(View)findViewById(R.id.lineOccur3);
         VlblOccur3 = (TextView) findViewById(R.id.VlblOccur3);
         rdogrpOccur3 = (RadioGroup) findViewById(R.id.rdogrpOccur3);
         
         rdoOccur31 = (RadioButton) findViewById(R.id.rdoOccur31);
         rdoOccur32 = (RadioButton) findViewById(R.id.rdoOccur32);
         secDurDiarr=(LinearLayout)findViewById(R.id.secDurDiarr);
         lineDurDiarr=(View)findViewById(R.id.lineDurDiarr);
         VlblDurDiarr=(TextView) findViewById(R.id.VlblDurDiarr);
         txtDurDiarr=(EditText) findViewById(R.id.txtDurDiarr);
         secBldDiarr=(LinearLayout)findViewById(R.id.secBldDiarr);
         lineBldDiarr=(View)findViewById(R.id.lineBldDiarr);
         VlblBldDiarr = (TextView) findViewById(R.id.VlblBldDiarr);
         rdogrpBldDiarr = (RadioGroup) findViewById(R.id.rdogrpBldDiarr);
         
         rdoBldDiarr1 = (RadioButton) findViewById(R.id.rdoBldDiarr1);
         rdoBldDiarr2 = (RadioButton) findViewById(R.id.rdoBldDiarr2);
         secEligiEnrol=(LinearLayout)findViewById(R.id.secEligiEnrol);
         lineEligiEnrol=(View)findViewById(R.id.lineEligiEnrol);
         VlblEligiEnrol = (TextView) findViewById(R.id.VlblEligiEnrol);
         rdogrpEligiEnrol = (RadioGroup) findViewById(R.id.rdogrpEligiEnrol);
         
         rdoEligiEnrol1 = (RadioButton) findViewById(R.id.rdoEligiEnrol1);
         rdoEligiEnrol2 = (RadioButton) findViewById(R.id.rdoEligiEnrol2);
         rdogrpEligiEnrol.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpEligiEnrol = new String[] {"1","2"};
             for (int i = 0; i < rdogrpEligiEnrol.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpEligiEnrol.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpEligiEnrol[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secConsent.setVisibility(View.GONE);
                    lineConsent.setVisibility(View.GONE);
                    rdogrpConsent.clearCheck();
                    secStudyID.setVisibility(View.GONE);
                    lineStudyID.setVisibility(View.GONE);
                    txtStudyID.setText("");
                    secMFName.setVisibility(View.GONE);
                    lineMFName.setVisibility(View.GONE);
                    txtMFName.setText("");
                    secContact1.setVisibility(View.GONE);
                    lineContact1.setVisibility(View.GONE);
                    txtContact1.setText("");
                    seccont1Veri.setVisibility(View.GONE);
                    linecont1Veri.setVisibility(View.GONE);
                    rdogrpcont1Veri.clearCheck();
                    seccont1Rel.setVisibility(View.GONE);
                    linecont1Rel.setVisibility(View.GONE);
                    txtcont1Rel.setText("");
                    secContact2.setVisibility(View.GONE);
                    lineContact2.setVisibility(View.GONE);
                    txtContact2.setText("");
                    secCont2Veri.setVisibility(View.GONE);
                    lineCont2Veri.setVisibility(View.GONE);
                    rdogrpCont2Veri.clearCheck();
                    secCont2Rel.setVisibility(View.GONE);
                    lineCont2Rel.setVisibility(View.GONE);
                    txtCont2Rel.setText("");
                    seclbladd.setVisibility(View.GONE);
                    linelbladd.setVisibility(View.GONE);
                    secZila.setVisibility(View.GONE);
                    lineZila.setVisibility(View.GONE);
                    spnZila.setSelection(0);
                    secUpazila.setVisibility(View.GONE);
                    lineUpazila.setVisibility(View.GONE);
                    spnUpazila.setSelection(0);
                    secUnions.setVisibility(View.GONE);
                    lineUnions.setVisibility(View.GONE);
                    spnUnions.setSelection(0);
                    secVillage.setVisibility(View.GONE);
                    lineVillage.setVisibility(View.GONE);
                    spnVillage.setSelection(0);
                    secLocation.setVisibility(View.GONE);
                    lineLocation.setVisibility(View.GONE);
                    txtLocation.setText("");
                    secStudyArea.setVisibility(View.GONE);
                    lineStudyArea.setVisibility(View.GONE);
                    rdogrpStudyArea.clearCheck();
                    secSpeColAdv.setVisibility(View.GONE);
                    lineSpeColAdv.setVisibility(View.GONE);
                    rdogrpSpeColAdv.clearCheck();
             }
             else
             {
                    secConsent.setVisibility(View.VISIBLE);
                    lineConsent.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secConsent=(LinearLayout)findViewById(R.id.secConsent);
         lineConsent=(View)findViewById(R.id.lineConsent);
         VlblConsent = (TextView) findViewById(R.id.VlblConsent);
         rdogrpConsent = (RadioGroup) findViewById(R.id.rdogrpConsent);
         
         rdoConsent1 = (RadioButton) findViewById(R.id.rdoConsent1);
         rdoConsent2 = (RadioButton) findViewById(R.id.rdoConsent2);
         rdogrpConsent.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpConsent = new String[] {"1","2"};
             for (int i = 0; i < rdogrpConsent.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpConsent.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpConsent[i];
             }




             if(rbData.equalsIgnoreCase("1")){
                 secStudyID.setVisibility(View.VISIBLE);
                 lineStudyID.setVisibility(View.VISIBLE);
                 secMFName.setVisibility(View.VISIBLE);
                 lineMFName.setVisibility(View.VISIBLE);
                 secContact1.setVisibility(View.VISIBLE);
                 lineContact1.setVisibility(View.VISIBLE);
                 seccont1Veri.setVisibility(View.VISIBLE);
                 linecont1Veri.setVisibility(View.VISIBLE);
                 seccont1Rel.setVisibility(View.VISIBLE);
                 linecont1Rel.setVisibility(View.VISIBLE);
                 secContact2.setVisibility(View.VISIBLE);
                 lineContact2.setVisibility(View.VISIBLE);
                 secCont2Veri.setVisibility(View.VISIBLE);
                 lineCont2Veri.setVisibility(View.VISIBLE);
                 secCont2Rel.setVisibility(View.VISIBLE);
                 lineCont2Rel.setVisibility(View.VISIBLE);
                 secZila.setVisibility(View.VISIBLE);
                 lineZila.setVisibility(View.VISIBLE);
                 secUpazila.setVisibility(View.VISIBLE);
                 lineUpazila.setVisibility(View.VISIBLE);
                 secUnions.setVisibility(View.VISIBLE);
                 lineUnions.setVisibility(View.VISIBLE);
                 secVillage.setVisibility(View.VISIBLE);
                 lineVillage.setVisibility(View.VISIBLE);
                 secLocation.setVisibility(View.VISIBLE);
                 lineLocation.setVisibility(View.VISIBLE);
                 secStudyArea.setVisibility(View.VISIBLE);
                 lineStudyArea.setVisibility(View.VISIBLE);
                 secSpeColAdv.setVisibility(View.VISIBLE);
                 lineSpeColAdv.setVisibility(View.VISIBLE);

                 if(CALLFROM.equals("n"))
                     txtStudyID.setText(NewStudyID(DEVICEID));
                 else {
                     if(STUDYID.length()==0)
                         txtStudyID.setText(NewStudyID(DEVICEID));
                     else
                         txtStudyID.setText(STUDYID);
                 }
             }

             else if(rbData.equalsIgnoreCase("2"))
             {
                    secStudyID.setVisibility(View.GONE);
                    lineStudyID.setVisibility(View.GONE);
                    txtStudyID.setText("");
                    secMFName.setVisibility(View.GONE);
                    lineMFName.setVisibility(View.GONE);
                    txtMFName.setText("");
                    secContact1.setVisibility(View.GONE);
                    lineContact1.setVisibility(View.GONE);
                    txtContact1.setText("");
                    seccont1Veri.setVisibility(View.GONE);
                    linecont1Veri.setVisibility(View.GONE);
                    rdogrpcont1Veri.clearCheck();
                    seccont1Rel.setVisibility(View.GONE);
                    linecont1Rel.setVisibility(View.GONE);
                    txtcont1Rel.setText("");
                    secContact2.setVisibility(View.GONE);
                    lineContact2.setVisibility(View.GONE);
                    txtContact2.setText("");
                    secCont2Veri.setVisibility(View.GONE);
                    lineCont2Veri.setVisibility(View.GONE);
                    rdogrpCont2Veri.clearCheck();
                    secCont2Rel.setVisibility(View.GONE);
                    lineCont2Rel.setVisibility(View.GONE);
                    txtCont2Rel.setText("");
                    seclbladd.setVisibility(View.GONE);
                    linelbladd.setVisibility(View.GONE);
                    secZila.setVisibility(View.GONE);
                    lineZila.setVisibility(View.GONE);
                    spnZila.setSelection(0);
                    secUpazila.setVisibility(View.GONE);
                    lineUpazila.setVisibility(View.GONE);
                    spnUpazila.setSelection(0);
                    secUnions.setVisibility(View.GONE);
                    lineUnions.setVisibility(View.GONE);
                    spnUnions.setSelection(0);
                    secVillage.setVisibility(View.GONE);
                    lineVillage.setVisibility(View.GONE);
                    spnVillage.setSelection(0);
                    secLocation.setVisibility(View.GONE);
                    lineLocation.setVisibility(View.GONE);
                    txtLocation.setText("");
                    secStudyArea.setVisibility(View.GONE);
                    lineStudyArea.setVisibility(View.GONE);
                    rdogrpStudyArea.clearCheck();
                    secSpeColAdv.setVisibility(View.GONE);
                    lineSpeColAdv.setVisibility(View.GONE);
                    rdogrpSpeColAdv.clearCheck();
             }
             else
             {
                    secStudyID.setVisibility(View.VISIBLE);
                    lineStudyID.setVisibility(View.VISIBLE);
                    secMFName.setVisibility(View.VISIBLE);
                    lineMFName.setVisibility(View.VISIBLE);
                    secContact1.setVisibility(View.VISIBLE);
                    lineContact1.setVisibility(View.VISIBLE);
                    seccont1Veri.setVisibility(View.VISIBLE);
                    linecont1Veri.setVisibility(View.VISIBLE);
                    seccont1Rel.setVisibility(View.VISIBLE);
                    linecont1Rel.setVisibility(View.VISIBLE);
                    secContact2.setVisibility(View.VISIBLE);
                    lineContact2.setVisibility(View.VISIBLE);
                    secCont2Veri.setVisibility(View.VISIBLE);
                    lineCont2Veri.setVisibility(View.VISIBLE);
                    secCont2Rel.setVisibility(View.VISIBLE);
                    lineCont2Rel.setVisibility(View.VISIBLE);
                    seclbladd.setVisibility(View.VISIBLE);
                    linelbladd.setVisibility(View.VISIBLE);
                    secZila.setVisibility(View.VISIBLE);
                    lineZila.setVisibility(View.VISIBLE);
                    secUpazila.setVisibility(View.VISIBLE);
                    lineUpazila.setVisibility(View.VISIBLE);
                    secUnions.setVisibility(View.VISIBLE);
                    lineUnions.setVisibility(View.VISIBLE);
                    secVillage.setVisibility(View.VISIBLE);
                    lineVillage.setVisibility(View.VISIBLE);
                    secLocation.setVisibility(View.VISIBLE);
                    lineLocation.setVisibility(View.VISIBLE);
                    secStudyArea.setVisibility(View.VISIBLE);
                    lineStudyArea.setVisibility(View.VISIBLE);
                    secSpeColAdv.setVisibility(View.VISIBLE);
                    lineSpeColAdv.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secStudyID=(LinearLayout)findViewById(R.id.secStudyID);
         lineStudyID=(View)findViewById(R.id.lineStudyID);
         VlblStudyID=(TextView) findViewById(R.id.VlblStudyID);
         txtStudyID=(EditText) findViewById(R.id.txtStudyID);
         secMFName=(LinearLayout)findViewById(R.id.secMFName);
         lineMFName=(View)findViewById(R.id.lineMFName);
         VlblMFName=(TextView) findViewById(R.id.VlblMFName);
         txtMFName=(EditText) findViewById(R.id.txtMFName);
         secContact1=(LinearLayout)findViewById(R.id.secContact1);
         lineContact1=(View)findViewById(R.id.lineContact1);
         VlblContact1=(TextView) findViewById(R.id.VlblContact1);
         txtContact1=(EditText) findViewById(R.id.txtContact1);
         seccont1Veri=(LinearLayout)findViewById(R.id.seccont1Veri);
         linecont1Veri=(View)findViewById(R.id.linecont1Veri);
         Vlblcont1Veri = (TextView) findViewById(R.id.Vlblcont1Veri);
         rdogrpcont1Veri = (RadioGroup) findViewById(R.id.rdogrpcont1Veri);
         
         rdocont1Veri1 = (RadioButton) findViewById(R.id.rdocont1Veri1);
         rdocont1Veri2 = (RadioButton) findViewById(R.id.rdocont1Veri2);
         seccont1Rel=(LinearLayout)findViewById(R.id.seccont1Rel);
         linecont1Rel=(View)findViewById(R.id.linecont1Rel);
         Vlblcont1Rel=(TextView) findViewById(R.id.Vlblcont1Rel);
         txtcont1Rel=(EditText) findViewById(R.id.txtcont1Rel);
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
         seclbladd=(LinearLayout)findViewById(R.id.seclbladd);
         linelbladd=(View)findViewById(R.id.linelbladd);
         secZila=(LinearLayout)findViewById(R.id.secZila);
         lineZila=(View)findViewById(R.id.lineZila);
         VlblZila=(TextView) findViewById(R.id.VlblZila);
         spnZila=(Spinner) findViewById(R.id.spnZila);
         List<String> listZila = new ArrayList<String>();
         
         listZila.add("");
         listZila.add("01-Dhaka");
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
         secSpeColAdv=(LinearLayout)findViewById(R.id.secSpeColAdv);
         lineSpeColAdv=(View)findViewById(R.id.lineSpeColAdv);
         VlblSpeColAdv = (TextView) findViewById(R.id.VlblSpeColAdv);
         rdogrpSpeColAdv = (RadioGroup) findViewById(R.id.rdogrpSpeColAdv);
         
         rdoSpeColAdv1 = (RadioButton) findViewById(R.id.rdoSpeColAdv1);
         rdoSpeColAdv2 = (RadioButton) findViewById(R.id.rdoSpeColAdv2);


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
         dtpHosAdDate.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpHosAdDate.getRight() - dtpHosAdDate.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnHosAdDate"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });


         txtHosAdTime.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtHosAdTime.getRight() - txtHosAdTime.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btnHosAdTime"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });

         //Hide all skip variables
         secIBDID.setVisibility(View.GONE);
         lineIBDID.setVisibility(View.GONE);
         secCName.setVisibility(View.GONE);
         lineCName.setVisibility(View.GONE);
         secCDOB.setVisibility(View.GONE);
         lineCDOB.setVisibility(View.GONE);
         secCAge.setVisibility(View.GONE);
         lineCAge.setVisibility(View.GONE);
         secCSex.setVisibility(View.GONE);
         lineCSex.setVisibility(View.GONE);
         secHosAdDate.setVisibility(View.GONE);
         lineHosAdDate.setVisibility(View.GONE);
         secHosAdTime.setVisibility(View.GONE);
         lineHosAdTime.setVisibility(View.GONE);
         secHosRegis1.setVisibility(View.GONE);
         lineHosRegis1.setVisibility(View.GONE);
         secHosBed1.setVisibility(View.GONE);
         lineHosBed1.setVisibility(View.GONE);
         secHosWard1.setVisibility(View.GONE);
         lineHosWard1.setVisibility(View.GONE);
         secHosRegis2.setVisibility(View.GONE);
         lineHosRegis2.setVisibility(View.GONE);
         secHosBed2.setVisibility(View.GONE);
         lineHosBed2.setVisibility(View.GONE);
         secHosWard2.setVisibility(View.GONE);
         lineHosWard2.setVisibility(View.GONE);
         secHosRegis3.setVisibility(View.GONE);
         lineHosRegis3.setVisibility(View.GONE);
         secHosBed3.setVisibility(View.GONE);
         lineHosBed3.setVisibility(View.GONE);
         secHosWard3.setVisibility(View.GONE);
         lineHosWard3.setVisibility(View.GONE);
         secProviDaig1.setVisibility(View.GONE);
         lineProviDaig1.setVisibility(View.GONE);
         secProviDiag2.setVisibility(View.GONE);
         lineProviDiag2.setVisibility(View.GONE);
         secProviDiag3.setVisibility(View.GONE);
         lineProviDiag3.setVisibility(View.GONE);
         secProviDiag4.setVisibility(View.GONE);
         lineProviDiag4.setVisibility(View.GONE);
         secProviDiag5.setVisibility(View.GONE);
         lineProviDiag5.setVisibility(View.GONE);
         secScrLabel2.setVisibility(View.GONE);
         lineScrLabel2.setVisibility(View.GONE);
         secAge5Yr.setVisibility(View.GONE);
         lineAge5Yr.setVisibility(View.GONE);
         secOccur3.setVisibility(View.GONE);
         lineOccur3.setVisibility(View.GONE);
         secDurDiarr.setVisibility(View.GONE);
         lineDurDiarr.setVisibility(View.GONE);
         secBldDiarr.setVisibility(View.GONE);
         lineBldDiarr.setVisibility(View.GONE);
         secEligiEnrol.setVisibility(View.GONE);
         lineEligiEnrol.setVisibility(View.GONE);
         secConsent.setVisibility(View.GONE);
         lineConsent.setVisibility(View.GONE);
         secStudyID.setVisibility(View.GONE);
         lineStudyID.setVisibility(View.GONE);
         secMFName.setVisibility(View.GONE);
         lineMFName.setVisibility(View.GONE);
         secContact1.setVisibility(View.GONE);
         lineContact1.setVisibility(View.GONE);
         seccont1Veri.setVisibility(View.GONE);
         linecont1Veri.setVisibility(View.GONE);
         seccont1Rel.setVisibility(View.GONE);
         linecont1Rel.setVisibility(View.GONE);
         secContact2.setVisibility(View.GONE);
         lineContact2.setVisibility(View.GONE);
         secCont2Veri.setVisibility(View.GONE);
         lineCont2Veri.setVisibility(View.GONE);
         secCont2Rel.setVisibility(View.GONE);
         lineCont2Rel.setVisibility(View.GONE);
         seclbladd.setVisibility(View.GONE);
         linelbladd.setVisibility(View.GONE);
         secZila.setVisibility(View.GONE);
         lineZila.setVisibility(View.GONE);
         secUpazila.setVisibility(View.GONE);
         lineUpazila.setVisibility(View.GONE);
         secUnions.setVisibility(View.GONE);
         lineUnions.setVisibility(View.GONE);
         secVillage.setVisibility(View.GONE);
         lineVillage.setVisibility(View.GONE);
         secLocation.setVisibility(View.GONE);
         lineLocation.setVisibility(View.GONE);
         secStudyArea.setVisibility(View.GONE);
         lineStudyArea.setVisibility(View.GONE);
         secSpeColAdv.setVisibility(View.GONE);
         lineSpeColAdv.setVisibility(View.GONE);
         secConsent.setVisibility(View.GONE);
         lineConsent.setVisibility(View.GONE);
         secStudyID.setVisibility(View.GONE);
         lineStudyID.setVisibility(View.GONE);
         secMFName.setVisibility(View.GONE);
         lineMFName.setVisibility(View.GONE);
         secContact1.setVisibility(View.GONE);
         lineContact1.setVisibility(View.GONE);
         seccont1Veri.setVisibility(View.GONE);
         linecont1Veri.setVisibility(View.GONE);
         seccont1Rel.setVisibility(View.GONE);
         linecont1Rel.setVisibility(View.GONE);
         secContact2.setVisibility(View.GONE);
         lineContact2.setVisibility(View.GONE);
         secCont2Veri.setVisibility(View.GONE);
         lineCont2Veri.setVisibility(View.GONE);
         secCont2Rel.setVisibility(View.GONE);
         lineCont2Rel.setVisibility(View.GONE);
         seclbladd.setVisibility(View.GONE);
         linelbladd.setVisibility(View.GONE);
         secZila.setVisibility(View.GONE);
         lineZila.setVisibility(View.GONE);
         secUpazila.setVisibility(View.GONE);
         lineUpazila.setVisibility(View.GONE);
         secUnions.setVisibility(View.GONE);
         lineUnions.setVisibility(View.GONE);
         secVillage.setVisibility(View.GONE);
         lineVillage.setVisibility(View.GONE);
         secLocation.setVisibility(View.GONE);
         lineLocation.setVisibility(View.GONE);
         secStudyArea.setVisibility(View.GONE);
         lineStudyArea.setVisibility(View.GONE);
         secSpeColAdv.setVisibility(View.GONE);
         lineSpeColAdv.setVisibility(View.GONE);
         secStudyID.setVisibility(View.GONE);
         lineStudyID.setVisibility(View.GONE);
         secMFName.setVisibility(View.GONE);
         lineMFName.setVisibility(View.GONE);
         secContact1.setVisibility(View.GONE);
         lineContact1.setVisibility(View.GONE);
         seccont1Veri.setVisibility(View.GONE);
         linecont1Veri.setVisibility(View.GONE);
         seccont1Rel.setVisibility(View.GONE);
         linecont1Rel.setVisibility(View.GONE);
         secContact2.setVisibility(View.GONE);
         lineContact2.setVisibility(View.GONE);
         secCont2Veri.setVisibility(View.GONE);
         lineCont2Veri.setVisibility(View.GONE);
         secCont2Rel.setVisibility(View.GONE);
         lineCont2Rel.setVisibility(View.GONE);
         seclbladd.setVisibility(View.GONE);
         linelbladd.setVisibility(View.GONE);
         secZila.setVisibility(View.GONE);
         lineZila.setVisibility(View.GONE);
         secUpazila.setVisibility(View.GONE);
         lineUpazila.setVisibility(View.GONE);
         secUnions.setVisibility(View.GONE);
         lineUnions.setVisibility(View.GONE);
         secVillage.setVisibility(View.GONE);
         lineVillage.setVisibility(View.GONE);
         secLocation.setVisibility(View.GONE);
         lineLocation.setVisibility(View.GONE);
         secStudyArea.setVisibility(View.GONE);
         lineStudyArea.setVisibility(View.GONE);
         secSpeColAdv.setVisibility(View.GONE);
         lineSpeColAdv.setVisibility(View.GONE);

        DataSearch(PREENROLLMENTID);
        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(IPDScreening.this, e.getMessage());
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
             Connection.MessageBox(IPDScreening.this, "Required field: PreEnrollment ID.");
             txtPreEnrollmentID.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0 ? "1" : txtPreEnrollmentID.getText().toString()) < 1 || Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0 ? "88888888" : txtPreEnrollmentID.getText().toString()) > 88888888)
           {
             Connection.MessageBox(IPDScreening.this, "Value should be between 1 and 88888888(PreEnrollment ID).");
             txtPreEnrollmentID.requestFocus(); 
             return;	
           }
         
         else if(!rdohasDiarr1.isChecked() & !rdohasDiarr2.isChecked() & sechasDiarr.isShown())
           {
              Connection.MessageBox(IPDScreening.this, "Select anyone options from (Baby diarrhea).");
              rdohasDiarr1.requestFocus();
              return;
           }
         else if(txtIBDID.getText().toString().length()==0 & secIBDID.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: IBD ID.");
             txtIBDID.requestFocus(); 
             return;	
           }
         else if(txtCName.getText().toString().length()==0 & secCName.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: Child name.");
             txtCName.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpCDOB.getText().toString());
         if(DV.length()!=0 & secCDOB.isShown())
           {
             Connection.MessageBox(IPDScreening.this, DV);
             dtpCDOB.requestFocus(); 
             return;	
           }
         else if(txtCAge.getText().toString().length()==0 & secCAge.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: Child age in months.");
             txtCAge.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtCAge.getText().toString().length()==0 ? "00" : txtCAge.getText().toString()) < 00 || Integer.valueOf(txtCAge.getText().toString().length()==0 ? "88" : txtCAge.getText().toString()) > 88)
           {
             Connection.MessageBox(IPDScreening.this, "Value should be between 00 and 88(Child age in months).");
             txtCAge.requestFocus(); 
             return;	
           }
         
         else if(!rdoCSex1.isChecked() & !rdoCSex2.isChecked() & secCSex.isShown())
           {
              Connection.MessageBox(IPDScreening.this, "Select anyone options from (Child sex).");
              rdoCSex1.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtpHosAdDate.getText().toString());
         if(DV.length()!=0 & secHosAdDate.isShown())
           {
             Connection.MessageBox(IPDScreening.this, DV);
             dtpHosAdDate.requestFocus(); 
             return;	
           }
         else if(txtHosAdTime.getText().length()==0 & secHosAdTime.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: Hospital admission time.");
             txtHosAdTime.requestFocus(); 
             return;	
           }
         else if(txtHosRegis1.getText().toString().length()==0 & secHosRegis1.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 1. Hospital registration number1.");
             txtHosRegis1.requestFocus(); 
             return;	
           }
         else if(txtHosBed1.getText().toString().length()==0 & secHosBed1.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 2. Hospital bed number1.");
             txtHosBed1.requestFocus(); 
             return;	
           }
         else if(txtHosWard1.getText().toString().length()==0 & secHosWard1.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 3. Hospital ward number1.");
             txtHosWard1.requestFocus(); 
             return;	
           }
         else if(txtHosRegis2.getText().toString().length()==0 & secHosRegis2.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 1. Hospital registration number2.");
             txtHosRegis2.requestFocus(); 
             return;	
           }
         else if(txtHosBed2.getText().toString().length()==0 & secHosBed2.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 2. Hospital bed number2.");
             txtHosBed2.requestFocus(); 
             return;	
           }
         else if(txtHosWard2.getText().toString().length()==0 & secHosWard2.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 3. Hospital ward number2.");
             txtHosWard2.requestFocus(); 
             return;	
           }
         else if(txtHosRegis3.getText().toString().length()==0 & secHosRegis3.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 1. Hospital registration number3.");
             txtHosRegis3.requestFocus(); 
             return;	
           }
         else if(txtHosBed3.getText().toString().length()==0 & secHosBed3.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 2. Hospital bed number3.");
             txtHosBed3.requestFocus(); 
             return;	
           }
         else if(txtHosWard3.getText().toString().length()==0 & secHosWard3.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 3. Hospital ward number3.");
             txtHosWard3.requestFocus(); 
             return;	
           }
         else if(txtProviDaig1.getText().toString().length()==0 & secProviDaig1.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 1. Provisional diagnosis.");
             txtProviDaig1.requestFocus(); 
             return;	
           }
         else if(txtProviDiag2.getText().toString().length()==0 & secProviDiag2.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 2. Provisional diagnosis.");
             txtProviDiag2.requestFocus(); 
             return;	
           }
         else if(txtProviDiag3.getText().toString().length()==0 & secProviDiag3.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 3. Provisional diagnosis.");
             txtProviDiag3.requestFocus(); 
             return;	
           }
         else if(txtProviDiag4.getText().toString().length()==0 & secProviDiag4.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 4. Provisional diagnosis.");
             txtProviDiag4.requestFocus(); 
             return;	
           }
         else if(txtProviDiag5.getText().toString().length()==0 & secProviDiag5.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 5. Provisional diagnosis.");
             txtProviDiag5.requestFocus(); 
             return;	
           }
         
         else if(!rdoAge5Yr1.isChecked() & !rdoAge5Yr2.isChecked() & secAge5Yr.isShown())
           {
              Connection.MessageBox(IPDScreening.this, "Select anyone options from (Age 5 Years or less 5).");
              rdoAge5Yr1.requestFocus();
              return;
           }
         
         else if(!rdoOccur31.isChecked() & !rdoOccur32.isChecked() & secOccur3.isShown())
           {
              Connection.MessageBox(IPDScreening.this, "Select anyone options from (Occurance 3 times or more).");
              rdoOccur31.requestFocus();
              return;
           }
         else if(txtDurDiarr.getText().toString().length()==0 & secDurDiarr.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: Duration of diarrhea.");
             txtDurDiarr.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtDurDiarr.getText().toString().length()==0 ? "00" : txtDurDiarr.getText().toString()) < 00 || Integer.valueOf(txtDurDiarr.getText().toString().length()==0 ? "88" : txtDurDiarr.getText().toString()) > 88)
           {
             Connection.MessageBox(IPDScreening.this, "Value should be between 00 and 88(Duration of diarrhea).");
             txtDurDiarr.requestFocus(); 
             return;	
           }
         
         else if(!rdoBldDiarr1.isChecked() & !rdoBldDiarr2.isChecked() & secBldDiarr.isShown())
           {
              Connection.MessageBox(IPDScreening.this, "Select anyone options from (Bloody diarrhea).");
              rdoBldDiarr1.requestFocus();
              return;
           }
         
         else if(!rdoEligiEnrol1.isChecked() & !rdoEligiEnrol2.isChecked() & secEligiEnrol.isShown())
           {
              Connection.MessageBox(IPDScreening.this, "Select anyone options from (Eligible for enrollment(Eligible if: 1. ≤5 years of age(Q14)=YES 2.Occurance of ≥3 watery or looser than normal stools within last 14 days period(Q15) =YES 3.Bloody diarrhea(Q28)=NO ).");
              rdoEligiEnrol1.requestFocus();
              return;
           }
         
         else if(!rdoConsent1.isChecked() & !rdoConsent2.isChecked() & secConsent.isShown())
           {
              Connection.MessageBox(IPDScreening.this, "Select anyone options from (Consent given).");
              rdoConsent1.requestFocus();
              return;
           }
         else if(txtStudyID.getText().toString().length()==0 & secStudyID.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: Study ID.");
             txtStudyID.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtStudyID.getText().toString().length()==0 ? "1" : txtStudyID.getText().toString()) < 1 || Integer.valueOf(txtStudyID.getText().toString().length()==0 ? "88888888" : txtStudyID.getText().toString()) > 88888888)
           {
             Connection.MessageBox(IPDScreening.this, "Value should be between 1 and 88888888(Study ID).");
             txtStudyID.requestFocus(); 
             return;	
           }
         else if(txtMFName.getText().toString().length()==0 & secMFName.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: Mother or father name.");
             txtMFName.requestFocus(); 
             return;	
           }
         else if(txtContact1.getText().toString().length()==0 & secContact1.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 1. Contact No 1.");
             txtContact1.requestFocus(); 
             return;	
           }
         
         else if(!rdocont1Veri1.isChecked() & !rdocont1Veri2.isChecked() & seccont1Veri.isShown())
           {
              Connection.MessageBox(IPDScreening.this, "Select anyone options from (2. Contact No 1 verified).");
              rdocont1Veri1.requestFocus();
              return;
           }
         else if(txtcont1Rel.getText().toString().length()==0 & seccont1Rel.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 3. Contact No 1 relationship with patient.");
             txtcont1Rel.requestFocus(); 
             return;	
           }
         else if(txtContact2.getText().toString().length()==0 & secContact2.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 1. Contact No 2.");
             txtContact2.requestFocus(); 
             return;	
           }
         
         else if(!rdoCont2Veri1.isChecked() & !rdoCont2Veri2.isChecked() & secCont2Veri.isShown())
           {
              Connection.MessageBox(IPDScreening.this, "Select anyone options from (2. Contact No 2 verified).");
              rdoCont2Veri1.requestFocus();
              return;
           }
         else if(txtCont2Rel.getText().toString().length()==0 & secCont2Rel.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 3. Contact No 2 relationship with Patient.");
             txtCont2Rel.requestFocus(); 
             return;	
           }
         else if(spnZila.getSelectedItemPosition()==0  & secZila.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 1. Zila.");
             spnZila.requestFocus(); 
             return;	
           }
         else if(spnUpazila.getSelectedItemPosition()==0  & secUpazila.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 2. Upazila.");
             spnUpazila.requestFocus(); 
             return;	
           }
         else if(spnUnions.getSelectedItemPosition()==0  & secUnions.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 3. Union or Ward.");
             spnUnions.requestFocus(); 
             return;	
           }
         else if(spnVillage.getSelectedItemPosition()==0  & secVillage.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 4. Village or Mahalla.");
             spnVillage.requestFocus(); 
             return;	
           }
         else if(txtLocation.getText().toString().length()==0 & secLocation.isShown())
           {
             Connection.MessageBox(IPDScreening.this, "Required field: 5. Location.");
             txtLocation.requestFocus(); 
             return;	
           }
         
         else if(!rdoStudyArea1.isChecked() & !rdoStudyArea2.isChecked() & secStudyArea.isShown())
           {
              Connection.MessageBox(IPDScreening.this, "Select anyone options from (Study area).");
              rdoStudyArea1.requestFocus();
              return;
           }
         
         else if(!rdoSpeColAdv1.isChecked() & !rdoSpeColAdv2.isChecked() & secSpeColAdv.isShown())
           {
              Connection.MessageBox(IPDScreening.this, "Select anyone options from (Specimen collection advised).");
              rdoSpeColAdv1.requestFocus();
              return;
           }
 
         String SQL = "";
         RadioButton rb;

         IPDScreening_DataModel objSave = new IPDScreening_DataModel();
         objSave.setPreEnrollmentID(Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0?"0":txtPreEnrollmentID.getText().toString()));
         String[] d_rdogrphasDiarr = new String[] {"1","2"};
         objSave.sethasDiarr(0);
         for (int i = 0; i < rdogrphasDiarr.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrphasDiarr.getChildAt(i);
             if (rb.isChecked()) objSave.sethasDiarr(Integer.valueOf(d_rdogrphasDiarr[i]));
         }

         objSave.setIBDID(Integer.valueOf(txtIBDID.getText().toString().length()==0?"0":txtIBDID.getText().toString()));
         objSave.setCName(txtCName.getText().toString());
         objSave.setCDOB(dtpCDOB.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpCDOB.getText().toString()) : dtpCDOB.getText().toString());
         objSave.setCAge(Integer.valueOf(txtCAge.getText().toString().length()==0?"0":txtCAge.getText().toString()));
         String[] d_rdogrpCSex = new String[] {"1","2"};
         objSave.setCSex(0);
         for (int i = 0; i < rdogrpCSex.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpCSex.getChildAt(i);
             if (rb.isChecked()) objSave.setCSex(Integer.valueOf(d_rdogrpCSex[i]));
         }

         objSave.setHosAdDate(dtpHosAdDate.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpHosAdDate.getText().toString()) : dtpHosAdDate.getText().toString());
         objSave.setHosAdTime(txtHosAdTime.getText().toString());
         objSave.setHosRegis1(txtHosRegis1.getText().toString());
         objSave.setHosBed1(txtHosBed1.getText().toString());
         objSave.setHosWard1(txtHosWard1.getText().toString());
         objSave.setHosRegis2(txtHosRegis2.getText().toString());
         objSave.setHosBed2(txtHosBed2.getText().toString());
         objSave.setHosWard2(txtHosWard2.getText().toString());
         objSave.setHosRegis3(txtHosRegis3.getText().toString());
         objSave.setHosBed3(txtHosBed3.getText().toString());
         objSave.setHosWard3(txtHosWard3.getText().toString());
         objSave.setProviDaig1(txtProviDaig1.getText().toString());
         objSave.setProviDiag2(txtProviDiag2.getText().toString());
         objSave.setProviDiag3(txtProviDiag3.getText().toString());
         objSave.setProviDiag4(txtProviDiag4.getText().toString());
         objSave.setProviDiag5(txtProviDiag5.getText().toString());
         String[] d_rdogrpAge5Yr = new String[] {"1","2"};
         objSave.setAge5Yr(0);
         for (int i = 0; i < rdogrpAge5Yr.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpAge5Yr.getChildAt(i);
             if (rb.isChecked()) objSave.setAge5Yr(Integer.valueOf(d_rdogrpAge5Yr[i]));
         }

         String[] d_rdogrpOccur3 = new String[] {"1","2"};
         objSave.setOccur3(0);
         for (int i = 0; i < rdogrpOccur3.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpOccur3.getChildAt(i);
             if (rb.isChecked()) objSave.setOccur3(Integer.valueOf(d_rdogrpOccur3[i]));
         }

         objSave.setDurDiarr(Integer.valueOf(txtDurDiarr.getText().toString().length()==0?"0":txtDurDiarr.getText().toString()));
         String[] d_rdogrpBldDiarr = new String[] {"1","2"};
         objSave.setBldDiarr(0);
         for (int i = 0; i < rdogrpBldDiarr.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpBldDiarr.getChildAt(i);
             if (rb.isChecked()) objSave.setBldDiarr(Integer.valueOf(d_rdogrpBldDiarr[i]));
         }

         String[] d_rdogrpEligiEnrol = new String[] {"1","2"};
         objSave.setEligiEnrol(0);
         for (int i = 0; i < rdogrpEligiEnrol.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpEligiEnrol.getChildAt(i);
             if (rb.isChecked()) objSave.setEligiEnrol(Integer.valueOf(d_rdogrpEligiEnrol[i]));
         }

         String[] d_rdogrpConsent = new String[] {"1","2"};
         objSave.setConsent(0);
         for (int i = 0; i < rdogrpConsent.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpConsent.getChildAt(i);
             if (rb.isChecked()) objSave.setConsent(Integer.valueOf(d_rdogrpConsent[i]));
         }

         objSave.setStudyID(Integer.valueOf(txtStudyID.getText().toString().length()==0?"0":txtStudyID.getText().toString()));
         objSave.setMFName(txtMFName.getText().toString());
         objSave.setContact1(txtContact1.getText().toString());
         String[] d_rdogrpcont1Veri = new String[] {"1","2"};
         objSave.setcont1Veri(0);
         for (int i = 0; i < rdogrpcont1Veri.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpcont1Veri.getChildAt(i);
             if (rb.isChecked()) objSave.setcont1Veri(Integer.valueOf(d_rdogrpcont1Veri[i]));
         }

         objSave.setcont1Rel(txtcont1Rel.getText().toString());
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

         String[] d_rdogrpSpeColAdv = new String[] {"1","2"};
         objSave.setSpeColAdv(0);
         for (int i = 0; i < rdogrpSpeColAdv.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpSpeColAdv.getChildAt(i);
             if (rb.isChecked()) objSave.setSpeColAdv(Integer.valueOf(d_rdogrpSpeColAdv[i]));
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

             Connection.MessageBox(IPDScreening.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(IPDScreening.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(IPDScreening.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String PreEnrollmentID)
     {
       try
        {
     
           RadioButton rb;
           IPDScreening_DataModel d = new IPDScreening_DataModel();
           String SQL = "Select * from "+ TableName +"  Where PreEnrollmentID='"+ PreEnrollmentID +"'";
           List<IPDScreening_DataModel> data = d.SelectAll(this, SQL);
           for(IPDScreening_DataModel item : data){
             txtPreEnrollmentID.setText(String.valueOf(item.getPreEnrollmentID()));
             String[] d_rdogrphasDiarr = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrphasDiarr.length; i++)
             {
                 if (String.valueOf(item.gethasDiarr()).equals(String.valueOf(d_rdogrphasDiarr[i])))
                 {
                     rb = (RadioButton)rdogrphasDiarr.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtIBDID.setText(String.valueOf(item.getIBDID()));
             txtCName.setText(item.getCName());
             dtpCDOB.setText(item.getCDOB().toString().length()==0 ? "" : Global.DateConvertDMY(item.getCDOB()));
             txtCAge.setText(String.valueOf(item.getCAge()));
             String[] d_rdogrpCSex = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpCSex.length; i++)
             {
                 if (String.valueOf(item.getCSex()).equals(String.valueOf(d_rdogrpCSex[i])))
                 {
                     rb = (RadioButton)rdogrpCSex.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtpHosAdDate.setText(item.getHosAdDate().toString().length()==0 ? "" : Global.DateConvertDMY(item.getHosAdDate()));
             txtHosAdTime.setText(item.getHosAdTime());
             txtHosRegis1.setText(item.getHosRegis1());
             txtHosBed1.setText(item.getHosBed1());
             txtHosWard1.setText(item.getHosWard1());
             txtHosRegis2.setText(item.getHosRegis2());
             txtHosBed2.setText(item.getHosBed2());
             txtHosWard2.setText(item.getHosWard2());
             txtHosRegis3.setText(item.getHosRegis3());
             txtHosBed3.setText(item.getHosBed3());
             txtHosWard3.setText(item.getHosWard3());
             txtProviDaig1.setText(item.getProviDaig1());
             txtProviDiag2.setText(item.getProviDiag2());
             txtProviDiag3.setText(item.getProviDiag3());
             txtProviDiag4.setText(item.getProviDiag4());
             txtProviDiag5.setText(item.getProviDiag5());
             String[] d_rdogrpAge5Yr = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpAge5Yr.length; i++)
             {
                 if (String.valueOf(item.getAge5Yr()).equals(String.valueOf(d_rdogrpAge5Yr[i])))
                 {
                     rb = (RadioButton)rdogrpAge5Yr.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpOccur3 = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpOccur3.length; i++)
             {
                 if (String.valueOf(item.getOccur3()).equals(String.valueOf(d_rdogrpOccur3[i])))
                 {
                     rb = (RadioButton)rdogrpOccur3.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtDurDiarr.setText(String.valueOf(item.getDurDiarr()));
             String[] d_rdogrpBldDiarr = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpBldDiarr.length; i++)
             {
                 if (String.valueOf(item.getBldDiarr()).equals(String.valueOf(d_rdogrpBldDiarr[i])))
                 {
                     rb = (RadioButton)rdogrpBldDiarr.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpEligiEnrol = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpEligiEnrol.length; i++)
             {
                 if (String.valueOf(item.getEligiEnrol()).equals(String.valueOf(d_rdogrpEligiEnrol[i])))
                 {
                     rb = (RadioButton)rdogrpEligiEnrol.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpConsent = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpConsent.length; i++)
             {
                 if (String.valueOf(item.getConsent()).equals(String.valueOf(d_rdogrpConsent[i])))
                 {
                     rb = (RadioButton)rdogrpConsent.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtStudyID.setText(String.valueOf(item.getStudyID()));
             txtMFName.setText(item.getMFName());
             txtContact1.setText(item.getContact1());
             String[] d_rdogrpcont1Veri = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpcont1Veri.length; i++)
             {
                 if (String.valueOf(item.getcont1Veri()).equals(String.valueOf(d_rdogrpcont1Veri[i])))
                 {
                     rb = (RadioButton)rdogrpcont1Veri.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtcont1Rel.setText(item.getcont1Rel());
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
             String[] d_rdogrpSpeColAdv = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpSpeColAdv.length; i++)
             {
                 if (String.valueOf(item.getSpeColAdv()).equals(String.valueOf(d_rdogrpSpeColAdv[i])))
                 {
                     rb = (RadioButton)rdogrpSpeColAdv.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(IPDScreening.this, e.getMessage());
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


              dtpDate = (EditText)findViewById(R.id.dtpCDOB);
             if (VariableID.equals("btnCDOB"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpCDOB);
              }
             else if (VariableID.equals("btnHosAdDate"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpHosAdDate);
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


              tpTime = (EditText)findViewById(R.id.txtHosAdTime);
             if (VariableID.equals("btnHosAdTime"))
              {
                  tpTime = (EditText)findViewById(R.id.txtHosAdTime);
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


     private String NewParticipantID(String UserId)
     {
         String PID = C.ReturnSingleValue("Select (ifnull(max(cast(PreEnrollmentID as numeric(10))),0)+1)MaxId from IPDScreening where DeviceID='"+ UserId +"'");
         return UserId + Global.Right("0000"+PID,5);
     }

     private String NewStudyID(String UserId)
     {
         //String PID = C.ReturnSingleValue("Select (ifnull(max(cast(StudyId as numeric(10))),0)+1)MaxId from Screening where UserId='"+ UserId +"'");
         String PID = C.ReturnSingleValue("Select (ifnull(max(cast(StudyID as numeric(10))),0)+1)MaxId from IPDScreening where substr(StudyID,1,3)='"+ UserId +"'");
         return UserId + Global.Right("0000"+PID,5);
     }
 }