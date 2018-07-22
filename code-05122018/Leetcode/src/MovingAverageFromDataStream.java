ublic class MovingAverage {
    /*
    * @param size: An integer
    */
        Queue<Integer> q;
    int size;
    //us long here, otherwise it can not pass the test.
    long sum;
    public MovingAverage(int size) {
        // do intialization if necessary
        this.q=new LinkedList<Integer>();
        this.size=size;
        this.sum=0;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        // write your code here
        q.offer(val);
        if(q.size()>size)
        {
            sum=sum-q.poll();
            sum+=val;
            return sum*1.0/size;
            
        }
        else{
            sum+=val;
            return sum*1.0/q.size();
        }
    }
}
