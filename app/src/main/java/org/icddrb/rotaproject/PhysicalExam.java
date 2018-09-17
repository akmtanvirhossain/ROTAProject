
 package org.icddrb.rotaproject;


 //Android Manifest Code
 //<activity android:name=".PhysicalExam" android:label="PhysicalExam" />
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

 public class PhysicalExam extends Activity {
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
         LinearLayout secPhyLabl;
         View linePhyLabl;
         LinearLayout secPreEnrollmentID;
         View linePreEnrollmentID;
         TextView VlblPreEnrollmentID;
         EditText txtPreEnrollmentID;
         LinearLayout secTempAdm;
         View lineTempAdm;
         TextView VlblTempAdm;
         EditText txtTempAdm;
         LinearLayout secTempEnrol;
         View lineTempEnrol;
         TextView VlblTempEnrol;
         EditText txtTempEnrol;
         LinearLayout secBodyWght;
         View lineBodyWght;
         TextView VlblBodyWght;
         RadioGroup rdogrpBodyWght;
         
         RadioButton rdoBodyWght1;
         RadioButton rdoBodyWght2;
         LinearLayout secWeight;
         View lineWeight;
         TextView VlblWeight;
         EditText txtWeight;
         LinearLayout secLethaAdm;
         View lineLethaAdm;
         TextView VlblLethaAdm;
         RadioGroup rdogrpLethaAdm;
         
         RadioButton rdoLethaAdm1;
         RadioButton rdoLethaAdm2;
         LinearLayout secLathaEn;
         View lineLathaEn;
         TextView VlblLathaEn;
         RadioGroup rdogrpLathaEn;
         
         RadioButton rdoLathaEn1;
         RadioButton rdoLathaEn2;
         LinearLayout secSunEyeAdm;
         View lineSunEyeAdm;
         TextView VlblSunEyeAdm;
         RadioGroup rdogrpSunEyeAdm;
         
         RadioButton rdoSunEyeAdm1;
         RadioButton rdoSunEyeAdm2;
         LinearLayout secSunEyeEn;
         View lineSunEyeEn;
         TextView VlblSunEyeEn;
         RadioGroup rdogrpSunEyeEn;
         
         RadioButton rdoSunEyeEn1;
         RadioButton rdoSunEyeEn2;
         LinearLayout secSkinPinAdm;
         View lineSkinPinAdm;
         TextView VlblSkinPinAdm;
         RadioGroup rdogrpSkinPinAdm;
         
         RadioButton rdoSkinPinAdm1;
         RadioButton rdoSkinPinAdm2;
         LinearLayout secSkinPoorEn;
         View lineSkinPoorEn;
         TextView VlblSkinPoorEn;
         RadioGroup rdogrpSkinPoorEn;
         
         RadioButton rdoSkinPoorEn1;
         RadioButton rdoSkinPoorEn2;
         LinearLayout secDrinkPoorAdm;
         View lineDrinkPoorAdm;
         TextView VlblDrinkPoorAdm;
         RadioGroup rdogrpDrinkPoorAdm;
         
         RadioButton rdoDrinkPoorAdm1;
         RadioButton rdoDrinkPoorAdm2;
         LinearLayout secDrinkPoorEn;
         View lineDrinkPoorEn;
         TextView VlblDrinkPoorEn;
         RadioGroup rdogrpDrinkPoorEn;
         
         RadioButton rdoDrinkPoorEn1;
         RadioButton rdoDrinkPoorEn2;
         LinearLayout secThitstAdm;
         View lineThitstAdm;
         TextView VlblThitstAdm;
         RadioGroup rdogrpThitstAdm;
         
         RadioButton rdoThitstAdm1;
         RadioButton rdoThitstAdm2;
         LinearLayout secThitstEn;
         View lineThitstEn;
         TextView VlblThitstEn;
         RadioGroup rdogrpThitstEn;
         
         RadioButton rdoThitstEn1;
         RadioButton rdoThitstEn2;
         LinearLayout secIrritAdm;
         View lineIrritAdm;
         TextView VlblIrritAdm;
         RadioGroup rdogrpIrritAdm;
         
         RadioButton rdoIrritAdm1;
         RadioButton rdoIrritAdm2;
         LinearLayout secIrritEn;
         View lineIrritEn;
         TextView VlblIrritEn;
         RadioGroup rdogrpIrritEn;
         
         RadioButton rdoIrritEn1;
         RadioButton rdoIrritEn2;

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
         setContentView(R.layout.physicalexam);
         getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         PREENROLLMENTID = IDbundle.getString("PreEnrollmentID");

         TableName = "PhysicalExam";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(PhysicalExam.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});


         secPhyLabl=(LinearLayout)findViewById(R.id.secPhyLabl);
         linePhyLabl=(View)findViewById(R.id.linePhyLabl);
         secPreEnrollmentID=(LinearLayout)findViewById(R.id.secPreEnrollmentID);
         linePreEnrollmentID=(View)findViewById(R.id.linePreEnrollmentID);
         VlblPreEnrollmentID=(TextView) findViewById(R.id.VlblPreEnrollmentID);
         txtPreEnrollmentID=(EditText) findViewById(R.id.txtPreEnrollmentID);
         txtPreEnrollmentID.setText(PREENROLLMENTID);

         secTempAdm=(LinearLayout)findViewById(R.id.secTempAdm);
         lineTempAdm=(View)findViewById(R.id.lineTempAdm);
         VlblTempAdm=(TextView) findViewById(R.id.VlblTempAdm);
         txtTempAdm=(EditText) findViewById(R.id.txtTempAdm);
         secTempEnrol=(LinearLayout)findViewById(R.id.secTempEnrol);
         lineTempEnrol=(View)findViewById(R.id.lineTempEnrol);
         VlblTempEnrol=(TextView) findViewById(R.id.VlblTempEnrol);
         txtTempEnrol=(EditText) findViewById(R.id.txtTempEnrol);
         secBodyWght=(LinearLayout)findViewById(R.id.secBodyWght);
         lineBodyWght=(View)findViewById(R.id.lineBodyWght);
         VlblBodyWght = (TextView) findViewById(R.id.VlblBodyWght);
         rdogrpBodyWght = (RadioGroup) findViewById(R.id.rdogrpBodyWght);
         
         rdoBodyWght1 = (RadioButton) findViewById(R.id.rdoBodyWght1);
         rdoBodyWght2 = (RadioButton) findViewById(R.id.rdoBodyWght2);
         rdogrpBodyWght.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpBodyWght = new String[] {"1","2"};
             for (int i = 0; i < rdogrpBodyWght.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpBodyWght.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpBodyWght[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secWeight.setVisibility(View.GONE);
                    lineWeight.setVisibility(View.GONE);
                    txtWeight.setText("");
             }
             else
             {
                    secWeight.setVisibility(View.VISIBLE);
                    lineWeight.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secWeight=(LinearLayout)findViewById(R.id.secWeight);
         lineWeight=(View)findViewById(R.id.lineWeight);
         VlblWeight=(TextView) findViewById(R.id.VlblWeight);
         txtWeight=(EditText) findViewById(R.id.txtWeight);
         secLethaAdm=(LinearLayout)findViewById(R.id.secLethaAdm);
         lineLethaAdm=(View)findViewById(R.id.lineLethaAdm);
         VlblLethaAdm = (TextView) findViewById(R.id.VlblLethaAdm);
         rdogrpLethaAdm = (RadioGroup) findViewById(R.id.rdogrpLethaAdm);
         
         rdoLethaAdm1 = (RadioButton) findViewById(R.id.rdoLethaAdm1);
         rdoLethaAdm2 = (RadioButton) findViewById(R.id.rdoLethaAdm2);
         secLathaEn=(LinearLayout)findViewById(R.id.secLathaEn);
         lineLathaEn=(View)findViewById(R.id.lineLathaEn);
         VlblLathaEn = (TextView) findViewById(R.id.VlblLathaEn);
         rdogrpLathaEn = (RadioGroup) findViewById(R.id.rdogrpLathaEn);
         
         rdoLathaEn1 = (RadioButton) findViewById(R.id.rdoLathaEn1);
         rdoLathaEn2 = (RadioButton) findViewById(R.id.rdoLathaEn2);
         secSunEyeAdm=(LinearLayout)findViewById(R.id.secSunEyeAdm);
         lineSunEyeAdm=(View)findViewById(R.id.lineSunEyeAdm);
         VlblSunEyeAdm = (TextView) findViewById(R.id.VlblSunEyeAdm);
         rdogrpSunEyeAdm = (RadioGroup) findViewById(R.id.rdogrpSunEyeAdm);
         
         rdoSunEyeAdm1 = (RadioButton) findViewById(R.id.rdoSunEyeAdm1);
         rdoSunEyeAdm2 = (RadioButton) findViewById(R.id.rdoSunEyeAdm2);
         secSunEyeEn=(LinearLayout)findViewById(R.id.secSunEyeEn);
         lineSunEyeEn=(View)findViewById(R.id.lineSunEyeEn);
         VlblSunEyeEn = (TextView) findViewById(R.id.VlblSunEyeEn);
         rdogrpSunEyeEn = (RadioGroup) findViewById(R.id.rdogrpSunEyeEn);
         
         rdoSunEyeEn1 = (RadioButton) findViewById(R.id.rdoSunEyeEn1);
         rdoSunEyeEn2 = (RadioButton) findViewById(R.id.rdoSunEyeEn2);
         secSkinPinAdm=(LinearLayout)findViewById(R.id.secSkinPinAdm);
         lineSkinPinAdm=(View)findViewById(R.id.lineSkinPinAdm);
         VlblSkinPinAdm = (TextView) findViewById(R.id.VlblSkinPinAdm);
         rdogrpSkinPinAdm = (RadioGroup) findViewById(R.id.rdogrpSkinPinAdm);
         
         rdoSkinPinAdm1 = (RadioButton) findViewById(R.id.rdoSkinPinAdm1);
         rdoSkinPinAdm2 = (RadioButton) findViewById(R.id.rdoSkinPinAdm2);
         secSkinPoorEn=(LinearLayout)findViewById(R.id.secSkinPoorEn);
         lineSkinPoorEn=(View)findViewById(R.id.lineSkinPoorEn);
         VlblSkinPoorEn = (TextView) findViewById(R.id.VlblSkinPoorEn);
         rdogrpSkinPoorEn = (RadioGroup) findViewById(R.id.rdogrpSkinPoorEn);
         
         rdoSkinPoorEn1 = (RadioButton) findViewById(R.id.rdoSkinPoorEn1);
         rdoSkinPoorEn2 = (RadioButton) findViewById(R.id.rdoSkinPoorEn2);
         secDrinkPoorAdm=(LinearLayout)findViewById(R.id.secDrinkPoorAdm);
         lineDrinkPoorAdm=(View)findViewById(R.id.lineDrinkPoorAdm);
         VlblDrinkPoorAdm = (TextView) findViewById(R.id.VlblDrinkPoorAdm);
         rdogrpDrinkPoorAdm = (RadioGroup) findViewById(R.id.rdogrpDrinkPoorAdm);
         
         rdoDrinkPoorAdm1 = (RadioButton) findViewById(R.id.rdoDrinkPoorAdm1);
         rdoDrinkPoorAdm2 = (RadioButton) findViewById(R.id.rdoDrinkPoorAdm2);
         secDrinkPoorEn=(LinearLayout)findViewById(R.id.secDrinkPoorEn);
         lineDrinkPoorEn=(View)findViewById(R.id.lineDrinkPoorEn);
         VlblDrinkPoorEn = (TextView) findViewById(R.id.VlblDrinkPoorEn);
         rdogrpDrinkPoorEn = (RadioGroup) findViewById(R.id.rdogrpDrinkPoorEn);
         
         rdoDrinkPoorEn1 = (RadioButton) findViewById(R.id.rdoDrinkPoorEn1);
         rdoDrinkPoorEn2 = (RadioButton) findViewById(R.id.rdoDrinkPoorEn2);
         secThitstAdm=(LinearLayout)findViewById(R.id.secThitstAdm);
         lineThitstAdm=(View)findViewById(R.id.lineThitstAdm);
         VlblThitstAdm = (TextView) findViewById(R.id.VlblThitstAdm);
         rdogrpThitstAdm = (RadioGroup) findViewById(R.id.rdogrpThitstAdm);
         
         rdoThitstAdm1 = (RadioButton) findViewById(R.id.rdoThitstAdm1);
         rdoThitstAdm2 = (RadioButton) findViewById(R.id.rdoThitstAdm2);
         secThitstEn=(LinearLayout)findViewById(R.id.secThitstEn);
         lineThitstEn=(View)findViewById(R.id.lineThitstEn);
         VlblThitstEn = (TextView) findViewById(R.id.VlblThitstEn);
         rdogrpThitstEn = (RadioGroup) findViewById(R.id.rdogrpThitstEn);
         
         rdoThitstEn1 = (RadioButton) findViewById(R.id.rdoThitstEn1);
         rdoThitstEn2 = (RadioButton) findViewById(R.id.rdoThitstEn2);
         secIrritAdm=(LinearLayout)findViewById(R.id.secIrritAdm);
         lineIrritAdm=(View)findViewById(R.id.lineIrritAdm);
         VlblIrritAdm = (TextView) findViewById(R.id.VlblIrritAdm);
         rdogrpIrritAdm = (RadioGroup) findViewById(R.id.rdogrpIrritAdm);
         
         rdoIrritAdm1 = (RadioButton) findViewById(R.id.rdoIrritAdm1);
         rdoIrritAdm2 = (RadioButton) findViewById(R.id.rdoIrritAdm2);
         secIrritEn=(LinearLayout)findViewById(R.id.secIrritEn);
         lineIrritEn=(View)findViewById(R.id.lineIrritEn);
         VlblIrritEn = (TextView) findViewById(R.id.VlblIrritEn);
         rdogrpIrritEn = (RadioGroup) findViewById(R.id.rdogrpIrritEn);
         
         rdoIrritEn1 = (RadioButton) findViewById(R.id.rdoIrritEn1);
         rdoIrritEn2 = (RadioButton) findViewById(R.id.rdoIrritEn2);





         //Hide all skip variables
         secWeight.setVisibility(View.GONE);
         lineWeight.setVisibility(View.GONE);


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(PhysicalExam.this, e.getMessage());
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
             Connection.MessageBox(PhysicalExam.this, "Required field: PreEnrollment ID.");
             txtPreEnrollmentID.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0 ? "1" : txtPreEnrollmentID.getText().toString()) < 1 || Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0 ? "88888888" : txtPreEnrollmentID.getText().toString()) > 88888888)
           {
             Connection.MessageBox(PhysicalExam.this, "Value should be between 1 and 88888888(PreEnrollment ID).");
             txtPreEnrollmentID.requestFocus(); 
             return;	
           }
         else if(txtTempAdm.getText().toString().length()==0 & secTempAdm.isShown())
           {
             Connection.MessageBox(PhysicalExam.this, "Required field: 1. Body temperture during admission F°.");
             txtTempAdm.requestFocus(); 
             return;	
           }
         else if(txtTempEnrol.getText().toString().length()==0 & secTempEnrol.isShown())
           {
             Connection.MessageBox(PhysicalExam.this, "Required field: 2. Body temperture during enrollment F°.");
             txtTempEnrol.requestFocus(); 
             return;	
           }
         
         else if(!rdoBodyWght1.isChecked() & !rdoBodyWght2.isChecked() & secBodyWght.isShown())
           {
              Connection.MessageBox(PhysicalExam.this, "Select anyone options from (Body weight available).");
              rdoBodyWght1.requestFocus();
              return;
           }
         else if(txtWeight.getText().toString().length()==0 & secWeight.isShown())
           {
             Connection.MessageBox(PhysicalExam.this, "Required field: 1. Body weight kg.");
             txtWeight.requestFocus(); 
             return;	
           }
         else if(Double.valueOf(txtWeight.getText().toString().length()==0 ? "01.00" : txtWeight.getText().toString()) < 01.00 || Double.valueOf(txtWeight.getText().toString().length()==0 ? "88.88" : txtWeight.getText().toString()) > 88.88)
           {
             Connection.MessageBox(PhysicalExam.this, "Value should be between 01.00 and 88.88(1. Body weight kg).");
             txtWeight.requestFocus(); 
             return;	
           }
         
         else if(!rdoLethaAdm1.isChecked() & !rdoLethaAdm2.isChecked() & secLethaAdm.isShown())
           {
              Connection.MessageBox(PhysicalExam.this, "Select anyone options from (1. Lethargic during admission;a)Yes b)No).");
              rdoLethaAdm1.requestFocus();
              return;
           }
         
         else if(!rdoLathaEn1.isChecked() & !rdoLathaEn2.isChecked() & secLathaEn.isShown())
           {
              Connection.MessageBox(PhysicalExam.this, "Select anyone options from (2. Lathargic during enroll;a)Yes b)No).");
              rdoLathaEn1.requestFocus();
              return;
           }
         
         else if(!rdoSunEyeAdm1.isChecked() & !rdoSunEyeAdm2.isChecked() & secSunEyeAdm.isShown())
           {
              Connection.MessageBox(PhysicalExam.this, "Select anyone options from (1. Sunken eyes during admission;a)Yes b)No).");
              rdoSunEyeAdm1.requestFocus();
              return;
           }
         
         else if(!rdoSunEyeEn1.isChecked() & !rdoSunEyeEn2.isChecked() & secSunEyeEn.isShown())
           {
              Connection.MessageBox(PhysicalExam.this, "Select anyone options from (2. Sunken eyes during enrollment;a)Yes b)No).");
              rdoSunEyeEn1.requestFocus();
              return;
           }
         
         else if(!rdoSkinPinAdm1.isChecked() & !rdoSkinPinAdm2.isChecked() & secSkinPinAdm.isShown())
           {
              Connection.MessageBox(PhysicalExam.this, "Select anyone options from (1. Skin pinch during admission).");
              rdoSkinPinAdm1.requestFocus();
              return;
           }
         
         else if(!rdoSkinPoorEn1.isChecked() & !rdoSkinPoorEn2.isChecked() & secSkinPoorEn.isShown())
           {
              Connection.MessageBox(PhysicalExam.this, "Select anyone options from (2. Skin pinch during enroll).");
              rdoSkinPoorEn1.requestFocus();
              return;
           }
         
         else if(!rdoDrinkPoorAdm1.isChecked() & !rdoDrinkPoorAdm2.isChecked() & secDrinkPoorAdm.isShown())
           {
              Connection.MessageBox(PhysicalExam.this, "Select anyone options from (1. Not able to Drink /drinling poorly during admission).");
              rdoDrinkPoorAdm1.requestFocus();
              return;
           }
         
         else if(!rdoDrinkPoorEn1.isChecked() & !rdoDrinkPoorEn2.isChecked() & secDrinkPoorEn.isShown())
           {
              Connection.MessageBox(PhysicalExam.this, "Select anyone options from (2. Not able to Drink /drinling poorly during enrollment).");
              rdoDrinkPoorEn1.requestFocus();
              return;
           }
         
         else if(!rdoThitstAdm1.isChecked() & !rdoThitstAdm2.isChecked() & secThitstAdm.isShown())
           {
              Connection.MessageBox(PhysicalExam.this, "Select anyone options from (1. Thitst during admission).");
              rdoThitstAdm1.requestFocus();
              return;
           }
         
         else if(!rdoThitstEn1.isChecked() & !rdoThitstEn2.isChecked() & secThitstEn.isShown())
           {
              Connection.MessageBox(PhysicalExam.this, "Select anyone options from (2. Thitst during enroll).");
              rdoThitstEn1.requestFocus();
              return;
           }
         
         else if(!rdoIrritAdm1.isChecked() & !rdoIrritAdm2.isChecked() & secIrritAdm.isShown())
           {
              Connection.MessageBox(PhysicalExam.this, "Select anyone options from (1. Irritable during admission).");
              rdoIrritAdm1.requestFocus();
              return;
           }
         
         else if(!rdoIrritEn1.isChecked() & !rdoIrritEn2.isChecked() & secIrritEn.isShown())
           {
              Connection.MessageBox(PhysicalExam.this, "Select anyone options from (2. Irritable during enroll).");
              rdoIrritEn1.requestFocus();
              return;
           }
 
         String SQL = "";
         RadioButton rb;

         PhysicalExam_DataModel objSave = new PhysicalExam_DataModel();
         objSave.setPreEnrollmentID(Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0?"0":txtPreEnrollmentID.getText().toString()));
         objSave.setTempAdm(Double.parseDouble(txtTempAdm.getText().toString().length()==0?"000.0":txtTempAdm.getText().toString()));
         objSave.setTempEnrol(Double.parseDouble(txtTempEnrol.getText().toString().length()==0?"000.0":txtTempEnrol.getText().toString()));
         String[] d_rdogrpBodyWght = new String[] {"1","2"};
         objSave.setBodyWght(0);
         for (int i = 0; i < rdogrpBodyWght.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpBodyWght.getChildAt(i);
             if (rb.isChecked()) objSave.setBodyWght(Integer.valueOf(d_rdogrpBodyWght[i]));
         }

         objSave.setWeight(Double.parseDouble(txtWeight.getText().toString().length()==0?"0.0":txtWeight.getText().toString()));
         String[] d_rdogrpLethaAdm = new String[] {"1","2"};
         objSave.setLethaAdm(0);
         for (int i = 0; i < rdogrpLethaAdm.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpLethaAdm.getChildAt(i);
             if (rb.isChecked()) objSave.setLethaAdm(Integer.valueOf(d_rdogrpLethaAdm[i]));
         }

         String[] d_rdogrpLathaEn = new String[] {"1","2"};
         objSave.setLathaEn(0);
         for (int i = 0; i < rdogrpLathaEn.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpLathaEn.getChildAt(i);
             if (rb.isChecked()) objSave.setLathaEn(Integer.valueOf(d_rdogrpLathaEn[i]));
         }

         String[] d_rdogrpSunEyeAdm = new String[] {"1","2"};
         objSave.setSunEyeAdm(0);
         for (int i = 0; i < rdogrpSunEyeAdm.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpSunEyeAdm.getChildAt(i);
             if (rb.isChecked()) objSave.setSunEyeAdm(Integer.valueOf(d_rdogrpSunEyeAdm[i]));
         }

         String[] d_rdogrpSunEyeEn = new String[] {"1","2"};
         objSave.setSunEyeEn(0);
         for (int i = 0; i < rdogrpSunEyeEn.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpSunEyeEn.getChildAt(i);
             if (rb.isChecked()) objSave.setSunEyeEn(Integer.valueOf(d_rdogrpSunEyeEn[i]));
         }

         String[] d_rdogrpSkinPinAdm = new String[] {"1","2"};
         objSave.setSkinPinAdm(0);
         for (int i = 0; i < rdogrpSkinPinAdm.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpSkinPinAdm.getChildAt(i);
             if (rb.isChecked()) objSave.setSkinPinAdm(Integer.valueOf(d_rdogrpSkinPinAdm[i]));
         }

         String[] d_rdogrpSkinPoorEn = new String[] {"1","2"};
         objSave.setSkinPoorEn(0);
         for (int i = 0; i < rdogrpSkinPoorEn.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpSkinPoorEn.getChildAt(i);
             if (rb.isChecked()) objSave.setSkinPoorEn(Integer.valueOf(d_rdogrpSkinPoorEn[i]));
         }

         String[] d_rdogrpDrinkPoorAdm = new String[] {"1","2"};
         objSave.setDrinkPoorAdm(0);
         for (int i = 0; i < rdogrpDrinkPoorAdm.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDrinkPoorAdm.getChildAt(i);
             if (rb.isChecked()) objSave.setDrinkPoorAdm(Integer.valueOf(d_rdogrpDrinkPoorAdm[i]));
         }

         String[] d_rdogrpDrinkPoorEn = new String[] {"1","2"};
         objSave.setDrinkPoorEn(0);
         for (int i = 0; i < rdogrpDrinkPoorEn.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpDrinkPoorEn.getChildAt(i);
             if (rb.isChecked()) objSave.setDrinkPoorEn(Integer.valueOf(d_rdogrpDrinkPoorEn[i]));
         }

         String[] d_rdogrpThitstAdm = new String[] {"1","2"};
         objSave.setThitstAdm(0);
         for (int i = 0; i < rdogrpThitstAdm.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpThitstAdm.getChildAt(i);
             if (rb.isChecked()) objSave.setThitstAdm(Integer.valueOf(d_rdogrpThitstAdm[i]));
         }

         String[] d_rdogrpThitstEn = new String[] {"1","2"};
         objSave.setThitstEn(0);
         for (int i = 0; i < rdogrpThitstEn.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpThitstEn.getChildAt(i);
             if (rb.isChecked()) objSave.setThitstEn(Integer.valueOf(d_rdogrpThitstEn[i]));
         }

         String[] d_rdogrpIrritAdm = new String[] {"1","2"};
         objSave.setIrritAdm(0);
         for (int i = 0; i < rdogrpIrritAdm.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpIrritAdm.getChildAt(i);
             if (rb.isChecked()) objSave.setIrritAdm(Integer.valueOf(d_rdogrpIrritAdm[i]));
         }

         String[] d_rdogrpIrritEn = new String[] {"1","2"};
         objSave.setIrritEn(0);
         for (int i = 0; i < rdogrpIrritEn.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpIrritEn.getChildAt(i);
             if (rb.isChecked()) objSave.setIrritEn(Integer.valueOf(d_rdogrpIrritEn[i]));
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

             Connection.MessageBox(PhysicalExam.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(PhysicalExam.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(PhysicalExam.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String PreEnrollmentID)
     {
       try
        {
     
           RadioButton rb;
           PhysicalExam_DataModel d = new PhysicalExam_DataModel();
           String SQL = "Select * from "+ TableName +"  Where PreEnrollmentID='"+ PreEnrollmentID +"'";
           List<PhysicalExam_DataModel> data = d.SelectAll(this, SQL);
           for(PhysicalExam_DataModel item : data){
             txtPreEnrollmentID.setText(String.valueOf(item.getPreEnrollmentID()));
             txtTempAdm.setText(String.valueOf(item.getTempAdm()));
             txtTempEnrol.setText(String.valueOf(item.getTempEnrol()));
             String[] d_rdogrpBodyWght = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpBodyWght.length; i++)
             {
                 if (String.valueOf(item.getBodyWght()).equals(String.valueOf(d_rdogrpBodyWght[i])))
                 {
                     rb = (RadioButton)rdogrpBodyWght.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtWeight.setText(String.valueOf(item.getWeight()));
             String[] d_rdogrpLethaAdm = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpLethaAdm.length; i++)
             {
                 if (String.valueOf(item.getLethaAdm()).equals(String.valueOf(d_rdogrpLethaAdm[i])))
                 {
                     rb = (RadioButton)rdogrpLethaAdm.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpLathaEn = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpLathaEn.length; i++)
             {
                 if (String.valueOf(item.getLathaEn()).equals(String.valueOf(d_rdogrpLathaEn[i])))
                 {
                     rb = (RadioButton)rdogrpLathaEn.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpSunEyeAdm = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpSunEyeAdm.length; i++)
             {
                 if (String.valueOf(item.getSunEyeAdm()).equals(String.valueOf(d_rdogrpSunEyeAdm[i])))
                 {
                     rb = (RadioButton)rdogrpSunEyeAdm.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpSunEyeEn = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpSunEyeEn.length; i++)
             {
                 if (String.valueOf(item.getSunEyeEn()).equals(String.valueOf(d_rdogrpSunEyeEn[i])))
                 {
                     rb = (RadioButton)rdogrpSunEyeEn.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpSkinPinAdm = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpSkinPinAdm.length; i++)
             {
                 if (String.valueOf(item.getSkinPinAdm()).equals(String.valueOf(d_rdogrpSkinPinAdm[i])))
                 {
                     rb = (RadioButton)rdogrpSkinPinAdm.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpSkinPoorEn = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpSkinPoorEn.length; i++)
             {
                 if (String.valueOf(item.getSkinPoorEn()).equals(String.valueOf(d_rdogrpSkinPoorEn[i])))
                 {
                     rb = (RadioButton)rdogrpSkinPoorEn.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpDrinkPoorAdm = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpDrinkPoorAdm.length; i++)
             {
                 if (String.valueOf(item.getDrinkPoorAdm()).equals(String.valueOf(d_rdogrpDrinkPoorAdm[i])))
                 {
                     rb = (RadioButton)rdogrpDrinkPoorAdm.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpDrinkPoorEn = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpDrinkPoorEn.length; i++)
             {
                 if (String.valueOf(item.getDrinkPoorEn()).equals(String.valueOf(d_rdogrpDrinkPoorEn[i])))
                 {
                     rb = (RadioButton)rdogrpDrinkPoorEn.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpThitstAdm = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpThitstAdm.length; i++)
             {
                 if (String.valueOf(item.getThitstAdm()).equals(String.valueOf(d_rdogrpThitstAdm[i])))
                 {
                     rb = (RadioButton)rdogrpThitstAdm.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpThitstEn = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpThitstEn.length; i++)
             {
                 if (String.valueOf(item.getThitstEn()).equals(String.valueOf(d_rdogrpThitstEn[i])))
                 {
                     rb = (RadioButton)rdogrpThitstEn.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpIrritAdm = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpIrritAdm.length; i++)
             {
                 if (String.valueOf(item.getIrritAdm()).equals(String.valueOf(d_rdogrpIrritAdm[i])))
                 {
                     rb = (RadioButton)rdogrpIrritAdm.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             String[] d_rdogrpIrritEn = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpIrritEn.length; i++)
             {
                 if (String.valueOf(item.getIrritEn()).equals(String.valueOf(d_rdogrpIrritEn[i])))
                 {
                     rb = (RadioButton)rdogrpIrritEn.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(PhysicalExam.this, e.getMessage());
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


         // tpTime.setText(new StringBuilder().append(Global.Right("00"+hour,2)).append(":").append(Global.Right("00"+minute,2)));

    }
  };


 
 // turning off the GPS if its in on state. to avoid the battery drain.
 @Override
 protected void onDestroy() {
     // TODO Auto-generated method stub
     super.onDestroy();
 }
}