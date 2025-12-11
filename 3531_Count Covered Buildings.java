class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        // mapX: x → sorted set of y-values (column)
        Map<Integer, TreeSet<Integer>> mapX = new HashMap<>();

        // mapY: y → sorted set of x-values (row)
        Map<Integer, TreeSet<Integer>> mapY = new HashMap<>();

        // Build the maps
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            mapX.computeIfAbsent(x, k -> new TreeSet<>()).add(y);
            mapY.computeIfAbsent(y, k -> new TreeSet<>()).add(x);
        }

        int count = 0;

      
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            TreeSet<Integer> col = mapX.get(x); 
            TreeSet<Integer> row = mapY.get(y); 

            boolean hasLeft  = row.lower(x) != null;
            boolean hasRight = row.higher(x) != null;
            boolean hasAbove = col.lower(y) != null;
            boolean hasBelow = col.higher(y) != null;

            if (hasLeft && hasRight && hasAbove && hasBelow) {
                count++;
            }
        }

        return count;
    }
}
