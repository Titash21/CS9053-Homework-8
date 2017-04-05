import jdk.nashorn.internal.scripts.JO;

import java.util.*;

/**
 * Created by TITASH MANDAL on 4/3/2017.
 */
public class LambdaScheduler{
    private final List<Jobs> joblist;

    public LambdaScheduler(List<Jobs> jobs) {
        joblist = jobs;
    }

    public List<Jobs> jobScheduling() {
        if(!joblist.isEmpty()){
            sortJobsWithEndTime();
        }else{
            return null;
        }
        List<Jobs> finalAcceptedJobs = new ArrayList<Jobs>();
        finalAcceptedJobs.add(joblist.get(0));
        for(int i=0;i<joblist.size()-1;i++){
            if(joblist.get(i+1).getStartTime()>=joblist.get(i).getEndTime()){
                finalAcceptedJobs.add(joblist.get(i+1));
            }
        }

        return finalAcceptedJobs;
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
