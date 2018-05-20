package com.example.g501vw.boardgamefinder2

class GameBoardData {
    var name : String
    var maxPlayer : Int
    var currPlayer : Int
    var detial : String
    var time : String
    lateinit var nameList : ArrayList<String>

    constructor(name: String,currPlayer : Int,numberPlayer : Int,time:String){
        this.name = name
        this.maxPlayer = numberPlayer
        this.detial = ""
        this.time = time
        this.currPlayer = currPlayer
        nameList = ArrayList<String>()

    }

    override fun toString() : String {
        return name + "("+time+")"+ " #Player = " + String.format("%d/%d",currPlayer,maxPlayer)
    }

    fun addDetial(sss : String) {
        detial = sss;
    }



    override fun equals(other: Any?): Boolean {
        if (other is GameBoardData){
            var data : GameBoardData = other as GameBoardData
            return name.equals(data.name) and time.equals(data.time)
        }

        return false
    }

    fun addList(list : ArrayList<String>){
        nameList.clear()
        nameList.addAll(list)
    }

    fun addMember(name : String) {
        nameList.add(name)
    }



}