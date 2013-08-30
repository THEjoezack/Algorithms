class Percolation

  def initialize width, height
    @size = width * height
    @strategy = WeightedQuickUnion.new(@size)
    @sites = Array.new @size, 0
    @empties = (0..size - 1).to_a.shuffle 
  end

  def percolated?
    add
    # TODO have separate strategy for top and bottom rows
    topGroups.each do |t|
      bottomGroups.each do |b|
        return true if @strategy.connected? t,b
      end
    end
    false
  end

  def filled_percent
    return (@size - @empties.size) / @size
  end

  private

  def add
    site = @empties.pop
    @sites[site] = 1

    @strategy.union(site - 1) # TODO if stuff
    @strategy.union(site + 1) # TODO if stuff
    @strategy.union(site - width) # TODO if stuff
    @strategy.union(site + width) # TODO if stuff
  end

end

p = Percolation.new
do 
  puts p.filled_percent.to_s + "%"
while !p.percolated?
