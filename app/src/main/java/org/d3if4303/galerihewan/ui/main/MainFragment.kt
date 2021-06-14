package org.d3if4303.galerihewan.ui.main

import android.graphics.drawable.DrawableContainer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if4303.galerihewan.Hewan
import org.d3if4303.galerihewan.R
import org.d3if4303.galerihewan.databinding.FragmentMainBinding
import java.util.zip.Inflater


class MainFragment : Fragment() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private lateinit var binding:FragmentMainBinding
    private lateinit var myAdapter: MainAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                          savedInstanceState: Bundle?): View? {
        //setContentView(R.layout.activity_main)

        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        myAdapter = MainAdapter()
        //setContentView(binding.root)

        //Log.d("MainActivity", "Jumlah data: " + getData().size)
        with(binding.recyclerView) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            //adapter = MainAdapter(getData())
            adapter = myAdapter
            setHasFixedSize(true)
        }
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getData().observe(viewLifecycleOwner, {
            myAdapter.updateData(it)
        })
    }

    //private fun getData(): List<Hewan>{
        //return listOf(
            //Hewan("Angsa", "Cynus olor", R.drawable.angsa),
            //Hewan("Ayam", "Gallus gallus", R.drawable.ayam),
            //Hewan("Bebek", "Cairina moschata", R.drawable.bebek),
            //Hewan("Domba", "Ovis", R.drawable.domba),
            //Hewan("Kalkun", "Meleagris gallopavo", R.drawable.kalkun),
            //Hewan("Kambing", "Capricornis sumatrensis", R.drawable.kambing),
            //Hewan("Kelinci", "Oryctolagus cuniculus", R.drawable.kelinci),
            //Hewan("Kerbau", "Bubalus bubalis", R.drawable.kerbau),
            //Hewan("Kuda", "Equus caballus", R.drawable.kuda),
            //Hewan("Sapi", "Bos taurus", R.drawable.sapi),
        //)
    //}
}