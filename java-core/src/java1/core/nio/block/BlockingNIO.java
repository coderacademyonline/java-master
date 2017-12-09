package java1.core.nio.block;

/**
 * @Author zhaojw
 * @Date 2017/12/3 16:49
 *
 * 一、使用NIO完成网络通信的三个核心
 * 1、通道：负责连接
 *      java.nio.channels.channel接口：
 *          |--SelectableChannel
 *              |--SocketChannel
 *              |--ServerSocketChannel
 *              |--DatagramChannel
 *
 *              |--Pipe.SinkChannel
 *              |--Pipe.SourceChannel
 * 2、缓冲区：负责额数据的存取
 * 3、选择器(Selector)：是SelectableChannel的多路复用器。用于监控SelectableChannel的IO状况
 *
 */
public class BlockingNIO {


}
