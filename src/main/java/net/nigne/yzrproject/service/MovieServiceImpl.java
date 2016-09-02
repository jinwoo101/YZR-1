package net.nigne.yzrproject.service;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.domain.DirectorVO;
import net.nigne.yzrproject.domain.GenreVO;
import net.nigne.yzrproject.domain.GpaVO;
import net.nigne.yzrproject.domain.MovieVO;
import net.nigne.yzrproject.domain.ReservationVO;
import net.nigne.yzrproject.persistence.MovieDAO;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieDAO dao;
	
	@Transactional(readOnly=true)
	@Override
	public MovieVO getMovie(String movie_id) {
		return dao.getMovie(movie_id);
	}

	@Transactional(readOnly=true)
	@Override
	public List<MovieVO> genreMovie(String member_id) {
		return dao.genreMovie(member_id);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<MovieVO> actorMovie(String member_id) {
		return dao.actorMovie(member_id);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<MovieVO> directorMovie(String member_id) {
		return dao.directorMovie(member_id);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<MovieVO> basicMovie() {
		return dao.basicMovie();
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<MovieVO> getMovieChart(String play, String order) {
		return dao.getMovieChart(play, order);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<MovieVO> getMovieSchedule() {
		return dao.getMovieSchedule();
	}
	

	@Transactional(readOnly = true)
	@Override
	public MovieVO getList(String movie_id) {
		// TODO Auto-generated method stub
		return dao.getList(movie_id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ActorVO> getActor(String movie_id) {
		// TODO Auto-generated method stub
		return dao.getActor(movie_id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<DirectorVO> getDirector(String movie_id) {
		// TODO Auto-generated method stub
		return dao.getDirector(movie_id);
	}

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public GpaVO getGpa(String movie_id) {
		return dao.getGpa(movie_id);
	}

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public void gpaUpdate(String movie_id, int acting, int direction, int beauty, int ost, int story, int male,
			int female, int teenager, int twenties, int thirties, int forties) throws Exception {
		dao.gpaUpdate(movie_id, acting, direction, beauty, ost, story, male, female, teenager, twenties, thirties,
				forties);
	}
	
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public List<GenreVO> getGenre(String movie_id) {
		// TODO Auto-generated method stub
		return dao.getGenre(movie_id);
	}

	@Override
	public List<MovieVO> getMovieList(String order) {
		// TODO Auto-generated method stub
		return dao.getMovieList(order);
	}

	@Override
	public List<MovieVO> getMovieId(String movieName) {
		// TODO Auto-generated method stub
		return dao.getMovieId(movieName);
	}

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public void addViewer(String movieId, int viewer) {
		// TODO Auto-generated method stub
		dao.addViewer(movieId, viewer);
	}

	@Override
	public long getMovieCnt() {
		// TODO Auto-generated method stub
		return dao.getMovieCnt();
	}

	@Override
	public List<MovieVO> getPlayMovieList() {
		// TODO Auto-generated method stub
		return dao.getPlayMovieList();
	}

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public void updateReservationRate(MovieVO vo, float reservationRate) {
		// TODO Auto-generated method stub
		float transformRate = digitNumber(reservationRate);
		dao.updateReservationRate(vo, transformRate);
	}
	
	private float digitNumber(float reservationRate) {
		DecimalFormat form = new DecimalFormat("#.#");
		float transformRate = Float.parseFloat(form.format(reservationRate));
		return transformRate;
	}

}
