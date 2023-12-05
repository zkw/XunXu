#include <bits/stdc++.h>
using namespace std;

struct Epoch {
    int D, H, M;
};

Epoch Read() {
    Epoch e;
    scanf("%d%d%d", &e.D, &e.H, &e.M);
    return e;
}

int Since0(const Epoch &e) { return (e.D * 24 + e.H) * 60 + e.M; }

int Since11(const Epoch &e) {
    int duration = Since0(e) - Since0(Epoch{11, 11, 11});
    if (duration < 0) return -1;
    return duration;
}

int main() {
    printf("%d\n", Since11(Read()));
    return 0;
}
