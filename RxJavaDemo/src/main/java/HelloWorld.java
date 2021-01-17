import Vo.UserVO;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xianzheTM
 * @date 2021/1/16 14:54
 */
public class HelloWorld {
    public static void main(String[] args) {
        Observable<String> switcher1 = new Observable<>() {
            @Override
            protected void subscribeActual(@NonNull Observer<? super String> observer) {
                observer.onNext("开");
                observer.onNext("关");
                observer.onComplete();
            }
        };

        Observer<String> light = new Observer<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("开始观察/订阅");
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("收到事件:" + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("结束");
            }
        };

        switcher1.subscribe(light);

        ///////////////////////////
        List<UserVO> list = new ArrayList<>();
        list.add(UserVO.builder().id(1).username("aa").build());
        list.add(UserVO.builder().id(2).username("bb").build());
        list.add(UserVO.builder().id(3).username("cc").build());
        Observable.fromIterable(list)
            .filter(user -> user.getId() > 2)
            .subscribe(System.out::println)
            .dispose();
    }
}
