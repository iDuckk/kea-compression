import org.iduck.kea.KEAEncoder;
import org.iduck.kea.KEADecoder;
import org.iduck.kea.KEANode;

import java.util.Arrays;
import java.util.List;

public class KEATest {
    public static void main(String[] args) {
        List<Integer> bits = Arrays.asList(1, 1, 0, 1, 0, 0, 0, 0);

        KEAEncoder encoder = new KEAEncoder();
        KEANode encoded = encoder.encode(bits);

        KEADecoder decoder = new KEADecoder();
        List<Integer> decoded = decoder.decode(encoded);

        System.out.println("Original: " + bits);
        System.out.println("Decoded : " + decoded);
    }
}
