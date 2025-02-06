// 117. Populating Next Right Pointers in Each Node II - M
    public Node connect(Node root) {
        //bfs
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i=0; i < size; i++) {
                Node curr = queue.poll();
                curr.next = prev;
                
                // start right to left
                if (curr.right != null) queue.add(curr.right);
                if (curr.left != null) queue.add(curr.left);
                prev = curr;
            }
        }
        return root;
    }

// better solution w no extra mem
        while(root != null){
            TreeLinkNode tempChild = new TreeLinkNode(0);
            TreeLinkNode currentChild = tempChild;
            while(root!=null){
                if(root.left != null) { currentChild.next = root.left; currentChild = currentChild.next;}
                if(root.right != null) { currentChild.next = root.right; currentChild = currentChild.next;}
                root = root.next;
            }
            root = tempChild.next;
        }
