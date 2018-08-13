package com.hand.infra.mapper;


import com.hand.domain.entity.Film;
import com.hand.domain.entity.Page;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface FilmMapper extends Mapper<Film> {

    List<Film> getAllFilm(Page page);

}