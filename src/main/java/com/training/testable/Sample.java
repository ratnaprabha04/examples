package com.training.testable;

import io.reactivex.rxjava3.core.Observable;

public class Sample {
	
	private DataProvider provider = new DataProvider();
	

	public void setProvider(DataProvider provider) {
		this.provider = provider;
	}


	Observable<Integer> buildPipeLine(){
		return Observable.fromIterable(provider.getDataFromDB())
		.map(s -> s.length())
		.map(i -> i*2);
	}
	
	public static void main(String[] args) {
		Sample obj = new Sample();
		obj.buildPipeLine().subscribe(obj::forEveryResult);

	}

	void forEveryResult(int res){
		//something complex or as simple as 
		System.out.println(res);
	}
}
