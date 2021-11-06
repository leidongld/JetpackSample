package com.openld.jetpacksample.room;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.openld.jetpacksample.R;
import com.openld.jetpacksample.room.entities.Performance;
import com.openld.jetpacksample.room.entities.Student;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Room测试页
 */
public class RoomActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTxtStudent;

    private TextView mTxtPerformance;

    private Button mBtnAdd;

    private Button mBtnQuery;

    private final StudentHandler mStudentHandler = new StudentHandler(Looper.getMainLooper(), RoomActivity.this);

    private final PerformanceHandler mPerformanceHandler = new PerformanceHandler(Looper.getMainLooper(), RoomActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        initWidgets();
    }

    private void initWidgets() {
        mTxtStudent = findViewById(R.id.txt_student);
        mTxtPerformance = findViewById(R.id.txt_performance);

        mBtnAdd = findViewById(R.id.btn_add);
        mBtnAdd.setOnClickListener(this);

        mBtnQuery = findViewById(R.id.btn_query);
        mBtnQuery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == mBtnAdd.getId()) {
            clickAddButton();
        } else if (v.getId() == mBtnQuery.getId()) {
            clickQueryButton();
        }
    }

    /**
     * 点击了查找按钮
     */
    private void clickQueryButton() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Student student = MyDatabase.getInstance().studentDao().queryStudentById(1);
                List<Performance> performanceList = MyDatabase.getInstance().performanceDao().queryPerformanceByStudentId(student.id);

                Message msgStudent = Message.obtain();
                msgStudent.obj = student;
                mStudentHandler.sendMessage(msgStudent);

                Message msgPerformance = Message.obtain();
                msgPerformance.obj = performanceList;
                mPerformanceHandler.sendMessage(msgPerformance);
            }
        }).start();
    }

    /**
     * 点击了添加按钮
     */
    private void clickAddButton() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Student student = new Student(1, "Sam", "18");
                MyDatabase.getInstance().studentDao().deleteStudent(student);
                MyDatabase.getInstance().studentDao().insertStudent(student);

                Performance performance1 = new Performance(1, 1, 90, 88, 97);
                MyDatabase.getInstance().performanceDao().deletePerformance(performance1);
                MyDatabase.getInstance().performanceDao().insertPerformance(performance1);

                Performance performance2 = new Performance(2, 1, 92, 81, 87);
                MyDatabase.getInstance().performanceDao().deletePerformance(performance2);
                MyDatabase.getInstance().performanceDao().insertPerformance(performance2);

//                Performance performance3 = new Performance(1, 1, 92, 81, 87);
//                MyDatabase.getInstance().performanceDao().deletePerformance(performance3);
//                MyDatabase.getInstance().performanceDao().insertPerformance(performance3);
            }
        }).start();
    }

    /**
     * 处理学生数数据的Handler
     */
    private static class StudentHandler extends Handler {
        private final WeakReference<RoomActivity> activityWeakReference;

        public StudentHandler(Looper looper, RoomActivity activity) {
            super(looper);
            activityWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            RoomActivity activity = activityWeakReference.get();
            super.handleMessage(msg);
            if (activity == null) {
                return;
            }
            Student student = (Student) msg.obj;
            activity.mTxtStudent.setText(student.toString());
        }
    }

    /**
     * 处理表现数据的Handler
     */
    private static class PerformanceHandler extends Handler {
        private final WeakReference<RoomActivity> activityWeakReference;

        public PerformanceHandler(Looper looper, RoomActivity activity) {
            super(looper);
            activityWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            RoomActivity activity = activityWeakReference.get();
            super.handleMessage(msg);
            if (activity == null) {
                return;
            }
            List<Performance> performanceList = (List<Performance>) msg.obj;
            StringBuilder sb = new StringBuilder();
            for (Performance performance : performanceList) {
                sb.append(performance.toString()).append("\n");
            }
            activity.mTxtPerformance.setText(sb.toString());
        }
    }
}