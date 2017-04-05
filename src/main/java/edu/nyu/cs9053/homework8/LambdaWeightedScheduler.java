import java.util.*;

/**
 * Created by TITASH MANDAL on 4/5/2017.
 */
public class LambdaWeightedScheduler {
    // This method uses dynamic programming to sort the lisit of jobs but the time complexity is O(nlogn)
    private final List<Jobs> joblist;
    

    public LambdaWeightedScheduler (List<Jobs> jobs) {
        joblist = jobs;

    }
    public int binarySearch(int currentJob)
    {
        /*A Binary Search based function to find the latest job before the current job
        that doesn't conflict with current job. */
        int lowIndex = 0, highIndex = currentJob- 1;
        while (lowIndex <= highIndex){
            int mid = (lowIndex + highIndex) / 2;
            if (joblist.get(mid).getEndTime() <= joblist.get(currentJob).getStartTime()) {
                if (joblist.get(mid + 1).getEndTime() <= joblist.get(currentJob).getStartTime())
                    lowIndex = mid + 1;
                    else{
                         return mid;
                    }

                }
            else{
                highIndex = mid - 1;
            }

        }

        return -1;
    }

    public  void sortJobsWithWeights(){

        Collections.sort(joblist, new Comparator<Jobs>() {
            public int compare(Jobs o1, Jobs o2) {
                if(o2.getWeight()<=o1.getWeight()){
                    return 1;
                }else{
                    return -1;
                }
            }

        });
    }
    public int maximumProfitCalculator() {
        if(!joblist.isEmpty()){
            sortJobsWithEndTime();
        }
        List<Integer> weights = new ArrayList<>();
        List<Jobs> jobsSelected=new LinkedList<>();
        weights.add(joblist.get(0).getWeight());
        for (int i=1; i<joblist.size(); i++)
        {
            int currentProfit= joblist.get(i).getWeight();
            int foundIndex = binarySearch(i);
            if (foundIndex != -1){
                currentProfit += weights.get(foundIndex);
            }
            weights.add(Math.max(currentProfit,weights.get(i-1)));
        }

        return (weights.get(joblist.size()-1));
    }

    public  void sortJobsWithEndTime(){

        Collections.sort(joblist, new Comparator<Jobs>() {
            public int compare(Jobs o1, Jobs o2) {
                if(o2.getEndTime()<=o1.getEndTime()){
                    return 1;
                }else{
                    return -1;
                }
            }

        });
    }







}
