package com.example.a07_dialogofragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class NuevaAveriaDialogo extends DialogFragment {
    AlertDialog.Builder builder;
    OnNuevaAveriaListener mListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.dialogo_nueva_averia, null));

        builder.setTitle("Nueva avería")
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast1 = Toast.makeText(getActivity(),"Avería guardada", Toast.LENGTH_SHORT);
                        toast1.show();
                        dialog.dismiss();
                        mListener.onAveriaGuardarClickListener();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Cancelar > cerrar el cuadro de diálogo
                        dialog.dismiss();
                    }
                });
        return builder.create();

    }

    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            mListener = (OnNuevaAveriaListener) activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString()
                    + " must implement NoticedialogListener");
        }
    }
}
