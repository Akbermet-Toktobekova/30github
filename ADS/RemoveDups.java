public class RemoveDups {

    public int removeDups(int[] arr) {
        if (arr == null) {
            return 0;
        }

        if (arr.length == 0) {
            return 0; // Or 1, depending on the desired behavior for an empty array
        }
      
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}
