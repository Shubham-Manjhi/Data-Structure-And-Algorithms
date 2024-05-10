package Stack;

import java.util.Stack;

    public class AbsoluteFilePath {
        public static void main(String[] args) {
            System.out.println(simplifyPath("/home/")); // Output: "/home"
            System.out.println(simplifyPath("/../")); // Output: "/"
            System.out.println(simplifyPath("/home//foo/")); // Output: "/home/foo"
        }

        public static String simplifyPath(String path) {
            Stack<String> stack = new Stack<>();
            String[] components = path.split("/");

            // Process each path component
            for (String directory : components) {
                // A no-op for a "." or an empty string
                if (directory.equals(".") || directory.isEmpty()) {
                    continue;
                } else if (directory.equals("..")) {
                    // Pop a directory from the stack for a ".."
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    // A legitimate directory name, so we add it to our stack
                    stack.push(directory);
                }
            }

            // Stich together all the directory names together
            StringBuilder result = new StringBuilder();
            for (String dir : stack) {
                result.append("/");
                result.append(dir);
            }

            return !result.isEmpty() ? result.toString() : "/";
        }
    }
