package com.example.countries.adapters
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.R

class languageAdapter(private val mList: MutableList<String>) : RecyclerView.Adapter<languageAdapter.ViewHolder>() {

    private lateinit var mListener : OnItemClickListener

    fun setOnClickListener(listener : OnItemClickListener){mListener = listener }
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.language_items, parent, false)

        return ViewHolder(view,mListener)
    }
    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, Position: Int) {

//for(x in mList){
        // sets the image to the imageview from our itemHolder class
        /*var bmp : Bitmap = BitmapFactory.decodeByteArray(mList[Position].image,0,mList[Position].image!!.size)
        holder.imageView.setImageBitmap(bmp)*/

        // sets the text to the textview from our itemHolder class
        holder.textlang.text = mList[Position]
       }




    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(ItemView) {
        val textlang: TextView = itemView.findViewById(R.id.lang_items)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition) }
        }
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}
