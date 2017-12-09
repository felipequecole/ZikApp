package com.example.frankson.zikapp;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

import static android.app.Activity.RESULT_OK;


public class CampanhaScreen extends Fragment {
    private static final int TIRAR_FOTO = 1;
    private String caminhoFoto;
    private Uri imageURI;
    private ImageView foto;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_campanha_screen, container, false);
        ButterKnife.bind(this,view);
        verifyStoragePermissions(getActivity());
        return view;
    }


    @OnClick(R.id.button_campanha)
    public void AbreCamera(){
        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intentCamera.resolveActivity(getContext().getPackageManager()) != null) {
            caminhoFoto = getActivity().getExternalFilesDir(null) + "/" + System.currentTimeMillis() + ".jpg";
            File arquivoFoto = new File(caminhoFoto);
            imageURI = FileProvider.getUriForFile(getContext(),"com.example.frankson.provider",arquivoFoto);
            intentCamera.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, imageURI);
            startActivityForResult(intentCamera, TIRAR_FOTO);
        }else {
            Toast toast = Toast.makeText(getContext(), "Impossível abrir o recurso", Toast.LENGTH_LONG);
            toast.show();
        }

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ContentResolver cr = getContext().getContentResolver();
        if (requestCode == TIRAR_FOTO && resultCode == RESULT_OK){
            Bitmap imageBitmap = null;
            Bitmap toFile = null;
            try {
                imageBitmap = MediaStore.Images.Media.getBitmap(cr, imageURI);
                toFile = inserirMarcaDagua(imageBitmap);
                File saida = new File(caminhoFoto);
                if (saida.exists()) {
                    if(saida.delete()){
                        Log.d("Salvar", "apagou");
                    }
                }
//                if (MediaStore.Images.Media.insertImage(getContext().getContentResolver(), toFile,
//                        "Campanha_"+System.currentTimeMillis() + ".jpg", "Imagem gerada pelo ZikApp") != null) {
//                    Log.d("Imagem", "salvou");
//                } else {
//                    Log.d("Imagem", "deu ruim");
//                }
                String mano = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + "/caralho_" + System.currentTimeMillis() + ".jpg";
                File fout = new File(mano);
                fout.createNewFile();
                FileOutputStream out = new FileOutputStream(fout);
                toFile.compress(Bitmap.CompressFormat.JPEG, 50, out);
                out.flush();
                out.close();
                if (MediaStore.Images.Media.insertImage(getContext().getContentResolver(), mano, "ImagemZikapp.jpg", "imagem do app") != null){
                    Log.d("Imagem", "Salvou sera");
                } else {
                    Log.d("Imagem", "desiste mermao");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            Toasty.success(getContext(), "Imagem Salva na galeria! :)").show();
        }
    }


    private Bitmap inserirMarcaDagua(Bitmap image){
        int altura = image.getHeight();
        int largura = image.getWidth();

        Bitmap marca = BitmapFactory.decodeResource(getResources(), R.drawable.marcadagua);
        int marca_largura = marca.getHeight();

        Bitmap resultado = Bitmap.createBitmap(largura, altura, image.getConfig());
        Canvas canvas = new Canvas(resultado);
        canvas.drawBitmap(image, 0, 0, null);
        canvas.drawBitmap(marca, (largura - marca.getWidth())/2, altura - marca_largura - 20, null);
        return resultado;

    }


    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }




}
