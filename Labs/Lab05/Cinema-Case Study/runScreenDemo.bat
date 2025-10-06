javac -d out src\Seat.java src\SeatID.java src\Screen.java src\Cinema.java
javac -cp out ScreenDemo.java
java -cp out;. ScreenDemo