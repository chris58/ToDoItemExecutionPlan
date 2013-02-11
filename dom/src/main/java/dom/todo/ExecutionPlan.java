package dom.todo;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.Title;

/**
 *
 * @author chris
 */
//@Hidden
@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY)
@javax.jdo.annotations.Version(strategy=VersionStrategy.VERSION_NUMBER, column="VERSION")
public class ExecutionPlan {
    private String name;
    private boolean inUse = false;
    
    public boolean isInUse(){
        return inUse;
    }
    public void setInUse(boolean inUse){
        this.inUse = inUse;
    }
    
    public ExecutionPlan(){
        System.out.println("Allocating new ExecutionPlan");
    }
    public String title() {
        return name;
    }
    
    @Hidden
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    private List<Task> tasks = new ArrayList<Task>();

    @Hidden
    public void addTask(Task task){
        getTasks().add(task);
    }
    
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        System.out.println("Setting tasks " + tasks);
        this.tasks = tasks;
    }
}
