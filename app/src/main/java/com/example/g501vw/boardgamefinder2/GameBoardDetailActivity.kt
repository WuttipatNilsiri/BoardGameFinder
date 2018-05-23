package com.example.g501vw.boardgamefinder2


import android.content.Intent
import android.os.Bundle

import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import android.widget.*

import kotlinx.android.synthetic.main.detail_main.*
import java.util.ArrayList

class GameBoardDetailActivity : AppCompatActivity() {

    var sv = ServerDemo.getInstance()


    var list : ArrayList<String> = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_main)

        var listView : ListView = findViewById(R.id.LSnameView)



        var listApdter : ArrayAdapter<String> = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list)

        listView.setAdapter(listApdter);

        val bundle =  intent.extras;

        val name = bundle!!.getString("name")
        val detail = bundle!!.getString("detail")
        val maxplayer = bundle!!.getInt("max")
        var currplayer = bundle!!.getInt("curr")
        val time = bundle!!.getString("time")
        var listname  = bundle!!.getStringArrayList("nameList")

        list.clear()
        list.addAll(listname)
        listApdter.notifyDataSetChanged()



        var nameView : TextView = findViewById(R.id.name)
        var detailView : TextView = findViewById(R.id.detail)
        var numPView : TextView = findViewById(R.id.numplayer)

        nameView.setText(name+"("+time+")")
        detailView.setText(detail)
        numPView.setText(String.format("#Player = %d/%d",currplayer,maxplayer))


        cancel.setOnClickListener { view ->
            val intent = Intent(this@GameBoardDetailActivity, MainActivity::class.java)
            startActivity(intent)

        }

        if (maxplayer == currplayer){
            join.isEnabled = false
        }

        join.setOnClickListener { view ->
            currplayer = currplayer + 1
            var data = GameBoardData(name,currplayer,maxplayer,time)
            var ls2add = ArrayList<String>()
            ls2add.addAll(listname)
            var nameP = in_nickname.text.toString()
            ls2add.add(nameP)
            data.addDetial(detail)
            data.addList(ls2add)
//            sv.remove(name+time)
            listname = ls2add
            sv.add(name+time,data)
            numPView.setText(String.format("#Player = %d/%d",currplayer,maxplayer))
            list.add(nameP)
            listApdter.notifyDataSetChanged()
            if (maxplayer == currplayer){
                join.isEnabled = false
            }

//            val intent = Intent(this@GameBoardDetailActivity, MainActivity::class.java)
////            intent.putExtra("from","create")
////            intent.putExtra("name",name)
////            intent.putExtra("detail",detail)
////            intent.putExtra("num",num)
//            startActivity(intent)


        }

    }


}

