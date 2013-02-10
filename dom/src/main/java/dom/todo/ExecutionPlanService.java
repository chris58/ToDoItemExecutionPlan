package dom.todo;


import java.util.ArrayList;
import java.util.List;
import org.apache.isis.applib.AbstractService;

public class ExecutionPlanService extends AbstractService{
    private final String where[] = {"Post office", "Woolworth", "Aldi"};
    private final String what[] = {"buy stamps", "talk to the clerk", "get some beer"};

    public List<ExecutionPlan> getExecutionPlans(ToDoItem td) {
        List<ExecutionPlan> l;
        System.out.println("--------------------getExecutionPlans called again--------");
        
        l = new ArrayList<ExecutionPlan>();
        for (int j = 0; j < 3; j++) {
            ExecutionPlan ep = newTransientInstance(ExecutionPlan.class);
            ep.setName(j + ": " + td.title());
            for (int i = 0; i < 3; i++) {
                Task t = newTransientInstance(Task.class);
                
                t.setWhat(what[j]);
                t.setWhere(where[i]);
                t = persist(t);
                ep.addTask(t);
            }
            ep = persist(ep);
            l.add(ep);
        }

        return l;
    }
}