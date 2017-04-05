public class Jobs{

    private final int startTime;
	private final int endTime;
	private final int weight;
	private final int uniqueID;

	public Jobs(int startTime,int endTime,int uniqueID){
		this.startTime=startTime;
		this.endTime=endTime;
		this.uniqueID=uniqueID;
		this.weight=0;
	}
    public Jobs(int startTime,int endTime,int weight,int uniqueID){
        this.startTime=startTime;
        this.endTime=endTime;
		this.uniqueID=uniqueID;
        this.weight=weight;
    }


	public int getStartTime(){
		return startTime;
	}
	public int getEndTime(){
		return endTime;
	}
	public int getWeight(){
	    return weight;
    }
    public int getUniqueID(){return uniqueID;}
}