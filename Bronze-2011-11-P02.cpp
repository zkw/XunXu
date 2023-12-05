#include <bits/stdc++.h>
using namespace std;

char Buffer[80];

string ReadString() {
    scanf("%s", Buffer);
    return Buffer;
}

int ToInt(const string& s, int base) {
    return strtol(s.c_str(), nullptr, base);
}

string ToString(int x, int base) {
    if (x == 0) return "0";
    string answer;
    while (x > 0) {
        answer += '0' + x % base;
        x /= base;
    }
    reverse(answer.begin(), answer.end());
    return answer;
}

int HammingDistance(const string& s0, const string& s1) {
    if (s0.size() != s1.size()) return -1;
    int difference = 0;
    for (int i = 0; i < s0.size(); ++i) {
        if (s0[i] != s1[i]) ++difference;
    }
    return difference;
}

void Toggle(string& s, int index) { s[index] ^= 1; }

bool TestOK(const string& s2, const string& s3, int& answer) {
    int number = ToInt(s2, 2);
    string s3Good = ToString(number, 3);
    if (HammingDistance(s3, s3Good) != 1) return false;
    answer = number;
    return true;
}

void Print(int answer) { printf("%d\n", answer); }

int main() {
    string s2 = ReadString();
    string s3 = ReadString();
    int answer = -1;
    for (int i = 0; i < s2.size(); ++i) {
        Toggle(s2, i);
        if (TestOK(s2, s3, answer)) break;
        Toggle(s2, i);
    }
    Print(answer);
    return 0;
}
