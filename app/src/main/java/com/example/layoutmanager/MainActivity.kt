package com.example.layoutmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)


        val usernames = arrayOf("Harsha D J", "Harshavardhan", "Dheeraj","Mithun S R","Jishnu Katta","Krishna kart","Mattam pavan","Mithun C","Hrithik")
        val messages = arrayOf("I am in USA", "I am directing movie", "Eld sari baribeku","Laali Laalo","Amen jesusu","Al bagdaadhi","seeing virat","......","writing assgn..")
        val timestamps = arrayOf("Yesterday", "Today", "Just Now","Yesterday","Today","Yesterday","Yesterday","Today","Yesterday")
        val profileImages = arrayOf(R.drawable.harsha, R.drawable.harshavardhar, R.drawable.dheeraj,R.drawable.profile,R.drawable.profile,R.drawable.profile,R.drawable.profile,R.drawable.profile,R.drawable.profile) // Add images as needed


        val items = ArrayList<ChatItem>()
        for (i in usernames.indices) {
            items.add(ChatItem(profileImages[i], usernames[i], messages[i], timestamps[i]))
        }


        val adapter = ChatAdapter(this, items)
        listView.adapter = adapter
    }
}


data class ChatItem(val profileImage: Int, val username: String, val message: String, val timestamp: String)


class ChatAdapter(private val context: AppCompatActivity, private val items: ArrayList<ChatItem>) : ArrayAdapter<ChatItem>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val item = getItem(position) ?: return convertView ?: View(context)
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.whatsapp_item, parent, false)


        val profileImage: ImageView = view.findViewById(R.id.profile_image)
        val username: TextView = view.findViewById(R.id.username)
        val message: TextView = view.findViewById(R.id.message)
        val timestamp: TextView = view.findViewById(R.id.timestamp)

        profileImage.setImageResource(item.profileImage)
        username.text = item.username
        message.text = item.message
        timestamp.text = item.timestamp

        return view
    }
}