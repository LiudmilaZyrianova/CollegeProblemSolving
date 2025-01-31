// 71. Simplify Path - M
    public String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        List<String> storage = new ArrayList<>();
        path = path + "/";
        // remove single period
        while (path.contains("/./")) {
            path = path.replaceAll("\\/\\.\\/", "\\/");
        }
        
        // remove multiple consecutive slashes
        path = path.replaceAll("\\/+", "\\/");

        int i = 1;
        StringBuilder temp;
        String tempString;
        while (i < path.length()) {
            temp = new StringBuilder();
            while ((i < path.length()) && (path.charAt(i) != '/')) {
                temp.append(path.charAt(i));
                i++;
            }

            tempString = temp.toString();
            if (tempString.equals("..")) {
                if (!storage.isEmpty()) {
                    storage.remove(storage.size() - 1);
                }
            } else if (!tempString.isEmpty()) {
                storage.add(tempString);
            }
            i++;
        }

        for (String elem : storage){
            res.append("/");
            res.append(elem);
        }

        return (res.toString().isEmpty()) ? "/" : res.toString();
    }

// MUCH BETTER SOLUTOIN - JUST USE STACK AFFTER SPLITTING BY /
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>(); // create a stack to keep track of directories
        String[] directories = path.split("/"); // split the path by slash '/'
        for (String dir : directories) { // iterate over the directories
            if (dir.equals(".") || dir.isEmpty()) { // ignore the current directory '.' and empty directories
                continue;
            } else if (dir.equals("..")) { // go one level up for double period '..'
                if (!stack.isEmpty()) { // if stack is not empty, pop the top element
                    stack.pop();
                }
            } else { // for any other directory, push it to the stack
                stack.push(dir);
            }
        }
        return "/" + String.join("/", stack); // join the directories in the stack with slash '/' and add a slash at the beginning
    }
