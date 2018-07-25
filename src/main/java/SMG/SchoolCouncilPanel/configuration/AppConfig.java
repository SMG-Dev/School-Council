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
import org.springframework.social.facebook.api.Video;

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
	public GenericRepository<Club> provideClubGenericRepository(SessionFactory sessionFactory) {
		HibernateRepository<Club> repo = new HibernateRepository<>(sessionFactory);
		repo.setEntityClass(Club.class);

		return repo;
	}

	@Bean
	@Autowired
	public GenericRepository<Activity> provideActivityGenericRepository(SessionFactory sessionFactory) {
		HibernateRepository<Activity> repo = new HibernateRepository<>(sessionFactory);
		repo.setEntityClass(Activity.class);

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
