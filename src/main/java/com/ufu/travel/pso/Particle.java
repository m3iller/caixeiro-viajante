package com.ufu.travel.pso;


public  class Particle implements Comparable<Particle>
{
    private int mData[];
    private double mpBest = 0;
    private double mVelocity = 0.0;

    public Particle()
    {
        this.mpBest = 0;
        this.mVelocity = 0.0;
    }
    
    public int compareTo(Particle that)
    {
    	if(this.pBest() < that.pBest()){
    		return -1;
    	}else if(this.pBest() > that.pBest()){
    		return 1;
    	}else{
    		return 0;
    	}
    }

    public int data(final int index)
    {
    	return this.mData[index];
    }
    
    public void data(final int index, final int value)
    {
        this.mData[index] = value;
        return;
    }

    public double pBest()
    {
    	return this.mpBest;
    }

    public void pBest(final double value)
    {
    	this.mpBest = value;
    	return;
    }

    public double velocity()
    {
    	return this.mVelocity;
    }
    
    public void velocity(final double velocityScore)
    {
       this.mVelocity = velocityScore;
       return;
    }

	public int[] getmData() {
		return mData;
	}

	public void setmData(int[] mData) {
		this.mData = mData;
	}
    
} 
