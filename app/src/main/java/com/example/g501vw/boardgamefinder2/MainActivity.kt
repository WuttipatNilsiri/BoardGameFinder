package com.example.g501vw.boardgamefinder2

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.*

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.create_main.*
import kotlinx.android.synthetic.main.detail_main.*
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.content.Intent
import android.os.Parcelable
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import java.util.*


class MainActivity : AppCompatActivity() {

    var list : ArrayList<GameBoardData> = ArrayList<GameBoardData>()



    var sv = ServerDemo.getInstance()

//    var state : Parcelable? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)







        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        var listView : ListView = findViewById(R.id.GameBListView)

        var listApdter : ArrayAdapter<GameBoardData> = ArrayAdapter<GameBoardData>(this,android.R.layout.simple_list_item_1,list)


//        if(state != null) {
//            listView.onRestoreInstanceState(state)
//            state = null
//        }



        listView.setAdapter(listApdter);



//        val bundle =  intent.extras;
//        val from = bundle!!.getString("from")
//
//        if (from.equals("create")){
//            val name = bundle!!.getString("name")
//            val detail = bundle!!.getString("detail")
//            val numplayer = bundle!!.getInt("num")
//            var createdData = GameBoardData(name,numplayer)
//            createdData.addDetial(detail)
//            list.add(createdData)
//            listApdter.notifyDataSetChanged()
//        }
        list.clear()
        list.addAll(sv.getList())
        listApdter.notifyDataSetChanged()





        listView.setOnItemClickListener { parent: AdapterView<*>, view, position: Int,id: Long ->

            var state = listView.onSaveInstanceState()
            val intent = Intent(this@MainActivity, GameBoardDetailActivity::class.java)
            var data = list.get(position);

            intent.putExtra("name", data.name)
            intent.putExtra("detail", data.detial)
            intent.putExtra("max", data.maxPlayer)
            intent.putExtra("curr",data.currPlayer)
            intent.putExtra("time",data.time)
            intent.putExtra("nameList",data.nameList)
            startActivity(intent)

        }



        fab.setOnClickListener { view ->

            val intent = Intent(this@MainActivity, CreateActivity::class.java)
            startActivity(intent)


//            var createdData = GameBoardData("Fuck User",4)
//            list.add(createdData)
//            listApdter.notifyDataSetChanged()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }




}
