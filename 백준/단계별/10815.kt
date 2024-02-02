fun main(): Unit = with(System.`in`.bufferedReader()){
    val N = readLine().toInt()
    val map = mutableMapOf<Int,Int>()
    readLine().split(" ").map{
        it.toInt()
        map.put(it.toInt(),1)
    }
    val M = readLine().toInt()
    readLine().split(" ").map{
        if(map.containsKey(it.toInt())) print("1 ") else print("0 ")
    }

}
