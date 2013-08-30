class QuickFind

  # O(n)
  def initialize size=10
    @keys = (0..size - 1).to_a
  end

  # O(n)
  def union a,b
    @keys.map! { |x| x == @keys[b] ? @keys[a] : x }
  end

  # O(1)
  def connected? a,b
    @keys[a] == @keys[b]
  end

  # O(n)
  def group_count
    @keys.uniq.count
  end
end

finder = QuickFind.new
finder.union 1,2
finder.union 3,4
finder.union 5,6
finder.union 7,8
finder.union 2,8
finder.union 0,8

puts "Group Count: "
puts finder.group_count.to_s
puts
puts "Transitive?"
puts "8 -> 1: " + finder.connected?(8,1).to_s # Transitive
puts
puts "Symmetric?"
puts "1 -> 8: " + finder.connected?(8,1).to_s # Symmetric
puts
puts "Reflexive?"
puts "9 -> 9: " + finder.connected?(9,9).to_s # Reflexive
puts
puts "Does it always return true?"
puts "1 -> 9: " + finder.connected?(1,9).to_s
puts