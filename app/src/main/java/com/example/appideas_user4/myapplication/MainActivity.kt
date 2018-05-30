package com.example.appideas_user4.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private var listNotes = ArrayList<Note>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        request("https://en.wikipedia.org/w/api.php?action=query&format=json&list=search&srsearch=Trump");

      /*  listNotes.add(Note(1, "JavaSampleApproach", "Java technology, Spring Framework - approach to Java by Sample."))
        listNotes.add(Note(2, "Kotlin Android Tutorial", "Create tutorial for people to learn Kotlin Android. Kotlin is now an official language on Android. It's expressive, concise, and powerful. Best of all, it's interoperable with our existing Android languages and runtime."))
        listNotes.add(Note(3, "Android Studio", "Android Studio 3.0 provides helpful tools to help you start using Kotlin. Convert entire Java files or convert code snippets on the fly when you paste Java code into a Kotlin file."))
        listNotes.add(Note(4, "Java Android Tutorial", "Create tutorial for people to learn Java Android. Learn Java in a greatly improved learning environment with more lessons, real practice opportunity, and community support."))
        listNotes.add(Note(5, "Spring Boot Tutorial", "Spring Boot help build stand-alone, production Spring Applications easily, less configuration then rapidly start new projects."))
    */

    }
    private fun request(url: String) {
                val queue = Volley.newRequestQueue(this)
                val request = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener<JSONObject> { response ->

                    val jsonObject = response.getString("batchcomplete")
                    val continue1 = response.getJSONObject("continue")
                    val query = response.getJSONObject("query")
                    val  searchinfo=query.getJSONObject("searchinfo")
                    val  search=query.getJSONArray("search")

                    for (i in 0 until search.length())
                    { val obj = search.getJSONObject(i)
                        val ns = obj.getInt("ns")
                        val title = obj.get("title").toString()
                        val pageid = obj.get("pageid").toString()
                        val size = obj.get("size").toString()
                        val wordcount = obj.get("wordcount").toString()
                        val snippet = obj.get("snippet").toString()
                        val timestamp = obj.get("timestamp").toString()

                        listNotes.add(Note(ns,title,snippet))

                        System.out.println("VolleyResponce"+snippet)
                    }
                    val lv = findViewById<ListView>(R.id.lvNotes) as ListView
                    lv.adapter = NotesAdapter(this, listNotes);

                   // newsRecyclerView.adapter = NewsAdapter(news)*/
                },
                Response.ErrorListener {
                    Toast.makeText(this, "That didn't work!", Toast.LENGTH_SHORT).show()
                })

        queue.add(request)
    }
}



