package com.example.servicestudy4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment {
    private Removable removable;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        removable = (Removable) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        assert getArguments() != null;
        String phone = getArguments().getString("phone");
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        return builder
                .setTitle("Alert Dialog")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Delete " + phone + "?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        removable.remove(phone);
                    }
                })
                .setNegativeButton("CANCEL", null)
                .create();
    }
}
