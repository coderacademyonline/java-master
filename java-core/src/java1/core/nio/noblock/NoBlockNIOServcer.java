package java1.core.nio.noblock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Calendar;
import java.util.Iterator;

/**
 * @Author zhaojw
 * @Date 2017/12/3 17:23
 */
public class NoBlockNIOServcer {

    public static void main(String[] args){
        try {
            NoBlockNIOServcer.server();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private static final String URL="";

    public static void server() throws IOException {
        //获取通道
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        //切换到非阻塞
        serverSocketChannel.configureBlocking(false);
        //绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9898));

        //获取选择器
        Selector selector=Selector.open();
        //将通道注册到选择器上，并且指定监听器接受事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //轮询式的获取选择器上已经准备就绪事件
        while(selector.select()>0){
            //获取当前选择器中所有注册的选择键（已就绪的监听事件）
            Iterator<SelectionKey> iterable=selector.selectedKeys().iterator();
            while (iterable.hasNext()){
                //获取准备就绪的事件
                SelectionKey sk=iterable.next();
                //判断具体是什么事件准备就绪
                if (sk.isAcceptable()){
                    //若"接收就绪"，获取客户端连接
                    SocketChannel socketChannel=serverSocketChannel.accept();
                    //切换到非阻塞模式
                    socketChannel.configureBlocking(false);
                    //该通到注册选择器
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }else if (sk.isReadable()){
                    //获取当前选择器上“读就绪”状态上的通道
                    SocketChannel socketChannel=(SocketChannel)sk.channel();
                    //读取数据
                    ByteBuffer buffer=ByteBuffer.allocate(1024);
                    int len=0;
                    while ((len=socketChannel.read(buffer))!=-1){
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0,len));
                        buffer.clear();
                    }
                }
                //取消选择器SelectionKey
                iterable.remove();
            }
        }
    }
}
