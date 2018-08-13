package com.hand.api.controller;

import com.hand.api.service.FilmService;
import com.hand.domain.entity.Film;
import com.hand.domain.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @RequestMapping(value = "/getAllFilm", method = RequestMethod.GET)
    public List<Film> getAllFilm(Page page) {
        List<Film> filmList = null;
        try {
            filmList = filmService.getAllFilm(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filmList;
    }
}
