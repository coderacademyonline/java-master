package java1.core.nio.buffertest;

import java.nio.ByteBuffer;

/**
 * @Author zhaojw
 * @Date 2017/12/2 22:46
 *
 * 根据数据类型不同，分为相应的缓冲区
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 *
 * 上述缓冲区的管理方式几乎一致，通过allocate() 获取缓冲区
 * 二、缓存区存储数据的两个核心方法：
 * put() ：存入数据到缓冲区中
 * get() ：获取缓冲区中的数据
 *
 * 三、缓冲区中的四个核心属性
 * 1、capacity：容量，表示缓冲区中最大存储数据的容量，一旦声明不能改变
 * 2、limit：界限，表示缓冲区可以操作数据的大小。limit后面的数据不能进行读写
 * 3、position：位置，表示缓冲区中这个在操作数据的位置。
 * 4、mark：标记，表示记录当前position的位置。可以通过reset()恢复到mark的位置
 * position<=limit<=capacity
 *
 * 四、直接缓冲区和非直接缓冲区
 * 非直接缓冲区：通过allocate()方法分配缓冲区，将缓冲区建立在JVM的内存中
 * 直接缓冲区：通过allocateDirect()方法分配缓冲区，将缓冲区直接建立在物理内存上，可以提高效率。
 */
public class TestBuffer {

    private static final String STR="abcde";

    public static void main(String[] args){
        TestBuffer testBuffer=new TestBuffer();
        testBuffer.test2();
    }

    public void Test1(){
        //allocate获取缓冲区
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        System.out.println("-----------获取缓冲区-------------");
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        //利用put存入数据到缓冲区
        buffer.put(STR.getBytes());
        System.out.println("-----------put()-------------");
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        //切换到读取数据模式
        buffer.flip();

        System.out.println("-----------读取数据模式-------------");
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        //利用get()读取缓冲区中的数据
        byte[] dst=new byte[buffer.limit()];
        buffer.get(dst);
        System.out.println(new String(dst,0,dst.length));

        System.out.println("-----------get()-------------");
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        //rewind()，可重复读取数据
        buffer.rewind();

        System.out.println("-----------rewind()-------------");
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        //清空缓冲区，但是缓冲区的数据依然存在，但是处于被遗忘状态，（limit，position等指标处于最初状态）
        buffer.clear();

        System.out.println("-----------clear()-------------");
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        System.out.println((char)buffer.get());
    }

    public void test2(){
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        buffer.put(STR.getBytes());
        buffer.flip();
        byte[] dst=new byte[buffer.limit()];
        buffer.get(dst,0,2);
        System.out.println(new String(dst,0,2));
        System.out.println(buffer.position());

        //mark()标记
        buffer.mark();

        buffer.get(dst,2,2);
        System.out.println(new String(dst,2,2));
        System.out.println(buffer.position());
        //reset()恢复到mark的位置
        buffer.reset();
        System.out.println(buffer.position());

        //判断缓冲区是否还有剩余数据
        if (buffer.hasRemaining()){
            //获取缓冲区中可以操作的数量
            System.out.println(buffer.remaining());
        }
    }

    public void test3(){
        ByteBuffer buffer=ByteBuffer.allocateDirect(1024);
        System.out.println("是否是直接缓冲区："+buffer.isDirect());
    }
}
