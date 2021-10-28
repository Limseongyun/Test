package others.reactor;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;

import org.junit.jupiter.api.Test;

/*
 * ReactiveStream는 리액티브 프로그래밍을 위한 명세이다.
 * Reactive Streams 인터페이스는
 * -Processor<T, R> extends Subscriber<T>, Publisher<R>{}
 * -Publisher<T>{subscribe(Subscriber<? super T>)}
 * -Subscriber<T>{onSubscribe(Subscription), onNext(T), onError(Throwable), onComplete()}
 * -Subscription{request(long), cancel()}
 * Subscriber가 Publisher 에게 subscribe 하면 Publisher 가 데이터 또는 시퀀스를 전달하게 된다.
 * 전달하기전에 Publisher는 Subscriber에 정의된 onSubscribe()를 호출하고 
 * Subscription은 Subscription을 이용해 request 하여 데이터를 받습니다.
 * 
 * 
 * 
 * ---------------------
 * Reactor는 ReactiveStreams 의 구현체, JVM을 위한 논블럭킹 리액티브 프로그래밍 라이브러리 이다.
 * WebFlux는 기본적으로 reactor-core 가 포함되어 있다.
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
