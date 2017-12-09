package java1.core.nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Author zhaojw
 * @Date 2017/12/3 13:54
 *
 * 一、通道(channel)：用于源节点与目标节点的连接。在Java NIO中负责缓冲区中的数据的传输。channel本身不存储数据，因此需要配合缓冲区进行传输
 *
 * 二、通道的主要实现类
 * java.nio.channels.Channel 接口：
 *        |--FileChannel
 *        |--SocketChannel
 *        |---ServerSocketChannel
 *        |--DatagramChannel
 *
 *  三、获取通道
 *  1、Java针对支持通道的类提供了getChannel()方法
 *      本地IO：
 *      FileInputStream/FileOutPutStream
 *      RandomAccessFile
 *
 *      网络IO：
 *      Socket
 *      ServerSocket
 *      DatagramSocket
 *
 *  2、在JDK1.7以后的NIO.2针对各个通道提供了静态方法open()
 *  3、在JDK1.7中的NIO.2的Files工具类的newByteChannel()
 *
 *  四、通道之间的数据传输，两种方式：
 *      1、transferFrom()
 *      2、transferTo()
 *
 *  五、分散(Scatter)与聚集(Gather)
 *  1、分散读取(Scattering Reads)：将通道中的数据分散到多个缓冲区中
 *  2、聚集写入(Gathering Writes)：将多个缓冲区总的数据聚集到通道中
 *
 *  六、字符集：CharSet
 *  编码：字符串-》字节数组
 *  解码：字节数组-》字符串
 */
public class TestChannel {

    private static final String INPUT_URL="";

    private static final String OUTPUT_URL="";

    public static void test1() throws Exception{
        FileInputStream fis=new FileInputStream(INPUT_URL);
        FileOutputStream fos=new FileOutputStream(OUTPUT_URL);
        FileChannel inChannel=fis.getChannel();
        FileChannel outChannel=fos.getChannel();

        //分配指定大小的缓冲区
        ByteBuffer buffer=ByteBuffer.allocate(1024);

        //将通道中的数据放入缓冲区
        while(inChannel.read(buffer)!=-1){
            buffer.flip();//切换读取数据的模式
            //将缓冲区中的数据写入通道中
            outChannel.write(buffer);
            buffer.clear();//清空缓冲区，循环读取
        }
        if (fis!=null){
            fis.close();
        }
        if (fos!=null){
            fos.close();
        }
        if (inChannel!=null){
            inChannel.close();
        }
        if (outChannel!=null){
            outChannel.close();
        }
    }

    /**
     * 利用直接缓冲区完成文件的复制（内存映射文件） 。速度很快，但不稳定，易造成JVM满
     */
    public static void test2() throws Exception{
        FileChannel inChannel=FileChannel.open(Paths.get(INPUT_URL), StandardOpenOption.READ);
        FileChannel outChannel=FileChannel.open(Paths.get(OUTPUT_URL),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

        //内存映射文件
        MappedByteBuffer inMappedBuffer=inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
        MappedByteBuffer outMappedBuffer=outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

        //直接对缓冲区进行数据的读写操作
        byte[] dst=new byte[inMappedBuffer.limit()];
        inMappedBuffer.get(dst);
        outMappedBuffer.put(dst);

        inChannel.close();
        outChannel.close();
    }

    /**
     * 通道之间的数据传输（直接缓冲区）
     * @throws Exception
     */
    public static void test3() throws Exception{
        FileChannel inChannel=FileChannel.open(Paths.get(INPUT_URL), StandardOpenOption.READ);
        FileChannel outChannel=FileChannel.open(Paths.get(OUTPUT_URL),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);


        //inChannel.transferTo(0,inChannel.size(),outChannel);

        outChannel.transferFrom(inChannel,0,inChannel.size());

        inChannel.close();
        outChannel.close();
    }

    /**
     * 分散与聚集
     */
    public static void test4() throws Exception{
        RandomAccessFile file=new RandomAccessFile(INPUT_URL,"rw");

        //获取通道
        FileChannel channel1=file.getChannel();
        //分配指定大小的缓冲区
        ByteBuffer buffer1=ByteBuffer.allocate(100);
        ByteBuffer buffer2=ByteBuffer.allocate(1024);

        //分散读取
        ByteBuffer[] buffers={buffer1,buffer2};
        channel1.read(buffers);

        for(ByteBuffer buffer:buffers){
            buffer.flip();
        }

        System.out.println(new String(buffers[0].array(),0,buffers[0].limit()));
        System.out.println("-----------------------");
        System.out.println(new String(buffers[1].array(),0,buffers[1].limit()));

        //聚集写入
        RandomAccessFile file2=new RandomAccessFile("2.txt","rw");
        FileChannel channel2=file2.getChannel();

        channel2.write(buffers);
    }

    public static void test5() throws IOException{
        Charset cs=Charset.forName("gbk");
        //获取编码器
        CharsetEncoder ce=cs.newEncoder();
        //获取解码器
        CharsetDecoder cd=cs.newDecoder();

        CharBuffer charBuffer=CharBuffer.allocate(1024);
        charBuffer.put("你妈的傻逼");
        //切换读取模式
        charBuffer.flip();
        //编码
        ByteBuffer buffer=ce.encode(charBuffer);
        for(int i=0;i<12;i++){
            System.out.println(buffer.get());
        }

        //解码
        buffer.flip();
        CharBuffer charBuffer1=cd.decode(buffer);
        System.out.println(charBuffer1.toString());
    }
}
