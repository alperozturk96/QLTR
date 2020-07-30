package com.example.tureng2.Sub_Core;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapLabel;
import com.example.tureng2.Core.HomeScreen;
import com.example.tureng2.R;

public class TimeCasesExampleA2 extends Fragment {

    private BootstrapButton showNextInfo;
    private TextView info,info2;
    private BootstrapLabel header;
    private int infoNumber = 0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_timecases_example_a2,container,false);

        try {
            showNextInfo = view.findViewById(R.id.btn_timecases_next);
            info = view.findViewById(R.id.info_timecases);
            info2 = view.findViewById(R.id.info_timecases2);
            header = view.findViewById(R.id.header_timecases);


            showNextInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(infoNumber == 0)
                    {
                        header.setText("Geniş Zaman (-r; -ar/-er/; -ır/-ir/-ur/-ür)");
                        info.setText("Geniş zaman kipi geçmişten geleceğe uzanan geniş bir zaman kesimindeki oluş ve kılışları içine alır. Fiil kök ve gövdelerine “-r” ekinin getirilmesiyle yapılır. Ünsüzle biten, tek ve çok heceli kelimelerin durumuna göre bu ek “-er, ar; -ır,-ir,-ur,-ür” biçimlerini alır.");
                        info2.setText("Örnek Cümle: \n\n Şimdi yiğidi atar, yıkar, yere serer, delik deşik eder.");
                        infoNumber++;
                    }
                    else if(infoNumber == 1)
                    {
                        header.setText("Şimdiki Zaman (-yor)");
                        info.setText("Fiilin söylendiği anda yapılmakta olduğunu bildirir. Fiilin yapılışı ile anlatım aynı anda gerçekleşmektedir. “-makta, -mekte” ve ‘‘-mada, -mede” ekleri de cümleye şimdiki zaman anlamı katar. Olumsuzu -ma, -me eki ile yapılır.");
                        info2.setText("Örnek Cümleler: \n\n Gördüler ki namus için durmuyor. \n Anlamıyorum dilinden artık. \n .Ders çalışmaktayım.");
                        infoNumber++;
                    }
                    else if(infoNumber == 2)
                    {
                        header.setText("Gelecek Zaman (-ecek, -acak)");
                        info.setText("Fiilin gelecek zamanda yapılacağını bildirir. Anlatım önce, fiil sonra gerçekleşir.");
                        info2.setText("Örnek Cümleler: \n\n Canavarların sultanı aslandır, onunla da oyun göstersin, kızı ondan sonra vereceğim. \n Onların övgülerine inanmayacak, hayallerini hele hiç anlamayacak.");
                        infoNumber++;
                    }
                    else if(infoNumber == 3)
                    {
                        header.setText("Di’li Geçmiş Zaman (Görülen / Bilinen Geçmiş Zaman) (-di, -dı, -du, -dü, -ti, -tı, -tu, -tü)");
                        info.setText("Fiilin söylenme anından önce yapıldığını bildirir. Anlatan kişinin, fiilin yapılışını gördüğünü ya da bildiğini ifade eder. Olumsuzu “-ma, -me” eki ile yapılır.");
                        info2.setText("Örnek Cümleler: \n\n Babasının, anasının ellerini öptü.\n Aylar geçti ama hâlâ evine dönmedi");
                        infoNumber++;
                    }
                    else if(infoNumber == 4)
                    {
                        header.setText("Miş’li Geçmiş Zaman (Öğrenilen / Duyulan Geçmiş Zaman) (-miş, -mış, -muş, -müş)");
                        info.setText("Fiilin söylenme anından önce yapıldığını bildirir. Anlatan kişinin, fiilin yapılışını başkasından duyduğunu, öğrendiğini ifade eder. Olumsuzu “-ma, -me” eki ile yapılır.");
                        info2.setText("Örnek Cümleler: \n\n Karşı yatan kara dağını aşmağa gelmişim.\n Galiba buralara şimdiye kadar hiç bozucu bir insan eli değmemiş");
                        infoNumber++;
                    }
                    else if(infoNumber == 5)
                    {
                        header.setVisibility(View.GONE);
                        info.setVisibility(View.GONE);
                        info2.setVisibility(View.GONE);
                        showNextInfo.setText("Ana Menü");
                    }
                    else if(infoNumber == 6)
                    {
                        Intent intent = new Intent(view.getContext(), HomeScreen.class);
                        startActivity(intent);
                    }
                }
            });
        }
        catch (Exception e)
        {
            Log.e("SubCore/TimeCasesA2","OnCreate Exception", e);
        }
        return view;
    }

}
