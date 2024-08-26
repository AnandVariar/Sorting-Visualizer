package com.Anand.Sorting.Visualizer.controller;


import com.Anand.Sorting.Visualizer.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/sort")
public class SortingController {

    @Autowired
    private SortingService sortingService;

    @PostMapping("/bubblesort")
    public List<int[]> bubbleSort(@RequestBody int[] array) {
        return sortingService.bubbleSort(array);
    }

    @PostMapping("/quicksort")
    public List<int[]> quickSort(@RequestBody int[] array) {
        return sortingService.quickSort(array);
    }

    @PostMapping("/mergesort")
    public List<int[]> mergeSort(@RequestBody int[] array) {
        return sortingService.mergeSort(array);
    }

    @PostMapping("/selectionsort")
    public List<int[]> selectionSort(@RequestBody int[] array) {
        return sortingService.selectionSort(array);
    }

    @PostMapping("/insertionsort")
    public List<int[]> insertionSort(@RequestBody int[] array) {
        return sortingService.insertionSort(array);
    }
}
