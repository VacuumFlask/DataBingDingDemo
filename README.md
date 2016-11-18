# DataBingDingDemo
Android数据绑定框架DataBinding

环境搭建

查看build.gradle的工程文件的Android 的 Gradle 插件版本是否低于 1.5.0：

classpath 'com.android.tools.build:gradle:1.5.0'

低于1.5.0修改build.grade的工程文件中dependencies：

dependencies {
        classpath 'com.android.tools.build:gradle:1.5.0'
        classpath 'com.android.databinding:dataBinder:1.0-rc0'
    }

Android 的 Gradle 插件版本高于 1.5.0的直接在build.grade（Module）文件中添加

android {
    ....
    dataBinding {
        enabled = true
    }
}

注意：Android stuido 的版本一定要大于1.3，而且Android Studio目前对binding对象没有自动代码提示，只会在编译时进行检查。

然后添加一个简单的Bean类-->User
/**
 * Created by Administrator on 2016/11/17 0017.
 * User的Bean类
 */
public class User {
    private String name;
    private String age;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

然后添加一个布局文件main_activity_layout.xml

<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">

    <data>
        <variable
            name="User"
            type="User类的包路径.User" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@{User.name}" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@{User.age}" />
    </LinearLayout>


</layout>

添加完了之后，会自动创建一个MainActivityLayoutBinding类

然后在MainActivity中

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityLayoutBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.main_activity_layout);
        User user = new User("测试人员", "21");
        viewDataBinding.setUser(user);
    }
}

