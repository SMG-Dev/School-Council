package SMG.SchoolCouncilPanel.configuration;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import SMG.SchoolCouncilPanel.entities.User;
import SMG.SchoolCouncilPanel.repositories.HibernateRepository;
import SMG.SchoolCouncilPanel.repositories.base.GenericRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http
				.authorizeRequests ()
				.antMatchers ("/", "/home", "/user/login", "/user/register", "/api/**", "/css/**", "/js/**", "/img/**", "/**")
				//.antMatchers ("*")
				.permitAll ()
				.anyRequest ()
				.authenticated ()
				.and ()
				.formLogin ()
				.loginPage ("/user/login")
				.successForwardUrl ("/")
				.permitAll ()
				.and ()
				.logout ()
				.permitAll ();
	}
}
