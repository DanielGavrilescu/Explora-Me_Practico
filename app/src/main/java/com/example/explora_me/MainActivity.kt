package com.example.explora_me

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.explora_me.databinding.ActivityMainBinding
import com.example.explora_me.model.OnClickListener
import com.example.explora_me.model.Sitio
import com.example.explora_me.model.SitioAdapter

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var mBinding: ActivityMainBinding

    private lateinit var mAdapter: SitioAdapter
    private lateinit var mGridLayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnSave.setOnClickListener(){
            val sitio = Sitio(name = mBinding.etNombreLugar.text.toString())
            mAdapter.add(sitio)
        }

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        mAdapter = SitioAdapter(mutableListOf(), this)
        mGridLayout = GridLayoutManager(this, 2)

        mBinding.reciclerView.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayout
            adapter = mAdapter
        }
    }

    /*
    *OnClickListener
    **/

    override fun onCLick(sitio: Sitio) {
        TODO("Not yet implemented")
    }


}