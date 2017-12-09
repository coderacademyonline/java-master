package java1.core.nio.block;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Author zhaojw
 * @Date 2017/12/3 16:54
 */
public class BlockNIOClient {

    private static final String URL="";

    public void client() throws IOException{
        //获取通道
        SocketChannel socketChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));
        FileChannel inChannel= FileChannel.open(Paths.get(URL), StandardOpenOption.READ);

        //分配指定大小的缓冲区
        ByteBuffer buffer=ByteBuffer.allocate(1024);

        //读取本地文件，并发送到服务端
        while (inChannel.read(buffer)!=-1){
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }

        //关闭通道
        inChannel.close();
        socketChannel.close();
    }
}
