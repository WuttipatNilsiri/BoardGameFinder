package com.example.g501vw.boardgamefinder2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.create_main.*

class CreateActivity : AppCompatActivity() {

    var sv = ServerDemo.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_main)

        create.setOnClickListener { view ->

            var name = in_name.text.toString()
            var detail = in_detail.text.toString()
            var num = Integer.parseInt(in_numplayer.text.toString())
            var time = in_time.text.toString()
            var data = GameBoardData(name,1,num,time)
            var nickname = in_nickname.text.toString()
            data.addMember(nickname)
            data.addDetial(detail)

            sv.add(name+time,data)
            val intent = Intent(this@CreateActivity, MainActivity::class.java)

            startActivity(intent)
            finish()

        }
        cancel.setOnClickListener{ view ->
            finish()
        }

    }

}