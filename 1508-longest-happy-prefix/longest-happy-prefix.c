#include <string.h>
#include <stdlib.h>

char* longestPrefix(char* s) {
    int n = strlen(s);
    if (n == 0) return "";

    int *lps = (int *)malloc(sizeof(int) * n);
    lps[0] = 0;

    int len = 0;
    int i = 1;

    
    while (i < n) {
        if (s[i] == s[len]) {
            len++;
            lps[i] = len;
            i++;
        } else {
            if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
    }

    int prefixLen = lps[n - 1];

    
    char *result = (char *)malloc(prefixLen + 1);
    for (int j = 0; j < prefixLen; j++) {
        result[j] = s[j];
    }
    result[prefixLen] = '\0';

    free(lps);
    return result;
}

