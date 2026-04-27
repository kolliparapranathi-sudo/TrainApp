import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class SearchTest {

    boolean linearSearch(String[] arr, String key){
        for(String s: arr){
            if(s.equals(key)) return true;
        }
        return false;
    }

    boolean binarySearch(String[] arr, String key){
        Arrays.sort(arr);
        int low=0, high=arr.length-1;

        while(low<=high){
            int mid=(low+high)/2;
            int cmp=arr[mid].compareTo(key);

            if(cmp==0) return true;
            else if(cmp<0) low=mid+1;
            else high=mid-1;
        }
        return false;
    }

    @Test
    void testLinearFound(){
        assertTrue(linearSearch(new String[]{"BG101","BG309"},"BG309"));
    }

    @Test
    void testLinearNotFound(){
        assertFalse(linearSearch(new String[]{"BG101"},"BG999"));
    }

    @Test
    void testBinaryFound(){
        assertTrue(binarySearch(new String[]{"BG101","BG309"},"BG309"));
    }

    @Test
    void testBinaryNotFound(){
        assertFalse(binarySearch(new String[]{"BG101"},"BG999"));
    }
}