package org.icddrb.rotaproject;
//Android Manifest Code
 //<activity android:name=".EmergencyScreening_list" android:label="EmergencyScreening: List" />
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

 public class EmergencyScreening_list extends AppCompatActivity {
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
    private List<EmergencyScreening_DataModel> dataList = new ArrayList<>();
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
         setContentView(R.layout.emergencyscreening_list);
         C = new Connection(this);
         g = Global.getInstance();
         STARTTIME = g.CurrentTime24();

         TableName = "EmergencyScreening";
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(EmergencyScreening_list.this);
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
                         Intent intent = new Intent(getApplicationContext(), EmergencyScreening.class);
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
         Connection.MessageBox(EmergencyScreening_list.this, e.getMessage());
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
     
           EmergencyScreening_DataModel d = new EmergencyScreening_DataModel();
             String SQL = "Select * from "+ TableName +"";
             List<EmergencyScreening_DataModel> data = d.SelectAll(this, SQL);
             dataList.clear();

             dataList.addAll(data);
             try {
                 mAdapter.notifyDataSetChanged();
             }catch ( Exception ex){
                 Connection.MessageBox(EmergencyScreening_list.this,ex.getMessage());
             }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(EmergencyScreening_list.this, e.getMessage());
            return;
        }
     }


     public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
         private List<EmergencyScreening_DataModel> dataList;
         public class MyViewHolder extends RecyclerView.ViewHolder {
         LinearLayout secListRow;
         TextView PreEnrollmentID;
         TextView StudyID;
         TextView HosRegis;
         TextView DtEnroll;
         TextView CName;
         TextView CDOB;
         TextView CAgeM;
         TextView CSex;
         TextView MFName;
         TextView Contact1;
         TextView Cont1Veri;
         TextView Cont1Rel;
         TextView Contact2;
         TextView Cont2Veri;
         TextView Cont2Rel;
         TextView Zila;
         TextView Upazila;
         TextView Unions;
         TextView Village;
         TextView Location;
         TextView StudyArea;
         TextView PreSumDiag;
         TextView PreSumDiag1;
         TextView PreSumDiag2;
         TextView PreSumDiag3;
         TextView PreSumDiag4;
         TextView PreSumDiag5;
         TextView OthSymp1;
         TextView Symp1Dur;
         TextView OthSymp2;
         TextView Symp2Dur;
         TextView RefuesAdm;
         TextView TRefusal;
         public MyViewHolder(View convertView) {
             super(convertView);
             secListRow = (LinearLayout)convertView.findViewById(R.id.secListRow);
             PreEnrollmentID = (TextView)convertView.findViewById(R.id.PreEnrollmentID);
             StudyID = (TextView)convertView.findViewById(R.id.StudyID);
             HosRegis = (TextView)convertView.findViewById(R.id.HosRegis);
             DtEnroll = (TextView)convertView.findViewById(R.id.DtEnroll);
             CName = (TextView)convertView.findViewById(R.id.CName);
             CDOB = (TextView)convertView.findViewById(R.id.CDOB);
             CAgeM = (TextView)convertView.findViewById(R.id.CAgeM);
             CSex = (TextView)convertView.findViewById(R.id.CSex);
             MFName = (TextView)convertView.findViewById(R.id.MFName);
             Contact1 = (TextView)convertView.findViewById(R.id.Contact1);
             Cont1Veri = (TextView)convertView.findViewById(R.id.Cont1Veri);
             Cont1Rel = (TextView)convertView.findViewById(R.id.Cont1Rel);
             Contact2 = (TextView)convertView.findViewById(R.id.Contact2);
             Cont2Veri = (TextView)convertView.findViewById(R.id.Cont2Veri);
             Cont2Rel = (TextView)convertView.findViewById(R.id.Cont2Rel);
             Zila = (TextView)convertView.findViewById(R.id.Zila);
             Upazila = (TextView)convertView.findViewById(R.id.Upazila);
             Unions = (TextView)convertView.findViewById(R.id.Unions);
             Village = (TextView)convertView.findViewById(R.id.Village);
             Location = (TextView)convertView.findViewById(R.id.Location);
             StudyArea = (TextView)convertView.findViewById(R.id.StudyArea);
             PreSumDiag = (TextView)convertView.findViewById(R.id.PreSumDiag);
             PreSumDiag1 = (TextView)convertView.findViewById(R.id.PreSumDiag1);
             PreSumDiag2 = (TextView)convertView.findViewById(R.id.PreSumDiag2);
             PreSumDiag3 = (TextView)convertView.findViewById(R.id.PreSumDiag3);
             PreSumDiag4 = (TextView)convertView.findViewById(R.id.PreSumDiag4);
             PreSumDiag5 = (TextView)convertView.findViewById(R.id.PreSumDiag5);
             OthSymp1 = (TextView)convertView.findViewById(R.id.OthSymp1);
             Symp1Dur = (TextView)convertView.findViewById(R.id.Symp1Dur);
             OthSymp2 = (TextView)convertView.findViewById(R.id.OthSymp2);
             Symp2Dur = (TextView)convertView.findViewById(R.id.Symp2Dur);
             RefuesAdm = (TextView)convertView.findViewById(R.id.RefuesAdm);
             TRefusal = (TextView)convertView.findViewById(R.id.TRefusal);
             }
         }
         public DataAdapter(List<EmergencyScreening_DataModel> datalist) {
             this.dataList = datalist;
         }
         @Override
         public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
             View itemView = LayoutInflater.from(parent.getContext())
                     .inflate(R.layout.emergencyscreening_row, parent, false);
             return new MyViewHolder(itemView);
         }
         @Override
         public void onBindViewHolder(MyViewHolder holder, int position) {
             final EmergencyScreening_DataModel data = dataList.get(position);
             holder.PreEnrollmentID.setText(String.valueOf(data.getPreEnrollmentID()));
             holder.StudyID.setText(String.valueOf(data.getStudyID()));
             holder.HosRegis.setText(String.valueOf(data.getHosRegis()));
             holder.DtEnroll.setText(data.getDtEnroll());
             holder.CName.setText(data.getCName());
             holder.CDOB.setText(data.getCDOB());
             holder.CAgeM.setText(String.valueOf(data.getCAgeM()));
             holder.CSex.setText(String.valueOf(data.getCSex()));
             holder.MFName.setText(data.getMFName());
             holder.Contact1.setText(data.getContact1());
             holder.Cont1Veri.setText(String.valueOf(data.getCont1Veri()));
             holder.Cont1Rel.setText(data.getCont1Rel());
             holder.Contact2.setText(data.getContact2());
             holder.Cont2Veri.setText(String.valueOf(data.getCont2Veri()));
             holder.Cont2Rel.setText(data.getCont2Rel());
             holder.Zila.setText(data.getZila());
             holder.Upazila.setText(data.getUpazila());
             holder.Unions.setText(data.getUnions());
             holder.Village.setText(data.getVillage());
             holder.Location.setText(data.getLocation());
             holder.StudyArea.setText(String.valueOf(data.getStudyArea()));
             holder.PreSumDiag.setText(String.valueOf(data.getPreSumDiag()));
             holder.PreSumDiag1.setText(data.getPreSumDiag1());
             holder.PreSumDiag2.setText(data.getPreSumDiag2());
             holder.PreSumDiag3.setText(data.getPreSumDiag3());
             holder.PreSumDiag4.setText(data.getPreSumDiag4());
             holder.PreSumDiag5.setText(data.getPreSumDiag5());
             holder.OthSymp1.setText(data.getOthSymp1());
             holder.Symp1Dur.setText(String.valueOf(data.getSymp1Dur()));
             holder.OthSymp2.setText(data.getOthSymp2());
             holder.Symp2Dur.setText(String.valueOf(data.getSymp2Dur()));
             holder.RefuesAdm.setText(String.valueOf(data.getRefuesAdm()));
             holder.TRefusal.setText(data.getTRefusal());
             holder.secListRow.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     final ProgressDialog progDailog = ProgressDialog.show(EmergencyScreening_list.this, "", "Please Wait . . .", true);
                     new Thread() {
                         public void run() {
                             try {
                                 Bundle IDbundle = new Bundle();
                                 IDbundle.putString("PreEnrollmentID", String.valueOf(data.getPreEnrollmentID()));
                                 Intent f1 = new Intent(getApplicationContext(), EmergencyScreening.class);
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