package others.reactor;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
 * ��
 * next�� ������ȣ�� ���
 * complete�� ��ȣ�� ������
 * error �� ��ȣ���� ������ �߻��Ѱ�
 * 
 * 
 * 
 * ---------------------
 * Reactor�� ReactiveStreams �� ����ü, JVM�� ���� ���ŷ ����Ƽ�� ���α׷��� ���̺귯�� �̴�.
 * WebFlux�� �⺻������ reactor-core �� ���ԵǾ� �ִ�.
 * 
 * Mono: 0-1���� ������� ó���ϱ� ���� Reactor ��ü
 * Flux: 0-N���� ������� ó���ϱ� ���� Reactor ��ü
 * 
 */
@Slf4j
public class ReactorTest {
/**
 * 
 */
	//@Test
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
	
	@Test
	public void monoFluxTest() {
		Flux.just(1, 2, 3)
		.doOnNext(i -> log.debug("ȣ��: {}", i)).subscribe(i->log.debug("��°��" + i));
		Mono.just(1).doOnNext(i->log.debug("zz")).subscribe();
		
	}
	
}
