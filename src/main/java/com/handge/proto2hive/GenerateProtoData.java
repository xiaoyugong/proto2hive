package com.handge.proto2hive;

import com.google.protobuf.ByteString;
import com.handge.proto.MessageOuterClass;
import com.handge.proto.Packet;
import com.handge.proto.User;
import com.handge.util.ParseProto;

/**
 * Created by gxy on 18-7-25.
 */
public class GenerateProtoData {

    public static void main(String[] args) {
        Packet.Builder packetBuilder = Packet.newBuilder();
        packetBuilder.setDstIp("172.18.199.13");
        packetBuilder.setDstPort(80);
        packetBuilder.setSrcIp("122.18.12.15");
        packetBuilder.setSrcPort(123);
        packetBuilder.setIpPorto2Name("http");

        Packet packet = packetBuilder.build();
        ByteString packetByte = packet.toByteString();


        User.Builder userBuilder = User.newBuilder();
        userBuilder.setName("gxy");
        userBuilder.setAge(18);

        User user = userBuilder.build();
        ByteString userByte = user.toByteString();

        MessageOuterClass.Message.Builder message = MessageOuterClass.Message.newBuilder();
//        message.setMessageName(packet.getClass().getSimpleName());
//        message.setPayload(packetByte);
        message.setMessageName(user.getClass().getSimpleName());
        message.setPayload(userByte);
        byte[] messageByte = message.build().toByteArray();

        ParseProto.decode(messageByte);
    }
}
