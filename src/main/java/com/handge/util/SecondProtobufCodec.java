package com.handge.util;

import com.google.protobuf.InvalidProtocolBufferException;
import com.handge.proto.MessageOuterClass.Message;

/**
 * Created by gxy on 18-7-26.
 */
public class SecondProtobufCodec {
    public static Message getMessage(byte[] msg) {

        Message message = null;
        try {
            message = Message.parseFrom(msg);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        return message;
    }
}
