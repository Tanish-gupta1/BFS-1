public class Problem1 {
    //t.c -> O(n)
    //s.c -> O(n)
    //approach do a bfs and at each level add the value into an array list and when new level comes create a new list
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>>  result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> ans = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                ans.add(curr.val);
                if(curr.left !=null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            result.add(ans);
        }
        return result;
    }
}
