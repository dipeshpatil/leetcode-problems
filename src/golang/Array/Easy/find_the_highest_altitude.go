package main

import (
	"fmt"
)

func main() {
	fmt.Println(largestAltitude([]int{-5, 1, 5, 0, -7}))
	fmt.Println(largestAltitude([]int{-4, -3, -2, -1, 4, 3, 2}))

	// 1
	// 0
}

func largestAltitude(gain []int) int {
	var points []int = make([]int, len(gain)+1)
	var max int = -int(^uint(0)>>1) - 1

	for i := 0; i < len(gain); i++ {
		points[i+1] = gain[i] + points[i]
		max = maxInt(max, points[i])
	}

	max = maxInt(max, points[len(gain)])

	return max
}

func maxInt(x int, y int) int {
	if x > y {
		return x
	}
	return y
}
