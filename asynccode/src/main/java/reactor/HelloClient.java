//package reactor;
//
//import io.netty.bootstrap.Bootstrap;
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.*;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.nio.NioSocketChannel;
//
///**
// * @author hqz
// * @create 2023/9/15 18:31
// */
//public class HelloClient {
//
//    private String host = "A";
//    private int port = 123;
//
//    public HelloClient(String host, int port) {
//        this.host = host;
//        this.port = port;
//    }
//
//    public void run() throws InterruptedException {
//
//        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
//        try {
//            Bootstrap bootstrap = new Bootstrap();
//            bootstrap.group(eventLoopGroup)
//                    .channel(NioSocketChannel.class)
//                    .option(ChannelOption.SO_KEEPALIVE, true).handler(new ChannelInitializer<>() {
//                @Override
//                protected void initChannel(Channel channel) throws Exception {
//                    channel.pipeline().addLast(new HelloClientHandler());
//                }
//            });
//            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
//            channelFuture.channel().closeFuture().sync();
//        } finally {
//            eventLoopGroup.shutdownGracefully();
//        }
//    }
//}
