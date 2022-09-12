package com.example.challange_chapter3

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_huruf.*

class Huruf : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_huruf, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hurufToolbar.setTitle("Words")

        val huruf = arrayListOf(
            ListHuruf("A"),
            ListHuruf("B"),
            ListHuruf("C"),
            ListHuruf("D"),
            ListHuruf("E"),
            ListHuruf("F"),
            ListHuruf("G"),
            ListHuruf("H"),
            ListHuruf("I"),
            ListHuruf("J"),
            ListHuruf("K"),
            ListHuruf("L"),
            ListHuruf("M"),
            ListHuruf("N"),
            ListHuruf("O"),
            ListHuruf("P"),
            ListHuruf("Q"),
            ListHuruf("R"),
            ListHuruf("S"),
            ListHuruf("T"),
            ListHuruf("U"),
            ListHuruf("V"),
            ListHuruf("W"),
            ListHuruf("X"),
            ListHuruf("Y"),
            ListHuruf("Z")
        )

        val adapterHuruf = Huruf_adapter(huruf)
        val lm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvKata.layoutManager = lm
        rvKata.adapter = adapterHuruf

        adapterHuruf.onClick = {
//            val fragmentKalimat = Kalimat()
//            val bundle = Bundle()
//            val frmanager = fragmentManager
//            val fragmentTransaction = frmanager?.beginTransaction();
//            bundle.putString("huruf", huruf.toString());
//            fragmentKalimat.setArguments(bundle);
//            fragmentTransaction?.replace(R.id.fcFragment,fragmentKalimat);
//            fragmentTransaction?.commit();
//
            val fragment = Kalimat()
            val bund = Bundle()
            bund.putSerializable("dataHuruf", it)
            fragment.arguments = bund
            fragmentManager?.beginTransaction()?.replace(R.id.fcFragment, fragment)?.commit()

        }
        gridIcon.setOnClickListener{
            val adapterHuruf = Huruf_adapter(huruf)
            val lm = GridLayoutManager(context,2)
            rvKata.layoutManager = lm
            rvKata.adapter = adapterHuruf
            adapterHuruf.onClick = {
                val fragment = Kalimat()
                val bund = Bundle()
                bund.putSerializable("dataHuruf", it)
                fragment.arguments = bund
                fragmentManager?.beginTransaction()?.replace(R.id.fcFragment, fragment)?.commit()
            }
            gridIcon.setOnClickListener{
                val frHuruf = Huruf()
                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fcFragment, frHuruf)?.commit()
            }
        }






    }

}
