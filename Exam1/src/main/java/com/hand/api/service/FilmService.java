package com.hand.api.service;

import com.hand.domain.entity.Film;
import com.hand.domain.entity.Page;

import java.util.List;
import java.util.Map;

public interface FilmService {

    List<Film> getAllFilm(Page page) throws Exception;
}
