package org.iduck.kea;

import java.util.ArrayList;
import java.util.List;

public class KEADecoder {

    public List<Integer> decode(KEANode root) {
        return decodeRecursive(root);
    }

    private List<Integer> decodeRecursive(KEANode node) {
        if (node.isLeaf()) {
            List<Integer> bits = new ArrayList<>();
            int size = Math.abs(node.value);
            int start = node.value < 0 ? 0 : 1;
            for (int i = 0; i < size; i++) {
                bits.add((i % 2 == 0) ? start : 1 - start);
            }
            return bits;
        } else {
            List<Integer> leftBits = decodeRecursive(node.left);
            List<Integer> rightBits = decodeRecursive(node.right);
            List<Integer> result = new ArrayList<>();

            int i = 0;
            int j = 0;

            while (i < leftBits.size() && j < rightBits.size()) {
                int current = leftBits.get(i);
                result.add(current);
                int r = rightBits.get(j);

                if (r == 1) {
                    i += 2;
                    j += 1;
                } else {
                    i += 1;
                    j += 1;
                }
            }

            while (i < leftBits.size()) {
                result.add(leftBits.get(i++));
            }

            return result;
        }
    }
}
