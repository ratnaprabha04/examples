package com.training.testable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.schedulers.TestScheduler;

class TimeBasedSampleTest {

	@Test
	void testBuildPipeLine() {
		//Arrange
		TimeBasedSample toBeTested = new TimeBasedSample();
		TestScheduler testScheduler = new TestScheduler();
		toBeTested.setScheduler(testScheduler);
		
		
		
		
		
		TestObserver<Integer> testObserver = new TestObserver<>();
		 assertFalse(testObserver.hasSubscription());
		//Act
		 toBeTested.buildPipeLine().subscribe(testObserver);
		
		//Assert TestObserver is subscribed
        //testObserver.assertSubscribed();          //RxJava 2.x
        assertTrue(testObserver.hasSubscription());

        //simulate the passing of time
        testScheduler.advanceTimeBy(3, TimeUnit.SECONDS);

        
        //Assert there were no errors
        testObserver.assertNoErrors();

        //Assert 3 values were received
        testObserver.assertValueCount(3);

        //Assert the received emissions were 0, 2, 8
        testObserver.assertValues(0, 2, 8);
	}

}
