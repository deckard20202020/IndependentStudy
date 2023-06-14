package FlexTrade;

import java.util.ArrayList;
import java.util.List;

public class Question2 {
    public static void main(String[] args) {
        int totalPackets = 10;
        List<Long> chunk1 = new ArrayList<>();
        chunk1.add(1L);
        chunk1.add(2L);
        List<Long> chunk2 = new ArrayList<>();
        chunk2.add(9L);
        chunk2.add(10L);
        List<List<Long>> uploadedChunks = new ArrayList<>();
        uploadedChunks.add(chunk1);
        uploadedChunks.add(chunk2);

        int answer = minimumChunksRequired(totalPackets, uploadedChunks);
        System.out.println(answer);
    }

    private static int minimumChunksRequired(int totalPackets, List<List<Long>> uploadedChunks) {
        List<Long> firstPacket = uploadedChunks.get(0);
        long chunkSize = (firstPacket.get(firstPacket.size() - 1) - firstPacket.get(0) + 1) * uploadedChunks.size();

        long numChunksUploaded = (firstPacket.get(firstPacket.size() - 1) - firstPacket.get(0) + 1) * uploadedChunks.size();

        long packetsLeft = totalPackets - numChunksUploaded;

        if (packetsLeft % chunkSize == 0) {
            long answer = packetsLeft / chunkSize;
            return (int) answer;
        }

        long answer = packetsLeft / chunkSize;
        answer = Math.round(answer);
        int a = (int) answer;
        return a + 1;
    }
}
