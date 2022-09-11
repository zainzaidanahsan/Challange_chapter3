package com.example.challange_chapter3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_huruf.*
import kotlinx.android.synthetic.main.fragment_kalimat.*

class Kalimat : Fragment() {
    lateinit var kata : ArrayList<ListHuruf>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kalimat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        var zbundle = Bundle()
//        zbundle = requireArguments()
//        zbundle.getString("huruf")
//
//        var getHuruf = arguments?.getString("huruf")
//
//        val args = this.arguments
//        val inputData = args?.get("dataHuruf")


        val hrf = arguments?.getSerializable("dataHuruf") as ListHuruf
        val getHuruf = hrf.huruf

        txtJudul.text = "Words That Starts With $getHuruf"

        backIcon.setOnClickListener{
            var pindah = Intent(context,MainActivity::class.java)
            startActivity(pindah)
        }

        when(getHuruf){
            "A" -> {
                kata = arrayListOf(
                    ListHuruf("Ayam"),
                    ListHuruf("Asam"),
                    ListHuruf("Anjungan")
                )
            }
            "B" ->{
                kata = arrayListOf(
                    ListHuruf("Babi"),
                    ListHuruf("Bayam"),
                    ListHuruf("Bison")
                )
            }
            "C"->{
                kata = arrayListOf(
                    ListHuruf("Cacing"),
                    ListHuruf("Cocok"),
                    ListHuruf("City")
                )
            }
            "D"->{
                kata= arrayListOf(
                    ListHuruf("Dandang"),
                    ListHuruf("Dada"),
                    ListHuruf("DKI")
                )
            }
            "E"->{
                kata = arrayListOf(
                    ListHuruf("Entog"),
                    ListHuruf("E-money"),
                    ListHuruf("Elang")
                )
            }
            "F"->{
                kata = arrayListOf(
                    ListHuruf("Fanta"),
                    ListHuruf("Figura"),
                    ListHuruf("Fogging")
                )
            }
            "G" ->{
                kata = arrayListOf(
                    ListHuruf("Game"),
                    ListHuruf("Gajah"),
                    ListHuruf("Gara")
                )
            }
            "H"->{
                kata = arrayListOf(
                    ListHuruf("Hijau"),
                    ListHuruf("Hanjuang"),
                    ListHuruf("Hukum")
                )
            }
            "I"->{
                kata = arrayListOf(
                    ListHuruf("Ikan"),
                    ListHuruf("Insang"),
                    ListHuruf("Ilham")
                )
            }
            "J"->{
                kata = arrayListOf(
                    ListHuruf("Jomblo"),
                    ListHuruf("Joglo"),
                    ListHuruf("Jogja")
                )
            }
        }
        val adapterKata = Kalimat_adapter(kata)
        val lm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvKalimat.layoutManager = lm
        rvKalimat.adapter = adapterKata

        adapterKata.onClick = {
            val getHuruf = it.huruf
            val pindah = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=$getHuruf"))
            startActivity(pindah)
        }


    }
}