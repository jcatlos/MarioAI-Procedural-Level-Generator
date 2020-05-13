package proceduralLevelGenerator

const val LEVEL_HEIGHT = 16

class Level(length: Int){
    val firstRoom : StartRoom = StartRoom(16)
    val lastRoom : FinishRoom = FinishRoom(16)

    //Layer first implementation
    var rooms = ArrayList<ArrayList<Room>>()

    init {
        println("starting initialization")
        var room : RoomH2 = firstRoom
        for (i in 0 until length){
            val new_room: RoomH2 = ChallengeRoomH2(16)
            room.nextRooms.add(new_room)
            new_room.prevRooms.add(room)
            room = new_room
        }
        room.nextRooms.add(lastRoom)
        lastRoom.prevRooms.add(room)
        println("finishing initialization")
    }

    fun generateMap() : String{
        println("starting generation")
        var level : Array<StringBuilder> = Array<StringBuilder>(size = LEVEL_HEIGHT, init =  {StringBuilder()})
        /*for(i in 0 until LEVEL_HEIGHT){
            var room : Room = firstRoom
            var j = 0
            while(room != lastRoom){
                level[i].append(room.file.readLine())
                room = rooms[++j][0]
            }
            level[i].append(lastRoom.file.readLine())
        }*/
        //var room : Room = firstRoom
        var current = ArrayList<Room>()
        current.add(firstRoom)
        var next = ArrayList<Room>()
        while(current.isNotEmpty() || next.isNotEmpty()){
            var i = 0
            var roomCounter = 0
            //Adding current layer to level
            while(roomCounter<current.size){
                //Adding neighbors to next
                for(i in 0 until current[roomCounter].nextRooms.size){
                    next.add(current[roomCounter].nextRooms[i])
                }
                //Adding room to level
                val old_i = i
                while(i-old_i < current[roomCounter].height){
                    level[i].append(current[roomCounter].file.readLine())
                    i++
                }
                roomCounter++
            }
            current.clear()
            current.addAll(next)
            next.clear()
        }

        // Making the final string
        var levelStr : StringBuilder = StringBuilder()
        for(row in level){
            levelStr.append(row)
            levelStr.append("\n")
        }
        return levelStr.toString()
    }
}