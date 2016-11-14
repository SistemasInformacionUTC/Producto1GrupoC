package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.avaje.ebean.Model;
import com.avaje.ebean.PagedList;
import com.avaje.ebean.Model.Find;

import play.data.validation.Constraints;

@Entity
public class Disco extends Model {
	
	 private static final long serialVersiongID = 1L;


@Id
public Long id;

@Constraints.Required
public String name;

@Constraints.Required
public int capacidad;

@Constraints.Required
public int nucleos;
@OneToOne
public Computer computer;

public static Find<Long,Disco> find = new Find<Long,Disco>(){};

}
