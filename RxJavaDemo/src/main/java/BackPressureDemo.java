import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.reactivestreams.Subscription;

/**
 * @author xianzheTM
 * @date 2021/1/16 17:43
 */
public class BackPressureDemo {
    public static void main(String[] args) {
        missing();
    }

    public static void missing() {
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                for (int i = 0; i < 129; i++) {
                    emitter.onNext(i);
                }
            }
        }, BackpressureStrategy.MISSING)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe(new FlowableSubscriber<Integer>() {
                @Override
                public void onSubscribe(Subscription s) {
                    s.request(Long.MAX_VALUE);
                }

                @Override
                public void onNext(Integer integer) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }

                }

                @Override
                public void onError(Throwable t) {
                    t.printStackTrace();
                }

                @Override
                public void onComplete() {

                }
            });
    }
}
