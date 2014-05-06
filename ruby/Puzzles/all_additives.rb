# http://www.careercup.com/page?pid=facebook-interview-questions&sort=votes

# Given a number N, write a program that returns all possible combinations of numbers that add up to N, as lists. (Exclude the N+0=N)

$stash = { 1 => [[1]], 2 => [[1, 1]] }

def fetch_additives input
  (3..input).each do |n|
    $stash[n] = []
    (1..(n / 2 )).each do |i|
      $stash[n] << [i, n - i]
    end
    $stash[n - 1].each do |i|
      $stash[n] << (Array.new(i) << 1)
    end
  end
  $stash[input]
end

fetch_additives(5).each do |s|
  puts s.to_s
end
