package com.example.simplesimples

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_view_record.view.*

//class NoteRecyclerAdapter(var items: List<MyListItem>) : RecyclerView.Adapter<NoteRecyclerAdapter.NoteViewHolder>() {

class NoteRecyclerAdapter: RecyclerView.Adapter<NoteRecyclerAdapter.NoteViewHolder>() {

     var items: ArrayList<MyListItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_view_record,
           parent, false)

        return NoteViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        when(holder) {

            is NoteViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        Log.v ("Simples", "get Item Count")
        return items.size
    }

    fun submitList(notesList: ArrayList<MyListItem>){
        items = notesList
    }

    class NoteViewHolder (
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {

        private val theID: TextView = itemView.idText
        private val theNote: TextView = itemView.noteText

        fun bind (noteList: MyListItem) {
            theID.text = noteList._id
            theNote.text = noteList._note

        }
    }
}