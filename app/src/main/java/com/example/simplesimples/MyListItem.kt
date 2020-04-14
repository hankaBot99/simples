package com.example.simplesimples

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class MyListItem (var _id: String?, var _note: String?) {

    constructor() : this("","")
}
