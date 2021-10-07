package com.training.testable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

import io.reactivex.rxjava3.observers.TestObserver;

class SampleTest {

	@Test
	void testBuildPipeLine() {
		Sample toBeTested = new Sample();
		DataProvider mock = Mockito.mock(DataProvider.class);
		toBeTested.setProvider(mock);
		List<String> dummy = new ArrayList<>();
		dummy.add("one");
		dummy.add("four");
		dummy.add("three");
		
		Mockito.when(mock.getDataFromDB()).thenReturn(dummy);
		
		
		TestObserver<Integer> testObserver = new TestObserver<>();
		 assertFalse(testObserver.hasSubscription());
		toBeTested.buildPipeLine().subscribe(testObserver);
		
		//Assert TestObserver is subscribed
        //testObserver.assertSubscribed();          //RxJava 2.x
        assertTrue(testObserver.hasSubscription());

        //Block and wait for Observable to terminate
        //testObserver.awaitTerminalEvent();       //RxJava 2.x
        try {
            testObserver.await(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Assert TestObserver called onComplete()
        testObserver.assertComplete();

        //Assert there were no errors
        testObserver.assertNoErrors();

        //Assert 3 values were received
        testObserver.assertValueCount(3);

        //Assert the received emissions were 0, 1, 2
        testObserver.assertValues(6, 8, 10);
	}

}
