package com.example.g501vw.boardgamefinder2

class ServerDemo{

    private object Holder { val INSTANCE = ServerDemo() }
    var mapData = HashMap<String,GameBoardData>()


    companion object Factory {
        fun getInstance(): ServerDemo = Holder.INSTANCE
    }


    fun add(id:String,data : GameBoardData) {
        mapData.put(id,data)
    }

    fun remove(id:String ){
        mapData.remove(id)
    }



    fun getList() : ArrayList<GameBoardData> {
        var listToReturn = ArrayList<GameBoardData>()
        listToReturn.addAll(mapData.values)
        return  listToReturn
    }
}