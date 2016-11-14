package models;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Constraint;

import play.data.validation.Constraints;

import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Find;

/**
 * Computer entity managed by Ebean
 */
@Entity
public class Ram extends Model {
private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	@Constraints.Required
	public String name;
	
	@Constraints.Required
	public Integer tamano;
	
	@Constraints.Required
	public Integer pines;
	
	@OneToOne
    public Ram ram;
	
	 public static Find<Long,Ram> find = new Find<Long,Ram>(){};
	 
	
}
