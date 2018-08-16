package com.handge.handler.customhandler;

import com.handge.proto.Packet;

public class PacketHandler extends AbstractHandler<Packet> {
    @Override
    public void handle(Packet packet) throws Exception {
        String objectStr = packet.toString();
        String tableName = "t_packet";
        execute(objectStr, tableName);
    }
}