# http://www.careercup.com/page?pid=facebook-interview-questions&sort=votes

# A k-palindrome is a string which transforms into a palindrome on removing at most k characters. 
# Given a string S, and an interger K, print "YES" if S is a k-palindrome; otherwise print "NO". 

def is_k_palindrome? s, k, i = 0, j = s.size - 1

  return false if k < 0
  return true if i >= j

  # if they match, keep it moving
  if s[i] == s[j]
    return is_k_palindrome? s, k, i + 1, j - 1
  end

  # if they don't match, try removing one...then the other
  is_k_palindrome?(s, k - 1, i + 1, j) || is_k_palindrome?(s, k - 1, i, j - 1)

end

puts is_k_palindrome?("aba", 1) ? "YES" : "NO" # yes
puts is_k_palindrome?("abxa", 1) ? "YES" : "NO" # yes
puts is_k_palindrome?("abdxa", 1) ? "YES" : "NO" # no
puts is_k_palindrome?("rxacecaaar",3) ? "YES" : "NO" # yes