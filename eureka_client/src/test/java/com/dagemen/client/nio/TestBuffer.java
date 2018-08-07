package com.dagemen.client.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class TestBuffer {
    @Test
    public void testByteBuffered() throws IOException {

        // 实例化
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 监听 8080 端口
        ServerSocket socket = serverSocketChannel.socket();
        socket.bind(new InetSocketAddress(8080));


        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("随机写入一些内容到 Buffer 中".getBytes());
        // Buffer 切换为读模式
        buffer.flip();
        while (buffer.hasRemaining()) {
            // 将 Buffer 中的内容写入文件
            SocketChannel socketChannel = serverSocketChannel.accept();
            int read = socketChannel.read(buffer);
            socketChannel.write(buffer);
        }
    }

    @Test
    public void testSocket() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 打开一个通道
        SocketChannel socketChannel = SocketChannel.open();
        // 发起连接
        socketChannel.connect(new InetSocketAddress("localhost", 8080));
        // 读取数据
        socketChannel.read(buffer);

        // 写入数据到网络连接中
        while (buffer.hasRemaining()) {
            socketChannel.write(buffer);
        }
    }

    @Test
    public void testDatagramChannel() throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(9090));
        ByteBuffer buf = ByteBuffer.allocate(48);

        String newData = "New String to write to file..."
                + System.currentTimeMillis();

        buf = ByteBuffer.allocate(48);
        buf.put(newData.getBytes());
        buf.flip();

        int bytesSent = channel.send(buf, new InetSocketAddress("jenkov.com", 80));
        channel.receive(buf);

    }
}
