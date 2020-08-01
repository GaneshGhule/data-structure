package gg.ds.heap.interviewQuestions;

import java.util.*;

class Interval {
    protected int start;
    protected int end;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "["+start+","+end+"]";
    }
}


//Employee free time
public class EmployeeFreeTime {

    public List<Interval> findFreeTime(List<List<Interval>> intervals){

        List<Interval> result = new ArrayList<>();

        Comparator<Employee> employeeComparator = (emp1, emp2) -> intervals.get(emp1.id).get(emp1.index).start - intervals.get(emp2.id).get(emp2.index).start;

        // Min heap
        PriorityQueue<Employee> queue = new PriorityQueue<>(employeeComparator);

        //add all employee in min heap
        for (int i = 0; i < intervals.size(); i++) {
            queue.add(new Employee(i, 0));
        }

        int max =  -1;

        while (!queue.isEmpty()){

            //Get employee which having min start interval time
            Employee employee = queue.poll();

            int start = intervals.get(employee.id).get(employee.index).start;

            // Add free time in result
            if(max != -1 && max < start){
               result.add(new Interval(max, start));
            }

            // update max so far
            max = Math.max(max, intervals.get(employee.id).get(employee.index).end);

            // If employee have multiple working interval then increment index and add employee in min heap
            if(++employee.index < intervals.get(employee.id).size()){
                queue.add(employee);
            }
        }
        return result;
    }


    class Employee {
        int id;
        int index;

        public Employee(int id, int index){
            this.id = id;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        EmployeeFreeTime employeeFreeTime = new EmployeeFreeTime();


        List<List<Interval>> intervals = new ArrayList<>();
        intervals.add(Arrays.asList(new Interval(1,3), new Interval(6,7)));
        intervals.add(Arrays.asList(new Interval(2,4)));
        intervals.add(Arrays.asList(new Interval(2,5), new Interval(9,12)));

        System.out.println(employeeFreeTime.findFreeTime(intervals));
    }
}
