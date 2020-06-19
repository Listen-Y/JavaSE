public class TestMap {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        int[] array = new int[] {5,3,7,1,9,6,1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,19};
        for (int x : array
             ) {
            myHashMap.add(x, 10);
        }
        System.out.println(myHashMap.get(0));
        System.out.println(myHashMap.get(18));
        System.out.println(myHashMap.get(5));
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(11));
        System.out.println(myHashMap.get(7));
        System.out.println(myHashMap.get(6));
        System.out.println(myHashMap.get(16));
        System.out.println(myHashMap.get(13));
        System.out.println(myHashMap.get(4));
        System.out.println(myHashMap.get(15));
        myHashMap.remove(15);
        myHashMap.remove(4);
        myHashMap.remove(13);
        myHashMap.remove(16);
        myHashMap.remove(6);
        myHashMap.remove(7);
        myHashMap.remove(11);
        System.out.println("================");
        System.out.println(myHashMap.get(0));
        System.out.println(myHashMap.get(18));
        System.out.println(myHashMap.get(5));
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(11));
        System.out.println(myHashMap.get(7));
        System.out.println(myHashMap.get(6));
        System.out.println(myHashMap.get(16));
        System.out.println(myHashMap.get(13));
        System.out.println(myHashMap.get(4));
        System.out.println(myHashMap.get(15));


    }
}
