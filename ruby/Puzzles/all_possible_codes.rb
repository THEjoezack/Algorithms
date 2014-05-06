# http://www.careercup.com/page?pid=facebook-interview-questions&sort=votes

# If a=1, b=2, c=3,....z=26. Given a string, find all possible codes that string can generate. Give a count as well as print the strings.

$lookup = ('A'..'Z').to_a

class Node
  attr_accessor :children, :value

  def initialize v
    @value = v
    @children = []
  end

  def add s
    node = Node.new($lookup[s.to_i - 1])
    @children << node
    node
  end
end

def get_codes chars, i, node
  return if i >= chars.size
  get_codes chars, i + 1, node.add(chars[i])
  if i < (chars.size - 1)
    combo = "#{chars[i]}#{chars[i+1]}"
    if combo.to_i < $lookup.size
      get_codes chars, i + 2, node.add(combo)
    end
  end
end

# TODO Surely can combine bfs and get_codes!
# TODO Really need Node class?

def bfs node, current = "", results = []
  if node.children.size == 0
    results << current
  end
  node.children.each do |n|
    bfs n, (current + n.value), results
  end
  results
end

root = Node.new("")
get_codes("1123".split(''), 0, root)
results = bfs root

puts results.count
puts results