class Router {
    private final int sz;
    private final Map<Integer, List<Integer>> freqCnts;
    private final Map<Long, int[]> networkPackets;
    private final Queue<Long> que;

    public Router(final int memoryLimit) {
        this.sz = memoryLimit;
        this.networkPackets = new HashMap<>();
        this.freqCnts = new HashMap<>();
        this.que = new LinkedList<>();
    }

    public boolean addPacket(final int source, final int destination, final int timestamp) {
        final long key = encode(source, destination, timestamp);

        if(networkPackets.containsKey(key))
            return false;

        if(networkPackets.size() >= sz)
            forwardPacket();

        networkPackets.put(key, new int[] { source, destination, timestamp });

        que.add(key);

        freqCnts.putIfAbsent(destination, new ArrayList<>());
        //otherwise get 
        freqCnts.get(destination).add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if(networkPackets.isEmpty())
            return new int[] {};


        final long key = que.poll();
        final int[] packet = networkPackets.remove(key);

        if(packet == null){

            return new int[]{};
        }

        final int destination = packet[1];
        final List<Integer> list = freqCnts.get(destination);

        list.remove(0);

        return packet;
    }

    public int getCount(final int destination, final int startTime, final int endTime) {
        final List<Integer> list = freqCnts.get(destination);
        if(list == null || list.isEmpty())
            return 0;

        final int left = lowerBound(list, startTime);
        final int right = upperBound(list, endTime);

        return right - left;
    }

    private long encode(final int source, final int destination, final int timestamp) {
        return ((long)source << 40) | ((long)destination << 20) | timestamp;
    }

    private int lowerBound(final List<Integer> list, final int target) {
        int low = 0, high = list.size();

        while(low < high) {
            final int mid = (low + high) >>> 1;
            if(list.get(mid) < target) low = mid + 1;
            else high = mid;
        }

        return low;
    }

    private int upperBound(final List<Integer> list, final int target) {
        int low = 0, high = list.size();

        while(low < high) {
            final int mid = (low + high) >>> 1;

            if(list.get(mid) <= target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */