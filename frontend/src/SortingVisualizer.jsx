import React, { useState, useEffect } from 'react';
import './SortingVisualizer.css';

function SortingVisualizer() {
    const [array, setArray] = useState([]);
    const [operations, setOperations] = useState([]);
    const [isSorting, setIsSorting] = useState(false);
    const [timeComplexity, setTimeComplexity] = useState('');

    // Generate a new random array
    const generateArray = () => {
        const newArray = Array.from({ length: 20 }, () => Math.floor(Math.random() * 100));
        setArray(newArray);
        setOperations([]);
        setTimeComplexity(''); // Clear time complexity when generating a new array
    };

    // Bubble Sort
    const bubbleSort = async () => {
        setIsSorting(true);
        setTimeComplexity('Bubble Sort: O(n^2)');
        try {
            const response = await fetch('http://localhost:8080/api/sort/bubblesort', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(array),
            });
            const data = await response.json();
            setOperations(data);
        } catch (error) {
            console.error('Error during Bubble Sort:', error);
        }
        setIsSorting(false);
    };

    // Quick Sort
    const quickSort = async () => {
        setIsSorting(true);
        setTimeComplexity('Quick Sort: O(n log n) on average');
        try {
            const response = await fetch('http://localhost:8080/api/sort/quicksort', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(array),
            });
            const data = await response.json();
            setOperations(data);
        } catch (error) {
            console.error('Error during Quick Sort:', error);
        }
        setIsSorting(false);
    };

     const mergeSort = async () => {
        setIsSorting(true);
        setTimeComplexity('Quick Sort: O(n log n) on average');
        try {
            const response = await fetch('http://localhost:8080/api/sort/mergesort', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(array),
            });
            const data = await response.json();
            setOperations(data);
        } catch (error) {
            console.error('Error during Quick Sort:', error);
        }
        setIsSorting(false);
    };

     const insertionSort = async () => {
        setIsSorting(true);
        setTimeComplexity('Quick Sort: O(n log n) on average');
        try {
            const response = await fetch('http://localhost:8080/api/sort/insertionsort', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(array),
            });
            const data = await response.json();
            setOperations(data);
        } catch (error) {
            console.error('Error during Quick Sort:', error);
        }
        setIsSorting(false);
    };

     const selectionSort = async () => {
        setIsSorting(true);
        setTimeComplexity('Quick Sort: O(n log n) on average');
        try {
            const response = await fetch('http://localhost:8080/api/sort/selectionsort', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(array),
            });
            const data = await response.json();
            setOperations(data);
        } catch (error) {
            console.error('Error during Quick Sort:', error);
        }
        setIsSorting(false);
    };




    // Animate the sorting process
    useEffect(() => {
        if (operations.length > 0) {
            visualizeSorting();
        }
    }, [operations]);

    // Function to visualize sorting
    const visualizeSorting = async () => {
        for (let i = 0; i < operations.length; i++) {
            setArray(operations[i]);
            await new Promise((resolve) => setTimeout(resolve, 100)); // Adjust the speed of the animation here
        }
    };

    return (
        <div className="visualizer">
            <button onClick={generateArray} disabled={isSorting}>Generate Array</button>
            <button onClick={bubbleSort} disabled={isSorting}>Bubble Sort</button>
            <button onClick={quickSort} disabled={isSorting}>Quick Sort</button>

            <button onClick={selectionSort} disabled={isSorting}>Selection Sort</button>
            <button onClick={mergeSort} disabled={isSorting}>Merge Sort</button>
            <button onClick={insertionSort} disabled={isSorting}>Insertion Sort</button>
            <div className="time-complexity">
                {timeComplexity}
            </div>
            <div className="array-container">
                {array.map((value, index) => (
                    <div className="array-bar" key={index} style={{ height: `${value}px` }}></div>
                ))}
            </div>
        </div>
    );
}

export default SortingVisualizer;
