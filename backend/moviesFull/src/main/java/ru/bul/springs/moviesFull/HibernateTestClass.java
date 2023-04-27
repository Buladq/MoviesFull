package ru.bul.springs.moviesFull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.bul.springs.moviesFull.models.Backdrop;
import ru.bul.springs.moviesFull.models.Genre;
import ru.bul.springs.moviesFull.models.Movie;
import ru.bul.springs.moviesFull.models.Review;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HibernateTestClass {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Genre.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Backdrop.class);
        SessionFactory sessionFactory=configuration.buildSessionFactory();

        try(sessionFactory) {
            LocalDate localDate=LocalDate.now();
            Session session=sessionFactory.getCurrentSession();
            session.beginTransaction();



            Query q=session.createQuery("from Movie");
            List<Movie> movies=q.list();
            for (var i:
                 movies) {
                System.out.println();
                System.out.println();
                System.out.println(i);
                System.out.println();
            }

//            List<Genre> genreList=new ArrayList<>();
//
//            for (int i = 2; i <=11 ; i++) {
//                Genre genre=session.get(Genre.class,i);
//                genreList.add(genre);
//            }

//            Movie movie=session.get(Movie.class,8093700);
//            System.out.println(movie);
//
//            movie.setGenreList(List.of(genreList.get(1),genreList.get(8),genreList.get(9)));
//            session.update(movie);




            ////переход к листам
//
//
//
//            List<String> listLinks=List.of("https://image.tmdb.org/t/p/original/gkseI3CUfQtMKX41XD4AxDzhQb7.jpg",
//                    "https://image.tmdb.org/t/p/original/wSILunFEbvw00Ql2aaMHCSZf3cI.jpg",
//                    "https://image.tmdb.org/t/p/original/xTsERrOCW15OIYl5aPX7Jbj38wu.jpg",
//                    "https://image.tmdb.org/t/p/original/j06sSrtbqnZdSgG6yEduao95y48.jpg",
//                    "https://image.tmdb.org/t/p/original/v4YV4ne1nwNni35iz4WmpZRZpCD.jpg",
//                    "https://image.tmdb.org/t/p/original/6n5ln1vWGD3JyT6Ibt7ZxjSxY3v.jpg",
//                    "https://image.tmdb.org/t/p/original/gi47WUUYVQWaLE5mJraS87ycdy6.jpg",
//                    "https://image.tmdb.org/t/p/original/dTQOU5a32K3UPTIXHgipEqN41OM.jpg",
//                    "https://image.tmdb.org/t/p/original/7zQJYV02yehWrQN6NjKsBorqUUS.jpg",
//                    "https://image.tmdb.org/t/p/original/rdDL4y7BxGyXFEDJgAG4lz89bG2.jpg");
//
//            for (var i:
//                 listLinks) {
//                Backdrop backdrop=new Backdrop(i,movie);
//                session.save(backdrop);
//            }
//










//            movie.setGenreList(new ArrayList<>(List.of(genre1,genre2)));
//
//            session.update(movie);



            session.getTransaction().commit();
        }
    }

}
