package org.icddrb.rotaproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import Common.Global;
import Utility.MySharedPreferences;

/**
 * Created by tasrul on 09-Apr-18.
 */

public class Menu_Assessment extends Activity {
    //Disabled Back/Home key
    //--------------------------------------------------------------------------------------------------
    @Override
    public boolean onKeyDown(int iKeyCode, KeyEvent event)
    {
        if(iKeyCode == KeyEvent.KEYCODE_BACK || iKeyCode == KeyEvent.KEYCODE_HOME)
        { return false; }
        else { return true;  }
    }

    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    static String PREENROLLMENTID = "";
    static String STUDYID = "";

    Bundle IDbundle;

    TextView txtStudyID,txtHospID,txtName,txtAge,txtAddress,txtRegDate,txtFatherMOther,lblFollowupMonth;
    TextView lblScheduleDate,lblVisitPossible,lblPrefferedVisit;
    Button cmdScreening,cmdClinical,cmdPhysical,cmdSerum,cmdVaccination,cmdDischarge,cmdFinalStatus;
    MySharedPreferences sp;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_assessment);

        DEVICEID    = sp.getValue(this, "deviceid");
        ENTRYUSER   = sp.getValue(this, "userid");

        IDbundle=getIntent().getExtras();
        PREENROLLMENTID = IDbundle.getString("PreEnrollmentID");
        STUDYID     = IDbundle.getString("studyid");

        final String NAME = IDbundle.getString("name");
        final String AGE     = IDbundle.getString("age");
        String ADDRESS = IDbundle.getString("address");
        String REGDATE = IDbundle.getString("regDate");


        findViewById(R.id.cmdBack).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        txtStudyID= (TextView) findViewById(R.id.txtStudyID);
        txtHospID= (TextView) findViewById(R.id.txtHospID);
        txtName= (TextView) findViewById(R.id.txtName);
        txtFatherMOther = (TextView)findViewById(R.id.txtFatherMOther);
        txtAge= (TextView) findViewById(R.id.txtAge);
        txtAddress= (TextView) findViewById(R.id.txtAddress);
        txtRegDate= (TextView) findViewById(R.id.txtRegDate);
        lblFollowupMonth= (TextView) findViewById(R.id.lblFollowupMonth);

        txtStudyID.setText(STUDYID);
        txtHospID.setText("");
        txtName.setText(NAME);
        txtFatherMOther.setText("");
        txtAge.setText("Age: " + AGE +" months");
        txtAddress.setText(ADDRESS);
        txtRegDate.setText(REGDATE);


        cmdScreening = (Button)findViewById(R.id.cmdScreening);
        cmdClinical = (Button)findViewById(R.id.cmdClinical);
        cmdPhysical = (Button)findViewById(R.id.cmdPhysical);
        cmdSerum = (Button)findViewById(R.id.cmdSerum);
        cmdVaccination = (Button)findViewById(R.id.cmdVaccination);
        cmdDischarge = (Button)findViewById(R.id.cmdDischarge);
        cmdFinalStatus = (Button)findViewById(R.id.cmdFinalStatus);

        cmdScreening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle IDbundle = new Bundle();
                IDbundle.putString("PreEnrollmentID", PREENROLLMENTID);
                IDbundle.putString("studyid", STUDYID);

                Intent intent = new Intent(getApplicationContext(), IPDScreening.class);
                intent.putExtras(IDbundle);
                startActivity(intent);
            }
        });

        cmdClinical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle IDbundle = new Bundle();
                IDbundle.putString("PreEnrollmentID", PREENROLLMENTID);
                IDbundle.putString("studyid", STUDYID);

                Intent intent = new Intent(getApplicationContext(), ClinicalInfo.class);
                intent.putExtras(IDbundle);
                startActivity(intent);
            }
        });

        cmdPhysical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle IDbundle = new Bundle();
                IDbundle.putString("PreEnrollmentID", PREENROLLMENTID);
                IDbundle.putString("studyid", STUDYID);

                Intent intent = new Intent(getApplicationContext(), PhysicalExam.class);
                intent.putExtras(IDbundle);
                startActivity(intent);
            }
        });

        cmdSerum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle IDbundle = new Bundle();
                IDbundle.putString("PreEnrollmentID", PREENROLLMENTID);
                IDbundle.putString("studyid", STUDYID);

                Intent intent = new Intent(getApplicationContext(), Serumelectro.class);
                intent.putExtras(IDbundle);
                startActivity(intent);
            }
        });

        cmdVaccination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle IDbundle = new Bundle();
                IDbundle.putString("PreEnrollmentID", PREENROLLMENTID);
                IDbundle.putString("studyid", STUDYID);

                Intent intent = new Intent(getApplicationContext(), Vaccination.class);
                intent.putExtras(IDbundle);
                startActivity(intent);
            }
        });

        cmdDischarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle IDbundle = new Bundle();
                IDbundle.putString("PreEnrollmentID", PREENROLLMENTID);
                IDbundle.putString("studyid", STUDYID);

                Intent intent = new Intent(getApplicationContext(), Discharge.class);
                intent.putExtras(IDbundle);
                startActivity(intent);
            }
        });

        cmdFinalStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Bundle IDbundle = new Bundle();
                IDbundle.putString("PreEnrollmentID", PREENROLLMENTID);
                IDbundle.putString("studyid", STUDYID);

                Intent intent = new Intent(getApplicationContext(), IPDScreening.class);
                intent.putExtras(IDbundle);
                startActivity(intent);*/
            }
        });

    }
}
