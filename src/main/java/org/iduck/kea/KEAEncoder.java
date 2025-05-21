package org.iduck.kea;

import java.util.ArrayList;
import java.util.List;

public class KEAEncoder {

    public KEANode encode(List<Integer> bits) {
        return recursiveEncode(bits);
    }

    private KEANode recursiveEncode(List<Integer> bits) {
        if (bits.size() <= 1) return new KEANode(bits.size());

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        boolean isFinish = true;

        for (int i = 0; i < bits.size() - 1; ) {
            int mainBit = bits.get(i);
            int secondBit = bits.get(i + 1);

            left.add(mainBit);
            right.add(mainBit == secondBit ? 1 : 0);

            if (mainBit != secondBit) i += 1;
            else i += 2;

            if (right.get(right.size() - 1) == 1)
                isFinish = false;
        }

        if (bits.size() % 2 == 1) {
            int lastBit = bits.get(bits.size() - 1);
            left.add(lastBit);
            right.add(0);
        }

        if (isFinish) {
            int size = left.size();
            int result = (left.get(0) == 0) ? -size : size;
            return new KEANode(result);
        } else {
            return new KEANode(
                recursiveEncode(left),
                recursiveEncode(right)
            );
        }
    }
}
