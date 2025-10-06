javac -d out src\Cinema.java src\Screen.java src\Seat.java src\CityCinema.java src\SeatID.java
javac -cp out CinemaDemo.java
java -cp out;. CinemaDemo