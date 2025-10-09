class Solution {
    public long minTime(int[] skill, int[] mana) {
        int noWizards = skill.length, m = mana.length;
        long[] done = new long[noWizards + 1];
        
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < noWizards; i++) {
                done[i + 1] = Math.max(done[i + 1], done[i]) + mana[j] * skill[i];
            }
            for (int i = noWizards - 1; i > 0; i--) {
                done[i] = done[i + 1] - mana[j] * skill[i];
            }
        }
        
        return done[noWizards];
    }
}