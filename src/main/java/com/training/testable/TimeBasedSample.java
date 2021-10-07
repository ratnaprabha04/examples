package com.training.testable;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TimeBasedSample {
	
	Scheduler scheduler = Schedulers.computation();
	

	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}


	Observable<Integer> buildPipeLine(){
		return Observable.interval(1, TimeUnit.SECONDS, scheduler)
		.map(l -> Math.pow(l,2))
		.map(i -> i*2)
		.map(d -> d.intValue());
	}
	
	public static void main(String[] args) throws Exception {
		TimeBasedSample obj = new TimeBasedSample();
		obj.buildPipeLine().subscribe(obj::forEveryResult);
		
		Thread.sleep(3000);
	}

	void forEveryResult(Object res){
		//something complex or as simple as 
		System.out.println(res);
	}
}
