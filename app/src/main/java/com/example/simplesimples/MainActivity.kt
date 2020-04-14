package com.example.simplesimples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    E/FirebaseInstanceId: binding to the service failed

    private lateinit var db: FirebaseFirestore
    private lateinit var noteAdapter: NoteRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }


    override fun onStart() {
        super.onStart()

        db = FirebaseFirestore.getInstance()
        var arrayOfItems = ArrayList<MyListItem>()


        val collRef =
            db.collection("UserNotes").document("d0QF8jkWl2oBAywSbt97")
                .collection("UsersNotes")

        collRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                Log.v("Simples", "Listen Failed.", e)
                return@addSnapshotListener
            }


            for (doc in snapshot!!) {

                if (snapshot != null) {

                    val myID = doc.data.getValue("ID").toString()
                    Log.v("Simples", "try and getValue on myID............  $myID")

                    val myNote = doc.data.getValue("Note").toString()
                    Log.v("Simples", "try to getValue on myNote.......... $myNote")

                    val sendNote = MyListItem(myID, myNote)

                    arrayOfItems.add(sendNote)
                }

            }

            noteAdapter.submitList(arrayOfItems)
//            recyclerView.adapter = NoteRecyclerAdapter(arrayOfItems)
//            recyclerView.layoutManager = LinearLayoutManager(this)
//            recyclerView.setHasFixedSize(true)

        }





    }


    private fun initRecyclerView () {

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            noteAdapter = NoteRecyclerAdapter()
            adapter = noteAdapter
            }
        }
}



