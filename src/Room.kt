package proceduralLevelGenerator

import java.io.BufferedReader
import java.io.File
import java.io.InputStream

abstract class Room(val height: Int){
    abstract val file : BufferedReader
    abstract var prevRooms : ArrayList<Room>
    abstract var nextRooms : ArrayList<Room>
}

/*abstract class RoomH1(height: Int) : Room(height) {

}

class ChallengeRoomH1(height: Int) : RoomH1(height){

}*/

abstract class RoomH2(height: Int) : Room(height){

}

/*abstract class Hub(height: Int) : RoomH2(height){

}

class DivideHub(height: Int) : Hub(height) {

}

class JoinHub(height: Int) : Hub(height) {

}*/

class StartRoom(height: Int) : RoomH2(height){
    override val file: BufferedReader = BufferedReader(File("blocks/start.txt").reader())
    override var prevRooms : ArrayList<Room> = ArrayList<Room>()
    override var nextRooms : ArrayList<Room> = ArrayList<Room>()

}

class FinishRoom(height: Int) : RoomH2(height){
    override val file: BufferedReader = BufferedReader(File("blocks/finish.txt").reader())
    override var prevRooms : ArrayList<Room> = ArrayList<Room>()
    override var nextRooms : ArrayList<Room> = ArrayList<Room>()
}

class ChallengeRoomH2(height: Int) : RoomH2(height){
    override val file: BufferedReader = BufferedReader(File("blocks/challenge2/1.txt").reader())
    override var prevRooms : ArrayList<Room> = ArrayList<Room>()
    override var nextRooms : ArrayList<Room> = ArrayList<Room>()
}

