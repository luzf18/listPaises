package com.example.mylist.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mylist.model.Pais
import com.example.mylist.utils.Contants.Constants.ALEMANHA
import com.example.mylist.utils.Contants.Constants.BRASIL
import com.example.mylist.utils.Contants.Constants.CHINA
import com.example.mylist.utils.Contants.Constants.DINAMARCA
import com.example.mylist.utils.Contants.Constants.ESTADOSUNIDOS
import com.example.mylist.utils.Contants.Constants.FRANCA
import com.example.mylist.utils.Contants.Constants.GRECIA
import com.example.mylist.utils.Contants.Constants.HOLANDA
import com.example.mylist.utils.Contants.Constants.IRLANDA
import com.example.mylist.utils.Contants.Constants.JAPAO
import com.example.mylist.utils.Contants.Constants.KOSOVO
import com.example.mylist.utils.Contants.Constants.LIBANO
import com.example.mylist.utils.Contants.Constants.MALDIVAS
import com.example.mylist.utils.Contants.Constants.NIGERIA
import com.example.mylist.utils.Contants.Constants.OMA
import com.example.mylist.utils.Contants.Constants.PORTUGAL
import com.example.mylist.utils.Contants.Constants.QATAR
import com.example.mylist.utils.Contants.Constants.RUSSIA
import com.example.mylist.utils.Contants.Constants.SANMARINO
import com.example.mylist.utils.Contants.Constants.TURQUIA
import com.example.mylist.utils.Contants.Constants.UCRANIA
import com.example.mylist.utils.Contants.Constants.VENEZUELA
import com.example.mylist.utils.Contants.Constants.ZAMBIA

class MainViewModel : ViewModel() {
    var listener: MainListener? = null

    val list: MutableLiveData<List<Pais>> = MutableLiveData()

    fun initViewModel() {
        list.postValue(
            listOf(
                Pais(ALEMANHA, "HB: 82,02 Milhões", "CP: Berlim"),
                Pais(BRASIL, "HB: 209,5 Milhões", "CP: Brasilia"),
                Pais(CHINA, "HB: 1,393 Bilhões", "CP: Pequim"),
                Pais(DINAMARCA, "HB: 5,806 Milhões", "CP: Copenhage"),
                Pais(ESTADOSUNIDOS, "HB: 328,2 Milhões", "CP: Washington D.C"),
                Pais(FRANCA, "HB: 66,99 Milhões", "CP: Paris"),
                Pais(GRECIA, "HB: 10,72 Milhões", "CP: Atenas"),
                Pais(HOLANDA, "HB: 17,28 Milhões", "CP: Amsterdã"),
                Pais(IRLANDA, "HB: 4,904 Milhões", "CP: Dublin"),
                Pais(JAPAO, "HB: 126,05 Milhões", "CP: Tóquio"),
                Pais(KOSOVO, "HB: 1,845 Milhão", "CP: Pristina"),
                Pais(LIBANO, "HB: 6,849 Milhões", "CP: Beirute"),
                Pais(MALDIVAS, "HB: 513,696 Milhões", "CP: Malé"),
                Pais(NIGERIA, "HB: 195,9 Milhões", "CP: Abuja"),
                Pais(OMA, "HB: 4,829 Milhões", "CP: Mascate"),
                Pais(PORTUGAL, "HB: 10,28 Milhões", "CP: Lisboa"),
                Pais(QATAR, "HB: 2,782 Milhões", "CP: Daha"),
                Pais(RUSSIA, "HB: 144,5 Milhões", "CP: Moscou"),
                Pais(SANMARINO, "HB: 33,785 Milhões", "CP: San Marino"),
                Pais(TURQUIA, "HB: 82 Milhões", "CP: Ancara"),
                Pais(UCRANIA, "HB: 41,98 Milhões", "CP: Kiev"),
                Pais(VENEZUELA, "HB: 28,87 Milhões", "CP: Caracas"),
                Pais(ZAMBIA, "HB: 17,35 Milhões", "CP: Lusaka")
            )
        )
        listener!!.onSetList()
        listener!!.onSearch()
    }
}
