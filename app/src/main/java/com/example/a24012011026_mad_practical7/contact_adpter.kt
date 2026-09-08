package com.example.a24012011026_mad_practical7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Contact_adpter(val contactlist: Array<Contact>):
    RecyclerView.Adapter<Contact_adpter.ContactViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactViewHolder {
        val iteamview = LayoutInflater.from(parent.context).
        inflate(R.layout.single_item , parent , false)
        return ContactViewHolder(iteamview)

    }

    override fun onBindViewHolder(
        holder: ContactViewHolder,
        position: Int
    ) {
        val contact = contactlist[position]
        holder.tvcontactname.text = contact.name
        holder.tvcontactphone.text = contact.phone
        holder.tvcontactemail.text = contact.email
        holder.tvcontactaddress.text = contact.address
    }

    override fun getItemCount(): Int {
        return contactlist.size
    }

    class ContactViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvcontactname : TextView = itemView.findViewById<TextView>(R.id.textview1)
        val tvcontactphone : TextView = itemView.findViewById<TextView>(R.id.textview2)

        val tvcontactemail : TextView = itemView.findViewById<TextView>(R.id.textview3)

        val tvcontactaddress : TextView = itemView.findViewById<TextView>(R.id.textview4)
    }
}
