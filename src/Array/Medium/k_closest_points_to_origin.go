package main

import (
	"math"
)

type points struct {
	distanceFromOrigin float64
	points             []int
}

func New(pointsArray []int) points {
	distanceFromOrigin := euclidean(pointsArray, []int{0, 0})
	return points{distanceFromOrigin, pointsArray}
}

func euclidean(points1 []int, points2 []int) float64 {
	return math.Sqrt(
		math.Pow(float64(points2[0]-points1[0]), 2.0) + math.Pow(float64(points2[0]-points1[0]), 2.0),
	)
}

func kClosest(points [][]int, k int) {

}

func main() {
	// p1 := New()
}
