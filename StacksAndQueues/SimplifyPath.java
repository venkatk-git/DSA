package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/.../a/../b/c/../d/./";

        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        Deque<String> s = new ArrayDeque<>();
        
        int i = 0; 
        while(i < path.length()) {
            StringBuilder currPath = new StringBuilder();

            while(i < path.length() && path.charAt(i) != '/') {
                currPath.append(path.charAt(i));
                i++;
            }

            if(!currPath.toString().isEmpty()) {
                String parsedCurrPath = currPath.toString();
                if(parsedCurrPath.equals("..")) {
                    if(!s.isEmpty()) {
                        s.pop();
                    } 
                } else if(parsedCurrPath.equals(".")) {

                } else {
                    s.push(parsedCurrPath);
                }
            }
            
            i++;
        }
        
        StringBuilder canonicalPath = new StringBuilder("/");

        while(!s.isEmpty()) {
            canonicalPath.append(s.removeLast());
            
            if(!s.isEmpty()) {
                canonicalPath.append("/");
            }
        }

        return canonicalPath.toString();
    }
}