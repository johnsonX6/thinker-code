package com.client.reactor;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * @author hqz
 * @create 2022/8/24 15:01
 */
public class SimpleReactiveStream {

    static class SimplePublisher implements Publisher {

        @Override
        public void subscribe(Subscriber subscriber) {
            subscriber.onSubscribe(new SimpleSubscription(data(), subscriber));
        }

        public String data() {
            return "this is publish data!";
        }
    }

    static class SimpleSubscriber implements Subscriber {

        @Override
        public void onSubscribe(Subscription subscription) {
            // request请求数据
            subscription.request(Long.MAX_VALUE);
        }

        @Override
        public void onNext(Object o) {
            System.out.println("next：" + o);
        }

        @Override
        public void onError(Throwable throwable) {
            System.out.println("err:" + throwable.getMessage());
        }

        @Override
        public void onComplete() {
            System.out.println("complete:");
        }
    }

    static class SimpleSubscription implements Subscription {

        protected String data;
        protected Subscriber subscriber;
        protected boolean isCancel;

        public SimpleSubscription(String data, Subscriber subscriber) {
            this.subscriber = subscriber;
            this.data = data;
        }

        @Override
        public void request(long l) {
            if (!isCancel) {
                try {
                    // 传给下游Subscriber
                    subscriber.onNext(data);
                    subscriber.onComplete();
                } catch (Exception e) {
                    // 出现错误时调用
                    subscriber.onError(e);
                }
            }
        }

        @Override
        public void cancel() {
            isCancel = true;
        }
    }

    public static void main(String[] args) {
        // 订阅发布者
        new SimplePublisher().subscribe(new SimpleSubscriber());
    }
}
