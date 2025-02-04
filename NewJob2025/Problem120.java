// 120. Triangle - M

    public int minimumTotal(List<List<Integer>> triangle) {
        // takes too long
        // return minimumTotal(triangle, 0, 0);

        // no need for stack and extra mem:
        int rows = triangle.size();

        for (int i = 1; i < rows; i++) {
            int j = 0;

            triangle.get(i).set(0, triangle.get(i-1).get(0) + triangle.get(i).get(0));

            for (j = 1; j < i; j++) {
                triangle.get(i).set(j, 
                Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j)) 
                + triangle.get(i).get(j));
            }

            triangle.get(i).set(j, triangle.get(i-1).get(j-1) + triangle.get(i).get(j));
        }

        int min = triangle.get(rows-1).get(0);
        for (int j = 1; j < rows; j++) {
            min = Math.min(min, triangle.get(rows-1).get(j));
        }
        return min;
    }
