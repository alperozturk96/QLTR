package com.example.tureng2.Sub_Core;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.example.tureng2.Core.Grammar;
import com.example.tureng2.MediaPlayer.MPAs;
import com.example.tureng2.R;

public class AlphabetA1 extends MPAs {


    private BootstrapButton refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        TypefaceProvider.registerDefaultIconSets();

        refresh = findViewById(R.id.refresh);

        if (isConnected()) {
            refresh.setVisibility(View.INVISIBLE);
            list_all_letters();
        }
    }


    public void list_all_letters() {

        final String[] addressList = {"https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fa.wav?alt=media&token=16a71c20-acaa-4515-92e5-04e75cd45e92"
                , "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fb.wav?alt=media&token=a1d84fac-fbd9-4130-af91-f2d91d4e0e7d"
                , "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fc.wav?alt=media&token=1b258633-82ab-4f6e-858f-0bf327ce8048"
                , "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2F%C3%A7.wav?alt=media&token=0ecc1072-8c1e-4fa3-84d1-8215809eee97",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fd.wav?alt=media&token=219b6834-3bfc-421c-bb16-4e39b6d9dabe",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fe.wav?alt=media&token=b5a5fd4e-7540-457c-a09b-d29e5fc51887",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Ff.wav?alt=media&token=418e3ecd-2875-4a0e-9df8-cc478637a799",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fg.wav?alt=media&token=473ac6bd-d69f-47be-90a7-e1b6d4b82f4e",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2F%C4%9F.wav?alt=media&token=7fc9db0d-b712-41eb-8c22-97d4d655fda9",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fh.wav?alt=media&token=a670e885-84ed-469e-8589-bdab730902b4",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2F%C4%B1.wav?alt=media&token=65a704eb-488b-48ce-9188-ad96e517d9da",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fi.wav?alt=media&token=dbef9955-ded4-4177-91f0-632cbcd877ac",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fj.wav?alt=media&token=cba5ae5b-b1c4-4ff0-beeb-40a5ab94c20b",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fk.wav?alt=media&token=ae8608d6-c3fc-4420-a822-19b0c9072a9c",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fl.wav?alt=media&token=16a005f6-a75f-4fbb-9fae-fc8ffcd907d9",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fm.wav?alt=media&token=300f4e59-7814-4ac9-b717-734d59ea310a",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fn.wav?alt=media&token=b81c9642-f570-4fc5-91d9-5a8fbac59385",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fo.wav?alt=media&token=4fe9c830-c146-40de-9908-23f72286766f",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2F%C3%B6.wav?alt=media&token=eb42bbc3-3d0c-4f5b-a088-7a2ddcf31bc2",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fp.wav?alt=media&token=c572120d-1ddb-4c22-8611-303c982a4b9a",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fr.wav?alt=media&token=a3f8e8b4-76da-4013-bb81-304c63be5136",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fs.wav?alt=media&token=4715c79b-cd26-4bc8-9587-093add5c2087",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2F%C5%9F.wav?alt=media&token=b96c9363-fb11-4818-a257-cf0d5c42f467",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Ft.wav?alt=media&token=3953f4bd-e457-47b5-bbdd-7e57aa3a4dfb",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fu.wav?alt=media&token=d5cbb593-ee15-4a6d-948a-e03960c426bd",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2F%C3%BC.wav?alt=media&token=0ae936aa-d34b-4ca1-9245-b47e9fcbe0b2",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fv.wav?alt=media&token=68f0baac-4d24-42f4-b3c2-e54e9ef41d98",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fy.wav?alt=media&token=743a0ea7-dcb3-4ada-a2e8-c2f7345bc0e2",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Alphabet%2Fz.wav?alt=media&token=47437966-83ed-4501-bbf3-438327bed05a",
        };


        String[] headerList = {"Aa", "Bb", "Cc", "Çç", "Dd", "Ee", "Ff", "Gg", "Ğğ", "Hh", "Iı", "İi", "Jj", "Kk", "Ll", "Mm", "Nn", "Oo", "Öö", "Pp", "Rr", "Ss",
                "Şş", "Tt", "Uu", "Üü", "Vv", "Yy", "Zz"};

        createListView(R.id.letters, addressList, headerList);
    }

    public void sampleWords(View view) {
        Intent intent = new Intent(this, Grammar.class);
        startActivity(intent);
    }
}
