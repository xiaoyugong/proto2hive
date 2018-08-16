package com.handge.util;

import com.google.protobuf.MessageLite;
import com.handge.handler.customhandler.AbstractHandler;
import com.handge.proto.MessageOuterClass;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by gxy on 18-7-26.
 */
public class ParseProto extends SecondProtobufCodec {
    public static void decode(byte[] msg) {
        MessageOuterClass.Message message = getMessage(msg);

        ArrayList list = null;
        try {
            list = ParseFromUtil.parse(message);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        assert list != null;
        AbstractHandler handleR  = HandlerUtil.getHandlerInstance(list.get(0) + "Handler");

        handleR.handler((MessageLite)list.get(1));
    }
}
