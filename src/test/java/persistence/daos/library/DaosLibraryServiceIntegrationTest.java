package persistence.daos.library;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import persistence.entities.library.Author;
import persistence.entities.library.Book;
import persistence.entities.library.Contact;
import persistence.entities.library.Style;
import persistence.entities.library.Theme;

@Repository
public class DaosLibraryServiceIntegrationTest {
    
    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private StyleDao styleDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private ThemeDao themeDao;

    public void populate(){
        Theme[] themeArray = {new Theme("Acción"), new Theme("Suspense"), new Theme("Drama")};
        themeDao.save(Arrays.asList(themeArray));

        Style[] styleArray = {new Style("Infantil", "Lectura sencilla"), new Style("Especializado", "Expertos de la temática")};
        styleDao.save(Arrays.asList(styleArray));

        Author[] authorArray = {new Author("Jesús", "Ber", new Contact("j@gmail.com", 666666661), styleArray[0]),
                new Author("Cris", "Ber", new Contact("c@gmail.com", 666666662), styleArray[0]),
                new Author("Ana", "Ber", new Contact("a@gmail.com", 666666663), styleArray[1]),
                new Author("Sin", "Ber", new Contact("s@gmail.com", 666666663), styleArray[1])};
        authorDao.save(Arrays.asList(authorArray));

        Book[] bookArray = {new Book("isbn1", "La flauta", Arrays.asList(themeArray[0], themeArray[1]), Arrays.asList(authorArray[0])),
                new Book("isbn2", "La mazorca", Arrays.asList(themeArray[1]), Arrays.asList(authorArray[1], authorArray[2])),
                new Book("isbn3", "El pepino", Arrays.asList(themeArray[0]), Arrays.asList(authorArray[2]))};
        bookDao.save(Arrays.asList(bookArray));
    }
    
    public void deleteAll(){
        bookDao.deleteAll();
        themeDao.deleteAll();
        authorDao.deleteAll();
        styleDao.deleteAll();
    }
}
