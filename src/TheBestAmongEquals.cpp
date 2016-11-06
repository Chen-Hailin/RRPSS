#include <bits/stdc++.h>
using namespace std;

const int N = 500000;

int n;
pair<int, int> score[N];

int main() {
    scanf("%d", &n);
    
    int l, r;
    for (int i=0; i<n; i++) {
        scanf("%d %d", &l, &r);
        score[i*2] = make_pair(r, 1);
        score[i*2+1] = make_pair(l, -1);        
    }
    
    sort(score, score + n*2, greater<pair<int, int> >());
    
    for (int i=n*2 - 1; i; i--) {
        if (score[i].second == -1) return 0 * printf("%d\n", n*2 - i + 1);
    }
    
    return 0;
}