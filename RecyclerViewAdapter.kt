package com.example.recyapp
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(var hospitalsList: ArrayList<Hospitals>?, var itemClick: hospitalClickListener) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
    override fun getItemCount(): Int {
        return hospitalsList!!.size
    }

    interface hospitalClickListener {
        fun getItem(position: Int)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bindData(hospitalsList, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerViewHolder {
        var view: View = LayoutInflater.from(parent!!.context).inflate(R.layout.item_list, parent, false)
        return RecyclerViewHolder(view, itemClick)
    }

        class RecyclerViewHolder(itemView: View, var itemClick: hospitalClickListener) : RecyclerView.ViewHolder(itemView) {
//    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textName: TextView = itemView.findViewById(R.id.text_name)
        var textAddress: TextView = itemView.findViewById(R.id.text_address)
        fun bindData(hospitalsList: ArrayList<Hospitals>?, position: Int) {
            textName.text = hospitalsList!!.get(position).hospitalName
            textAddress.text = hospitalsList!!.get(position).address
            itemView.setOnClickListener(View.OnClickListener {
                itemClick.getItem(adapterPosition)
            })
        }
    }
}
