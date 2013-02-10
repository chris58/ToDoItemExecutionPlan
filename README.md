ToDoItemExecutionPlan
=====================
The idea:

A ToDoItem might have associated with it an execution plan with tasks. The plan is something like
- go to somewhere
- do that
- go to somewhere else
- and do something else

Several execution plans are generated and the user should select one to fullfill the ToDoItem.
For 'Buy Milk' it could be

(1) - Go to the supermarket
- get some milk
- pay for the milk
- go home

(2) - Go to the farm
- milk a cow
- pay the farmer
- go home

etc. etc.

What I don't understand is how to acchieve this with isis.
I installed an ExecutionPlanService which is supposed to generate som alternative plans for a ToDoItem.
The method getExecutionPlans(ToDoItem td) is called many many times but why?
When selecting a plan from a drop down list (via choicesExecutionPlan()) a plan may be selected
but clicking on the selected plan then crashes the UI.
