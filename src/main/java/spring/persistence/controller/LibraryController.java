package spring.persistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.persistence.daos.LibraryRepository;
import spring.persistence.daos.library.AuthorDao;
import spring.persistence.daos.library.BookDao;
import spring.persistence.daos.library.StyleDao;

@Controller
public class LibraryController {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private StyleDao styleDao;

    @Autowired
    private BookDao bookDao;

    public void process() {
        libraryRepository.populate();

        System.out.println(">>>> Books:  " + bookDao.findAll());

        System.out.println(">>>> Authores del estilo: Infantil");
        System.out.println("     " + authorDao.findByStyle(styleDao.findByNameIgnoreCase("Infantil")));

        System.out.println(">>>> Nombre de Authores a partir del nombre del estilo: infantil");
        System.out.println("     " + authorDao.findName("Infantil"));

        System.out.println(">>>> Nombre de Authores que tienen algun libro");
        System.out.println("     " + authorDao.findNameByAnyBook());

        System.out.println(">>>> Nombre de Authores que tienen algun libro con el nombre de tema: Acción");
        System.out.println("     " + authorDao.findNameByThemeName("Acción"));
        
        libraryRepository.deleteAll();

    }
}
