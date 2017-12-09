package java1.core.nio.noblock;

import java.io.IOError;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

/**
 * @Author zhaojw
 * @Date 2017/12/3 17:19
 */
public class NoBlockNIOClient {

    public static void main(String[] args){
        try {
            NoBlockNIOClient.client();
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    private static final String URL="";

    public static void client() throws IOException{
        //获取通道
        SocketChannel socketChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));

        //切换到非阻塞式
        socketChannel.configureBlocking(false);

        //分配指定大小的缓冲区
        ByteBuffer buffer=ByteBuffer.allocate(1024);

        //读取本地文件，并发送到服务端
        buffer.put(new Date().toString().getBytes());
         buffer.flip();
         socketChannel.write(buffer);
         buffer.clear();
        socketChannel.close();
    }
}
