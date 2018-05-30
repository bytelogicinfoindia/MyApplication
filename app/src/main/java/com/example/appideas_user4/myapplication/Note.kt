package com.example.appideas_user4.myapplication

/**
 * Created by appideas-user4 on 25/4/18.
 */
class Note {
    var id: Int? = null
    var title: String? = null
    var content: String? = null

    constructor(id: Int, title: String, content: String) {
        this.id = id
        this.title = title
        this.content = content
    }
}