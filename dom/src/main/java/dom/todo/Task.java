package dom.todo;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;


/**
 *
 * @author chris
 */
@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY)
@javax.jdo.annotations.Version(strategy=VersionStrategy.VERSION_NUMBER, column="VERSION")
public class Task{

    private String what;

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }
    private String where;

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }
}
