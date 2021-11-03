package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(arrayPairSum([]int{1, 4, 3, 2}))
	fmt.Println(arrayPairSum([]int{6, 2, 6, 5, 1, 2}))

	// 4
	// 9
}

func arrayPairSum(nums []int) int {
	sort.Ints(nums)
	var ans int = 0
	for i := 0; i < len(nums); i += 2 {
		ans += nums[i]
	}

	return ans
}
