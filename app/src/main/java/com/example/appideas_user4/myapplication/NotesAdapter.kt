package com.example.appideas_user4.myapplication

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * Created by appideas-user4 on 25/4/18.
 */
class  NotesAdapter : BaseAdapter {

    private var notesList = ArrayList<Note>()
    private var context: Context? = null

    constructor(context: Context, notesList: ArrayList<Note>) : super() {
        this.notesList = notesList
        this.context = context
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        val view: View?
        val vh: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.note, parent, false);
            vh = ViewHolder(view)
            view.tag = vh
            Log.i("JSA", "set Tag for ViewHolder, position: " + position)
        } else {
            view = convertView
            vh = view.tag as ViewHolder
        }

        vh.tvTitle.text = notesList[position].title
        vh.tvContent.text = Html.fromHtml(notesList[position].content)
        vh.ivDelete.setOnClickListener {
            //removeee(position)
            val intent = Intent(context, CameraActivity::class.java)
            context!!.startActivity(intent)
            // your code to perform when the user clicks on the TextView
            Toast.makeText(context, "You clicked on TextView 'Click Me'.", Toast.LENGTH_SHORT).show()
        }
        return view
    }

    private fun removeee(position: Int) {
        notesList.remove(notesList.get(position))
        notifyDataSetChanged()
    }


    override fun getItem(position: Int): Any {
        return notesList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return notesList.size
    }
}

private class ViewHolder(view: View?) {
    val tvTitle: TextView
    val tvContent: TextView
    val ivDelete: ImageView

    init {
        this.tvTitle = view?.findViewById<TextView>(R.id.tvTitle) as TextView
        this.tvContent =view?.findViewById<TextView>(R.id.tvContent) as TextView
        this.ivDelete =view?.findViewById<ImageView>(R.id.ivDelete) as ImageView
    }

    //  if you target API 26, you should change to:
//        init {
//            this.tvTitle = view?.findViewById<TextView>(R.id.tvTitle) as TextView
//            this.tvContent = view?.findViewById<TextView>(R.id.tvContent) as TextView
//        }
}
