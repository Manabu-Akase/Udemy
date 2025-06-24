package com.example.quiz;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class AnswerDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        //mainActivityから値を受け取る

        String title = requireArguments().getString("TITLE");
        String message = requireArguments().getString("MESSAGE");

       return new MaterialAlertDialogBuilder(requireActivity())
                .setTitle(title)
                .setMessage("答え:"+message)
                .setPositiveButton("OK", (dialog, which) ->
                {

                    //ボタンが押されたら実行するコード

                    ((MainActivity)requireActivity()).checkQuizCount();

                })

                .create();

    }
}
