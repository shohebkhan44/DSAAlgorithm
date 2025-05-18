public class hashing {
    
    public static void main(String[] args) {
        int[] arr={12,2,1,4,5,2,1};
int[] hash={0,0,0,0,0,0,0,0};
//cpmputing
for(int i=0;i<arr.length;i++){
    hash[arr[i]]+=1;
}
for (int i=0;i<arr.length;i++) {
    System.out.println(i +"->"+ arr[i]);
}

    }
}
