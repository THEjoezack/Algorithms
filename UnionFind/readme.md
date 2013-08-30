# Notes

* QuickFind is great for lookups, slow for unions
* QuickUnion's e worst case scenario is slow O(n)

## Improvements

* Weighted quick-union 
  * Balances tree to prevent worst case scenario
  * Always add to smaller tree
* Path Compression
  * Flatten out the tree as you look up the root
  * Makes the tree almost flat!
  * Theoretically still logarithmic, in practice linear