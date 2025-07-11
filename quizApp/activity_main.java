<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical"
    android:gravity="center">

    <TextView
        android:id="@+id/countLabel"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/count_label"
        android:textSize="20sp"
        />

    <TextView
        android:id="@+id/questionLabal"

        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/question_label"
        android:textSize="24sp"
        android:layout_marginTop="60dp"/>

    <Button
        android:id="@+id/answerBtn1"
        android:layout_width="300dp"
        android:layout_height="60dp"
        android:text="@string/btn_answer"
        android:layout_marginTop="80dp"
        style= "@style/Widget.Material3.Button.OutlinedButton" />

    <Button
        android:id="@+id/answerBtn2"
        android:layout_width="300dp"
        android:layout_height="60dp"
        android:text="@string/btn_answer"
        android:layout_marginTop="6dp"
        style= "@style/Widget.Material3.Button.OutlinedButton" />

    <Button
        android:id="@+id/answerBtn3"
        android:layout_width="300dp"
        android:layout_height="60dp"
        android:text="@string/btn_answer"
        android:layout_marginTop="6dp"
        style= "@style/Widget.Material3.Button.OutlinedButton" />

    <Button
        android:id="@+id/answerBtn4"
        android:layout_width="300dp"
        android:layout_height="60dp"
        android:text="@string/btn_answer"
        android:layout_marginTop="6dp"
        style= "@style/Widget.Material3.Button.OutlinedButton" />



</LinearLayout>
