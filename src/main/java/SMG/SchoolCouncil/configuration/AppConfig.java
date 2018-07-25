package SMG.SchoolCouncilPanel.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import SMG.SchoolCouncilPanel.entities.*;
import SMG.SchoolCouncilPanel.repositories.HibernateRepository;
import SMG.SchoolCouncilPanel.repositories.base.GenericRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

	@Bean
	public SessionFactory provideSessionFactory() {
		return HibernateUtils.getSessionFactory();
	}

	@Bean
	@Autowired
	public GenericRepository<User> provideUsersGenericRepository(SessionFactory sessionFactory) {
		HibernateRepository<User> repo = new HibernateRepository<>(sessionFactory);
		repo.setEntityClass(User.class);

		return repo;
	}

	@Bean
	@Autowired
	public GenericRepository<Course> provideCoursesGenericRepository(SessionFactory sessionFactory) {
		HibernateRepository<Course> repo = new HibernateRepository<>(sessionFactory);
		repo.setEntityClass(Course.class);

		return repo;
	}

	@Bean
	@Autowired
	public GenericRepository<Track> provideTracksGenericRepository(SessionFactory sessionFactory) {
		HibernateRepository<Track> repo = new HibernateRepository<>(sessionFactory);
		repo.setEntityClass(Track.class);

		return repo;
	}

	@Bean
	@Autowired
	public GenericRepository<Video> provideVideosGenericRepository(SessionFactory sessionFactory) {
		HibernateRepository<Video> repo = new HibernateRepository<>(sessionFactory);
		repo.setEntityClass(Video.class);

		return repo;
	}

	@Bean
	@Autowired
	public GenericRepository<Comment> provideCpmmentGenericRepository(SessionFactory sessionFactory) {
		HibernateRepository<Comment> repo = new HibernateRepository<>(sessionFactory);
		repo.setEntityClass(Comment.class);

		return repo;
	}

	private static PasswordEncoder passEncoder;

	static {
		passEncoder = new BCryptPasswordEncoder ();
	}

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return passEncoder;
	}
}
