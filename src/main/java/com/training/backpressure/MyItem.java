package com.training.backpressure;

public class MyItem {

	final int id;

	MyItem(int id) {
		this.id = id;
		System.out.println("Constructing MyItem " + id);
	}
}
