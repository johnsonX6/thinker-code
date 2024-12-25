package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

/**
 * @author hqz
 * @create 2023/9/16 09:19
 * 参考文档：https://juejin.cn/post/6844903700746485767?searchId=202309160905171BC81596EC0E714A9D81
 * 非完整教程
 */
@Component
@Slf4j
public class NettyServer {

    private EventLoopGroup boss = new NioEventLoopGroup();

    private EventLoopGroup worker = new NioEventLoopGroup();

    @Value("${netty.port}")
    private int port;

    @PostConstruct
    public void run() throws InterruptedException {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(port))
                .option(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true);
//                .childHandler(new NettyServerHandlerInitializer());
        ChannelFuture future = bootstrap.bind().sync();
        if(future.isSuccess()){
            log.info("启动netty server");
        }
    }

    @PreDestroy
    public void destroy() throws InterruptedException {
        boss.shutdownGracefully().sync();
        worker.shutdownGracefully().sync();
    }
}
