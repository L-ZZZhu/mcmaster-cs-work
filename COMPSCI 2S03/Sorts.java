public class Sorts {

	public static void main(String[] args) {
		int[] nums = {5, 4, 7, 1, 0, 2, 9, 3, 8, 6};
		System.out.println(array_to_string(nums));
		insertion_sort(nums);
		
	}
	
	public static void insert(int[] nums, int index) {
		for(int i = index; i > 0; i--) {
			if(nums[i] < nums[i-1]) {
				swap_values(nums,i,i-1);
			}
			else {
				return;
			}
		}
	}
	
	public static void insertion_sort(int[] nums) {
		for(int i = 1; i < nums.length; i++) {
			insert(nums, i);
			System.out.println(array_to_string(nums));
		}
	}
	
	public static String array_to_string(int[] a) {
		String s = "{";
		for(int i = 0; i < a.length; i++) {
			if(i == a.length - 1) {
				s = s + a[i];
			}
			else{
				s = s + a[i] + ", ";
			}
		}
		return s + "}";
	}
	
	public static void swap_values(int[] a, int i, int j) {
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	/*
	 * public static void insert(int[] nums, int index) {
		int i = index;
		while(i > 0 && nums[i] < nums[i-1]) {
			swap_values(nums, i, i-1);
			i--;
		}
	}
	
	public static void insertion_sort(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			insert(nums, i);
		}
	}
	 */
	
}
