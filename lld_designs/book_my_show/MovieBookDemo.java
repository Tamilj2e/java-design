package lld_designs.book_my_show;

import lld_designs.book_my_show.models.*;
import lld_designs.book_my_show.models.enums.PaymentMode;
import lld_designs.book_my_show.models.enums.SeatStatus;
import lld_designs.book_my_show.models.enums.SeatType;
import lld_designs.book_my_show.repository.MovieRepository;
import lld_designs.book_my_show.repository.TheaterRepository;
import lld_designs.book_my_show.repository.UserRepo;
import lld_designs.book_my_show.service.BookingService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovieBookDemo {


    public static void main(String[] args) {
        BookingService bookingService = BookingService.getInstance();
        MovieRepository movieRepo = new MovieRepository();
        TheaterRepository theatersRepo = new TheaterRepository();
        UserRepo userRepo = new UserRepo();

        Movie m1 = new Movie("Avatar", Duration.ofMinutes(180));
        Movie m2 = new Movie("Spiderman", Duration.ofMinutes(150));
        Movie m3 = new Movie("Batman", Duration.ofMinutes(130));

        movieRepo.add(m1);
        movieRepo.add(m2);
        movieRepo.add(m3);

        Seat s1 = new Seat(1,1, SeatType.SILVER);
        Seat s2 = new Seat(2,2, SeatType.SILVER);
        Seat s3 = new Seat(3,2, SeatType.GOLD);
        Seat s4 = new Seat(4,1, SeatType.PLATINUM);
        List<Seat> seatList = new ArrayList<>();
        seatList.add(s1);
        seatList.add(s2);
        seatList.add(s3);
        seatList.add(s4);





        List<ShowSeat> showSeats = new ArrayList<>();
        for(var seat:seatList){
            ShowSeat s = new ShowSeat(seat,LocalDateTime.of(2026,8,17,8,30));
            s.setStatus(SeatStatus.AVAILABLE);
            showSeats.add(s);
        }
        Screen screen1= new Screen(1,seatList,"IMAX");
        Screen screen2 = new Screen(1,seatList,"IMAX");
        Show show1 = new Show(m1,screen1, LocalDateTime.of(2026,8,17,8,30),showSeats,120);
        Show show2 = new Show(m2,screen2, LocalDateTime.of(2026,8,17,8,30),showSeats,120);

        List<Show> showList = new ArrayList<>();
        showList.add(show1);
        showList.add(show2);


        screen1.setShowList(showList);
        screen2.setShowList(showList);
        List<Screen> screenList = List.of(screen2,screen1);


        theatersRepo.add(new Theater(screenList,"PVR","POLLACHI"));
        theatersRepo.add(new Theater(screenList,"durais","POLLACHI"));


        User user = new User("abc123","Tamil","abc@gmail.com","97424");
        userRepo.add(user);


        Booking booking =bookingService.bookShow(show1,showSeats.subList(0,1), PaymentMode.UPI,user,true).orElse(null);

        System.out.println(booking);



    }
}
