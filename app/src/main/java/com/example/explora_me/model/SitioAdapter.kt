package com.example.explora_me.model

import android.content.ClipData.Item
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.explora_me.R
import com.example.explora_me.databinding.ItemsBinding

class SitioAdapter (
    private var sitio: MutableList<Sitio>,
    private var listener: OnClickListener
) : RecyclerView.Adapter<SitioAdapter.ViewHolder>(){

    private lateinit var mContext : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context

        val view = LayoutInflater.from(mContext).inflate(R.layout.items, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = sitio.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sitio = sitio.get(position)

        with(holder){
            setListener(sitio)
            binding.tvName.text = sitio.name
        }
    }

    fun add( sitioAñadir: Sitio) {
       sitio.add(sitioAñadir)
        notifyDataSetChanged()

    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemsBinding.bind(view)

        fun setListener(sitio: Sitio){
            binding.root.setOnClickListener{listener.onCLick(sitio)}
        }
    }
}