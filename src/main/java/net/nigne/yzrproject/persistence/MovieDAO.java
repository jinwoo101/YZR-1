package net.nigne.yzrproject.persistence;

import java.util.List;

import net.nigne.yzrproject.domain.ActorVO;
import net.nigne.yzrproject.domain.DirectorVO;
import net.nigne.yzrproject.domain.GenreVO;
import net.nigne.yzrproject.domain.GpaVO;
import net.nigne.yzrproject.domain.MovieVO;
import net.nigne.yzrproject.domain.ReservationVO;

public interface MovieDAO {
	public MovieVO getMovie(String movie_id);
	
	public List<MovieVO> genreMovie(String member_id);		// ��õ�帣��ȭ���
	public List<MovieVO> actorMovie(String member_id);		// ��õ��쿵ȭ���
	public List<MovieVO> directorMovie(String member_id);	// ��õ������ȭ���
	public List<MovieVO> basicMovie();						// �⺻��ȭ��õ���
	
	public List<MovieVO> getMovieChart(String play, String order);	// ������Ʈ
	public List<MovieVO> getMovieSchedule();	// �󿵿�����
	
	public MovieVO getList(String movie_id);
	public List<ActorVO> getActor(String movie_id);
	public List<DirectorVO> getDirector(String movie_id);
	public GpaVO getGpa(String movie_id);	
	public void gpaUpdate(String movie_id, int acting, int direction, int beauty, int ost, int story, int male,
			int female, int teenager, int twenties, int thirties, int forties) throws Exception;
	public List<GenreVO> getGenre(String movie_id);
	
	public List<MovieVO> getMovieList(String order);	// ��������, �����ټ�
	public List<MovieVO> getMovieId(String movieName);	// ������̵� ��������
	
	public void addViewer(String movieId, int viewer);
	public void updateReservationRate(MovieVO vo, float reservationRate);

	public List<MovieVO> getPlayMovieList();
	
	public long getMovieCnt();
	
	
}
