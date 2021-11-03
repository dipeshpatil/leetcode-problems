package main

import "fmt"

func main() {
	fmt.Println(createTargetArray([]int{0, 1, 2, 3, 4}, []int{0, 1, 2, 2, 1}))
	fmt.Println(createTargetArray([]int{1, 2, 3, 4, 0}, []int{0, 1, 2, 3, 0}))
	fmt.Println(createTargetArray([]int{1}, []int{0}))

	// [0 4 1 3 2]
	// [0 1 2 3 4]
	// [1]
}

func createTargetArray(nums []int, index []int) []int {
	var length int = len(nums)
	var result = make([]int, length)

	for i := 0; i < length; i++ {
		idx := index[i]

		if idx < i {
			for j := i; j > idx; j-- {
				result[j] = result[j-1]
			}
		}

		result[idx] = nums[i]
	}

	return result
}
