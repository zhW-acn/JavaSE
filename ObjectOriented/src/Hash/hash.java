package Hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class hash {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");//MD5  SHA-512 SHA-256
        byte[] digest = md5.digest("2".getBytes());
        System.out.println(Arrays.toString(digest));
    }
}
