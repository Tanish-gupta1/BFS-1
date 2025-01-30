public class Problem2 {
    //t.c -> O(v+e)
    //s.c -> O(v+e)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 ){
            return true;
        }

        //this array index will be corresponding to the number of dependency it's
        int[] indegree = new int[numCourses];
        //this will store the key ->  dependent  and value -> list of all the value which are dependent on key
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();//for bfs
        int popCount = 0;// so at last this should be equal to the number of courses because it'll increase with increase in element in queue
        for(int[] prerequisite : prerequisites){
            int to = prerequisite[0];
            int from = prerequisite[1];
            indegree[to]++;
            if(!map.containsKey(from)){
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }

        for(int i = 0;i<numCourses;i++){
            //find all the course which has no dependency and add in the queue
            if(indegree[i] == 0){
                popCount++;
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> dependents = map.get(curr);
            if(dependents == null){
                continue;
            }
            for(int dependent : dependents){
                //now for each dependent reduce the array index so we know it been taken care and check if it became 0 it means all the dependent are gone
                indegree[dependent]--;
                if(indegree[dependent] == 0){
                    popCount++;
                    q.add(dependent);
                }
            }
        }
        return popCount == numCourses;
    }
}
