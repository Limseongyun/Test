package others.reactor;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LsySubscriber implements Subscriber<Integer> {
	private Logger logger = LoggerFactory.getLogger(LsySubscriber.class);
	private Integer count;
	private final Integer DEMAND_COUNT = 3;
	private Subscription subscription;
	public LsySubscriber() {}

	@Override
	public void onSubscribe(Subscription subscription) {
		logger.info("subscriber - onSubscribe");
		count = DEMAND_COUNT;
		this.subscription = subscription;
		this.subscription.request(DEMAND_COUNT);
	}

	@Override
	public void onNext(Integer item) {
		logger.info("subscriber - onNext");
		synchronized (this) {
			count --;
			if(count == 0) {
				logger.info("count is zero");
				count = DEMAND_COUNT;
				subscription.request(count);
			}
		}
	}

	@Override
	public void onError(Throwable throwable) {
		logger.info("subscriber - onError");
	}

	@Override
	public void onComplete() {
		logger.info("subscriber - onComplete");
	}

	
}
