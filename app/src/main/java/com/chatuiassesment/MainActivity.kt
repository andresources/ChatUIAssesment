package com.chatuiassesment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.apolis45.chatuidemo.adatpers.ChatAdapter
import com.chatuiassesment.data.InComingImageMsg
import com.chatuiassesment.data.InComingMsg
import com.chatuiassesment.data.OutGoingMsg
import com.chatuiassesment.databinding.ActivityMainBinding
import com.chatuiassesment.viewholders.OutMsgViewHolder

class MainActivity : AppCompatActivity() {
    val messages = mutableListOf<Any>(
        InComingMsg("Rahul", "Hi", "12:30 PM",R.drawable.w1),
        InComingMsg("Gita", "Hello Everyone", "12:31 PM",R.drawable.i2),
        OutGoingMsg("Hey! Everyone!", "12:32 PM"),
        InComingMsg("Group Admin", "We are going to held the meeting today at 4:30 PM", "12:34",R.drawable.img2),
        InComingMsg("Group Admin", "All are request to be in time", "12:35",R.drawable.img2),
        OutGoingMsg("What is the agenda of meeting", "12:40 pm"),
        InComingImageMsg("Gita", R.drawable.im_tower, "12:31 PM",R.drawable.i2)
    )
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = ChatAdapter(messages)
        binding.rvChat.adapter = adapter
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition
                    messages.removeAt(position)
                    adapter.notifyItemRemoved(position)
                    Toast.makeText(this@MainActivity, "Deleted", Toast.LENGTH_SHORT).show()
            }

        }).attachToRecyclerView(binding.rvChat)
    }
}