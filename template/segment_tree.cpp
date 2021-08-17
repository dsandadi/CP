#include <iostream>
#include <vector>

using namespace std;

class SegmentTree
{
	vector<int> tree;
	int n;

public:
	SegmentTree(vector<int> &arr)
	{
		n = arr.size();
		tree = vector<int>(2 * n);
		// populate leaf node.
		for (int i = 0; i < n; ++i)
		{
			tree[i + n] = arr[i];
		}
	}

	void build_segment_tree(vector<int> &nums)
	{
		int n = nums.size();
		// populate leaf node.
		for (int i = 0; i < n; ++i)
		{
			tree[i + n] = nums[i];
		}
		// build segment tree.
		for (int i = n; i > 0; --i)
		{
			tree[i] = tree[i << 1] + tree[i << 1 + 1];
		}
	}
	void update(int index, int val)
	{
		tree[index + n] = val;
		// update segment tree.
		for (int i = index + n; i > 0; i >>= 1)
		{
			tree[i >> 1] = tree[i] + tree[i ^ 1];
		}
		return;
	}
	// query the sum of range [left, right)
	int query(int left, int right)
	{
		int l = left + n, r = right + n;
		// query segment tree.
		int sum = 0;
		while (l < r)
		{
			if (l & 1)
			{
				sum += tree[l++];
			}
			if (r & 1)
			{
				sum += tree[--r];
			}
			l >>= 1;
			r >>= 1;
		}
		return sum;
	}
};

int main()
{
	vector<int> arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	SegmentTree st(arr);
	st.build_segment_tree(arr);

	// print the sum in range(1,2) index-based
	cout << st.query(1, 3) << endl;

	// modify element at 2nd index
	st.update(2, 1);

	// print the sum in range(1,2) index-based
	cout << st.query(1, 3) << endl;

	return 0;
}