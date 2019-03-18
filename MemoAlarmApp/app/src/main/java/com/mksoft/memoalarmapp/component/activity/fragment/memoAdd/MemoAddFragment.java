package com.mksoft.memoalarmapp.component.activity.fragment.memoAdd;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

//import android.App.Fragment;
import com.mksoft.memoalarmapp.HideKeyboard;
import com.mksoft.memoalarmapp.ViewModel.MemoViewModel;
import com.mksoft.memoalarmapp.component.activity.MainActivity;
import com.mksoft.memoalarmapp.R;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.AndroidSupportInjection;

public class MemoAddFragment extends Fragment {
    Button btn;
    Button AddPagebackButton;
    EditText titleData;
    EditText contentData;
    LinearLayout memoAddLayout;

    MainActivity mainActivity;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity)getActivity();
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.configureDagger();

    }
    private void configureDagger(){
        AndroidSupportInjection.inject(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){


        View view = inflater.inflate(R.layout.memo_add, container, false);
        titleData =  view.findViewById(R.id.title);
        contentData =  view.findViewById(R.id.content);
        memoAddLayout = view.findViewById(R.id.memoAddLayout);
        AddPagebackButton = view.findViewById(R.id.AddPagebackButton);
        //hideKeyboard();
        btn = view.findViewById(R.id.btn1);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("title",titleData.getText().toString());
                bundle.putString("content",contentData.getText().toString());

                mainActivity.OnFragmentChange(2,bundle);

            }
        });
        clickHideKeyboard();
        clickBack();
        return view;
    }


    private void clickBack(){
        AddPagebackButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                mainActivity.OnFragmentChange(0,null);

            }
        });
    }
    private void hideKeyboard(){
        MainActivity.mainActivity.getHideKeyboard().hideKeyboard();
    }
    private void clickHideKeyboard(){
        memoAddLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard();

            }
        });
    }




}
