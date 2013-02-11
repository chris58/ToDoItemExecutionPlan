package dom.todo;

import java.util.ArrayList;
import java.util.List;
import org.apache.isis.applib.AbstractService;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.filter.Filter;

public class ExecutionPlanService extends AbstractService{
    private final String where[] = {"Grocery Store", "Farm", "The Pasture"};
    private final String what[] = {"go there", "milk the cow", "pay for the milk"};
    static int runs = 0;
    
    @Hidden
    public List<ExecutionPlan> getExecutionPlans(ToDoItem td) {
        List<ExecutionPlan> l;

        System.out.println("--------------------getExecutionPlans called again " + runs++ + " --------");
        
//     this method is called many times, so deleting
//     the unwanted execution plans was an idea.
//     But isis crashes at another place
//        
//        while ((l = findAllUnused()) != null && l.size() > 0)
//            remove(l.get(0));
        
        l = new ArrayList<ExecutionPlan>();
        for (int j = 0; j < 3; j++) {
            ExecutionPlan ep = newTransientInstance(ExecutionPlan.class);
            ep.setName(runs + "/" + j + " execution plan");
            for (int i = 0; i < 3; i++) {
                Task t = newTransientInstance(Task.class);
                
                t.setWhat(what[i]);
                t.setWhere(where[j]);
                t = persist(t);
                ep.addTask(t);
            }
            ep = persist(ep);
            l.add(ep);
        }

        // If returning the list l, isis crashes
        // therefore this
        return findAllUnused();
        
        //return l;
    }

    public List<ExecutionPlan> findAllUnused(){
        return allMatches(ExecutionPlan.class, new Filter<ExecutionPlan>() {
            @Override
            public boolean accept(final ExecutionPlan t) {
                return !t.isInUse();
            }

        });
       
    }
    
}