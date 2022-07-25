package com.mladenjovicic.portfolio.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mladenjovicic.portfolio.Data.Model.DB.SubCollectionTreeDBModel
import com.mladenjovicic.portfolio.R
import com.mladenjovicic.portfolio.ui.vase.VaseActivity

class VaseAdapter: RecyclerView.Adapter<VaseAdapter.MyViewHolder>() {


    private var vaseList:List<SubCollectionTreeDBModel>?=null
    fun setVaseList(vaseList: List<SubCollectionTreeDBModel>){
        this.vaseList = vaseList
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaseAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_vase, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: VaseAdapter.MyViewHolder, position: Int) {

        holder.bind(vaseList?.get(position)!!)

        holder.itemView.setOnClickListener {
            if(holder.rowVase != null){
                val intent = Intent(holder.rowVase.context, VaseActivity::class.java)
                intent.putExtra("vaseId", vaseList!![position].serverId)
                holder.rowVase.context.startActivity(intent)
            }else{
                val intent = Intent(holder.textViewRowVase?.context, VaseActivity::class.java)
                intent.putExtra("vaseId", vaseList!![position].serverId)
                holder.textViewRowVase?.context!!.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        if(vaseList == null)return 0
        else return vaseList?.size!!
    }
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val rowVase = itemView.findViewById<LinearLayout>(R.id.rowVase)
        val textViewRowVase = itemView.findViewById<TextView>(R.id.textViewRowVase)

        fun bind(data:SubCollectionTreeDBModel){
            textViewRowVase.text = data.name
        }
    }
}