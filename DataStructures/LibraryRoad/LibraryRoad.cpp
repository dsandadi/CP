#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>

using namespace std;
int findRoot(int* connectedMap,int n,int city)
{
    int root = connectedMap[city];
    if (root != -1) {
        while (root != connectedMap[root]) {
            root = connectedMap[root];
            return root;
        }
    }
       else return city;
}

void compressPath(int* connectedMap,int n,int city ) {

        connectedMap[city] = findRoot(connectedMap,n,city);
    }
int main(){
    int q;
    cin >> q;
    for(int a0 = 0; a0 < q; a0++) {
        int n;
        int m;
        int clib;
        int croad;
        int roadCost = 0, libCost = 0;
        cin >> n >> m >> clib >> croad;
        int connectedMap[n];
        set<int> libLocations;
        if (clib < croad) {
            cout << (n * clib);

        } else {
            for (int a1 = 0; a1 < m; a1++) {
                int city_1;
                int city_2;
                cin >> city_1 >> city_2;
                city_1 -= 1;
                city_2 -= 1;
                int root = connectedMap[city_1];
                if (root != -1 && connectedMap[city_1] == connectedMap[city_2])
                    continue;


                if ((connectedMap[city_1] == -1) && (connectedMap[city_2] == -1)) {
                    connectedMap[city_1] = city_1;
                    connectedMap[city_2] = city_1;
                    //libLocations.insert(city_1);
                    roadCost += croad;
                } else if (connectedMap[city_1] == -1) {
                    connectedMap[city_1] = connectedMap[findroot(connectedMap,n,city_2)];
                    roadCost += croad;
                } else {
                    connectedMap[findRoot(connectedMap,n,city_2)] = findRoot(connectedMap,n,city_1);
                    roadCost += croad;
                }

            }
            for (int i = 0; i < n; i++) {
                compressPath(connectedMap, n, i);
                libLocations.insert(connectedMap[i]);
            }
            libCost = clib * libLocations.size();
            cout << (libCost + roadCost) << endl;
        }
        }

    
    return 0;
}

