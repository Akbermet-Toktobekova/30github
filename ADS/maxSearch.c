#include <stdio.h>

// find max given an array and its size

int GetMaxInAnArray(const int* arr, size_t len) {
    if (len == 0) {
        // something unexpected
        perror("error len of an array");
    }
    int tmp = arr[0];
    for (size_t i = 1; i < len; ++i) {
        if (tmp < arr[i]) {
            tmp = arr[i];
        }
    }
    return tmp;
}