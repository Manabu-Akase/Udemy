<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:fitsSystemWindows="true"
    tools:context=".MainActivity" >

    <TextView
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/map_label" />

    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignStart="@+id/textView1"
        android:layout_below="@+id/textView1"
        android:onClick="map"
        android:text="@string/map_address" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignStart="@+id/button1"
        android:layout_below="@+id/button1"
        android:text="@string/call_label" />

    <EditText
        android:id="@+id/editText1"
        android:autofillHints=""
        android:inputType="phone"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignStart="@+id/textView2"
        android:layout_below="@+id/textView2"
        android:ems="9"
        android:minHeight="48dp"
        android:background="#b0c4de"
        android:hint="@string/call_hint"
        android:layout_marginHorizontal="16dp"
        tools:ignore="LabelFor" />

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBaseline="@+id/editText1"
        android:layout_alignBottom="@+id/editText1"
        android:layout_toEndOf="@+id/editText1"
        android:onClick="call"
        android:text="@string/call_button" />

</RelativeLayout>
