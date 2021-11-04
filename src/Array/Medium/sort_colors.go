package main

import "fmt"

func main() {
	fmt.Println(sortColors([]int{2, 0, 2, 1, 1, 0})) // [0 0 1 1 2 2]
	fmt.Println(sortColors([]int{2, 0, 1}))          // [0 1 2]
	fmt.Println(sortColors([]int{0}))                // [0]
	fmt.Println(sortColors([]int{1}))                // [1]

	fmt.Println(sortColorsTwoPass([]int{2, 2, 2, 1, 1, 0})) // [0 1 1 2 2 2]
	fmt.Println(sortColorsTwoPass([]int{2, 2, 1}))          // [1 2 2]
	fmt.Println(sortColorsTwoPass([]int{0}))                // [0]
	fmt.Println(sortColorsTwoPass([]int{1}))                // [1]

}

// One Pass Algorithm, Optimal Choice
func sortColors(nums []int) []int {
	low, mid := 0, 0
	high := len(nums) - 1

	for mid <= high {
		if nums[mid] == 0 {
			exch(nums, mid, low)
			mid++
			low++
		} else if nums[mid] == 1 {
			mid++
		} else if nums[mid] == 2 {
			exch(nums, mid, high)
			high--
		}
	}

	return nums
}

// Two Pass Algorithm, High Time Complexity
func sortColorsTwoPass(nums []int) []int {
	zeros, ones, twos := 0, 0, 0

	for _, num := range nums {
		switch num {
		case 0:
			zeros++
		case 1:
			ones++
		case 2:
			twos++
		default:
			break
		}
	}

	for i := 0; i < zeros; i++ {
		nums[i] = 0
	}

	for j := zeros; j < ones+zeros; j++ {
		nums[j] = 1
	}

	for k := ones + zeros; k < twos+ones+zeros; k++ {
		nums[k] = 2
	}

	return nums
}

func exch(nums []int, i int, j int) {
	nums[i], nums[j] = nums[j], nums[i]
}
