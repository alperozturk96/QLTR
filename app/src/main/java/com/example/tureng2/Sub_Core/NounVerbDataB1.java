package com.example.tureng2.Sub_Core;

import java.util.ArrayList;

class NounVerbDataB1 {

    private String noun;

    String getNouns() {
        return noun;
    }

    private void setNouns(String nouns) {
        this.noun = nouns;
    }

    public static ArrayList<NounVerbDataB1> getData(boolean choose)
    {
        int i = 0;

        ArrayList<NounVerbDataB1> dataB1 = new ArrayList<NounVerbDataB1>();
        String[] nouns = {"abone" , "acil" , "adım" , "araç" , "arıza" , "bedel" , "bilek" , "borç" , "boru" , "büyüklük" , "büyüleyici" , "civar" , "çöp" , "davranış" , "deneyim" , "depozito" ,
                "doğalgaz" , "döşeme" , "durum" , "eğitim" , "emlak" , "endişeli" , "etki" , "evlilik" , "fatura" , "fiyat" , "fonksiyon" , "garip" , "günlük" , "güvenlik" , "halat" , "ham" , "ısıtma" ,
                "ıslak" , "içerik" , "ihtiyaç" , "ilan" , "imdat" , "iş bölümü" , "işlem" , "jandarma" , "kaban" , "kanat" , "kiralık" , "kombi" , "konum" , "koza" , "lavabo" ,
                "lüks" , "manzara" , "masrafsız" , "mevki" , "muhit" , "müstakil" , "nezih" , "ödeme" , "ömür" , "özellik" , "pazarlık" , "pil" , "sahip" , "satır" , "satış" , "sızıntı" ,
                "sigorta" , "sözleşme" , "şofben" , "tarife" , "taşınma" , "temel" , "tesisatçı" , "tuhaf" , "tüketim" , "ulaşım" , "uygun" , "uyum" , "vali" , "vana" , "vergi" ,
                "yakınlık" , "yapışık" , "yuva" , "zam"};

        String[] verbs = {"acele etmek" , "akıtmak" , "atıştırmak" , "ayırmak" , "basmak" , "benzemek" , "boşaltmak" , "bozulmak" , "değerlendirmek" , "dikkat çekmek" , "doldurmak" , "eğmek" , "fışkırmak" ,
                "harcamak" , "ısınmak" , "ilerletmek" , "karşılaşmak" , "kopmak" , "kurtulmak" , "önermek" , "patlamak" , "sığmak" , "sıkışmak" , "sızdırmak" , "söndürmek" , "takip etmek" , "tartışmak" ,
                "telaşlanmak" , "tercih etmek" , "teslim etmek" , "tıkanmak" , "uğraşmak" , "yadırgamak" , "yansıtmak" , "yardımcı olmak" , "yığmak" , "zenginleşmek"};

        NounVerbDataB1 nvd1 = null;

        if (!choose)
        {
            nouns = verbs;
        }

        for (i = 0; i < nouns.length; i++)
        {
            nvd1 = new NounVerbDataB1();

            nvd1.setNouns(nouns[i]);

            dataB1.add(nvd1);
        }

        return dataB1;
    }

}
