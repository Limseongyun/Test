package others.reactor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LsySubscription implements Subscription{
	private Logger logger = LoggerFactory.getLogger(LsySubscription.class);
	private final ExecutorService executorService;
	private Subscriber<? super Integer> subscriber;
	private final AtomicInteger value;
	
	public LsySubscription(Subscriber<? super Integer> subscriber, ExecutorService executorService) {
		this.executorService = executorService;
		this.subscriber = subscriber;
		value = new AtomicInteger();
	
	}
	
	@Override
	public void request(long n) {
		if(n < 0) {
			
		} else {
			for(int i = 0; i < n; i++) {
				//new Runnable()
				executorService.execute(()->{
					int count = value.incrementAndGet();
					if(count > 200) {
						logger.info("Item is over");
						subscriber.onComplete();
					} else {
						logger.info("push Item" + count);
						subscriber.onNext(count);
					}
				});
			}
		}
	}

	@Override
	public void cancel() {
		subscriber.onComplete();
	}

}
