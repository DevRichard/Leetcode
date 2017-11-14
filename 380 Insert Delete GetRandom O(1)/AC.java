class RandomizedSet 
{
    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random rdm;
    /** Initialize your data structure here. */
    public RandomizedSet() 
    {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
        rdm = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) 
    {
        if(map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size()-1);
        //System.out.println("Insert   "+val + " " + (list.size()-1));
        return true;
    }
    
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) 
    {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        //System.out.println("Delete   " + val + " "+ index);
        int lastvalue = list.get(list.size() - 1);
        list.set(index, lastvalue);
        map.put(lastvalue, index);
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() 
    {
        return list.get(rdm.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */