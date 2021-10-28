package others.reactor;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;

import org.junit.jupiter.api.Test;

/*
 * ReactiveStream�� ����Ƽ�� ���α׷����� ���� ���̴�.
 * Reactive Streams �������̽���
 * -Processor<T, R> extends Subscriber<T>, Publisher<R>{}
 * -Publisher<T>{subscribe(Subscriber<? super T>)}
 * -Subscriber<T>{onSubscribe(Subscription), onNext(T), onError(Throwable), onComplete()}
 * -Subscription{request(long), cancel()}
 * Subscriber�� Publisher ���� subscribe �ϸ� Publisher �� ������ �Ǵ� �������� �����ϰ� �ȴ�.
 * �����ϱ����� Publisher�� Subscriber�� ���ǵ� onSubscribe()�� ȣ���ϰ� 
 * Subscription�� Subscription�� �̿��� request �Ͽ� �����͸� �޽��ϴ�.
 * 
 * 
 * 
 * ---------------------
 * Reactor�� ReactiveStreams �� ����ü, JVM�� ���� ���ŷ ����Ƽ�� ���α׷��� ���̺귯�� �̴�.
 * WebFlux�� �⺻������ reactor-core �� ���ԵǾ� �ִ�.
 */
public class ReactorTest {
/**
 * 
 */
	@Test
	public void test() {
		Publisher<Integer> lsyPublisher = new LsyPublisher();
		Subscriber<Integer> lsySubscriber = new LsySubscriber();
		lsyPublisher.subscribe(lsySubscriber);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
