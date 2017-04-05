import java.util.ArrayList;
import java.util.List;

/**
 * Created by TITASH MANDAL on 4/5/2017.
 */
public class Test {
    public static void main(String args[]){
        List<Jobs> joblist=new ArrayList<>();
        //Testing the JobScheduler
        joblist.add(new Jobs(5,7,7258));
        joblist.add(new Jobs(2,4,2368));
        joblist.add(new Jobs(17,17,2213));
        joblist.add(new Jobs(3,5,291));
        joblist.add(new Jobs(7,8,1822));
        joblist.add(new Jobs(4,9,2197));
        joblist.add(new Jobs(10,17,2193));
        joblist.add(new Jobs(3,17,2173));
        LambdaScheduler lambdaScheduler=new LambdaScheduler(joblist);
        List<Jobs> finalAcceptedJobs=lambdaScheduler.jobScheduling();
        for(Jobs value:finalAcceptedJobs){
            System.out.printf("Start Time %d End Time %d  %n", value.getStartTime() ,value.getEndTime());
        }
        System.out.printf("The number of accepted non overlapping jobs of equal priority jobs are %d%n", finalAcceptedJobs.size());
        //Testing the WeightedJobScheduler
        joblist.add(new Jobs(1,2,50,1923));
        joblist.add(new Jobs(3,5,20,1223));
        joblist.add(new Jobs(6,19,10,1233));
        joblist.add(new Jobs(2,100,2342));
        joblist.add(new Jobs(5,8,11,8340));
        joblist.add(new Jobs(7,9,2,4083));
        LambdaWeightedScheduler  lambdaWeightedScheduler=new LambdaWeightedScheduler(joblist);
        int profit= lambdaWeightedScheduler.maximumProfitCalculator();
        System.out.println("Profit is " + profit);

    }
}
