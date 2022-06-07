package com.example.countries.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.Countries.ListesItem
import com.example.countries.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class countryAdapter(private val mList: MutableList<ListesItem>, val context : Context) : RecyclerView.Adapter<countryAdapter.ViewHolder>() {

    private lateinit var mListener : OnItemClickListener

    fun setOnClickListener(listener : OnItemClickListener){mListener = listener }
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_list, parent, false)

        return ViewHolder(view,mListener)
    }
    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, Position: Int) {

//for(x in mList){
        // sets the image to the imageview from our itemHolder class
        /*var bmp : Bitmap = BitmapFactory.decodeByteArray(mList[Position].image,0,mList[Position].image!!.size)
        holder.imageView.setImageBitmap(bmp)*/

        // sets the text to the textview from our itemHolder class
        holder.name.text = mList[Position].name.official
        if (mList[Position].idd.suffixes != null) {
            holder.num.text = mList[Position].idd.root + mList[Position].idd.suffixes[0]
        } else {
            holder.num.text = mList[Position].idd.root
        }
        val picasso =
            Picasso.Builder(context)
                .listener { picasso, uri, exception ->
                    //Toast.makeText(this,exception.message, Toast.LENGTH_LONG).show()
                }
                .build()
        picasso.load(mList[Position].flags.png)
            .centerCrop().fit()
            .into(holder.flag)
    }


    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(ItemView) {
        val name: TextView = itemView.findViewById(R.id.name_country)
        val num: TextView = itemView.findViewById(R.id.num_country)
        val flag: ImageView = itemView.findViewById(R.id.flag)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition) }
        }
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}