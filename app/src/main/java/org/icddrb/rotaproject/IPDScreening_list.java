package org.icddrb.rotaproject;
//Android Manifest Code
 //<activity android:name=".IPDScreening_list" android:label="IPDScreening: List" />
 import java.util.ArrayList;
 import java.util.List;
 import android.app.*;
 import android.app.AlertDialog;
 import android.content.Context;
 import android.content.DialogInterface;
 import android.content.Intent;
 import android.location.Location;
 import android.view.KeyEvent;
 import android.os.Bundle;
 import android.view.View;
 import android.view.MotionEvent;
 import android.view.ViewGroup;
 import android.view.LayoutInflater;
 import android.widget.LinearLayout;
 import android.widget.TextView;
 import android.widget.Button;
 import android.widget.ImageButton;
 import Common.*;
 import android.support.v7.widget.RecyclerView;
 import android.support.v7.app.AppCompatActivity;
 import android.content.res.TypedArray;
 import android.graphics.Canvas;
 import android.graphics.Rect;
 import android.graphics.drawable.Drawable;
 import android.support.v7.widget.LinearLayoutManager;
 import android.view.GestureDetector;
 import android.support.v7.widget.DefaultItemAnimator;

 public class IPDScreening_list extends AppCompatActivity {
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
    private int mDay;
    private int mMonth;
    private int mYear;
    static final int DATE_DIALOG = 1;
    static final int TIME_DIALOG = 2;

    Connection C;
    Global g;
    private List<IPDScreening_DataModel> dataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DataAdapter mAdapter;
    static String TableName;

    TextView lblHeading;
    Button btnAdd;
    Button btnRefresh;

    static String STARTTIME = "";
    static String PREENROLLMENTID = "";

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.ipdscreening_list);
         C = new Connection(this);
         g = Global.getInstance();
         STARTTIME = g.CurrentTime24();

         TableName = "IPDScreening";
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(IPDScreening_list.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});

         btnRefresh = (Button) findViewById(R.id.btnRefresh);
         btnRefresh.setOnClickListener(new View.OnClickListener() {

             public void onClick(View view) {
                   //write your code here
                   DataSearch(PREENROLLMENTID);

             }});

         btnAdd   = (Button) findViewById(R.id.btnAdd);
         btnAdd.setOnClickListener(new View.OnClickListener() {

             public void onClick(View view) {
                         Bundle IDbundle = new Bundle();
                         IDbundle.putString("PreEnrollmentID", "");
                         IDbundle.putString("studyid", "");
                         IDbundle.putString("status", "add");
                         IDbundle.putString("callfrom", "n");
                         Intent intent = new Intent(getApplicationContext(), IPDScreening.class);
                         intent.putExtras(IDbundle);
                         startActivityForResult(intent, 1);

             }});


        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mAdapter = new DataAdapter(dataList);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        DataSearch(PREENROLLMENTID);


     }
     catch(Exception  e)
     {
         Connection.MessageBox(IPDScreening_list.this, e.getMessage());
         return;
     }
 }
 
 @Override
 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     super.onActivityResult(requestCode, resultCode, data);
     if (resultCode == Activity.RESULT_CANCELED) {
         //Write your code if there's no result
     } else {
         DataSearch(PREENROLLMENTID);
     }
 }

 private void DataSearch(String PreEnrollmentID)
     {
       try
        {
     
           IPDScreening_DataModel d = new IPDScreening_DataModel();
             String SQL = "Select * from "+ TableName +"";// Where PreEnrollmentID='"+ PreEnrollmentID +"'";
             List<IPDScreening_DataModel> data = d.SelectAll(this, SQL);
             dataList.clear();

             dataList.addAll(data);
             try {
                 mAdapter.notifyDataSetChanged();
             }catch ( Exception ex){
                 Connection.MessageBox(IPDScreening_list.this,ex.getMessage());
             }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(IPDScreening_list.this, e.getMessage());
            return;
        }
     }


     public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
         private List<IPDScreening_DataModel> dataList;
         public class MyViewHolder extends RecyclerView.ViewHolder {
         LinearLayout secListRow;
         TextView PreEnrollmentID;
         TextView hasDiarr;
         TextView IBDID;
         TextView CName;
         TextView CDOB;
         TextView CAge;
         TextView CSex;
         TextView HosAdDate;
         TextView HosAdTime;
         TextView HosRegis1;
         TextView HosBed1;
         TextView HosWard1;
         TextView HosRegis2;
         TextView HosBed2;
         TextView HosWard2;
         TextView HosRegis3;
         TextView HosBed3;
         TextView HosWard3;
         TextView ProviDaig1;
         TextView ProviDiag2;
         TextView ProviDiag3;
         TextView ProviDiag4;
         TextView ProviDiag5;
         TextView Age5Yr;
         TextView Occur3;
         TextView DurDiarr;
         TextView BldDiarr;
         TextView EligiEnrol;
         TextView Consent;
         TextView StudyID;
         TextView MFName;
         TextView Contact1;
         TextView cont1Veri;
         TextView cont1Rel;
         TextView Contact2;
         TextView Cont2Veri;
         TextView Cont2Rel;
         TextView Zila;
         TextView Upazila;
         TextView Unions;
         TextView Village;
         TextView Location;
         TextView StudyArea;
         TextView SpeColAdv;
         public MyViewHolder(View convertView) {
             super(convertView);
             secListRow = (LinearLayout)convertView.findViewById(R.id.secListRow);
             PreEnrollmentID = (TextView)convertView.findViewById(R.id.PreEnrollmentID);
             hasDiarr = (TextView)convertView.findViewById(R.id.hasDiarr);
             IBDID = (TextView)convertView.findViewById(R.id.IBDID);
             CName = (TextView)convertView.findViewById(R.id.CName);
             CDOB = (TextView)convertView.findViewById(R.id.CDOB);
             CAge = (TextView)convertView.findViewById(R.id.CAge);
             CSex = (TextView)convertView.findViewById(R.id.CSex);
             HosAdDate = (TextView)convertView.findViewById(R.id.HosAdDate);
             HosAdTime = (TextView)convertView.findViewById(R.id.HosAdTime);
             HosRegis1 = (TextView)convertView.findViewById(R.id.HosRegis1);
             HosBed1 = (TextView)convertView.findViewById(R.id.HosBed1);
             HosWard1 = (TextView)convertView.findViewById(R.id.HosWard1);
             HosRegis2 = (TextView)convertView.findViewById(R.id.HosRegis2);
             HosBed2 = (TextView)convertView.findViewById(R.id.HosBed2);
             HosWard2 = (TextView)convertView.findViewById(R.id.HosWard2);
             HosRegis3 = (TextView)convertView.findViewById(R.id.HosRegis3);
             HosBed3 = (TextView)convertView.findViewById(R.id.HosBed3);
             HosWard3 = (TextView)convertView.findViewById(R.id.HosWard3);
             ProviDaig1 = (TextView)convertView.findViewById(R.id.ProviDaig1);
             ProviDiag2 = (TextView)convertView.findViewById(R.id.ProviDiag2);
             ProviDiag3 = (TextView)convertView.findViewById(R.id.ProviDiag3);
             ProviDiag4 = (TextView)convertView.findViewById(R.id.ProviDiag4);
             ProviDiag5 = (TextView)convertView.findViewById(R.id.ProviDiag5);
             Age5Yr = (TextView)convertView.findViewById(R.id.Age5Yr);
             Occur3 = (TextView)convertView.findViewById(R.id.Occur3);
             DurDiarr = (TextView)convertView.findViewById(R.id.DurDiarr);
             BldDiarr = (TextView)convertView.findViewById(R.id.BldDiarr);
             EligiEnrol = (TextView)convertView.findViewById(R.id.EligiEnrol);
             Consent = (TextView)convertView.findViewById(R.id.Consent);
             StudyID = (TextView)convertView.findViewById(R.id.StudyID);
             MFName = (TextView)convertView.findViewById(R.id.MFName);
             Contact1 = (TextView)convertView.findViewById(R.id.Contact1);
             cont1Veri = (TextView)convertView.findViewById(R.id.cont1Veri);
             cont1Rel = (TextView)convertView.findViewById(R.id.cont1Rel);
             Contact2 = (TextView)convertView.findViewById(R.id.Contact2);
             Cont2Veri = (TextView)convertView.findViewById(R.id.Cont2Veri);
             Cont2Rel = (TextView)convertView.findViewById(R.id.Cont2Rel);
             Zila = (TextView)convertView.findViewById(R.id.Zila);
             Upazila = (TextView)convertView.findViewById(R.id.Upazila);
             Unions = (TextView)convertView.findViewById(R.id.Unions);
             Village = (TextView)convertView.findViewById(R.id.Village);
             Location = (TextView)convertView.findViewById(R.id.Location);
             StudyArea = (TextView)convertView.findViewById(R.id.StudyArea);
             SpeColAdv = (TextView)convertView.findViewById(R.id.SpeColAdv);
             }
         }
         public DataAdapter(List<IPDScreening_DataModel> datalist) {
             this.dataList = datalist;
         }
         @Override
         public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
             View itemView = LayoutInflater.from(parent.getContext())
                     .inflate(R.layout.ipdscreening_row, parent, false);
             return new MyViewHolder(itemView);
         }
         @Override
         public void onBindViewHolder(MyViewHolder holder, int position) {
             final IPDScreening_DataModel data = dataList.get(position);
             holder.PreEnrollmentID.setText(String.valueOf(data.getPreEnrollmentID()));
             holder.hasDiarr.setText(String.valueOf(data.gethasDiarr()));
             holder.IBDID.setText(String.valueOf(data.getIBDID()));
             holder.CName.setText(data.getCName());
             holder.CDOB.setText(data.getCDOB());
             holder.CAge.setText(String.valueOf(data.getCAge()));
             holder.CSex.setText(String.valueOf(data.getCSex()));
             holder.HosAdDate.setText(data.getHosAdDate());
             holder.HosAdTime.setText(data.getHosAdTime());
             holder.HosRegis1.setText(data.getHosRegis1());
             holder.HosBed1.setText(data.getHosBed1());
             holder.HosWard1.setText(data.getHosWard1());
             holder.HosRegis2.setText(data.getHosRegis2());
             holder.HosBed2.setText(data.getHosBed2());
             holder.HosWard2.setText(data.getHosWard2());
             holder.HosRegis3.setText(data.getHosRegis3());
             holder.HosBed3.setText(data.getHosBed3());
             holder.HosWard3.setText(data.getHosWard3());
             holder.ProviDaig1.setText(data.getProviDaig1());
             holder.ProviDiag2.setText(data.getProviDiag2());
             holder.ProviDiag3.setText(data.getProviDiag3());
             holder.ProviDiag4.setText(data.getProviDiag4());
             holder.ProviDiag5.setText(data.getProviDiag5());
             holder.Age5Yr.setText(String.valueOf(data.getAge5Yr()));
             holder.Occur3.setText(String.valueOf(data.getOccur3()));
             holder.DurDiarr.setText(String.valueOf(data.getDurDiarr()));
             holder.BldDiarr.setText(String.valueOf(data.getBldDiarr()));
             holder.EligiEnrol.setText(String.valueOf(data.getEligiEnrol()));
             holder.Consent.setText(String.valueOf(data.getConsent()));
             holder.StudyID.setText(String.valueOf(data.getStudyID()));
             holder.MFName.setText(data.getMFName());
             holder.Contact1.setText(data.getContact1());
             holder.cont1Veri.setText(String.valueOf(data.getcont1Veri()));
             holder.cont1Rel.setText(data.getcont1Rel());
             holder.Contact2.setText(data.getContact2());
             holder.Cont2Veri.setText(String.valueOf(data.getCont2Veri()));
             holder.Cont2Rel.setText(data.getCont2Rel());
             holder.Zila.setText(String.valueOf(data.getZila()));
             holder.Upazila.setText(String.valueOf(data.getUpazila()));
             holder.Unions.setText(String.valueOf(data.getUnions()));
             holder.Village.setText(String.valueOf(data.getVillage()));
             holder.Location.setText(data.getLocation());
             holder.StudyArea.setText(String.valueOf(data.getStudyArea()));
             holder.SpeColAdv.setText(String.valueOf(data.getSpeColAdv()));
             holder.secListRow.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     final ProgressDialog progDailog = ProgressDialog.show(IPDScreening_list.this, "", "Please Wait . . .", true);
                     new Thread() {
                         public void run() {
                             try {
                                 Bundle IDbundle = new Bundle();
                                 IDbundle.putString("PreEnrollmentID", String.valueOf(data.getPreEnrollmentID()));
                                 IDbundle.putString("studyid", String.valueOf(data.getStudyID()));
                                 IDbundle.putString("callfrom", "o");
                                 Intent f1 = new Intent(getApplicationContext(), Menu_Assessment.class);
                                 f1.putExtras(IDbundle);
                                 startActivityForResult(f1,1);
                             } catch (Exception e) {
                             }
                             progDailog.dismiss();
                         }
                     }.start();
                 }
             });
         }
         @Override
         public int getItemCount() {
             return dataList.size();
         }
     }

     public class DividerItemDecoration extends RecyclerView.ItemDecoration {
             private final int[] ATTRS = new int[]{
                     android.R.attr.listDivider
             };
             public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
             public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
             private Drawable mDivider;
             private int mOrientation;
             public DividerItemDecoration(Context context, int orientation) {
                 final TypedArray a = context.obtainStyledAttributes(ATTRS);
                 mDivider = a.getDrawable(0);
                 a.recycle();
                 setOrientation(orientation);
             }
             public void setOrientation(int orientation) {
                 if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
                     throw new IllegalArgumentException("invalid orientation");
                 }
                 mOrientation = orientation;
             }
             @Override
             public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
                 if (mOrientation == VERTICAL_LIST) {
                     drawVertical(c, parent);
                 } else {
                     drawHorizontal(c, parent);
                 }
             }
             public void drawVertical(Canvas c, RecyclerView parent) {
                 final int left = parent.getPaddingLeft();
                 final int right = parent.getWidth() - parent.getPaddingRight();

                 final int childCount = parent.getChildCount();
                 for (int i = 0; i < childCount; i++) {
                     final View child = parent.getChildAt(i);
                     final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                             .getLayoutParams();
                     final int top = child.getBottom() + params.bottomMargin;
                     final int bottom = top + mDivider.getIntrinsicHeight();
                     mDivider.setBounds(left, top, right, bottom);
                     mDivider.draw(c);
                 }
             }
             public void drawHorizontal(Canvas c, RecyclerView parent) {
                 final int top = parent.getPaddingTop();
                 final int bottom = parent.getHeight() - parent.getPaddingBottom();
                 final int childCount = parent.getChildCount();
                 for (int i = 0; i < childCount; i++) {
                     final View child = parent.getChildAt(i);
                     final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                             .getLayoutParams();
                     final int left = child.getRight() + params.rightMargin;
                     final int right = left + mDivider.getIntrinsicHeight();
                     mDivider.setBounds(left, top, right, bottom);
                     mDivider.draw(c);
                 }
             }
             @Override
             public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                 if (mOrientation == VERTICAL_LIST) {
                     outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
                 } else {
                     outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
                 }
             }
     }

     public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
             private GestureDetector gestureDetector;
             private ClickListener clickListener;
             public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
                 this.clickListener = clickListener;
                 gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                     @Override
                     public boolean onSingleTapUp(MotionEvent e) {
                         return true;
                     }
                     @Override
                     public void onLongPress(MotionEvent e) {
                         View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                         if (child != null && clickListener != null) {
                             clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                         }
                     }
                 });
             }
             @Override
             public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                 View child = rv.findChildViewUnder(e.getX(), e.getY());
                 if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                     clickListener.onClick(child, rv.getChildPosition(child));
                 }
                 return false;
             }
             @Override
             public void onTouchEvent(RecyclerView rv, MotionEvent e) {
             }
             @Override
             public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
             }
             interface ClickListener {
                 void onClick(View view, int position);
                 void onLongClick(View view, int position);
             }
     }


}