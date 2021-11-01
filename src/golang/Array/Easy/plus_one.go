package main

import "fmt"

func main() {
	fmt.Println(plusOne([]int{9, 9, 9, 9}))
	fmt.Println(plusOne([]int{1, 2, 3, 4}))
	fmt.Println(plusOne([]int{4, 5, 7, 1}))

	// [1 0 0 0 0]
	// [1 2 3 5]
	// [4 5 7 2]
}

func plusOne(digits []int) []int {
	var size int = len(digits)

	for i := size - 1; i >= 0; i-- {
		if digits[i] == 9 {
			digits[i] = 0
		} else {
			digits[i] += 1
			break
		}
	}

	if digits[0] == 0 {
		var newDigits = make([]int, size+1)
		newDigits[0] = 1

		for i := 0; i < len(digits); i++ {
			newDigits[i+1] = digits[i]
		}

		return newDigits
	}

	return digits
}
