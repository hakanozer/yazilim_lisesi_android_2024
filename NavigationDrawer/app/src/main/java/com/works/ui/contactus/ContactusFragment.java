package com.works.ui.contactus;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.works.R;
import com.works.utils.Const;

public class ContactusFragment extends Fragment {

    private ContactusViewModel mViewModel;

    public static ContactusFragment newInstance() {
        return new ContactusFragment();
    }

    EditText txt_email, txt_name;
    Button btn_send;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contactus, container, false);

        txt_email = v.findViewById(R.id.txt_email);
        txt_name = v.findViewById(R.id.txt_name);
        btn_send = v.findViewById(R.id.btn_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txt_email.getText().toString();
                String name = txt_name.getText().toString();
                Const.email = email;
                Const.name = name;
                Toast.makeText(v.getContext(), email + " - " + name, Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ContactusViewModel.class);
        // TODO: Use the ViewModel
    }

}