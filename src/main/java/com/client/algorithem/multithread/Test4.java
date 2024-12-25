package com.client.algorithem.multithread;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @author hqz
 * @create 2024/10/16 15:41
 */
public class Test4 {
    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();
        Thread p = new Thread(new ImageProducer(pipe));
        Thread p1 = new Thread(new ImageConsumer(pipe));
        p.start();
        p1.start();
    }

    /**
     * 生产者，消费者模型处理
     */

    static class ImageProducer implements Runnable{

        Pipe pipe;

        public ImageProducer(Pipe pipe) {
            this.pipe = pipe;
        }

        @Override
        public void run() {
            Pipe.SinkChannel channel = pipe.sink();
            byte[] bytes = new byte[1024];
            ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
            try {
                channel.write(byteBuffer);
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    static class ImageConsumer implements Runnable{

        Pipe pipe;

        public ImageConsumer(Pipe pipe) {
            this.pipe = pipe;
        }

        @Override
        public void run() {
            Pipe.SourceChannel sourceChannel = pipe.source();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            try {
                int read = sourceChannel.read(byteBuffer);
                byteBuffer.flip();
                byte[] data = new byte[read];
                byteBuffer.get(data);
                System.out.println("处理图像数据...");
                sourceChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
