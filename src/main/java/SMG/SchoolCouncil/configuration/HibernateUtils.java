package SMG.SchoolCouncilPanel.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import SMG.SchoolCouncilPanel.entities.*;

public class HibernateUtils {
	static final SessionFactory sessionFactory;

	static {
		org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration()
				.configure();

		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Course.class);
		configuration.addAnnotatedClass(Track.class);
		configuration.addAnnotatedClass(Video.class);
		configuration.addAnnotatedClass(Comment.class);

		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

		serviceRegistryBuilder.applySettings(configuration.getProperties());
		StandardServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}