package com.sideki.telegramclone.utilites

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class AppValuewEventListener (val onSuccess:(DataSnapshot) -> Unit):ValueEventListener{
    override fun onDataChange(snapshot: DataSnapshot) {
        onSuccess(snapshot)
    }

    override fun onCancelled(error: DatabaseError) {
        TODO("Not yet implemented")
    }
}