package models;

import play.*;
import play.data.format.Formats;
import play.data.validation.Constraints;
import javax.persistence.*;

import com.avaje.ebean.Model;
import com.avaje.ebean.PagedList;
import com.avaje.ebean.Model.Find;

import java.util.*;

@Entity
public class Monitor extends Model {
	
	private static final long serialVersionUID = 1L;

	@Id
    public Long id;
    
    @Constraints.Required
    public String name;
    
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date introduced;
    
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date discontinued;
    
    @Constraints.Required
    public int pulgadas;
    
    @Constraints.Required
    public int peso;
    
    @ManyToOne
    public Computer computer;

  public static Find<Long,Monitor> find = new Find<Long,Monitor>(){};
    
    /**
     * Return a paged list of computer
     *
     * @param page Page to display
     * @param pageSize Number of computers per page
     * @param sortBy Computer property used for sorting
     * @param order Sort order (either or asc or desc)
     * @param filter Filter applied on the name column
     */
    public static PagedList<Monitor> page(int page, int pageSize, String sortBy, String order, String filter) {
        return
            find.where()
                .ilike("name", "%" + filter + "%")
                .orderBy(sortBy + " " + order)
                .fetch("computer")
                .findPagedList(page, pageSize);
    }
    
}

