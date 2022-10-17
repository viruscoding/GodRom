package com.god.godmanager.ui.addpackage;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.god.godmanager.Common.FragmentListen;
import com.god.godmanager.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OtherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OtherFragment extends Fragment {

    public EditText txtSleepNativeMethod;
    public EditText txtSmaliTrace;
    public Button btnSelectFridaJs;
    public EditText txtJsPath;
    public Button btnListen;
    public Button btnListenWait;
    public EditText txtPort;
    public EditText txtGadgetPath;
    public Button btnSelectGadget;
    public Button btnSelectGadgetArm64;
    public EditText txtGadgetArm64Path;

    private FragmentListen listener;

    public OtherFragment() {
        // Required empty public constructor
    }
    public static OtherFragment newInstance() {
        OtherFragment fragment = new OtherFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach(activity);
        listener=(FragmentListen) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_other, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        txtSmaliTrace = (EditText)getActivity().findViewById(R.id.txtSmaliTrace);
        txtSleepNativeMethod=(EditText)getActivity().findViewById(R.id.txtSleepNativeMethod);
        btnSelectFridaJs=(Button)getActivity().findViewById(R.id.btnSelectFridaJs);
        txtJsPath=(EditText)getActivity().findViewById(R.id.txtJsPath);
        btnListen=(Button)getActivity().findViewById(R.id.btnListen);
        btnListenWait=(Button)getActivity().findViewById(R.id.btnListenWait);
        txtPort=(EditText)getActivity().findViewById(R.id.txtPort);
        txtGadgetPath=(EditText)getActivity().findViewById(R.id.txtGadgetPath);
        btnSelectGadget=(Button)getActivity().findViewById(R.id.btnSelectGadget);
        btnSelectGadgetArm64=(Button)getActivity().findViewById(R.id.btnSelectGadgetArm64);
        txtGadgetArm64Path=(EditText)getActivity().findViewById(R.id.txtGadgetArm64Path);
        listener.onOtherAttach();
    }
}