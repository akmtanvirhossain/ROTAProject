
 package org.icddrb.rotaproject;


 //Android Manifest Code
 //<activity android:name=".Serumelectro" android:label="Serumelectro" />
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

 public class Serumelectro extends Activity {
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
         LinearLayout secSerumLabl;
         View lineSerumLabl;
         LinearLayout secPreEnrollmentID;
         View linePreEnrollmentID;
         TextView VlblPreEnrollmentID;
         EditText txtPreEnrollmentID;
         LinearLayout secSerElectro1;
         View lineSerElectro1;
         TextView VlblSerElectro1;
         RadioGroup rdogrpSerElectro1;
         
         RadioButton rdoSerElectro11;
         RadioButton rdoSerElectro12;
         LinearLayout secTDateSer1;
         View lineTDateSer1;
         TextView VlblTDateSer1;
         EditText dtpTDateSer1;
         LinearLayout secSodium1;
         View lineSodium1;
         TextView VlblSodium1;
         EditText txtSodium1;
         LinearLayout secSodium1Not;
         View lineSodium1Not;
         TextView VlblSodium1Not;
         CheckBox chkSodium1Not;
         LinearLayout secPotassium1;
         View linePotassium1;
         TextView VlblPotassium1;
         EditText txtPotassium1;
         LinearLayout secPotassium1Not;
         View linePotassium1Not;
         TextView VlblPotassium1Not;
         CheckBox chkPotassium1Not;
         LinearLayout secChloride1;
         View lineChloride1;
         TextView VlblChloride1;
         EditText txtChloride1;
         LinearLayout secCloride1Not;
         View lineCloride1Not;
         TextView VlblCloride1Not;
         CheckBox chkCloride1Not;
         LinearLayout secSerElectro2;
         View lineSerElectro2;
         TextView VlblSerElectro2;
         RadioGroup rdogrpSerElectro2;
         
         RadioButton rdoSerElectro21;
         RadioButton rdoSerElectro22;
         LinearLayout secTDateSer2;
         View lineTDateSer2;
         TextView VlblTDateSer2;
         EditText dtpTDateSer2;
         LinearLayout secSodium2;
         View lineSodium2;
         TextView VlblSodium2;
         EditText txtSodium2;
         LinearLayout secSodium2Not;
         View lineSodium2Not;
         TextView VlblSodium2Not;
         CheckBox chkSodium2Not;
         LinearLayout secPotassium2;
         View linePotassium2;
         TextView VlblPotassium2;
         EditText txtPotassium2;
         LinearLayout secPotassium2Not;
         View linePotassium2Not;
         TextView VlblPotassium2Not;
         CheckBox chkPotassium2Not;
         LinearLayout secChloride2;
         View lineChloride2;
         TextView VlblChloride2;
         EditText txtChloride2;
         LinearLayout secChloride2Not;
         View lineChloride2Not;
         TextView VlblChloride2Not;
         CheckBox chkChloride2Not;

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
         setContentView(R.layout.serumelectro);
         getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

         C = new Connection(this);
         g = Global.getInstance();

         STARTTIME = g.CurrentTime24();
         DEVICEID  = sp.getValue(this, "deviceid");
         ENTRYUSER = sp.getValue(this, "userid");

         IDbundle = getIntent().getExtras();
         PREENROLLMENTID = IDbundle.getString("PreEnrollmentID");

         TableName = "Serumelectro";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Serumelectro.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});


         secSerumLabl=(LinearLayout)findViewById(R.id.secSerumLabl);
         lineSerumLabl=(View)findViewById(R.id.lineSerumLabl);
         secPreEnrollmentID=(LinearLayout)findViewById(R.id.secPreEnrollmentID);
         linePreEnrollmentID=(View)findViewById(R.id.linePreEnrollmentID);
         VlblPreEnrollmentID=(TextView) findViewById(R.id.VlblPreEnrollmentID);
         txtPreEnrollmentID=(EditText) findViewById(R.id.txtPreEnrollmentID);
         txtPreEnrollmentID.setText(PREENROLLMENTID);
         secSerElectro1=(LinearLayout)findViewById(R.id.secSerElectro1);
         lineSerElectro1=(View)findViewById(R.id.lineSerElectro1);
         VlblSerElectro1 = (TextView) findViewById(R.id.VlblSerElectro1);
         rdogrpSerElectro1 = (RadioGroup) findViewById(R.id.rdogrpSerElectro1);
         
         rdoSerElectro11 = (RadioButton) findViewById(R.id.rdoSerElectro11);
         rdoSerElectro12 = (RadioButton) findViewById(R.id.rdoSerElectro12);
         rdogrpSerElectro1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpSerElectro1 = new String[] {"1","2"};
             for (int i = 0; i < rdogrpSerElectro1.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpSerElectro1.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpSerElectro1[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secTDateSer1.setVisibility(View.GONE);
                    lineTDateSer1.setVisibility(View.GONE);
                    dtpTDateSer1.setText("");
                    secSodium1.setVisibility(View.GONE);
                    lineSodium1.setVisibility(View.GONE);
                    txtSodium1.setText("");
                    secSodium1Not.setVisibility(View.GONE);
                    lineSodium1Not.setVisibility(View.GONE);
                    chkSodium1Not.setChecked(false);
                    secPotassium1.setVisibility(View.GONE);
                    linePotassium1.setVisibility(View.GONE);
                    txtPotassium1.setText("");
                    secPotassium1Not.setVisibility(View.GONE);
                    linePotassium1Not.setVisibility(View.GONE);
                    chkPotassium1Not.setChecked(false);
                    secChloride1.setVisibility(View.GONE);
                    lineChloride1.setVisibility(View.GONE);
                    txtChloride1.setText("");
                    secCloride1Not.setVisibility(View.GONE);
                    lineCloride1Not.setVisibility(View.GONE);
                    chkCloride1Not.setChecked(false);
             }
             else
             {
                    secTDateSer1.setVisibility(View.VISIBLE);
                    lineTDateSer1.setVisibility(View.VISIBLE);
                    secSodium1.setVisibility(View.VISIBLE);
                    lineSodium1.setVisibility(View.VISIBLE);
                    secSodium1Not.setVisibility(View.VISIBLE);
                    lineSodium1Not.setVisibility(View.VISIBLE);
                    secPotassium1.setVisibility(View.VISIBLE);
                    linePotassium1.setVisibility(View.VISIBLE);
                    secPotassium1Not.setVisibility(View.VISIBLE);
                    linePotassium1Not.setVisibility(View.VISIBLE);
                    secChloride1.setVisibility(View.VISIBLE);
                    lineChloride1.setVisibility(View.VISIBLE);
                    secCloride1Not.setVisibility(View.VISIBLE);
                    lineCloride1Not.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secTDateSer1=(LinearLayout)findViewById(R.id.secTDateSer1);
         lineTDateSer1=(View)findViewById(R.id.lineTDateSer1);
         VlblTDateSer1=(TextView) findViewById(R.id.VlblTDateSer1);
         dtpTDateSer1=(EditText) findViewById(R.id.dtpTDateSer1);
         secSodium1=(LinearLayout)findViewById(R.id.secSodium1);
         lineSodium1=(View)findViewById(R.id.lineSodium1);
         VlblSodium1=(TextView) findViewById(R.id.VlblSodium1);
         txtSodium1=(EditText) findViewById(R.id.txtSodium1);
         secSodium1Not=(LinearLayout)findViewById(R.id.secSodium1Not);
         lineSodium1Not=(View)findViewById(R.id.lineSodium1Not);
         VlblSodium1Not=(TextView) findViewById(R.id.VlblSodium1Not);
         chkSodium1Not=(CheckBox) findViewById(R.id.chkSodium1Not);
         secPotassium1=(LinearLayout)findViewById(R.id.secPotassium1);
         linePotassium1=(View)findViewById(R.id.linePotassium1);
         VlblPotassium1=(TextView) findViewById(R.id.VlblPotassium1);
         txtPotassium1=(EditText) findViewById(R.id.txtPotassium1);
         secPotassium1Not=(LinearLayout)findViewById(R.id.secPotassium1Not);
         linePotassium1Not=(View)findViewById(R.id.linePotassium1Not);
         VlblPotassium1Not=(TextView) findViewById(R.id.VlblPotassium1Not);
         chkPotassium1Not=(CheckBox) findViewById(R.id.chkPotassium1Not);
         secChloride1=(LinearLayout)findViewById(R.id.secChloride1);
         lineChloride1=(View)findViewById(R.id.lineChloride1);
         VlblChloride1=(TextView) findViewById(R.id.VlblChloride1);
         txtChloride1=(EditText) findViewById(R.id.txtChloride1);
         secCloride1Not=(LinearLayout)findViewById(R.id.secCloride1Not);
         lineCloride1Not=(View)findViewById(R.id.lineCloride1Not);
         VlblCloride1Not=(TextView) findViewById(R.id.VlblCloride1Not);
         chkCloride1Not=(CheckBox) findViewById(R.id.chkCloride1Not);
         secSerElectro2=(LinearLayout)findViewById(R.id.secSerElectro2);
         lineSerElectro2=(View)findViewById(R.id.lineSerElectro2);
         VlblSerElectro2 = (TextView) findViewById(R.id.VlblSerElectro2);
         rdogrpSerElectro2 = (RadioGroup) findViewById(R.id.rdogrpSerElectro2);
         
         rdoSerElectro21 = (RadioButton) findViewById(R.id.rdoSerElectro21);
         rdoSerElectro22 = (RadioButton) findViewById(R.id.rdoSerElectro22);
         rdogrpSerElectro2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpSerElectro2 = new String[] {"1","2"};
             for (int i = 0; i < rdogrpSerElectro2.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpSerElectro2.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpSerElectro2[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secTDateSer2.setVisibility(View.GONE);
                    lineTDateSer2.setVisibility(View.GONE);
                    dtpTDateSer2.setText("");
                    secSodium2.setVisibility(View.GONE);
                    lineSodium2.setVisibility(View.GONE);
                    txtSodium2.setText("");
                    secSodium2Not.setVisibility(View.GONE);
                    lineSodium2Not.setVisibility(View.GONE);
                    chkSodium2Not.setChecked(false);
                    secPotassium2.setVisibility(View.GONE);
                    linePotassium2.setVisibility(View.GONE);
                    txtPotassium2.setText("");
                    secPotassium2Not.setVisibility(View.GONE);
                    linePotassium2Not.setVisibility(View.GONE);
                    chkPotassium2Not.setChecked(false);
                    secChloride2.setVisibility(View.GONE);
                    lineChloride2.setVisibility(View.GONE);
                    txtChloride2.setText("");
                    secChloride2Not.setVisibility(View.GONE);
                    lineChloride2Not.setVisibility(View.GONE);
                    chkChloride2Not.setChecked(false);
             }
             else
             {
                    secTDateSer2.setVisibility(View.VISIBLE);
                    lineTDateSer2.setVisibility(View.VISIBLE);
                    secSodium2.setVisibility(View.VISIBLE);
                    lineSodium2.setVisibility(View.VISIBLE);
                    secSodium2Not.setVisibility(View.VISIBLE);
                    lineSodium2Not.setVisibility(View.VISIBLE);
                    secPotassium2.setVisibility(View.VISIBLE);
                    linePotassium2.setVisibility(View.VISIBLE);
                    secPotassium2Not.setVisibility(View.VISIBLE);
                    linePotassium2Not.setVisibility(View.VISIBLE);
                    secChloride2.setVisibility(View.VISIBLE);
                    lineChloride2.setVisibility(View.VISIBLE);
                    secChloride2Not.setVisibility(View.VISIBLE);
                    lineChloride2Not.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secTDateSer2=(LinearLayout)findViewById(R.id.secTDateSer2);
         lineTDateSer2=(View)findViewById(R.id.lineTDateSer2);
         VlblTDateSer2=(TextView) findViewById(R.id.VlblTDateSer2);
         dtpTDateSer2=(EditText) findViewById(R.id.dtpTDateSer2);
         secSodium2=(LinearLayout)findViewById(R.id.secSodium2);
         lineSodium2=(View)findViewById(R.id.lineSodium2);
         VlblSodium2=(TextView) findViewById(R.id.VlblSodium2);
         txtSodium2=(EditText) findViewById(R.id.txtSodium2);
         secSodium2Not=(LinearLayout)findViewById(R.id.secSodium2Not);
         lineSodium2Not=(View)findViewById(R.id.lineSodium2Not);
         VlblSodium2Not=(TextView) findViewById(R.id.VlblSodium2Not);
         chkSodium2Not=(CheckBox) findViewById(R.id.chkSodium2Not);
         secPotassium2=(LinearLayout)findViewById(R.id.secPotassium2);
         linePotassium2=(View)findViewById(R.id.linePotassium2);
         VlblPotassium2=(TextView) findViewById(R.id.VlblPotassium2);
         txtPotassium2=(EditText) findViewById(R.id.txtPotassium2);
         secPotassium2Not=(LinearLayout)findViewById(R.id.secPotassium2Not);
         linePotassium2Not=(View)findViewById(R.id.linePotassium2Not);
         VlblPotassium2Not=(TextView) findViewById(R.id.VlblPotassium2Not);
         chkPotassium2Not=(CheckBox) findViewById(R.id.chkPotassium2Not);
         secChloride2=(LinearLayout)findViewById(R.id.secChloride2);
         lineChloride2=(View)findViewById(R.id.lineChloride2);
         VlblChloride2=(TextView) findViewById(R.id.VlblChloride2);
         txtChloride2=(EditText) findViewById(R.id.txtChloride2);
         secChloride2Not=(LinearLayout)findViewById(R.id.secChloride2Not);
         lineChloride2Not=(View)findViewById(R.id.lineChloride2Not);
         VlblChloride2Not=(TextView) findViewById(R.id.VlblChloride2Not);
         chkChloride2Not=(CheckBox) findViewById(R.id.chkChloride2Not);


         dtpTDateSer1.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpTDateSer1.getRight() - dtpTDateSer1.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnTDateSer1"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpTDateSer2.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpTDateSer2.getRight() - dtpTDateSer2.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnTDateSer2"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });



         //Hide all skip variables
         secTDateSer1.setVisibility(View.GONE);
         lineTDateSer1.setVisibility(View.GONE);
         secSodium1.setVisibility(View.GONE);
         lineSodium1.setVisibility(View.GONE);
         secSodium1Not.setVisibility(View.GONE);
         lineSodium1Not.setVisibility(View.GONE);
         secPotassium1.setVisibility(View.GONE);
         linePotassium1.setVisibility(View.GONE);
         secPotassium1Not.setVisibility(View.GONE);
         linePotassium1Not.setVisibility(View.GONE);
         secChloride1.setVisibility(View.GONE);
         lineChloride1.setVisibility(View.GONE);
         secCloride1Not.setVisibility(View.GONE);
         lineCloride1Not.setVisibility(View.GONE);
         secTDateSer2.setVisibility(View.GONE);
         lineTDateSer2.setVisibility(View.GONE);
         secSodium2.setVisibility(View.GONE);
         lineSodium2.setVisibility(View.GONE);
         secSodium2Not.setVisibility(View.GONE);
         lineSodium2Not.setVisibility(View.GONE);
         secPotassium2.setVisibility(View.GONE);
         linePotassium2.setVisibility(View.GONE);
         secPotassium2Not.setVisibility(View.GONE);
         linePotassium2Not.setVisibility(View.GONE);
         secChloride2.setVisibility(View.GONE);
         lineChloride2.setVisibility(View.GONE);
         secChloride2Not.setVisibility(View.GONE);
         lineChloride2Not.setVisibility(View.GONE);


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Serumelectro.this, e.getMessage());
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
             Connection.MessageBox(Serumelectro.this, "Required field: PreEnrollment ID.");
             txtPreEnrollmentID.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0 ? "0000001" : txtPreEnrollmentID.getText().toString()) < 0000001 || Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0 ? "88888888" : txtPreEnrollmentID.getText().toString()) > 88888888)
           {
             Connection.MessageBox(Serumelectro.this, "Value should be between 0000001 and 88888888(PreEnrollment ID).");
             txtPreEnrollmentID.requestFocus(); 
             return;	
           }
         
         else if(!rdoSerElectro11.isChecked() & !rdoSerElectro12.isChecked() & secSerElectro1.isShown())
           {
              Connection.MessageBox(Serumelectro.this, "Select anyone options from (Serum electrolyte information (first) available).");
              rdoSerElectro11.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtpTDateSer1.getText().toString());
         if(DV.length()!=0 & secTDateSer1.isShown())
           {
             Connection.MessageBox(Serumelectro.this, DV);
             dtpTDateSer1.requestFocus(); 
             return;	
           }
         else if(txtSodium1.getText().toString().length()==0 & secSodium1.isShown())
           {
             Connection.MessageBox(Serumelectro.this, "Required field: 2. Sodium.");
             txtSodium1.requestFocus(); 
             return;	
           }
         else if(Double.valueOf(txtSodium1.getText().toString().length()==0 ? "1" : txtSodium1.getText().toString()) < 1 || Double.valueOf(txtSodium1.getText().toString().length()==0 ? "888.88" : txtSodium1.getText().toString()) > 888.88)
           {
             Connection.MessageBox(Serumelectro.this, "Value should be between 1 and 888.88(2. Sodium).");
             txtSodium1.requestFocus(); 
             return;	
           }
         else if(txtPotassium1.getText().toString().length()==0 & secPotassium1.isShown())
           {
             Connection.MessageBox(Serumelectro.this, "Required field: 3. Potassium.");
             txtPotassium1.requestFocus(); 
             return;	
           }
         else if(Double.valueOf(txtPotassium1.getText().toString().length()==0 ? "001.00" : txtPotassium1.getText().toString()) < 001.00 || Double.valueOf(txtPotassium1.getText().toString().length()==0 ? "888.88" : txtPotassium1.getText().toString()) > 888.88)
           {
             Connection.MessageBox(Serumelectro.this, "Value should be between 001.00 and 888.88(3. Potassium).");
             txtPotassium1.requestFocus(); 
             return;	
           }
         else if(txtChloride1.getText().toString().length()==0 & secChloride1.isShown())
           {
             Connection.MessageBox(Serumelectro.this, "Required field: 4. Chloride.");
             txtChloride1.requestFocus(); 
             return;	
           }
         else if(Double.valueOf(txtChloride1.getText().toString().length()==0 ? "001.00" : txtChloride1.getText().toString()) < 001.00 || Double.valueOf(txtChloride1.getText().toString().length()==0 ? "888.88" : txtChloride1.getText().toString()) > 888.88)
           {
             Connection.MessageBox(Serumelectro.this, "Value should be between 001.00 and 888.88(4. Chloride).");
             txtChloride1.requestFocus(); 
             return;	
           }
         
         else if(!rdoSerElectro21.isChecked() & !rdoSerElectro22.isChecked() & secSerElectro2.isShown())
           {
              Connection.MessageBox(Serumelectro.this, "Select anyone options from (Serum elecrolyte information (second) available).");
              rdoSerElectro21.requestFocus();
              return;
           }
         DV = Global.DateValidate(dtpTDateSer2.getText().toString());
         if(DV.length()!=0 & secTDateSer2.isShown())
           {
             Connection.MessageBox(Serumelectro.this, DV);
             dtpTDateSer2.requestFocus(); 
             return;	
           }
         else if(txtSodium2.getText().toString().length()==0 & secSodium2.isShown())
           {
             Connection.MessageBox(Serumelectro.this, "Required field: 2. Sodium.");
             txtSodium2.requestFocus(); 
             return;	
           }
         else if(Double.valueOf(txtSodium2.getText().toString().length()==0 ? "001.00" : txtSodium2.getText().toString()) < 001.00 || Double.valueOf(txtSodium2.getText().toString().length()==0 ? "888.88" : txtSodium2.getText().toString()) > 888.88)
           {
             Connection.MessageBox(Serumelectro.this, "Value should be between 001.00 and 888.88(2. Sodium).");
             txtSodium2.requestFocus(); 
             return;	
           }
         else if(txtPotassium2.getText().toString().length()==0 & secPotassium2.isShown())
           {
             Connection.MessageBox(Serumelectro.this, "Required field: 3. Potassium.");
             txtPotassium2.requestFocus(); 
             return;	
           }
         else if(Double.valueOf(txtPotassium2.getText().toString().length()==0 ? "01.00" : txtPotassium2.getText().toString()) < 01.00 || Double.valueOf(txtPotassium2.getText().toString().length()==0 ? "88.88" : txtPotassium2.getText().toString()) > 88.88)
           {
             Connection.MessageBox(Serumelectro.this, "Value should be between 01.00 and 88.88(3. Potassium).");
             txtPotassium2.requestFocus(); 
             return;	
           }
         else if(txtChloride2.getText().toString().length()==0 & secChloride2.isShown())
           {
             Connection.MessageBox(Serumelectro.this, "Required field: 4. Chloride.");
             txtChloride2.requestFocus(); 
             return;	
           }
         else if(Double.valueOf(txtChloride2.getText().toString().length()==0 ? "001.00" : txtChloride2.getText().toString()) < 001.00 || Double.valueOf(txtChloride2.getText().toString().length()==0 ? "888.88" : txtChloride2.getText().toString()) > 888.88)
           {
             Connection.MessageBox(Serumelectro.this, "Value should be between 001.00 and 888.88(4. Chloride).");
             txtChloride2.requestFocus(); 
             return;	
           }
 
         String SQL = "";
         RadioButton rb;

         Serumelectro_DataModel objSave = new Serumelectro_DataModel();
         objSave.setPreEnrollmentID(Integer.valueOf(txtPreEnrollmentID.getText().toString().length()==0?"0":txtPreEnrollmentID.getText().toString()));
         String[] d_rdogrpSerElectro1 = new String[] {"1","2"};
         objSave.setSerElectro1(0);
         for (int i = 0; i < rdogrpSerElectro1.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpSerElectro1.getChildAt(i);
             if (rb.isChecked()) objSave.setSerElectro1(Integer.valueOf(d_rdogrpSerElectro1[i]));
         }

         objSave.setTDateSer1(dtpTDateSer1.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpTDateSer1.getText().toString()) : dtpTDateSer1.getText().toString());
         objSave.setSodium1(Double.parseDouble(txtSodium1.getText().toString().length()==0?"0.0":txtSodium1.getText().toString()));
         objSave.setSodium1Not(Integer.valueOf(chkSodium1Not.isChecked()?"1":(secSodium1Not.isShown()?"2":"")));
         objSave.setPotassium1(Double.parseDouble(txtPotassium1.getText().toString().length()==0?"0.0":txtPotassium1.getText().toString()));
         objSave.setPotassium1Not(Integer.valueOf(chkPotassium1Not.isChecked()?"1":(secPotassium1Not.isShown()?"2":"")));
         objSave.setChloride1(Double.parseDouble(txtChloride1.getText().toString().length()==0?"0.0":txtChloride1.getText().toString()));
         objSave.setCloride1Not(Integer.valueOf(chkCloride1Not.isChecked()?"1":(secCloride1Not.isShown()?"2":"")));
         String[] d_rdogrpSerElectro2 = new String[] {"1","2"};
         objSave.setSerElectro2(0);
         for (int i = 0; i < rdogrpSerElectro2.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpSerElectro2.getChildAt(i);
             if (rb.isChecked()) objSave.setSerElectro2(Integer.valueOf(d_rdogrpSerElectro2[i]));
         }

         objSave.setTDateSer2(dtpTDateSer2.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpTDateSer2.getText().toString()) : dtpTDateSer2.getText().toString());
         objSave.setSodium2(Double.parseDouble(txtSodium2.getText().toString().length()==0?"0.0":txtSodium2.getText().toString()));
         objSave.setSodium2Not(Integer.valueOf(chkSodium2Not.isChecked()?"1":(secSodium2Not.isShown()?"2":"")));
         objSave.setPotassium2(Double.parseDouble(txtPotassium2.getText().toString().length()==0?"0.0":txtPotassium2.getText().toString()));
         objSave.setPotassium2Not(Integer.valueOf(chkPotassium2Not.isChecked()?"1":(secPotassium2Not.isShown()?"2":"")));
         objSave.setChloride2(Double.parseDouble(txtChloride2.getText().toString().length()==0?"0.0":txtChloride2.getText().toString()));
         objSave.setChloride2Not(Integer.valueOf(chkChloride2Not.isChecked()?"1":(secChloride2Not.isShown()?"2":"")));
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

             Connection.MessageBox(Serumelectro.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(Serumelectro.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Serumelectro.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String PreEnrollmentID)
     {
       try
        {
     
           RadioButton rb;
           Serumelectro_DataModel d = new Serumelectro_DataModel();
           String SQL = "Select * from "+ TableName +"  Where PreEnrollmentID='"+ PreEnrollmentID +"'";
           List<Serumelectro_DataModel> data = d.SelectAll(this, SQL);
           for(Serumelectro_DataModel item : data){
             txtPreEnrollmentID.setText(String.valueOf(item.getPreEnrollmentID()));
             String[] d_rdogrpSerElectro1 = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpSerElectro1.length; i++)
             {
                 if (String.valueOf(item.getSerElectro1()).equals(String.valueOf(d_rdogrpSerElectro1[i])))
                 {
                     rb = (RadioButton)rdogrpSerElectro1.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtpTDateSer1.setText(item.getTDateSer1().toString().length()==0 ? "" : Global.DateConvertDMY(item.getTDateSer1()));
             txtSodium1.setText(String.valueOf(item.getSodium1()));
             if(String.valueOf(item.getSodium1Not()).equals("1"))
             {
                chkSodium1Not.setChecked(true);
             }
             else if(String.valueOf(item.getSodium1Not()).equals("2"))
             {
                chkSodium1Not.setChecked(false);
             }
             txtPotassium1.setText(String.valueOf(item.getPotassium1()));
             if(String.valueOf(item.getPotassium1Not()).equals("1"))
             {
                chkPotassium1Not.setChecked(true);
             }
             else if(String.valueOf(item.getPotassium1Not()).equals("2"))
             {
                chkPotassium1Not.setChecked(false);
             }
             txtChloride1.setText(String.valueOf(item.getChloride1()));
             if(String.valueOf(item.getCloride1Not()).equals("1"))
             {
                chkCloride1Not.setChecked(true);
             }
             else if(String.valueOf(item.getCloride1Not()).equals("2"))
             {
                chkCloride1Not.setChecked(false);
             }
             String[] d_rdogrpSerElectro2 = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpSerElectro2.length; i++)
             {
                 if (String.valueOf(item.getSerElectro2()).equals(String.valueOf(d_rdogrpSerElectro2[i])))
                 {
                     rb = (RadioButton)rdogrpSerElectro2.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             dtpTDateSer2.setText(item.getTDateSer2().toString().length()==0 ? "" : Global.DateConvertDMY(item.getTDateSer2()));
             txtSodium2.setText(String.valueOf(item.getSodium2()));
             if(String.valueOf(item.getSodium2Not()).equals("1"))
             {
                chkSodium2Not.setChecked(true);
             }
             else if(String.valueOf(item.getSodium2Not()).equals("2"))
             {
                chkSodium2Not.setChecked(false);
             }
             txtPotassium2.setText(String.valueOf(item.getPotassium2()));
             if(String.valueOf(item.getPotassium2Not()).equals("1"))
             {
                chkPotassium2Not.setChecked(true);
             }
             else if(String.valueOf(item.getPotassium2Not()).equals("2"))
             {
                chkPotassium2Not.setChecked(false);
             }
             txtChloride2.setText(String.valueOf(item.getChloride2()));
             if(String.valueOf(item.getChloride2Not()).equals("1"))
             {
                chkChloride2Not.setChecked(true);
             }
             else if(String.valueOf(item.getChloride2Not()).equals("2"))
             {
                chkChloride2Not.setChecked(false);
             }
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Serumelectro.this, e.getMessage());
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


              dtpDate = (EditText)findViewById(R.id.dtpTDateSer1);
             if (VariableID.equals("btnTDateSer1"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpTDateSer1);
              }
             else if (VariableID.equals("btnTDateSer2"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpTDateSer2);
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