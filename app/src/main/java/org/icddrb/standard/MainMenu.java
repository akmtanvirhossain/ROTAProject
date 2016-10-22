package org.icddrb.standard;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import Common.Connection;
import Common.Global;

public class MainMenu extends Activity {

    Button cmdDataUpload;
    Button cmdDataSync;

    static String USERID = "";
    Connection C;
    Global g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            //getLayoutInflater().inflate(R.layout.main_menu, frameLayout);
            setContentView(R.layout.main_menu);
            C = new Connection(this);
            g = Global.getInstance();

            USERID = g.getUserId();

            cmdDataUpload = (Button)findViewById(R.id.cmdDataUpload);
            cmdDataUpload.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent f1 = new Intent(getApplicationContext(), AndroidTask.class);
                    startActivity(f1);

                    /*//Upload file to server
                    FileUpload myTask = new FileUpload();
                    String[] params = new String[2];
                    params[0] = ProjectSetting.DatabaseName; //Source database name
                    params[1] = g.getDeviceNo()+"_"+ Global.CurrentDMY() +"_"+ ProjectSetting.DatabaseName; //Destination database name
                    myTask.execute(params);*/

                }
            });

            cmdDataSync = (Button)findViewById(R.id.cmdDataSync);
            cmdDataSync.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    //Check for Internet connectivity
                    if (Connection.haveNetworkConnection(MainMenu.this)) {
                    } else {
                        Connection.MessageBox(MainMenu.this,"Internet connection is not available for Data Sync.");
                        return;
                    }

                    AlertDialog.Builder adb = new AlertDialog.Builder(MainMenu.this);
                    adb.setTitle("Data Sync");
                    adb.setMessage("Do you want to Sync Data[Yes/No]?");
                    adb.setNegativeButton("No", null);
                    adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            C = new Connection(MainMenu.this);
                            final ProgressDialog progDailog = ProgressDialog.show(MainMenu.this, "", "Please Wait . . .", true);

                            new Thread() {
                                public void run() {
                                    try {

                                        List<String> tableList = new ArrayList<String>();
                                        tableList.add("Screening");
                                        tableList.add("idnHistory");
                                        tableList.add("medRecord");
                                        tableList.add("Admission");
                                        tableList.add("Folup");
                                        tableList.add("Medicine");
                                        tableList.add("OthInvestig");

                                        //Lab
                                        tableList.add("SampleAnalysis");
                                        tableList.add("LabResult");

                                        C.DataSync_UploadDownload(tableList, USERID);

                                        /*String[] ServerVal  = Connection.split(C.ReturnResult("ReturnSingleValue","sp_ServerCheck '"+ USERID +"'"),',');
                                        String DBUploadRequest = ServerVal[2].toString();

                                        if(DBUploadRequest.equals("1")) {
                                            C.DatabaseUpload(USERID);
                                            C.ExecuteCommandOnServer("Update UserList set DBRequest='2' where UserId='"+ USERID +"'");
                                        }*/

                                    } catch (Exception e) {

                                    }
                                    progDailog.dismiss();
                                }
                            }.start();

                        }});
                    adb.show();
                }
            });

            Button cmdExit = (Button)findViewById(R.id.cmdExit);
            cmdExit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AlertDialog.Builder adb = new AlertDialog.Builder(MainMenu.this);
                            adb.setTitle("Exit");
                            adb.setMessage("Do you want to exit from the system[Yes/No]?");
                            adb.setNegativeButton("No", null);
                            adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    finishAffinity();
                                    System.exit(0);
                                }});
                            adb.show();
                }
            });

        }
        catch (Exception ex)
        {
            Connection.MessageBox(MainMenu.this,ex.getMessage());
        }
    }
}
