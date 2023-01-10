package com.example.mvvmkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmkotlin.R
import com.example.mvvmkotlin.data.CountryItem

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.countryItemViewHolder>() {

    private var countrylist = ArrayList<CountryItem>()

    fun setCountryList(countryList_loc:ArrayList<CountryItem>){
            this.countrylist=countryList_loc
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): countryItemViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.country_list_row,parent,false)
        return countryItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: countryItemViewHolder, position: Int) {
            holder.bindData(countrylist.get(position),holder)
    }

    override fun getItemCount(): Int {
        return countrylist.size
    }

    class countryItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flagImage = itemView.findViewById<ImageView>(R.id.flagImage)
        val tvname = itemView.findViewById<TextView>(R.id.tvName)
        val tvCapital = itemView.findViewById<TextView>(R.id.tvCapital)
        val tvRegion = itemView.findViewById<TextView>(R.id.tvRegion)

        fun bindData(countryItem: CountryItem,holder: countryItemViewHolder){
            tvname.text = countryItem!!.name + " " + countryItem!!.alpha2Code
            tvCapital.text = "Capital " + countryItem.capital
            tvRegion.text = "Region " + countryItem.region
            Glide.with(holder.itemView)
                .load(countryItem.flags?.png)
                .into(flagImage)
        }
    }
}