package SMG.SchoolCouncilPanel.repositories.base;

import SMG.SchoolCouncilPanel.entities.base.Entity;

import java.util.List;

public interface GenericRepository<T extends Entity> {
	List<T> getAll ();

	List<T> getBy (String field, Object value);

	T create (T entity);
}