package net.rdd.testMail;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Created by rdd on 2018/11/16.
 */
public class Base64Test {

    public static void main(String[] args) {

        try {
            final BASE64Encoder encoder = new BASE64Encoder();
            final BASE64Decoder decoder = new BASE64Decoder();
            final String text = "{\"buyer_nick\":\"丶劳资94灬神\",\"payment\":\"2.00\",\"status\":\"TRADE_FINISHED\",\"iid\":576601112865,\"oid\":267762403889391751,\"rater\":\"buyer\",\"tid\":267762403889391751,\"type\":\"guarantee_trade\",\"seller_nick\":\"apis2018\"}";
            final byte[] textByte = text.getBytes("UTF-8");
//编码
            final String encodedText = encoder.encode(textByte);
            System.out.println(encodedText);
//解码
            System.out.println(new String(decoder.decodeBuffer(encodedText), "UTF-8"));

//            final BASE64Encoder encoder = new BASE64Encoder();
//            final BASE64Decoder decoder = new BASE64Decoder();
//            final String text = "字串文字";
//            final byte[] textByte = text.getBytes("UTF-8");
////编码
//            final String encodedText = encoder.encode(textByte);
//            System.out.println(encodedText);
//
////解码
//            System.out.println(new String(decoder.decodeBuffer(encodedText), "UTF-8"));

        }catch (Exception e) {}
    }

}
