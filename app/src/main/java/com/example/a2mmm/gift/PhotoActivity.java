package com.example.a2mmm.gift;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Base64;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import okhttp3.OkHttpClient;

import static com.example.a2mmm.gift.MainActivity.sspp;

public class PhotoActivity extends Activity {
    /**
     * Called when the activity is first created.
     *
     */
    TextView qr;
    Button but, upload_image;
    String[] ssp=new String[10];
    int tot=0;
    Bitmap[] bitmat=new Bitmap[10];
    Dialog mCameraDialog;
    public String base_url="http://118.89.174.136/";
    private final OkHttpClient client = new OkHttpClient();
    ImageView img1,img2,img3,img4,img5,img6,imgg;
    // 获取sd卡根目录地址,并创建图片父目录文件对象和文件的对象;
    String file_str = Environment.getExternalStorageDirectory().getPath();
    File mars_file = new File(file_str + "/my_camera");
    File file_go;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_photo);
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //请求权限
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0X11);
            //判断是否需要 向用户解释，为什么要申请该权限
            ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.READ_CONTACTS);
            //InputMethodManager  manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        }
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            //请求权限
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.CAMERA}, 0X11);
            //判断是否需要 向用户解释，为什么要申请该权限
            ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.READ_CONTACTS);
            //InputMethodManager  manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        }
        qr=(TextView) findViewById(R.id.qr);
        sspp="";
        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=1;
                while (i<=3)
                {
                    sspp=sspp+","+ssp[i];
                    i++;
                }
                Toast.makeText(PhotoActivity.this, "已确认", Toast.LENGTH_SHORT).show();
            }});
        img1 = (ImageView) findViewById(R.id.my_img_view);
        img1 .setOnClickListener(new OnClickListener() {

        @Override
        public void onClick (View v){
            imgg=img1;
            tot=1;
            downcd();
        }
        });
        img2 = (ImageView) findViewById(R.id.my_img_view1);
        img2 .setOnClickListener(new OnClickListener() {

            @Override
            public void onClick (View v){
                imgg=img2;
                tot=2;
                downcd();
            }
        });
        img3 = (ImageView) findViewById(R.id.my_img_view2);
        img3 .setOnClickListener(new OnClickListener() {

            @Override
            public void onClick (View v){
                imgg=img3;
                tot=3;
                downcd();
            }
        });
//上传

    }

    //拍照结束后显示图片;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
// TODO Auto-generated method stub
// 判断请求码和结果码是否正确，如果正确的话就在activity上显示刚刚所拍照的图片;
        if (requestCode == 0x1 && resultCode == this.RESULT_OK) {
/* 使用BitmapFactory.Options类防止OOM(Out Of Memory)的问题；
创建一个BitmapFactory.Options类用来处理bitmap；*/
            BitmapFactory.Options myoptions = new BitmapFactory.Options();
/* 设置Options对象inJustDecodeBounds的属性为true，用于在BitmapFactory的
decodeFile(String path, Options opt)后获取图片的高和宽；
而且设置了他的属性值为true后使用BitmapFactory的decodeFile()方法无法返回一张
图片的bitmap对象，仅仅是把图片的高和宽信息给Options对象；
*/
            myoptions.inJustDecodeBounds = true;
            Bitmap bm = BitmapFactory.decodeFile(file_go.getAbsolutePath());
            BitmapFactory.decodeFile(file_go.getAbsolutePath(), myoptions);
//根据在图片的宽和高，得到图片在不变形的情况指定大小下的缩略图,设置宽为222；
            int height = myoptions.outHeight * 512 / myoptions.outWidth;
            myoptions.outWidth = 512;
            myoptions.outHeight = height;
//在重新设置玩图片显示的高和宽后记住要修改，Options对象inJustDecodeBounds的属性为false;
//不然无法显示图片;
            myoptions.inJustDecodeBounds = false;
//还没完这里才刚开始,要节约内存还需要几个属性，下面是最关键的一个；
            myoptions.inSampleSize = myoptions.outWidth / 222;
//还可以设置其他几个属性用于缩小内存；
            myoptions.inPurgeable = true;
            myoptions.inInputShareable = true;
            myoptions.inPreferredConfig = Bitmap.Config.ARGB_4444;// 默认是Bitmap.Config.ARGB_8888
//成功了，下面就显示图片咯；
            bitmat[tot] = BitmapFactory.decodeFile(file_go.getAbsolutePath(), myoptions);
            ssp[tot]=Bitmap2StrByBase64(bm);
            imgg.setImageBitmap(bitmat[tot]);

        } else {
            System.out.println("不显示图片");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public String Bitmap2StrByBase64(Bitmap bit){
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        bit.compress(Bitmap.CompressFormat.JPEG, 40, bos);//参数100表示不压缩
        byte[] bytes=bos.toByteArray();
        return Base64.encodeToString(bytes, Base64.NO_WRAP);
    }
    public boolean string2Image(String imgStr, String imgFilePath) {
        // 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null)
            return false;
        try {
            // Base64解码
            byte[] b = Base64.decode(imgStr.getBytes(), Base64.DEFAULT);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    // 调整异常数据
                    b[i] += 256;
                }
            }
            // 生成Jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void downcd(){
        mCameraDialog = new Dialog(this, R.style.my_dialog);
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(
                R.layout.layout_camera_control, null);
        root.findViewById(R.id.btn_open_camera).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub

// 验证sd卡是否正确安装：
                if (Environment.MEDIA_MOUNTED.equals(Environment
                        .getExternalStorageState())) {
// 先创建父目录，如果新创建一个文件的时候，父目录没有存在，那么必须先创建父目录，再新建文件。
                    if (!mars_file.exists()) {
                        mars_file.mkdirs();
                    }

/*//常规情况下，我们这里会 创建子目录，但在这里不用系统拍照完毕后会根据所给的图片路径自动去实现;
if(!file_go.exists())
{
try {
file_go.createNewFile();
} catch (IOException e) {
}}
*/
// 设置跳转的系统拍照的activity为：MediaStore.ACTION_IMAGE_CAPTURE ;
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
// 并设置拍照的存在方式为外部存储和存储的路径；
                     file_go= new File(file_str + "/my_camera/file"+tot+".jpg");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(file_go));
//跳转到拍照界面;
                    startActivityForResult(intent, 0x1);
                } else {
                    Toast.makeText(PhotoActivity.this, "请先安装好sd卡",
                            Toast.LENGTH_LONG).show();
                }
                mCameraDialog.dismiss();
            }
        });
        root.findViewById(R.id.btn_choose_img).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick (View v){
                if (bitmat[tot]!=null) {
                    CDialog.Builder builder = new CDialog.Builder(PhotoActivity.this);
                    builder.setTitle("查 看 大 图");
                    builder.setpp(bitmat[tot]);
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }

                    });



                    builder.create().show();
                    mCameraDialog.dismiss();
                }
            }
        });
        root.findViewById(R.id.btn_cancel).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub

// 验证sd卡是否正确安装：
                mCameraDialog.dismiss();
            }
        });
        mCameraDialog.setContentView(root);
        Window dialogWindow = mCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialogWindow.setWindowAnimations(R.style.dialogstyle); // 添加动画
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = -40; // 新位置Y坐标
        lp.width = (int) getResources().getDisplayMetrics().widthPixels; // 宽度
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT; // 高度
        root.measure(0, 0);
        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mCameraDialog.show();
    }
}