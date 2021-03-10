import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberDemo {

    /**
     * Number的使用
     * @param args
     */
    public static void main1(String[] args) {
        Number number = 1111.922;
        int i = number.intValue();
        System.out.println(i);
    }

    public static void main3(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        TreeNode mirror = mirror(root);
        print(mirror);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }

    /**
     * 求镜像二叉树
     * @param root
     * @return
     */
    public static TreeNode mirror (TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = mirror(root.right);
        root.right = mirror(temp);
        return root;
    }


    /**
     * 前序遍历
     * @param root
     */
    public static void print(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }

    private static Object lock = new Object();


    /**
     * 子线程输出10次主线程输出100次， 循环50次
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphoreMain = new Semaphore(0);
        Semaphore semaphoreSon = new Semaphore(0);
        AtomicInteger integer = new AtomicInteger(50);
        Thread thread = new Thread(new Runnable() {

            public void run() {
                while (integer.get() > 0) {
                    System.out.println("...");
                    try {
                        semaphoreSon.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < 10; i++) {
                        System.out.println("子线程输出" + i);
                    }
                    semaphoreMain.release();
                    integer.decrementAndGet();
                }
            }
        });
        thread.start();

       for(int i = 0; i < 50; i++) {
           semaphoreSon.release();
           semaphoreMain.acquire();
                for (int j = 0; j < 100; j++) {
                    System.out.println("主线程输出" + i + " " + j);
                }
            }
        }


    public TreeNode mirror2(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = mirror(root.right);
        root.right = mirror(temp);
        return root;
    }


}
