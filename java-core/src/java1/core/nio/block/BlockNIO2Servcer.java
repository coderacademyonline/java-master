package java1.core.nio.block;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Author zhaojw
 * @Date 2017/12/3 17:23
 */
public class BlockNIO2Servcer {
    private static final String URL="";

    public void server() throws IOException {
        //获取通道
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        FileChannel outChannel=FileChannel.open(Paths.get(URL), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
        //绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9898));

        //获取客户端连接的通道
        SocketChannel socketChannel=serverSocketChannel.accept();

        //分配指定大小的缓冲区
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        //接受客户端的数据，
        while (socketChannel.read(buffer)!=-1){
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }

        //发送返回到客户端
        buffer.put("服务端收到消息".getBytes());
        buffer.flip();
        socketChannel.write(buffer);

        serverSocketChannel.close();
        socketChannel.close();
    }
}
