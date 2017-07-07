package com.zhang.greendaotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zhang.greendaotest.bean.Tbl_province;
import com.zhang.greendaotest.bean.User;
import com.zhang.greendaotest.db.GreenDaoManager;
import com.zhang.greendaotest.greendao.gen.Tbl_provinceDao;
import com.zhang.greendaotest.greendao.gen.UserDao;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "GREENDAO";
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.btn5)
    Button btn5;
    @BindView(R.id.btn6)
    Button btn6;
    @BindView(R.id.btn7)
    Button btn7;
    @BindView(R.id.btn8)
    Button btn8;
    @BindView(R.id.tv)
    TextView mTv;

    private List<User> users;
    private UserDao mUserDao;
    private Tbl_provinceDao mTbl_provinceDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mUserDao = MyApp.sDaoSession.getUserDao();
        mTbl_provinceDao = MyApp.sNewDaoSession.getTbl_provinceDao();
    }


    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                //数据逐一添加
                User user1 = new User(null, "greendao_1", "110", 20);
                mUserDao.insert(user1);
                User user2 = new User(null, "greendao_2", "111", 21);
                mUserDao.insert(user2);
                break;
            case R.id.btn2:
                List<User> userList = mUserDao.queryBuilder()
                        //条件
                        .where(UserDao.Properties.Id.notEq(10))
                        //排序
                        .orderAsc(UserDao.Properties.Id)
                        //限制查询个数
                        .limit(10)
                        .build().list();
                mTv.setText(userList.toString());
                break;
            case R.id.btn3:
                User oldUser = mUserDao.queryBuilder()
                        .where(UserDao.Properties.Name.eq("greendao_1")).build().unique();
                if (oldUser != null) {
                    oldUser.setName("greendao_0");
                    mUserDao.update(oldUser);
                    Log.d(TAG, "update: 修改成功");
                } else {
                    Log.d(TAG, "update: 修改失败");
                }
                break;
            case R.id.btn4:
                User findUser = mUserDao.queryBuilder().where(UserDao.Properties.Name.eq("greendao_2")).build().unique();
                if (findUser != null) {
                    mUserDao.deleteByKey(findUser.getId());
                }
                break;
            case R.id.btn5:
                String sql = "delete from user where user_name='greendao_1'";
                GreenDaoManager.getInstance().getmDaoSession().getDatabase().execSQL(sql);
                break;
            case R.id.btn6:
                users = Arrays.asList(new User(null, "greendao_100", "120", 20,null),
                        new User(null, "greendao_101", "121", 21,"001"),
                        new User(null, "greendao_102", "122", 22,"002"),
                        new User(null, "greendao_103", "123", 23,"003"),
                        new User(null, "greendao_104", "124", 24,"004"),
                        new User(null, "greendao_105", "125", 25,"005"),
                        new User(null, "greendao_106", "126", 26,"006")
                );
                mUserDao.getSession().runInTx(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < users.size(); i++) {
                            User user = users.get(i);
                            mUserDao.insertOrReplace(user);
                        }
                    }
                });
                break;
            case R.id.btn7:
                mUserDao.deleteAll();
                break;
            case R.id.btn8:
                List<Tbl_province> cityList = mTbl_provinceDao.queryBuilder()
                        //条件
                        .where(Tbl_provinceDao.Properties.Id.notEq(100))
                        //排序
                        .orderAsc(Tbl_provinceDao.Properties.Id)
                        //限制查询个数
                        .limit(100)
                        .build().list();
                mTv.setText(cityList.toString());
                break;
        }
    }

}
