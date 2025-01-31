// 105. Construct Binary Tree from Preorder and Inorder Traversal - M

    public int searchArr(int[] arr, int low, int high, int target) {
        for (int i = low; i <=high; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int plow, int phigh, int[] inorder, int ilow, int ihigh) {
        TreeNode root = new TreeNode(preorder[plow]);
        if (plow == phigh) { 
            return root;
        }
        int locationOfRoot = searchArr(inorder, ilow, ihigh, root.val);
        int delta = locationOfRoot - ilow;

        if (locationOfRoot > ilow) {
            root.left = buildTree(
            preorder, plow + 1, plow + delta, 
            inorder, ilow, locationOfRoot - 1);
        }

        if (locationOfRoot < ihigh) {
            root.right = buildTree(
            preorder, plow + 1 + delta, phigh, 
            inorder, locationOfRoot + 1, ihigh);
        }


        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(
            preorder, 0, preorder.length - 1, 
            inorder, 0, preorder.length - 1);
    }

// improve by storing inordeer locations mapping.put(inorder[i], i);
