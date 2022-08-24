package com.example.project03_last.member;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.project03_last.AndVO;
import com.example.project03_last.R;
import com.example.project03_last.conn.ApiClient;
import com.example.project03_last.conn.ApiInterface;
import com.example.project03_last.conn.CommonConn;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JoinActivity extends AppCompatActivity {
    TextInputEditText edt_id, edt_pw, edt_name;
    RadioGroup rdo_grp;
    Button btn_join, btn_close;
    ImageView imgv_profile;
    
    ActivityResultLauncher<Intent> launcher;//startActivityForResult 대신 나온 신버전 방식
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        checkDangerousPermissions();
        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        edt_name = findViewById(R.id.edt_name);
        rdo_grp = findViewById(R.id.rdo_grp);
        btn_join = findViewById(R.id.btn_join);
        btn_close = findViewById(R.id.btn_close);
        imgv_profile = findViewById(R.id.imgv_profile);
        imgv_profile.setOnClickListener(v -> {
            //카메라로 사진을 업데이트할건지(실시간찍기)
            //갤러리로 사진을 찍어놓은 것을 할건지(저장된 것 사용)
            showDialog();

            
        });

        Intent intent = getIntent();
        edt_id.setText(intent.getStringExtra("email"));
        if(edt_id.getText().toString().length() > 1) {
            edt_id.setEnabled(false);
        }

        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndVO vo = new AndVO();
                vo.setEmail(edt_id.getText()+"");
                vo.setPw(edt_pw.getText()+"");
                vo.setName(edt_name.getText()+"");
                if( rdo_grp.getCheckedRadioButtonId() == R.id.rdo_man) {
                    vo.setGender("남");
                }else {
                    vo.setGender("여");
                }

                CommonConn conn = new CommonConn(JoinActivity.this, "join");
                conn.addParams("vo", new Gson().toJson(vo));
                conn.excuteConn(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {

                    }
                });

            }
        });

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        
        /* 구버전
        Intent intent1 = new Intent(JoinActivity.this, LoginActivity.class);
        startActivityForResult(intent1, 1000);  //코드 상수로 final <-*/
    }
    
    String[] dialog_item = {"카메라", "갤러리"};
    public final int LOAD_IMG = 1000;   //startActivityForResult 라는 메소드로 인텐트가 실행이되면
                                        //해당하는 메소드로 실행한 액티비티가 종료되었을 때 결과를 얻어올 수 있음
                                        //모든 결과는 하나의 메소드인 onActivityResult 라는 메소드에서 처리해야함
                                        //어떤 작업이 끝났는지에 따라 코드 분기를 해줘야 함
    public final int CAMERA_CODE = 1001;
    AlertDialog dialog;
    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("선택해")
                .setSingleChoiceItems(dialog_item, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        
                        if(dialog_item[i].equals("카메라")) {
                            Log.d("다이얼로그", "onClick: 카메라" + i);
                            Intent pickIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            //임시파일 만들기 <- 프로바이더로 임시파일을 채워서 가져오게 만들기
                            //일단 이 인텐트가 사용가능한지 체크
                            if(pickIntent.resolveActivity(getPackageManager()) != null) {
                                //사용가능하다면!
                                //임시파일 만들기
                                File file = createFile();
                                if( file != null ) {
                                    //API24 부터는 프로바이더를 통해서 사진을 캡쳐한 것을 가져와야함(임시파일)
                                    Uri imgUri = FileProvider.getUriForFile(getApplicationContext()
                                                , getApplicationContext().getPackageName() + ".fileprovider", file);
                                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {    //API24 이상
                                        pickIntent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);
                                    }else {
                                        pickIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                                    }
                                }
                            startActivityForResult(pickIntent , CAMERA_CODE );

                            }

                        }else {
                            Log.d("다이얼로그", "onClick: 갤러리" + i);
                            //카메라, 갤러리 OS에서 만둘어둔 액티비티(액션)
                            Intent intent = new Intent();   //생성자에 어떤 작업할건지 지정해도 됨 setter
                            intent.setType("image/*");
                            intent.setAction(Intent.ACTION_PICK);   //갤러리에서 사진 선택
                            startActivityForResult(Intent.createChooser(intent, "Select Picture"), LOAD_IMG);
                        }
                    }
                });
        dialog = builder.create();
        dialog.show();
    }//showDialog()

    public String imgFilePath;
    private File createFile() { //임시파일 만들어내기
        //파일 이름을 동적으로 만들기
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "Pj03My" + timeStamp;
        //사진파일을 저장하기 위한 경로 받아오기
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        File rtnFile = null;
        try {
            rtnFile = File.createTempFile( fileName, ".jpg", storageDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        imgFilePath = rtnFile.getAbsolutePath();
        return rtnFile;
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        dialog.dismiss();
        if( requestCode == LOAD_IMG && resultCode == RESULT_OK/*-1 : 성공 / 실패는 0 */ ) {
            //Intent Data 형태로 주는 경로는 사실 사진파일의 실제 경로가 xx
            Log.d("갤러리", "onActivityResult: " + data.getData());
            Log.d("갤러리", "onActivityResult: " + data.getData().getPath());
            String img_path = getRealPath(data.getData());
            Glide.with(JoinActivity.this).load(img_path).into(imgv_profile);

            //MultiPart 형태로 전송 : File
            RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), new File(img_path));
            MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.jpg", fileBody);
            ApiInterface apiInterface = ApiClient.getApiclient().create(ApiInterface.class);
            apiInterface.sendFile(filePart).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Log.d("TAG", "onResponse: ");
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("TAG", "onResponse: ");
                }
            });

        }else if( requestCode == CAMERA_CODE && resultCode == RESULT_OK) {
            Glide.with(JoinActivity.this).load(imgFilePath).into(imgv_profile);
            RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), new File(imgFilePath));
            MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.jpg", fileBody);
            ApiInterface apiInterface = ApiClient.getApiclient().create(ApiInterface.class);
            apiInterface.sendFile(filePart).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });
        }
        //requestCode <= startActivityForResult 를 실행할 때 보내줬던 코드 (어떤 작업이 끝나고 이 메소드에 왔는지 구분하는 키)
    }

    public String getRealPath(Uri contentUri) {
        String res = null;
        String[] project = {MediaStore.Images.Media.DATA};  //저장소에 있는 이미지들을 일단 전부 가져옴
        Cursor cursor = getContentResolver().query(contentUri, project, null, null, null);
        if( cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }

    //권한 레벨 낮음 : 인터넷 - 사용하겠다고 메니페스트에 명시만 하면 OK
    //권한 레벨 중간 : 유튜브 - 사용하겠다고 메니페스트에 명시 후 queries 로 재명시 해줘야 함
    //권한 레벨 높음 : 위치, 카메라, 갤러리(파일저장소) - 사용하겠다고 메니페스트 명시 후 queries로도 명시 후 사용자 동의 필요
    
    private void checkDangerousPermissions() {
        String[] permissions = {
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_MEDIA_LOCATION,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Toast.makeText(this, "권한 설명 필요함.", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if( requestCode == 1 ) {    //성공
            for (int i = 0; i < permissions.length; i++) {
                if( grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("TAG", "권한 승인 됨: " + permissions[i]);
                }else {
                    Log.d("TAG", "권한 승인 안됨: " + permissions[i]);
                }
            }
        }
    }
}