/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dom.todo;

import java.util.List;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.NotPersistable;

/**
 *
 * @author chris
 */
@NotPersistable
public class ExecutionPlanChooser {
    
    private ExecutionPlan executionPlan;
    private ToDoItem toDoItem;

    /**
     * Get the value of toDoItem
     *
     * @return the value of toDoItem
     */
    public ToDoItem getToDoItem() {
        return toDoItem;
    }

    /**
     * Set the value of toDoItem
     *
     * @param toDoItem new value of toDoItem
     */
    public void setToDoItem(ToDoItem toDoItem) {
        this.toDoItem = toDoItem;
    }


    public ExecutionPlan getExecutionPlan() {
        return executionPlan;
    }

    public void setExecutionPlan(ExecutionPlan executionPlan) {
        this.executionPlan = executionPlan;
    }
    
    public List<ExecutionPlan> choicesExecutionPlan(){
	return eps.getExecutionPlans(toDoItem);
    }
    
    public void doIt(){
        ExecutionPlan ep = container.newTransientInstance(ExecutionPlan.class);
        for (Task t: executionPlan.getTasks()) {
            //container.persistIfNotAlready(t);
            ep.addTask(t);
        }
        ep.setInUse(true);
        ep.setName(executionPlan.getName());
        container.persistIfNotAlready(ep);
        toDoItem.setExecutionPlan(ep);
//        toDoItem.setExecutionPlan(executionPlan);
        
        //return toDoItem;
    }
    
//    public String disableDoIt(){
//        return (executionPlan != null) ? null : "execution plan not set";
//    }

    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }
    private ExecutionPlanService eps;
    public void setExecutionPlanService(ExecutionPlanService eps){
	this.eps = eps;
    }
}
