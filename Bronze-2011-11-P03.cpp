#include <bits/stdc++.h>
using namespace std;

vector<int> Read() {
    int size;
    scanf("%d", &size);
    vector<int> data(size);
    for (int& i : data) scanf("%d", &i);
    return data;
}

void Normalize(vector<int>& data) {
    sort(data.begin(), data.end());
    int base = data[0];
    for (int& i : data) i -= base;
}

vector<int> Subvector(const vector<int>& data, int begin, int size) {
    if (data.size() < begin + size) return {};
    return {data.begin() + begin, data.begin() + begin + size};
}

bool Like(vector<int>& a, vector<int>& b) {
    if (a.size() != b.size()) return false;
    Normalize(a);
    Normalize(b);
    return a == b;
}

vector<int> IndicesChord(const vector<int> music, vector<int>& chord) {
    vector<int> answer;
    for (int i = 0; i < music.size(); ++i) {
        auto submusic = Subvector(music, i, chord.size());
        if (Like(chord, submusic)) answer.emplace_back(i + 1);
    }
    return answer;
}

void Write(const vector<int>& data) {
    printf("%d\n", int(data.size()));
    for (int i : data) printf("%d\n", i);
}

int main() {
    auto music = Read();
    auto chord = Read();
    Write(IndicesChord(music, chord));
    return 0;
}
