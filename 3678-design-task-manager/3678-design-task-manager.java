class TaskManager {
    private PriorityQueue<int[]> pq;
    private Map<Integer,Integer> taskPr;
    private Map<Integer,Integer> taskOwner;

    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a,b) -> {
            if (b[0] != a[0]) return b[0] - a[0];
            return b[1] - a[1];
        });

        taskPr = new HashMap<>();
        taskOwner = new HashMap<>();
        for (List<Integer> t : tasks) add(t.get(0), t.get(1), t.get(2));
    }

    public void add(int userId, int taskId, int priority) {
        pq.add(new int[]{priority, taskId});
        //add them into the Queue based on their priorites
        taskPr.put(taskId, priority);
        taskOwner.put(taskId, userId);
    }

    public void edit(int taskId, int newPriority) {
        pq.add(new int[]{newPriority, taskId});
        taskPr.put(taskId, newPriority);
    }

    public void rmv(int taskId) {

        taskPr.put(taskId, -1);
    }

    public int execTop() {
        // execute this till priority queue is not empty
        while (!pq.isEmpty()) {

            int[] t = pq.poll();
            int p = t[0], id = t[1];
            if (taskPr.getOrDefault(id, -2) == p) {
                taskPr.put(id, -1);

                return taskOwner.getOrDefault(id, -1);
            }
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */