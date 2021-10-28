package others.reactor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LsyPublisher implements Publisher<Integer> {

	private Logger logger = LoggerFactory.getLogger(LsyPublisher.class);
	private final ExecutorService executor = Executors.newFixedThreadPool(3);
	
	
	@Override
	public void subscribe(Subscriber<? super Integer> subscriber) {
		logger.info("publisher - subscribe");
		subscriber.onSubscribe(new LsySubscription(subscriber, executor));
	}
}
