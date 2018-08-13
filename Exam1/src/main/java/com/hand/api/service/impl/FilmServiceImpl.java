package com.hand.api.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.api.service.FilmService;
import com.hand.domain.entity.Film;
import com.hand.domain.entity.Page;
import com.hand.infra.mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmMapper filmMapper;

    @Override
    public List<Film> getAllFilm(Page page) throws Exception {

        PageHelper.startPage(page.getPage(),page.getPageSize());
        return filmMapper.getAllFilm(page);
    }

}
