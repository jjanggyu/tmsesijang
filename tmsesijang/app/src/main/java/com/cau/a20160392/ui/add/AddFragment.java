package com.cau.a20160392.ui.add;

import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cau.a20160392.MainActivity;
import com.cau.a20160392.R;
import androidx.appcompat.app.AppCompatActivity;
import java.io.InputStream;

import static android.app.Activity.RESULT_OK;

public class AddFragment extends Fragment {

    private AddViewModel mViewModel;
    private ImageView imageView;
    private static final int code = 0;

    public static AddFragment newInstance() {
        return new AddFragment();
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_add,container,false);
        imageView = (ImageView)rootView.findViewById(R.id.upload);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
               intent.setType("image/*");
               intent.setAction(Intent.ACTION_GET_CONTENT);
               startActivityForResult(intent,1);
            }
        });


        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       if(resultCode==1){
           if(resultCode== RESULT_OK){
               try {
                   InputStream in = getActivity().getContentResolver().openInputStream(data.getData());
                   Bitmap img = BitmapFactory.decodeStream(in);
                   in.close();
                   imageView.setImageBitmap(img);
               }catch (Exception e){
                   e.printStackTrace();
               }
           }
       }

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AddViewModel.class);
        // TODO: Use the ViewModel
    }

}
